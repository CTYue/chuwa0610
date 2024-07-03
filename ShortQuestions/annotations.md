# Annotations Guide

This document contains a list of annotations, their usage, and code examples. It will be updated whenever new annotations are learned.

## Table of Contents
- [Entity Annotations](#entity-annotations)
- [Controller Annotations](#controller-annotations)

## Entity Annotations

### @Entity
**Usage:** This annotation specifies that the class is an entity and is mapped to a database table.

**Example:**
```java
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private Long id;
    private String name;

    // Getters and Setters
}
```

@Table
Usage: This annotation specifies the table in the database with which this entity is mapped.

@Id
Usage: This annotation specifies the primary key of an entity.

@GeneratedValue
Usage: This annotation provides the specification of generation strategies for the values of primary keys.

@Column
Usage: This annotation is used to specify the mapped column for a persistent property or field.

@RestController
Usage: This annotation is used to create RESTful web services using Spring MVC.

@RequestMapping
Usage: This annotation is used to map web requests to specific handler classes or handler methods.

@GetMapping
Usage: This annotation is used to handle HTTP GET requests.


2. explain how the below annotaitons specify the table in database?

```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
  
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```

@Column(columnDefinition = "varchar(255) default 'John Snow'"):

Specifies the SQL type and default value of the column.
The column will be of type varchar(255) with a default value of 'John Snow'.

@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false"):

Specifies the name of the column as STUDENT_NAME.
The column will have a maximum length of 50 characters.
The column cannot be null.
The column values do not need to be unique.

3. What is the default column names of the table in database for @column?
Default Column Names
For the field firstName, the default column name will be firstName.
For the field operatingSystem, the default column name will be operatingSystem.

4.  What are the layers in springboot application? what is the role of each layer?
5.  Describe the flow in all of the layers if an API is called by Postman.
Presentation Layer (Controller Layer)
Role: Handles HTTP requests and responses, processes user inputs, and returns the appropriate views or data
Postman sends an HTTP request to the API endpoint.

Service Layer
Role: Contains business logic and interacts with the data layer to process requests.
The controller calls the appropriate service method to handle the request.
The service layer processes business logic and may call one or more repository methods.

Data Access Layer (Repository Layer)
Role: Handles database operations such as CRUD (Create, Read, Update, Delete) operations.
The service method interacts with the repository layer to perform database operations.
The repository layer executes database queries and returns the results to the service layer.

Model Layer
Role: Represents the data and entities used within the application.
Data retrieved or stored in the database is represented by entity classes in the model layer.
The processed data is sent back through the service and controller layers.


6.  What is the application.properties? do you know application.yml?
application.properties:
Role: Configuration file used to define application settings such as database connection details, server port, and other configurations in a key-value pair format.

application.yml:
Role: Alternative configuration file to application.properties that uses YAML format for defining configurations, which can be more readable and support hierarchical data 

7.  What’s the naming differences between GraphQL vs. REST ? Why is the differences ? 
REST:
Resources: In REST, the primary concept is a resource, which is any object of importance, such as a user, post, or comment. Resources are typically represented as endpoints (URLs).
HTTP Methods: REST uses standard HTTP methods to perform actions on resources:
GET: Retrieve a resource.
POST: Create a new resource.
PUT: Update an existing resource.
DELETE: Remove a resource.
Endoints: URLs in REST are used to access resources and often look like /users, /posts/1, etc.

GraphQL:
Types: GraphQL is schema-based and uses types to define the structure of data. Types represent objects such as User, Post, Comment, etc.
Queries and Mutations: GraphQL uses queries to read data and mutations to modify data.
Queries: Used to fetch data.
Mutations: Used to modify data (create, update, delete).
Fields: In GraphQL, data is fetched based on fields specified in the query, and responses are only as large as necessary, containing only the requested fields.
Endpoints: GraphQL uses a single endpoint, typically /graphql, to handle all requests, unlike REST where each resource has its own endpoint.

Reasons for Differences:
Flexibility: GraphQL allows clients to request only the data they need, leading to more efficient data retrieval. In contrast, REST responses can be over-fetching or under-fetching data.
Single Endpoint: GraphQL operates through a single endpoint, simplifying the API surface area. REST has multiple endpoints which can complicate maintenance as the number of resources grows.
Schema-Based: GraphQL’s schema defines the shape of the API, making it self-documenting and easier to understand. REST lacks a built-in schema definition, often relying on external documentation.

8.  Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL. 
Example 1: Fetching Blog Posts and Comments
REST:
Initial Request: GET /posts retrieves a list of blog posts.
N Additional Requests: For each post, GET /posts/{postId}/comments retrieves the comments for that post.
N+1 Problem: This requires 1 request for posts + N requests for comments, leading to N+1 requests in total.

GraphQL:
{
  posts {
    id
    title
    comments {
      id
      text
    }
  }
}

Example 2: Fetching Users and Their Orders
REST:
Initial Request: GET /users retrieves a list of users.
N Additional Requests: For each user, GET /users/{userId}/orders retrieves the orders for that user.
N+1 Problem: This requires 1 request for users + N requests for orders, leading to N+1 requests in total.

GraphQL:
{
  users {
    id
    name
    orders {
      id
      total
    }
  }
}

9.  Finish the following API 
```java
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        try {
            boolean deleted = postService.deletePostById(id);
            if (!deleted) {
                return new ResponseEntity<>(Map.of("error", "Post not found"), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(Map.of("message", "Post deleted successfully"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

@Service
public class PostService {

    private Map<Long, Post> posts = new HashMap<>();

    // Initialize with some mock data
    public PostService() {
        posts.put(1L, new Post(1L, "First Post", "Content of the first post"));
        posts.put(2L, new Post(2L, "Second Post", "Content of the second post"));
    }

    public boolean deletePostById(Long id) {
        if (!posts.containsKey(id)) {
            return false;
        }
        posts.remove(id);
        return true;
    }
}

public class Post {
    private Long id;
    private String title;
    private String content;

    public Post(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
```

GraphQL
type Query {
    getAllPost: [Post]
}

type Post {
    id: ID!
    title: String!
    content: String!
}