# Chuwa Homework9 MingHao(Howard) Lee 

## 1. List all of the Spring data related annotations your learned and explain its usage. 
- **`@Entity`**
  - **Usage**: Indicates that the class is an entity and is mapped to a database table.

- **`@Table`**
  - **Usage**: Specifies the name of the database table to be used for mapping.

- **`@Id`**
  - **Usage**: Specifies the primary key of an entity.

- **`@GeneratedValue`**
  - **Usage**: Provides the specification of generation strategies for the values of primary keys.

- **`@Column`**
  - **Usage**: Used to specify the details of the column to which a field or property will be mapped.

- **`@Repository`**
  - **Usage**: Indicates that the class is a repository and it should be used for data access and retrieval operations.

- **`@Query`**
  - **Usage**: Used to define custom queries using JPQL or SQL.

- **`@Transactional`**
  - **Usage**: Declares transaction management for the annotated method or class.

## 2. What is DTO, VO, Payload, PO, model, DAO?
1. **DTO (Data Transfer Object)**
   - **Definition**: A DTO is an object that carries data between processes. It is used to transfer data across different layers of an application or between services.
   - **Usage**: DTOs are often used to encapsulate data and transfer it from the client to the server and vice versa, especially in web services and APIs. They usually do not contain business logic.

2. **VO (Value Object)**
   - **Definition**: A VO is an object that contains values and is used to represent an entity's state. Value objects are immutable and are compared based on their attributes rather than their identities.
   - **Usage**: VOs are used to represent entities where the value is the key characteristic. Examples include currency, measurements, or complex data types like an address.

3. **Payload**
   - **Definition**: In the context of data transmission, a payload is the actual data that is being transported in a network packet or during an API call, excluding any metadata or headers.
   - **Usage**: Payloads are used to refer to the data sent in an API request or response. For example, in a JSON API, the payload would be the JSON body containing the data.

4. **PO (Persistent Object)**
   - **Definition**: A PO is an object that represents data that can be persisted to a database. These objects usually correspond directly to database tables.
   - **Usage**: POs are used in the context of ORM (Object-Relational Mapping) frameworks like Hibernate, where the objects are directly mapped to database tables for persistence.

5. **Model**
   - **Definition**: A model is a representation of a data structure used in an application. It often includes the data itself and the business logic for interacting with that data.
   - **Usage**: Models are used in MVC (Model-View-Controller) architecture. The model represents the data and the rules for how the data can be manipulated and interacted with.

6. **DAO (Data Access Object)**
   - **Definition**: A DAO is an object that provides an abstract interface to some type of database or other persistence mechanism. It typically contains methods for CRUD (Create, Read, Update, Delete) operations.
   - **Usage**: DAOs are used to separate the persistence layer from the business logic layer in an application. They provide a way to interact with the database without exposing the details of the database access code to the rest of the application.

## 3. What is `@JsonProperty("description_yyds")`?

`@JsonProperty` is an annotation from the Jackson library used to specify the property name in JSON when serializing and deserializing Java objects. 

- **Purpose**: The `@JsonProperty` annotation defines the JSON property name that will be used during serialization and deserialization.
- **Usage**: It is used when you have a Java field with one name but want it to be represented with a different name in the JSON data. For example, if the Java field is named `description` but you want it to appear as `description_yyds` in the JSON, you use `@JsonProperty("description_yyds")`.
- **Effect**: Ensures the JSON representation uses the specified property name (`description_yyds`) during both serialization and deserialization processes.

## 4. Explain the purpose of following dependency? 
```Java
  <dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.13.3</version>
    <scope>compile</scope>
  </dependency>
```

### Purpose of `jackson-databind` Dependency

- **Group ID**: `com.fasterxml.jackson.core`
  - This specifies the group (or organization) that provides the library. `com.fasterxml.jackson.core` is the group ID for the core Jackson libraries.

- **Artifact ID**: `jackson-databind`
  - This specifies the specific library within the group. `jackson-databind` is the Jackson library responsible for data binding, which converts JSON to and from Java objects.

- **Version**: `2.13.3`
  - This specifies the version of the library to be used. Version `2.13.3` is a specific release of the `jackson-databind` library.

- **Scope**: `compile`
  - This specifies the classpath scope in which the dependency is available. `compile` scope means the dependency is available in all build tasks and runtime phases.

### Explanation

The `jackson-databind` dependency is a part of the Jackson library suite, which is used for parsing JSON data and converting it into Java objects (deserialization) and for converting Java objects into JSON data (serialization).

