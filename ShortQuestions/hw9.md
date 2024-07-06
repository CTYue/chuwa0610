1. List all of the Spring data related annotations your learned and explain its usage
   1. **@Entity**
      - Marks a class as a JPA entity.
   2. **@Table**
      - Specifies the table in the database with which the entity is mapped.
   3. **@Id**
      - Marks a field as the primary key of the entity.
   4. **@GeneratedValue**
      - Specifies the primary key generation strategy.
      - Example: `@GeneratedValue(strategy = GenerationType.IDENTITY)`
   5. **@Column**
      - Maps a field to a column in the database.
      - Example: `@Column(name = "username") private String username;`
   6. **@OneToOne**
      - Defines a one-to-one relationship between two entities.
      - Example: `@OneToOne private Profile profile;`
   7. **@OneToMany**
      - Defines a one-to-many relationship between two entities.
      - Example: `@OneToMany(mappedBy = "user") private List<Order> orders;`
   8. **@ManyToOne**
      - Defines a many-to-one relationship between two entities.
      - Example: `@ManyToOne private User user;`
   9. **@ManyToMany**
      - Defines a many-to-many relationship between two entities.
      - Example: `@ManyToMany private List<Role> roles;`
   10. **@JoinColumn**
       - Specifies the foreign key column for a relationship.
       - Example: `@JoinColumn(name = "profile_id")`
   11. **@JoinTable**
       - Specifies the join table for a many-to-many relationship.
       - Example: `@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))`
   12. **@Enumerated**
       - Maps an enum type to a database column.
       - Example: `@Enumerated(EnumType.STRING)`
   13. **@Lob**
       - Specifies that a field should be persisted as a large object to a database-supported large object type.
       - Example: `@Lob private byte[] content;`
   14. **@Temporal**
       - Specifies the temporal precision of a date field.
       - Example: `@Temporal(TemporalType.TIMESTAMP) private Date createdDate;`
   15. **@Transient**
       - Specifies that a field is not persistent.
       - Example: `@Transient private String tempData;`
   16. **@Embedded**
       - Embeds a class into another entity.
       - Example: `@Embedded private Address address;`
   17. **@Embeddable**
       - Marks a class whose instances are stored as an intrinsic part of an owning entity.
       - Example: `@Embeddable public class Address { ... }`



2. What is DTO, VO, Payload, PO, model, DAO?
   - **DTO(Data Transfer Object)**: A DTO is an object that is used to transfer data between different parts of an application, often between the server and client.
   - **VO(View Object)**: In Spring Boot, VO stands for **Value Object** , which is typically used to encapsulate data returned to the client. It is a special kind of DTO (Data Transfer Object) .
   - **Payload**: The body of a request or response in web services.
   - **DAO(Data Access Object)**:A DAO is an object that provides an abstract interface to some type of database or other persistence mechanisms. DAOs encapsulate the data access logic and provide methods to perform CRUD (Create, Read, Update, Delete) operations.
   - **PO**: Persistent Object, represents data that can be persisted to a database.
   - **Model:** Represents the core business logic and data.

3. What is @JsonProperty("description_yyds")

   - `@JsonProperty` is an annotation from the Jackson library, which is used for JSON serialization and deserialization in Java. It is used to specify the JSON property name to map to a Java field or method during the serialization (Java object to JSON) and deserialization (JSON to Java object) processes.

4. Explain the purpose of following dependency?

   ```xml
   <dependency>
     <groupId>com.fasterxml.jackson.core</groupId>
     <artifactId>jackson-databind</artifactId>
     <version>2.13.3</version>
     <scope>compile</scope>
   </dependency>
   ```

   The `jackson-databind` dependency is crucial for working with JSON data in Java applications. It allows for easy serialization and deserialization of Java objects to and from JSON, providing a flexible way to handle JSON data within Java applications.

5. What is spring-boot-stater?

   - A **Spring Boot Starter** is a dependency descriptor that simplifies the process of setting up and configuring a Spring-based project. These starters are a set of convenient dependency descriptors that you can include in your application.
   - In `spring-boot-starter-web` starter, there are depedencies for building web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container.

