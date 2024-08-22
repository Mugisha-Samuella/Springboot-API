# Spring MVC REST API Example

This project demonstrates how to create a simple REST API using Java Spring MVC, IntelliJ IDEA, and Postman for testing.

## Table of Contents

- [Getting Started](#getting-started)
- [Setting Up the Project](#setting-up-the-project)
- [Creating the REST Controller](#creating-the-rest-controller)
- [Running the Application](#running-the-application)
- [Testing with Postman](#testing-with-postman)
- [Optional: Connecting to a Database](#optional-connecting-to-a-database)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

To get started with this project, you'll need to have the following tools installed on your machine:

- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (version 11 or later)
- [Postman](https://www.postman.com/)

## Setting Up the Project

1. **Create a New Project in IntelliJ IDEA:**
   - Open IntelliJ IDEA and select `File > New > Project`.
   - Choose `Spring Initializr` and fill in the project metadata (Group, Artifact, etc.).
   - Select dependencies: `Spring Web`, `Spring Boot DevTools`, and `Spring Data JPA` (optional, for database connection).
   - Click `Next` and then `Finish`.

2. **Configure the Project:**
   - Choose your Java version.
   - Ensure that the `Spring Boot` version is compatible with the selected dependencies.

## Creating the REST Controller

1. **Create a Controller Class:**
   - Inside `src/main/java`, create a new package, e.g., `com.example.demo.controller`.
   - Create a Java class named `UserController` inside the package.
   - Add the following code:

   ```java
   package com.example.demo.controller;

   import org.springframework.web.bind.annotation.GetMapping;
   import org.springframework.web.bind.annotation.PathVariable;
   import org.springframework.web.bind.annotation.PostMapping;
   import org.springframework.web.bind.annotation.RequestBody;
   import org.springframework.web.bind.annotation.RequestMapping;
   import org.springframework.web.bind.annotation.RestController;

   @RestController
   @RequestMapping("/users")
   public class UserController {

       @GetMapping("/{id}")
       public String getUserById(@PathVariable("id") Long id) {
           return "User with ID: " + id;
       }

       @PostMapping
       public String createUser(@RequestBody String user) {
           return "User created: " + user;
       }
   }
Running the Application
Run the Application:
Locate the SpringBootApplication class (usually in the root package).
Right-click on the class and select Run.
The application should start up, exposing your REST endpoints at http://localhost:8080.
Testing with Postman
Test the GET Endpoint:

Open Postman and create a new request.
Set the request method to GET and enter the URL http://localhost:8080/users/1.
Click Send. You should receive a response: User with ID: 1.
Test the POST Endpoint:

Change the request method to POST and set the URL to http://localhost:8080/users.
Go to the Body tab, select raw, and set the format to JSON.
Enter a JSON object, e.g., { "name": "John Doe", "email": "john@example.com" }.
Click Send. You should see a response confirming the user was created.
Optional: Connecting to a Database
Add Database Dependencies:

Add the following dependencies to your pom.xml:
xml
Copy code
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
Create an Entity Class:

Create an entity class to represent your database table:
java
Copy code
package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    // Getters and Setters
}
Create a Repository Interface:

Create a repository interface for CRUD operations:
java
Copy code
package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
Update the Controller:

Inject UserRepository into UserController and update the methods:
java
Copy code
@Autowired
private UserRepository userRepository;

@PostMapping
public User createUser(@RequestBody User user) {
    return userRepository.save(user);
}

@GetMapping("/{id}")
public User getUserById(@PathVariable("id") Long id) {
    return userRepository.findById(id).orElse(null);
}
Configure Database Connection:

In src/main/resources/application.properties, configure your database connection:
properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/yourdb
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
Test the Endpoints Again with Postman:

Test the POST and GET endpoints to ensure data is persisted in the database.
Contributing
Contributions are welcome! Please open an issue or submit a pull request with your improvements.

License
This project is licensed under the MIT License.
