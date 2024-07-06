# Hw8
## 1.  List all of the Spring data related annotations your learned and explain its usage.
### @JsonProperty
-  to indicate the property name in JSON.
```java
public class MyBean {
    public int id;
    private String name;

    @JsonProperty("name")
    public void setTheName(String name) {
        this.name = name;
    }

    @JsonProperty("name")
    public String getTheName() {
        return name;
    }
}
```
### @RequestMapping
-  used to define the URL mapping and the HTTP method for a particular handler method in a controller.
```java
@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
public ResponseEntity<User> getUserById(@PathVariable Long id) {
    // Logic to get a user by id
    User user = userService.findById(id);
    if (user != null) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

```
More annotations see [annotations.md](annotations.md)
## 2.  What is DTO, VO, Payload, PO, model, DAO?
### DTO (Data Transfer Object)
- An object that carries data between processes. 
- Often used to encapsulate data that will be sent over the network.
- Usually contain no business logic and are used solely for transferring data.
### VO (Value Object):
- An object that represents a simple entity whose equality is based on the value rather than the identity.
- Usually immutable.
### Payload:
- Referring to the data carried in a request or response.
- Can be thought of as the actual data sent or received
### PO (Persistent Object):
- An object that represents data that is stored persistently, typically in a database.
- Often mapped to database tables and can be managed by an ORM (Object-Relational Mapping) framework like Hibernate. 
### Model:
- Represents the application's data and business logic.
- Can be a combination of POJOs (Plain Old Java Objects), entities, and business logic components.
### DAO (Data Access Object):
- An object that provides an abstract interface to some type of database or other persistence mechanism.
- Typically contain methods for CRUD operations (Create, Read, Update, Delete).
## 3.  What is @JsonProperty("description_yyds")
The @JsonProperty annotation is used to specify how a Java object field is serialized and deserialized to and from JSON. The "description_yyds" is the name that will be used in the JSON representation of the object.\
For example, if we use it here
```java
public class Product {
    private String description;

    @JsonProperty("description_yyds")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description_yyds")
    public void setDescription(String description) {
        this.description = description;
    }
}

```
The JSON will be with the key
```
{
    "description_yyds": "blablabla"
}

```
## 4.  Explain the purpose of following dependency?
```
    <dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.13.3</version>
    <scope>compile</scope>
    </dependency>
```
- It adds jackson-databind library, a popular JSON processing library for Java, to the project
- Contains basic data binding (mapping) functionality that allows for reading JSON content into Java Objects (POJOs) and JSON Trees (JsonNode), as well as writing Java Objects and trees as JSON.
## 5.  What is spring-boot-stater?
- what dependecies in the below starter? do you know any starters?
```
    <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
```
- It is a set of convenient dependency descriptors provided by Spring Boot that aggregate commonly used libraries and frameworks.
- Including :
  - Spring Web: The core Spring Web module, including Spring MVC for building web applications and RESTful web services.
  - Spring Boot Starter: Basic Spring Boot dependencies and auto-configuration support.
  - Jackson Databind: For JSON processing (serialization and deserialization).
  - Tomcat: As the embedded servlet container (by default, but it can be replaced with others like Jetty or Undertow).
  - Validation API: For bean validation using Hibernate Validator.
- Other starters:
  - spring-boot-starter-test:
    - For testing Spring Boot applications.
    - Includes dependencies for JUnit, Spring TestContext Framework, AssertJ, Hamcrest, Mockito, JSONassert, and JsonPath.
```  
  <dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
  </dependency>
  ```
## 6.  Explain  @RequestMapping(value = "/users", method = RequestMethod.POST)  ? could you list CRUD by this style?
- @RequestMapping: Defines the URL mapping and the HTTP method for a particular handler method in a controller.
- value = "/users": Specifies that this handler method will be invoked for requests that have /users in the URL path.
- method = RequestMethod.POST: Specifies that this handler method will only handle HTTP POST requests.
### Post
```java
@RequestMapping(value = "/posts", method = RequestMethod.POST)
public ResponseEntity<User> createPost(@RequestBody PostDto postDto) {
    PostDto response = postService.createPost(postDto);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
}

```
### GET
```java
@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
public ResponseEntity<User> getPostById(@PathVariable Long id) {
    PostDto postDto = postService.findById(id);
    return ResponseEntity.ok(postService.getPostById(id));
}

```
### PUT
```java
@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
public ResponseEntity<User> updatePost(@PathVariable Long id, @RequestBody PostDto postDto) {
    PostDto updateDto = postService.updatePost(postDto, id);
    return ResponseEntity.ok(updateDto);
}
```
### DELETE
```java
@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
public ResponseEntity<Void> deletePostById(@PathVariable Long id) {
    postService.deletePostById(id);
    return new ResponseEntity<>("Post: "+id+" Deleted",HttpStatus.OK);
}
```
## 7.  What is ResponseEntity? why do we need it?
```
    new ResponseEntity<>(postResponse, HttpStatus.OK);
    new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    ResponseEntity.ok(postService.getPostById(id));
```
- It is a class that represents an HTTP response, including the status code, headers, and body. It is used to provide a more comprehensive and flexible way of returning HTTP responses from controller methods.
- We use it because it gives convenient access to default responses such as 
  - ResponseEntity.ok(): 200 OK, 
  - ResponseEntity.notFound().build(): 404 Not Found
  - ResponseEntity.noContent().build(): 204 No Content
  - HttpStatus.CREATED: 201 Created
  - etc.
- It also allows us to define custom responses, allowing us to define what should be contained in the responses
```java
@GetMapping("/posts/{id}")
public ResponseEntity<Post> getPostById(@PathVariable Long id) {
    Post post = postService.getPostById(id);
    if (post != null) {
        return ResponseEntity.ok(post); // Returns 200 OK with the post data
    } else {
        return ResponseEntity.notFound().build(); // Returns 404 NOT FOUND
    }
}
```
## 8.  What is ResultSet in jdbc? and describe the flow how to get data using JDBC
It is an interface in JDBC that represents the result set of a query executed in a database. It provides methods to iterate over the rows of the result set, access column values, and perform various operations on the retrieved data.
- Execute a query
```java
ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
```
- Process Result
```java
while (resultSet.next()) {
    int id = resultSet.getInt("id");
    String name = resultSet.getString("name");
    String email = resultSet.getString("email");
    System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
}
```
## 9.  Compare Spring Data JPA vs Hibernate vs JDBC.
| Spring Data JPA                                           | Hibernate                                                                                          | JDBC                                                                                                                                                  |
|-----------------------------------------------------------|----------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------|
| High-level abstraction                                    | Medium-level abstraction                                                                           | Low-level abstraction                                                                                                                                 |
| Provides a repository abstraction over JPA                | Provides ORM (Object-Relational Mapping) framework that abstracts away much of the underlying SQL. | Directly interacts with the database using SQL.                                                                                                       |
| Automatically generates queries thus less code is needed  | Offers a rich set of features for mapping Java objects to database tables.                         | Requires manual handling of connections, statements, and result sets.                                                                                 |
| Very easy to use                                          | requires knowledge of Hibernate's features and configurations                                      | Requires writing raw SQL queries and handling all database interactions manually, also gives full control over SQL execution and database interactions |
| Less Performance                                          | Moderate Performance                                                                               | Best Performance                                                                                                                                      |
| Less Flexibility                                          | Moderate Flexibility                                                                               | Most Flexibility                                                                                                                                      |
## 10.  Learn how to use ObjectMapper by this example.
- https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/exercise/oa/api/FoodOutletJackson.java
```
    FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);
    String s = objectMapper.writeValueAsString(foodOutlet);
    objectMapper.readTree(); // learn how to use it?
```
- ObjectMapper is used from the Jackson library to handle JSON serialization and deserialization.

- The line ``FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);``
  - readValue() method is used to deserialize JSON (resBody) into a Java object (FoodOutlet) based on @JsonProperty
- The Line ``String s = objectMapper.writeValueAsString(foodOutlet);``
  - serializes a Java object (FoodOutlet) into a JSON string
- objectMapper.readTree();
  - useful when you want to handle JSON data without necessarily mapping it to specific Java classes. It allows for more flexible handling of JSON content.
  - eg.
  ```java

        JsonNode jsonNode = objectMapper.readTree(jsonString);

        String name = jsonNode.get("name").asText();
        int age = jsonNode.get("age").asInt();
        String city = jsonNode.get("city").asText();
        boolean employed = jsonNode.get("employed").asBoolean();
        JsonNode skillsNode = jsonNode.get("skills"); 
  ```
## 11.  What is the serialization and desrialization?
- https://hazelcast.com/glossary/serialization/
### Serialization
Serialization is the process of converting a data object, a combination of code and data represented within a region of data storage, into a series of bytes that saves the state of the object in an easily transmittable form.
## Deserialization
The reverse process, constructing a data structure or object from a series of bytes
## 12.  use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
```java
int[] array = new int[]{20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
Double ave = Arrays.stream(array).average().orElse(0.0);
```
## 13.  抄写并理解 https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageable 下的代码
## 14.  抄写并理解 https://github.com/TAIsRich/springboot-redbook/tree/04_comment 下的代码