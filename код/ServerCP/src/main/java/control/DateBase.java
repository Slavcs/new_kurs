package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DateBase extends Configs {
    
    private Connection connection;
    
    public Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
        getConfigs();
        String connectionString = "jdbc:mysql://" + dbHost + ":"
          + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return connection;       
     }

}
