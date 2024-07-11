



2. Compare Spring and Springboot? What are the benfits of Srpingboot?

   - Spring:
     - **Core Framework:** Spring is a comprehensive framework for enterprise Java development. It provides a wide range of functionalities such as dependency injection, aspect-oriented programming, and transaction management.
     - **Modules:** It includes various modules like Spring MVC, Spring ORM, Spring AOP, and Spring Security.
     - **Configuration:** Configuration in Spring can be complex, involving XML configurations or Java-based configurations using annotations.
   - Spring boot:
     - **Built on Spring:** Spring Boot is built on top of the Spring framework. It simplifies the use of Spring by providing defaults and reducing boilerplate code.
     - **Auto-Configuration:** Provides auto-configuration for many Spring modules, reducing the need for manual setup.
     - **Standalone Applications:** Enables the creation of standalone, production-grade Spring applications that can run independently using an embedded server like Tomcat or Jetty.
     - **Starter POMs:** Offers starter POMs (Project Object Models) that simplify dependency management by providing a set of dependencies for common tasks.
   - Benifits of Spring boot:
     - **Simplified Configuration:**
       - Reduces the need for boilerplate code and extensive configuration.
       - Auto-configuration simplifies the setup process for Spring applications.
     - **Faster Development:**
       - Provides a range of starter templates for common functionalities, accelerating the development process.
       - Spring Initializr helps quickly bootstrap new projects.
     - **Embedded Servers:**
       - Supports embedded servers (Tomcat, Jetty, Undertow), allowing applications to run as standalone services.
       - Eliminates the need for deploying applications on external servers.

3. What is IOC and What is DI?

   1. IoC is a design principle where the control of creating and managing objects is transferred from the application code to the Spring container. This means that instead of the application code explicitly creating instances of objects, the Spring container takes care of it. This inversion of control from the application to the container enhances modularity and makes the system more testable and maintainable.
   2. DI is a design pattern and a subset of IoC. It is a way to achieve IoC, where dependencies are injected into a class rather than the class creating its own dependencies. DI allows the creation of dependent objects outside of a class and provides those objects to a class in various ways. This can be done through:
      - **Constructor Injection**: Dependencies are provided through a class constructor.
      - **Setter Injection**: Dependencies are provided through setter methods.
      - **Field Injection**: Dependencies are injected directly into fields.

4. What is  `@CompnonentScan` ?

   In Spring, the `@ComponentScan` annotation is used to specify the packages to scan for Spring-managed components. It tells the Spring framework where to look for annotated components (like `@Component`, `@Service`, `@Repository`, `@Controller`, etc.) so that they can be registered as beans in the Spring application context.

   The `@ComponentScan` annotation is typically used in configuration classes that are annotated with `@Configuration` or as part of a Spring Boot application class annotated with `@SpringBootApplication`.

5. What is  `@SpringbootApplication`

   The `@SpringBootApplication` annotation is a convenience annotation that is used in Spring Boot applications. It combines three commonly used annotations:

   - `@Configuration`
   - `@EnableAutoConfiguration`
   - `@ComponentScan`

   This single annotation helps in setting up the Spring application context, enabling automatic configuration, and component scanning.

6. How many ways to define a bean? Provide code examples.

   **`@Component` Annotation**:

   ```java
   @Component
   public class MyComponent { }
   ```

   **Specialized Stereotype Annotations (`@Service`, `@Repository`, `@Controller`)**:

   ```java
   @Service
   public class MyService { }
   ```

   **`@Bean` Annotation in a Configuration Class**:

   ```java
   @Configuration
   public class AppConfig {
       @Bean
       public MyBean myBean() { return new MyBean(); }
   }
   ```

   **XML Configuration**:

   ```xml
   <bean id="myBean" class="com.example.MyBean" />
   ```

   **`@Configuration` with `@ComponentScan`**:

   ```java
   @Configuration
   @ComponentScan(basePackages = "com.example")
   public class AppConfig { }
   ```

   **Java Configuration with `@Import`**:

   ```java
   @Configuration
   @Import({AppConfig.class, OtherConfig.class})
   public class MainConfig { }
   ```

   **Using `FactoryBean`**:

   ```java
   public class MyFactoryBean implements FactoryBean<MyBean> {
       // implementation
   }
   @Configuration
   public class AppConfig {
       @Bean
       public MyFactoryBean myFactoryBean() { return new MyFactoryBean(); }
   }
   ```

