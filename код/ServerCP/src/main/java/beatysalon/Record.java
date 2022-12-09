package beatysalon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Record implements Print {
    private int recordID;
    private String clientSurname;
    private String serviceName;
    private String employeeSurname;
    private String recordDate;
    private String recordTime;

    public Record(int recordID, String clientSurname, String serviceName, String employeeSurname, String recordDate, String recordTime) {
        this.recordID = recordID;
        this.clientSurname = clientSurname;
        this.serviceName = serviceName;
        this.employeeSurname = employeeSurname;
        this.recordDate = recordDate;
        this.recordTime = recordTime;
    }

    public Record() {
        
    }

    public String getClientSurname() {
        return clientSurname;
    }
    
    public void setClientSurname(String ClientSurname) {
        this.clientSurname = ClientSurname;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public void setServiceName(String ServiceName) {
        this.serviceName = ServiceName;
    }

    public void setEmployeeSurname(String EmployeeSurname) {
        this.employeeSurname = EmployeeSurname;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public int getRecordID() {
        return recordID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public String getRecordTime() {
        return recordTime;
    }

    @Override
    public void stringmap(Map<String, String> stringmap) {
      if (!stringmap.get("ClientSurname").isEmpty()) {
            clientSurname = stringmap.get("ClientSurname");
        }
        if (!stringmap.get("ServiceName").isEmpty()) {
            serviceName = stringmap.get("ServiceName");
        }
        if (!stringmap.get("EmployeeSurname").isEmpty()) {
            employeeSurname = stringmap.get("EmployeeSurname");
        }
        if (!stringmap.get("RecordDate").isEmpty()) {
            recordDate = stringmap.get("RecordDate");
        }
        if (!stringmap.get("RecordTime").isEmpty()) {
            recordTime = stringmap.get("RecordTime");
        }
    }
    
    public void resultSetToRecord(ResultSet resultSet) throws SQLException {
        if (resultSet.last() == true) {
            recordID = resultSet.getInt(1);
            clientSurname = resultSet.getString(2);
            serviceName = resultSet.getString(3);
            employeeSurname = resultSet.getString(4);
            recordDate = resultSet.getString(5);
            recordTime = resultSet.getString(6);
        }
    }
}
