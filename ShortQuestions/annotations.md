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
### @SpringbootApplication
- It is a combination of 3 annotations @Configuration, @EnableAutoConfiguration, and @ComponentScan
- It is used to mark a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning.
- Usually put in the main class
```java
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
```
### @Configuration
- Used to indicate that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.
```java
@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
        dataSource.setUsername("user");
        dataSource.setPassword("password");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

```
### @Beam
- This bean will be managed by the Spring container, making it available for dependency injection throughout the application.
```java
@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
        dataSource.setUsername("user");
        dataSource.setPassword("password");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

```
## @ComponentScan
- Used to allow Spring to scan the specified packages and register the beans with the Spring application context automatically.
-  usually annotated with @Configuration
```java
@Configuration
@ComponentScan(basePackages = "com.example.myapp")
public class AppConfig {
    // Other bean definitions
}

```

### @EnableAutoConfiguration
- Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. It attempts to configure your Spring application automatically based on the dependencies you have added.

```java
@EnableAutoConfiguration
public class MyApp {
// Application code
}
```
### @Component
- A generic stereotype for any Spring-managed component.
- Can be used to annotate any class to make it a Spring bean.
- No specific additional behavior is associated with it beyond making the class a Spring bean.
```java
@Component
public class MyComponent {
    public void perform() {
        System.out.println("Performing task");
    }
}
```
### @Service
- A specialization of @Component indicating that the annotated class is a service component.
- Used for service layer components, which usually contain business logic.
- No specific additional behavior, but it provides better readability and clarity regarding the class's role in the application.
```java
@Service
public class MyService {
  public void executeService() {
    System.out.println("Executing service");
  }
}
```
### @Repository
-  A specialization of @Component indicating that the annotated class is a repository (or DAO).
- Used for data access layer components.
- In addition to making the class a Spring bean, it also provides exception translation, converting database-related exceptions into Spring's DataAccessException.
```java
@Repository
public class MyRepository {
  public void saveData() {
    System.out.println("Saving data");
  }
}
```
### @Controller
- A specialization of @Component indicating that the annotated class is a web controller.
- Used for presentation layer components, specifically to define web controllers in Spring MVC.
- Used in conjunction with Spring MVC to map web requests to handler methods.
```java
@Controller
public class MyController {
    @GetMapping("/foo")
    public String foo() {
        return "foo";
    }
}
```
### @Autowired
- Used to automatically wire a bean to a class field, constructor, or setter method.
- By default, it wires by type. If multiple beans of the same type are available, an exception is thrown
```java
@Component
public class MyComponent {
  @Autowired
  private MyService myService;

  public void doSomething() {
    myService.performService();
  }
}

```
### @Qualifier
-  Used to resolve the ambiguity when multiple beans of the same type are available by specifying the exact bean to be injected.
- Works in conjunction with @Autowired to provide more fine-grained control over which bean should be injected.
```java
@Component
public class MyComponent {
    @Autowired
    @Qualifier("specificService")
    private MyService myService;

    public void doSomething() {
        myService.performService();
    }
}

//=============================================================
@Service("specificService")
public class SpecificService implements MyService {
  public void performService() {
    System.out.println("Specific Service");
  }
}

@Service("anotherService")
public class AnotherService implements MyService {
  public void performService() {
    System.out.println("Another Service");
  }
}

```
### @Resource
- annotation for dependency injection. It can be used similarly to @Autowired, but it wires by name by default.
```java
@Component
public class MyComponent {
    @Resource(name = "specificService")
    private MyService myService;

    public void doSomething() {
        myService.performService();
    }
}
```
### @Primary
- Indicates that a bean should be given preference when multiple candidates qualify for autowiring.
- Works with @Autowired to resolve ambiguity by marking one bean as the primary candidate for dependency injection.
```java
@Service
@Primary
public class PrimaryService implements MyService {
    public void performService() {
        System.out.println("Primary Service");
    }
}

@Service
public class SecondaryService implements MyService {
    public void performService() {
        System.out.println("Secondary Service");
    }
}

@Component
public class MyComponent {
    @Autowired
    private MyService myService;

    public void doSomething() {
        myService.performService(); // Will use PrimaryService
    }
}

```
### @Inject
- Works similarly to @Autowired, injecting by type. It does not have Spring-specific features like @Qualifier.
```java
@Component
public class MyComponent {
    @Inject
    private MyService myService;
}

```
### @PropertySource
- Used to specify the location of a properties file to be loaded into the Spring Environment. This is useful for externalizing configuration and injecting properties into Spring beans.
```java
@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Value("${my.property}")
    private String myProperty;

    @Bean
    public MyBean myBean() {
        return new MyBean(myProperty);
    }
}
```

### @EnableTransactionManagement
- Enables Spring's annotation-driven transaction management capability, allowing the use of `@Transactional` annotations in service layer methods to manage transactions.
```java
@Configuration
@EnableTransactionManagement
public class AppConfig {
    
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    
    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource("jdbc:h2:mem:testdb");
    }
}
```

### @EnableWebMvc
- Enables Spring's MVC support in a Java-based configuration. It imports the Spring MVC configuration, which sets up the DispatcherServlet, enables default MVC components, and allows the use of `@Controller` annotations.
```java
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.web")
public class WebConfig implements WebMvcConfigurer {
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
    
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }
}
```

## Validations
### @NotNull
- Ensures the annotated field is not null.
```java
@NotNull(message = "ID cannot be null")
private Long id;
```
### @NotEmpty
-  Ensures the annotated field is not empty (not null and not empty string).
```java
@NotEmpty(message = "Name cannot be empty")
private String name;

```
### @NotBlank
- Ensures the annotated field is not blank (not null and trimmed length > 0).
```java
@NotBlank(message = "Name cannot be blank")
private String name;
```
### @Size
-  Ensures the annotated field has a size between the specified min and max values.
```java
@Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
private String name;
```
### @Min
- Ensures the annotated field has a value not less than the specified minimum.
```java
@Min(value = 18, message = "Age should not be less than 18")
private int age;
```
### @Max
- Ensures the annotated field has a value not more than the specified maximum.
```java
@Max(value = 100, message = "Age should not be more than 100")
private int age;
```
### @Email
- Ensures the annotated field is a valid email address.
```java
@Email(message = "Email should be valid")
private String email;

```
### @Past
- : Ensures the annotated field represents a date in the past.
```java
@Past(message = "Date of birth must be in the past")
private LocalDate dateOfBirth;
```
### @Future
-  Ensures the annotated field represents a date in the future.
```java
@Future(message = "Appointment date must be in the future")
private LocalDate appointmentDate;
```

