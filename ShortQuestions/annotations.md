# AnnoTations
### @JsonProperty
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
### @RequestMapping
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
### @Entity
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

### @Id
- Specifies the primary key of an entity.
```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

### @GeneratedValue
- Specifies the generation strategy for the primary key.
```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

### @Column
- Specifies the mapping between a field and a column in the database.
```java
@Column(name = "user_name", nullable = false, length = 50)
private String name;
```

### @Table
- Specifies the table name in the database that the entity maps to.
```java
@Entity
@Table(name = "users")
public class User {
    // fields, getters, setters
}
```

### @Repository
- Indicates that the class is a Spring Data repository.
```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
```

### @Query
- Defines a custom query directly on the repository method.
```java
@Query("SELECT u FROM User u WHERE u.email = :email")
User findByEmail(@Param("email") String email);
```


### @Transactional
- Indicates that the method or class should be executed within a transactional context.
```java
@Transactional
public void someTransactionalMethod() {
    // method implementation
}
```


### @CreatedDate
- Used in conjunction with Spring Data JPA Auditing to automatically populate date fields.
```java
@CreatedDate
private LocalDateTime createdDate;
```

### @LastModifiedDate
- Used in conjunction with Spring Data JPA Auditing to automatically populate date fields.
```java
@LastModifiedDate
private LocalDateTime lastModifiedDate;
```
### @JoinColumn
- Specifies the foreign key column for an entity relationship.
```java
@ManyToOne
@JoinColumn(name = "user_id")
private User user;
```
Sure, here are additional Spring annotations, particularly those used in Spring MVC and Spring Data REST, in the specified format:

### @GetMapping
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

### @PostMapping
- Used to define a URL mapping and the HTTP POST method for a particular handler method in a controller.
```java
@PostMapping("/users")
public ResponseEntity<User> createUser(@RequestBody User user) {
    User savedUser = userService.save(user);
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
}
```

### @PutMapping
- Used to define a URL mapping and the HTTP PUT method for a particular handler method in a controller.
```java
@PutMapping("/users/{id}")
public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
    User updatedUser = userService.update(id, user);
    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
}
```

### @DeleteMapping
- Used to define a URL mapping and the HTTP DELETE method for a particular handler method in a controller.
```java
@DeleteMapping("/users/{id}")
public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
```

### @PatchMapping
- Used to define a URL mapping and the HTTP PATCH method for a particular handler method in a controller.
```java
@PatchMapping("/users/{id}")
public ResponseEntity<User> partiallyUpdateUser(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
    User updatedUser = userService.partialUpdate(id, updates);
    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
}
```

### @PathVariable
- Used to bind a method parameter to a URI template variable.
```java
@GetMapping("/users/{id}")
public ResponseEntity<User> getUserById(@PathVariable Long id) {
    // Logic to get a user by id
}
```

### @RequestBody
- Used to bind the body of a web request to a method parameter.
```java
@PostMapping("/users")
public ResponseEntity<User> createUser(@RequestBody User user) {
    // Logic to create a new user
}
```

### @RequestParam
- Used to bind a web request parameter to a method parameter.
```java
@GetMapping("/users")
public ResponseEntity<List<User>> getUsers(@RequestParam(value = "name", required = false) String name) {
    // Logic to get users, optionally filtered by name
}
```

### @RestController
- A convenience annotation that combines `@Controller` and `@ResponseBody`. It indicates that the class handles RESTful web services.
```java
@RestController
@RequestMapping("/api")
public class UserController {
    // Handler methods
}
```

### @Test
- To run Junit Tests
```java
    @Test
    public void testArrays() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
    //...
    }
```
### @Override
- To override a method from inherited class
```java
    @Override
    public PostDto createPost(PostDto postDto) {
    // step1 create object "Post"
    }
```

