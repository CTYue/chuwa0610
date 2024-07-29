# Homework 8

## Yirun Wang

### 2. explain how the below annotaitons specify the table in database?
The name field will map to a column in the database table. The data type is varchar, limit length is 255, and the default value is "John Snow".
studentName will map to a column in the database table called "STUDENT_NAME". It is varchar with a maximum length of 50. It can't contain Null value. Duplicate values are allowed.

### 3. What is the default column names of the table in database for @Column?
firstName
operatingSystem

### 4. What are the layers in springboot application? what is the role of each layer?
- Presentation layer
This layer is responsible for handling HTTP requests, returning HTTP responses, and rendering the user interface. It manages the interaction with the client and often includes controllers.
```
@RestController
@RequestMapping("/api")
public class UserController {
    
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        // Call to Service Layer
    }
}
```
- Service layer
This layer contains the business logic of the application. It processes input from the Presentation Layer, performs necessary calculations or transformations, and coordinates activities across various components of the application.
```
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
```
- Data Access layer
This layer is responsible for interacting with the database. It performs CRUD (Create, Read, Update, Delete) operations and abstracts the data access details from the Service Layer.
```
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
```
- Model Layer
This layer contains the domain entities and models that are used throughout the application. These are the objects that are persisted to and retrieved from the database.
```
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;

    // getters and setters
}
```

### 5. Describe the flow in all of the layers if an API is called by Postman.
- The request is received by the DispatcherServlet, the front controller in Spring MVC.
- The DispatcherServlet routes the request to the appropriate controller based on the URL mapping.
- The controller method calls a method in the Service Layer to perform business logic.
- The service method processes the input (e.g., fetches user details, applies business rules).
- The service method interacts with the Repository Layer to fetch or modify data.
- The repository interfaces with the database to perform the necessary operations (e.g., query the user by ID).
- The repository retrieves data from the database and returns it as an entity object. The entity object is passed back through the layers to the service method.
- The service method receives the entity object and may perform additional processing. The processed data is returned to the controller.
- The controller prepares the HTTP response, typically wrapping the data in a ResponseEntity.
- The DispatcherServlet sends the HTTP response back to Postman.

### 6. What is the application.properties? do you know application.yml?
Both application.properties and application.yml are configuration files used in Spring Boot to externalize configuration.
application.properties uses a key-value pair format, where each configuration property is specified on a new line. Commonly used for straightforward, simple configurations, like database configuration.
application.yml uses YAML (YAML Ain’t Markup Language) format, which is more hierarchical and can represent nested properties in a cleaner way. Preferred for more complex configurations where nested properties are involved.

### 7. What’s the naming differences between **GraphQL **vs.  **REST**? Why are there differences?

GraphQL uses queries to fetch data and mutations to modify data. 

​	`query { post(id: 1) { id, title, content } }` - Retrieves a specific post by ID.

​	`mutation { createPost(input: { title: "New Post", content: "Content" }) { id, title, content } }` - Creates a new post.

Rest uses HTTP methods to perform operations and resources endpoints.

​	`GET /posts/{id}` - Retrieves a specific post by ID.

​	`POST /posts` - Creates a new post.

Unlike REST, which uses multiple endpoints, GraphQL typically uses a single endpoint (e.g., /graphql) for all operations.

GraphQL uses a strongly typed schema to define the shape of the API. Types are defined using the GraphQL schema definition language (SDL).

```
type Post {
    id: ID!
    title: String!
    content: String!
}

type Query {
    posts: [Post]
    post(id: ID!): Post
}

type Mutation {
    createPost(input: CreatePostInput): Post
    updatePost(id: ID!, input: UpdatePostInput): Post
    deletePost(id: ID!): Post
}
```

### 8. Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL.

The N+1 problem is a common issue in RESTful APIs where multiple requests are made to fetch related data, leading to inefficient querying and performance issues. GraphQL can solve this by allowing clients to fetch nested data in a single query.

1. Fetch a list of blog posts and their associated comments.

​	First fetch all the blog posts using GET /posts

​	And use Get /posts/{id}/comments to fetch all the comments for each post.

​	For N posts, this results in N+1 requests.

​	For GraphQL, we can fetch the posts and comments in one query.

```
query {
  posts {
    id
    title
    comments {
      id
      content
    }
  }
}
```

2. Fetch orders with product details

   In Rest, use GET /orders to get all the orders.

   Use GET /products/{product_id} to get the product details.

   With GraphQL, fetch all the data in one query:

   ```
   {
     orders {
       id
       quantity
       product {
         id
         name
         price
       }
     }
   }
   ```
   
   