7. What is default bean name for  `@Component`  and  `@Bean` ? Also compare  `@Component`  and  `@Bean`

   ```java
   @Component
   public class MyService {
       // ...
   }
   ```

   The default bean name would be `myService`.

   ```java
   @Configuration
   public class AppConfig {
   
       @Bean
       public MyService myService() {
           return new MyService();
       }
   }
   ```

   The default bean name would be `myService`.

   - **`@Component`**: It is a class-level annotation used to automatically detect and register beans with Spring’s application context during classpath scanning. It is typically used for classes that are part of the application's business logic and are not configurations.

   - **`@Bean`**: It is a method-level annotation used in a configuration class (`@Configuration`). It is used to define and register beans explicitly within the Spring application context.

8. 

   **`@Component`**

   - **Purpose**: General-purpose stereotype annotation.

   - **Usage**: Used to indicate that a class is a Spring-managed component. It is a generic annotation that can be used when the specific role of the class is not clear or when none of the other annotations (`@Service`, `@Repository`, `@Controller`) are applicable.

   - Example:

     ```java
     @Component
     public class MyComponent {
         // business logic
     }
     ```

   **`@Service`**

   - **Purpose**: Specialization of `@Component` for service-layer components.

   - **Usage**: Used to indicate that a class performs service tasks, typically containing business logic and service-related operations. It helps to clearly communicate the intent that the class contains service logic.

   - Example:

     ```java
     @Service
     public class MyService {
         // business logic
     }
     ```

   **`@Repository`**

   - **Purpose**: Specialization of `@Component` for persistence-layer components.

   - **Usage**: Used to indicate that a class is responsible for data access and typically interacts with a database. It also provides additional functionality such as automatic exception translation, converting database exceptions into Spring’s DataAccessException hierarchy.

   - Example:

     ```java
     @Repository
     public class MyRepository {
         // database access logic
     }
     ```

   **`@Controller`**

   - **Purpose**: Specialization of `@Component` for presentation-layer components.

   - **Usage**: Used to indicate that a class is a Spring MVC controller. It is typically used for classes that handle web requests and return web responses (often views). When combined with `@ResponseBody`, it can also return JSON or XML directly.

   - Example

     ```java
     @Controller
     public class MyController {
         // handler methods for web requests
     }
     ```

9.  Explain  @Autowired ,  @Qualifier  ,  @Resource  and  @Primary ?

   **`@Autowired`**: Automatically injects dependencies by type. Used for field, setter, and constructor injection.

   **`@Qualifier`**: Used with `@Autowired` to resolve ambiguity by specifying which bean to inject.

   **`@Resource`**: Similar to `@Autowired` but provides more control, allowing injection by name or type. Part of Java EE standard.

   **`@Primary`**: Specifies the default bean to be used when multiple beans of the same type are available, giving it higher preference.

10. How many annotaitons we can use to inject a bean?

    | Annotation   | Provided By      | Injection Type       | Usage Scope                   | Typical Use Case                                          |
    | ------------ | ---------------- | -------------------- | ----------------------------- | --------------------------------------------------------- |
    | `@Autowired` | Spring Framework | By type              | Fields, Setters, Constructors | General-purpose Spring dependency injection               |
    | `@Qualifier` | Spring Framework | By name (with type)  | Used with `@Autowired`        | Disambiguating when multiple beans of the same type exist |
    | `@Resource`  | Java EE          | By name (and type)   | Fields, Setters               | Java EE standard injection by name                        |
    | `@Inject`    | JSR-330 (Java)   | By type              | Fields, Setters, Constructors | Standard Java dependency injection                        |
    | `@Value`     | Spring Framework | Properties injection | Fields, Setters, Constructors | Injecting configuration values                            |

