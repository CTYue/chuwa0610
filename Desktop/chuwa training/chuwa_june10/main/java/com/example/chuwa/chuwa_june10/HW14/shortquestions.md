
## 2.  Briefly reading: https://www.techgeeknext.com/spring-boot/spring-aop-interview-questions
## 3.  What is the Aspect Oriented Programming, explain it with detailed use cases?
```text
AOP (Aspect-Oriented Programming) is a programming model that manages methods in a unified manner, allowing multiple methods to be reused. For example, logging, transaction management, and security checks are used in many modules, 
and these functions cross-cut through various modules. AOP extracts these cross-cutting concerns from business logic, making them easier to maintain and reuse in different modules.
AOP execution process: During execution, a proxy object is generated, and the proxy object processes the methods in the target object.

detail case; aop process
1 proxy object : Generate a proxy object to replace the actual target object. 
2 method process: Then the proxy object intercepts the method call of the method target object.
Then according to the defined aspect, the aspect code will be executed before the method is executed, after the method is executed, or when an exception is thrown.

@Aspect
public class LoggingAspect {
    //the code will Execute before method
    @Before("execution(* BankService.deposit(..)) || execution(* BankService.withdraw(..))")
    public void logBefore() {
        System.out.println("Logging before method execution");
    }
    //the code will Execute after method
    @After("execution(* BankService.deposit(..)) || execution(* BankService.withdraw(..))")
    public void logAfter() {
        System.out.println("Logging after method execution");
    }
}
```
## 4.  What are the advantages and disadvantages of Spring AOP?
### advantages
- 1 Modularity: 
AOP can separate cross-cutting concerns (such as logging, security, transaction management, etc.) from core business logic, develop and maintain these concerns as independent modules, and improve the reusability and maintainability of the code.
- 2 Code Reusability:
Aspects can be reused in different parts of an application, reducing code duplication，For example, a logging module can be used in multiple applications

### disadvantages
- Complexity:
The concepts and techniques of AOP are more complex and require more time to learn and understand.
- Performance issue and  additional Overhead
AOP will add certain overhead at runtime, such as the creation and calling of aspects, which will affect program performance.
## 5.  Explain following concept in your own words, you may include code snippet as part of your answer.
    ### 1.  Aspect ： It is a combination of pointcut and notification. Is a class that contains pointcuts and notifications
    ### 2.  PointCut :  A pointcut is an expression that defines the join points at which advice is applied.
    ### 3.  JoinPoint :A join point is a specific point in program execution, usually the moment of method invocation or method execution.
    ### 4.  Advice :  Intercept to the Join point, tell Join poin  what to do next， Such as pre-notification, post-notification, exception notification, etc.
```text

1. deposit( )  is JoinPoint，The pointcut specifies when we want the advice to be applied.
2. logAfter method is advice
3. PointCut:  @Before("execution(* BankService.deposit(..)) || execution(* BankService.withdraw(..))")
4. Aspect:   LoggingAspect class, 

@Aspect
public class LoggingAspect {
    //the code will Execute before method
    @Before("execution(* BankService.deposit(..)) || execution(* BankService.withdraw(..))")
    public void logBefore() {
        System.out.println("Logging before method execution");
    }
    //the code will Execute after method
    @After("execution(* BankService.deposit(..)) || execution(* BankService.withdraw(..))")
    public void logAfter() {
        System.out.println("Logging after method execution");
    }
}
```
  
## 6.  How do we declare a pointcut, can we declare it without annotating an empty method? Name some expressions to do it.

```java
import org.aspectj.lang.annotation.After;

@Aspect
public class LoggingAspect {

    // @Pointcut  annotation  as a pointcut signal,  advice method do not need have specific implement
    @Pointcut("execution(* com.example.service.*.*(..))")
    public void serviceLayer() {
    }

    // In all methods matched by the serviceLayer pointcut, use the logBefore notification
    @Before("serviceLayer()")
    public void logBefore() {
        System.out.println("Logging before method execution");
    }

    @After("serviceLayer()")
    public void logAfter() {
        System.out.println("Logging after method execution");
    }
    
    //  Multiple advice can apply the same pointcut expression， 
    //logBefore  and logAfter all used  "serviceLayer()"  expression
}
}
```
## 7.  Compare different types of advices in Spring AOP.
Each type of advice is applied at different points in the method execution lifecycle, allowing aspects to execute specific actions before, after, or around a method invocation.

- **@Before**: Executes before the method. Useful for pre-processing, such as logging, validation, or security checks.
- **@After**: Executes after the method, regardless of the outcome. Useful for cleanup or final logging.
- **@AfterReturning**: Executes after the method returns successfully. Useful for logging return values or post-processing results.
- **@AfterThrowing**: Executes after the method throws an exception. Useful for logging errors or handling exceptions.
- **@Around**: Executes before and after the method, allowing control over the method execution. Useful for complex use cases like performance monitoring or transaction management.
## 8. Reading: https://www.javainuse.com/spring/sprbatch_interview
## 9.  Spring WebFlux vs Stream API+CompletableFuture, why use Spring WebFlux over the other?
1. **Scalability and Performance**:
    - **WebFlux**: Optimized for high-concurrency environments with its non-blocking I/O and backpressure support, allowing for better resource utilization and scalability.
    - **Stream API + CompletableFuture**: While suitable for simple asynchronous tasks, it may not handle backpressure and high concurrency as efficiently as WebFlux.

