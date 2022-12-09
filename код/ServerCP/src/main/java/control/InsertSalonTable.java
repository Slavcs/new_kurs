package control;

import beatysalon.Salon;
import servercp.ServerWork;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class InsertSalonTable {
    private ServerWork sw;
    private DateBase mdbc;
    private java.sql.Statement stmt;
    private Salon salon;
    private String query;
    private Statement statement;
    private java.sql.PreparedStatement preparedStmt;
    public Map<String, String> stringmap;

//    public void set(ASd mdbc){
//        this.mdbc  = mdbc;
//    }

    public InsertSalonTable(ServerWork sw) {
        try {
            this.sw = sw;
            mdbc = new DateBase();
            Connection conn = mdbc.getConnection();
            stmt = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
        } catch (Exception e) {
            System.out.println("InsertSalonTable = " + e);
        }
    }

    public String quotate(String content) {
        return " '" + content + "' ";
    }

    public void AddButtonActionPerformed() throws IOException, ClassNotFoundException, SQLException {
        salon = new Salon();

        query = "INSERT INTO salons VALUES(NULL,?,?,?,?,?)";

        preparedStmt = mdbc.getConnection().prepareStatement(query);

        stringmap = sw.receiveStringMap();//считывание данных потока ввода
        salon.stringmap(stringmap);
        sw.serverMessage("stringmap recieved! ");

        preparedStmt.setString(1, salon.getSalonName());
        preparedStmt.setObject(2, salon.getSalonCity());
        preparedStmt.setString(3, salon.getSalonLocation());
        preparedStmt.setObject(4, salon.getSalonWebSite());
        preparedStmt.setObject(5, salon.getSalonPhoneNumber());
        preparedStmt.execute();
    }

    public void DeleteButtonActionPerformed() throws IOException, ClassNotFoundException {

        sw.stringmap = sw.receiveStringMap();
        String SalonID = sw.stringmap.get("SalonID");

        String insertStr = "";
        try {
            insertStr = "DELETE FROM salons WHERE SalonID=" + SalonID;
            int done = stmt.executeUpdate(insertStr);
        } catch (SQLException e) {
            System.out.println("delete = " + e);
            sw.sendMessage("Error occured in deleting data: " + e);
        }
    }

    public void EditButtonActionPerformed() {
        sw.stringmap = sw.receiveStringMap();
        String SalonID = sw.stringmap.get("SalonID");
        String SalonName = sw.stringmap.get("SalonName");
        String SalonCity = sw.stringmap.get("SalonCity");
        String SalonLocation = sw.stringmap.get("SalonLocation");
        String SalonWebSite = sw.stringmap.get("SalonWebSite");
        String SalonPhoneNumber = sw.stringmap.get("SalonPhoneNumber");
        try {
            String insertStr = "UPDATE salons SET SalonName="
                    + quotate(SalonName) + "WHERE SalonID =" + SalonID;
            int done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE salons SET SalonCity ="
                    + quotate(SalonCity) + "WHERE SalonID =" + SalonID;
            done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE salons SET SalonLocation ="
                    + quotate(SalonLocation) + "WHERE SalonID =" + SalonID;
            done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE salons SET SalonWebSite ="
                    + quotate(SalonWebSite) + "WHERE SalonID =" + SalonID;
            done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE salons SET SalonPhoneNumber ="
                    + quotate(SalonPhoneNumber) + "WHERE SalonID =" + SalonID;
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
            System.out.println("getResultFromSalon = " + e);
        }
    }
}
