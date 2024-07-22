# AnnoTations
### @Aspect
- Used to declare a class as an aspect, which contains advice methods that apply cross-cutting concerns. This annotation is a marker that indicates the class contains methods annotated with advice annotations like `@Before`, `@After`, etc.
```java
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // This class is an aspect
}
```

### @Before
- Used to declare advice that runs before the matched join point method execution. It is typically used to perform actions like logging, security checks, etc., before the main logic of the method is executed.
```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.service.UserService.createUser(..))")
    public void logBeforeMethod() {
        System.out.println("A user is about to be created.");
    }
}
```

### @After
- Used to declare advice that runs after the matched join point method execution, regardless of its outcome (whether it returns normally or throws an exception). This is useful for tasks such as cleanup or logging the completion of a method.
```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @After("execution(* com.example.service.UserService.createUser(..))")
    public void logAfterMethod() {
        System.out.println("The user creation process has finished.");
    }
}
```

### @AfterReturning
- Used to declare advice that runs after the matched join point method returns normally (i.e., without throwing an exception). This is useful for logging the return value or processing the result of a method.
```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @AfterReturning(pointcut = "execution(* com.example.service.UserService.createUser(..))", returning = "result")
    public void logAfterReturning(Object result) {
        System.out.println("User created successfully with result: " + result);
    }
}
```

### @AfterThrowing
- Used to declare advice that runs after the matched join point method exits by throwing an exception. This is useful for logging exceptions or performing error handling.
```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @AfterThrowing(pointcut = "execution(* com.example.service.UserService.createUser(..))", throwing = "error")
    public void logAfterThrowing(Throwable error) {
        System.out.println("An error occurred during user creation: " + error.getMessage());
    }
}
```

### @Around
- Used to declare advice that runs around the matched join point method execution. This advice has control over when (or if) the method is executed. It can be used for tasks like performance monitoring, transaction management, etc.
```java
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.example.service.UserService.createUser(..))")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before creating user");
        Object result = joinPoint.proceed(); // Proceed with the method execution
        System.out.println("After creating user");
        return result;
    }
}
```

### @Pointcut
- Used to declare and reuse pointcut expressions. It is typically defined as an empty method annotated with `@Pointcut`, and the pointcut expression is used to specify where advice should be applied.
```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.example.service.UserService.createUser(..))")
    public void createUserPointcut() {
        // Pointcut expression
    }

    @Before("createUserPointcut()")
    public void logBeforeMethod() {
        System.out.println("A user is about to be created.");
    }
}
```

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



## Testing
### @BeforeAll
- Used to declare a static method that will be executed once before all test methods in the current class. This is typically used to set up static resources or perform expensive setup operations that need to be done only once.
```java
import org.junit.jupiter.api.BeforeAll;

public class ExampleTest {
    @BeforeAll
    public static void initAll() {
        // Code to set up resources shared across all tests
    }
}
```

### @BeforeEach
- Used to declare a method that will be executed before each test method. This is typically used to set up the test environment for each test case.
```java
import org.junit.jupiter.api.BeforeEach;

public class ExampleTest {
    @BeforeEach
    public void init() {
        // Code to set up resources before each test
    }
}
```

### @Test
- Used to declare a method as a test method. This method contains the logic to be tested.
```java
import org.junit.jupiter.api.Test;

public class ExampleTest {
    @Test
    public void testMethod() {
        // Code for the test case
    }
}
```

### @AfterEach
- Used to declare a method that will be executed after each test method. This is typically used to clean up resources used during the test.
```java
import org.junit.jupiter.api.AfterEach;

public class ExampleTest {
    @AfterEach
    public void tearDown() {
        // Code to clean up resources after each test
    }
}
```

### @AfterAll
- Used to declare a static method that will be executed once after all test methods in the current class. This is typically used to clean up static resources or perform final clean-up operations.
```java
import org.junit.jupiter.api.AfterAll;

public class ExampleTest {
    @AfterAll
    public static void tearDownAll() {
        // Code to clean up resources shared across all tests
    }
}
```
### @Mock
- Creates a mock object of the annotated class
```java
@RunWith(MockitoJUnitRunner.class) 
class StudentTest { 

	@Mock
	Pen pen;
	@Test
	public void writeWithPenTest() throws Exception { 
		Mockito.when(pen.getRedPen()).thenReturn("Red Pen");
	} 

}

```
### @InjectMocks
- Creates and instance of the class and mocks that created using @Mock
- Doesn't even need to initialize the class
```java
// student need a pen
class Student { 

	private Pen pen; 

	public Student(Pen pen) { 
		this.pen = pen; 
	} 

	public String write() { 
		return "Student Write with: " + pen.getRedPen(); 
	} 

}

// then
@RunWith(MockitoJUnitRunner.class)
class StudentTest {

    @Mock
    Pen pen;

    @InjectMocks
    Student student;

    @Test
    public void writeWithPenTest() throws Exception {
        Mockito.when(pen.getRedPen()).thenReturn("Red Pen");
        assertEquals("Student Write with: Red Pen", student.write());
    }

}

```

### `@Mock`
- `@Mock` is used to create a mock object. A mock object is a simulated object that mimics the behavior of real objects in controlled ways. Mocks are used to isolate the class under test by simulating its dependencies.
-  By default, all methods of a mock return either null, zero, or false, depending on the return type. You can specify the behavior of the mock's methods using `Mockito.when()`.

```java
@RunWith(MockitoJUnitRunner.class)
public class SomeTest {

    @Mock
    private List<String> mockedList;

    @Test
    public void testMock() {
        Mockito.when(mockedList.get(0)).thenReturn("Mocked Element");

        assertEquals("Mocked Element", mockedList.get(0));
        assertNull(mockedList.get(1)); // by default, other methods return null
    }
}
```

### `@Spy`
- `@Spy` is used to create a spy object. A spy object is a real instance of a class, but its methods can be stubbed. This means you can call real methods on the spy object while still having the ability to override specific methods.
- By default, all methods of a spy call the real methods unless they are stubbed. This allows for partial mocking, where you can mock specific methods and let others behave as normal.

```java
@RunWith(MockitoJUnitRunner.class)
public class SomeTest {

    @Spy
    private List<String> spiedList = new ArrayList<>();

    @Test
    public void testSpy() {
        spiedList.add("Real Element");
        Mockito.doReturn("Spied Element").when(spiedList).get(0);

        assertEquals("Spied Element", spiedList.get(0)); // stubbed method
        assertEquals(1, spiedList.size()); // real method
    }
}
```