### Key functionalities provided by `jackson-databind` include:

#### Deserialization: Converting JSON strings into Java objects.

**Example:**
```Java
  ObjectMapper objectMapper = new ObjectMapper();
  User user = objectMapper.readValue(jsonString, User.class);
```
#### Serialization: Converting Java objects into JSON strings.
 **Example:**
```Java
  ObjectMapper objectMapper = new ObjectMapper();
  String jsonString = objectMapper.writeValueAsString(user);
```
#### Configuration: Customizing the serialization and deserialization processes through annotations and configuration settings.
**Example:**
```Java
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public class User {
      private String name;
      private Integer age;
      // getters and setters
  }
```
### Usage in Spring Applications

In Spring applications, `jackson-databind` is commonly used for:

- Handling JSON data in RESTful web services (e.g., in Spring Boot applications).
- Automatically converting JSON request bodies to Java objects and Java objects to JSON responses using `@RequestBody` and `@ResponseBody` annotations.

**Example in a Spring Boot Controller:**

```java
@RestController
public class UserController {

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // user is automatically deserialized from JSON
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.findById(id);
        // user is automatically serialized to JSON
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
```
In summary, the `jackson-databind` dependency is crucial for handling JSON data in Java applications, 
providing powerful and flexible means of serializing and deserializing JSON data.

## 5. What is `spring-boot-starter`?
1. What dependencies are in the below starter? Do you know any starters?
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

The `spring-boot-starter-web` starter includes the following dependencies:

- **Spring Web**: Provides core web functionalities including RESTful services.
- **Spring MVC**: Provides Model-View-Controller (MVC) architecture for web applications.
- **Jackson**: Used for JSON processing.
- **Tomcat**: The default embedded servlet container.

Some other commonly used Spring Boot starters include:

- **spring-boot-starter-data-jpa**: For using Spring Data JPA with Hibernate.
- **spring-boot-starter-security**: For securing your application with Spring Security.
- **spring-boot-starter-test**: For testing Spring Boot applications with libraries such as JUnit, Hamcrest, and Mockito.
- **spring-boot-starter-thymeleaf**: For using Thymeleaf as the templating engine.
- **spring-boot-starter-actuator**: For adding production-ready features such as metrics and monitoring.

## 6. Explain `@RequestMapping(value = "/users", method = RequestMethod.POST)`? Could you list CRUD operations in this style?
The `@RequestMapping` annotation is used to map web requests to specific handler functions in Spring MVC and Spring Boot. The `value` attribute specifies the URL pattern to which the handler method will respond, and the `method` attribute specifies the HTTP request method (e.g., GET, POST, PUT, DELETE).

## CRUD Operations using `@RequestMapping`
**Create (POST)**
```Java
  @RequestMapping(value = "/users", method = RequestMethod.POST)
  public ResponseEntity<User> createUser(@RequestBody User user) {
      // logic to create a user
      return new ResponseEntity<>(user, HttpStatus.CREATED);
  }
```
**Read (GET)**
```Java
  @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
  public ResponseEntity<User> getUser(@PathVariable Long id) {
      // logic to retrieve a user by id
      User user = userService.findById(id);
      return new ResponseEntity<>(user, HttpStatus.OK);
  }
```
**Update (PUT)**
```Java
  @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
  public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
      // logic to update a user
      User updatedUser = userService.updateUser(id, userDetails);
      return new ResponseEntity<>(updatedUser, HttpStatus.OK);
  }
```

**Delete (DELETE)**
```Java
  @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
      // logic to delete a user by id
      userService.deleteUser(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
```


## 7. What is `ResponseEntity`? Why do we need it?
```Java
  new ResponseEntity<>(postResponse, HttpStatus.OK);
  new ResponseEntity<>(postResponse, HttpStatus.CREATED);
  ResponseEntity.ok(postService.getPostById(id));
```
`ResponseEntity` is a class in Spring MVC that represents the entire HTTP response, including the status code, headers, and body. It provides greater control over the response sent to the client.

#### Why do we need `ResponseEntity`?
- **Control Over Status Codes**: It allows us to set the HTTP status code of the response, such as `OK`, `CREATED`, `NO_CONTENT`, etc.
- **Setting Headers**: We can customize the response headers.
- **Customizing the Response Body**: It provides flexibility to manipulate the response body.

**Examples:**

- `new ResponseEntity<>(postResponse, HttpStatus.OK);`
  - This creates a `ResponseEntity` with the body `postResponse` and HTTP status `OK`.

