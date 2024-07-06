#Lombok
1. Database.Hibernate

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
1. @Autowired
   - inject bean

1. @PersistenceContext
   - It injects an EntityManager.
   ```
   @PersistenceContext
   EntityManager entityManager;
   ```

