## @SpringBootApplication
* This annotation is used to mark the main class of a Spring Boot application. It encapsulates @SpringBootConfiguration, @EnableAutoConfiguration, and @ComponentScan annotations with their default attributes.
``` java
@SpringBootApplication
// Class 
public class DemoApplication { 
  
    // Main driver method 
    public static void main(String[] args) 
    { 
  
        SpringApplication.run(DemoApplication.class, args); 
    } 
}
```

## @SpringBootConfiguration
* It is a class-level annotation that is part of the Spring Boot framework. It implies that a class provides Spring Boot application configuration. It can be used as an alternative to Spring’s standard @Configuration annotation so that configuration can be found automatically.
``` java
@SpringBootConfiguration
public class Application { 
  
    public static void main(String[] args) { 
        SpringApplication.run(Application.class, args); 
    } 
  
    @Bean
    public StudentService studentService() { 
        return new StudentServiceImpl(); 
    } 
}
```

## Request Handling and Controller annotations:
* @Controller
* @RequestMapping: use @Controller annotation with @RequestMapping annotation to map HTTP requests with methods inside a controller class.
``` java
@RequestMapping(value="\aaa",method=RequestMapping.GET)
```
* @GetMapping @PutMapping @PostMapping @PatchMapping @DeleteMapping

* @RequestParam: used to obtain a parameter from URI
``` java
@RestController
public class MyController{ 
  @GetMapping("/authors") 
  public String getAuthors(@RequestParam(name="authorName") String name){ 
    //insert code here 
  } 
}
```
* @PathVariable
``` java
@RestController
public class MyController{ 
    
    @GetMapping("/author/{authorName}") 
    public String getAuthorName(@PathVariable(name = "authorName") String name){ 
      //insert your code here 
    } 
    
}
```
* @RequestBody
``` java
@RestController
public class MyController{ 
    
  @GetMapping("/author") 
  public void printAuthor(@RequestBody Author author){ 
    //insert code here 
  } 
} 
```


## Spring Data
* @Entity:  Specifies that the class is an entity.
* @Table: It specifies the table in the database with which this entity is mapped.
* @Column: Specify the column mapping.
* @Id: marks a field in a model class as the primary key.
* @CreatedBy, @LastModifiedBy, @CreatedDate, @LastModifiedDate: automatically populates.
* @Transient: Every non static and non-transient property of an entity is considered persistent, unless you annotate it as @Transient.
* @JoinColumn: foreign key.