# Chuwa Hw8 MingHao(Howard) Lee 
## Question 1-3 please refer to the branch MingHao_Lee/hw7, hw7.md.

## 1. What are the layers in a Spring Boot application? What is the role of each layer?
In a Spring Boot application, there are typically four main layers, each with a specific role. These layers are:

1. **Presentation Layer (or Web Layer)**
2. **Service Layer (or Business Layer)**
3. **Data Access Layer (or Persistence Layer)**
4. **Database Layer**



**Role:**
- This layer is responsible for handling user interface (UI) logic and interactions.
- It includes controllers (`@Controller`, `@RestController`) that handle HTTP requests and responses.
- Converts user inputs to service calls and prepares responses to be sent back to the client.

**Components:**
- Controllers
- View templates (Thymeleaf, JSP, etc.)
- REST API endpoints

## 2. Service Layer

**Role:**
- Contains business logic and rules.
- Acts as an intermediary between the presentation layer and the data access layer.
- It is responsible for performing operations and managing the application's workflow.
- Contains services annotated with `@Service`.

**Components:**
- Service classes and interfaces
- Business logic

## 3. Data Access Layer

**Role:**
- Handles the interaction with the database.
- Responsible for CRUD operations and data persistence.
- Uses repositories and DAOs (Data Access Objects) to communicate with the database.

**Components:**
- Repository interfaces annotated with `@Repository`
- DAOs
- Data mappers (MyBatis, JPA, Hibernate)

## 4. Database Layer

**Role:**
- The actual database where the data is stored.
- It could be any relational database (MySQL, PostgreSQL) or NoSQL database (MongoDB).

**Components:**
- Database schema
- Tables, collections, and indexes

## Example Flow in a Spring Boot Application

When an API call is made:

### Controller (Presentation Layer):
- Receives the HTTP request.
- Validates and processes the request data.
- Calls the appropriate service method.

### Service (Service Layer):
- Executes the business logic.
- May call multiple repositories to perform data operations.
- Combines data and logic to form the response.

### Repository (Data Access Layer):
- Interacts with the database.
- Performs CRUD operations.
- Returns data to the service layer.

### Database (Database Layer):
- Stores and retrieves the actual data as per the request.

## Diagram Representation
```Java
+----------------------+
|  Presentation Layer  |
|    (Controller)      |
+----------|-----------+
           |
           v
+----------------------+
|    Service Layer     |
|      (Service)       |
+----------|-----------+
           |
           v
+----------------------+
|  Data Access Layer   |
|   (Repository/DAO)   |
+----------|-----------+
           |
           v
+----------------------+
|    Database Layer    |
|    (Database)        |
+----------------------+
```




## 2. Describe the flow in all of the layers if an API is called by Postman.
When an API call is made by Postman, the flow through the layers of a Spring Boot application is as follows:

## 1. Presentation Layer (Controller)

### Role:
- Receives the HTTP request from Postman.
- Validates and processes the request data.
- Calls the appropriate service method to handle the business logic.

### Components:
- **Controller Methods:** These methods are annotated with `@Controller` or `@RestController`. They map HTTP requests to handler methods of MVC and REST controllers.

**Flow:**
1. Postman sends an HTTP request to the application's endpoint.
2. The request is received by the DispatcherServlet, which routes it to the appropriate controller.
3. The controller method processes the request, validates inputs, and prepares to call the service layer.

## 2. Service Layer

### Role:
- Contains the business logic.
- Acts as an intermediary between the presentation layer and the data access layer.
- Manages the application's workflow and operations.

### Components:
- **Service Classes and Interfaces:** Annotated with `@Service`, they contain methods that implement the business logic.

**Flow:**
1. The controller calls a method in the service layer.
2. The service method executes the business logic, possibly involving multiple steps or calls to the data access layer.
3. The service layer may handle additional validation, transformations, or other business rules.

## 3. Data Access Layer

### Role:
- Handles interactions with the database.
- Responsible for performing CRUD operations.
- Uses repositories and DAOs to abstract and encapsulate all access to the data source.

### Components:
- **Repository Interfaces and DAO Classes:** Annotated with `@Repository`, they provide methods to perform database operations.

**Flow:**
1. The service layer calls a method in the repository or DAO to access or modify data.
2. The repository interacts with the database using an ORM framework like JPA or Hibernate.
3. The repository returns the data to the service layer.

## 4. Database Layer

### Role:
- The actual database where the data is stored.
- Can be any relational database (MySQL, PostgreSQL) or NoSQL database (MongoDB).

### Components:
- **Database Schema:** Defines the structure of the database, including tables, collections, and indexes.
- **Tables/Collections:** Store the actual data.

**Flow:**
1. The repository or DAO performs the database operation (e.g., a query or update).
2. The database processes the operation and returns the result to the repository.
3. The repository returns the result to the service layer.

## Example Flow

1. **HTTP Request:**
   - Postman sends an HTTP `GET` request to `/api/posts`.

