package beatysalon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import static servercp.ServerWork.encryptUserPassword;

public class User implements Print {

    private int userID;
    private String userLogin;
    private String userPassword;
    private String userRights;
    private int employeeID;

    public User() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRights() {
        return userRights;
    }

    public void setUserRights(String userRights) {
        this.userRights = userRights;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public void stringmap(Map<String, String> stringmap) {
        if (!stringmap.get("UserLogin").isEmpty()) {
            userLogin = stringmap.get("UserLogin");
        }
        if (!stringmap.get("UserPassword").isEmpty()) {
            userPassword = encryptUserPassword(stringmap.get("UserPassword"));
        }
    }

    public void resultSetToUser(ResultSet resultSet) throws SQLException {
        userID = resultSet.getInt("UserID");
        userLogin = resultSet.getString("UserLogin");
        userPassword = resultSet.getString("UserPassword");
        userRights = resultSet.getString("UserRigths");
        employeeID = resultSet.getInt("EmployeeID");
    }

}
