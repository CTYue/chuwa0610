1. List all of the annotations you learned from class and homework to annotaitons.md   
    [annotations.md](./annotations.md)
2.  what is the @configuration and @bean?   
    - @Configuration and @Bean annotations are used to define beans and their dependencies in a Java-based configuration class. They are part of Spring's Java-based configuration support, which provides an alternative to XML-based configuration.
    - Spring container can process the class to generate bean definitions and service requests for those beans at runtime.
    - example
    ```
    @Configuration
    public class AppConfig {

        @Bean
        public MyService myService() {
            return new MyServiceImpl();
        }
    
        @Bean
        public MyRepository myRepository() {
            return new MyRepositoryImpl();
        }
    }
    ```
    

3.  How do you handle the exceptions in Spring? How do you make sure you do NOT expose sensitive information?
    - to handler exception in Spring, we have different annotations
    - @ExceptionHandler
      - Method level
    - @ControllerAdvice
      - Class level
    - @ResponseStatus
    - example
    ```
    @ControllerAdvice
    public class GlobalExceptionHandler {
        @ExceptionHandler(ResourceNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public String handleResourceNotFound(ResourceNotFoundException ex) {
            return ex.getMessage();
        }
    }
    ```
    - Don't expose sensitive information
      - using Exception handler to wrap error messages
      - show vague error messages
      - use dto class to decouple data in the db.
      
4.  How do you do validations in Spring? List some validation annotaitons you know. What's the purpose of validation?
    - add dependency `spring-boot-starter-validation`
    - using validation annotations
      - @NotNull
        - field not null
      - @Size
        - field is with specified range
      - @Min
        - filed has a value no less than the specified minimum value
      - @Max
        - filed has a value no less than the specified maximum value
      - @Email
        - field is a valid email addresss
      - @Pattern
        - field matches the specified regular expression pattern
      - @Valid
        - @RequestBody should match predefined rules of the class
      
5.  What is the actuator, list some endpoints and payload it provides?
    - spring dependencies: spring-boot-starter-actuator
    - monitor and manage the application
    - endpoints
      - health:   localhost:port/actuator/health
      - beans:   /actuator/beans
      - cache:  /actuator/caches
      - env:    /actuator/env
      - loggers: /actuator/logger
      - heapdump, threaddump, metrics
    - Payload
      - JSON object
      - using /actuator will show a lot of endpoints
6.  Apply above annotations to your previous homework projects as possible as you can.
    [code](../Coding/hw42)
7.  watch those videos(泛泛地看一遍，能理解多少是多少，没有必要看其它视频。)
   1.  Spring 简介： https://www.youtube.com/watch?v=l0MqsOADAUE&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=64

   2. IOC/DI: https://www.youtube.com/watch?v=PyMxNr2p0C0&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=65
   3. IOC container: https://www.youtube.com/watch?v=pLa77Tw-yyI&list=PLmOn9nNkQxJFbsU4Qz8CdRiV
          M4Qs3ci75&index=66
   4. Bean:
      1. https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs
          3ci75&index=67
      2.  https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs
          3ci75&index=68
      3.  https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs
          3ci75&index=69
   5. DI:
      1.  https://www.youtube.com/watch?v=MgTpBST9onM&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3
          ci75&index=70
      2.  https://www.youtube.com/watch?v=yhEWZx2i1BA&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci
          75&index=71