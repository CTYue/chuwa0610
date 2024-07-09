## 1.  List all of the Spring data related annotations your learned and explain its usage.
````text
@Entity

Usage: Marks a class as a JPA entity.
Example: @Entity public class User { ... }
@Table

Usage: Specifies the database table name for the entity.
Example: @Table(name = "users")
@Id

Usage: Identifies the primary key field of the entity.
Example: @Id private Long id;
@GeneratedValue

Usage: Specifies the primary key generation strategy.
Example: @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column

Usage: Defines the mapping between entity attributes and database columns.
Example: @Column(name = "username", nullable = false)
@Transient

Usage: Marks an entity attribute that is not mapped to a database column.
Example: @Transient private String tempData;
@ManyToOne

Usage: Defines a many-to-one relationship.
Example: @ManyToOne @JoinColumn(name = "role_id")
@OneToMany

Usage: Defines a one-to-many relationship.
Example: @OneToMany(mappedBy = "user")
@ManyToMany

Usage: Defines a many-to-many relationship.
Example: @ManyToMany @JoinTable(name = "user_roles")
@OneToOne

Usage: Defines a one-to-one relationship.
Example: @OneToOne @JoinColumn(name = "profile_id")
@Repository

Usage: Marks a Spring Data repository class and enables exception translation.
Example: @Repository public interface UserRepository extends JpaRepository<User, Long> { ... }
@Query

Usage: Defines a custom query.
Example: @Query("SELECT u FROM User u WHERE u.email = ?1")
@Modifying

Usage: Marks a query method as an update or delete operation.
Example: @Modifying @Query("UPDATE User u SET u.active = false WHERE u.lastLogin < :date")
@Transactional

Usage: Specifies the transactional properties for a method or class.
Example: @Transactional public void saveUser(User user) { ... }
@EnableJpaRepositories

Usage: Enables JPA repository support.
Example: @EnableJpaRepositories(basePackages = "com.example.repository")
````

## 2.  What is DTO, VO, Payload, PO, model, DAO?
- DTO: 
````text
A DTO is an object that is used to transfer data between different layers, Usually between the controller layer and the service layer.
````
- VO
```text
Represents an immutable object whose value does not change once created and 
is often used to transfer data in the service lay.
```
- Payload
```text
Usually refers to the data part actually carried in network transmission, 
such as the body of an HTTP request or response. 
For example, in a REST API, the JSON data of a POST request is called Payload.
```
- PO
```text
PO usually corresponds to the database table structure, including database fields and related getter and setter method
```
- model
```text
Represents objects and logic in the business domain, the service layer of the application
```

- DAO
```text
Data access objects are used to encapsulate access operations to the database, 
use interfaces and it,s implementation classes to implement specific data access operations.
```
## 3.  What is @JsonProperty("description_yyds")
```text
It is an annotation in the Jackson library that can map fields in Java objects to field names in JSON data. 
It is usually used when the field names in Java objects and JSON data are inconsistent.
```
## 4.  Explain the purpose of following dependency?
```text
<dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.13.3</version>
      <scope>compile</scope>
    </dependency>
<dependency>

This dependency is the jackson-databind module in the Jackson library, 
which is used to serialize and deserialize Java objects to and from JSON data. Specifically, 
it provides the function of converting Java objects to JSON format and converting JSON format data back to Java objects.
   
```
## 5.  What is spring-boot-stater?
```text
Spring Boot Starter is a set of predefined dependencies that can help developers quickly integrate various functional modules, 
such as web applications and database access, to reduce developers' configuration work.
for example, spring-boot-starter-web, spring-boot-starter-data-jpa
```
###  （1)what dependecies in the below starter? do you know any starters?
```text
The web starter contains most of the dependencies needed to build a RESTful application, such as:
Spring MVC
Tomcat
Jackson
Spring Core
Logging、

starters
spring-boot-starter-data-jpa
spring-boot-starter-test
spring-boot-starter-data-mongodb
spring-boot-starter-jdbc：
```
## 6.  Explain  @RequestMapping(value = "/users", method = RequestMethod.POST)  ? could you list CRUD by this style?
- The RequestMapping annotation maps the http request to a specific method. 
- The requested URL path is "/users", and the request is a post request.
````java
// CREATE
@RequestMapping(value = "/users", method = RequestMethod.POST)
public ResponseEntity<User> createUser(@RequestBody User user) {
    // note: @RequestBody is used post and put request,
    // Get the data in the HTTP request body and convert it into the Java object 
    
}

// READ (get all users)
@RequestMapping(value = "/users", method = RequestMethod.GET)
public ResponseEntity<List<User>> getAllUsers() {
    
}

// UPDATE
@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
    
}

// DELETE
@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
public ResponseEntity<User> deleteUser(@PathVariable Long id) {
}
````
## 7.  What is ResponseEntity? why do we need it?
```text
ResponseEntity is a class that represents the entire HTTP response: status code, headers and body. 
It allows us to have more detailed control over the HTTP response.

why use it？
1. Using ResponseEntity throughout the application provides a consistent response format for easy client processing.
2. Return different HTTP status codes for different situations
3. Set HTTP response headers
```

## 8.  What is ResultSet in jdbc? and describe the flow how to get data using JDBC
- ResultSet: It is an interface in JDBC that is used to represent the result set returned from a database query operation.
- get data using JDBC
```text
1.Drive-- Use Class.forName() to load the database driver(mysql-driver or etc)
2.Connection-- use DriverManager.getConnection() build connection with database，and ge Connection object。
3.Statement-- call Statement.executeQuery() to execute SQL query.
4.ResultSet-- Use the ResultSet.next() method to iterate over the result set row by row.
```
## 9.  Compare Spring Data JPA vs Hibernate vs JDBC.
```text
1.JDBC: JDBC (Java Database Connectivity) is a standard API provided by Java for communicating with relational databases. 
we need to manually write SQL query statements and process result sets.

2.Hibernate: Hibernate is an ORM (Object-Relational Mapping) framework that provides object-to-relational database table mapping and object-to-database operations. 
Java classes are mapped to database tables through annotations or XML configuration, 
use object to perform database operations, hiding most of the SQL details.
3.Spring Data JPA: Spring Data JPA is a module of the Spring framework,
 using JPA to simplify data access. Spring Data JPA provides interfaces, to automatically generate basic CRUD operations.
```

## 10.  Learn how to use ObjectMapper by this example.
### 1.  https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/exercise/oa/api/FoodOutletJackson.java
```text
FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);
String s = objectMapper.writeValueAsString(foodOutlet);
objectMapper.readTree() // learn how to use it?
```
## 11.  What is the serialization and deserialization?
- Serialization is the process of converting an object into a byte stream for easy storage in memory, files, and databases; 
- deserialization is the reverse process, restoring the byte stream into an object.
### 1.  https://hazelcast.com/glossary/serialization/
   
## 12.  use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
```java
import java.util.Arrays;

public class AverageOfArray {
    public static void main(String[] args) {
        int[] array = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
        
        double average = Arrays.stream(array)         // 1. create stream: convert collection to stream
                               .average()            // 2. middle operation: average() to caculate 
                               .orElse(0);           // 3. terminate operation: get average value，if the stream is empty,return 0;
        
        // print res;
        System.out.println("Average of the array: " + average);
    }
}

```

## 13.  抄写并理解 https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageable 下的代码
## 14.  抄写并理解 https://github.com/TAIsRich/springboot-redbook/tree/04_comment 下的代码