## HW AOP&Batch&Swagger / HW 14

### 1. List all of the annotations you learned from class and homework to annotaitons.md 

### 2. Briefly reading: 

https://www.techgeeknext.com/spring-boot/spring-aop-interview-questions 

### 3. What is the Aspect Oriented Programming, explain it with detailed use cases? 

**Aspect-Oriented Programming (AOP)** is a programming paradigm that aims to **increase modularity by allowing the separation of cross-cutting concerns**. It complements traditional programming paradigms by enabling better separation of concerns, making the code more modular, readable, and maintainable.

#### **Logging:**

**Use Case:**

- Adding logging to multiple methods across various classes without cluttering the business logic.

**Implementation:**

- Define an aspect for logging.
- Use a pointcut to match all methods that need logging.
- Apply advice to log method execution details.

```java
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* com.example.service.*.*(..))")
    private void selectAllMethods() {}

    @Before("selectAllMethods()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Executing method: " + joinPoint.getSignature().getName());
    }

    @After("selectAllMethods()")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("Method executed: " + joinPoint.getSignature().getName());
    }
}

```

#### **Transaction Management:**

**Use Case:**

- Ensure methods that modify data are executed within a transaction context to maintain data integrity.

**Implementation:**

- Define an aspect for transaction management.
- Use a pointcut to match methods that should be transactional.
- Apply advice to begin and commit/rollback transactions.

```java
@Aspect
public class TransactionAspect {

    @Pointcut("execution(* com.example.service.*.*(..))")
    private void transactionalMethods() {}

    @Around("transactionalMethods()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        TransactionStatus status = null;
        try {
            status = transactionManager.getTransaction(new DefaultTransactionDefinition());
            Object result = joinPoint.proceed();
            transactionManager.commit(status);
            return result;
        } catch (Throwable ex) {
            if (status != null) {
                transactionManager.rollback(status);
            }
            throw new RuntimeException(ex);
        }
    }
}
```

#### **Security:**

**Use Case:**

- Enforce security checks before accessing certain methods, such as ensuring the user has the required permissions.

**Implementation:**

- Define an aspect for security.
- Use a pointcut to match methods that require security checks.
- Apply advice to perform security checks before method execution.

```java
@Aspect
public class SecurityAspect {

    @Pointcut("execution(* com.example.service.*.*(..)) && @annotation(Secured)")
    private void securedMethods() {}

    @Before("securedMethods()")
    public void beforeAdvice(JoinPoint joinPoint) {
        // Perform security checks
        if (!hasPermission(joinPoint)) {
            throw new SecurityException("User does not have permission to execute this method");
        }
    }

    private boolean hasPermission(JoinPoint joinPoint) {
        // Implement security check logic here
        return true; // Placeholder logic
    }
}
```

#### **Performance Monitoring**

**Use Case:**

- Monitor the performance of methods by measuring their execution time.

**Implementation:**

- Create an aspect to handle performance monitoring.
- Define a pointcut to select the methods to be monitored.
- Implement around advice to measure and log the execution time of the methods.

```java
@Aspect
@Component
public class PerformanceMonitoringAspect {

    private static final Logger logger = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);

    @Pointcut("execution(* com.example.service.*.*(..))")
    private void monitorMethods() {}

    @Around("monitorMethods()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        logger.info("Method {} executed in {} ms", joinPoint.getSignature(), duration);
        return result;
    }
}

```

#### **Exception Handling**

**Use Case:**

- Apply a consistent exception-handling policy across multiple methods or classes.

**Implementation:**

- Create an aspect for exception handling.
- Define a pointcut to select the methods where exception handling is required.
- Implement after-throwing advice to catch and handle exceptions.

```java
@Aspect
@Component
public class ExceptionHandlingAspect {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlingAspect.class);

    @Pointcut("execution(* com.example.service.*.*(..))")
    private void handleExceptions() {}

    @AfterThrowing(pointcut = "handleExceptions()", throwing = "ex")
    public void afterThrowingAdvice(Exception ex) {
        logger.error("Exception caught: {}", ex.getMessage(), ex);
        // Additional handling like returning a default value or error response can be added here
    }
}

```





