[Restful](#restful)   
[Validation](#validation)   
[IOC/DI](#ioc-di)   
[Exception](#exception)
[EntityManager](#entitymanager)


# RESTFul
   @Entity, @Repository, @Service, @RestController
1. Database.Hibernate
   Define database class
    **@Entity:**
    - Marks a class as a JPA entity, representing a table in the realtional database.   
    
   **@Table:**
   - Specifies the details of the table to which an entity is mapped, such as name and schema.

   **@Id:**
   - Marks a field as the primary key of an entity.

   **@GeneratedValue:**
   - Configures the strategy used to generate values for the primary key automatically.   

   **@Column:**
   - Configures the mapping between a field and a column in the database table, allowing customization of column name, length, nullable, etc.
   
   **@CreatedTimestamp, @LastModifiedDate**
   - Automatically sets the creation and last modified date.
   ```
    @Entity
    @Table(name = "posts")
    public class Post {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "title", unique = true, nullable = false)
        private String title;
        @Column(name = "content", nullable = false)
        private String content;
        @Column(name = "description", nullable = false)
        private String description;
    
       @CreatedDate
       private LocalDateTime createDateTime;
   
       @UpdateTimestamp
       private LocalDateTime updateDateTime;
        // Constructors, getters, setters, and other methods omitted for brevity
    }
   
   ```
   **@JoinColumn**   
   The side with the @JoinColumn annotation owns the relationship
   - define a foreign key with the specified name, who owns relationship.
   - @JoinColumn(name = "address_id") annotation,  foreign key to the Address table.
   - mappedBy = "address" annotation, it is the inverse side of the relationship.

   **@JoinTable**
   define the join table that maintains the many-to-many relationship between two entities
   
   **@Transient**
   annotation in Hibernate is used to mark a field in an entity class as non-persistent, meaning that Hibernate will not store this field in the database.


   **@OneToOne**
   ```
   Entity Address
   Entity Employee
   
   public class Address {
      ...
      @Id 
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "address_id")
      private Long id;
   
      @OneToOne (mappedBy = "address")
      private Employee employee;
   }
   
   public class Employee {
      ...
      
      @Transient
      String password;
      
      @OneToOne
      @JoinColum(name = "address_id") // id in address
      private Address address;
      
   }
   ```
   **@ManyToOne**
   ```
   Entity Department
   Entity Employee
   
   public class Department {
      ...
      @OneToMany(mappedBy = "department") // reference
      private Set<Employee> employees;
   }
   
   public class Employee {
      ...
      @ManyToOne
      @JoinColumn(name = "department_id")
      private Department department;
   }
   ```
   **@ManyToMany**
   ```
   Enity Employee
   Enity Project
   
   public class Project {
      @ManyToMany(mappedBy = "projects")
      private Set<Employee> employees;
   }
   
   public class Employee {
      @ManyToMany
   
      @JoinTable(
        name = "employee_project",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "project_id")
      )
      private Set<Project> projects;
   }
   ```

1. @Repository
    - Data Access Object (DAO)
   ```
    @Repository
    public interface PostRepository extends JpaRepository<Post, Long> {
    // no code need here
    }
   ```
1. @Service
    - service component in the business layer.
    ```
    @Service
    public class PostServiceImpl implements PostService {

        @Autowired
        private PostRepository postRepository;
    
        @Override
        public PostDto createPost(PostDto postDto) {
            ...
        }
    }
    ```
1. @RestController
   = @Controller + @ResponseBody
    - a controller component in the MVC (Model-View-Controller) architecture.
    - @PostMapping
      - map HTTP POST requests onto specific handler methods in Spring controllers
    - @PutMapping
      - map HTTP PUT requests onto specific handler methods in Spring controllers.
    - @RequestBody
      -  bind the body of an HTTP request to a method parameter
    - @PathVariable
      - get pathVariable in the url
    ```
    @RestController
    @RequestMapping("/api/v1/posts")
    public class PostController {
    
        @Autowired
        private PostService postService;
    
        @PostMapping
        public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
            PostDto response = postService.createPost(postDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED) ;
        }
   
       @GetMapping("/{id}")
       public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id) {
           return ResponseEntity.ok(postService.getPostById(id));
       }
    }
    ```
   - @Controller + @ResponseBody
   ```
   @Controller
   @RequestMapping("/api/v1/posts")
   public class PostController {
      @Autowired
      private PostService postService;
      
      @PostMapping()
      public @ResponseBody ResponseEntity<PostDto> createPost(@RequestBody PostDto
      postDto) {
         PostDto postResponse = postService.createPost(postDto);
         return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
      }
   }
   ```
   - Content Negotiation
     - consumes: consume content-type from request
     - produces: contents to front-end, front-end only accept the type it defined
   ```java
   @PutMapping(value = "/{id}", produces = "text/pdf", consumes = "application/xml")
   public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto,
   @PathVariable(name = "id") long id) {
    PostDto postResponse = postService.updatePost(postDto, id);
    return new ResponseEntity<>(postResponse, HttpStatus.OK);
   }
   ```
1. @Controller
   a controller annotation
   could used for graphQLController
   - @QueryMapping
      - map a method to a GraphQL query.
   - @MutationMapping
     - map a method to a GraphQL mutation.
   - @Argument
     - bind a method parameter to a GraphQL argument.
   ```
   @Controller
   public class PostGraphQLController {
   private PostService postService;
   
       //constructor injection
       public PostGraphQLController(PostService postService) {
           this.postService = postService;
       }
   
       @QueryMapping
       public PostDto getById(@Argument long id) {
           return postService.getPostById(id);
       }
   
       @MutationMapping
       public PostDto createPost(@Argument String title, @Argument String description, @Argument String content) {
           PostDto postDto = new PostDto();
   
           postDto.setTitle(title);
           postDto.setDescription(description);
           postDto.setContent(content);
   
           return postService.createPost(postDto);
       }

   }
   ```
1. @ResponseStatus
   -  automatically applies the specified status code whenever that exception is thrown and not otherwise handled.
   ```
   @ResponseStatus(HttpStatus.NOT_FOUND) // sets HTTP status to 404 Not Found
   public class ResourceNotFoundException extends RuntimeException {
      public ResourceNotFoundException(String message) {
      super(message);
      }
   }
   ```
   
# Validation
spring-boot-starter-validation
1. @NotEmpty   
   or @NotEmpty(message = "Name should not be null or empty")
2. @NotNull
2. @Size
   Field: min, max, message
3. @Email
4. @Pattern
4. @Valid // to apply rule to the parameter

   ```
   public class User {
      @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
      private String name;
   
      @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "The username must be alphanumeric")
      private String username;

      @NotEmpty
      private String type;
   
      @Email
      private String email;
      ...
   }
   
   @RestController
   public class UserController {

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        ...
        return new ResponseEntity<>("User is valid", HttpStatus.OK);
    }
   }
   ```
   
# IOC DI
1. @Autowired
   - inject bean at runtime
   ```
   1. 如果只有一个impl,则默认用这个impl
   2. 如果有多个impl, 则查看是否有@Qualifier
   3.如果有多个impl, 且无@Qualifier, 按变量名(By Name)
   4. 如果有多个impl, 且无@Qualifier, 按变量名(By Name)不行， 则查看是否有@Primary (因为这个是type level的)
   5. 若无，则报错 (NoUniqueBeanDefinitionException) 
   ```
1. @Qualifier
   - to specify which inject which bean
   ```
   interface Animal(){...}
   @Component
   @Primary
   class Dog implements Animal{...}
   @Component
   class Cat implements Animal{...}
   
   public classA {
      @Autowired
      priviate Animal cat;
   }
   ```
1. @Primary
   - give a specific bean precedence when multiple beans of the same type exist in the Spring context.
1. @Component
   - 普通Component
   ```
   @Component
   public class GreetingService {
       public String greet(String name) {
           return "Hello, " + name + "!";
       }
   }
   ```
1. @Configuration
   - to mark a class as a source of bean definitions for the Spring application context. It indicates that the class can be used by the Spring IoC (Inversion of Control) container as a configuration class to generate and manage beans.
1. @Bean
   - typically used with **@Configuration**
   - usually to define 3rd Party lib
   - to indicate that a method produces a bean to be managed by the Spring container. 
   - define beans in a Spring application context
   ```
   @Configuration
   public class CommonConfig {

    /**
     * 当需要把第三方lib放入到IOC容器时候，则会用@Bean
     * @return
     */
    // "modelmapper" -> new ModelMapper();
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }  
   }
   ```
1. @ComponentScan
   - often use with @Configuration
   ```
   @Configuration
   @ComponentScan(basePackages = {"com.example.service", "com.example.repository"})
   public class AppConfig {
   }
   ```
1. @SpringBootApplication
   = @Configuration + @ComponentScan + @EnableAutoConfiguration

# Exception
1. @ExceptionalHandler
   - method level
   - used to handle the specific exceptions and sending the custom responses to the client
2. @ControllerAdvice
   - Class Level
   - handle exceptions globally across all controllers
   - make this class be a bean
   ``` 
   @RestController
   public class MyController {

      @ExceptionHandler(ResourceNotFoundException.class)
      @ResponseStatus(HttpStatus.NOT_FOUND)
      public String handleResourceNotFound(ResourceNotFoundException ex) {
        return ex.getMessage();
      }
   }
   ```
   ```
   @ControllerAdvice
   public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFound(ResourceNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGenericException(Exception ex) {
        return "An unexpected error occurred";
    }
   }
   ```

# EntityManager
1. @PersistenceContext
   - It injects an EntityManager.
   ```
   @PersistenceContext
   EntityManager entityManager;
   ```