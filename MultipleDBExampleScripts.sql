DROP DATABASE IF EXISTS employee_db;
CREATE DATABASE employee_db;
USE employee_db;

DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
	employee_name VARCHAR(10),
    employee_id VARCHAR(10),
    PRIMARY KEY (employee_id)
);


INSERT INTO employee VALUES ('employee1', '001');
INSERT INTO employee VALUES ('employee2', '002');
INSERT INTO employee VALUES ('employee3', '003');


DROP DATABASE IF EXISTS student_db;
CREATE DATABASE student_db;
USE student_db;

DROP TABLE IF EXISTS student;

CREATE TABLE student (
	student_name VARCHAR(10),
    student_id VARCHAR(10),
    PRIMARY KEY (student_id)
);


INSERT INTO student VALUES ('student1', '001');
INSERT INTO student VALUES ('student2', '002');
INSERT INTO student VALUES ('student3', '003');



USE student_db; SELECT * FROM student;  

USE employee_db; SELECT * FROM employee;