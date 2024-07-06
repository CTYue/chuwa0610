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
- It is a specialized version of the @Controller annotation that includes the @ResponseBody annotation. This means that it's designed for building RESTful web services where the response body of a method is serialized directly into the response format (usually JSON or XML). Annotate a class to define it as a controller where every method returns a domain object instead of a view.
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
