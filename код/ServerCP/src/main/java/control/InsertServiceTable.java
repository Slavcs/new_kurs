package control;

import beatysalon.Salon;
import beatysalon.Service;
import servercp.ServerWork;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class InsertServiceTable {
    private ServerWork sw;
    private DateBase mdbc;
    private java.sql.Statement stmt;
     private Service service;
private String query;
    private Statement statement;
    private java.sql.PreparedStatement preparedStmt;
    public Map<String, String> stringmap;

    public InsertServiceTable(ServerWork sw) {
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
        service = new Service();

        query = "INSERT INTO service VALUES(NULL,?,?,?)";

        preparedStmt = mdbc.getConnection().prepareStatement(query);

            stringmap = sw.receiveStringMap();//считывание данных потока ввода
            service.stringmap(stringmap);
            sw.serverMessage("stringmap recieved! ");

            preparedStmt.setString(1, service.getServiceName());
            preparedStmt.setObject(2, service.getServiceCost());
            preparedStmt.setString(3, service.getServiceType());
        preparedStmt.execute();
    }

    public void DeleteButtonActionPerformed() throws IOException, ClassNotFoundException {

        sw.stringmap = sw.receiveStringMap();
        String ServiceID = sw.stringmap.get("ServiceID");

        String insertStr = "";
        try {
            insertStr = "DELETE FROM service WHERE ServiceID=" + ServiceID;
            int done = stmt.executeUpdate(insertStr);
        } catch (SQLException e) {
            System.out.println("delete = " + e);
            sw.sendMessage("Error occured in deleting data: " + e);
        }
    }

    public void EditButtonActionPerformed() {
        sw.stringmap = sw.receiveStringMap();
            String ServiceID = sw.stringmap.get("ServiceID");
            String ServiceName = sw.stringmap.get("ServiceName");
            String ServiceCost = sw.stringmap.get("ServiceCost");
            String ServiceType = sw.stringmap.get("ServiceType");
        try {
            String insertStr = "UPDATE service SET ServiceName ="
                    + quotate(ServiceName) + "WHERE ServiceID =" + ServiceID;
            int done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE service SET ServiceCost ="
                    + quotate(ServiceCost) + "WHERE ServiceID =" + ServiceID;
            done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE service SET ServiceType ="
                    + quotate(ServiceType) + "WHERE ServiceID =" + ServiceID;
            done = stmt.executeUpdate(insertStr);
        } catch (SQLException e) {
            sw.sendMessage("Error occured in editing data:" + e);
        }
    }

    public void getResultFromService() throws IOException {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT * FROM service");

            ArrayList<String[]> resultSets = new ArrayList<>();

            while (rs.next()) {
                String[] row = {rs.getString("ServiceID"),
                    rs.getString("ServiceName"),
                    rs.getString("ServiceCost"),
                    rs.getString("ServiceType")};
                resultSets.add(row);
            }
            sw.sendResultSet(resultSets);
            rs.close();
        } catch (SQLException e) {
            System.out.println("getResultFromService = " + e);
        }
    }
}
