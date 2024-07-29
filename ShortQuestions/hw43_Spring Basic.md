## HW43 - Spring Basic / HW11

### 1.  List all of the annotations you learned from class and homework to annotations.md (your own cheatsheet).
### 2.  Compare Spring and Springboot? What are the benefits of springboot?

|              | Spring                                                       | Spring Boot                                                  |
| ------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| purpose      | a comprehensive framework for Java application development. It **provides infrastructure support and a wide range of features** for building Java applications. | built on top of the Spring Framework, aims to **simplify the bootstrapping and development** of Spring applications. |
| Key Features | **DI**, <br />**AOP**, <br />**MVC**, <br />**Transaction Management**, <br />**Integration** with like JPA, JDBC, Hibernate | **Auto-Configuration**, <br />**Standalone**, <br />**Production-Ready Features** like health checks, metrics, and externalized configuration,<br />**Convention over Configuration**: Promotes convention over configuration, making it easier to get started with Spring Boot without extensive XML configuration or explicit annotations. |

 Benefits of springboot

- **Rapid Application Development**: By reducing boilerplate code and configuration, Spring Boot allows developers to focus more on business logic.

- **Simplified Deployment**: The embedded server and executable JAR files simplify deployment and provisioning of applications.

- **Microservices Friendliness**: Well-suited for building microservices due to its lightweight nature and easy configuration.

- **Community Support**: Being part of the Spring ecosystem, Spring Boot benefits from a large and active community.

- **Streamlined Development**: Developers can start building applications quickly with minimal setup and configuration.



### 3.  What is IOC and What is DI?
#### Inversion of Control (IoC)
- A design principle where the flow of control of a system is inverted compared to traditional programming. 
  - traditional programming: the flow of control is **determined by the program itself**.
  -  IOC: the control is **determined by the container** or framework which manages the lifecycle of application objects(Beans).
#### Dependency Injection (DI)
- It is a specific **implementation of the IoC** principle. where components are given their dependencies rather than creating or looking for them internally.

- It involves **injecting the dependencies** into the class instead of the class creating them itself.

- Common DI:
  - Constructor Injection
    ```java
    public class Service {
        private final Repository repository;
    
        public Service(Repository repository) {
            this.repository = repository;
        }
    }
    
    ```
  - Setter Injection 
  ```java
    public class Service {
        private Repository repository;
  
        public void setRepository(Repository repository) {
            this.repository = repository;
        }
    }
  
  ```
  - Field Injection
  ```java
    public class Service {
        @Autowired
        private Repository repository;
    }
  
  ```



### 4.  What is  @ComponentScan ?

- An annotation used to **automatically scan and discover Spring-managed components** (such as `@Component`, `@Service`, `@Repository`, `@Controller`, etc.) within your application's package and its sub-packages.

- Used to allow Spring to scan the specified packages and register the beans with the Spring application context automatically

- Usually annotated with @Configuration or @SpringBootApplication

  Spring will scan the package `com.example` and its sub-packages for components to register as beans.)
```java
@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}

@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {
    // Other bean definitions
}
```


### 5.  What is  @SpringbootApplication ?

- A combination of 3 annotations `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`
- It simplifies the setup and configuration of Spring applications by providing **auto-configuration**, **component scanning**, and other essential features out of the box.
- typically put in **Main** class as entry point for most Spring Boot applications.
```java
@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```


### 6.  How many ways to define a bean? Provide code examples.

####  Using `@Component` Annotation (general)

- or Using `@Service`, `@Repository`, and `@Controller`, （Specialized Stereotype Annotations）
- These annotations are specialized versions of `@Component`, used for specific purposes.

```java
@Component
//@Service 
//@Repository 
//@Controller
public class Foo {
    public void doSomething() {
        System.out.println("Doing something");
    }
}
```

#### Using `@Bean` Annotation in a Configuration Class
```java
@Configuration
public class AppConfig {
  
    @Bean
    public UserService userService() {
        UserService userService = new UserService();
        userService.setUserRepository(userRepository()); // Dependency injection
        return userService;
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }
}
```
#### Use Java Configuration with @ComponentScan

