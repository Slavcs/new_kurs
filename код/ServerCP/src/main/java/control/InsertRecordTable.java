package control;

import beatysalon.Record;
import beatysalon.Client;
import servercp.ServerWork;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

public class InsertRecordTable {
    private ServerWork sw;
    private DateBase mdbc;
    private java.sql.Statement stmt;
    private String query;
    private Statement statement;
    private java.sql.PreparedStatement preparedStmt;
    public Map<String, String> stringmap;
    private Record record;
    private Client client;

    public InsertRecordTable(ServerWork sw) {
        try {
            this.sw = sw;
            mdbc = new DateBase();
            Connection conn = mdbc.getConnection();
            stmt = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
        } catch (Exception e) {
            System.out.println("InsertRecordTable = " + e);
        }
    }

     public String quotate(String content) {
        return " '" + content + "' ";
    }
    
    public void AddClientButtonActionPerformed() throws IOException, ClassNotFoundException, SQLException {
       client = new Client();
       query = "INSERT INTO clients VALUES(NULL,?,?,?)";

        preparedStmt = mdbc.getConnection().prepareStatement(query);

            stringmap = sw.receiveStringMap();//считывание данных потока ввода
            client.stringmap(stringmap);
            sw.serverMessage("stringmap recieved! ");

            preparedStmt.setString(1, client.getClientSurname());
            preparedStmt.setObject(2, client.getClientName());
            preparedStmt.setString(3, client.getClientPhoneNumber());
        preparedStmt.execute();
    }
    
    public void AddRecordButtonActionPerformed() throws IOException, ClassNotFoundException, SQLException {
       record = new Record();
       query = "INSERT INTO records VALUES(NULL,?,?,?,?,?)";

        preparedStmt = mdbc.getConnection().prepareStatement(query);

            stringmap = sw.receiveStringMap();//считывание данных потока ввода
            record.stringmap(stringmap);
            sw.serverMessage("stringmap recieved! ");

            preparedStmt.setString(1, record.getClientSurname());
            preparedStmt.setString(2, record.getServiceName());
            preparedStmt.setString(3, record.getEmployeeSurname());
            preparedStmt.setString(4, record.getRecordDate());
            preparedStmt.setString(5, record.getRecordTime());
        preparedStmt.execute();
    }

    public void DeleteClientButtonActionPerformed() throws IOException, ClassNotFoundException {

        sw.stringmap = sw.receiveStringMap();
        String ClientID = sw.stringmap.get("ClientID");

        String insertStr = "";
        try {
            insertStr = "DELETE FROM clients WHERE ClientID=" + ClientID;
            int done = stmt.executeUpdate(insertStr);
        } catch (SQLException e) {
            System.out.println("delete = " + e);
            sw.sendMessage("Error occured in deleting data: " + e);
        }
    }
    public void DeleteRecordButtonActionPerformed() throws IOException, ClassNotFoundException {

        sw.stringmap = sw.receiveStringMap();
        String RecordID = sw.stringmap.get("RecordID");

        String insertStr = "";
        try {
            insertStr = "DELETE FROM records WHERE RecordID=" + RecordID;
            int done = stmt.executeUpdate(insertStr);
        } catch (SQLException e) {
            System.out.println("delete = " + e);
            sw.sendMessage("Error occured in deleting data: " + e);
        }
    }

    public void EditClientButtonActionPerformed() {
        sw.stringmap = sw.receiveStringMap();
            String ClientID = sw.stringmap.get("ClientID");
            String ClientSurname = sw.stringmap.get("ClientSurname");
            String ClientName = sw.stringmap.get("ClientName");
            String ClientPhoneNumber = sw.stringmap.get("ClientPhoneNumber");
        try {
            String insertStr = "UPDATE clients SET ClientSurname ="
                    + quotate(ClientSurname) + "WHERE ClientID =" + ClientID;
            int done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE clients SET ClientName ="
                    + quotate(ClientName) + "WHERE ClientID =" + ClientID;
            done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE clients SET ClientPhoneNumber ="
                    + quotate(ClientPhoneNumber) + "WHERE ClientID =" + ClientID;
            done = stmt.executeUpdate(insertStr);
        } catch (SQLException e) {
            sw.sendMessage("Error occured in editing data:" + e);
        }
    }

