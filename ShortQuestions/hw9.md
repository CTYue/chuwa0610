# Homework 9

## Yirun Wang

### 1. List all of the Spring data related annotations.

1. @Transactional

   `@Transactional` is a Spring Framework annotation used to manage transaction boundaries. When applied to a class or method, it ensures that operations within the transaction are either all successful or all rolled back in case of an error. This helps maintain data integrity and consistency.

   ```java
   @Transactional
   void pay() {}
   ```

2. @Id

   Marks a field in a model as the primary key.

   ```java
   class Person {
   
       @Id
       Long id;
   
       // ...
       
   }
   ```

3. @NoReposityBean

   Used in Spring Data to indicate that a repository interface should not be instantiated as a Spring bean.

   Typically applied to base repository interfaces that are meant to be extended by other repository interfaces.

   ```java
   @NoRepositoryBean
   interface MyUtilityRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
       Optional<T> findById(ID id);
   }
   
   ```

4. @Param

   Used in Spring Data JPA to specify the name of a parameter in a query.

   Helps bind method parameters to query parameters in repository methods.

   ```java
   @Query("SELECT u FROM User u WHERE u.name = :name")
   User findByName(@Param("name") String name);
   
   ```

5. @Transient

   Used in JPA to indicate that a field should not be persisted in the database.

   Prevents the annotated field from being mapped to a database column.

   ```java
   @Entity
   public class User {
       @Id
       private Long id;
       
       @Transient
       private int age; // This field will not be persisted
   
       // Other fields and methods
   }
   ```

   

6. @CreatedBy, @LastModifiedBy, @CreatedDate, @LastModifiedDate

   With these annotations, we can audit our model classes: Spring automatically populates the annotated fields with the principal who created the object, last modified it, and the date of creation, and last modification.

   ```java
   public class Person {
   
       // ...
   
       @CreatedBy
       User creator;
       
       @LastModifiedBy
       User modifier;
       
       @CreatedDate
       Date createdAt;
       
       @LastModifiedDate
       Date modifiedAt;
   
       // ...
   
   }
   ```

   

7. @Query

   Used in Spring Data JPA to define custom JPQL (Java Persistence Query Language) or SQL queries directly on repository methods.

   Allows for complex queries beyond the capabilities of method name conventions.

   ```java
   @Query("SELECT COUNT(*) FROM Person p")
   long getPersonCount();
   ```

   

8. @Procedure

   Used in Spring Data JPA to call stored procedures. Simplifies the invocation of stored procedures from repository methods.

   First, we need to declare the repository on the entity class using standard JPA annotations:

   ```java
   @NamedStoredProcedureQueries({ 
       @NamedStoredProcedureQuery(
           name = "count_by_name", 
           procedureName = "person.count_by_name", 
           parameters = { 
               @StoredProcedureParameter(
                   mode = ParameterMode.IN, 
                   name = "name", 
                   type = String.class),
               @StoredProcedureParameter(
                   mode = ParameterMode.OUT, 
                   name = "count", 
                   type = Long.class) 
               }
       ) 
   })
   
   class Person {}
   ```

   After this, we can refer to it in the repository with the name we declared in the *name* argument

   ```java
   @Procedure(name = "count_by_name")
   long getCountByName(@Param("name") String name);
   ```

   

9. @Lock

   Used in Spring Data JPA to specify the lock mode type for a query. Ensures data consistency by applying locking mechanisms like `PESSIMISTIC_WRITE` or `OPTIMISTIC`.

   ```java
   @Lock(LockModeType.PESSIMISTIC_WRITE)
   @Query("SELECT u FROM User u WHERE u.id = :id")
   User findByIdForUpdate(@Param("id") Long id);
   
   ```

10. @Modifying

    Used in Spring Data JPA to annotate a query method that performs a modifying operation, such as an update or delete. Ensures that the method is recognized as a modifying query, enabling it to execute updates or deletes.

    ```java
    @Modifying
    @Query("UPDATE Person p SET p.name = :name WHERE p.id = :id")
    void changeName(@Param("id") long id, @Param("name") String name);
    ```

    

11. @EnableJpaRepositories

    Used in Spring Data JPA to enable JPA repositories and scan for repository interfaces. Typically placed on a configuration class to set up JPA repository support.

    ```java
    @Configuration
    @EnableJpaRepositories
    class PersistenceJPAConfig {}
    ```

    

12. @Document

    Used in Spring Data MongoDB to map a Java class to a MongoDB document. Indicates that a class is a MongoDB document and specifies the collection name.

    ```java
    @Document(collection = "users")
    public class User {
        @Id
        private String id;
        
        private String name;
        // Other fields and methods
    }
    
    ```

    

