package beatysalon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Salon implements Print { 
    private int salonID;

    public void setSalonID(int salonID) {
        this.salonID = salonID;
    }

    public int getSalonID() {
        return salonID;
    }
    private String salonName;
    private String salonCity;
    private String salonLocation;
    private String salonWebSite;
    private String salonPhoneNumber;
    private List<Service> service;
    private List<Record> record;

    public Salon(String salonName, String salonCity, List<Service> service, List<Record> record) {
        this.salonName = salonName;
        this.salonCity = salonCity;
        this.service = service;
        this.record = record;
    }

    public Salon(String salonName, String salonCity, String salonLocation, String salonWebSite, String salonPhoneNumber, List<Service> service, List<Record> record) {
        this.salonName = salonName;
        this.salonCity = salonCity;
        this.salonLocation = salonLocation;
        this.salonWebSite = salonWebSite;
        this.salonPhoneNumber = salonPhoneNumber;
        this.service = new ArrayList<>();
        this.record = new ArrayList<>();
    }
    
    public Salon() {
        this.salonName = null;
        this.salonCity = null;
        this.salonLocation = null;
        this.salonWebSite = null;
        this.salonPhoneNumber = null;
        this.service = new ArrayList<>();
        this.record = new ArrayList<>();
    }
    

    public String getSalonName() {
        return salonName;
    }

    public void setSalonName(String salonName) {
        this.salonName = salonName;
    }

    public String getSalonCity() {
        return salonCity;
    }

    public void setSalonCity(String salonCity) {
        this.salonCity = salonCity;
    }
    
    public String getSalonLocation() {
        return salonLocation;
    }

    public void setSalonLocation(String salonLocation) {
        this.salonLocation = salonLocation;
    }
    
    public String getSalonWebSite() {
        return salonWebSite;
    }

    public String getSalonPhoneNumber() {
        return salonPhoneNumber;
    }  
    
    public void setSalonWebSite(String salonWebSite) {
        this.salonWebSite = salonWebSite;
    }

    public void setSalonPhoneNumber(String salonPhoneNumber) {
        this.salonPhoneNumber = salonPhoneNumber;
    }

    public List<Service> getService() {
        return service;
    }

    public void setRecord(List<Record> record) {
        this.record = record;
    }

    public List<Record> getRecord() {
        return record;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }

    public void printServiceList() {
        for (Service service : service) {
            System.out.println(service);
        }
    }

    public void printRecordList() {
        for (Record record : record) {
            System.out.println(record);
        }
    }

    @Override
    public void stringmap(Map<String, String> stringmap) {
        if (!stringmap.get("SalonName").isEmpty()) {
            salonName = stringmap.get("SalonName");
        }
        if (!stringmap.get("SalonCity").isEmpty()) {
            salonCity = stringmap.get("SalonCity");
        }
        if (!stringmap.get("SalonLocation").isEmpty()) {
            salonLocation = stringmap.get("SalonLocation");
        }
        if (!stringmap.get("SalonWebSite").isEmpty()) {
            salonWebSite = stringmap.get("SalonWebSite");
        }
        if (!stringmap.get("SalonPhoneNumber").isEmpty()) {
            salonPhoneNumber = stringmap.get("SalonPhoneNumber");
        }
    }

    public void resultSetToSalon(ResultSet resultSet) throws SQLException {
        if (resultSet.last() == true) {
            salonID = resultSet.getInt(1);
            salonName = resultSet.getString(2);
            salonCity = resultSet.getString(3);
            salonLocation = resultSet.getString(4);
            salonWebSite = resultSet.getString(5);
            salonPhoneNumber = resultSet.getString(6);
        }
    }
}
