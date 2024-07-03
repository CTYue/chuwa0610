## 2. explain how the below annotaitons specify the table in database?
* name: column name is "name", type varchar, max length 255, default "John Snow"
* studentName: column name is "STUDENT_NAME", length 50, cannot be null, can be repeated.

## 3. What is the default column names of the table in database for @Column ?
* firstName, operationgSystem

## 4. What are the layers in springboot application? what is the role of each layer?
* Presentation Layer - Authentication & Json Translation
* Business Layer - Business Logic, Validation & Authorization
* Persistence Layer - Storage Logic
* Database Layer - Actual Database

## 5. Describe the flow in all of the layers if an API is called by Postman.
### Control
* Entry Point: @Controller
* Request Mapping: @RequestMapping
* Service Call

### Service
* Business Logic

### Repository
* CRUD

### Response

## 6. What is the application.properties? do you know application.yml?
* Application.properties file is used to write the application-related property into that file. This file contains the different configuration which is required to run the application in a different environment, and each environment will have a different property defined by it. Inside the application properties file, we define every type of property like changing the port, database connectivity, connection to the eureka server, and many more.

## 7. What's the naming differences between GraphQL vs. REST ? Why is the differences ? 
* REST APIs are resource-based. Each resource (e.g., user, post, comment) is represented by a URL.
* GraphQL is operation-based, focusing on querying and mutating data rather than representing resources via URLs.

## 8. Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL. 
### Example 1: Fetching Authors and Their Books
* REST: GET /authors, GET /authors/1/books
* Graphql: 
```
query {
  authors {
    id
    name
    books {
      id
      title
    }
  }
}
```
### Example 2: Fetching Authors and Their Books
* REST: GET /users, GET /users/1/orders
* Graphql: 
```
query {
  users {
    id
    name
    orders {
      id
      item
    }
  }
}
```