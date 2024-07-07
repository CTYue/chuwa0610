## 1. List all of the Spring data related annotations your learned and explain its usage
- @Entity -> Usage: Marks a class as a JPA entity. Represents a table in a database.
- @Id -> Usage: Specifies the primary key of an entity.
- @GeneratedValue -> Usage: Configures how the primary key should be generated.
- @Table -> Usage: Specifies the table name in the database that the entity maps to.
- @Column -> Usage: Specifies the details of a column in the table. Can set the name, length, nullable, etc.
- @Repository -> Usage: Indicates that the class is a Spring Data Repository, which will handle data access operations.
- @Query -> Usage: Defines a custom JPQL or SQL query directly on a repository method.
- @NamedQuery -> Usage: Defines a named JPQL query on an entity class.
```java
@Entity
@NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
public class User {
    // Fields and methods
}
```
- @Modifying-> Usage: Used with @Query on update, delete, or insert operations to indicate the query will modify data.
```java
@Modifying
@Query("UPDATE User u SET u.name = ?1 WHERE u.email = ?2")
int updateUserNameByEmail(String name, String email);
```

- @Transactional -> Defines the scope of a single database transaction.
- @PersistenceContext -> Injects an EntityManager to handle persistence operations.
- @OneToOne, @OneToMany, @ManyToOne, @ManyToMany -> Usage: Defines relationships between entities.
```java

@OneToOne
private Profile profile;

@OneToMany(mappedBy = "user")
private List<Order> orders;

@ManyToOne
private User user;

@ManyToMany
@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
private Set<Role> roles;
```

- @JoinColumn -> Usage: Specifies the foreign key column for a relationship.
```java
@ManyToOne
@JoinColumn(name = "user_id")
private User user;

```

- @JoinTable -> Usage: Specifies the table for the many-to-many relationship.
```java
@ManyToMany
@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
private Set<Role> roles;

```



## 2.  What is DTO, VO, Payload, PO, model, DAO?
- DTO -> A DTO is an object that is used to encapsulate data and transfer it between layers within an application or between services.
- VO (Value Object)-> A VO is an object that represents a value and is typically immutable. It is used to describe some characteristic of a domain.
- Payload -> Payload refers to the actual data being transmitted or processed, often within the context of HTTP requests and responses
- PO (Persistent Object) ->  A PO is an object that represents data stored in a persistent storage, such as a database.
- Model -> A model represents the data and business logic of an application, often forming the core of the MVC (Model-View-Controller) design pattern.
- DAO (Data Access Object) -> A DAO is an object that provides an abstract interface to the database or any other persistence mechanism.

## 3.  What is @JsonProperty("description_yyds")
- @JsonProperty annotation in Java, typically used with the Jackson library, is used to define property names for JSON serialization and deserialization. It allows you to specify a different name for a property in the JSON representation of an object than the name used in the Java class.



## 4. Explain the purpose of following dependency?
```xml
   <dependency>
     <groupId>com.fasterxml.jackson.core</groupId>
     <artifactId>jackson-databind</artifactId>
     <version>2.13.3</version>
     <scope>compile</scope>
   </dependency>
```
- core functionality for converting Java objects to JSON (serialization) and JSON back to Java objects (deserialization)

## 5.  What is spring-boot-stater?
- A Spring Boot Starter is a convenient way to bundle common dependencies and configurations into a single dependency that can be included in a Spring Boot application.
### 1.  what dependecies in the below starter? do you know any starters?
```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
#### Here is the detailed list of dependencies that spring-boot-starter-web typically includes:

- spring-boot-starter
- spring-boot-starter-json
- spring-boot-starter-tomcat
- spring-web
- spring-webmvc
- spring-boot-starter-validation


#### Some Other starter
- spring-boot-starter-data-jpa:
- For working with Spring Data JPA and Hibernate to access relational databases. 
- spring-boot-starter-security:
- For adding Spring Security to the application.
- spring-boot-starter-test:
- For including testing libraries like JUnit, Mockito, and Spring Test. 
- spring-boot-starter-thymeleaf:
- For using Thymeleaf as the template engine for rendering web pages.


## Explain  @RequestMapping(value = "/users", method = RequestMethod.POST)  ? could you list CRUD by this style?
- @RequestMapping(value = "/users", method = RequestMethod.POST)
- @RequestMapping(value = "/users", method = RequestMethod.GET)
- @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
- @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)


## 7.  What is ResponseEntity? why do we need it?
```java
new ResponseEntity<>(postResponse, HttpStatus.OK);
new ResponseEntity<>(postResponse, HttpStatus.CREATED);
ResponseEntity.ok(postService.getPostById(id));
```

- ResponseEntity is a class in Spring MVC that represents the entire HTTP response, including the status code, headers, and body. It provides a powerful way to control the HTTP response and is typically used in RESTful web services.


## 8.  What is ResultSet in jdbc? and describe the flow how to get data using JDBC
- ResultSet is an interface in Java's JDBC API that represents the result set of a database query. It provides methods to access the data returned by a SELECT query, allowing you to iterate through the results and retrieve individual columns.


```java
public static void main(String[] args) {
    String jdbcUrl = "jdbc:mysql://localhost:3306/mydatabase";
    String username = "username";
    String password = "password";

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        connection = DriverManager.getConnection(jdbcUrl, username, password);
        System.out.println("Connected to the database.");
        
        statement = connection.createStatement();
        
        String sql = "SELECT * FROM users";
        resultSet = statement.executeQuery(sql);

        
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");

            System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
        }

    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close the ResultSet
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Close the Statement
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Close the Connection
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Disconnected from the database.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
```

## 9.  Compare Spring Data JPA vs Hibernate vs JDBC.
### JDBC (Java Database Connectivity):

JDBC is the standard Java API for connecting to relational databases and executing SQL queries.
It provides a low-level, imperative way to interact with the database.
Hibernate:
### Hibernate
Hibernate is an Object-Relational Mapping (ORM) framework that automates the mapping between Java objects and database tables.
It provides a higher-level, declarative approach compared to JDBC, with features such as caching, lazy loading, and transaction management.
Spring Data JPA:
### Spring Data JPA
Spring Data JPA is part of the larger Spring Data family. It builds on top of JPA (Java Persistence API) and provides a repository-based, declarative way to interact with the database.
It simplifies data access layers by reducing the amount of boilerplate code needed for data access.


## 11.  What is the serialization and desrialization?
- Serialization is the process of converting an object into a format that can be easily stored or transmitted. The serialized format can be stored in a file, sent over a network, or persisted in a database. The main goal of serialization is to save the state of an object so that it can be recreated later.