13. @Field

    Used in Spring Data MongoDB to map a Java field to a specific field in a MongoDB document.  Specifies the field name in the MongoDB document if it differs from the Java field name.

    ```java
    @Document(collection = "users")
    public class User {
        @Id
        private String id;
        
        @Field("username")
        private String name;
        // Other fields and methods
    }
    
    ```

    

14. @EnableMongoRepositories

    Used in Spring Data MongoDB to enable MongoDB repositories and scan for repository interfaces. Typically placed on a configuration class to set up MongoDB repository support.

    ```java
    @Configuration
    @EnableMongoRepositories(basePackages = "com.example.repository")
    public class MongoConfig {
        // Additional configuration
    }
    
    ```

    

### 2. What is DTO, VO, Payload, PO, model, DAO?

#### DTO (Data Transfer Object)

- **Purpose**: Used to transfer data between layers in an application. Typically, DTOs are used to encapsulate data and reduce the number of method calls. DTO does **NOT** have any behavior and business logic, except for storage, retrieval, serialization and deserialization of its own data.
- **Usage**: Helps in decoupling layers and improving maintainability.

```java
public class UserDTO {
    private String name;
    private String email;

    // Getters and setters
}

```

#### VO (Value Object)

- **Purpose**: Represents a value, typically immutable and without an identity. Used to encapsulate multiple attributes and ensure they are treated as a single unit.
- **Usage**: Common in domain-driven design for entities that describe certain aspects or calculations.

```java
public class AddressVO {
    private final String street;
    private final String city;
    
    public AddressVO(String street, String city) {
        this.street = street;
        this.city = city;
    }

    // Getters, no setters
}

```

#### Payload

- **Purpose**: Represents the body of a message in a communication protocol. Often used to describe the data sent in HTTP requests and responses.
- **Usage**: Commonly used in REST APIs to describe the data being sent or received.

#### PO (Persistent Object)

- **Purpose**: Represents objects that are stored in a database, often as a direct mapping to database tables. Represents data stored in a database. Annotations like @Entity , @Table , @Id , @Column , etc., are commonly used in PO.
- **Usage**: Used in ORM frameworks to persist data.

```java
@Entity
public class UserPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    // Getters and setters
}

```

#### Model

- **Purpose**: Represents the data and the business logic of an application. Often used to encapsulate data and methods that operate on that data.
- **Usage**: Central to the MVC (Model-View-Controller) design pattern.

#### DAO (Data Access Object)

- **Purpose**: Provides an abstract interface to the database. Encapsulates the logic for accessing data sources. **It provides a standardized interface to perform CRUD operations on entities.**

- **Usage**: Separates data access logic from business logic, making the code more modular and easier to maintain.

  ```java
  public interface UserDAO {
      UserPO findById(Long id);
      void save(UserPO user);
      void delete(UserPO user);
  }
  
  public class UserDAOImpl implements UserDAO {
      @PersistenceContext
      private EntityManager entityManager;
  
      @Override
      public UserPO findById(Long id) {
          return entityManager.find(UserPO.class, id);
      }
  
      @Override
      public void save(UserPO user) {
          entityManager.persist(user);
      }
  
      @Override
      public void delete(UserPO user) {
          entityManager.remove(user);
      }
  }
  
  ```

  ### 3. What is @JsonProperty("description_yyds")

  When applied to a field or a getter/setter method, it specifies the JSON property name to be used. Convert a Java object into JSON, using the specified property name in the JSON output. 

  Convert JSON into a Java object, mapping the specified JSON property name to the corresponding Java field when deserializing.

  ```java
  import com.fasterxml.jackson.annotation.JsonProperty;
  
  public class Product {
      @JsonProperty("description_yyds")
      private String description;
  
      // Constructors, getters, and setters
      public Product() {}
  
      public Product(String description) {
          this.description = description;
      }
  
      public String getDescription() {
          return description;
      }
  
      public void setDescription(String description) {
          this.description = description;
      }
  }
  
  ```

  And it will be serialized as:

  ```java
  import com.fasterxml.jackson.databind.ObjectMapper;
  
  public class Main {
      public static void main(String[] args) throws Exception {
          Product product = new Product("This is a great product");
          
          ObjectMapper objectMapper = new ObjectMapper();
          String jsonString = objectMapper.writeValueAsString(product);
          
          System.out.println(jsonString); // Output: {"description_yyds":"This is a great product"}
      }
  }
  
  ```

  ### 4. Explain the purpose of following dependency?

  ```
      <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.13.3</version>
      <scope>compile</scope>
      </dependency>
  ```

  The Jackson Databank library is part of the Jackson JSON processing framework and is used for converting Java objects to JSON and vice versa.

  Utilize Jackson annotations like `@JsonProperty`, `@JsonIgnore`, `@JsonInclude`, etc., to control JSON processing.

  Customize JSON processing behavior using `ObjectMapper`.

  ### 5. What is spring-boot-starter?

  In Spring Boot, a **starter** (correctly spelled as `spring-boot-starter`) is a special type of dependency that includes a set of curated dependencies and configurations. Each starter is designed to provide a specific set of functionalities or features for Spring Boot applications.

  - Instead of manually specifying individual libraries and configurations, starters encapsulate them into one dependency. This simplifies the project setup and reduces the chance of dependency version conflicts.

  - Starters enable developers to quickly bootstrap applications with common functionalities, allowing them to focus more on implementing business logic rather than infrastructure concerns.
  - **Convention over Configuration**: Spring Boot encourages convention over configuration. Starters follow this principle by providing sensible defaults and reducing the need for explicit configuration.

  ```
      <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
      </dependency>
  ```

  `spring-boot-starter-web` is the starter package that includes all necessary dependencies and configurations for developing web applications using Spring MVC and an embedded servlet container. Includes an embedded servlet container (like Tomcat, Jetty, or Undertow) so that you can run your application as a standalone web server without needing to deploy to an external server.

  Other starters:

  - `spring-boot-starter-data-jpa`:  Includes dependencies for Spring Data JPA, Hibernate, and a JDBC API.
  - `spring-boot-starter-test`: Includes testing dependencies for unit and integration testing.
  - `spring-boot-starter-data-mongodb`: Provides support for using MongoDB databases with Spring Data MongoDB.

