# Student Management System

A professional console-based Student Management System developed using Java, JDBC, and MySQL. This project is designed to manage student academic records through a simple menu-driven application and demonstrates practical implementation of Core Java, Object-Oriented Programming, SQL, JDBC database connectivity, CRUD operations, input validation, and Git/GitHub.

## Project Overview

The Student Management System allows users to create, view, search, update, and delete student records stored in a MySQL database. The application also calculates student percentages and grades automatically and provides basic academic reports such as the top-performing student, average percentage, and grade-wise student summary.

This project was developed as a practical Java and SQL project to gain hands-on experience in developing database-driven applications.

## Objectives

- Manage student records efficiently.
- Store student information in a MySQL database.
- Connect Java with MySQL using JDBC.
- Implement CRUD operations.
- Search students by ID and name.
- Calculate student percentage automatically.
- Calculate student grades automatically.
- Generate basic academic reports.
- Validate user input.
- Handle database and input-related exceptions.
- Practice Git and GitHub version control.

## Features

### Student Management

- Add new student records.
- Update existing student records.
- Delete student records.
- Search student by ID.
- Search student by name.
- Display all student records.

### Academic Management

- Calculate percentage automatically.
- Calculate grade automatically.
- Display the top-performing student.
- Calculate average percentage.
- Display grade-wise student summary.

### Input Validation

The application validates:

- Student name.
- Email address.
- Phone number.
- Subject marks.
- Menu choices.
- Invalid input values.

Marks are accepted only between 0 and 100.

## Technologies Used

Java
JDBC
MySQL
SQL
Eclipse IDE
Git
GitHub

## Project Architecture

The application follows a simple layered structure.

User
  |
  v
StudentManagement.java
  |
  v
Student.java
  |
  v
StudentDAO.java
  |
  v
DBConnection.java
  |
  v
MySQL Database

## Project Structure

StudentManagementSystem/
|
|-- src/
|   |
|   `-- com/
|       |
|       `-- studentmanagement/
|           |
|           |-- DBConnection.java
|           |-- Student.java
|           |-- StudentDAO.java
|           `-- StudentManagement.java
|
|-- .gitignore
`-- README.md

## Java Classes

### DBConnection.java

This class manages the connection between the Java application and MySQL database using JDBC.

Responsibilities:

- Establish database connection.
- Provide database connection to DAO classes.
- Handle SQL connection exceptions.

### Student.java

This class represents the student model.

Student information includes:

- Student ID
- Name
- Email
- Phone
- Course
- Mark 1
- Mark 2
- Mark 3
- Percentage
- Grade

The class also calculates percentage and grade based on the three subject marks.

### StudentDAO.java

The Data Access Object class handles communication between the Java application and MySQL database.

It performs:

- INSERT operations.
- UPDATE operations.
- DELETE operations.
- SELECT operations.
- Search by student ID.
- Search by student name.
- Top student query.
- Average percentage query.
- Grade summary query.

### StudentManagement.java

This is the main application class.

It provides the console-based menu and handles user interaction.

Responsibilities include:

- Displaying menu options.
- Reading user input.
- Validating user input.
- Calling DAO methods.
- Displaying results.

## Database

Database Name:

student_management

Table Name:

students

## Database Table Structure

Column: student_id
Type: INT
Description: Primary key and auto-increment student ID

Column: name
Type: VARCHAR(100)
Description: Student name

Column: email
Type: VARCHAR(100)
Description: Student email address

Column: phone
Type: VARCHAR(15)
Description: Student phone number

Column: course
Type: VARCHAR(50)
Description: Student course

Column: mark1
Type: INT
Description: First subject mark

Column: mark2
Type: INT
Description: Second subject mark

Column: mark3
Type: INT
Description: Third subject mark

Column: percentage
Type: DECIMAL(5,2)
Description: Calculated percentage

Column: grade
Type: VARCHAR(5)
Description: Calculated grade

## Database Setup

Create the database:

CREATE DATABASE student_management;

Select the database:

USE student_management;

Create the students table:

CREATE TABLE students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(15),
    course VARCHAR(50),
    mark1 INT,
    mark2 INT,
    mark3 INT,
    percentage DECIMAL(5,2),
    grade VARCHAR(5)
);

## Percentage Calculation

The application calculates the percentage using three subject marks.

Percentage = (Mark 1 + Mark 2 + Mark 3) / 3

Example:

Mark 1 = 85
Mark 2 = 90
Mark 3 = 95

Percentage = (85 + 90 + 95) / 3
Percentage = 90.00

## Grade Calculation

The application assigns grades based on the calculated percentage.

90 - 100  = A
80 - 89   = B
70 - 79   = C
60 - 69   = D
Below 60  = F

## Application Menu

1. Add Student
2. Update Student
3. Delete Student
4. Search Student by ID
5. Search Student by Name
6. Display All Students
7. Show Top Student
8. Show Average Percentage
9. Show Grade Summary
10. Exit

## Add Student

The Add Student option allows the user to enter:

- Student name
- Email
- Phone number
- Course
- Three subject marks