Spring **automatically detects** classes annotated with `@Component` and its derivatives (`@Service`, `@Repository`, `@Controller`, etc.) and **registers them as beans** automatically.

```java
@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {
    // No explicit bean definitions needed, components will be scanned
}


// MyComponent.java
@Component
public class MyComponent {
  public void doSomething() {
    System.out.println("Doing something in MyComponent");
  }
}
```
#### Using XML Configuration

```xml
<!-- applicationContext.xml -->
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Define a bean -->
    <bean id="userService" class="com.example.UserService">
        <!-- Injecting dependencies -->
        <property name="userRepository" ref="userRepository"/>
    </bean>

    <bean id="userRepository" class="com.example.UserRepository"/>

</beans>
```



### 7.  What is default bean name for  @Component  and  @Bean ? Also compare  @Component  and  @Bean .

#### @Component

-  Default bean name：the class name with the first letter in lowercase

```java
@Component
public class MyService {
    // Bean name will be "myService"
}

```
#### @Bean
- Default bean name：the method name itself
```java
@Configuration
public class AppConfig {
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
    // Bean name will be "myBean"
}
```

#### Compare

| @Component                                                   | @Bean                                                        |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| class level                                                  | method level                                                 |
| create a Spring-managed bean from a class without explicitly defining it in a configuration class. | declare a single bean in the `@Configuration` class, and also used to create and configure third-party classes. |
| requires **@ComponentScan** to find and register beans automatically | not require component scanning. Each bean is explicitly declared in a method. |
| has specialized stereotypes such as `@Service`, `@Repository`, and `@Controller`, | Provides more control over bean creation and initialization, allowing for custom initialization, dependency injection, and lifecycle management. |



### 8.  Compare  @component  and  @service , @repository ,  @controller ?

| Aspect                   | `@Component`                 | `@Service`                           | `@Repository`                                    | `@Controller`                            |
| ------------------------ | ---------------------------- | ------------------------------------ | ------------------------------------------------ | ---------------------------------------- |
| **Role**                 | Generic component            | Service layer                        | Data access layer                                | Presentation layer (web)                 |
| **Usage**                | Any Spring-managed component | Business logic and service functions | Data access and repository functions             | Web controllers handling HTTP requests   |
| **Semantics**            | General-purpose              | Indicates service functionality      | Indicates data access and persistence            | Indicates a web controller               |
| **Special Features**     | None                         | None                                 | Exception translation for persistence exceptions | Mapping HTTP requests to handler methods |
| **Layer in Application** | Any                          | Service layer                        | Data access layer                                | Presentation layer                       |

#### @Component
- A generic stereotype for any Spring-managed component.
- Can be used to annotate any class to make it a Spring bean.
- No specific additional behavior is associated with it beyond making the class a Spring bean.
```java
@Component
public class MyComponent {
    public void perform() {
        System.out.println("Performing task");
    }
}
```
#### @Service
- A specialization of @Component indicating that the annotated class is a service component.
- Used for service layer components, which usually contain business logic.
- No specific additional behavior, but it provides better readability and clarity regarding the class's role in the application.
```java
@Service
public class MyService {
  public void executeService() {
    System.out.println("Executing service");
  }
}
```
#### @Repository
-  A specialization of @Component indicating that the annotated class is a repository (or DAO).
- Used for data access layer components.
- In addition to making the class a Spring bean, it also provides exception translation, converting database-related exceptions into Spring's DataAccessException.
```java
@Repository
public class MyRepository {
  public void saveData() {
    System.out.println("Saving data");
  }
}
```
#### @Controller
- A specialization of @Component indicating that the annotated class is a web controller.
- Used for presentation layer components, specifically to define web controllers in Spring MVC.
- Used in conjunction with Spring MVC to map web requests to handler methods.
```java
@Controller
public class MyController {
    @GetMapping("/foo")
    public String foo() {
        return "foo";
    }
}
```


