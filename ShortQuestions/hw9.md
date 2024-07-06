## 2. What is DTO, VO, Payload, PO, model, DAO?
- **DTO(Data Transfer Object)**: An object that carries data between processes in order to reduce the number of method calls.
DTO does NOT have any behavior and business logic, except for storage, retrieval, serialization and deserialization of its own data.
- **VO(Value Object)**: is a special type of object that can hold values such as java.lang.Integer and java.lang.Long.
- **Payload**: Annotation that binds a method parameter to the payload of a message. Can also be used to associate a payload to a method invocation. The payload may be passed through a MessageConverter to convert it from serialized form with a specific MIME type to an Object matching the target method parameter.
- **PO(Persist Object)**: Represents data stored in a database. Annotations like `@Entity`, `@Table`, `@Id`, `@Column`, etc., are commonly used in PO
- **Model**: supply attributes used for rendering views. To provide a view with usable data, we simply add this data to its Model object. Additionally, maps with attributes can be merged with Model instances
- **DAO(Data Access Objects)**: The DataAccessObject abstracts the underlying data access implementation for the BusinessObject to enable transparent access to the data source. It provides a standardized interface to perform CRUD operations on entities.

## 3. What is @JsonProperty("description_yyds")
`@JsonProperty` annotation is used to indicate the property name in JSON. It is for handling JSON serialization and deserialization. `@JsonProperty("description_yyds")` specifies the Java object below is mapped to "description_yyds".

## 4. Explain the purpose of following dependency?
```
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>2.13.3</version>
  <scope>compile</scope>
</dependency>
```
This dependency is for the Jackson Databind library, which is a part of the larger Jackson suite of data-processing tools in Java.
**Jackson Databind** is a Java library that is primarily used for serializing Java objects to JSON and deserializing JSON back to Java objects. It forms the backbone of JSON processing in many Java applications and frameworks, including Spring Boot.
### Key Featrues
1. **Object-JSON Serialization**: It can convert Java objects into their JSON representation, allowing for easy transmission over networks, storage in text-based formats, or simply for usage within JavaScript in web applications.

2. **JSON-Object Deserialization**: It converts JSON data into Java objects. This is especially useful when dealing with data from REST APIs or configurations that are delivered in JSON format.

3. **Data Binding**: Jackson supports various forms of data binding. It can do simple data binding (Java structures to JSON and vice-versa), full data binding (JSON to Java objects), and even untyped data binding (JSON to Java Maps, Lists, etc.).

4. **Annotations and Customization**: Jackson provides numerous annotations to customize the serialization and deserialization processes, such as @JsonProperty, @JsonIgnore, and @JsonFormat. These can control naming, format, inclusion/exclusion criteria, and more.

5. **Flexibility**: It works with any JSON-compatible data, supports extensive data formats beyond JSON (through extensions), and allows extensive customization of the binding process.

### Usage
1. **Web Applications**: For RESTful services where JSON is a standard media type for request and response bodies. Frameworks like Spring MVC and Spring Boot automatically configure Jackson for JSON processing.
2. **Microservices**: For data exchange between different microservices, often using JSON over HTTP or message brokers.
Configuration Management: For reading configurations written in JSON.
3. **Data Storage and Retrieval**: For storing data in JSON format in databases or other storage systems and retrieving it back into Java applications.

