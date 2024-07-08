## 1. List all of the Spring data related annotations your learned and explain its usage.
* @Entity:  Specifies that the class is an entity.
* @Table: It specifies the table in the database with which this entity is mapped.
* @Column: Specify the column mapping.
* @Id: marks a field in a model class as the primary key.
* @CreatedBy, @LastModifiedBy, @CreatedDate, @LastModifiedDate: automatically populates.
* @Transient: Every non static and non-transient property of an entity is considered persistent, unless you annotate it as @Transient.
* @JoinColumn: foreign key.

## 2. What is DTO, VO, Payload, PO, model, DAO?
* DTO: Data Transfer Object
* VO: Value Object
* Payload: The part after the headers and the CRLF of a HTTP Request.
* PO: Persistent Object, one that continues to exist after the program that created it has been unloaded
* model: The internal representations of information
* DAO: Data Access Object

## 3. What is @JsonProperty("description_yyds") 
* Map a JSON property "description_yyds" to a field in a Java object.

## 4. Explain the purpose of following dependency?
```
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.13.3</version>
    <scope>compile</scope>
</dependency>

```
* jackson-databind library: JSON Serialization and Deserialization, Annotations Support, ObjectMapper.

## 5.  What is spring-boot-stater?
* A set of convenient dependency descriptors that you can include in your application.
### 1) what dependecies in the below starter?
* Sspring boot starter, Jackson, spring core, spring MVC, spring boot starter tomcat.
### 2) do you know any starters?
* spring-boot-starter-test, spring-boot-starter-mail.

## 6.  Explain  @RequestMapping(value = "/users", method = RequestMethod.POST)  ? could you list CRUD by this style?
* Map POST request on url/users to this function.
``` java
@RequestMapping(value = "/users", method = RequestMethod.GET)
@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
```

## 7. What is ResponseEntity? why do we need it?
* ResponseEntity represents the whole HTTP response: status code, headers, and body.
* We can use it to fully configure the HTTP response.

## 8. What is ResultSet in jdbc? and describe the flow how to get data using JDBC.
* ResultSet provides methods to iterate through the results of a query.
* Connection -> Create Statement -> Execute Query -> Process ResultSet.

## 9. Compare Spring Data JPA vs Hibernate vs JDBC.
* Java Database Connectivity (JDBC) is an API for the Java programming language which defines how a client may access a database. 
* JPA (Java Persistence API): Aims to significantly improve the implementation of data access layers by reducing the effort to the amount that's actually needed.
* Hibernate: Hibernate is an implementation of JPA.

## 11. What is the serialization and desrialization?
* Serialization is the process of converting an object or data structure into a format that can be easily stored or transmitted.
* Deserialization is the process of converting a serialized format back into an object or data structure.

## 12. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
``` java
public class StreamAverage {
    public static void main(String[] args) {
        int[] numbers = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
        double average = Arrays.stream(numbers).average()
        System.out.println(average);
    }
}


```