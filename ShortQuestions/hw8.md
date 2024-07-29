## Spring-boot exercise

2. explain how the below annotaitons specify the table in database?
   - The field `name` is mapped to a database column with a type of `varchar(255)` and a default value of `'John Snow'`
   - The `studentName` field is stored in a column named `STUDENT_NAME`, with a length of 50 characters, not allowing `null` values, and not requiring uniqueness.
3. What is the default column names of the table in database for  `@Column `
   - when no name is explicitly specified, the default column names of the table in the database will be the same as the field names in the entity class. so it will be `firstName` and `operatingSystem`

4. What are the layers in a Spring Boot application? What is the role of each layer?

- Controller Layer (Web Layer)
  - **Role:** Handles HTTP requests and responses. It acts as an entry point for the client to interact with the application. The controller layer processes the incoming requests, delegates the request to the appropriate service methods, and returns the results back to the client.
- Service Layer
  - **Role:** Contains the business logic of the application. It processes the data received from the controller layer and interacts with the repository layer to retrieve or store data. The service layer ensures that the business rules are applied correctly.
- Repository Layer (Data Access Layer)
  - **Role:** Interacts with the database. It contains methods for performing CRUD operations and is responsible for communicating with the database using JPA or other ORM frameworks. The repository layer abstracts the data access logic.
- Model Layer (Domain Layer)
  - **Role:** Represents the data structure of the application. It includes entity classes that define the structure of the data being managed. The model layer is used across other layers to transfer data.

5. Describe the flow in all of the layers if an API is called by Postman.

​	When an API is called by Postman, the flow through the layers of a Spring Boot application is as follows:

1. **Controller Layer:**
   - Postman sends an HTTP request to a specific endpoint.
   - The request is received by a controller method mapped to that endpoint.
   - The controller processes the request and may extract any necessary parameters or request body.
2. **Service Layer:**
   - The controller delegates the request to the appropriate service method.
   - The service method contains the business logic and processes the request data.
   - If data is needed from the database or needs to be persisted, the service layer interacts with the repository layer.
3. **Repository Layer:**
   - The service layer calls the repository methods to perform CRUD operations.
   - The repository interacts with the database to retrieve, save, update, or delete data.
   - The results from the repository are returned to the service layer.
4. **Model Layer:**
   - Throughout the flow, the model layer is used to transfer data between layers.
   - The entities and data transfer objects (DTOs) define the structure of the data being passed around.
5. **Controller Layer:**
   - The service layer returns the processed data to the controller.
   - The controller constructs an appropriate HTTP response and sends it back to Postman.'





6. What is the `application.properties`? Do you know `application.yml`?

- `application.properties`
  - **Explanation:** A configuration file used in Spring Boot applications to set various properties for the application. It allows configuring application settings such as database connection details, server port, logging level, and more. The properties are defined in a key-value format.
- `application.yml`
  - **Explanation:** An alternative to `application.properties` that uses YAML format. It provides a hierarchical way of defining configuration properties, which can be more readable and easier to manage for complex configurations.

7. 

##### Example 1: Fetching Posts with Comments

**Scenario:** You have a REST API that serves blog posts and their comments. Each post can have multiple comments. To fetch all posts along with their comments, a naive implementation might look like this:

N+1 Requests:

- For each post, fetch comments: `GET /posts/1/comments` and `GET /posts/2/comments`

```json
[
    {"id": 1, "postId": 1, "text": "Great post!"},
    {"id": 2, "postId": 1, "text": "Very informative."}
]
```

```json
[
    {"id": 3, "postId": 2, "text": "Thanks for sharing."}
]
```

**Problem:** If you have N posts, this results in 1 request to fetch posts + N requests to fetch comments for each post.

**Solution with GraphQL:** With GraphQL, you can fetch all posts along with their comments in a single query:

```
query {
  posts {
    id
    title
    comments {
      id
      text
    }
  }
}
```



##### Example 2: Fetching Users with Their Orders

Each user can have multiple orders. To fetch all users along with their orders, a naive implementation might look like this:

**N+1 Requests:**

- For each user, fetch orders: `GET /users/1/orders` and `GET /users/2/orders`

```json
[
    {"id": 101, "userId": 1, "product": "Laptop"},
    {"id": 102, "userId": 1, "product": "Mouse"}
]
```

```json
[
    {"id": 103, "userId": 2, "product": "Keyboard"}
]
```

**Problem:** If you have N users, this results in 1 request to fetch users + N requests to fetch orders for each user.

**Solution with GraphQL:** With GraphQL, you can fetch all users along with their orders in a single query:

```
graphql
Copy code
query {
  users {
    id
    name
    orders {
      id
      product
    }
  }
}
```