## 5. What is spring-boot-starter? what dependecies in the below starter? do you know any starters?
```
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
**spring-boot-starter** are a set of convenient dependency descriptors that you can include in your application. Each starter is designed to provide a specific type of functionality—ranging from web development to connecting to data stores—enabling you to add necessary dependencies to your project quickly and easily without having to worry about version compatibility and dependency conflicts.  
The dependency above is spring boot starter web. It is used for building web application using Spring MVC. It includes Tomcat as the default embedded container. It is commonly used for developing RESTful web service or traditional MVC applications.  
Other commonly used Spring starters include:
- `spring-boot-starter-data-jpa`: provides supoort for using Java Persistence API(JPA) to connect to relational databases.
- `spring-boot-starter-security`: adds security features to the application, such as authentication and authorization.
- `spring-boot-starter-test`: provides libraries necessary for testing Spring Boot application with libraries like JUnit, Hamcrest, and Mockito.

## 6. Explain @RequestMapping(value = "/users", method = RequestMethod.POST)? could you list CRUD by this style?
`@RequestMapping` annotation is used to map web requests to Spring Controller methods. This specific one sets up a post request endpoint at /users.  
- **C(create)**: `@RequestMapping(value = "/users", method = RequestMethod.POST)`.
- **R(Read)**: `@RequestMapping(value = "/users", method = RequestMethod.GET)`
- **U(update)**: `@RequestMapping(value = "/users", method = RequestMethod.PUT)`/`@RequestMapping(value = "/users", method = RequestMethod.PATCH)`
-**D(delete)**: `@RequestMapping(value = "/users", method = RequestMethod.DELETE)`

## 7. What is ResponseEntity? why do we need it?
```
new ResponseEntity<>(postResponse, HttpStatus.OK);
new ResponseEntity<>(postResponse, HttpStatus.CREATED);
ResponseEntity.ok(postService.getPostById(id));
```
ResponseEntity is used for setting up the body, status, and headers of an HTTP response. The code snippet above demonstrates the two ways to return a HTTP response using ResponseEntity

## 8. What is ResultSet in jdbc? and describe the flow how to get data using JDBC.
The ResultSet is a table of data generated by executing database queries.  
We can first retrieve a ResultSet by calling `executeQuery()` on any object implementing the Statement interface.  
```
PreparedStatement pstmt = dbConnection.prepareStatement("select * from employees");
ResultSet rs = pstmt.executeQuery();
```
The ResultSet object maintains a cursor that points to the current row of the result set. We can use `next()` method to iterate through the records.  
```
while(rs.next()) {
    String name = rs.getString("name");
    Integer empId = rs.getInt("emp_id");
    Double salary = rs.getDouble("salary");
    String position = rs.getString("position");
}
```
While iterating through the results, we can also use `getX()` methods to fetch the values from the database columns. Where X is the datatype of the column.
```
Integer empId = rs.getInt(1);
String name = rs.getString(2);
String position = rs.getString(3);
Double salary = rs.getDouble(4);
```

## 9. Compare Spring Data JPA vs Hibernate vs JDBC.
1. **Java Persistence API(JPA)**  
JPA is a specification that defines a standard interface for Java applications to interact with relational databases. It simplifies database access by providing a set of annotations and APIs for mapping Java objects to database tables. JPA is not an implementation but rather a set of rules that frameworks, like Hibernate, implement.
2. **Hibernate: A Robust JPA Implementation**  
Hibernate is a powerful and widely used Object-Relational Mapping (ORM) framework. It is a JPA implementation, meaning it adheres to the rules set by the JPA specification. Hibernate goes beyond JPA, offering additional features and optimizations. Developers often choose Hibernate when they need a full-featured ORM framework with advanced capabilities for complex database interactions.
3. **Java Database Connectivity (JDBC): The Foundation**  
JDBC is the standard Java API for connecting to relational databases. Unlike JPA and Hibernate, JDBC is lower level and requires developers to write SQL queries and handle result sets manually. While it offers more control, it also demands more code. JDBC is often used when fine-grained control over database interactions is required, or when working with databases not covered by higher-level frameworks.
### JPA vs. Hibernate
- **JPA**: A specification defining a set of rules for Java applications to interact with databases.
- **Hibernate**: A full-fledged ORM framework implementing the JPA specification with additional features.
### JPA vs. JDBC
- **JPA**: Higher-level abstraction with object-relational mapping, reducing the need for manual SQL.
- **JDBC**: Lower-level API requiring manual SQL queries and result set handling.
### Hibernate vs. JDBC:
- **Hibernate**: An ORM framework providing higher-level abstractions, automatic table creation, and caching.
- **JDBC**: Direct and low-level database access, offering more control but demanding more manual coding.
### Spring Data vs. JPA/Hibernate:
- **Spring Data**: Part of the Spring ecosystem, providing a simplified and consistent approach to data access.
- **JPA/Hibernate**: Lower-level frameworks with richer features but potentially more boilerplate code.

### How they relate
- **JPA and Hibernate**: Hibernate is a JPA implementation. Developers often use the terms interchangeably, but it's essential to recognize that Hibernate extends JPA with additional features.
- **JPA and JDBC**: JDBC is the lower-level foundation that JPA builds upon. JPA simplifies database access by introducing object-relational mapping and higher-level abstractions.
- **Hibernate and JDBC**: Hibernate abstracts JDBC, providing a higher-level API for developers. While JDBC is manually code-intensive, Hibernate automates many aspects of database access.

## 11. What is the serialization and desrialization?
**Serialization** is the process of converting a data object—a combination of code and data represented within a region of data storage—into a series of bytes that saves the state of the object in an easily transmittable form. In this serialized form, the data can be delivered to another data store (such as an in-memory computing platform), application, or some other destination.  
The reverse process—constructing a data structure or object from a series of bytes—is deserialization. The **deserialization** process recreates the object, thus making the data easier to read and modify as a native structure in a programming language.

## 12. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
```
int[] arr = new int[]{20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
OptionalDouble opt = Arrays.stream(arr).average();
if(opt.isPresent()){
   System.out.println(opt.getAsDouble());
} else {
   System.out.println("Empty array");
}
// Output:
// 39.7
```