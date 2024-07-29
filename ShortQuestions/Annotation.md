# Annotation

**RestController:**
Used to mark a controller class

**RequestMapping:**

Used to map HTTP request 

properties:

value: The request URL

method: Request Method, if method is method = RequestMethod.POST, it will not received GET request

params: Request must have or must don’t have this query param. 

headers: headers must contains this properties

consumes: Request Content-Type must be this type(eg:  application/json)

produces: Response Content-Type must be this type(eg:  application/json)

eg:

```java
@RestController
@RequestMapping("/api")
public class MyController {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers() {
        return "Returning all users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, consumes = "application/json")
    public String addUser() {
        return "Adding a new user";
    }

    @RequestMapping(value = "/users", params = "id", method = RequestMethod.GET)
    public String getUserById() {
        return "Returning user with specific ID";
    }

    @RequestMapping(value = "/users", headers = "X-API-KEY=123", method = RequestMethod.GET)
    public String getUserWithHeader() {
        return "Returning user for specific API key";
    }
}
```

**Path Variable & Request Param:**

PathVariable: get path variables

properties: value, required

Request Param:  get query params

properties: value, required, defaultValue

eg:

[http://localhost:8080/spring-mvc-basics/user/{userId}/song?filter[year]=2010&filter[genre]=rock&filter[singer]=TaylorSwift&Page=1&PageSize=50](http://localhost:8080/spring-mvc-basics/user/%7BuserId%7D/song?filter%5Byear%5D=2010&filter%5Bgenre%5D=rock&filter%5Bsinger%5D=TaylorSwift&Page=1&PageSize=50)

```java
@Controller
public class SongController {

    @GetMapping("/user/{userId}/song")
    @ResponseBody
    public String getSongs(@PathVariable("userId") String userId,
                           @RequestParam("filter[year]") int year,
                           @RequestParam("filter[genre]") String genre,
                           @RequestParam("filter[singer]") String singer,
                           @RequestParam("Page") int page,
                           @RequestParam("PageSize") int pageSize) {
        return "Songs for user " + userId + " in genre " + genre + " by " + singer + " from " + year +
               ", page " + page + " with page size " + pageSize;
    }
}
```

**RequestBody:**

Get request body and store it in Java class

eg:

```java
@PostMapping("/users")
public ResponseEntity<String> addUser(@RequestBody User user) {
    // 处理用户数据
    return ResponseEntity.ok("User created with ID: " + user.getId());
}
```

**RestController = Controller + ResponseBody**

Controller:

Used to identify this is a controller component, spring boot will treat it as a controller component.

ResponseBody:

Used to automatic convert the response into JSON or XML

eg:

```java
@RestController
@RequestMapping("/api/v1/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping
    public ResponseEntity<BlogDTO> createBlog(@RequestBody BlogDTO blogDTO){
        BlogDTO response = blogService.createBlog(blogDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
```

**Autowired**:

Used for dependency injection.

If do not use Autowired, we need to use “new” to create instance, if this has other dependency, it need to create the dependency, which violated Single Responsibility Principle, Dependency Inversion Principle..

eg:

```java

public class EmailService {
    private MailSender mailSender;

    public EmailService() {
        this.mailSender = new MailSender();  // EmailService 创建时需要实例化 MailSender
    }

    public void sendEmail(String message) {
        mailSender.send(message);
    }
}

// Use Autowired

@Service
public class EmailService {
    private final MailSender mailSender;

    @Autowired
    public EmailService(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String message) {
        mailSender.send(message);
    }
}
```

From Spring 4.3, constructor function injection is a better way to implement DI

```java
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository; // Spring 通过依赖注入提供实例
    }

    @Override
    public BlogDTO createBlog(BlogDTO blogDTO) {
        // 使用 blogRepository 的方法
    }
}

//eg2

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogController {
    private final BlogService blogService;

    // Spring 自动注入 BlogService，无需 @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public ResponseEntity<BlogDTO> createBlog(@RequestBody BlogDTO blogDTO) {
        BlogDTO response = blogService.createBlog(blogDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
```

**Repository, Service, Controller:**

The specialization of Component annotation.

Repository is used in persistence layer, which mostly corresponds to database access operations.

Service used in service layer, which holds business logic, calls methods in the repository layer and process business function.
Controller used in presentation layer, to mark a class as a web controller.

Component annotation is used to define beans for component scanning.

Bean annotation used in Configuration

**@GetMapping, @PostMapping,@PutMapping, @DeleteMapping**

Specific shortcuts for @ReuqestMapping to handle HTTP GET, POST, PUT, and DELETE requests

**Document:**

Mapping Java class with MongoDB document. The collection name will be the lower case of Entity, eg: blog. If the collection name is different, we need to use **collection = “blogs”** to assign name.

The column name will be the same as the database, if name is different, we need to use **@Column(name = "user_name")** to assign name

**@Id** means id is the primary key of the table, in MongoDB, it will be mapping to _id

```java
@Document(collection = "blogs")
public class Blog {
    @Getter
    @Id
    private String id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String content;

    @Getter
    @Setter
    private LocalDateTime createTime;

    @Getter
    @Setter
    private LocalDateTime updateTime;

```

**Entity:**

Indicate that this is a JPA entity

**Table** indicate the database table name

**uniqueConstraints** means this the value of this column must be unique

```java
@Entity
@Table(
        name = "posts",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title"})
        }
)
```

Id: This column is a primary key

```java
@Column(name = "description", nullable = false)
//name is the name in database, nullable means this properties can not be null
```