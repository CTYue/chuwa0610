# Annotations

This document lists all the annotations I have learned, organized by their usage in different parts of Java Spring application. Each annotation is explained with its usage and an example of code snippet.

## Table of Contents
1. Entity Annotations
2. Controller Annotations
3. Service Annotations
4. Repository Annotations
5. General Annotations

## Entity Annotations
### @Entity
usage: indicates that a class is a JPA entity. This is used at the class level.
```bash
import havax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
  @Id
  private Long id;
  private String name;
  
  // getters and setters
}
```

### @Table
Usage: specifies the table int the database with which this entity is mapped.
```bash
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
  // class body
}
```

### @Id
usage: specifies the primary key of an entity
```bash
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
  @Id
  private Long id;
}
```

### @GeneratedValue
usage: provides the specification of generation strategies for the values of primary keys
```bash
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GeneratedType;
import javax.persistence.Id;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
}
```


## Controller Annotations
### @RestController
usage: a convenience annotation that is itself annotated with '@Controller' and '@ResponseBody'. It is used to create RESTful web services using Spring MVC
```bash
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {
  @GetMapping("/users")
  public List<User> getUsers() {
    
  }
}
```

### @RequestMapping
usage: provides routing information. It is used to map web requests to specific handler classes and/or handler methods
```bash
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
  
}
```