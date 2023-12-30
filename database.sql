
--student table

CREATE TABLE Students (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    gpa DECIMAL(3, 2),
    department VARCHAR(255),
    department_code int FOREIGN KEY REFERENCES departments(department_code)
);

INSERT INTO students (id, name, gpa, department, department_code)
VALUES
    (1, 'John Doe', 3.75, 'CS', 55),
    (2, 'Mike Johnson', 3.45, 'IT', 77),
    (3, 'David Lee', 3.67, 'SOFTEARE', 33);


	select* from students;


--------------------------------------------
--------------------------------------------

--department table

CREATE TABLE departments (
    department_code INT PRIMARY KEY,
    department VARCHAR(255),
    subjects VARCHAR(255),
    subject_code int FOREIGN KEY REFERENCES subjects(subject_code)
);

INSERT INTO departments (department_code, department, subjects, subject_code)
VALUES
    (55, 'CS', 'Algorithms', 101),
    (33, 'SOFTWARE ','Database Systems', 102),
    (77, 'IT', 'Computer Networks', 103);

	select *from departments

--------------------------------------------
--------------------------------------------


--subject table

	CREATE TABLE subjects (
    subject_code INT PRIMARY KEY,
    subject VARCHAR(255)
	);


	INSERT INTO subjects (subject_code, subject)
VALUES
    (101, 'Algorithms'),
    (102, 'Database Systems'),
    (103, 'Computer Networks');

	select *from subjects;
 
 --------------------------------------------
--------------------------------------------


-- users table

CREATE TABLE users (
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255)
);


INSERT INTO users (username, password)
VALUES
    ('user1', 'password1'),
    ('user2', 'password2'),
    ('user3', 'password3');
