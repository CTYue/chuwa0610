### 2 explain how the below annotaitons specify the table in database?

```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```

- The @Column annotation is used to specify the column definition in the database.
- columnDefinition = "varchar(255) default 'John Snow'" indicates that in the database, this column will be defined as a varchar(255) type, and its default value will be 'John Snow'.

### 3 What is the default column names of the table in database for @Column ?

```java
@Column
private String firstName;
@Column
private String operatingSystem;
```

- If the @Column annotation does not specify the name attribute, by default, the column name will be the same as the field name in the class.
- Therefore, in this case, firstName and operatingSystem will be used as the default column names in the database table.

### 4 What are the **layers** in springboot application? what is the **role** of each layer?

**Controller Layer**:

- **Role**: Handles incoming HTTP requests, processes them, and returns the appropriate response.
- **Components**: Controllers annotated with `@RestController` or `@Controller`.

**Service Layer**:

- **Role**: Contains the business logic of the application.
- **Components**: Services annotated with `@Service`.

**Repository Layer**:

- **Role**: Handles data persistence and retrieval.
- **Components**: Repositories usually annotated with `@Repository` and extending interfaces like `JpaRepository`.

**Model Layer**:

- **Role**: Represents the data structure of the application.
- **Components**: Entities or domain models annotated with `@Entity`.

### 5. Describe the **flow in all of the layers** if an API is called by Postman.

**Client Request**:

- A client sends an HTTP request using Postman to the API endpoint.

**Controller Layer**:

- The request is received by the appropriate controller method. The controller processes the request parameters and forwards the request to the service layer.

**Service Layer**:

- The service layer processes the request using the business logic. If data is needed, it calls the repository layer.

**Repository Layer**:

- The repository layer interacts with the database to fetch or persist data.

**Service Layer**:

- The service receives the data from the repository layer, processes it if necessary, and returns it to the controller.

**Controller Layer**:

- The controller prepares the HTTP response and sends it back to the client.

### 6. What is the **application.properties**? do you know application.yml?

**`application.properties`**: A configuration file used in Spring Boot applications to set application properties and configurations in a key-value format.

```java
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/db
spring.datasource.username=root
spring.datasource.password=pass

```

**`application.yml`**: An alternative to `application.properties`, it uses YAML format for configurations, which is more readable for hierarchical data.

```java
server:
  port: 8080

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/db
    username: root
    password: pass

```



7. What’s the naming differences between **GraphQL** vs. **REST** ? Why is the differences ? 

**REST**:

- **Naming**: Based on resources and HTTP methods.

- Example

  :

  - GET /users
  - POST /users
  - GET /users/{id}

- **Reason**: REST is resource-centric, focusing on performing actions (CRUD) on resources.

**GraphQL**:

- **Naming**: Based on queries and mutations.

- Example

  :

  - query { user(id: "1") { name, email } }
  - mutation { createUser(name: "John", email: "john@example.com") { id, name, email } }

- **Reason**: GraphQL is data-centric, allowing clients to request specific data structures.

### 8 Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL. 

#### Example 1: Fetching Users and Their Orders

- **REST**:

  - Fetch all users: `GET /users`
  - For each user, fetch orders: `GET /users/{id}/orders`
  - N+1 Problem: One query to fetch users, and N queries to fetch orders for each user.

- **GraphQL**:

  - Single query:

    ```java
    query {
      users {
        id
        name
        orders {
          id
          product
          quantity
        }
      }
    }
    
    ```

#### Example 2: Fetching Authors and Their Books

- **REST**:

  - Fetch all authors: `GET /authors`
  - For each author, fetch books: `GET /authors/{id}/books`
  - N+1 Problem: One query to fetch authors, and N queries to fetch books for each author.

- **GraphQL**:

  - Single query

    ```java
    query {
      authors {
        id
        name
        books {
          id
          title
          publishedYear
        }
      }
    }
    
    ```

    