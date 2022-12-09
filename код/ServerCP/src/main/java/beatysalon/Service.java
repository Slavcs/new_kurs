package beatysalon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class Service implements Print {

    public Service() {
    }
    private int serviceID;
    private String serviceName;
    private String serviceCost;
    private String serviceType;

    public Service(int serviceID, String serviceName, String serviceCost, String serviceType) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.serviceCost = serviceCost;
        this.serviceType = serviceType;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setserviceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }
    
    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

@Override
    public void stringmap(Map<String, String> stringmap) {
        if (!stringmap.get("ServiceName").isEmpty()) {
            serviceName = stringmap.get("ServiceName");
        }
        if (!stringmap.get("ServiceCost").isEmpty()) {
            serviceCost = stringmap.get("ServiceCost");
        }
        if (!stringmap.get("ServiceType").isEmpty()) {
            serviceType = stringmap.get("ServiceType");
        }
    }

    public void resultSetToSalon(ResultSet resultSet) throws SQLException {
        if (resultSet.last() == true) {
            serviceID = resultSet.getInt(1);
            serviceName = resultSet.getString(2);
            serviceCost = resultSet.getString(3);
            serviceType = resultSet.getString(4);
        }
    }
}