11. Explain and compare differnet types of denpendency injection, their pros and cons, and use cases.

    - Constructor injection

      ```java
      public class MyService {
          private final MyRepository myRepository;
      
          @Autowired
          public MyService(MyRepository myRepository) {
              this.myRepository = myRepository;
          }
      }
      ```

      **Pros**:

      - **Immutability**: Since dependencies are provided at the time of object creation and declared as `final`, they cannot be changed.
      - **Testing**: Easier to write unit tests as dependencies are provided via constructors.
      - **Clear Dependencies**: The dependencies required by a class are clearly listed in the constructor, making it more transparent.

      **Cons**:

      - **Boilerplate Code**: More boilerplate code if the number of dependencies is large.
      - **Circular Dependencies**: More challenging to resolve circular dependencies.

      **Use Cases**:

      - When the class requires all dependencies at the time of instantiation.
      - When dependencies are mandatory for the class to function correctly.

    - Setter injection

      ```java
      public class MyService {
          private MyRepository myRepository;
      
          @Autowired
          public void setMyRepository(MyRepository myRepository) {
              this.myRepository = myRepository;
          }
      }
      
      ```

      **Pros**:

      - **Optional Dependencies**: Suitable for optional dependencies that might not always be needed.
      - **Flexibility**: Dependencies can be changed or re-injected after object creation.

      **Cons**:

      - **Mutable State**: Allows for the possibility of changing dependencies, which can lead to mutable state issues.
      - **Less Clear Dependencies**: Dependencies are not immediately apparent from the constructor, making it less transparent.

      **Use Cases**:

      - When some dependencies are optional or can be set after object creation.
      - When a class has a large number of dependencies, and you want to avoid a complex constructor.

    - Field Injection

      ```java
      public class MyService {
          @Autowired
          private MyRepository myRepository;
      }
      ```

      **Pros**:

      - **Conciseness**: Less boilerplate code, as dependencies are injected directly into fields.
      - **Ease of Use**: Simplifies the code by avoiding constructors and setters for dependencies.

      **Cons**:

      - **Testing Difficulty**: Harder to write unit tests, as you need reflection to set private fields.
      - **Lack of Immutability**: Dependencies can be changed if fields are not `final`.
      - **Hidden Dependencies**: Dependencies are not visible in the constructor, making it less clear what a class depends on.

      **Use Cases**:

      - Quick and straightforward projects where simplicity and conciseness are prioritized.
      - When dependency injection frameworks or tools are managing the injection process.

12. If we have multiple beans for one type, how to set one is primary? and how Spring IOC picks one bean to inject if no primay.

    - **@Primary**: Use `@Primary` to designate a bean as the primary candidate when multiple beans of the same type are present.
    - **@Qualifier**: Use `@Qualifier` to specify which bean to inject when there are multiple beans of the same type and no primary bean is defined.
    - **Default Behavior**: Without `@Primary` or `@Qualifier`, Spring will throw an exception if multiple beans of the same type exist and it cannot determine which one to inject.

13. Compare BeanFactory and ApplicationContext in Spring framework?

    | Feature                             | `BeanFactory`                                  | `ApplicationContext`                        |
    | ----------------------------------- | ---------------------------------------------- | ------------------------------------------- |
    | **Initialization**                  | Lazy (beans created on demand)                 | Eager (beans created at startup)            |
    | **Event Handling**                  | Not supported                                  | Supported                                   |
    | **Internationalization (i18n)**     | Not supported                                  | Supported                                   |
    | **AOP Support**                     | Basic                                          | Advanced                                    |
    | **Resource Loading**                | Limited                                        | Advanced                                    |
    | **Environment Abstraction**         | Not supported                                  | Supported                                   |
    | **Integration with Spring Modules** | Basic                                          | Advanced (seamless integration with Spring) |
    | **Use Case**                        | Lightweight, resource-constrained applications | Enterprise-level applications               |

    **BeanFactory**:

    - **Pros**: Lightweight, suitable for simple applications with resource constraints.
    - **Cons**: Limited features, lacks support for advanced container functionalities.

    **ApplicationContext**:

    - **Pros**: Rich feature set, supports enterprise-level functionalities like event handling, AOP, and i18n.
    - **Cons**: More resource-intensive due to eager initialization of beans.

