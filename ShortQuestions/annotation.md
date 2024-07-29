# Annotation

## Spring Data JPA Annotations (Java Persistence API - JPA)
### @Entity
- Marks a class as a database table.
### @Table
- Used with `@Entity` to specify the table in the database with which the entity is mapped. Optionally specify the name of the table if it differs from the name of the entity class.
### @UniqueConstraint(columnNames = {"title"})
- Often included within `@Table` annotation to indicate a unique constraint on specific columns.
```java
@Entity
@Table(
        name = "posts",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title"})
        }
)
```
### @Id
- Marks a field as the primary key of an entity.
### @GeneratedValue
- Specifies the strategy for generating primary key values.
```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
// IDENTITY relies on a database identity column to generate a primary key
```
### @Column
- Specify the details of a column in a database table, such as name, nullable, length.
```java
@Column(name= "title", unique = true, nullable = false)
private String title;
```
### @Transient
- Indicate that a field is not to be persisted in the database.
### @CreatedDate
- Marks a field to be filled automatically with the date when the entity is created.
```java
@CreatedDate
private LocalDateTime createDateTime;
```
### @UpdateTimestamp
- Automatically update a timestamp field whenever the database record is updated.
```java
@UpdateTimestamp
private LocalDateTime updateDateTime;
```

## Controller Annotations (Spring MVC)

### @SpringBootApplication
- Place on the main application class to define the Spring Boot application.
```java
@SpringBootApplication
public class XhsApplication {
	public static void main(String[] args) {
		SpringApplication.run(XhsApplication.class, args);
	}
}
```
### @Repository
- Used at the persistence layer, which will act as a repository. Annotate a class to indicate that it's a DAO component, which will be automatically detected by Spring through classpath scanning.
```java
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    //no code needed here.
}
```
### @Service
- Used to annotate classes at the service layer. Indicates that a class holds business logic and calls methods in the repository layer.
```java
@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    public PostServiceImpl(//...);
    @Override
    public PostDto createPost(PostDto postDto) {
        //step 1: create object "Post"  
        //step 2: connect to DB and save object "Post"
    }
}
```
### @RestController
- (`@RestController = @Controller + @ResponseBody`) It is a specialized version of the @Controller annotation that includes the @ResponseBody annotation. This means that it's designed for building RESTful web services where the response body of a method is serialized directly into the response format (usually JSON or XML). Annotate a class to define it as a controller where every method returns a domain object instead of a view.
### @RequestMapping
- Maps HTTP requests to handler methods of MVC and REST controllers.
### @Autowired
- Used for dependency injection. This annotation allows Spring to resolve and inject collaborating beans into your bean. Automatically inject a bean with @Autowired on a class constructor, setter method, or field.
### @PostMapping
- A shortcut for @RequestMapping(method = RequestMethod.POST). Tells Spring to deserialize the JSON or XML payload of an incoming request to a Java object. Used to map HTTP POST requests onto specific handler methods.
```java
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto response = postService.createPost(postDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
```
### @GetMapping
### @PutMapping
### @DeleteMapping

### @Qualifier
- eliminate the issue of which bean needs to be injected
```java
public class FooService {
     //  we can avoid ambiguity when Spring finds multiple beans of the same type.
    @Autowired
    @Qualifier("fooFormatter")
    private Formatter formatter;
}
```
### @Primary
- decide which bean to inject when ambiguity is present regarding dependency injection. This annotation defines a preference when multiple beans of the same type are present. The bean associated with the @Primary annotation will be used unless otherwise indicated.
```java
// In this example, both methods return the same Employee type. The bean that Spring will inject is the one returned by the method tonyEmployee. This is because it contains the @Primary annotation. This annotation is useful when we want to specify which bean of a certain type should be injected by default.
@Configuration
public class Config {
 
    @Bean
    public Employee johnEmployee() {
        return new Employee("John");
    }
 
    @Bean
    @Primary
    public Employee tonyEmployee() {
        return new Employee("Tony");
    }
}
```
### @Resource
- @Resource is the annotation that will help to extract beans from the container.
```java
@Configuration
public class ApplicationContext {
 
    // Put the bean into the spring container
    @Bean(name = "userFile")
    public File userFile() {
        File file = new File("user.txt");
        return file;
    }
}

@Service
class UserService {

    // Ask the container to get the bean and 'put' it here (inject)
    @Resource(name = "userFile")
    private File userFile;

}
```

