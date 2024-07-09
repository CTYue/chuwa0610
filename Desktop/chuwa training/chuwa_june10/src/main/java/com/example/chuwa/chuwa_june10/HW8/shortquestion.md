## 1. create a file to list all of the annotaitons you learned and known,and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.
### (1). File name: annotations.md
### (2). you'd better also list a code example under the annotations.
## 2. explain how the below annotaitons specify the table in database?
````text
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
````
```text
The name field will map to a column in the database table. The data type is varchar, limit length is 255, and the default value is "John Snow".
studentName will map to a column in the database table called "STUDENT_NAME". It is varchar with a maximum length of 50. It can't contain Null value. Duplicate values are allowed.
```
## 3. What is the default column names of the table in database for @Column ?
```text
@Column
private String firstName;
@Column
private String operatingSystem;
```
```text
Convert camel case names to lower case. Use underscores to separate words.

first_name
operating_system
```

## 4. What are the layers in springboot application? what is the role of each layer?
- Controller Layer (Web Layer)
```text
Handles HTTP requests and responses. It acts as an entry point for the client to interact with the application. 
The controller layer processes the incoming requests, delegates the request to the appropriate service methods, 
and returns the results back to the client.
```
- Service Layer
```text
Contains the business logic of the application. It processes the data received from the controller layer and interacts with the repository layer to retrieve or store data. 
The service layer ensures that the business rules are applied correctly.
```
- Repository Layer (Data Access Layer)
```text
Interacts with the database. It contains methods for performing CRUD operations and is responsible for communicating 
with the database using JPA or other ORM frameworks. The repository layer abstracts the data access logic.
```
- Model Layer (Domain Layer)
```text
Represents the data structure of the application. It includes entity classes that define the structure of the data being managed. 
The model layer is used across other layers to transfer data.
``` 
## 5. Describe the flow in all of the layers if an API is called by Postman.
```text
1.Controller Layer (Web Layer):
Postman's request first hits this layer. The controller receives the HTTP request, extracts necessary information, and routes it to the appropriate handler method.
2.Service Layer:
The controller calls the relevant service method. This layer applies business logic, performs necessary computations or transformations on the data.
3.Repository Layer (Data Access Layer):
If data persistence is required, the service layer interacts with the repository. The repository executes database operations, retrieving or storing data as needed.
4.Model Layer (Domain Layer):
This layer represents the core domain objects or entities. These objects are typically used across all layers, carrying data between them.
```
## 6. What is the application.properties? do you know application.yml?
- application.properties
```text
A configuration file used in Spring Boot applications to set various properties for the application. 
It allows configuring application settings such as database connection details, server port, logging level, and more. 
The properties are defined in a key-value format.
```
- application.yml
```text
An alternative to `application.properties` that uses YAML format. 
It provides a hierarchical way of defining configuration properties, 
which can be more readable and easier to manage for complex configurations.
```
## 7. What’s the naming differences between GraphQL vs. REST ? Why is the differences ? 
- REST
```text
Contains Different customized endpoints. (e.g., /users, /products).
Use HTTP methods (GET,POST, PUT, DELTE)
```
- GraphQL
```text
One single endpoint (/graphgl)
Instead of multiple endpoints, GraphQL uses a query language to define the structure of data required by the client.
```

## 8. Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL.
### Example 1
- In REST if I have to get comments from a post, I have to :
```text
GET /posts
Response:
[
  { "postId": 1, "title": "Post 1" },
  { "postId": 2, "title": "Post 2" }
]
```

- Then: To get details of each customer I have to
```text
GET /posts/1/comments
GET /posts/2/comments
```

- However in GraphQl, I can simply create a query:
```text
{
  posts {
    postId
    title
    comments {
      commentId
      content
    }
  }
}
```



### Example 2:
- In REST if I have to get customers that ordered stuff, I have to :
```text
GET /orders
Response:
[
  { "orderId": 1, "customerId": 101 },
  { "orderId": 2, "customerId": 102 }
]
```

- Then: To get details of each customer I have to
```text
GET /customers/101
GET /customers/102
```
- However in GraphQl, I can simply create a query:
```text
{
  orders {
    orderId
    customer {
      customerId
      name
    }
  }
}
```

## 9.  Finish the following API
    REST
    DELETE post by ID (with exception cases)
    GraphQL
    Query getAllPost
## 10.  Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB;
check [MongoBlogApplication.java](..%2FCoding%2Fhw7%2Fmongo-blog%2Fsrc%2Fmain%2Fjava%2Fcom%2Fexample%2Fmongo_blog%2FMongoBlogApplication.java)