2. **Ease of Composition**:
    - **WebFlux**: Provides a rich set of operators for composing complex asynchronous workflows using `Flux` and `Mono`, making it easier to handle reactive streams.
    - **Stream API + CompletableFuture**: Requires manual composition of asynchronous tasks, which can become cumbersome and less readable for complex workflows.

3. **Integration**:
    - **WebFlux**: Seamlessly integrates with the Spring ecosystem, providing reactive support across various Spring projects (e.g., Spring Data, Spring Security).
    - **Stream API + CompletableFuture**: Lacks built-in integration with Spring projects, requiring additional effort to combine with Spring-based applications.
## 10.  When to use Spring Batch? please provide detailed exaples with business context.
Spring Batch is a lightweight, comprehensive batch processing framework suitable for timing or batch tasks that process large amounts of data. It provides reliable transaction management, concurrency control, statistics, job restart and skip, and resource management.
Such as data import and export, log processing, report generation
For example, importing order data into the database: the company needs to process a large number of customer orders every day.
1. We need to read data from the CSV file first, and import external data into our application.
2. Then verify and transform the read data, such as verifying required fields, verifying data format, date format, etc.
3. Finally, write the sorted data into the database for future query and use.

## 11.  How does Spring Batch work? you may include code snippet as part of your answer.
Create a job: Define a batch task to perform a specific data processing task.
Define steps: A job contains several steps, each of which is responsible for performing specific operations, such as reading data, processing data, and writing data.
Execute a job: Run the entire job in the predefined order of steps to complete the batch data processing process.
## 12.  How can we schedule a Spring Batch Job?
To use Spring's task scheduling feature. The most common method is to configure the @Scheduled annotation or use Quartz to schedule tasks.
1. @Scheduled annotation ：In the Spring Batch configuration class, define a method and use the @Scheduled annotation to trigger the method periodically to execute the job.
```java
@Configuration
@EnableBatchProcessing
@EnableScheduling
public class BatchConfig {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Scheduled(cron = "0 0 * * * ?") // 每小时执行一次
    public void performJob() throws Exception {
        jobLauncher.run(job, new JobParameters());
    }
}

```
## 13.  What is the cron expression?
Cron expressions are a syntax for setting up scheduled tasks, which allows you to define a schedule for the execution of tasks. Cron expressions usually consist of 6 or 7 fields, each field represents a different time unit, such as seconds, minutes, hours, days, months, weeks, and years.
0 0 * * * ?: means executing once every day at midnight 00:00.
0 15 10 * * ?: means executing once every day at 10:15 am.
0 0/5 * * * ?: means executing the task every 5 minutes.

Cron： The structure of the expression
seconds（0-59）
Minutes (0-59)
Hours (0-23)
Day of Month (1-31)
Month (1-12 or JAN-DEC)
Day of Week (0-6 or SUN-SAT)
Year (optional)

## 14.  Explain Spring task?
Spring Task is a module within the Spring Framework that provides scheduling support. It allows you to execute tasks asynchronously and schedule tasks to run at specific times or intervals.
- @EnableScheduling：该注解用于启用 Spring 的定时任务执行功能。
- @Scheduled：该注解用于标记要执行定时任务的方法。支持固定延迟、固定速率和 cron 表达式。
- TaskScheduler：这是 Spring 提供的用于以编程方式调度任务的接口。

## 15.  What is Filter and any filter example?
- A component that performs filtering tasks on either the request to a resource or on the response from a resource, or both.
- Typically used for tasks such as logging, authentication, authorization, and input validation.
- Filters can be chained together, allowing multiple filters to process a single request/response.
## 16.  What is the Interceptor? What we can do with interceptor?
In Spring, Interceptors are used to process HTTP requests and responses before the request reaches the controller or after the response is returned from the controller. 
Interceptors are often used to handle some common tasks, such as logging, authentication, performance monitoring, etc., which need to be performed on each request or response.
## 17.  In Interceptor, What is preHandle? What is postHandle?
preHandle is used to process the request before it reaches the controller and decide whether to continue the request.
postHandle is used to process after the request is processed but before the view is rendered, and can be used to modify model data and view information.
## 18.  What is Swagger, why do we need it? What does it do except "documentation"?
Swagger is a toolkit for API design, construction, documentation, and use. In addition to providing API documentation, Swagger also has the following features:

API design: Swagger provides a visual interface to help design APIs, including defining request and response formats.
API testing: You can test API interfaces directly in the Swagger UI to view request and response data.
Code generation: Automatically generate client SDK and server-side code based on API documentation to reduce the workload of manual coding.
Interface simulation: Provide interface simulation services to help developers develop and test front-ends before the actual interface is implemented.