14. Explain bean scope in Spring IOC?  List bean scopes with explainations and code examples if possible.

    **1. Singleton**

    **Description**: The default scope in Spring. A single instance of the bean is created and shared across the entire Spring container.

    **Use Case**: Use when you want a single shared instance for the entire application context.

    **Example**:

    ```java
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.Scope;
    
    @Configuration
    public class AppConfig {
    
        @Bean
        public MySingletonBean mySingletonBean() {
            return new MySingletonBean();
        }
    }
    
    public class MySingletonBean {
        // Bean implementation
    }
    ```

    **2. Prototype**

    **Description**: A new instance of the bean is created every time it is requested from the Spring container.

    **Use Case**: Use when you need a new instance of the bean for each request.

    **Example**:

    ```java
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.Scope;
    
    @Configuration
    public class AppConfig {
    
        @Bean
        @Scope("prototype")
        public MyPrototypeBean myPrototypeBean() {
            return new MyPrototypeBean();
        }
    }
    
    public class MyPrototypeBean {
        // Bean implementation
    }
    ```

    **3. Request**

    **Description**: A single instance of the bean is created and shared per HTTP request. Only applicable in a web-aware Spring application context.

    **Use Case**: Use when you need a single instance of a bean for the duration of an HTTP request.

    **Example**:

    ```java
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.Scope;
    import org.springframework.web.context.annotation.RequestScope;
    
    @Configuration
    public class WebConfig {
    
        @Bean
        @RequestScope
        public MyRequestBean myRequestBean() {
            return new MyRequestBean();
        }
    }
    
    public class MyRequestBean {
        // Bean implementation
    }
    ```

    **4. Session**

    **Description**: A single instance of the bean is created and shared per HTTP session. Only applicable in a web-aware Spring application context.

    **Use Case**: Use when you need a single instance of a bean for the duration of an HTTP session.

    **Example**:

    ```java
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.Scope;
    import org.springframework.web.context.annotation.SessionScope;
    
    @Configuration
    public class WebConfig {
    
        @Bean
        @SessionScope
        public MySessionBean mySessionBean() {
            return new MySessionBean();
        }
    }
    
    public class MySessionBean {
        // Bean implementation
    }
    ```

    **5. Application**

    **Description**: A single instance of the bean is created and shared per ServletContext. Only applicable in a web-aware Spring application context.

    **Use Case**: Use when you need a single instance of a bean for the duration of a web application.

    **Example**:

    ```java
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.Scope;
    import org.springframework.web.context.annotation.ApplicationScope;
    
    @Configuration
    public class WebConfig {
    
        @Bean
        @ApplicationScope
        public MyApplicationBean myApplicationBean() {
            return new MyApplicationBean();
        }
    }
    
    public class MyApplicationBean {
        // Bean implementation
    }
    ```

    **6. WebSocket**

    **Description**: A single instance of the bean is created and shared per WebSocket.

    **Use Case**: Use when you need a single instance of a bean for the duration of a WebSocket session.

    **Example**:

    ```java
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.Scope;
    import org.springframework.web.socket.config.annotation.EnableWebSocket;
    import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
    
    @Configuration
    @EnableWebSocket
    public class WebSocketConfig implements WebSocketConfigurer {
    
        @Bean
        @Scope("websocket")
        public MyWebSocketBean myWebSocketBean() {
            return new MyWebSocketBean();
        }
    
        // WebSocket configuration implementation
    }
    
    public class MyWebSocketBean {
        // Bean implementation
    }
    ```

    | Scope           | Description                                                  | Use Case                                                     |
    | --------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
    | **Singleton**   | Single instance per Spring IoC container                     | Shared configuration or service beans                        |
    | **Prototype**   | New instance each time bean is requested                     | Stateful beans, beans that maintain user session information |
    | **Request**     | Single instance per HTTP request (web application context)   | Beans that are specific to a single HTTP request             |
    | **Session**     | Single instance per HTTP session (web application context)   | Beans that need to be preserved across multiple HTTP requests |
    | **Application** | Single instance per ServletContext (web application context) | Beans that are shared across the entire web application      |
    | **WebSocket**   | Single instance per WebSocket                                | Beans that are specific to a WebSocket session               |

15. Configure a bean using xml. If bean has parameters/dependencies, how can we configure the bean? 

    ```xml
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://www.springframework.org/schema/beans 
                               http://www.springframework.org/schema/beans/spring-beans.xsd">
    
        <bean id="myBean" class="com.example.MyBean"/>
    </beans>
    ```

    - With Constructor Injection:

      ```xml
      <beans xmlns="http://www.springframework.org/schema/beans"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://www.springframework.org/schema/beans 
                                 http://www.springframework.org/schema/beans/spring-beans.xsd">
      
          <bean id="myDependency" class="com.example.MyDependency"/>
      
          <bean id="myBean" class="com.example.MyBean">
              <constructor-arg ref="myDependency"/>
          </bean>
      </beans>
      ```

    - With setter injection:

      ```xml
      <beans xmlns="http://www.springframework.org/schema/beans"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://www.springframework.org/schema/beans 
                                 http://www.springframework.org/schema/beans/spring-beans.xsd">
      
          <bean id="myDependency" class="com.example.MyDependency"/>
      
          <bean id="myBean" class="com.example.MyBean">
              <property name="myDependency" ref="myDependency"/>
          </bean>
      </beans>
      ```

      

      

      

      