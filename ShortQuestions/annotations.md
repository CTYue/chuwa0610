## 1. `@SpringBootApplication`
This annotation is used to mark the main class of a Spring Boot application. It encapsulates @SpringBootConfiguration, @EnableAutoConfiguration, and @ComponentScan annotations with their default attributes.  
Ex:
```
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
```

## 2. `@RestController`
This annotation is used to handle REST APIs such as GET, PUT, POST, DELETE etc. and also used to create RESTful web services using Spring MVC.

It encapsulates @Controller annotation and @ResponseBody annotation with their default attributes.  
```
@RestController
public class PostController{ 
   // ...
}
```

## 3. `@RequestMapping`
This annotation is used to map the HTTP requests with the handler methods inside the controller class.
```
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
   // ...
}
```

## 4. `@Autowired`
This annotation is used for automatic dependency injection
```
@Autowired
private PostService postService;
```

## 5. `@Repository`
Repository Annotation is a specialization of @Component annotation which is used to indicate that the class provides the mechanism for storage, retrieval, update, delete and search operation on objects.
```
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
```

## 6. `@Entity`
@Entity annotation is used in the context of Spring Data JPA (Java Persistence API) to mark a class as a persistent Java class. 
```
@Entity
public class Post{
   // ...
}
```

## 7. `@Service`
Service annotation indicates that the class belongs to the business logic layer. It is used to mark the class as a service provider.
```
@Service
public class PostServiceImpl implements PostService {
   // ...
}
```

## 8. `@Id`
@Id sets the column as primary key

## 9. `@GeneratedValue(strategy = GenerationType.IDENTITY)`
This annotation will generate the primary key value by the database itself using the auto-increment column option. It relies on the database’s native support for generating unique values. 
```
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
private Long empId; 
```

## 10. `@Column(name = "description", nullable = false)`
Specify the information for this column, like name in database, can be null or not in database.
```
Column(name = "description", nullable = false)
private String description;
```

## 11. `@OneToOne(cascade = CascadeType.ALL)`, `@JoinColumn(name = "profile_id, referencedColumnName = "id")`
OneToOne represents a one-to-one relationship between two entities. The JoinColumn annotation is used to configure the name of the column in the table that maps to the primary key in the other table.  
**Cascading** - means **Propagating** an operation from the owning entity to the related entity. When a record in the owning entity(parent table) is saved, updated or deleted, the change should be reflected in the related entity(child table) as well.

|Type| Usage|
|----------|-------------|
| Persist     | Owning entity saved -> related entity saved  |
| Merge | Owning entity merged -> related entity merged |
| Refresh | Owning entity refreshed -> related entity refreshed|
| Remove | Owning entity removed -> related entity removed|
| Detach | Owning entity detached -> related entity detached|
| All | All cascade operations on owning entity applied to related entity|
```
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "profile_id, referencedColumnName = "id")
private PlayerProfile playerProfile
```

## 12. `@ManyToMany(fetch = FetchType.LAZY)`, `@JoinTable(name = "sku_inventory", joinColumns = @JoinColumn(name = "sku_id"), inverseJoinColumns = @JoinColumn(name = "Inventory_id"))`
@ManyToMany represents a many-to-many relationship between two types of entities. In the case of a many-to-many relationship, both sides can relate to multiple instances of the other side.  
@JoinTable should be placed in the owner side. It should contain name of the join table as well as the foreign keys with the @JoinColumn annotations. The joinColumn attribute will connect to the owner side of the relationship, and the inverseJoinColumn to the other side.
- FetchType.Lazy - only fetch data from post.
- FetchType.Eager - when we fetch post, JPA also fetch comment at the same time.
```
@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(name = "sku_inventory", joinColumns = @JoinColumn(name = "sku_id"), inverseJoinColumns = @JoinColumn(name = "Inventory_id"))
private Set<PmsInventory> pmsInventories = new HashSet<>();
```

## 13. `@NamedQuery`, `@NamedQueries`
A **named query** is a statically defined query with a predefined unchangeable query string. Using named queries instead of dynamic queries may improve code organization by separating the JPQL query strings from the Java code. It also enforces the use of query parameters rather than embedding literals dynamically into the query string and results in more efficient queries.  
```
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
```
Attaching multiple named queries to the same entity class requires wrapping them in a `@NamedQueries` annotation
```
@Entity
@NamedQueries({
    @NamedQuery(name="Country.findAll",
                query="SELECT c FROM Country c"),
    @NamedQuery(name="Country.findByName",
                query="SELECT c FROM Country c WHERE c.name = :name"),
}) 
```

## 14. `@Transactional`
@Transactional is used to configure Spring transactions, it can be used either at the class or method level.
```
@Transactional
public class PostJPQLRepositoryImpl implements PostJPQLRepository {
   @PersistenceContext
   EntityManager entityManager;
}
```

## 15. `@Bean`
To declare an object that is managed by the Spring framework. Spring framework takes care of instantiation, configuration, and wiring up objects.
```
@Bean
public ModelMapper modelMapper() {
   return new ModelMapper();
}
```

## 16. `@ExceptionHandler`
This annotation is used to handel the specific exceptions and sending the custom responses to the client
```
@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ErrorDetails> handleResourceNotFoundException (ResourceNotFoundException exception, WebRequest webRequest) {
   ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
   return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
}
```

## 17. `@ComponentScan`
This annotation defines where Spring should scan the bean definations and generate the beans.
```
@Configuration
@ComponentScan(basePackages = {"com.chuwa.springbasic"})
public class BeanConfig {
   // ...
}
```

## 18. `@Configuration`
This annotation declares a class as the source for bean definitions.
```
@Configuration
@ComponentScan(basePackages = {"com.chuwa.springbasic"})
public class BeanConfig {
   // ...
}
```

## 19. `@Qualifier`
Adds a qualifier name to a specific bean
```
@Bean
@Qualifier("primary")
public ModelMapper modelMapper() {
   return new ModelMapper();
}
```

## 20. `@Primary`
Sets the bean as primary bean. If no qualifier is used, Spring will always use this Bean first.
```
@Bean
@Primary
public ModelMapper modelMapper() {
   return new ModelMapper();
}
```

## 21. `@Controller`
`@Controller` annotation is also a specialization of @Component annotation. The `@Controller` annotation indicates that a particular class serves the role of a controller. Spring Controller annotation is typically used in combination with annotated handler methods based on the `@RequestMapping` annotation. It can be applied to classes only. It’s used to mark a class as a web request handler. It’s mostly used with Spring MVC applications.

```
@Controller
public class myController {
 //...
}
```

## 22. `@PreAuthorize`
The @PreAuthorize annotation checks the given expression before entering the method. The @PreAuthorize(“hasRole(‘ROLE_VIEWER’)”) has the same meaning as @Secured(“ROLE_VIEWER”)
```
@PreAuthorize("hasRole('ROLE_VIEWER')")
public String getUsernameInUpperCase() {
    return getUsername().toUpperCase();
}
```

## 23. `@PostAuthorize()`
@PostAuthorize annotation verifies it after the execution of the method and could alter the result. @PreAuthorize expressions can be replaced by @PostAuthorize ones.
```
@PostAuthorize("#username == authentication.principal.username")
public String getMyRoles2(String username) {
    //...
}
```