# HW8

1. **What is DTO, VO, Payload, PO, model, DAO?**
    
    DTO: Used to transfer data between layers
    
    VO value object: Used to present the properties of the model.
    
    Payload: The payload of the request(kind of like DTO)
    
    PO persistent object: Present the data that can be persisted in the database.
    
    Model: Represent the data and the rules of the application. It can consist of persistence objects, business logic, and service methods to manipulate the data.
    
    DAO: DAOs are used to abstract and encapsulate all access to a data source. DAOs manage the connection with the data source to obtain and store data.
    
2. **What is @JsonProperty("description_yyds")**
    
    It can be used in the Scenarios if the name of request body from client is different from the DTO. It will map the particular field to “description_yyds” when the object is serialized to JSON or deserialized from JSON.
    
    eg:
    
    ```java
     @JsonProperty("description_yyds")
     private String description;
     
     request:
     {
    	  "name": "Sample Name",
    	  "description_yyds": "An important detail"
     }
    ```
    
3. **Explain the purpose of following dependency?**
    
    It support reading from and writing to JSON from Java objects. It can convert JSON to and from Plain Old Java Objects (POJOs) using the ObjectMapper class. It supports both:Serialization: Converting Java objects to JSON. And Deserialization: Converting JSON to Java objects.
    

```java
<dependency> 
	<groupId>com.fasterxml.jackson.core</groupId> 
	<artifactId>jackson-databind</artifactId> 
	<version>2.13.3</version>
	 <scope>compile</scope>
</dependency>
```

1. **What is spring-boot-stater?** 
    
    what dependecies in the below starter? do you know any starters?
    
    ```java
    <dependency> 
    	<groupId>org.springframework.boot</groupId> 
    	<artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    ```
    
    Spring-boot-start-web contains: Spring core, Spring Bean, Spring web MVC, Spring web, Jackson, Validation API, embedded Tomcat, Spring Boot AutoConfiguration and Spring boot Actuator.
    
2. **Explain @RequestMapping(value = "/users", method = RequestMethod.POST)? could you list CRUD by this style?**
    
    /users specifies the URL pattern that the controller method will handle.
    
    [RequestMethod.POST](http://RequestMethod.POST) indicates that it only accept Http POST requests.
    
    ```java
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // logic to create a user
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        // logic to retrieve all users
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        // logic to retrieve a specific user by id
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        // logic to update an existing user
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        // logic to delete a user
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    ```
    
3. **What is ResponseEntity? why do we need it?**
    
    ResponseEntity is used to represent the entire HTTP request,  including the status code, headers, and body.
    
4. **What is ResultSet in jdbc? and describe the flow how to get data using JDBC**
    
    ResultSet is a interface which represent a table of data representing a database result set, which maintains a cursor pointing to its current row of data. ResultSet allows navigation, data. retrieval, concurrency.
    
    The Flow to get data using JDBC is:
    
    1. establishing a connection
    2. creating a prepared statement or query
    3. execute the query
    4. looping through the result set to get the object
    5. close the connection
5. **Compare Spring Data JPA vs Hibernate vs JDBC.**
    
    JDBC is the low level API for database interactions, Spring Data JPA is the high-level API for data access using the repository pattern. If we choose Hibernates as the dependency, Hibernates will provide ORM solution for Spring Data JPA APIs.
    
    ![Untitled](HW8%2064f1d8f94d0a484f95a376678e2ce004/Untitled.png)
    
6. **What is the serialization and desrialization?**
    
    Convert the into a format. Deserialization is the reverse process of serialization.
    
7. **use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32**]

```java
int[] numbers = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
OptionalDouble average = Arrays.stream(numbers).average();
```