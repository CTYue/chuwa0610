# HW9

## 1. List all of the Spring data related annotations your learned and explain its usage.

- @Entity: Marks a Java class as an entity, which maps to a table in the database. Each instance of the entity represents a row in the table.

- @Repository: Indicates that the annotated class is a repository or a data access object (DAO). This annotation acts as a marker for any class that fulfills the role of repository.

- @Service: Marks a class as a service class in Spring. This annotation is used to define a service layer bean in the Spring application context.

- @RestController: A specialized version of @Controller used in RESTful web services. It automatically converts the return value of methods to JSON or XML.

- @Autowired: Marks a constructor, field, or method as to be autowired by Spring's dependency injection facilities.

## 2. What is DTO, VO, Payload, PO, model, DAO?

- DTO (Data Transfer Object): It is used to transfer data between layers or modules of an application.

- VO (Value Object): It is an immutable object representing some value and it contains attributes with no behavior.

- Payload: It represents the data transmitted over a network, often in the form of JSON or XML.

- PO (Persistant Object): It is an object that is mapped to a database entity.

- Model: It represnets the application's data and business logic

- DAO (Data Access Object): It provides an abstract interface to some type of database or other persistence mechanism.

## 3. What is @JsonProperty("description_yyds")?

- @JsonProperty("description_yyds") in Java specifies that the field description in a class should be serialized and deserialized using the JSON property name "description_yyds".

## 4. Explain the purpose of following dependency?
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.13.3</version>
    <scope>compile</scope>
</dependency>

- The purpose of jackson-databined dependency is to provide data-binding functionality for JSON processing in Java applications using the Jackson library. 
- Functionality:
    - Serialization: Converts Java objects into JSON representation.
    - Deserialization: Converts JSON back into Java objects.
    - Data Binding: Maps JSON data to and from Java objects based on their structure and properties.
- Therefore, this dependency is essential for applications that need to parse JSON data received from external sources, such as web APIs, and convert it into Java objects or vice versa

## 5. What is spring-boot-stater?

- Spring-boot-starter is a packaged set of dependencies that streamline the setup of specific features in a Spring Boot application.

### 1. What dependecies in the below starter? do you know any starters?
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

- Spring MVC, Jackson, Spring Web, Validation are in the below starter.
- Others: spring-boot-starter-data-jpa, spring-boot-starter-security, spring-boot-starter-test.

## 6. Explain @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?

- The @RequestMapping(value = "/users", method = RequestMethod.POST) maps HTTP POST requests to the users endpoint which means it handles the creation of a new resource (user).

- CRUD Operations: 
    - Create (POST): @RequestMapping(value = "/users", method = RequestMethod.POST)
    - READ (GET): @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    - UPDATE (PUT): @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    - DELETE (DELETE): @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)

## 7. What is ResponseEntity? why do we need it?
```java
new ResponseEntity<>(postResponse, HttpStatus.OK);
new ResponseEntity<>(postResponse, HttpStatus.CREATED);
ResponseEntity.ok(postService.getPostById(id));
```
- ResponseEntity represents the entire HTTP response, including status code, headers and body. 
- It allows setting specific HTTP status codes (OK, CREATED, etc.) and headers in responses.
- It enhances integration with Spring features for consistent API design and error handling and provides control over HTTP responses for different scenarios. 

- We need because it enables precise HTTP response configuration (status codes, headers) in Spring applications.
- Ensures consistent API design and error handling practices.

## 8. What is ResultSet in jdbc? and describe the flow how to get data using JDBC?

- ResultSet in JDBC represents the result of a database query and it provides methods to iterate over the data retrieved from the database.

- Flow to Get data using JDBC: 
    - Connect.
    - Create Statement.
    - Execute Query.
    - Process ResultSet.
    - Close Resources

## 9. Compare Spring Data JPA vs Hibernate vs JDBC.

- JDBC (Java Database Connectivity): 
    - It is low-level API for interacting with databses.
    - It requires manual handling of SQL queries, connections, and result sets.
    - It offers maximum control but involves more boilerplate code.

- Hibernate: 
    - It is Object-relational mapping (ORM) framework that simplifies database interactions.
    - It provides higher-level abstractions over JDBC, mapping Java objects to database tables.
    - Caching, lazy loading, and transaction management.

- Spring Data JPA:
    - It is part of the Spring Data project, provides abstraction over JPA (Java Persistence API).
    - It simplifies database access with repositories and query methods.
    - It integrates seamlessly with Spring ecosystem, reducing boilerplate code.

## 10. Learn how to use ObjectMapper by this example.
```java
FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);
String s = objectMapper.writeValueAsString(foodOutlet);
objectMapper.readTree() // learn how to use it?
```
- Deserialize JSON to Java Object
- Serialize Java Object to JSON String
- Read JSON as Tree Model
- ObjectMapper: Converts JSON data to Java objects (readValue) and vice versa (writeValueAsString).
- JsonNode: Represents a hierarchical structure of JSON data, useful for handling dynamic or unknown JSON structures (readTree).

## 11. What is the serialization and desrialization?
### 1. https://hazelcast.com/glossary/serialization/

- Serialization: It is a porocess of converting an object into a byte stream to store it in memory, a database, or to transmit it over a network.

- Deserialization: It is a Process of reconstructing an object from its serialized byte stream, typically to use it in memory or retrieve it from storage.

## 12. Use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].

```java
public class ArrayAverage {

    public static void main(String[] args) {
        int[] array = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
        // Calculate average using streams
        double average = Arrays.stream(array)
                              .average()
                              .orElse(0);
        System.out.println("Average: " + average);
    }
}
```

## 13. 抄写并理解 https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageable 下的代码

## 14. 抄写并理解 https://github.com/TAIsRich/springboot-redbook/tree/04_comment 下的代码