2. **Controller Layer:**
   - The request is received by the `PostController` class.
   - The `PostController` method annotated with `@GetMapping("/api/posts")` processes the request.
   - The method calls the `PostService` to get the list of posts.

3. **Service Layer:**
   - The `PostService` method `getAllPosts()` executes the business logic to retrieve posts.
   - The service method calls the `PostRepository` to fetch data from the database.

4. **Data Access Layer:**
   - The `PostRepository` method `findAll()` interacts with the database to retrieve all posts.
   - The data is fetched from the database and returned to the service layer.

5. **Database Layer:**
   - The database processes the `SELECT` query and returns the list of posts to the repository.

6. **Response:**
   - The service method returns the list of posts to the controller.
   - The controller prepares the response and sends it back to Postman.

## 3. What is the `application.properties`? Do you know `application.yml`?
### What is `application.properties`?

`application.properties` is a configuration file used in Spring Boot applications to define various settings and properties. This file is typically located in the `src/main/resources` directory and is used to configure application-specific settings, such as:

- Server settings (e.g., port number)
- Database connection details
- Logging levels
- Custom application properties

### What is `application.yml`?

`application.yml` is another configuration file format supported by Spring Boot for defining application properties. YAML (YAML Ain't Markup Language) is a human-readable data format that is often used for configuration files because of its simplicity and readability. Like `application.properties`, the `application.yml` file is also typically located in the `src/main/resources` directory.


## 4. What are the naming differences between GraphQL vs. REST? Why are there differences?
### GraphQL

- **Queries:** Used to fetch data. The operation name typically describes the data being fetched.
  - Example: `getUser`, `listPosts`
- **Mutations:** Used to modify data. The operation name typically describes the action being performed.
  - Example: `createUser`, `updatePost`

### REST

- **Endpoints:** Named based on resources and HTTP methods are used to define actions.
  - **GET**: Fetch data
    - Example: `GET /users`, `GET /posts`
  - **POST**: Create new data
    - Example: `POST /users`, `POST /posts`
  - **PUT**: Update existing data
    - Example: `PUT /users/{id}`, `PUT /posts/{id}`
  - **DELETE**: Delete data
    - Example: `DELETE /users/{id}`, `DELETE /posts/{id}`

### Differences

1. **Resource-Based vs. Action-Based:**
   - **REST:** Endpoints are resource-based, focusing on entities (e.g., users, posts).
   - **GraphQL:** Operations are action-based, focusing on actions or queries (e.g., getUser, createUser).

2. **HTTP Methods:**
   - **REST:** Uses different HTTP methods (GET, POST, PUT, DELETE) to define the type of operation.
   - **GraphQL:** Uses a single endpoint (usually `/graphql`) and distinguishes operations by query, mutation, and subscription.

3. **URL Structure:**
   - **REST:** Multiple endpoints based on resources and actions, e.g., `/users`, `/posts/{id}`.
   - **GraphQL:** Single endpoint with a flexible query structure, e.g., `/graphql`.

4. **Granularity and Flexibility:**
   - **REST:** Fixed endpoints for specific operations, which can lead to over-fetching or under-fetching of data.
   - **GraphQL:** Flexible queries allow clients to request exactly what they need, avoiding over-fetching or under-fetching.

These differences arise because GraphQL is designed to provide a more flexible and efficient way to interact with APIs, allowing clients to specify their exact data requirements. REST, on the other hand, follows a more rigid structure with predefined endpoints and methods, which can be simpler to implement but less flexible for complex data requirements.


## 5. Provide 2 real-world examples of the N+1 problem in REST that can be solved by GraphQL.
### Example 1: E-commerce Platform - Products and Reviews

**Problem**:
In an e-commerce platform, you want to display a list of products along with their customer reviews.

**REST API Issue**:
- First, you make a request to fetch all products.
- Then, for each product, you make separate requests to fetch their reviews.
- This results in one initial request to get the products and additional requests for each product to get their reviews, leading to potentially hundreds of requests if there are many products.

**GraphQL Solution**:
With GraphQL, you can fetch all products and their reviews in a single request, avoiding the multiple network calls and reducing the load time.

---

### Example 2: Social Media App - Users and Posts

**Problem**:
In a social media app, you want to display user profiles along with their latest posts.

**REST API Issue**:
- First, you make a request to fetch the list of users.
- Then, for each user, you make separate requests to fetch their posts.
- This results in one initial request to get the users and additional requests for each user to get their posts, leading to a high number of requests if there are many users.

**GraphQL Solution**:
With GraphQL, you can fetch all users and their posts in a single request, significantly reducing the number of network calls and improving the performance of the application.


## 6. Finish the following API
### REST
**DELETE post by ID (with exception cases)**

### GraphQL
**Query getAllPost**

Question 6 please refer to the coding folder redbook project folder 

## 7. Create a Project, name it `mongo-blog`, write a POST API for `mongo-blog`, change the database to MongoDB.

1. [MongoDB Compatibility with Spring Boot](https://www.mongodb.com/compatibility/spring-boot)
2. Question 7 please refer to the coding folder MongoBlog project folder
