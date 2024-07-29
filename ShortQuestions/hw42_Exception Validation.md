### HW42 / hw10



### 2.  what is the @configuration and @bean?
#### @Configuration
- an annotation used on **classes** in Spring to indicate that the class will contain bean definitions.
- Classes annotated with `@Configuration` can have methods annotated with `@Bean`.
#### @Bean
- an annotation used on **methods** within `@Configuration`-annotated classes to declare a bean. Beans are Spring-managed objects that are created, managed, and injected by the Spring IoC container.
```java
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}

```


### 3.  How do you handle the exceptions in Spring? How do you make sure you do NOT expose sensitive information?

- Using  **Method level** annotation `@ExceptionHandler` : define methods annotated with `@ExceptionHandler` within your `@ControllerAdvice` or controller classes to handle specific exceptions. 

  ```java
  @Controller
  public class MyController {
      
      @ExceptionHandler(SomeException.class)
      public ResponseEntity<String> handleSomeException(SomeException ex) {
          return new ResponseEntity<>("An error occurred", HttpStatus.BAD_REQUEST);
      }
  }
  ```

- Using `@ResponseStatus`: Annotate exception handler methods with `@ResponseStatus` to define the HTTP status code for the response.

- Using **Class level** annotation `@ControllerAdvice`: Implement a global exception handler using `@ControllerAdvice` to centralize exception handling across controllers.

  ```java
  @ControllerAdvice
  public class GlobalExceptionHandler {
  
      @ExceptionHandler(Exception.class)
      @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
      public ResponseEntity<String> handleGlobalException(Exception ex) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error occurred");
      }
  
      // Other exception handlers
  }
  ```

- Custom Exception Messages:

  ```java
  public class EntityNotFoundException extends RuntimeException {
      // Custom exception details
  }	
  ```

  

### 4.  How do you do validations in Spring? List some validation annotations you know. What's the purpose of validation?

The purpose of validation is to ensure that the data being processed by an application meets certain criteria before it is used or persisted. This helps to maintain data integrity, prevent errors, and enhance security by validating user inputs.

Add validation dependency.

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  	<artifactId>spring-boot-starter-validation</artifactId>
  		<version>2.7.0</version>
