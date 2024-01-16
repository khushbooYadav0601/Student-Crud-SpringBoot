# Student_CRUD_SpringBoot

# MySQL
create database studentDB;
use studentDB;
create table Student (s_id bigint NOT NULL auto_increment,
	s_name varchar(50),
    s_age int,
    s_grade varchar(10),
    s_address varchar(50),
    primary key (s_id));
    
select * from Student;

# Postman (RESTful API)
1. Create New Student(POST):
   Endpoint: "http://localhost:8080/api/student".
2. Get All Students(GET):
   Endpoint: "http://localhost:8080/api/students".
3. Get Student by ID(GET):
   Endpoint: "http://localhost:8080/api/studentById/{s_id}".
4. Get Student by Name(GET):
   Endpoint: "http://localhost:8080/api/student/{s_name}".
5. Update Student by ID(PUT):
   Endpoint: "http://localhost:8080/api/student/{s_id}".
6. Delete Student by ID(DELETE):
   Endpoint: "http://localhost:8080/api/student/{s_id}".
7. Delete All Students(DELETE):
   Endpoint: "http://localhost:8080/api/student".
