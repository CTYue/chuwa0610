# Annotations in Spring Boot
##  create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.

### @Entity
Marks a class as a JPA entity.

**Usage:**
```java
@Entity
public class User {
}
```

### @Table
Specifies the table in the database that corresponds to the entity.
**Usage:**
```java
@Entity
@Table(name = "users")
public class User {
}
```

### @Id
Marks a field as a primary key.
**Usage:**
```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
```

### @GeneratedValue
Specifies the generation strategy for primary keys.
**Usage:**
```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
```

## @Column
Specifies the details of a column in the table.
**Usage:**
```java
@Entity
public class User {
    @Column(name = "user_name", nullable = false)
    private String name;
}

```


## @RestController
Combines @Controller and @ResponseBody. Used to create RESTful web services.
**Usage:**
```java
@RestController
@RequestMapping("/api/users")
public class UserController {
    @GetMapping
    public List<User> getAllUsers() {
        // ...
    }
}
```

## @RequestMapping
Maps HTTP requests to handler methods.
**Usage:**
```java
@RestController
@RequestMapping("/api/users")
public class UserController {
    @GetMapping
    public List<User> getAllUsers() {
        // ...
    }
}
```

## @GetMapping
Shortcut for @RequestMapping(method = RequestMethod.GET).
**Usage:**
```java
@GetMapping
public List<User> getAllUsers() {
    // ...
}
```

## @PostMapping
Shortcut for @RequestMapping(method = RequestMethod.POST).
**Usage:**
```java
@PostMapping
public List<User> getAllUsers(@RequestBody User user) {
    // ...
}
```

## @PutMapping
Shortcut for @RequestMapping(method = RequestMethod.PUT).
**Usage:**
```java
@RestController
@RequestMapping("/api/users")
public class UserController {
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        // ...
    }
}

```



## 2.explain how the below annotaitons specify the table in database?

```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
  
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;

```

in the first line of annotation Specifies a default value for the column.
in the second line of annotation Specifies the column name as STUDENT_NAME.length maximum can be 50 char, and it is not null and it is not unique.


## 3.Layers in Spring Boot Application
What is the default column names of the table in database for  @Column ?
```java
@Column
private String firstName;
@Column
private String operatingSystem;
```
it will create two column which is firstName and operatingSystem.



## 4.  What are the layers in springboot application? what is the role of each layer?
- Controller Layer -> Handles HTTP requests and responses.
- Service Layer -> Contains business logic.
- Data Access Layer and Entity Layer -> read and write data to database Contains entity classes that map to database tables.


## 5.Describe the flow in all of the layers if an API is called by Postman. 
- when we first request get, put, post, delete,or patch it handle by api layer which is controller layer, after that it go in to service (business logic layer), after that we can read from database or write to database using Data Access Layer and Entity Layer.

## 6.  What is the application.properties? do you know application.yml?
in the application properties file it Used to configure Spring Boot applications, for example connecting to database.
```properties
server.port= port number 
spring.datasource.url= databse url
spring.datasource.username= user name 
spring.datasource.password= password
```
you can also use yaml version of the setup.
```yaml
server:
  port: port number

spring:
  datasource:
    url: databse url
    username: user name
    password: password
```