</dependency>
```

#### 1. Define validation constraints in Model class. eg. User

- **@NotNull**
- **@NotEmpty**: not null /not empty string
- **@NotBlank**: not null and trimmed length > 0
- **@Size, @Pattern, @Email, @Min, @Max**

#### 2. Use Validations in Controller to trigger validation.

- **@Valid**: Used in method **arguments** to trigger validation of nested objects or collections.

```java
public class User {
    @NotNull(message = "ID cannot be null")
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
 		@NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
  	@Pattern(regexp = "[a-zA-Z0-9]*")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 100, message = "Age should not be more than 100")
    private int age;
  
  	@Past(message = "Date of birth must be in the past")
		private LocalDate dateOfBirth;
  
  	@Future(message = "Appointment date must be in the future")
		private LocalDate appointmentDate;

}
public class UserController {

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody User user, BindingResult bindingResult) {  
      // @Valid trigger User validations in class User
        //.....
    }
}
```


### 5.  What is the actuator, list some endpoints and payload it provides?

- **Actuator** is a library that allows you to **monitor and interact with your application**. 

- It provides several endpoints that expose useful information about your application's health, metrics, environment, and more. These endpoints can be accessed over HTTP, making them accessible for monitoring/inspecting and management purposes.

- Endpoints:

#### **Health Endpoint**

- **Endpoint**: `/actuator/health`
- **Purpose**: Provides basic health information about the application.

```json
{
  "status": "UP",
  "components": {
    "db": {
      "status": "UP",
      "details": {
        "database": "MySQL",
        "status": "OK"
      }
    },
    "diskSpace": {
      "status": "UP",
      "details": {
        "total": 1024,
        "free": 512,
        "threshold": 256
      }
    }
  }
}
```

#### Metrics Endpoint

- **Endpoint**: `/actuator/metrics/{metricName}`
- **Purpose**: Provides various metrics about the application, such as memory usage, HTTP requests, and more.

```json
{
  "name": "jvm.memory.used",
  "measurements": [
    {
      "statistic": "VALUE",
      "value": 123456
    }
  ],
  "availableTags": []
}
```

#### Info Endpoint

- **Endpoint**: `/actuator/info`

- **Purpose**: Provides arbitrary application information.

- Example Payload

  ```json
  {
    "app": {
      "name": "My Spring Boot Application",
      "version": "1.0.0",
      "description": "This is a sample Spring Boot application"
    }
  }
  ```

- Developers can customize the information provided in this endpoint.

#### Environment Endpoint

- **Endpoint**: `/actuator/env`

- **Purpose**: Exposes information about the application's environment properties.

- Example Payload

  ```json
  {
    "profiles": ["default"],
    "propertySources": [
      {
        "name": "classpath:/application.properties",
        "properties": {
          "server.port": {
            "value": "8080"
          },
          "logging.level.org.springframework.web": {
            "value": "DEBUG"
          }
        }
      }
    ]
  }
  ```

#### Beans Endpoint

- **Endpoint**: `/actuator/beans`

- **Purpose**: Provides a list of all Spring beans in the application context.

- Example Payload

  ```json
  {
    "contexts": {
      "application": {
        "beans": {
          "beanName": "beanClassName",
          "myService": {
            "aliases": [],
            "scope": "singleton",
            "type": "com.example.MyService",
            "resource": "file:src/main/java/com/example/MyService.java",
            "dependencies": []
          },
          "dataSource": {
            "aliases": [],
            "scope": "singleton",
            "type": "org.apache.tomcat.jdbc.pool.DataSource",
            "resource": "file:src/main/resources/application.yml",
            "dependencies": []
          }
        }
      }
    }
  }
  ```

#### Logger Endpoint

- **/actuator/loggers**

- **Purpose**: Shows and manages the configuration of loggers in the application.
  
  ```json
  {
    "levels": [
      "OFF",
      "ERROR",
      "WARN",
      "INFO",
      "DEBUG",
      "TRACE"
    ],
    "loggers": {
      "ROOT": {
        "configuredLevel": "INFO",
        "effectiveLevel": "INFO"
      },
      "org.springframework": {
        "configuredLevel": "WARN",
        "effectiveLevel": "WARN"
      }
    }
  }
  ```

#### ThreadDump Endpoint

- **/actuator/threaddump**

- **Purpose**: Provides a thread dump from the JVM showing the current state of all threads.
  ```json
  {
    "threads": [
      {
        "threadName": "main",
        "threadId": 1,
        "blockedTime": -1,
        "blockedCount": 0,
        "waitedTime": -1,
        "waitedCount": 0,
        "lockName": null,
        "lockOwnerId": -1,
        "lockOwnerName": null,
        "inNative": false,
        "suspended": false,
        "threadState": "RUNNABLE",
        "stackTrace": [
          {
            "methodName": "run",
            "fileName": "Main.java",
            "lineNumber": 34,
            "className": "com.example.Main",
            "nativeMethod": false
          }
        ]
      }
    ]
  }
  ```

  

### 6. Apply above annotations to your previous homework projects as possible as you can.

### 7.  watch those videos(泛泛地看一遍，能理解多少是多少，没有必要看其它视频。)

1. Spring 简介： https://www.youtube.com/watch?v=l0MqsOADAUE&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=64
2. IOC/DI: https://www.youtube.com/watch?v=PyMxNr2p0C0&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=65
3. IOC container: https://www.youtube.com/watch?v=pLa77Tw-yyI&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=66
4. Bean:
   1. https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=67
   2. https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=68
   3. https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=69
5. DI:
   1. https://www.youtube.com/watch?v=MgTpBST9onM&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=70
   2. https://www.youtube.com/watch?v=yhEWZx2i1BA&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=71