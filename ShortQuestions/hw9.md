1. List all of the Spring data related annotations your learned and explain its usage.
    - @Entity
      - mark a java class as an entity
    - @Table
      - specify details of the table
    - @Id
      - primary key
    - @Column
      - specify more constrains of the column, like name, length, nullable, unique
    - relationship between two tables, can specify the cascade type, fetch type
      - @OneToOne
      - @ManyToOne, @OneToMany
      - @ManyToMany
    - @JoinColumn
      - to define the foreign key
    - @JoinTable
      - for many to many relationship, will sepcify the composite primary key
      

2. What is DTO, VO, Payload, PO, model, DAO?
   - DTO
     - transfer data between different layers of the application, typically transfer data between controller and view layers
   - VO
     - value object, represents a set of values, typically immutable
   - payload
     - could be dto and some response send to client
   - PO
     - Persistent Object, similar to  entity
   - model
     - entity class that defines the table in the db
   - DAO
     - manage the database access and operations, the xxxRepository
   
3. What is @JsonProperty("description_yyds")   
    specify the field is JSON and will use "description_yyds" as property name.


4. Explain the purpose of following dependency?
    ```
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.13.3</version>
        <scope>compile</scope>
    </dependency>
    ```
    add dependency `Jackson` to the project, then in the project, we can convert string to JSON format.


5. What is spring-boot-stater?
    it refers to a set of dependencies that provided by SpringBoot. 
    It allows developers to quickly and easily add dependencies and configure the application. 
   1. what dependecies in the below starter? do you know any starters?
    ```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    ```
   - it includes dependencies for building web applications, including springMVC, RESTFul services and tomcat
   - Others:
     - data jpa
     - security
     - test
     - thymeleaf
    
6. Explain  @RequestMapping(value = "/users", method = RequestMethod.POST)  ? could you list CRUD by
    this style?
    - create a HTTP POST with URL ".../users"
      - @PostMapping
    - @RequestMapping(value = "/users", method = RequestMethod.GET)
      - @GetMapping
    - @RequestMapping(value = "/users", method = RequestMethod.PUT)
      - @PutMapping
    - @RequestMapping(value = "/users", method = RequestMethod.DELETE)
      - @DeleteMapping
    - @RequestMapping(value = "/users", method = RequestMethod.PATCHJJJJ)
      - @PatchMapping

7. What is ResponseEntity? why do we need it?
   ```
    new ResponseEntity<>(postResponse, HttpStatus.OK);
    new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    ResponseEntity.ok(postService.getPostById(id));
   ```
   - ResponseEntity represents the whole HTTP response: status code, headers and body.
   - why need:
     - provide precise control over the HTTP response
     - easy to handle difference scenarios, such as 404 not found, 2xx code
   
8. What is ResultSet in jdbc? and describe the flow how to get data using JDBC
    - ResultSet is a class represent the set of rows and columns retrieved from the database
    - flow
      - Establish database connection
        `Connection conn = DriverManager.getConnection(...)`
      - create statement and sql query
        ```
        String sql = "select * from ...";
        Statement stmt = conn.creatStatement()
        
        ```
      - execute query and get ResultSet
        `Resultset rs = stat.executeQuery(sql)`
      - fetch data
        ```
        while(rs.next()) {
        
        }
        ```
      - close connection
        ```
        rs.close()
        stmt.close()
        conn.close()
        ```
    
9. Compare Spring Data JPA vs Hibernate vs JDBC.
    
    |                      | Spring Data JPA   | Hibernate         | JDBC   |
    |----------------------|-------------------|-------------------|--------|
    | Level of abstraction | High              | Medium to High    | Low    |
    | Boilerplate code     | Minimal           | Moderate          | High   |
    | Trasaction           | Built-in          | Built in          | Manual |
    | Query                | naming convention | naming convention | manual |

10. Learn how to use ObjectMapper by this example.
    1.  https://github.com/CTYue/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/exercise/oa/api/FoodOutletJackson.java
         ```
          FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);
            // define a class FoodOutlet, convert String to data structure FoodOutlet(similar to JSONObject)
          String s = objectMapper.writeValueAsString(foodOutlet);
            // convert FoodOutleft to String
          objectMapper.readTree() // learn how to use it?
        
         ```
    - Method to deserialize JSON content as tree expressed using set of JsonNode instances
    - JsonNode readTree(byte[] content)
    - JsonNode readTree(File)
    - JsonNode readTree(JsonParser jp)
    - JsonNode readTree(Reader r)
    - JsonNode readTree(String content)
    - JsonNode readTree(URL source)
    ```
    import com.fasterxml.jackson.databind.JsonNode;
    
    String BASE_URL = "https://jsonmock.hackerrank.com/api/food_outlets?city=Seattle";
    String URL_Addr = BASE_URL + "&page=1";
    int maxCost = 140;
    
    
    JsonNode jsonNode =objectMapper.readTree(new URL(BASE_URL));
    JsonNode data = jsonNode.get("data");

    List<JsonNode> list = StreamSupport.stream(data.spliterator(), false).filter(d -> Integer.valueOf(d.get("estimated_cost").toString()) <= maxCost).map(d -> d.get("name")).collect(Collectors.toList());
    System.out.println(list.toString());
    ```
    
11.  What is the serialization and desrialization?
    1.  https://hazelcast.com/glossary/serialization/   
    Serialization is a process of converting an object into a stream of bytes to more easily save or transmit it.
    Deserialization is to convert bytes to original object for easier read. 
   

    
12. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
    `Double a = Arrays.stream(arr).average().orElse(0);`

13. 抄写并理解 https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageable 下的代码
    [code](../Coding/hw9/13)
14. 抄写并理解 https://github.com/TAIsRich/springboot-redbook/tree/04_comment 下的代码
    [code](../Coding/hw9/14)