- `new ResponseEntity<>(postResponse, HttpStatus.CREATED);`
  - This creates a `ResponseEntity` with the body `postResponse` and HTTP status `CREATED`.

- `ResponseEntity.ok(postService.getPostById(id));`
  - This creates a `ResponseEntity` with the body provided by `postService.getPostById(id)` and HTTP status `OK`.

#### Example in a Spring Boot Controller:

```java
  @RestController
  public class PostController {
  
      @GetMapping("/posts/{id}")
      public ResponseEntity<PostResponse> getPostById(@PathVariable Long id) {
          PostResponse postResponse = postService.getPostById(id);
          return ResponseEntity.ok(postResponse);
      }
  
      @PostMapping("/posts")
      public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest postRequest) {
          PostResponse postResponse = postService.createPost(postRequest);
          return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
      }
  }
```
In this example:
- The `getPostById` method returns a ResponseEntity with an OK status.
- The `createPost` method returns a ResponseEntity with a CREATED status.

## 8. What is `ResultSet` in JDBC?abd describle the folw how to get data using JDBC

`ResultSet` is a class in Java's JDBC API that represents the result set of a database query. It provides methods to iterate through the returned data, retrieve individual column values, and navigate through the results.

### Flow to Get Data Using JDBC and describe the flow howto get data using JDBC

The process of retrieving data using JDBC involves several clear steps:

1. Load the JDBC Driver

Register the JDBC driver to establish a connection to the database.

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

2. Establish a Connection
Use the `DriverManager` class to create a connection to the database.

```Java
  Connection connection = DriverManager.getConnection(
  "jdbc:mysql://localhost:3306/mydatabase", "username", "password");
```
3. Create a Statement
Use the `Connection` object to create a `Statement` or `PreparedStatement` object to execute SQL queries.

```Java
  Statement statement = connection.createStatement();
  // or
  PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
```
4. Execute a Query
Execute the SQL query using the `Statement` or `PreparedStatement` object and obtain the `ResultSet`.

```Java
  ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
  // or
  preparedStatement.setInt(1, userId);
  ResultSet resultSet = preparedStatement.executeQuery();
```
5. Process the ResultSet
Iterate through the `ResultSet` to retrieve and process data.

```Java
  while (resultSet.next()) {
      int id = resultSet.getInt("id");
      String name = resultSet.getString("name");
      // Process the data as needed
  }
```
6. Close the Resources
Properly close the `ResultSet`, `Statement`, and `Connection` objects to free up database resources.

```Java
  resultSet.close();
  statement.close();
  connection.close();
```
**Example Code**
- **Here's a comprehensive example demonstrating how to use JDBC to retrieve data from a MySQL database:**

```Java
  public class JDBCExample {
      public static void main(String[] args) {
          try {
              // Load the JDBC driver
              Class.forName("com.mysql.cj.jdbc.Driver");
  
              // Establish a connection
              Connection connection = DriverManager.getConnection(
                  "jdbc:mysql://localhost:3306/mydatabase", "username", "password");
  
              // Create a statement
              Statement statement = connection.createStatement();
  
              // Execute a query
              ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
  
              // Process the result set
              while (resultSet.next()) {
                  int id = resultSet.getInt("id");
                  String name = resultSet.getString("name");
                  System.out.println("ID: " + id + ", Name: " + name);
              }
  
              // Close the resources
              resultSet.close();
              statement.close();
              connection.close();
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
  }
```

## 9. Compare Spring Data JPA vs Hibernate vs JDBC

| Feature                     | Spring Data JPA                                    | Hibernate                                         | JDBC                                                |
|-----------------------------|----------------------------------------------------|---------------------------------------------------|-----------------------------------------------------|
| **Abstraction Level**       | High                                               | Medium                                            | Low                                                 |
| **Ease of Use**             | Very easy to use with repository interfaces        | Easier than JDBC, but requires understanding of ORM concepts | Low-level, requires extensive boilerplate code       |
| **Configuration**           | Minimal configuration required                     | Requires configuration of SessionFactory and mappings | Requires manual configuration of connections, statements, and result sets |
| **Productivity**            | High due to repositories and derived queries       | High, but requires more setup than Spring Data JPA | Moderate, but prone to repetitive boilerplate code  |
| **Query Language**          | JPQL or derived queries                            | HQL (Hibernate Query Language) and JPQL            | SQL                                                 |
| **Performance**             | Generally good, but might require tuning           | Generally good, but might require tuning           | High performance, but requires manual optimization  |
| **Transaction Management**  | Integrated with Spring's transaction management    | Integrated with Hibernate transaction management   | Manual management of transactions                   |
| **Support for Complex Mappings** | Excellent with annotations and XML configurations | Excellent with annotations and XML configurations  | Requires manual handling of complex SQL queries     |
| **Vendor Lock-in**          | Low, as it abstracts the underlying JPA provider   | Medium, as it is specific to Hibernate             | None, as it directly uses SQL and JDBC API          |
| **Learning Curve**          | Low for those familiar with Spring                 | Moderate, due to ORM concepts                      | Steep, due to low-level API and SQL knowledge       |
| **Community and Support**   | Large, backed by Spring ecosystem                  | Large, with extensive documentation and support    | Large, as it is the standard Java API for database access |