### @Transactional
- define the boundaries of a transaction in a declarative way. This means that the developer doesn't have to manually handle transaction beginning and ending, and can instead focus on business logic.
```java
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    @Transactional
    public void transferFunds(Account from, Account to, BigDecimal amount) {
        from.debit(amount);
        to.credit(amount);
        accountRepository.save(from);
        accountRepository.save(to);
    }
}
```
### @Bean
- The @Bean annotation is used within @Configuration annotated classes to declare a Spring bean.
```java
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyService();
    }

    @Bean
    public MyController myController() {
        // Injecting MyService into MyController
        return new MyController(myService());
    }
}
```
### @Component
- @Component is a generic stereotype for any Spring-managed component. Other annotations like @Repository, @Service, and @Controller are specializations of @Component for more specific use cases.
### @Controller
- @Controller is used to mark classes as Spring MVC Controllers. This component handles HTTP requests and returns HTTP responses.
```java
@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";  // Name of the view to render
    }
}
```
### @ControllerAdvice
- Used to handle exceptions across the whole application.
```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleException(Exception e) {
        return "An error occurred: " + e.getMessage();
    }
}
```

### @SpringBootApplication
- @SpringBootApplication is a convenience annotation that adds all the following: @Configuration, @EnableAutoConfiguration, @ComponentScan.
### @Configuration
- Declares a class as the source for bean definitions
### @EnableAutoConfiguration
- Allows the application to add beans using classpath definitions
### @ComponentScan
- Used to specify the packages that Spring should scan for components, configurations, and services. Essentially, it tells Spring where to look for annotated classes that it should manage, like @Component, @Service, @Repository, and @Controller among others.
```java
@Configuration
@ComponentScan(basePackages = "com.example.demo.services")
public class AppConfig {
    // Additional configuration or bean definitions can go here
}
```

## Spring Data Query Annotations
### @Query
- Allows you to define a custom query using JPQL or SQL, which will be executed to retrieve data from the database. It can be used on repository methods.
### @Param
- Used in conjunction with @Query, it allows you to pass parameters to your custom queries.
### @Modifying
- Combined with @Query when the query updates or deletes data, requiring modification of the database.

```java
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.lastName = :lastName")
    List<Employee> findByLastName(@Param("lastName") String lastName);

    @Modifying
    @Query("UPDATE Employee e SET e.lastName = :lastName WHERE e.id = :id")
    void updateLastName(@Param("id") Long id, @Param("lastName") String lastName);
}
```

## Spring Data MongoDB Annotations
### @Document
- Indicate that a class should be mapped to a MongoDB document.
### @Field
- Specifies a document field to be mapped to a class field. You can customize the name of the document field if it differs from the Java class field name.

## Common Validation Annotations
### @NotNull
- The annotated element must not be null.
### @NotEmpty
- The annotated element must not be null and must contain at least one non-whitespace character.
### @NotBlank
- The annotated element must not be null and must contain at least one non-whitespace character. Useful for strings.
### @Email
- The annotated element must be a valid email address.
### @Size(min=, max=)
- The annotated element size must be between the specified boundaries (if it is a string, the size of the string is evaluated).
### @Min(value)
- The annotated element must be a number whose value must be higher or equal to the specified minimum.
### @Max(value)
- The annotated element must be a number whose value must be lower or equal to the specified maximum.
### @Positive
- The annotated element must be a strictly positive number.
### @PositiveOrZero
- The annotated element must be a positive number or zero.
### @Negative
- The annotated element must be a strictly negative number.
### @NegativeOrZero
- The annotated element must be a negative number or zero.
### @Pattern(regexp)
- The annotated String must match the specified regular expression.
### @Valid
- Cascades validation to associated objects if they are annotated with @Valid.
```java
@RestController
@Validated
public class UserController {

    @PostMapping("/users")
    public String addUser(@Valid @RequestBody User user) {
        // Assuming the business logic processes the user further
        return "User added successfully!";
    }
}

class User {
    @NotBlank(message = "Username must not be blank")
    @Size(min = 5, max = 15, message = "Username must be between 5 and 15 characters")
    private String username;

    // getters and setters
}
```

## Java Dependency Injection
### @Inject
- Used to perform dependency injection in Java applications, allowing you to decouple the configuration and dependencies of your classes from the class code itself.
```java
//The @Inject on the constructor of MessagePrinter tells the DI container to inject an instance of MessageService when creating an instance of MessagePrinter.
public class MessagePrinter {

    private final MessageService messageService;

    @Inject
    public MessagePrinter(MessageService messageService) {
        this.messageService = messageService;
    }

    public void printMessage() {
        System.out.println(messageService.getMessage());
    }
}
```

## Spring Aspect-Oriented Programming (AOP)
First, ensure your Spring project includes AOP dependencies in your pom.xml:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

### @Before
- Run before the method execution

### @After
- Run after the method returned a result

### @AfterReturning
- Run after the method returned a result, intercept the returned result as well.

### @AfterThrowing
- Run after the method throws an exception

### @Around
- Run around the method execution, combine all three advices above, requires `ProceedingJoinPoint` as parameter type in the advice method while above advice annotations requires `JoinPoint` as parameter type.