### 4. [What are the advantages and disadvantages of Spring AOP?](https://online.glyndwr.ac.uk/aspect-oriented-programming-advantages-and-disadvantages/)

| **Advantages**                                               | **Disadvantages**                                            |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| **Modularity**: AOP **modularises** and separates cross-cutting concerns from core business logic, allowing programmers and developers to **handle concerns separately**. | **Complexity**: Implementing and understanding AOP can add complexity to a project. It requires a good grasp of AOP concepts, which can be a steep learning curve for developers unfamiliar with the paradigm. |
| **Improved Maintainability**: AOP makes it possible to modify or update specific code functionalities – without affecting the wider source code – making software changes more manageable for programmers and developers. It also helps to reduce undesirable or unintended side effects. | **Debugging Challenges**: Because AOP involves weaving aspects into the code at runtime, it can be challenging to debug. The flow of execution might not be straightforward, making it harder to track down issues. |
| **Code reusability**: The aspects that are inherent in AOP encapsulate common functionalities and, therefore, promote the reuse of code across different parts of the application. | **Performance Overhead**: AOP introduces additional method calls and processing, which can lead to performance overhead. This can be especially noticeable in performance-critical applications. |
| **Centralised management**. AOP makes it easier to implement modifications and changes uniformly across the entire application and, as a result, manage cross-cutting concerns such as transactions and security. | **Tooling and Support**: While Spring AOP is well-supported within the Spring ecosystem, tooling for AOP in general can be limited. This might affect the development experience, especially when compared to more mainstream techniques. |
| **Readability**. Isolating and specifying non-functional requirements improves the readability of central business logic. As such, software engineers can focus on core functionality, free from the distractions of unrelated concerns. | **Code Readability**: AOP can make the codebase harder to read and understand. Aspects are applied declaratively, which means the actual behavior of the code might not be evident from the source code itself, potentially leading to maintenance challenges. |
| **Scalability**. As the codebase grows, the effective management of concerns becomes more important, as well as more complex. AOP supports a cleaner, more organised code structure – which, in turn, supports scalability. | **Limited Aspect Scope**: Spring AOP is proxy-based and operates mainly at the method level. This means it doesn't support field interception or constructor interception as fully as some other AOP frameworks, like AspectJ. |
| **Better testing functionality**. Concerns that have been separated/isolated make it much easier to conduct independent testing. This is useful in terms of promoting better overall software quality and implementing a more effective testing methodology and strategy. | **Increased Build Time**: Depending on the complexity and number of aspects, the build time can increase due to the additional processing required to weave aspects into the code. |



### 5. Explain following concept in your own words, you may include code snippet as part of your answer. 

![image-20240723105617913](/Users/xiao/Library/Application Support/typora-user-images/image-20240723105617913.png)

#### Aspect 

`@Aspect` A class that **encapsulates cross-cutting concerns** like logging or security.

#### PointCut 

`@Pointcut` Defines **where** the aspect's **advice** should be applied. (这个切面需要应用advice)

#### JoinPoint  (methods in execution)

A point in the execution of the program **where** an **aspect** can be applied. (需要被拦截的连接点，在这个连接点，也就是程序执行中的某个method上应用advice，eg. log一些东西)

#### Advice 

The **action/notification** taken by an aspect at a particular join point. (before, after, around, etc.).



### 6. How do we declare a pointcut, can we declare it without annotating an empty method? Name some expressions to do it. 

Pointcuts are declared using the `@Pointcut` annotation in an aspect class. A **common way** to declare a pointcut is by **annotating an empty method**. Here's an example:

```java
@Aspect
public class MyAspect {

    @Pointcut("execution(* com.example.service.*.*(..))")
    public void serviceLayerExecution() {
        // This method is empty because it only serves as a pointcut definition
    }
  	// the detailed pointcut advice logic
  	@Before("serviceLayerExecution()")
    public void beforeServiceMethod() {
        // Advice logic here
    }
}
```

