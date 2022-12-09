package servercp;

import beatysalon.Employee;
import beatysalon.Salon;
import beatysalon.Service;
import beatysalon.Record;
import beatysalon.User;
import control.DateBase;
import control.InsertRecordTable;
import control.InsertSalonTable;
import control.InsertServiceTable;
import control.InsertUserTable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class ServerWork implements Serializable {

    public ObjectInputStream sois;
    public ObjectOutputStream soos;
    public int numOfClient;
    public static int maxClients;
    public static boolean logging;

    private DateBase worker;
    private Statement statement;
    private PreparedStatement preparedStmt;

    private String query;
    private ResultSet resultSet;

    private String clientMessageRecieved;
    public Map<String, String> stringmap;

    private Salon salon;
    private User user;
    private Employee employee;
    private Service service;
    private Record record;

    private String employeeNS;

    ServerWork(ObjectInputStream sois, ObjectOutputStream soos, int numOfClient) {
        this.sois = sois;
        this.soos = soos;
        this.numOfClient = numOfClient;
    }

    public void serverMessage(String msg) {
        if (logging) {
            System.out.println("Worker for client" + numOfClient + ": " + msg);
        }
    }

    public void sendMessage(String msg) {
        try {
            soos.writeObject(msg);

            if (logging) {
                serverMessage("message sended: " + msg);
            }
        } catch (IOException e) {
            System.out.println("sendMessage = " + e);
        }
    }

    public void sendResultSet(ArrayList<String[]> resultSets) {
        try {
            soos.writeObject(resultSets);

            if (logging) {
                serverMessage("resultSets sended ");
            }
        } catch (IOException e) {
            System.out.println("sendMessage = " + e);
        }
    }

    public LinkedHashMap receiveStringMap() {
        LinkedHashMap strmap = new LinkedHashMap();
        try {
            Object temp = sois.readObject();
            System.out.println(temp);
            strmap = (LinkedHashMap) temp;

            if (logging) {
                serverMessage("stringmap received");
            }
        } catch (Exception e) {
            System.out.println("receiveStringMap = " + e);
        }

        return strmap;
    }

    public String receiveMessage() {
        String msg = new String();
        try {
            msg = (String) sois.readObject();

            if (logging) {
                serverMessage("~client~: " + msg);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("receiveMessage = " + e);
            return "_exception";
        }

        return msg;
    }

    public void runServerWork() {
        try {

            worker = new DateBase();
            statement = worker.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );

            do {
                clientMessageRecieved = receiveMessage();

                if (clientMessageRecieved.equals("_can_start")) {
                    if (numOfClient > maxClients) {
                        sendMessage("_too_many_connections");
                        return;
                    } else {
                        sendMessage("_allowed_to_start");
                    }
                }
                query = "SELECT * FROM salons";
                resultSet = statement.executeQuery(query);
                if (resultSet.last() == true) {
                    salon = new Salon();
                    salon.resultSetToSalon(resultSet);
                    serverMessage("Salon has been read");
                } else {
                    salonRegistration();
                    serverMessage("Salon has been updated");
                }

                //проверка, есть ли хоть один администратор
                query = "SELECT * FROM users WHERE UserRigths = 'admin'";
                resultSet = statement.executeQuery(query);
                if (resultSet.last() == false) {
                    userRegistration("admin");
                }

                //вход пользователя
                sendMessage("_authorization");
                stringmap = receiveStringMap();

                //регистрация пользователя
                if (stringmap.get("_registration") != null) {
                    userRegistration("user");
                }

                //поиск пользователя в БД и проверка пароля
                userEntering();

                //чтение из БД всех полей для пользователя
                query = "SELECT * FROM users WHERE UserLogin = '" + user.getUserLogin() + "'";
                resultSet = statement.executeQuery(query);
                if (resultSet.last() == true) {
                    user.resultSetToUser(resultSet);
                }

                //чтение данных о сотруднике, связанном с пользователем
                query = "SELECT * FROM employees WHERE EmployeeID = " + user.getEmployeeID();
                ResultSet employeeSet = statement.executeQuery(query);

                employee = new Employee();
                employee.resultSetToEmployee(employeeSet);
                if (employeeSet.last() == true) {
                    employeeNS = employee.getEmployeeName() + " " + employee.getEmployeeSurname();
                } else {
                    employeeNS = "Неизвестный сотрудник";
                }

                menu();

                do {
                    //получение команды клиента
                    clientMessageRecieved = receiveMessage();


                    if (clientMessageRecieved.equals("salon_button")) {
                        workWithSalon();
                        continue;
                    }

                    if (clientMessageRecieved.equals("service_button")) {
                        workWithService();
                        continue;
                    }

                    if (clientMessageRecieved.equals("record_button")) {
                        workWithRecord();
                        continue;
                    }
                    if (clientMessageRecieved.equals("user_button")) {
                        workWithUser();
                        continue;
                    }

                    if (clientMessageRecieved.equals("work_end")) {
                        sendMessage("_exit");
                        return;
                    } else {
                        break;
                    }

                } while (true);

            } while (true);

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
            serverMessage("init error: " + e);
        } // вывод исключений
        finally {
            try {
                sois.close();
                soos.close();
            } catch (IOException e) {
                
            }
        }
    }

    public void workWithService() throws IOException, ClassNotFoundException, SQLException {
        sendMessage("_close_wnd");
        sendMessage("_insert_service_table");
        InsertServiceTable ict = new InsertServiceTable(this);
        do {
            clientMessageRecieved = receiveMessage();

            if (clientMessageRecieved.equals("_edit_button")) {
                ict.EditButtonActionPerformed();
                sendMessage("_update_components");
                continue;
            }
            if (clientMessageRecieved.equals("_delete_button")) {
                ict.DeleteButtonActionPerformed();
                sendMessage("_update_components");
                continue;
            }
            if (clientMessageRecieved.equals("_send_button")) {
                ict.AddButtonActionPerformed();
                sendMessage("_update_components");
                continue;
            }
            if (clientMessageRecieved.equals("_get_result_from_service")) {
                ict.getResultFromService();
                continue;
            }
            if (clientMessageRecieved.equals("_go_back")) {
                sendMessage("_close_wnd");
                menu();
                break;
            } else {
                break;
            }
        } while (true);
    }
    
    public void workWithUser() throws IOException, ClassNotFoundException, SQLException {
        sendMessage("_close_wnd");
        sendMessage("_insert_user_table");
        InsertUserTable imt = new InsertUserTable(this);
        do {
            clientMessageRecieved = receiveMessage();

            if (clientMessageRecieved.equals("_edit_button")) {
                imt.EditButtonActionPerformed();
                sendMessage("_update_components");
                continue;
            }
            if (clientMessageRecieved.equals("_delete_button")) {
                imt.DeleteButtonActionPerformed();
                sendMessage("_update_components");
                continue;
            }
            if (clientMessageRecieved.equals("_send_button")) {
                imt.AddButtonActionPerformed();
                sendMessage("_update_components");
                continue;
            }
            if (clientMessageRecieved.equals("_get_result_from_salon")) {
                imt.getResultFromSalon();
                continue;
            }
            if (clientMessageRecieved.equals("_get_result_from_employee")) {
                imt.getResultFromEmployee();
                continue;
            }
            if (clientMessageRecieved.equals("_get_ids_from_salon")) {
                imt.getIDsFromSalon();
                continue;
            }
            if (clientMessageRecieved.equals("_go_back")) {
                sendMessage("_close_wnd");
                menu();
                break;
            } else {
                break;
            }
        } while (true);
    }

    public void workWithRecord() throws IOException, ClassNotFoundException, SQLException {
        sendMessage("_close_wnd");
        sendMessage("_insert_record_table");
        InsertRecordTable ipt = new InsertRecordTable(this);
        do {
            clientMessageRecieved = receiveMessage();

            if (clientMessageRecieved.equals("_edit_button")) {
                ipt.EditClientButtonActionPerformed();
                sendMessage("_update_components");
                continue;
            }
            if (clientMessageRecieved.equals("_delete_button")) {
                ipt.DeleteClientButtonActionPerformed();
                sendMessage("_update_components");
                continue;
            }
            if (clientMessageRecieved.equals("_send_button")) {
                ipt.AddClientButtonActionPerformed();
                sendMessage("_update_components");
                continue;
            }
            if (clientMessageRecieved.equals("_send_button_record")) {
                ipt.AddRecordButtonActionPerformed();
                sendMessage("_update_components");
                continue;
            }
            if (clientMessageRecieved.equals("_edit_button_record")) {
                ipt.EditRecordButtonActionPerformed();
                sendMessage("_update_components");
                continue;
            }
            if (clientMessageRecieved.equals("_delete_button_record")) {
                ipt.DeleteRecordButtonActionPerformed();
                sendMessage("_update_components");
                continue;
            }
            if (clientMessageRecieved.equals("_get_result_from_record")) {
                ipt.getResultFromRecord();
                continue;
            }
            if (clientMessageRecieved.equals("_get_result_from_client")) {
                ipt.getResultFromClient();
                continue;
            }
            if (clientMessageRecieved.equals("_get_ids_from_client")) {
                ipt.getIDsFromClient();
                continue;
            }
            if (clientMessageRecieved.equals("_get_ids_from_service")) {
                ipt.getIDsFromService();
                continue;
            }
            if (clientMessageRecieved.equals("_get_ids_from_employee")) {
                ipt.getIDsFromEmployee();
                continue;
            }
            if (clientMessageRecieved.equals("_go_back")) {
                sendMessage("_close_wnd");
                menu();
                break;
            } else {
                break;
            }
        } while (true);
    }

    public void workWithSalon() throws IOException, ClassNotFoundException, SQLException {
        sendMessage("_close_wnd");
        sendMessage("_insert_salon_table");
        InsertSalonTable ict = new InsertSalonTable(this);
        do {
            clientMessageRecieved = receiveMessage();

            if (clientMessageRecieved.equals("_edit_button")) {
                ict.EditButtonActionPerformed();
                sendMessage("_update_components");
                continue;
            }
            if (clientMessageRecieved.equals("_delete_button")) {
                ict.DeleteButtonActionPerformed();
                sendMessage("_update_components");
                continue;
            }
            if (clientMessageRecieved.equals("_send_button")) {
                ict.AddButtonActionPerformed();
                sendMessage("_update_components");
                continue;
            }
            if (clientMessageRecieved.equals("_get_result_from_salon")) {
                ict.getResultFromSalon();
                continue;
            }
            if (clientMessageRecieved.equals("_go_back")) {
                sendMessage("_close_wnd");
                menu();
                break;
            } else {
                break;
            }
        } while (true);
    }

    public void menu() throws IOException, ClassNotFoundException {
        sendMessage("_user_reg");
        if (user.getUserRights().equals("admin")) {
            sendMessage("_adminmenu");
        } else {
            sendMessage("_usermenu");
        }
        sendMessage(employeeNS);
    }

    public void salonRegistration() throws IOException, SQLException, ClassNotFoundException {
        sendMessage("_salon_reg");

        salon = new Salon();

        query = "INSERT INTO salons VALUES(NULL,?,?,?,?,?)";

        preparedStmt = worker.getConnection().prepareStatement(query);

        do {
            stringmap = receiveStringMap();//считывание данных потока ввода
            salon.stringmap(stringmap);
            serverMessage("stringmap recieved! ");

            int flag = 0;
            for (String key : stringmap.values()) {
                if (key.isEmpty()) {
                    sendMessage("_error_wnd");
                    sendMessage((String) ("<html>Необходимо заполнить все поля!</html>"));
                    flag = 0;
                    break;
                }
                flag++;
            }
            if (flag == 0) {
                continue;
            }

            preparedStmt.setString(1, salon.getSalonName());
            preparedStmt.setObject(2, salon.getSalonCity());
            preparedStmt.setString(3, salon.getSalonLocation());
            preparedStmt.setObject(4, salon.getSalonWebSite());
            preparedStmt.setObject(5, salon.getSalonPhoneNumber());
            break;
        } while (true);
        preparedStmt.execute();
    }

    public void userRegistration(String rights) throws IOException, SQLException, ClassNotFoundException {

        sendMessage("_user_reg");

        stringmap = receiveStringMap();//считывание данных потока ввода
        user = new User();
        user.stringmap(stringmap);
        employee = new Employee();
        salon = salon.getSalonID() == 0 ? new Salon() : salon;
        employee.stringmap(stringmap);
        int salonID;
        if(resultSet.next()) {
            salonID = resultSet.getInt(1);
        }else salonID = salon.getSalonID();

        query = "INSERT INTO employees VALUES(NULL,?,?,?)";

        System.out.println("INSERT INTO employees VALUES(NULL,?,?,?)");
        preparedStmt = worker.getConnection().prepareStatement(query);
        preparedStmt.setInt(1, salonID);
        preparedStmt.setString(2, employee.getEmployeeSurname());
        preparedStmt.setString(3, employee.getEmployeeName());
        preparedStmt.execute();

        query = "SELECT * FROM employees";
        resultSet = statement.executeQuery(query);
        resultSet.last();

        int emplID = resultSet.getInt(1);

        query = "INSERT INTO users VALUES(NULL,?,?,?,'" + rights + "')";
        System.out.println("INSERT INTO users VALUES(NULL,?,?,'");
        preparedStmt = worker.getConnection().prepareStatement(query);
        preparedStmt.setString(2, user.getUserLogin());
        preparedStmt.setString(3, user.getUserPassword());
        preparedStmt.setInt(1, emplID);
        preparedStmt.execute();
    }

    public void userEntering() throws SQLException, IOException, ClassNotFoundException {
        user = new User();
        user.stringmap(stringmap);
        do {

            query = "SELECT * FROM users WHERE UserLogin = '" + user.getUserLogin() + "'";
            resultSet = statement.executeQuery(query);

            if (resultSet.last() == false) {
                sendMessage("_error_wnd");
                sendMessage((String) ("<html>Логин введен не верно!<br>"
                        + "Проверьте введённые данные</html>"));

                stringmap = receiveStringMap();
                user = new User();
                user.stringmap(stringmap);
            } else {
                break;
            }
        } while (true);
        do {

            query = "SELECT * FROM users WHERE UserLogin = '" + user.getUserLogin() + "'"
                    + " AND `UserPassword` = '" + user.getUserPassword() + "'";
            resultSet = statement.executeQuery(query);

            if (resultSet.last() == false) {
                sendMessage("_error_wnd");
                sendMessage((String) ("<html>Неверный пароль!<br>"
                        + "Проверьте введённые данные.</html>"));
                stringmap = receiveStringMap();
                user = new User();
                user.stringmap(stringmap);
            } else {
                sendMessage("_close_wnd");
                break;
            }
        } while (true);
    }

 
    public static String encryptUserPassword(String str) {
        return String.valueOf(str.hashCode());
    }

}

