# Employee Management System - REST API

This project implements CRUD (Create, Read, Update, Delete) operations for managing employees, using RESTful APIs in Java with Spring Boot. The system allows users to create, view, update, and delete employee records in a database.

## Table of Contents

1. [Features](#features)
2. [Technologies](#technologies)
3. [Prerequisites](#prerequisites)
4. [Setup and Installation](#setup-and-installation)
5. [API Endpoints](#api-endpoints)
6. [Project Structure](#project-structure)
7. [Running the Application](#running-the-application)
8. [License](#license)

## Features

- **Create Employee**: Add a new employee record to the database.
- **Retrieve Employee**: Fetch employee details by ID or list all employees.
- **Update Employee**: Modify employee information.
- **Delete Employee**: Remove employee records.

## Technologies

- Java 11+
- Spring Boot
- Spring Data JPA
- RESTful API
- PostgreSQL/MySQL (any preferred relational database)
- Maven

## Prerequisites

- Java 11 or above
- Maven 3.6+
- PostgreSQL/MySQL database
- IDE like IntelliJ IDEA, Eclipse, or VS Code

## Setup and Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/your-username/employee-management-system.git
   cd employee-management-system
   ```

2. **Configure the database**:
   
   Open `src/main/resources/application.properties` and update the database settings with your own.

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/employee_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build the project**:

   Run the following Maven command to build the project:

   ```bash
   mvn clean install
   ```

4. **Run the application**:

   You can now run the application using:

   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

### 1. Create Employee

- **URL**: `/api/employees`
- **Method**: `POST`
- **Request Body**:
   ```json
   {
     "firstName": "John",
     "lastName": "Doe",
     "email": "john.doe@example.com",
     "position": "Software Engineer"
   }
   ```
- **Response**: HTTP 201 Created

### 2. Retrieve All Employees

- **URL**: `/api/employees`
- **Method**: `GET`
- **Response**: List of employee records

### 3. Retrieve Employee by ID

- **URL**: `/api/employees/{id}`
- **Method**: `GET`
- **Response**: Employee record

### 4. Update Employee

- **URL**: `/api/employees/{id}`
- **Method**: `PUT`
- **Request Body**:
   ```json
   {
     "firstName": "Jane",
     "lastName": "Doe",
     "email": "jane.doe@example.com",
     "position": "Manager"
   }
   ```
- **Response**: HTTP 200 OK

### 5. Delete Employee

- **URL**: `/api/employees/{id}`
- **Method**: `DELETE`
- **Response**: HTTP 204 No Content

## Project Structure

```
src
│
├── main
│   ├── java
│   │   └── com.example.employee
│   │       ├── controller         # REST controllers
│   │       ├── model              # Employee entity
│   │       ├── repository         # Repository interface for database operations
│   │       ├── service            # Service layer for business logic
│   │       └── EmployeeManagementApplication.java  # Main Spring Boot application class
│   └── resources
│       └── application.properties  # Application configuration
│
└── test
    └── java
        └── com.example.employee    # Unit and integration tests
```

## Running the Application

After following the setup steps, you can run the application using:

```bash
mvn spring-boot:run
```

Once the application is running, you can access the API endpoints via a tool like Postman or Curl.
