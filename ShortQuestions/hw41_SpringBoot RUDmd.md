### HW41 / hw9 

#### 1. List all of the Spring data related annotations your learned and explain its usage.

##### @JoinTable

- Used to define the table with many-to-many relationship.

##### @OneToOne @ManyToOne, @OneToMany @ManyToMany - 

- Mark the relationship between tables.

```java
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerID;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sale> sales;
}
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long saleID;

    @Temporal(TemporalType.DATE)
    private Date saleDate;

    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> books;
}
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookID;

    @ManyToOne
    @JoinColumn(name = "saleID")
    private Sale sale;

    @ManyToMany
    @JoinTable(
        name = "Book_Authors", // 连接表的名称
        joinColumns = @JoinColumn(name = "bookID"), // 定义指向 Book 实体的外键
        inverseJoinColumns = @JoinColumn(name = "authorID") // 定义指向 Author 实体的外键
    )
    private List<Author> authors;
}
```

##### @Entity
- Used to mark a class as a JPA entity, which maps to a database table.
```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}
```

##### @Id
- Specifies the primary key of an entity.
```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

##### @GeneratedValue
- Specifies the generation strategy for the primary key.
```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

##### @Column
- Specifies the mapping between a field and a column in the database.
```java
@Column(name = "user_name", nullable = false, length = 50)
private String name;
```

##### @Table
- Specifies the table name in the database that the entity maps to.
```java
@Entity
@Table(name = "users")
public class User {
    // fields, getters, setters
}
```

##### @Repository
- Indicates that the class is a Spring Data repository.
```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
```

##### @Query
- Defines a custom query directly on the repository method.
```java
@Query("SELECT u FROM User u WHERE u.email = :email")
User findByEmail(@Param("email") String email);
```


##### @Transactional
- Indicates that the method or class should be executed within a transactional context.
```java
@Transactional
public void someTransactionalMethod() {
    // method implementation
}
```


##### @CreatedDate
- Used in conjunction with Spring Data JPA Auditing to automatically populate date fields.
```java
@CreatedDate
private LocalDateTime createdDate;
```

##### @LastModifiedDate
- Used in conjunction with Spring Data JPA Auditing to automatically populate date fields.
```java
@LastModifiedDate
private LocalDateTime lastModifiedDate;
```
##### @JoinColumn
- Specifies the **foreign key** column for an entity relationship.
```java
@ManyToOne
@JoinColumn(name = "user_id")
private User user;
```
Sure, here are additional Spring annotations, particularly those used in Spring MVC and Spring Data REST, in the specified format

##### @JsonProperty

-  to indicate the property name in JSON.

```java
public class MyBean {
    public int id;
    private String name;

    @JsonProperty("name")
    public void setTheName(String name) {
        this.name = name;
    }

    @JsonProperty("name")
    public String getTheName() {
        return name;
    }
}
```

##### @RequestMapping

-  used to define the URL mapping and the HTTP method for a particular handler method in a controller.

```java
@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
public ResponseEntity<User> getUserById(@PathVariable Long id) {
    // Logic to get a user by id
    User user = userService.findById(id);
    if (user != null) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

```

##### @GetMapping
- Used to define a URL mapping and the HTTP GET method for a particular handler method in a controller.
```java
@GetMapping("/users/{id}")
public ResponseEntity<User> getUserById(@PathVariable Long id) {
    // Logic to get a user by id
    User user = userService.findById(id);
    if (user != null) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
```

##### @PostMapping
- Used to define a URL mapping and the HTTP POST method for a particular handler method in a controller.
```java
@PostMapping("/users")
public ResponseEntity<User> createUser(@RequestBody User user) {
    User savedUser = userService.save(user);
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
}
```

##### @PutMapping
- Used to define a URL mapping and the HTTP PUT method for a particular handler method in a controller.
```java
@PutMapping("/users/{id}")
public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
    User updatedUser = userService.update(id, user);
    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
}
```

##### @DeleteMapping
- Used to define a URL mapping and the HTTP DELETE method for a particular handler method in a controller.
```java
@DeleteMapping("/users/{id}")
public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
```

##### @PatchMapping
- Used to define a URL mapping and the HTTP PATCH method for a particular handler method in a controller.
```java
@PatchMapping("/users/{id}")
public ResponseEntity<User> partiallyUpdateUser(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
    User updatedUser = userService.partialUpdate(id, updates);
    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
}
```

##### @PathVariable
- Used to bind a method parameter to a URI template variable.
```java
@GetMapping("/users/{id}")
public ResponseEntity<User> getUserById(@PathVariable Long id) {
    // Logic to get a user by id
}
```

##### @RequestBody
- Used to bind the body of a web request to a method parameter.
```java
@PostMapping("/users")
public ResponseEntity<User> createUser(@RequestBody User user) {
    // Logic to create a new user
}
```

##### @RequestParam
- Used to bind a web request parameter to a method parameter.
```java
@GetMapping("/users")
public ResponseEntity<List<User>> getUsers(@RequestParam(value = "name", required = false) String name) {
    // Logic to get users, optionally filtered by name
}
```

##### @RestController
- A convenience annotation that combines `@Controller` and `@ResponseBody`. It indicates that the class handles RESTful web services.
```java
@RestController
@RequestMapping("/api")
public class UserController {
    // Handler methods
}
```



#### 2. What is DTO, VO, Payload, PO, model, DAO?

##### DTO (Data Transfer Object)

