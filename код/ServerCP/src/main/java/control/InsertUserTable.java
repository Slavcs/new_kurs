package control;

import beatysalon.Employee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import servercp.ServerWork;


public class InsertUserTable {
    private ServerWork sw;
    private DateBase mdbc;
    private java.sql.Statement stmt;
    private Employee employee;
    private String query;
    private Statement statement;
    private java.sql.PreparedStatement preparedStmt;
    public Map<String, String> stringmap;

    public InsertUserTable(ServerWork sw) {
        try {
            this.sw = sw;
            mdbc = new DateBase();
            Connection conn = mdbc.getConnection();
            stmt = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
        } catch (Exception e) {
            System.out.println("InsertServiceTable = " + e);
        }
    }

    public String quotate(String content) {
        return " '" + content + "' ";
    }

    public void AddButtonActionPerformed() throws IOException, ClassNotFoundException, SQLException {
        employee = new Employee();

        query = "INSERT INTO employees VALUES(NULL,?,?,?)";

        try {
            preparedStmt = mdbc.getConnection().prepareStatement(query);

            stringmap = sw.receiveStringMap();//считывание данных потока ввода
            employee.stringmap(stringmap);
            sw.serverMessage("stringmap recieved! ");

            preparedStmt.setObject(1, employee.getSalonID());
            preparedStmt.setString(2, employee.getEmployeeSurname());
            preparedStmt.setString(3, employee.getEmployeeName());
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void DeleteButtonActionPerformed() throws IOException, ClassNotFoundException {

        sw.stringmap = sw.receiveStringMap();
        String EmployeeID = sw.stringmap.get("EmployeeID");

        String insertStr = "";
        try {
            insertStr = "DELETE FROM employees WHERE EmployeeID=" + EmployeeID;
            int done = stmt.executeUpdate(insertStr);
        } catch (SQLException e) {
            System.out.println("delete = " + e);
            sw.sendMessage("Error occured in deleting data: " + e);
        }
    }

    public void EditButtonActionPerformed() {
        sw.stringmap = sw.receiveStringMap();
        String EmployeeID = sw.stringmap.get("EmployeeID");
        String SalonID = sw.stringmap.get("SalonID");
        String EmployeeSurname = sw.stringmap.get("EmployeeSurname");
        String EmployeeName = sw.stringmap.get("EmployeeName");
        try {
            String insertStr = "UPDATE employees SET SalonID ="
                    + quotate(SalonID) + "WHERE EmployeeID =" + EmployeeID;
            int done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE employeese SET EmployeeSurname ="
                    + quotate(EmployeeSurname) + "WHERE EmployeeID =" + EmployeeID;
            done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE employees SET EmployeeName ="
                    + quotate(EmployeeName) + "WHERE EmployeeID =" + EmployeeID;
            done = stmt.executeUpdate(insertStr);
        } catch (SQLException e) {
            sw.sendMessage("Error occured in editing data:" + e);
        }
    }

    public void getResultFromSalon() throws IOException {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT * FROM salons");

            ArrayList<String[]> resultSets = new ArrayList<>();

            while (rs.next()) {
                String[] row = {rs.getString("SalonID"),
                        rs.getString("SalonName"),
                        rs.getString("SalonCity"),
                        rs.getString("SalonLocation"),
                        rs.getString("SalonWebSite"),
                        rs.getString("SalonPhoneNumber")};
                resultSets.add(row);
            }
            sw.sendResultSet(resultSets);
            rs.close();
        } catch (SQLException e) {
            System.out.println("getResultFromService = " + e);
        }
    }

    public void getResultFromEmployee() throws IOException {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT * FROM employees");

            ArrayList<String[]> resultSets = new ArrayList<>();

            while (rs.next()) {
                String[] row = {rs.getString("EmployeeID"),
                        rs.getString("SalonID"),
                        rs.getString("EmployeeSurname"),
                        rs.getString("EmployeeName")};
                resultSets.add(row);
            }
            sw.sendResultSet(resultSets);
            rs.close();
        } catch (SQLException e) {
            System.out.println("getResultFromService = " + e);
        }
    }

    public void getIDsFromSalon() {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT SalonID FROM salons");

            ArrayList<String[]> resultSets = new ArrayList<>();

            while (rs.next()) {
                String[] row = {
                        rs.getString("SalonID")
                };
                resultSets.add(row);
            }

            sw.sendResultSet(resultSets);
            rs.close();
        } catch (SQLException e) {
            System.out.println("getIDsFromSalon = " + e);
        }
    }
}
