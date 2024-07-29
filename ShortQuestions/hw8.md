# HW8
## 1.  create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.
- File name: [annotations.md](annotations.md)
- you'd better also list a code example under the annotations.
## 2.  explain how the below annotaitons specify the table in database?
```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;

@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```
- The @Column annotation is used to specify details about the columns in the database table that correspond to the annotated fields in the Java class.
- In the first half, "name" will be mapped to columnDefinitions defines the boundaries of a column "name"". It is set that the type should be varchar(255) and have a default value of 'John Snow'.
- In the second half, "studentName" wille be mapped to a column named "STUDENT_NAME" with restriction of length<=50 and cannot be NULL, and can be non-unique.
## 3.  What is the default column names of the table in database for  @Column ?
```java
   @Column
   private String firstName;
   @Column
   private String operatingSystem;
```
If no names are given, it will use the same name teh variable as the default column name.\
Here the columns will be "firstName" and "operatingSystem"
## 4.  What are the layers in springboot application? what is the role of each layer?
### Presentation Layer
- Handle interaction with client
- Handles HTTP request and response
### Business Layer
- Contains business logic of the applications
- process data from previous layer
### Persistence Layer
- Manages storage, and interaction with database
- Contains Data access logics like access, retrieve and update data in database
### Database Layer
- Where the actual data is stored
- Executes queries and transactions
## 5.  Describe the flow in all of the layers if an API is called by Postman.
### Presentation Layer
- Takes in the client request eg.`` "POST /api/users"`` with JSON body
- Make sure inputs are valid before send to next layer
- Present data from business layer as HTTP 201 response with response body
### Business Layer
- Process the incoming data, apply any business rules
- Calls Persistence layer for data access.
### Persistence Layer
- Interacts with Database to execute queries like SQL queries.
### Database Layer
- Execute the queries, return any result if necessary.
## 6.  What is the application.properties? do you know application.yml?
It is a file used to configure the application, such as Server port, link to DB, access username and passwords,etc.\
application.yml is an alternative of application.properties. It is more readable with hierarchical structures
## 7.  What’s the naming differences between GraphQL vs. REST ? Why is the differences ?
### REST
- Contains Different customized endpoints. (e.g., /users, /products).
- Use HTTP methods (GET,POST, PUT, DELTE)
## GraphQL
- One single endpoint (/graphgl)
- Instead of multiple endpoints, GraphQL uses a query language to define the structure of data required by the client.
## 8.  Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL.
Example 1:\
In REST if I have to get comments from a post, I have to :
```
GET /posts

Response:
[
  { "postId": 1, "title": "Post 1" },
  { "postId": 2, "title": "Post 2" }
]


```
Then: To get details of each customer I have to
```
GET /posts/1/comments
GET /posts/2/comments
...
```
However in GraphQl, I can simply create a query:
```
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
Example 2:\
In REST if I have to get customers that ordered stuff, I have to :
```
GET /orders

Response:
[
  { "orderId": 1, "customerId": 101 },
  { "orderId": 2, "customerId": 102 }
]

```
Then: To get details of each customer I have to
```
GET /customers/101
GET /customers/102
...
```
However in GraphQl, I can simply create a query:
```
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
### REST
- DELETE post by ID (with exception cases)
- see [PostController.java](..%2FCoding%2Fredbook%2Fsrc%2Fmain%2Fjava%2Fcom%2Fchuwa%2Fredbook%2Fcontroller%2FPostController.java)
### GraphQL
- Query getAllPost
- See [PostGraphQlController.java](..%2FCoding%2Fredbook%2Fsrc%2Fmain%2Fjava%2Fcom%2Fchuwa%2Fredbook%2Fcontroller%2FPostGraphQlController.java)
## 10.  Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB;
check [MongoBlogApplication.java](..%2FCoding%2Fhw7%2Fmongo-blog%2Fsrc%2Fmain%2Fjava%2Fcom%2Fexample%2Fmongo_blog%2FMongoBlogApplication.java)