After entering the marks, the application calculates the percentage and grade automatically and stores the complete student record in MySQL.

## Update Student

The Update Student option allows users to modify an existing student's information using the student ID.

The application can update:

- Name
- Email
- Phone
- Course
- Subject marks

When marks are updated, the percentage and grade are recalculated.

## Delete Student

The Delete Student option removes a student record from the database using the student ID.

The application checks the selected student record and deletes it from MySQL.

## Search Student by ID

Users can search for a specific student by entering the student ID.

The application displays:

- Student ID
- Name
- Email
- Phone
- Course
- Marks
- Percentage
- Grade

## Search Student by Name

Users can search students using their name.

The application uses SQL pattern matching to retrieve matching student records.

## Display All Students

The Display All Students option retrieves all student records stored in the MySQL database and displays the student information in the console.

## Top Student

The application identifies the student with the highest percentage.

The result is generated using an SQL query that sorts student percentages in descending order.

## Average Percentage

The application calculates the average percentage of all students using the SQL AVG function.

This provides a simple overview of overall student performance.

## Grade Summary

The Grade Summary option groups students according to their grades and displays the number of students in each grade.

Example:

Grade A: 2 students
Grade B: 3 students
Grade C: 4 students
Grade D: 1 student
Grade F: 0 students

The actual results depend on the data stored in the database.

## CRUD Operations

Create:
INSERT - Add a new student.

Read:
SELECT - View and search student records.

Update:
UPDATE - Modify student information.

Delete:
DELETE - Remove a student record.

## JDBC Workflow

The application follows this general JDBC workflow:

Java Application
     |
     v
JDBC Driver
     |
     v
MySQL Connection
     |
     v
SQL Query
     |
     v
MySQL Database
     |
     v
ResultSet / Update Result
     |
     v
Java Application

## SQL Concepts Used

The project uses several SQL concepts:

- CREATE DATABASE
- CREATE TABLE
- INSERT
- SELECT
- UPDATE
- DELETE
- WHERE
- LIKE
- ORDER BY
- GROUP BY
- COUNT
- AVG
- LIMIT
- Aggregate functions

## Java Concepts Used

The project demonstrates:

- Classes and Objects
- Encapsulation
- Constructors
- Methods
- Getters and Setters
- Conditional statements
- Loops
- Exception handling
- Scanner
- JDBC
- PreparedStatement
- ResultSet
- DAO pattern

## Input Validation

The application includes input validation to reduce incorrect user input.

### Marks

Marks must be between 0 and 100.

### Phone Number

The phone number must contain 10 digits.

### Email

The application validates the basic email format.

### Name

The application checks that the student name is not empty.

### Menu

Invalid menu input is handled so that the application does not terminate unexpectedly.

## Requirements

Before running this project, install:

- JDK 24 or compatible Java version
- Eclipse IDE
- MySQL Server
- MySQL Connector/J
- Git

## How to Run

### Step 1: Clone the Repository

git clone https://github.com/YOUR-USERNAME/StudentManagementSystem.git

### Step 2: Open the Project

Open Eclipse IDE and import the project as an existing Java project.

### Step 3: Create the Database

Open MySQL and execute the database and table creation commands provided in this README.

### Step 4: Configure Database Connection

Open:

src/com/studentmanagement/DBConnection.java

Configure your local MySQL connection.

Example configuration:

URL:
jdbc:mysql://localhost:3307/student_management

Username:
root

Password:
YOUR_MYSQL_PASSWORD

### Step 5: Add MySQL Connector/J

Add the MySQL Connector/J JAR file to the Eclipse project's build path.

### Step 6: Run the Application

Run:

StudentManagement.java

The Student Management System menu will appear in the Eclipse console.

## Security

Never upload your real MySQL password to a public GitHub repository.

Use a placeholder such as:

YOUR_MYSQL_PASSWORD

For production applications, database credentials should be stored using secure methods such as environment variables or a secure configuration system.

## Learning Outcomes

Through this project, I gained practical experience in:

- Core Java programming.
- Object-Oriented Programming.
- Java classes and objects.
- JDBC database connectivity.
- MySQL database management.
- SQL CRUD operations.
- PreparedStatement.
- ResultSet.
- Exception handling.
- Input validation.
- DAO-based application structure.
- Git version control.
- GitHub repository management.

## Future Enhancements

The project can be extended with:

- Java Swing GUI.
- JavaFX interface.
- Student login system.
- Admin login.
- Role-based access control.
- Password hashing.
- PDF report generation.
- Excel report generation.
- Advanced search and filtering.
- Student attendance management.
- Subject-wise performance reports.
- Secure environment-based database configuration.
- Unit testing.
- Web-based version.

## Project Highlights

- Java-based console application.
- MySQL database integration.
- JDBC connectivity.
- Complete CRUD functionality.
- Student search functionality.
- Automatic percentage calculation.
- Automatic grade calculation.
- Academic reporting.
- Input validation.
- Exception handling.
- Git/GitHub version control.

## Author

Karru Raghavendra

## License

This project is created for educational and portfolio purposes.
