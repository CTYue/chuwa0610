# hw8

## 2. explain how the below annotations specify the table in database?

```java
class Main {
    // map name to a column, varchar(255) type with default value: 'John Snow' in database
    @Column(columnDefinition = "varchar(255) default 'John Snow'")
    private String name;
    // map studentName to a column "STUDENT_NAME", maximum length of 50 characters, not null, and not unique
    @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
    private String studentName;
}
```

## 3. What is the default column names of the table in database for @Column ?

```java
class Main {
    @Column
    private String firstName;
    @Column
    private String operatingSystem;
}
```
- By default, The default column names of the table in the database for the `@Column` annotation in JPA are the same 
  as the names of the fields in the class. So it is `firstName` and `operatingSystem`.
- However, by default, JPA providers like Hibernate might convert camelCase field names to snake_case column names in the database. So, firstName would be mapped to a column named `first_name` and operatingSystem to `operating_system` in the database table.

## 4. What are the layers in springboot application? what is the role of each layer?

- Controller Layer(Presentation Layer):
  - The entry point for handling HTTP requests.
  - Route requests to the service layer for business logic.
  - Return response to the client.

- Service Layer(Business layer):
  - Contains the business logic of the application, process the data received.
  - The intermediary layer which communicates with `Controller` and `Repository` layer.

- Repository Layer(Data Access Layer):
    - Responsible for data access and persistence.
    - Interact with the database to perform CRUD operations with JPA or other ORM tools.
    - Abstract date from access logic from business logic. (transfer dto to do)

- Model/Entity Layer(Domain Layer):
    - Represent the data model, the data structure.
    - Map entity classes to database tables.

## 5. Describe the flow in all the layers if an API is called by Postman
1. The **client/postman** sends an HTTP request to the server.
2. `Controller` layer receives HTTP request and maps tp the appropriate method using annotations like `@PostMapping`,
   `@GetMapping`, then calls the appropriate method in `Service` layer.
3. `Service` layer contains the business logic, it converts received DTO to an entity object suitable for 
   persistence. calls the method in the `Repository` layer.
4. `Repository` layer interacts with the database using JPA(Java Persistence API) to perform CRUD operations.
5. `Controller` layer receives the processed result, prepares for the response and sends back to the client/postman.
6. `Postman` shows the result.



## 6. What is the application.properties? do you know application.yml?

- Both are the configuration files in a Spring Boot application.
- application.properties: Uses key-value pairs to define configuration settings.
```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/mydatabase
spring.datasource.username=dbuser
spring.datasource.password=dbpassword

# Server Configuration
server.port=8080

# Logging Configuration
logging.level.org.springframework=INFO
logging.level.com.example=DEBUG

```

- application.yml: Uses YAML format for configuration.
```yaml
# Database Configuration
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydatabase
    username: dbuser
    password: dbpassword

# Server Configuration
server:
  port: 8080

# Logging Configuration
logging:
  level:
    org.springframework: INFO
    com.example: DEBUG

```

## 7. What’s the naming differences between GraphQL vs. REST ? What are the differences ?
- REST is Resource-centric design and GraphQL is flexible and efficient data fetching.

- REST: resource-based, use endpoints(users) that represent resources and actions using nouns({id) and HTTP methods 
  (verbs:GET) 
  - example: `GET /users/{id}`

- GraphQL: operation-based: single endpoint (/graphql) and use a query language to specify the data requirements.
  - example: /graphql
  ```
  query {
    users {
      id
      name
      email
    } 
  }
  ```

## 8. Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL.

### 1.  fetch a list of posts along with their authors' details using RESTful endpoints.
- REST N+1 Problem:
    - GET /posts 
```json
[
  { "id": 1, "title": "Post 1", "authorId": 101 },
  { "id": 2, "title": "Post 2", "authorId": 102 },
]
```
  - For each post, fetch the author details separately.
```
GET /authors/101
GET /authors/102
...
```
- GraphQL Solution:
    - Single query to fetch posts and its author details
```graphql
query {
  posts {
    id
    title
    author {
      id
      name
    }
  }
}
```
### 2. fetch a list of products along with the orders for each product,
- REST N+1 Problem: `GET /products/{productId}/orders`
```text
GET /products
[
  { id: 1, name: "Product A" },
  { id: 2, name: "Product B" },
  ...
]

GET /products/1/orders
[
  { id: 101, productId: 1, quantity: 2 },
  { id: 102, productId: 1, quantity: 1 },
  ...
]

GET /products/2/orders
[
  { id: 201, productId: 2, quantity: 3 },
  { id: 202, productId: 2, quantity: 2 },
  ...
]

```

- GraphQL:
```graphql
query {
  products {
    id
    name
    orders {
      id
      quantity
    }
  }
}
```
## 9. Finish the following API REST: DELETE post by ID (with exception cases) GraphQL: Query getAllPost

- REST: Endpoint: DELETE /posts/{id}
    - Controller:
        ```java
        @DeleteMapping("/posts/{id}")
        public ResponseEntity<String> deletePostById(@PathVariable(name = "id") Long id) {
            // Implementation handles exceptions such as PostNotFoundException
        }
        ```
    - Service:
        ```java
        public void deletePostById(Long id) throws PostNotFoundException {
            // detail logic to delete
        }
        ```
- GraphQL: Query getAllPosts
    - Schema:
    ```java
    type Post {
        id: ID
        title: String
        content: String
    }
	type Query {
        getAllPosts: [Post!]!
    }
    type Query {
        getAllPosts: [Post]
    }
    ```
    - Resolver:
    ```java
    @Component
    public class PostQueryResolver implements GraphQLQueryResolver {
  
      private final PostService postService;
  
      public PostQueryResolver(PostService postService) {
          this.postService = postService;
      }
  
      public List<Post> getAllPosts() {
          return postService.getAllPosts();
      }
    }  
    ```
    - Query:
    ```graphql
    query {
        getAllPosts {
            id
            title
            content
        }
    }
    ```
## 10. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB]
[mongo-blog](../Coding/mongo-blog)