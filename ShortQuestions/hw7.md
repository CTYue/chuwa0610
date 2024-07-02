# HW7

## 1. REST API Postman Practice

### 1. 5 GET APIS with different response type
- API-GET-1
- GET https://ghibliapi.herokuapp.com/locations
- Response Body: N/A
- Response: HTML Format
<!DOCTYPE html>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <title>Application Error</title>
    <style media="screen">
        html,
        body,
        iframe {
            margin: 0;
            padding: 0;
        }

        html,
        body {
            height: 100%;
            overflow: hidden;
        }

        iframe {
            width: 100%;
            height: 100%;
            border: 0;
        }
    </style>
</head>

<body>
    <iframe src="//www.herokucdn.com/error-pages/application-error.html"></iframe>
</body>

</html>

- API-GET-2
- GET https://jsonplaceholder.typicode.com/posts/1
- Request Body: N/A
- Response: Json Format
{
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
}

- API-GET-3
- GET https://api.coindesk.com/v1/bpi/currentprice.json
- Request Body: N/A
- Response: JSON Format
{
    "time": {
        "updated": "Jul 1, 2024 22:06:31 UTC",
        "updatedISO": "2024-07-01T22:06:31+00:00",
        "updateduk": "Jul 1, 2024 at 23:06 BST"
    },
    "disclaimer": "This data was produced from the CoinDesk Bitcoin Price Index (USD). Non-USD currency data converted using hourly conversion rate from openexchangerates.org",
    "chartName": "Bitcoin",
    "bpi": {
        "USD": {
            "code": "USD",
            "symbol": "&#36;",
            "rate": "63,112.623",
            "description": "United States Dollar",
            "rate_float": 63112.6228
        },
        "GBP": {
            "code": "GBP",
            "symbol": "&pound;",
            "rate": "49,891.412",
            "description": "British Pound Sterling",
            "rate_float": 49891.4119
        },
        "EUR": {
            "code": "EUR",
            "symbol": "&euro;",
            "rate": "58,760.629",
            "description": "Euro",
            "rate_float": 58760.6288
        }
    }
}

- API-GET-4
- GET https://pokeapi.co/api/v2/pokemon/ditto
- Request Body: N/A
- Response: JSON object with Pokemon details

- API-GET-5
- GET https://dog.ceo/api/breeds/list/all
- Request Body: N/A
- Response: JSON object with dog breeds

### 2. 5 Post API with json request body, please also paste the response here

- API-POST-1
- POST https://jsonplaceholder.typicode.com/posts
- Request Body:
{
    "title": "foo",
    "body": "bar",
    "userId": 1
}
- Response:
{
    "title": "foo",
    "body": "bar",
    "userId": 1,
    "id": 101
}

- API-POST-2
- POST https://reqres.in/api/users
- Request Body:
{
    "name": "Tony",
    "job": "SDE"
}
- Response:
{
    "name": "Tony",
    "job": "SDE",
    "id": "562",
    "createdAt": "2024-07-01T22:19:49.407Z"
}

- API-POST-3
- POST https://jsonplaceholder.typicode.com/comments
- Request Body:
{
    "postId": 1,
    "name": "comment.",
    "email": "12345@gmail.com",
    "body": "Something to say..."
}
- Response:
{
    "postId": 1,
    "name": "comment.",
    "email": "12345@gmail.com",
    "body": "Something to say...",
    "id": 501
}

- API-POST-4
- POST https://reqres.in/api/register
- Request Body:
{
    "email": "eve.holt@reqres.in",
    "password": "12345"
}
- Response:
{
    "id": 4,
    "token": "QpwL5tke4Pnpja7X4"
}

- API-POST-5
- POST https://jsonplaceholder.typicode.com/posts/1/comments
- Request Body:
{
    "name": "Tony",
    "email": "12345@example.com",
    "body": "Something..."
}
- Response:
{
    "name": "Tony",
    "email": "12345@example.com",
    "body": "Something...",
    "postId": "1",
    "id": 501
}

### 3. 3 PUT API with json request body, please also paste the response here

- API-PUT-1
- PUT https://jsonplaceholder.typicode.com/posts/1
- Request Body:
{
    "id": 1,
    "title": "foo",
    "body": "bar",
    "userId": 1
}
- Response: 
{
    "id": 1,
    "title": "foo",
    "body": "bar",
    "userId": 1
}

- API-PUT-2
- PUT https://reqres.in/api/users/2
- Request Body:
{
    "name": "Tony",
    "job": "SDE"
}
- Response:
{
    "name": "Tony",
    "job": "SDE",
    "updatedAt": "2024-07-01T22:25:10.293Z"
}

- API-PUT-3
- PUT https://jsonplaceholder.typicode.com/comments/1
- Request Body:
{
    "postId": 1,
    "id": 1,
    "name": "Tony",
    "email": "12345@example.com",
    "body": "Something to say."
}
- Response:
{
    "postId": 1,
    "id": 1,
    "name": "Tony",
    "email": "12345@example.com",
    "body": "Something to say."
}

### 4. 2 DELETE API