Yes.  without annotating an empty method:

```java
@Aspect
public class MyAspect {
		// directly use the pointcut expression in advice annotations like @Before
  	// instead of declaring an empty method
    @Before("execution(* com.example.service.*.*(..))")
    public void beforeServiceMethod() {
        // Advice logic here
    }
}
```



### Expressions for Pointcuts

Spring AOP provides various expressions to define pointcuts:

1. **`execution`**: Matches method execution join points. This is the most common pointcut expression.

   ```java
   @Pointcut("execution(* com.example.service.*.*(..))")
   public void serviceLayer() {}
   ```

2. **`within`**: Limits matching to join points within certain types.

   ```java
   @Pointcut("within(com.example.service..*)")
   public void withinServiceLayer() {}
   ```

3. **`this`**: Limits matching to join points where the bean reference is an instance of the given type.

   ```java
   @Pointcut("this(com.example.service.MyService)")
   public void thisService() {}
   ```

4. **`target`**: Limits matching to join points where the target object is an instance of the given type.

   ```java
   @Pointcut("target(com.example.service.MyService)")
   public void targetService() {}
   ```

5. **`args`**: Limits matching to join points where the arguments are instances of the given types.

   ```java
   @Pointcut("args(java.lang.String, int)")
   public void methodWithArgs() {}
   ```

6. **`@within`**: Limits matching to join points within types that have the given annotation.

   ```java
   @Pointcut("@within(org.springframework.stereotype.Service)")
   public void withinAnnotatedService() {}
   ```

7. **`@target`**: Limits matching to join points where the target object has the given annotation.

   ```java
   @Pointcut("@target(org.springframework.stereotype.Service)")
   public void targetAnnotatedService() {}
   ```

8. **`@args`**: Limits matching to join points where the arguments are annotated with the given annotation.

   ```java
   @Pointcut("@args(com.example.annotation.MyAnnotation)")
   public void methodWithAnnotatedArgs() {}
   ```

9. **`@annotation`**: Limits matching to join points where the subject method has the given annotation.

   ```java
   @Pointcut("@annotation(com.example.annotation.MyAnnotation)")
   public void methodWithAnnotation() {}
   ```



### 7. Compare different types of advices in Spring AOP. 

There are different types of advice, including:

- **@Before:** Executed before the join point.
- **@After:** Executed after the join point.
- **@Around:** Surrounds the join point and can control whether the join point executes. **before & after**
- **@AfterReturning:** Executed **after** the join point **completes** normally.
- **@AfterThrowing:** Executed if the join point **throws an exception.**

```java
@Aspect
@Component
public class LoggingAspect {
  	// Define a pointcut for all methods in service, like UserService
  	@Pointcut("execution(* com.example.service.*.*(..))")
    public void serviceMethods() {}

  	// Before advice
    @Before("execution(* com.example.service.*.*(..))")
    public void logBeforeMethodExecution() {
        System.out.println("Method is about to be executed.");
    }

  	// After advice
    @After("execution(* com.example.service.*.*(..))")
    public void logAfterMethodExecution() {
        System.out.println("Method has been executed.");
    }

  	// Around advice
    @Around("execution(* com.example.service.*.*(..))")
    public Object logAroundMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Method execution started: " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        System.out.println("Method execution finished: " + joinPoint.getSignature().getName());
        return result;
    }
}


// output
/**
Method is about to be executed.
Method execution started:
eg. add user John...
...
Method execution finished: 
Method has been executed.
*/
```



### 8. Reading: https://www.javainuse.com/spring/sprbatch_interview 

### 9. Spring WebFlux vs Stream API+CompletableFuture, why use Spring WebFlux over the other? 