### 9.  Explain  @Autowired,  @Qualifier,  @Resource  and  @Primary 
#### @Autowired
- Used for automatic dependency injection **DI**.
- Spring automatically injects the appropriate bean into the **s** where the `@Autowired` annotation is applied.
- By default, `@Autowired` injects the dependency by **type**. If multiple beans of the same type are available, an exception is thrown.
```java
@Component
public class MyComponent {
  @Autowired
  private MyService myService;

  public void doSomething() {
    myService.performService();
  }
}

```
#### @Qualifier
-  Used in conjunction with `@Autowired` to resolve ambiguity when **multiple beans of the same type** are available.
- Used to distinguish beans by name.
```java
@Component
public class MyComponent {
    @Autowired
    @Qualifier("specificService")
    private MyService myService;

    public void doSomething() {
        myService.performService();
    }
}

@Service("specificService")
public class SpecificService implements MyService {
  public void performService() {
    System.out.println("Specific Service");
  }
}

@Service("anotherService")
public class AnotherService implements MyService {
  public void performService() {
    System.out.println("Another Service");
  }
}

```
#### @Resource
- Used for automatic dependency injection **DI**.
- provides similar functionality to `@Autowired`, 
- it performs injection by **name** by default.
```java
@Component
public class MyComponent {
    @Resource(name = "specificService")
    private MyService myService;

    public void doSomething() {
        myService.performService();
    }
}

@Service("specificService")
public class SpecificService implements MyService {
  public void performService() {
    System.out.println("Specific Service");
  }
}
```
- If no `name` attribute is specified and the field name does not match any bean name, `@Resource` will try to resolve the dependency by type.

```java
@Component
public class MyComponent {
    @Resource
    private MyService myService;

    public void doSomething() {
        myService.performService();
    }
}

@Service
public class SpecificService implements MyService {
  public void performService() {
    System.out.println("Specific Service");
  }
}
```

- In this example, `@Resource` attempts to inject a bean of type `MyRepository`. If there is **only one** bean of that type, it will be **injected**. If there are **multiple beans** of that type, the **injection will fail** unless the field name matches one of the bean names.

#### @Primary
- give a **higher preference** to a bean when multiple candidates are available for autowiring.
- Marks a bean as the **primary candidate** for autowiring.
- Works with `@Autowired` to resolve ambiguity without using `@Qualifier`.
```java
@Service
@Primary
public class PrimaryService implements MyService {
    public void performService() {
        System.out.println("Primary Service");
    }
}

@Service
public class SecondaryService implements MyService {
    public void performService() {
        System.out.println("Secondary Service");
    }
}

@Component
public class MyComponent {
    @Autowired
    private MyService myService;

    public void doSomething() {
        myService.performService(); // Will use PrimaryService
    }
}
```


### 10.  How many annotations we can use to inject a bean?
#### `@AutoWired`: 

Used for automatic dependency injection by type. Can be applied to fields, constructors, or setter methods.

#### `@Qualifier`:

Used along with `@Autowired` to specify which bean to inject when multiple beans of the **same type** exist. Specifies the bean name or qualifier value.

#### `@Resource`

Used for dependency injection by **name** by default. Can be applied to fields, setter methods, or constructors. Resolves the bean by the name specified in the name attribute of the annotation.

#### `@Inject`

Used to inject values from properties files or environment variables. Can inject simple values like strings, numbers, or booleans into beans.

Works similarly to `@Autowired`, injecting by **type**. 

It does not have Spring-specific features like `@Qualifier`, but have a similar annotation `@Named`.

```java
@Component
public class MyService {

    @Inject
    @Named("specificRepository")
    private MyRepository myRepository;

    public void performService() {
        myRepository.saveData();
    }
}

@Named("specificRepository")
public class MyRepositoryImpl1 implements MyRepository {
    // Implementation details
}
```

#### `@Primary`

Indicates that a bean should be given preference when multiple candidates are available. Used to resolve ambiguity without using `@Qualifier`.

```java
@Component
public class MyComponent {
    @Inject
    private MyService myService;
}
```


### 11.  Explain and compare different types of dependency injection, their pros and cons, and use cases.

