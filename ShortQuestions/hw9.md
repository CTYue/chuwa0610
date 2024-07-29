# HW9

1. what is the @configuration and @bean?
    
    ```java
    @Configuration
    public class AppConfig {
        @Bean
        public SomeExternalLibrary externalLibrary() {
            return new SomeExternalLibrary();
        }
    }
    ```
    
    Configuration is class-level annotation(used to define a class), which used to tell spring framework here is a place to declare one or more beans.
    
    Bean is method level annotation, used to a method produces a bean to be managed by the Spring container. It is used within @Configuration to specify that the return value of the method is to be registered as a bean in the Spring application context.
    
    In Spring boot, Configuration and Bean are always used for 3rd service.
    
2. How do you handle the exceptions in Spring? How do you make sure you do NOT expose sensitive information?
    
    Use ExceptionHandler and ControllerAdvice
    
    ```java
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest
    webRequest) {
    			ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
    webRequest.getDescription(false));
    			return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
     }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,WebRequest webRequest) {
    			ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
    			webRequest.getDescription(false));
    			return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
     }
    ```
    
    Make sure do not expose sensitive information:
    
    Use environment variable
    
    use HTTPS
    
    Access control
    
    Spring Security Configuration: Configure HTTPS, 	Use secure session, Implement CSRF
    
    Use OAuth for API security.
    
    Logging and Monitoring: Implement logging to capture access and changes to sensitive data without logging the data itself. 
    
3. How do you do validations in Spring? List some validation annotaitons you know. What's the purpose of validation?
    
    Use Validator:
    
    ```java
    public class User {
        @NotNull(message = "Username must not be null")
        @Size(min = 5, max = 15, message = "Username must be between 5 and 15 characters long")
        private String username;
    
        @Email(message = "Email should be valid")
        private String email;
    }
    
    // use
    @PostMapping("/users")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        // Persist the user
        return ResponseEntity.ok("User created successfully");
    }
    ```
    
    @NotNull: Checks that the annotated field is not null.
    
    @NotEmpty: Checks that the field is not null and its size/length is greater than zero.
    
    @NotBlank: Checks that the field is not null and trimmed length is greater than zero.
    
    @Email: Checks that the field is a valid email address.
    
    @Size(min=, max=): Checks that the field’s size is within the given range.
    
    @Min(value): Ensures that the field’s value is no less than the specified minimum.
    
    @Max(value): Ensures that the field’s value is not greater than the specified maximum.
    
4. What is the actuator, list some endpoints and payload it provides?
    
    It is used to monitor and manage the spring boot applications when it is pushed to production. You can use Actuator to get insights via production-ready endpoints about your application’s health, metrics, info, dump, environment, etc.
    
    Common endpoints:
    
    1.	**/actuator/health**: Shows application health information (when the app is secure, this might be a simple ‘status’ of UP or DOWN).
    
    2.	**/actuator/info**: Displays arbitrary application info.
    
    3.	**/actuator/metrics**: Shows ‘metrics’ information for the current application.
    
    4.	**/actuator/loggers**: Displays and modifies the configuration of loggers in the application.
    
    5.	**/actuator/httptrace**: Displays HTTP trace information (by default, the last 100 HTTP request-response exchanges).
    
    6.	**/actuator/auditevents**: Exposes audit events information regarding the current application. This is particularly useful if you have an audit framework in place.
    
    7.	**/actuator/env**: Exposes properties from Spring’s ConfigurableEnvironment.
    
    8.	**/actuator/beans**: Displays a complete list of all the Spring beans in your application.
    
    9.	**/actuator/threaddump**: Performs a thread dump.
    
    10.	**/actuator/heapdump**: Returns a GZip compressed hprof heap dump file.
    
    11.	**/actuator/prometheus**: Exposes metrics in a format that can be scraped by a Prometheus server.