- API-DELETE-1
- DELETE https://jsonplaceholder.typicode.com/posts/1
- Response: HTTP Status 200 OK

- API-DELETE-2
- DELETE https://reqres.in/api/users/2
- Response: HTTP Status 204 No Content

### 5. Each example with 404, 401,500 and any http status codes you know
- 404 Not Found
- 401 Unauthorized
- 500 Internal Server Error

## 2. SpringBoot

### 1. create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.
- File name: annotations.md
- you'd better also list a code example under the annotations.

### 2. explain how the below annotaitons specify the table in database?

```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```
- @Column(columnDefinition = "varchar(255) default 'John Snow'"): Maps name to a varchar(255) column with a default value of 'John Snow'.

- @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false): Maps studentName to a STUDENT_NAME column with a maximum length of 50 characters, not nullable, and not unique.

### 3. What is the default column names of the table in database for @Column ?

```java
@Column
private String firstName;
@Column
private String operatingSystem;
```
- By default, if the @Column annotation is used without specifying a column name, JPA will use the field name as the column name in the database table. So for the provided fields: firstName will map to a column named firstName and operatingSystem will map to a column named operatingSystem.

### 4. What are the layers in springboot application? what is the role of each layer?

- Controller Layer: 
    - Handles HTTP requests and responses.
    - Maps user requests to the appropriate service methods.
    - Manages user input and returns views or data.

- Service Layer:
    - Contains business logic.
    - Processes data received from controllers.
    - Interacts with the repository layer to fetch or persist data.

- Repository Layer:
    - Manages database operations.
    - Uses JPA or other ORM tools to perform CRUD operations.
    - Maps entities to database tables.

- Model Layer:
    - Represents the data structure.
    - Contains entity classes mapped to database tables.
    - Used across other layers for data transfer.

### 5. Describe the flow in all of the layers if an API is called by Postman
- Controller Layer: Receives the HTTP request from Postman.
    - Maps the request to a specific handler method.
    - Calls the appropriate service method with request data.

- Service Layer: Processes the business logic.
    - Validates and manipulates the data.
    - Calls the repository layer if data persistence is needed.

- Repository Layer:
    - Interacts with the database.
    - Performs CRUD operations based on service layer requests.
    - Returns data to the service layer.

- Service Layer:
    - Receives data from the repository layer.
    - Further processes data if needed.
    - Returns the final result to the controller layer.

- Controller Layer:
    - Prepares the response.
    - Sends the response back to Postman.

- Postman: Receives and displays the API response.

### 6. What is the application.properties? do you know application.yml?

- application.properties and application.yml are configuration files in a Spring Boot application.
- application.properties: Uses key-value pairs to define configuration settings.
    - EX: server.port=8080 
          spring.datasource.url=jdbc:mysql://localhost:3306/mydb

- application.yml: Uses YAML format for configuration.
    - EX: server:
            port: 8080
          spring:
            datasource:
                url: jdbc:mysql://localhost:3306/mydb

### 7. What’s the naming differences between GraphQL vs. REST ? Why is the differences ?
- REST is Resource-centric design and GraphQL is flexible and efficient data fetching.

- REST:
    - Resource-Based: Endpoints named after resources.
    - Example: /users, /users/{id}
    - HTTP Methods: GET, POST, PUT, DELETE

- GraphQL:
    - Operation-Based: Single endpoint for all operations.
    - Example: /graphql
    - Queries/Mutations: Specify operations in request body.

### 8. Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL.

#### 1.  Fetching User and Their Posts:
- REST N+1 Problem:
    - GET /users to fetch all users.
    - For each user, GET /users/{id}/posts to fetch their posts.
- GraphQL Solution:
     - Single query to fetch users and their posts
    ```java
    query {
        users {
            id
            name
            posts {
                id
                title
            }
        }
    }
    ```
#### 2. Fetching Products and Their Reviews:
- REST N+1 Problem:
    - GET /products to fetch all products.
    - For each product, GET /products/{id}/reviews to fetch their reviews.
- GraphQL Solution:
    - Single query to fetch products and their reviews
    ```java
    query {
        products {
            id
            name
            reviews {
                id
                comment
            }
        }
    }
    ```
### 9. Finish the following API REST: DELETE post by ID (with exception cases) GraphQL: Query getAllPost

- REST: Endpoint: DELETE /posts/{id}
    - Controller: 
        ```java
        @DeleteMapping("/posts/{id}")
        public ResponseEntity<String> deletePostById(@PathVariable Long id) {
            // Implementation handles exceptions such as PostNotFoundException
        }
        ```
    - Service: 
        ```java
        public void deletePostById(Long id) throws PostNotFoundException {
        // Check if post exists, throw PostNotFoundException if not
        // Delete post
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
        getAllPosts: [Post]
    }
    ```
    - Resolver:
    ```java
    @Component
    public class QueryResolver implements GraphQLQueryResolver {
        public List<Post> getAllPosts() {
            // Implementation fetches all posts
        }
    }   
    ```
    - Ex: 
    ```java
    query {
        getAllPosts {
            id
            title
            content
        }
    }
    ```
### 10. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB
- https://www.mongodb.com/compatibility/spring-boot