| **Aspect**                | **Constructor Injection**                                    | **Setter Injection**                                         | **Field Injection**                                          |
| ------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| **Definition**            | Dependencies are injected through the constructor.           | Dependencies are injected through setter methods.            | Dependencies are injected directly into fields.              |
| **Implementation**        | `@Autowired` on the constructor.                             | `@Autowired` on setter methods.                              | `@Autowired` on fields.                                      |
| **Injection Timing**      | Injected when the object is created.                         | Injected after the object is created through setter methods. | Injected directly into fields after object creation.         |
| **Optional Dependencies** | Not supported, all constructor parameters must be provided.  | Supported, dependencies can be set after object creation.    | Supported, dependencies can be set directly after object creation. |
| **Mutability**            | Dependencies are immutable, the object's state does not change after creation. | Dependencies are mutable, can be changed during the object's lifecycle. | Dependencies are mutable, can be changed during the object's lifecycle. |
| **Testability**           | **Easy** to test, as dependencies are explicitly passed via the constructor. | Testing may **require additional configuration** to ensure setters are called. | **Difficult** to test, as dependencies are implicitly injected. |
| **Code Conciseness**      | Code is longer, constructors can become complex with many parameters. | Code is simpler, reduces the number of constructor parameters. | Code is the most concise, dependencies are injected directly. |
| **Required Dependencies** | Requires all necessary dependencies to be provided at object creation. | Not required, dependencies can be set optionally.            | Not required, dependencies can be set optionally.            |
| **Object Initialization** | Object is fully initialized at creation, ensuring dependency completeness. | Dependencies may be set after object creation, which can lead to incomplete initialization. | Dependencies are set after object creation; the object may be incomplete at the start. |
| **Use Cases**             | Suitable for immutable objects and mandatory dependencies.   | Suitable for optional dependencies or when dependencies may change during the object's lifecycle. | Suitable for simple cases where testing and dependency management are not major concerns. |



### Constructor Injection
- involves passing dependencies to a class through its constructor. This means that all dependencies are provided when the class is instantiated.
```java
@Component
public class MyComponent {
    private final MyService myService;

    @Autowired
    public MyComponent(MyService myService) {
        this.myService = myService;
    }

    public void doSomething() {
        myService.performService();
    }
}

```
- Dependencies are set once at the time of object creation and cannot be changed, promoting immutability.
- Makes unit testing easier since dependencies are explicit and can be provided via the constructor.
- The required dependencies are clear from the constructor parameters, making it obvious what the class needs to function.
- Can become verbose if there are many dependencies.
- Can be problematic if there are circular dependencies between classes.
### Setter Injection
-  involves providing dependencies to a class via setter methods after the object has been instantiated.
```java
@Component
public class MyComponent {
    private MyService myService;

    @Autowired
    public void setMyService(MyService myService) {
        this.myService = myService;
    }

    public void doSomething() {
        myService.performService();
    }
}
```
- Dependencies can be changed after object creation, allowing for more flexible configurations.
- Can be used to inject optional dependencies that may not be required for the class to function.
- The object can be in an invalid state if not all dependencies are set before usage.
- Allows dependencies to be changed, which can lead to mutable objects and potential side effects.
### Field Injection
- Field injection involves directly injecting dependencies into fields using annotations.
```java
@Component
public class MyComponent {
    @Autowired
    private MyService myService;

    public void doSomething() {
        myService.performService();
    }
}
```
- Reduces code as there are no need for constructors or setter methods for dependency injection.
- Simple to use and requires minimal setup.
- More difficult to test since dependencies are not visible in constructors or setters, making it harder to mock dependencies.
- Breaks encapsulation by making the dependencies directly accessible as fields.
- Typically relies on reflection, which can have performance implications and make debugging harder.



### 12.  If we have multiple beans for one type, how to set one is primary? and how Spring IOC picks one bean to inject if no primary.

#### Using `@Primary` Annotation

Indicate that it should be given preference when multiple beans of the same type are available.

#### Using `@Qualifier` Annotation if no primary

Specify which bean to inject by name.



### 13.  Compare BeanFactory and ApplicationContext in Spring framework?