    public void EditRecordButtonActionPerformed() {
        sw.stringmap = sw.receiveStringMap();
            String RecordID = sw.stringmap.get("RecordID");
            String ClientSurname = sw.stringmap.get("ClientSurname");
            String ServiceName = sw.stringmap.get("ServiceName");
            String EmployeeSurname = sw.stringmap.get("EmployeeSurname");
            String RecordDate = sw.stringmap.get("RecordDate");
            String RecordTime = sw.stringmap.get("RecordTime");

        try {
            String insertStr = "UPDATE records SET ClientSurname="
                    + quotate(ClientSurname) + "WHERE RecordID =" + RecordID;
            int done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE records SET ServiceName="
                    + quotate(ServiceName) + "WHERE RecordID =" + RecordID;
            done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE records SET EmployeeSurname="
                    + quotate(EmployeeSurname) + "WHERE RecordID =" + RecordID;
            done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE records SET RecordDate="
                    + quotate(RecordDate) + "WHERE RecordID =" + RecordID;
            done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE records SET RecordTime="
                    + quotate(RecordTime) + "WHERE RecordID =" + RecordID;
            done = stmt.executeUpdate(insertStr);
        } catch (SQLException e) {
            sw.sendMessage("Error occured in editing data:" + e);
        }
    }

    public void getResultFromClient() {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT * FROM clients");

            ArrayList<String[]> resultSets = new ArrayList<>();

            while (rs.next()) {
                String[] row = {
                    rs.getString("ClientID"),
                    rs.getString("ClientSurname"),
                    rs.getString("ClientName"),
                    rs.getString("ClientPhoneNumber")
                };
                resultSets.add(row);
            }

            sw.sendResultSet(resultSets);
            rs.close();
        } catch (SQLException e) {
            System.out.println("getResultFromClient = " + e);
        }
    }

    public void getResultFromRecord() {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT * FROM records");

            ArrayList<String[]> resultSets = new ArrayList<>();

            while (rs.next()) {
                String[] row = {
                    rs.getString("RecordID"),
                    rs.getString("ClientSurname"),
                    rs.getString("ServiceName"),
                    rs.getString("EmployeeSurname"),
                    rs.getString("RecordDate"),
                    rs.getString("RecordTime")
                };
                resultSets.add(row);
            }

            sw.sendResultSet(resultSets);
            rs.close();
        } catch (SQLException e) {
            System.out.println("getResultFromRecord = " + e);
        }
    }

    public void getIDsFromClient() {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT ClientSurname FROM clients");

            ArrayList<String[]> resultSets = new ArrayList<>();

            while (rs.next()) {
                String[] row = {
                    rs.getString("ClientSurname")
                };
                resultSets.add(row);
            }

            sw.sendResultSet(resultSets);
            rs.close();
        } catch (SQLException e) {
            System.out.println("getIDsFromClient = " + e);
        }
    }
 
       public void getIDsFromService() {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT ServiceName FROM service");

            ArrayList<String[]> resultSets = new ArrayList<>();

            while (rs.next()) {
                String[] row = {
                    rs.getString("ServiceName")
                };
                resultSets.add(row);
            }

            sw.sendResultSet(resultSets);
            rs.close();
        } catch (SQLException e) {
            System.out.println("getIDsFromService = " + e);
        }
    }
    
    public void getIDsFromEmployee() {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT EmployeeSurname FROM employees");

            ArrayList<String[]> resultSets = new ArrayList<>();

            while (rs.next()) {
                String[] row = {
                    rs.getString("EmployeeSurname")
                };
                resultSets.add(row);
            }

            sw.sendResultSet(resultSets);
            rs.close();
        } catch (SQLException e) {
            System.out.println("getIDsFromEmployee = " + e);
        }
    }
 }