6. Explain `@RequestMapping(value = "/users", method = RequestMethod.POST)` ? Could you list CRUD by this style?

   - Explanation: 

     - **`value = "/users"`**: This specifies the URL path to which the handler method will respond. In this case, the method will handle requests sent to `/users`.
     - **`method = RequestMethod.POST`**: This specifies the HTTP method that the handler method will support. In this case, the method will handle `POST` requests.

   - CRUD:

     ```java
     @RequestMapping(value = "/users", method = RequestMethod.POST)
     public ResponseEntity<User> createUser(@RequestBody User user) {
         // Logic to create a new user
     }
     
     @RequestMapping(value = "/users", method = RequestMethod.GET)
     public ResponseEntity<List<User>> getAllUsers() {
         // Logic to retrieve all users
     }
     
     @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
     public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
         // Logic to update an existing user
     }
     
     @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
     public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
         // Logic to delete a user
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
     ```

7. What is ResponseEntity? why do we need it?

   - `ResponseEntity` is a class provided by the Spring Framework that represents an HTTP response, including the status code, headers, and body. It allows developers to specify the status code, headers, and body of the response, providing complete control over the HTTP interaction between the client and server. This makes it an essential component for building robust and flexible RESTful web services.

8. What is ResultSet in jdbc? and describe the flow how to get data using JDBC

   - `ResultSet` is an interface in Java's JDBC API that represents the result set of a query made to a database. It acts as a table of data representing a database result set, which is generated by executing a statement that queries the database.

   - ```java
     import java.sql.Connection;
     import java.sql.DriverManager;
     import java.sql.ResultSet;
     import java.sql.Statement;
     
     public class JdbcExample {
         public static void main(String[] args) {
             String jdbcUrl = "jdbc:mysql://localhost:3306/mydatabase";
             String username = "root";
             String password = "password";
     
             Connection connection = null;
             Statement statement = null;
             ResultSet resultSet = null;
     
             try {
                 // Load JDBC driver (optional for newer JDBC versions)
                 Class.forName("com.mysql.cj.jdbc.Driver");
     
                 // Establish connection
                 connection = DriverManager.getConnection(jdbcUrl, username, password);
     
                 // Create statement
                 statement = connection.createStatement();
     
                 // Execute query
                 resultSet = statement.executeQuery("SELECT * FROM users");
     
                 // Process ResultSet
                 while (resultSet.next()) {
                     int id = resultSet.getInt("id");
                     String userName = resultSet.getString("username");
                     String email = resultSet.getString("email");
     
                     // Output data
                     System.out.println("ID: " + id + ", Username: " + userName + ", Email: " + email);
                 }
             } catch (Exception e) {
                 e.printStackTrace();
             } finally {
                 // Close resources
                 try {
                     if (resultSet != null) resultSet.close();
                     if (statement != null) statement.close();
                     if (connection != null) connection.close();
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }
         }
     }
     
     ```

9. Compare Spring Data JPA vs Hibernate vs JDBC

   - **Spring Data JPA**: A high-level Spring framework that abstracts the complexities of JDBC and JPA. It simplifies the data access layer by providing repository interfaces and implementations.
   - **Hibernate**: A widely-used ORM (Object-Relational Mapping) framework that implements the JPA specification. It maps Java objects to database tables and handles the boilerplate code for CRUD operations.
   - **JDBC (Java Database Connectivity)**: A low-level API for interacting with relational databases directly. It requires manual handling of SQL queries and result sets.

11. What is the serialization and desrialization?

    - **Serialization** is the process of converting an object into a format that can be easily stored or transmitted, such as a byte stream, JSON, or XML. The primary purpose of serialization is to persist the state of an object or to transfer it over a network.

    - JSON Serialization Example

      ```java
      // define a serializable class
      import java.io.Serializable;
      
      public class Person implements Serializable {
          private static final long serialVersionUID = 1L;
          
          private String name;
          private int age;
      
          public Person(String name, int age) {
              this.name = name;
              this.age = age;
          }
      }
      
      public class JsonSerializeDemo {
          public static void main(String[] args) {
              Person person = new Person("John Doe", 30);
              ObjectMapper objectMapper = new ObjectMapper();
      
              try {
                  String jsonString = objectMapper.writeValueAsString(person);
                  System.out.println("Serialized JSON: " + jsonString);
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
      
      public class JsonDeserializeDemo {
          public static void main(String[] args) {
              String jsonString = "{\"name\":\"John Doe\",\"age\":30}";
              ObjectMapper objectMapper = new ObjectMapper();
      
              try {
                  Person person = objectMapper.readValue(jsonString, Person.class);
                  System.out.println("Deserialized Person...");
                  System.out.println("Name: " + person.getName());
                  System.out.println("Age: " + person.getAge());
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
      ```

      

12. Use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32]

    ```java
    double average = Arrays.stream(numbers)
                                   .average()
                                   .orElse(Double.NaN);
    ```

    