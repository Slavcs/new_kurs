package beatysalon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Employee implements Print {

    private int employeeID;
    private String employeeName;
    private String employeeSurname;
    private String salonID;

    public Employee() {
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }
    
       public void setSalonID(String salonID) {
        this.salonID = salonID;
    }

    public String getSalonID() {
        return salonID;
    }
    

    @Override
    public void stringmap(Map<String, String> stringmap) {
        if (stringmap.containsKey("SalonID") && !stringmap.get("SalonID").isEmpty()) {
            salonID = stringmap.get("SalonID");
        }
         if (stringmap.containsKey("EmployeeSurname") && !stringmap.get("EmployeeSurname").isEmpty()) {
            employeeSurname = stringmap.get("EmployeeSurname");
        }
        if (stringmap.containsKey("EmployeeName") && !stringmap.get("EmployeeName").isEmpty()) {
            employeeName = stringmap.get("EmployeeName");
        }
    }

    public void resultSetToEmployee(ResultSet resultSet) throws SQLException {
        if (resultSet.last() == true) {
            employeeID = resultSet.getInt("EmployeeID");
            salonID = resultSet.getString("SalonID");
            employeeSurname = resultSet.getString("EmployeeSurname");
            employeeName = resultSet.getString("EmployeeName");
            
        }
    }
}