### 6. Explain @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?

@RequestMapping is used to map HTTP requests to handler methods in Spring MVC controllers

`value="/users"` specifies the URL path that this handler method will respond to.

`method = RequestMethod.POST`: Specifies that this handler method will handle HTTP POST requests. This means it will process data submitted to the `/users` endpoint via a POST request.

**CRUD: create, read, update, delete**

- Create

  ```java
  import org.springframework.web.bind.annotation.*;
  
  @RestController
  @RequestMapping("/api")
  public class UserController {
  
      @PostMapping("/users")
      public String createUser(@RequestBody User user) {
          // Logic to create a new user
          return "User created: " + user.getUsername();
      }
  }
  
  ```

  

- Read

  ```java
  @RestController
  @RequestMapping("/api")
  public class UserController {
  
      @GetMapping("/users/{id}")
      public String getUser(@PathVariable Long id) {
          // Logic to fetch user details by ID
          return "User details for ID: " + id;
      }
  }
  
  ```

  

- Update

  ```java
  @RestController
  @RequestMapping("/api")
  public class UserController {
  
      @PutMapping("/users/{id}")
      public String updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
          // Logic to update user details by ID
          return "User updated: " + updatedUser.getUsername();
      }
  }
  
  ```

  

- Delete

  ```java
  @RestController
  @RequestMapping("/api")
  public class UserController {
  
      @DeleteMapping("/users/{id}")
      public String deleteUser(@PathVariable Long id) {
          // Logic to delete user by ID
          return "User deleted with ID: " + id;
      }
  }
  
  ```

  

### 7. What is ResponseEntity? why do we need it?

`ResponseEntity` in Spring Framework represents the entire HTTP response, including headers, status code, and body. It's a powerful way to customize and control the HTTP response returned from a Spring MVC controller.

**Customize HTTP Response**: Allows you to set HTTP headers, status codes, and response body with fine-grained control.

**Flexibility**: Provides flexibility in handling different types of responses, including JSON, HTML, files, or even custom content types.

**Handle Errors**: Easily handle error conditions by returning appropriate HTTP status codes and error messages.

**Integration with RESTful Services**: Ideal for building RESTful APIs where the structure and content of the HTTP response are crucial.

- **HTTP Status Codes**: By using `ResponseEntity`, you can specify exact HTTP status codes (like 200 OK, 404 Not Found, 500 Internal Server Error, etc.) based on the outcome of your request handling logic.

- **Headers**: You can set custom HTTP headers such as `Content-Type`, `Cache-Control`, or any other headers required for your application.

- **Body**: Allows you to return any Java object as the response body. Spring's message converters convert these objects to the appropriate content type (JSON, XML, etc.) based on the `Accept` header of the request.

### 8. What is ResultSet in jdbc? and describe the flow how to get data using JDBC

In JDBC (Java Database Connectivity), a `ResultSet` is an interface that represents a table of data returned by a SQL query. It allows Java applications to retrieve and manipulate the results of a database query. Once a `Statement` (or `PreparedStatement`) is executed against a database, it produces a `ResultSet` that encapsulates the query results.

#### 1. Load the JDBC Driver

```java
Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL JDBC driver
```

#### 2. Establish a Connection to the Database

```java
String jdbcUrl = "jdbc:mysql://localhost:3306/mydatabase";
String username = "username";
String password = "password";
Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
```

#### 3. Create a Statement or PreparedStatement

