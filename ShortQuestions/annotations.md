# 1. Annotaions Used by Entity

- @Entity: Specifies that the class is an entity and is mapped to a database table.
```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    // getters and setters
}
```

- @Id: Marks a field as the primary key.
```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

- @GeneratedValue: Defines how the primary key is generated.
```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

- @Column: Maps a field to a database column.
```java
@Column(name = "user_name", nullable = false)
private String name;
```

# 2. Controller Annotations

- @RestController: Marks a class as a REST Controller

- @RequestMapping: Maps web requests to methods.

- @GetMapping: Map GET Requests
```java
@RestController
@RequestMapping("/api/users")
public class UserController {
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        // logic
    }
}
```

- @PostMapping: Map POST Requests
```java
@PostMapping
public User createUser(@RequestBody User user) {
    // logic
}
```

- @PutMapping: Map PUT Requests
```java
@PutMapping
public User updateUser(@PathVariable Long id, @RequestBody User user) {
    // logic
}
```

- @DeleteMapping: Map DELETE Requests
```java
@DeleteMapping("/{id}")
public void deleteUser(@PathVariable Long id) {
    // logic
}
```

- @PathVariable: Binds method parameters to path variables.

- @RequestBody: Binds method parameters to the request body.

# 3. Annotations in Service Layers

- @Service: Marks a class as a service provider

- @Component: Generic stereotype for any Spring-managed component.

- @Repository: Marks a class as a Data Access Object.

# 4. General Annotations

- @Override: Indicates that a method overrides a method in a superclass.

- @Autowired: Marks a constructor, field, setter method, or config method as to be autowired by Spring's dependency injection facilities.

# 5. @Transactional

- Indicates that the method or class should be executed within a transactional context.

# 6. @CreatedDate

- Used in conjunction with Spring Data JPA Auditing to automatically populate date fields

# 7. LastModifiedDate

- Used in conjunction with Spring Data JPA Auditing to automatically populate date fields.

# 8. @Test

- To run Junit Tests

# 9. @SpringbootApplication

- It is a combination of 3 annotations @Configuration, @EnableAutoConfiguration, and @ComponentScan
- It is used to mark a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning.