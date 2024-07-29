## HW9

2. What is DTO, VO, Payload, PO, model, DAO?

   >DTO(Data Transfer Object) is used to transfer data between different layers.
   >
   >A Value Object is an object that represents a descriptive aspect of the domain with no conceptual identity
   >
   >payload refers to the part of transmitted data that is the actual intended message.
   >
   >Persistent Objects or POs are used in ORM (Object-Relational Mapping) frameworks where objects are mapped to database records.
   >
   >In MVC (Model-View-Controller) architecture, the model represents the data and the business rules that govern access to and updates of this data
   >
   >DAOs are a pattern that provides an abstract interface to some type of database or other persistence mechanism.

3. What is @JsonProperty("description_yyds") 

   >This annotation is used to map JSON property names("description_yyds") in JSON data to Java object fields.

4. Explain the purpose of following dependency? 

   >```java
   ><dependency>
   ><groupId>com.fasterxml.jackson.core</groupId>
   ><artifactId>jackson-databind</artifactId>
   ><version>2.13.3</version>
   ><scope>compile</scope>
   ></dependency>
   >```
   >
   >jackson-databind is a part of the Jackson library that provides data-binding (also known as serialization and deserialization) functionality between Java objects and JSON

5. What is spring-boot-stater? 

   >It includes all the dependencies that are used for a spring boot application.

   1. what dependecies in the below starter? do you know any starters? 

      ```java
      <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
      </dependency>
      ```

      >```java
      ><dependency>
      >  <groupId>org.springframework.boot</groupId>
      >  <artifactId>spring-boot-starter</artifactId>
      >  <version>3.3.1</version>
      >  <scope>compile</scope>
      ></dependency>
      ><dependency>
      >  <groupId>org.springframework.boot</groupId>
      >  <artifactId>spring-boot-starter-json</artifactId>
      >  <version>3.3.1</version>
      >  <scope>compile</scope>
      ></dependency>
      ><dependency>
      >  <groupId>org.springframework.boot</groupId>
      >  <artifactId>spring-boot-starter-tomcat</artifactId>
      >  <version>3.3.1</version>
      >  <scope>compile</scope>
      ></dependency>
      ><dependency>
      >  <groupId>org.springframework</groupId>
      >  <artifactId>spring-web</artifactId>
      >  <version>6.1.10</version>
      >  <scope>compile</scope>
      ></dependency>
      ><dependency>
      >  <groupId>org.springframework</groupId>
      >  <artifactId>spring-webmvc</artifactId>
      >  <version>6.1.10</version>
      >  <scope>compile</scope>
      ></dependency>
      >```

6. Explain @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style? 

   >This endpoint will be requested by post and the request path is /users
   >
   >@RequestMapping(value = "/users", method = RequestMethod.GET)
   >
   >@RequestMapping(value = "/users", method = RequestMethod.PUT)
   >
   >@RequestMapping(value = "/users", method = RequestMethod.DELETE)

7. What is ResponseEntity? why do we need it? 

   >`ResponseEntity` is a class in Spring Framework, used extensively in the development of RESTful web services with Spring MVC. It represents the entire HTTP response message, which includes status code, headers, and body. This allows developers to fully configure the response returned from an API endpoint.

8. What is ResultSet in jdbc? and describe the flow how to get data using JDBC 

   >ResultSet is the query results from a specific SQL query.
   >
   >Workflow:
   >
   >1. Establishing a connection 
   >2. Creating a prepared statement or query 
   >3. Execute the query 
   >4. Looping through the result set to get the objects 
   >5. Close the connection

9. Compare Spring Data JPA vs Hibernate vs JDBC. 

   >Spring Data JPA is the highest-level API of these three, which abstracts all the common database operations.
   >
   >Hibernate is an implementation of the JPA. Spring data JPA is an abstraction of JPA to automate the configuration.
   >
   >JDBC is the lowest-level API for interacting with the database using JAVA

10. What is the serialization and deserialization? 

    >**Serialization** and **deserialization** are fundamental concepts in computing related to the process of converting data structures or object states into a format that can be stored (for example, in a file or memory buffer) or transmitted (over a network) and then reconstructed later.

11. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32]. 

    >```java
    >public static double getAverage(int[] nums){
    >    return Arrays.stream(nums).average().orElse(0);
    >}
    >```