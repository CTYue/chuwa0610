# HW7

1. **Explain how the below annotaitons specify the table in database?**

```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```

JPA will use @Column to map the properties of Entity class to the column of the table.

**columnDefinition**  assign the definition of this column, set the type as “varchar(255)”, and the default value is 'John Snow'

**name** define the name of this properties in database table as "STUDENT_NAME", which max length is 50, can not be null, the value is unique.

1. What is the default column names of the table in database for @Column ?

```java
@Column
private String firstName;
@Column
private String operatingSystem;
```

The default name will be the same as the properties of the Entity Class. “firstName”, “operatingSystem”

1. **What are the layers in springboot application? what is the role of each layer**
    
    Controller layer: Handle requests from clients, manage user session and security. Send inputs to service methods.
    
    Service layer: Contains the application’s business logic. This layer ensure the security and permissions during the data transaction. Service layer use repository instance to to do data transaction.
    
    Repository Layer: Responsible for data access and storage logic, which communicates with the database and any other data sources(other apis or file system)
    
    Model layer: Define the business model, including the entity models, DTOs..
    
    Security Layer: Manage the authentication and authorization.
    
    Configuration Layer: The configuration settings for entire application, which includes external configuration management and setup Spring context.
    
    Integration Layer: Manages the flow of data between different systems and services 
    
2. **Describe the flow in all of the layers if an API is called by Postman**
    
    The request will be intercepted by the appryopriate Controller based on the URL and HTTP method, controller will validate the data, and pass it to service layer.
    
    Service layer will check the authentication and authorization and manage the data transactions, ensuring data consistency and rollback in case of errors.
    
    Repository Layer will interacts with the database, using JPA Repository or custom DAOs to retrieve, update, insert or delete data in database.
    
    The model layer(including the Entity and DTO) represent the data structure that the application will work with. DTOs will be used to carry data between processes.
    
    If the response is ready, the response will back to service layer, then go back to controller layer, finally it will be sent back to client.
    
3. **What is the application.properties? do you know application.yml?**
    
    It used to define the environment settings of the application, like the database url. [application.properties](http://application.properties) use key-value format, application.yaml use YAML format.
    
4. **What’s the naming differences between GraphQL vs. REST ? Why is the differences ?**
    
    REST use HTTP methods(GET, POST, PUT, DELETE etc.) to perform operations on resources.
    
    ```java
    GET /users/1
    ```
    
    GraphQL use query, mutation, and subscription.
    
    ```java
    query {
      getUser(id: "1") {
        id
        name
        email
      }
    }
    ```
    
    GraphQL offers a more flexible approach to data retrieval. It allows clients to specify exactly what data is needed in a single request. REST is simpler in terms of using standardized HTTP methods but can lead to over-fetching or under-fetching of data.
    
5. **Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL.**
    
    Get the comments of post {id}:
    
    Use REST API need 2 steps:
    
    1.	**Fetch all posts:** GET /posts
    
    2.	**For each post, fetch comments:** GET /posts/{postId}/comments
    
    Use GraphQL need 1 step:
    
    ```java
    query {
      posts {
        id
        title
        comments {
          id
          text
          author
        }
      }
    }
    ```
    
    Get address of the user
    
    REST API:
    
    1.	**Fetch all users:** GET /users
    
    2.	**For each user, fetch their address:** GET /users/{userId}/address
    
    GraphQL:
    
    ```java
    query {
      users {
        id
        name
        address {
          street
          city
          state
          zipCode
        }
      }
    }
    ```