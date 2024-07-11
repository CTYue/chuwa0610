1. List all of the Spring data related annotations your learned and explain its usage.
2. What is DTO, VO, Payload, PO, model, DAO?
3. What is @JsonProperty("description_yyds") 
4. Explain the purpose of following dependency?
5. What is spring-boot-stater? 
6. what dependecies in the below starter? do you know any starters?
7. Explain @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by 
   this style?
8. What is ResponseEntity? why do we need it?
9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC
10. Compare Spring Data JPA vs Hibernate vs JDBC.
11. Learn how to use ObjectMapper by this example.
12. https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/ex
    ercise/oa/api/FoodOutletJackson.java
13. What is the serialization and desrialization?
14. https://hazelcast.com/glossary/serialization/
    com.fasterxml.jackson.core
    jackson-databind
    2.13.3
    compile
    org.springframework.boot
    spring-boot-starter-web
    new ResponseEntity<>(postResponse, HttpStatus.OK);
    new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    ResponseEntity.ok(postService.getPostById(id));
    FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);
    String s = objectMapper.writeValueAsString(foodOutlet);
    objectMapper.readTree() // learn how to use it?
15. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
16. 抄写并理解 https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageable 下的代码
17. 抄写并理解 https://github.com/TAIsRich/springboot-redbook/tree/04_comment 下的代