```java
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Run before the method execution
    @Before("execution(* com.example.service.MessageService.sendMessage(..))")
    public void beforeSendMessage(JoinPoint joinPoint) {
        System.out.println("Before sending message: " + joinPoint.getSignature());
    }

    // Run after the method returned a result
    @After("execution(* com.example.service.MessageService.sendMessage(..))")
    public void afterSendMessage(JoinPoint joinPoint) {
        System.out.println("After sending message: " + joinPoint.getSignature());
    }

    // Run after the method returned a result, intercept the returned result as well
    @AfterReturning(pointcut = "execution(* com.example.service.MessageService.getMessage(..))", returning = "result")
    public void afterReturningGetMessage(JoinPoint joinPoint, String result) {
        System.out.println("After returning from getMessage: " + result);
    }

    // Run after the method throws an exception
    @AfterThrowing(pointcut = "execution(* com.example.service.MessageService.sendMessage(..))", throwing = "ex")
    public void afterThrowingSendMessage(JoinPoint joinPoint, Exception ex) {
        System.out.println("After throwing in sendMessage: " + ex.getMessage());
    }

    // Run around the method execution
    @Around("execution(* com.example.service.MessageService.sendMessage(..))")
    public Object aroundSendMessage(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Before around advice");
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed(); // Continue with method execution
            System.out.println("After around advice (returning)");
        } catch (Throwable ex) {
            System.out.println("After around advice (exception): " + ex.getMessage());
            throw ex;
        }
        return result;
    }
}

```

## Java testing frameworks (JUnit)
### @Test
- indicates that a method is a test method
### @BeforeAll
- annotated method should be run once before all tests in the current test class
### @AfterAll 
- @AfterAll is used to annotate methods that should run once after all tests in the test class have been executed.
### @BeforeEach
- @BeforeEach is used to annotate methods that should be executed before each test is run.
### @AfterEach
- @AfterEach is used to annotate methods that should be run after each test is executed.
```java
public class DatabaseTests {
    static Database db;

    @BeforeAll
    public static void setupDatabase() {
        db = new Database();
        db.connect();
    }

    @Test
    public void testConnection() {
        assertTrue(db.isConnected(), "Database should be connected.");
    }
}
``` 

### @SpringBootTest
- This annotation tells Spring Boot to go and find the main configuration class (one with @SpringBootApplication, for example) and use that to start a Spring application context. @SpringBootTest can be used when a test requires the whole application to be up and running, such as when you're doing end-to-end tests or when the components being tested are tightly integrated with various Spring functionalities.
```java
@SpringBootTest
public class FullApplicationTest {

    @Test
    public void contextLoads() {
        // test whether the application context loads properly
    }
}
```
### @Mock
- @Mock is a Mockito annotation used to create mock instances of objects.
```java
public class ServiceTest {
    
    @Mock
    private Dependency dependency;

    private Service service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        service = new Service(dependency);
    }

    @Test
    public void testServiceMethod() {
        when(dependency.someMethod()).thenReturn("Expected Value");
        assertEquals("Expected Value", service.useDependency());
    }
}
```
### @Spy
- @Spy is another Mockito annotation but, unlike @Mock, it creates a spy on the real objects, meaning it will track all interactions with the spy but still perform the actual operations unless those calls are specifically stubbed to behave otherwise.
```java
public class ComplexServiceTest {

    @Spy
    private ComplexService service = new ComplexService();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testServiceBehavior() {
        doReturn("Mocked").when(service).someComplexMethod();
        assertEquals("Mocked", service.someComplexMethod());
        verify(service).someComplexMethod();
    }
}
```
### @InjectMocks
- @InjectMocks is used to automatically inject mocked or spied dependencies into the class under test. Mockito will attempt to inject fields annotated with @Mock or @Spy into the specified class.
```java
public class SomeServiceTest {

    @Mock
    private Dependency dependency;

    @InjectMocks
    private SomeService service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testServiceUsingDependency() {
        when(dependency.calculate()).thenReturn(42);
        assertEquals(42, service.performCalculation());
    }
}
```

## MicroService
### @EnableEurekaServer
- The `@EnableEurekaServer` annotation is used with Spring Cloud Netflix Eureka to set up a service registry that allows microservices to register themselves and to discover other services for communication.
```java
@SpringBootApplication
@EnableEurekaServer // Enable Eureka Server
public class EurekaServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(EurekaServerApplication.class, args);
} }
```
### @HystrixCommand
- The `@HystrixCommand` annotation is part of the Hystrix library, which was as part of their Spring Cloud suite for handling latency and fault tolerance in distributed systems. When one service calls another, but the another service has a problem, Hystrix can catch all problems of underlying services and process a fallback plan
```java
@Service
public class ReliableService {

    @HystrixCommand(fallbackMethod = "reliable")
    public String risky() {
        throw new RuntimeException("Failed!");
        // Actual risky operations go here
    }

    public String reliable() {
        return "Recovered Failure!";
    }
}
```