| Feature               | Spring WebFlux                        | Stream API + CompletableFuture          |
| --------------------- | ------------------------------------- | --------------------------------------- |
| Paradigm              | Reactive programming                  | Concurrent programming                  |
| Asynchronous Support  | Built-in, non-blocking I/O            | Requires manual handling with futures   |
| Backpressure Handling | Yes                                   | No                                      |
| Declarative Syntax    | Yes (using Reactor)                   | No                                      |
| Ease of Use           | High (with built-in operators)        | Medium (requires more boilerplate)      |
| Scalability           | High (optimized for high concurrency) | Moderate (depends on thread management) |
| Integration           | Seamless with Spring ecosystem        | Standalone, requires custom integration |
| Error Handling        | Comprehensive with reactive operators | Manual, more complex                    |
| Performance           | Efficient for I/O-bound tasks         | Depends on implementation               |
| Learning Curve        | Steeper due to reactive paradigm      | Lower, familiar imperative style        |



### 10. When to use Spring Batch? please provide detailed examples with business context.

Spring Batch is particularly useful in scenarios where you need to process a large set of data in a reliable and efficient manner. Some common use cases include:

1. **Data Migration and ETL (Extract, Transform, Load)**:
   - Migrating data from one database to another.
   - Extracting data from various sources, transforming it, and loading it into a data warehouse.
   - **Business Context**: A company is migrating its customer data from an old legacy database to a new modern database. This involves reading data from the old database, transforming it according to the new schema, and then writing it to the new database.
2. **Report Generation**:
   - Generating large-scale reports from database records.
   - **Business Context**: A financial institution needs to generate monthly reports for all transactions performed in the previous month. These reports will be used for auditing and compliance purposes.
3. **Data Cleansing**:
   - Processing and cleaning data to ensure its accuracy and consistency.
   - **Business Context**: A healthcare organization needs to clean and standardize patient data to improve quality and comply with regulations.
4. **Bulk Operations**:
   - Performing batch updates, inserts, or deletes in a database.
   - **Business Context**: A retail company needs to update product prices in bulk across their inventory database.
5. **Automated Workflow Jobs**:
   - Automating business workflows that involve multiple steps and need to be executed in a specific order.
   - **Business Context**: A logistics company wants to automate nightly data processing tasks to maintain operational efficiency.



### 11. How does Spring Batch work? you may include code snippet as part of your answer. 

### Define a job configuration

Create a job with one or more steps.

```java
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
    }

    @Bean
    public Step step1(JdbcCursorItemReader<User> reader, ItemProcessor<User, ProcessedUser> processor, FlatFileItemWriter<ProcessedUser> writer) {
        return stepBuilderFactory.get("step1")
            .<User, ProcessedUser>chunk(10)
            .reader(reader)
            .processor(processor)
            .writer(writer)
            .build();
    }
}

```



### Define steps

Configure each step with a reader, processor, and writer.

### Execute the Job

Use a `JobLauncher` to start the job with specific parameters.

```java
@SpringBootApplication
public class BatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(JobLauncher jobLauncher, Job job) {
        return args -> {
            JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
            jobLauncher.run(job, params);
        };
    }
}

```



### 12. How can we schedule a Spring Batch Job? 

You can schedule a Spring Batch job using Spring's `@Scheduled` annotation or by configuring a `TaskScheduler`. 

**Configuration to Enable Scheduling:**

```java
@Configuration
@EnableScheduling
public class BatchSchedulerConfig {
}
```

**Scheduled Job Execution:**

```java
@Component
public class BatchJobScheduler {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Scheduled(cron = "0 0 2 * * ?")
    public void perform() throws Exception {
        JobParameters params = new JobParametersBuilder()
            .addString("JobID", String.valueOf(System.currentTimeMillis()))
            .toJobParameters();
        jobLauncher.run(job, params);
    }
}
```



### 13. What is the cron expression? 

A cron expression is a string that represents a schedule for executing tasks. It consists of six or seven fields separated by spaces, defining the schedule: 

```scss
┌───────────── second (0 - 59)
│ ┌───────────── minute (0 - 59)
│ │ ┌───────────── hour (0 - 23)
│ │ │ ┌───────────── day of the month (1 - 31)
│ │ │ │ ┌───────────── month (1 - 12)
│ │ │ │ │ ┌───────────── day of the week (0 - 7) (0 or 7 is Sunday)
│ │ │ │ │ │
* * * * * *
```

