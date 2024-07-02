## 1 annotations l learn - list
### （1）core annotations
- @SpringBootApplication ( include: @SpringBootConfiguration、@EnableAutoConfiguration  @ComponentScan)
- start up application - code example
```java
@SpringBootApplication
public class MySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }
}
```
### （2）Configuration annotations、
- @Configuration
- usage:  Marks a class as a configuration class, which is equivalent to an XML configuration file.

```java
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}
```

### （3）Component Scan Annotation
- @ComponentScan ： Automatically scan the classes or interfaces under the specified path and register the classes with specific annotations into Spring's IoC container. These automatically assembled annotations include @Controller, @Service, @Component, @Repository, etc.
- @Controller, @Service,  @Repository, @Component,
- code example： 
```java
@ComponentScan(basePackages = "com.example")
public class AppConfig {
}
```

###  (4) annotation of  data access
- @Entity:  map a class to a table in database
- @Table: Specify the details for JPA entities that map to tables in the database
- @Id: Specifies the primary key of the entity.
- @GeneratedValue:  Specify the primary key generation strategy
- @Repository: Marks the data access component.
```java 
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
```

```java

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

```
### component of controller layer
- @Controller: mark a component of controller layer, return view 
```java
@Controller
public class MyController {
    // Return data
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello, World!";
    }
    // return view
    @GetMapping("/page")
    public String page() {
        return "home";  // 返回视图名称，视图解析器会解析到具体的页面
    }

}
```
- @RestController:  Combined annotation, including @Controller and @ResponseBody. return data, like JSON, XML
```java
@RestController
public  class MyRestController{
    @GetMapping("/hello")
    public  String hello() {
        return "hello, world";
    }
}
```
- @GetMapping, @PostMapping,@PutMapping,@DeleteMapping
- @PathVariable: Bind URL path variables to method parameters.
```java
@GetMapping("/user/{id}")
public String getUser(@PathVariable("id") Long id) {
    return "User ID: " + id;
}
```
-  @RequestParam：Bind URL request parameter to method parameters
```java
@GetMapping("/items")
    public String getItems(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        return "Fetching items for page: " + page + " with size: " + size;
    }
```
- @RequestBody： Bind the request body to the method parameters. Only for post requests, which have a request body.
```java
@PostMapping("/json")
public String json(@RequestBody MyRequest request) {
    return "Request body: " + request;
}
```

### Transactional annotation
- @Transactional: Ensure that multiple database operations within a method either succeed or fail at the same time.
- ensure ACID principle

### @Autowired: inject a object from AOC container, then we can use it in class


## 2  explain how the below annotaitons specify the table in database?
```java
// name property in class corresponding to column definition in database
// The maximum length is 255, the column default value John Snow, 
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;

// The attribute studentName in the entity class corresponds to STUDENT_NAME in the database
// length=50, The maximum length is 50
// nullable=false: the column does not allow nulls.
// unique=false:  the column can be repeated and unique value constraint is not required.
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
``` 

## 3 What is the default column names of the table in database for @Column ?
- When using the @Column annotation, if you do not specify the name attribute, the column name in the database table will correspond to the attribute name in the entity class.
```java
@Column
private String firstName;
@Column
private String operatingSystem;
```
## 4. What are the layers in springboot application? what is the role of each layer?
- A software architecture design style, divided into three layers,
- 1.Controller Layer：Processes client requests and responses, is responsible for receiving user input, calling business logic to process requests, and returns responses.
- 2.Service Layer:The business logic of the application, handling business rules, data processing and other complex processing tasks
- 3.Data Access Layer(DAO layer): Responsible for interacting with databases or other data stores, performing data operations and persistence
## 5. Describe the flow in all of the layers if an API is called by Postman.
- The controller layer receives and parses HTTP requests. 
- The service layer executes business logic and call the data access layer. 
- The data access layer interacts with the database and performs data operations. 
- Returns the response, and the controller layer builds the HTTP response and returns it to
## 6. What is the application.properties? do you know application.yml?
- application.properties   application.yml  are both Configuration file in spring application.
- It uses a key-value pair format and usually stores application configuration information, such as database connection, server port, log level, etc.
- application.properties:  structure is not so clear.
- application.yml: structure is very clear and simple
  ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/db0a86bd-8f1e-42bd-882d-3e9925b71d41/1808083f-05ae-41ca-838b-b180facb0187/Untitled.png)