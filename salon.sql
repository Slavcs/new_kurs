-- CREATE SCHEMA 'salon' DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
CREATE TABLE salons (
	SalonID INT NOT NULL AUTO_INCREMENT primary key,
	SalonName VARCHAR(45) NOT NULL,
	SalonCity VARCHAR(45) NULL,
	SalonLocation VARCHAR(45) NULL,
	SalonWebSite VARCHAR(60) NOT NULL,
    SalonPhoneNumber INT NOT NULL
);


CREATE TABLE clients (
	ClientID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	ClientSurname VARCHAR(45) NOT NULL,
	ClientName VARCHAR(45) NULL,
	ClientPhoneNumber INT NOT NULL
);


CREATE TABLE service (
	ServiceID INT NOT NULL AUTO_INCREMENT primary key,
	ServiceName VARCHAR(45) NOT NULL,
	ServiceCost DOUBLE NOT NULL,
	ServiceType VARCHAR(45) NOT NULL
);


CREATE TABLE employees (
	EmployeeID INT NOT NULL AUTO_INCREMENT primary key,
    SalonID INT NOT NULL,
	EmployeeSurname VARCHAR(45) NOT NULL,
	EmployeeName VARCHAR(45) NULL,
	CONSTRAINT fx_employee_salons  FOREIGN KEY (SalonID)  
	REFERENCES salons(SalonID) 
ON DELETE NO ACTION ON UPDATE NO ACTION
);


CREATE TABLE users (
	UserID INT NOT NULL AUTO_INCREMENT primary key,
	EmployeeID INT NULL,
	UserLogin VARCHAR(45) NOT NULL,
	UserPassword VARCHAR(45) NOT NULL,
	UserRigths ENUM('admin', 'user') NOT NULL DEFAULT 'user',
	CONSTRAINT fx_users_employees FOREIGN KEY (EmployeeID)
	REFERENCES employees (EmployeeID) 
	ON DELETE NO ACTION ON UPDATE NO ACTION
);


CREATE TABLE records (
	RecordID INT NOT NULL AUTO_INCREMENT primary key,
    ClientSurname VARCHAR(45) NOT NULL,
    ServiceName VARCHAR(45) NOT NULL,
    EmployeeSurname VARCHAR(45) NOT NULL,
	RecordDate DATE NOT NULL,
	RecordTime TIME NOT NULL,
	CONSTRAINT fx_records_clients  FOREIGN KEY (ClientSurname)  
	REFERENCES clients(ClientSurname)  
	ON DELETE CASCADE  ON UPDATE NO ACTION,
	CONSTRAINT fx_records_service  FOREIGN KEY (ServiceName)  
	REFERENCES service(ServiceName)  
	ON DELETE CASCADE  ON UPDATE NO ACTION,
	CONSTRAINT fx_records_employees  FOREIGN KEY (EmployeeSurname)  
	REFERENCES employees(EmployeeSurname)  
	ON DELETE NO ACTION  ON UPDATE NO ACTION
);