For example, the cron expression `"0 0 2 * * ?"` means "At 2:00 AM every day".



### 14. Explain Spring task? 

Spring Task is a part of the Spring Framework that provides support for scheduling tasks. It simplifies the scheduling of tasks using annotations like `@Scheduled` and integrates with various scheduling libraries such as Quartz.

**Example of Scheduling a Task:**

```java
@Component
public class ScheduledTasks {

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("The time is now " + new Date());
    }
}
```



### 15. What is Filter and any filter example? 

In the context of web applications, a filter is an object that performs filtering tasks on either the request to a resource or the response from a resource, or both. Filters are typically used to perform tasks such as logging, authentication, input validation, and compression.

**Example of a Filter in Spring Boot:**

**Filter Implementation:**

```
java
复制代码
@Component
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("Request URI is: " + req.getRequestURI());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
```

**Filter Registration:**

```
java
复制代码
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<MyFilter> loggingFilter(){
        FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;
    }
}
```

In this example, the filter logs the URI of each request to the `/api/*` endpoints.



### 16. What is the Interceptor? What we can do with interceptor? 

An interceptor in Spring is a component that allows you to intercept HTTP requests and responses. It can be used for various purposes, such as logging, authentication, and modifying requests and responses. Interceptors provide more fine-grained control over request handling compared to filters and can be applied to specific handlers.

#### Example: Configuring an Interceptor

**Interceptor Implementation:**

```java
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Pre Handle method is Calling");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("Post Handle method is Calling");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
        System.out.println("Request and Response is completed");
    }
}
```

**Interceptor Registration:**

```java
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/api/*");
    }
}
```

#### What we can do with interceptor?

**Logging**: Track requests and responses.

**Authentication and Authorization**: Check user credentials and permissions.

**Request Modification**: Modify request headers or parameters.

**Response Modification**: Modify response headers or body.

**Performance Monitoring**: Measure the time taken to process a request.



### 17. In Interceptor, What is preHandle? What is postHandle? 

#### preHandle

- This method is called before the actual handler is executed.
- It can be used to perform operations before the request is processed.
- If it returns `true`, the execution chain proceeds to the next interceptor or handler.
- If it returns `false`, the execution chain is interrupted, and no further processing occurs.

```java
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    System.out.println("Pre Handle method is Calling");
    return true;
}
```

#### postHandle

- This method is called after the handler is executed, but before the `DispatcherServlet` renders the view.
- It can be used to add attributes to the model or modify the `ModelAndView`.

```java
@Override
public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                       ModelAndView modelAndView) throws Exception {
    System.out.println("Post Handle method is Calling");
}
```

#### afterCompletion

- This method is called after the complete request has finished.
- It can be used for cleanup activities.

```java
@Override
public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
    System.out.println("Request and Response is completed");
}
```



### 18. What is Swagger, why do we need it? What does it do except "documentation"?

#### What is Swagger?

**Swagger** is a set of open-source **tools for designing, building, documenting, and consuming RESTful web services**. Swagger's main goal is to help developers and users understand and interact with the service without accessing the source code or understanding the implementation.

#### Why need?

- **Documentation**: Provides a comprehensive and interactive API documentation.
- **Testing**: Allows developers to test endpoints directly from the documentation interface.
- **Client Generation**: Automatically generates client libraries in various programming languages.
- **API Design**: Helps design APIs before implementation, ensuring consistent and clear API contracts.
- **Standardization**: Ensures consistency across different APIs and services.

#### What does it do except "documentation"?

- **Interactive API Explorer**: Users can test endpoints with different inputs and see responses directly within the Swagger UI.
- **Code Generation**: Generates client SDKs, server stubs, and API documentation automatically based on the API specification.
- **API Versioning and Change Management**: Helps manage different versions of APIs and tracks changes over time.
- **Validation**: Validates the API specification to ensure it adheres to the OpenAPI standard.
- **Mocking**: Provides the capability to mock API responses for testing purposes before the actual implementation is available.