### Summary

- **Spring Data JPA**:
  - **Pros**: High-level abstraction, easy to use, minimal configuration, integrated with Spring ecosystem.
  - **Cons**: Slightly lower performance compared to JDBC, might require tuning for complex queries.

- **Hibernate**:
  - **Pros**: Powerful ORM framework, excellent support for complex mappings, extensive configuration options.
  - **Cons**: Requires more setup and understanding of ORM concepts, medium vendor lock-in.

- **JDBC**:
  - **Pros**: Direct access to SQL, high performance, no vendor lock-in.
  - **Cons**: Low-level API, extensive boilerplate code, manual transaction management, steep learning curve.

Each of these technologies has its strengths and weaknesses, and the choice depends on the specific needs of the project, the team's familiarity with the technology, and the complexity of the database interactions.

## 10. How to use `ObjectMapper` in Jackson

The `ObjectMapper` class is the main class used for converting JSON to and from Java objects in the Jackson library. Below is an example that demonstrates its usage.

#### Example Code: FoodOutletJackson
#### 1. https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/ex ercise/oa/api/FoodOutletJackson.java

  
**ObjectMapper Methods Used:**
- `readValue`:
  - **Usage:** Converts JSON string to a Java object.
  - **Example:**
  - `FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);`

- `writeValueAsString`:
  - **Usage:** Converts a Java object to a JSON string.
  - **Example:**
  - `String jsonString = objectMapper.writeValueAsString(foodOutlet);`

- `readTree`:
  - **Usage:** Parses JSON into a JsonNode tree model, which allows for more flexible and dynamic data handling.
  - **Example:**
  ```Java
    JsonNode rootNode = objectMapper.readTree(resBody);
    JsonNode dataNode = rootNode.path("data");
    for (JsonNode node : dataNode) {
        String name = node.path("name").asText();
        int estimatedCost = node.path("estimated_cost").asInt();
        if (estimatedCost <= maxCost) {
            res.add(name);
        }
    }
  ```

**Steps to Use ObjectMapper:**

1. Create an ObjectMapper instance:

- `private static ObjectMapper objectMapper = new ObjectMapper();`

2. Convert JSON to Java object using readValue:

- `FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);`
  
3. Convert Java object to JSON string using writeValueAsString:

- `String jsonString = objectMapper.writeValueAsString(foodOutlet);`

4. Parse JSON using readTree:

- `JsonNode rootNode = objectMapper.readTree(resBody);`
**Summary**
The ObjectMapper class in Jackson provides a powerful way to work with JSON data. It allows for easy conversion between JSON strings and Java objects, as well as more advanced features like reading and manipulating JSON trees.

## 11. What is Serialization and Deserialization?

**Serialization** is the process of converting a data object—a combination of code and data represented within a region of data storage—into a series of bytes that saves the state of the object in an easily transmittable form. In this serialized form, the data can be delivered to another data store (such as an in-memory computing platform), application, or some other destination.

**Deserialization** is the reverse process—constructing a data structure or object from a series of bytes. The deserialization process recreates the object, thus making the data easier to read and modify as a native structure in a programming language.

## 12. Using Stream API to Calculate the Average of an Array
```java
import java.util.Arrays; `[20, 3, 78, 9, 6, 53, 73, 99, 24, 32]`

public class StreamApiExample {
    public static void main(String[] args) {
        int[] numbers = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};

        double average = Arrays.stream(numbers)
                               .average()
                               .orElse(Double.NaN); // returns NaN if the array is empty

        System.out.println("Average: " + average);
    }
}
```

## question 13 and 14 refer to the branch MingHao_Lee/hw9 branch coding branch 