- An object that carries data between processes.
- Used to **transfer data** between server and client or between different layers of an application.
- Usually contain **no business logic**, just hold data.

##### VO (Value Object):

- an object that represents a value(have no identity) and is **immutable**. It is often used to describe domain models in Domain-Driven Design (DDD).

##### Payload:

- Referring to the body of the request or response message, contains the actual data sent or received in an HTTP request or response.

##### PO (Persistent Object):

- an object that is mapped to a database table and is managed by an ORM (Object-Relational Mapping) framework like Hibernate. 
- POs are used to represent and manage the **data that is persisted in a database**.

##### Model:

- Represents the **data and business logic** of an application, often forming the core of the MVC (Model-View-Controller) design pattern.

- Can be a combination of POJOs (Plain Old Java Objects), entities, and business logic components.

##### DAO (Data Access Object):

- An object that provides an abstract interface to some type of database or other persistence mechanism.
- Encapsulates the logic, like typically contain methods for CRUD operations.



#### 3. What is @JsonProperty("description_yyds")

- The `@JsonProperty` annotation is part of the Jackson library, which is a popular library for processing JSON data in Java. This annotation is used to specify the exact JSON property name to map to a Java field or method when serializing and deserializing JSON data.

```java
public class Item {
    private String description;

    @JsonProperty("description_yyds")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description_yyds")
    public void setDescription(String description) {
        this.description = description;
    }
}

```
The JSON will be with the key
```json
{
    "description_yyds": "xxxx"
}
```



#### 4. Explain the purpose of following dependency?

```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.13.3</version>
    <scope>compile</scope>
</dependency>
```

The provided dependency is for the Jackson library, specifically the `jackson-databind` module.

It contains basic data binding (mapping) functionality that allows for reading JSON content into Java Objects (POJOs) and JSON Trees (JsonNode), as well as writing Java Objects and trees as JSON.

Example:

```java
import com.fasterxml.jackson.databind.ObjectMapper;

public class Example {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            
            // Creating a sample object
            User user = new User();
            user.setId(1L);
            user.setName("Alice");
            user.setEmail("alice@example.com");

            // Serializing Java object to JSON
            String jsonString = objectMapper.writeValueAsString(user);
            System.out.println("Serialized JSON: " + jsonString);

            // Deserializing JSON to Java object
            User deserializedUser = objectMapper.readValue(jsonString, User.class);
            System.out.println("Deserialized User: " + deserializedUser.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class User {
    private Long id;
    private String name;
    private String email;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
	`
```



#### 5. What is spring-boot-stater?

1. what dependencies in the below starter? do you know any starters?
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

 A set of convenient dependency descriptors you can include in your application to quickly get started with various technologies and functionalities.

It provide **pre-configured sets of dependencie**s that help you quickly set up and develop specific types of applications. 

- spring-boot-starter-data-jpa
- spring-boot-starter-security
- spring-boot-starter-test
- spring-boot-starter-data-mongodb



#### 6. Explain @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?

- @RequestMapping(value = "/users", method = RequestMethod.POST)

  Define a HTTP Post request with URL ".../users"

- @RequestMapping(value = "/users", method = RequestMethod.GET)

- @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)

- @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)



#### 7. What is ResponseEntity? why do we need it?

```java
new ResponseEntity<>(postResponse, HttpStatus.OK);
new ResponseEntity<>(postResponse, HttpStatus.CREATED);
ResponseEntity.ok(postService.getPostById(id));	
```

`ResponseEntity` is a class in the Spring Framework that represents an HTTP response, including the status code, headers, and body. It is used to customize the entire HTTP response, providing greater control over the response returned to the client.

Why?

-  customize the response fully
- Flexible Return Type
- Error Handling:  return error messages with appropriate HTTP status codes.



#### 8. What is ResultSet in jdbc? and describe the flow how to get data using JDBC 

It represents the **result set of a query** made to a database. 
`ResultSet` provides methods to access the data returned by a database query, including methods to iterate through the rows of the result set and retrieve column values for the current row.

Flow:

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
      
        // establish database connection
        connection = DriverManager.getConnection(jdbcUrl, username, password);
        System.out.println("Connected to the database.");
        
        statement = connection.createStatement();
        
      	// create statement and sql query
        String sql = "SELECT * FROM users";
      	// execute query and get ResultSet
        resultSet = statement.executeQuery(sql);

        // fetch data
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



#### 9. Compare Spring Data JPA vs Hibernate vs JDBC.

|                      | Spring Data JPA   | Hibernate         | JDBC   |
| -------------------- | ----------------- | ----------------- | ------ |
| Level of abstraction | High              | Medium to High    | Low    |
| Boilerplate code     | Minimal           | Moderate          | High   |
| Trasaction           | Built-in          | Built in          | Manual |
| Query                | naming convention | naming convention | manual |



#### 10. Learn how to use ObjectMapper by this example.

https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/exercise/oa/api/FoodOutletJackson.java



#### 11. What is the serialization and desrialization?

https://hazelcast.com/glossary/serialization/

**Serialization** is the process of converting an object or data structure into a format that can be easily stored or transmitted.

**Deserialization** is the reverse process of serialization. It involves converting a byte stream or a formatted text (e.g., JSON, XML) back into an object or data structure.

#### 12. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].

```java
int[] array = new int[]{20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
Double ave = Arrays.stream(array).average().orElse(0.0);
```



#### 13. 抄写并理解 

https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageable 下的代码



#### 14. 抄写并理解 

https://github.com/TAIsRich/springboot-redbook/tree/04_comment 下的代码
