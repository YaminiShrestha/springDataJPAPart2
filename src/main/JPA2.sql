create database empdb;
use empdb;
create table employeeTable(
empId int PRIMARY KEY AUTO_INCREMENT,
empFirstName varchar(20),
empLastName varchar(20),
empSalary DECIMAL(10,2),empAge int(20)
);
select * from employeeTable;
