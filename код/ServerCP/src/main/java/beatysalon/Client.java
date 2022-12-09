package beatysalon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Client implements Print {
    private int clientID;
    private String clientSurname;
    private String clientName;
    private String clientPhoneNumber;

    public Client(int clientID, String clientSurname, String clientName, String clientPhoneNumber) {
        this.clientID = clientID;
        this.clientSurname = clientSurname;
        this.clientName = clientName;
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public Client() {
        
    }

    public int getClientID() {
        return clientID;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }
    
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    @Override
    public void stringmap(Map<String, String> stringmap) {
      if (!stringmap.get("ClientSurname").isEmpty()) {
            clientSurname = stringmap.get("ClientSurname");
        }
        if (!stringmap.get("ClientName").isEmpty()) {
            clientName = stringmap.get("ClientName");
        }
        if (!stringmap.get("ClientPhoneNumber").isEmpty()) {
            clientPhoneNumber = stringmap.get("ClientPhoneNumber");
        }
    }
    
    public void resultSetToClient(ResultSet resultSet) throws SQLException {
        if (resultSet.last() == true) {
            clientID = resultSet.getInt(1);
            clientSurname = resultSet.getString(2);
            clientName = resultSet.getString(3);
            clientPhoneNumber = resultSet.getString(4);
        }
    }
}
