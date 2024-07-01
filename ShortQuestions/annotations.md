# Annotations Guide

This document contains a list of annotations, their usage, and code examples. It will be updated whenever new annotations are learned.

## Table of Contents
- [Entity Annotations](#entity-annotations)
- [Controller Annotations](#controller-annotations)

## Entity Annotations

### @Entity
**Usage:** This annotation specifies that the class is an entity and is mapped to a database table.

**Example:**
```java
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private Long id;
    private String name;

    // Getters and Setters
}
```

@Table
Usage: This annotation specifies the table in the database with which this entity is mapped.

@Id
Usage: This annotation specifies the primary key of an entity.

@GeneratedValue
Usage: This annotation provides the specification of generation strategies for the values of primary keys.

@Column
Usage: This annotation is used to specify the mapped column for a persistent property or field.

@RestController
Usage: This annotation is used to create RESTful web services using Spring MVC.

@RequestMapping
Usage: This annotation is used to map web requests to specific handler classes or handler methods.

@GetMapping
Usage: This annotation is used to handle HTTP GET requests.


2. explain how the below annotaitons specify the table in database?

```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
  
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```

@Column(columnDefinition = "varchar(255) default 'John Snow'"):

Specifies the SQL type and default value of the column.
The column will be of type varchar(255) with a default value of 'John Snow'.

@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false"):

Specifies the name of the column as STUDENT_NAME.
The column will have a maximum length of 50 characters.
The column cannot be null.
The column values do not need to be unique.

3. What is the default column names of the table in database for @column?
Default Column Names
For the field firstName, the default column name will be firstName.
For the field operatingSystem, the default column name will be operatingSystem.

4.  What are the layers in springboot application? what is the role of each layer?
5.  Describe the flow in all of the layers if an API is called by Postman.
Presentation Layer (Controller Layer)
Role: Handles HTTP requests and responses, processes user inputs, and returns the appropriate views or data
Postman sends an HTTP request to the API endpoint.

Service Layer
Role: Contains business logic and interacts with the data layer to process requests.
The controller calls the appropriate service method to handle the request.
The service layer processes business logic and may call one or more repository methods.

Data Access Layer (Repository Layer)
Role: Handles database operations such as CRUD (Create, Read, Update, Delete) operations.
The service method interacts with the repository layer to perform database operations.
The repository layer executes database queries and returns the results to the service layer.

Model Layer
Role: Represents the data and entities used within the application.
Data retrieved or stored in the database is represented by entity classes in the model layer.
The processed data is sent back through the service and controller layers.


6.  What is the application.properties? do you know application.yml?
application.properties:
Role: Configuration file used to define application settings such as database connection details, server port, and other configurations in a key-value pair format.

application.yml:
Role: Alternative configuration file to application.properties that uses YAML format for defining configurations, which can be more readable and support hierarchical data 