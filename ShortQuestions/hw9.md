# Hw8
## 1.  List all of the Spring data related annotations your learned and explain its usage.
## 2.  What is DTO, VO, Payload, PO, model, DAO?
## 3.  What is @JsonProperty("description_yyds")
## 4.  Explain the purpose of following dependency?
```
    <dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.13.3</version>
    <scope>compile</scope>
    </dependency>
```
## 5.  What is spring-boot-stater?
- what dependecies in the below starter? do you know any starters?
```
    <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
```
## 6.  Explain  @RequestMapping(value = "/users", method = RequestMethod.POST)  ? could you list CRUD by this style?
```
    new ResponseEntity<>(postResponse, HttpStatus.OK);
    new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    ResponseEntity.ok(postService.getPostById(id));
```
## 7.  What is ResponseEntity? why do we need it?
## 8.  What is ResultSet in jdbc? and describe the flow how to get data using JDBC
## 9.  Compare Spring Data JPA vs Hibernate vs JDBC.
## 10.  Learn how to use ObjectMapper by this example.
- https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/exercise/oa/api/FoodOutletJackson.java
```
    FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);
    String s = objectMapper.writeValueAsString(foodOutlet);
    objectMapper.readTree(); // learn how to use it?
```
## 11.  What is the serialization and desrialization?
- https://hazelcast.com/glossary/serialization/
## 12.  use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
## 13.  抄写并理解 https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageable 下的代码
## 14.  抄写并理解 https://github.com/TAIsRich/springboot-redbook/tree/04_comment 下的代码