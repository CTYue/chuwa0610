1.  List all of the Spring data related annotations your learned and explain its usage.
### @Entity
- Marks a class as an entity bean, typically a table in a database.

### @Table
- Specifies the table name in the database that maps to the entity.

### @Id
- Marks a field as the primary key of the entity.

### @GeneratedValue
- Specifies how the primary key should be generated (e.g., AUTO, IDENTITY, SEQUENCE, TABLE).

### @Column
- Specifies the mapped column for a persistent property or field.

### @OneToOne
- Defines a one-to-one relationship between two entities.

### @OneToMany
- Defines a one-to-many relationship between two entities.

### @ManyToOne
- Defines a many-to-one relationship between two entities.

### @ManyToMany
- Defines a many-to-many relationship between two entities.

### @JoinColumn
- Specifies the foreign key column for the relationship.

### @Repository
- Indicates that the class is a repository that interacts with the database.

### @Query
- Defines a custom query using JPQL or native SQL.

### @Transactional
- Specifies that the method or class should be executed within a transaction.

2.  What is DTO, VO, Payload, PO, model, DAO?
#DTO (Data Transfer Object)
- A simple object used to transfer data between layers of an application.

#VO (Value Object)
- An object that contains values but no behavior, typically immutable.

#Payload
- The body of a request or response, often used in the context of web services.

#PO (Persistent Object)
- An object that represents data stored in a database.

#Model
- A representation of the business domain, often containing both data and behavior.

#DAO (Data Access Object)
- An object that provides an abstract interface to some type of database or other persistence mechanism.

3.  What is @JsonProperty("description_yyds") 
This annotation is used in Jackson library to map a JSON property to a Java field. In this case, it maps the JSON property `description_yyds` to the Java field it annotates.

4.  Explain the purpose of following dependency?
 It declares that the project depends on the jackson-databind library from the com.fasterxml.jackson.core group, in version 2.13.3.

5.  What is spring-boot-stater? 
`spring-boot-starter` is a convenient dependency descriptor you can include in your application to pull in common dependencies and simplify configuration.
1.  what dependecies in the below starter? do you know any starters?
The spring-boot-starter-web dependency includes the following dependencies:

Spring MVC: The web framework for creating RESTful web services and web applications.
Spring Core: The core components and configurations needed for a Spring application.
Spring Context: Support for dependency injection and managing application context.
Spring AOP: Provides aspect-oriented programming capabilities.
Spring Beans: Allows for managing and configuring beans.
Spring Web: Supports web application development.
Spring WebMVC: Provides the MVC framework for building web applications.
Jackson: For JSON processing.
Validation API: For validating user input.
Tomcat: Embedded servlet container for running web applications.

6.  Explain  @RequestMapping(value = "/users", method = RequestMethod.POST)  ? could you list CRUD by 
this style?

This annotation maps HTTP requests to handler methods of MVC and REST controllers. The example maps a POST request to `/users` URL to a specific method.

7. What is ResponseEntity? why do we need it?
Key Features of ResponseEntity:
Status Code: Allows you to set the HTTP status code of the response.
Headers: Lets you add or manipulate HTTP headers.
Body: Holds the body of the response, which can be any type of object.
Why Do We Need ResponseEntity?
Customizing HTTP Responses: You can fully customize the HTTP response, including setting headers and status codes. This is useful for providing detailed response information, such as error messages or success confirmations.
Error Handling: It allows you to return appropriate HTTP status codes (e.g., 404 Not Found, 500 Internal Server Error) along with error messages.
Flexibility: Offers more control over the response compared to returning just the response body object. You can set response headers, cookies, and status codes, which are essential for building robust REST APIs.
Convenience: Provides a fluent API for building responses, making the code more readable and maintainable.

8. What is ResultSet in jdbc? and describe the flow how to get data using JDBC
Key Features of ResultSet:
Data Access: Provides methods to access the data in a row-by-row manner.
Cursor Movement: By default, the cursor moves forward only, but you can create scrollable ResultSet objects.
Type and Concurrency: ResultSet can be of different types (TYPE_FORWARD_ONLY, TYPE_SCROLL_INSENSITIVE, TYPE_SCROLL_SENSITIVE) and concurrency modes (CONCUR_READ_ONLY, CONCUR_UPDATABLE).
Basic Flow to Retrieve Data Using JDBC
Load the JDBC Driver: The driver is required for establishing a connection with the database.
Establish a Connection: Use the DriverManager to establish a connection to the database.
Create a Statement: Create a Statement object to execute SQL queries.
Execute the Query: Use the Statement object to execute a query and get a ResultSet.
Process the ResultSet: Iterate over the ResultSet to retrieve the data.
Close the Resources: Close the ResultSet, Statement, and Connection to release the resources.

9. Compare Spring Data JPA vs Hibernate vs JDBC
Spring Data JPA
Abstraction Level: High-level abstraction over JPA (Java Persistence API).
Ease of Use: Simplifies data access layers with minimal boilerplate code; provides repository interfaces and automatic query generation.
Features: Built-in support for pagination, sorting, and custom query methods. Integrates seamlessly with Spring Boot.
Usage: Ideal for developers seeking quick, out-of-the-box solutions for database operations with Spring framework integration.
Hibernate
Abstraction Level: ORM (Object-Relational Mapping) framework implementing JPA.
Ease of Use: More complex than Spring Data JPA, but offers fine-grained control over database operations.
Features: Advanced caching, lazy loading, dirty checking, and criteria queries. Extensive support for various database operations and relationships.
Usage: Suitable for applications requiring complex ORM capabilities and fine-tuned performance optimizations.
JDBC
Abstraction Level: Low-level API for direct database interaction.
Ease of Use: Requires significant boilerplate code for common tasks like connection management, query execution, and result set handling.
Features: Provides direct control over SQL execution and database interactions. No abstraction, leading to more explicit and manual management.
Usage: Best for applications needing precise control over SQL execution and performance, or when using databases unsupported by higher-level frameworks.

10. Learn how to use ObjectMapper by this example.
readValue():converts JSON content into a Java object.
writeValueAsString():converts a Java object into a JSON string.
readTree():reads JSON content as a JsonNode, allowing for more flexible processing.

11. What is the serialization and desrialization?
Serialization
Serialization is the process of converting a Java object into a format that can be easily stored (in a file or database) or transmitted (over a network). This format is usually a string (like JSON or XML) or a binary format.
Purpose: To save the state of an object so it can be recreated later.
Use Cases: Saving objects to a file, sending objects over a network, caching objects, etc.

Deserialization
Deserialization is the process of converting data from a storage format back into a Java object. This is essentially the reverse of serialization.
Purpose: To recreate an object from its serialized form.
Use Cases: Reading objects from a file, receiving objects over a network, loading cached objects, etc.

12. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32]
```java
int[] numbers = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};

// Calculate the average using Stream API
double average = Arrays.stream(numbers)
                        .average()
                        .orElse(Double.NaN); // Handle empty arrays by returning NaN
```