```java
String sql = "SELECT id, name, email FROM users WHERE id = ?";
PreparedStatement preparedStatement = connection.prepareStatement(sql);
preparedStatement.setInt(1, userId); // Set parameter if using PreparedStatement
```

#### 4. Execute the Query and Get ResultSet

```java
ResultSet resultSet = preparedStatement.executeQuery();
```

#### 5. Iterate Over the ResultSet to Retrieve Data

```java
while (resultSet.next()) {
    int id = resultSet.getInt("id");
    String name = resultSet.getString("name");
    String email = resultSet.getString("email");

    // Process retrieved data (e.g., store in Java objects, print to console)
    System.out.println("User ID: " + id + ", Name: " + name + ", Email: " + email);
}
```

#### 6. Close Resources

```java
resultSet.close();
preparedStatement.close();
connection.close();
```

### 9. Compare Spring Data JPA vs Hibernate vs JDBC.

- **Spring Data JPA(Java Persistence API)**:

JPA is a specification that defines a standard interface for Java applications to interact with relational databases. It simplifies database access by providing a set of annotations and APIs for mapping Java objects to database tables. JPA is not an implementation but rather a set of rules that frameworks, like Hibernate, implement.

Spring Data JPA builds on top of JPA and Hibernate, providing a higher level of abstraction and eliminating boilerplate code for common CRUD operations.

- **Hibernate**:

Hibernate is a powerful and widely used Object-Relational Mapping (ORM) framework. It is a JPA implementation, meaning it adheres to the rules set by the JPA specification. It simplifies database interactions by mapping Java objects to database tables and vice versa.

Hibernate operates at a higher level of abstraction compared to JDBC. It abstracts away the details of SQL queries and database operations.

- **JDBC**

JDBC is a low-level API for Java developers to interact directly with databases. It provides methods to execute SQL queries, update statements, and stored procedures.

 Lowest level, requires manual SQL handling, suitable for performance-critical applications and when full control over SQL queries is necessary.

### 10.  Learn how to use ObjectMapper by this example.

 https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/ex ercise/oa/api/FoodOutletJackson.java

```java
 FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);
String s = objectMapper.writeValueAsString(foodOutlet);
objectMapper.readTree() // learn how to use it?
```

The `ObjectMapper` class from the Jackson library is a powerful tool for converting between Java objects and JSON. 

`objectMapper.readValue(resBody, FoodOutlet.class)`: Deserializes the JSON response into a `FoodOutlet` object.

`objectMapper.writeValueAsString(foodOutlet)`: Serializes the `FoodOutlet` object back to a JSON string for debugging or logging.

The `objectMapper.readTree()` method from the Jackson library is used to parse JSON strings into a `JsonNode` tree structure.`objectMapper.readTree()` provides a flexible way to work with JSON data, allowing you to handle dynamic JSON structures without predefined Java classes.



### 11. What is the serialization and desrialization?

**Serialization** is the process of converting an object into a format that can be easily stored or transmitted. In the context of JSON, serialization refers to converting a Java object into a JSON string.

When building RESTful web services, JSON is commonly used as the format for request and response bodies. Serialization converts Java objects to JSON to send as HTTP responses, and deserialization converts JSON request bodies to Java objects.

**Deserialization** is the process of converting data from a storage or transmission format back into an object. For JSON, deserialization means converting a JSON string back into a Java object.

```java
@RestController
@RequestMapping("/api/foodoutlets")
public class FoodOutletController {

    @PostMapping
    public ResponseEntity<FoodOutlet> createFoodOutlet(@RequestBody FoodOutlet foodOutlet) {
        // foodOutlet is deserialized from the JSON request body
        // Process the foodOutlet and save it to the database
        return ResponseEntity.ok(foodOutlet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodOutlet> getFoodOutlet(@PathVariable Long id) {
        FoodOutlet foodOutlet = // fetch from the database
        // foodOutlet is serialized to JSON for the HTTP response
        return ResponseEntity.ok(foodOutlet);
    }
}

```

When working with message queues (e.g., RabbitMQ, Kafka), messages are often serialized into JSON format before being sent and deserialized upon receipt.

```java
@Service
public class FoodOutletService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendFoodOutlet(FoodOutlet foodOutlet) {
        String jsonString = objectMapper.writeValueAsString(foodOutlet);
        rabbitTemplate.convertAndSend("foodoutlet.exchange", "foodoutlet.routingkey", jsonString);
    }

    @RabbitListener(queues = "foodoutlet.queue")
    public void receiveFoodOutlet(String jsonString) {
        FoodOutlet foodOutlet = objectMapper.readValue(jsonString, FoodOutlet.class);
        // process the foodOutlet
    }
}

```



### 12. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].

```java
Double avg = Arrays.stream(arr).average().orElse(0.0);
```