| Feature              | BeanFactory                       | ApplicationContext                               |
| -------------------- | --------------------------------- | ------------------------------------------------ |
| Lazy Initialization  | Yes                               | Yes (can be configured for eager initialization) |
| Dependency Injection | Basic                             | Full support (`@Autowired`, `@Resource`, etc.)   |
| Lifecycle Management | Basic                             | Enhanced (supports events, listeners)            |
| Resource Management  | Limited                           | Yes (supports accessing resources)               |
| Internationalization | No                                | Yes (supports message resolution)                |
| Event Handling       | No                                | Yes (supports application events)                |
| Annotation Support   | No                                | Yes (supports component scanning, annotations)   |
| Usage                | Resource-constrained environments | Most enterprise applications                     |

```java
BeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
MyBean myBean = (MyBean) factory.getBean("myBean");
```
```java
ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
MyBean myBean = (MyBean) context.getBean("myBean");
```


### 14.  Explain bean scope in Spring IOC?  List bean scopes with explanations and code examples if possible.
#### Singleton
- Default in Spring
- **Only one instance** of the bean is created per Spring IoC container.
- The same instance is shared and reused throughout the container.
- For Stateless beans that are shared across multiple components
```java
@Component
public class SingletonBean {
    // Bean definition
}

@Configuration
public class AppConfig {
    @Bean
    public SingletonBean singletonBean() {
        return new SingletonBean();
    }
}
```
#### Prototype Scope
- A new instance of the bean is created each time it is requested from the container.
- Not shared, each request results in a unique bean instance.
- For Stateful beans or beans that need to maintain state across different usage.
```java
@Component
@Scope("prototype")
public class PrototypeBean {
    // Bean definition
}

@Configuration
public class AppConfig {
    @Bean
    @Scope("prototype")
    public PrototypeBean prototypeBean() {
        return new PrototypeBean();
    }
}
```
#### Request Scope (Web-aware scope)
- A new instance of the bean is created for each HTTP request.
- Each HTTP request has its own instance of the bean.
- For Beans that are needed per HTTP request, such as request-specific data.
```java
@Component
@Scope("request")
public class RequestScopedBean {
    // Bean definition
}

@Configuration
public class AppConfig {
    @Bean
    @Scope("request")
    public RequestScopedBean requestScopedBean() {
        return new RequestScopedBean();
    }
}
```
#### Session Scope (Web-aware scope)
- A new instance of the bean is created for each HTTP session.
- Each HTTP session has its own instance of the bean.
- For Beans that need to store user session data.
```java
@Component
@Scope("session")
public class SessionScopedBean {
    // Bean definition
}

@Configuration
public class AppConfig {
    @Bean
    @Scope("session")
    public SessionScopedBean sessionScopedBean() {
        return new SessionScopedBean();
    }
}
```
#### Application Scope (Web-aware scope)
- A single instance of the bean is created for the entire web application.
- Shared across all requests and sessions.
- Beans that need to maintain application-wide state.
```java
@Component
@Scope("application")
public class ApplicationScopedBean {
    // Bean definition
}

@Configuration
public class AppConfig {
    @Bean
    @Scope("application")
    public ApplicationScopedBean applicationScopedBean() {
        return new ApplicationScopedBean();
    }
}
```
#### WebSocket Scope (Web-aware scope)
- A new instance of the bean is created for each WebSocket session.
- Each WebSocket session has its own instance of the bean.
- Beans that need to store WebSocket session data.
```java
@Component
@Scope("websocket")
public class WebSocketScopedBean {
    // Bean definition
}

@Configuration
public class AppConfig {
    @Bean
    @Scope("websocket")
    public WebSocketScopedBean webSocketScopedBean() {
        return new WebSocketScopedBean();
    }
}
```


### 15.  Configure a bean using xml. If bean has parameters / dependencies, how can we configure the bean?
```xml
<!-- applicationContext.xml -->
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Define a bean -->
    <bean id="userService" class="com.example.UserService">
        <!-- Injecting dependencies -->
        <property name="userRepository" ref="userRepository"/>
    </bean>

    <bean id="userRepository" class="com.example.UserRepository"/>

</beans>
```


### 16.  Do Q15 without xml, use Springboot IOC annotations instead.
```java
@Configuration
public class AppConfig {
  
    @Bean
    public UserService userService() {
        UserService userService = new UserService();
        userService.setUserRepository(userRepository()); // Dependency injection
        return userService;
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }
}
```