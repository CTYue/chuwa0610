1.  List all of the annotations you learned from class and homework to annotaitons.md (your own
    cheatsheet).   
    [annotations.md](annotations.md)
2.  Compare Spring and Springboot? What are the benefits of Srpingboot?
    - Spring, has many features
      - DI, Dependency Injection
      - AOP, Aspect Oriented Programming
      - MVC, Model-View-Controller design pattern
      - Data Access, simplifies working with JDBC, using ORM framework
    - SpringBoot
      - built on top of Spring Framework and aims to simplify the setup and development
      - Auto Configuration, automatically configures based on the classpath
      - Embedded Servers
      - Starter POMs
      - Spring Initializer, web based tool
      - Production Ready features, like monitoring, metrics,health check
    - benefits of SpringBoot
      - Simplified Configuration
      - Embedded Servers
      - Production-Ready Features: Actuator
      - microservice support:
        - easy to use RESTful web services
        
3.  What is IOC and What is DI?
    - IOC
      - Inversion of Control, is a design principle where the control of objects is transferred from the developer to a container or framework.
      - decouple the execution and implementation. 
    - DI
      - Dependency Injection
      - it's a form of IoC, the dependencies are injected into a class, rather than the class creating or looking up its dependencies.

4.  What is  @CompnonentScan ?
    - an annotation to specify the base packages to scan for Spring components.
    ```
    @Configuration
    @ComponentScan(basePackages = "com.example.package")
    public class AppConfig {
        // Additional bean definitions if needed
    }
    ```
    
5.  What is  @SpringbootApplication ?
    - a central annotation in Spring Boot that combines several other annotations to help the configuration of Spring Boot Applications.
    - is typically placed on the main class of a Spring Boot application, which serves as the entry point of the application.
    - @Configuration + @EnableAutoConfiguration + @ComponentScan
    
6.  How many ways to define a bean? Provide code examples.
    - @Component 
      - ```
        @Component
        public class Com1 {
            
        }
        ```
    - @Configuration +  @Bean
      - ```
        @Configuration
        public class Com2 {
            @Bean
            public MyService myService() {
                return new MyServiceImpl();
            }
        }
        ```
    - XML configuration
      - ```
        <beans ...>
            <bean id = "myService" class="..."/>
        </beans>
        ``` 
    - @Service, @Repository @Controller, @RestController
    
7.  What is default bean name for  @Component  and  @Bean ? Also compare  @Component  and  @Bean .
    - default bean name
      - @Component: the default name is the unqualified class name with the first letter in lowercase.
      - @Bean: the default bean name is the method that defines the bean.
      - difference
        - @Component: 
          - class level
          - used to auto-detect and auto-configure beans using classpath scanning.
        - @Bean
          - method level, usually with @Configuration
          - to explicitly declare a single, usually for 3rd-party libraries.
        
8.  Compare  @component  and  @service , @repository ,  @controller ?
    - are stereotype annotations to mark a class as Spring-managed bean
    - @Component: a generic stereotype annotation used to mark a class as a spring component.
    - @Service: specialized version of @Component for service layer classes.
    - @Repository: specialized version of @Component for data access layer classes.
    - @Controller: specialized version of @Component for web layer classes

9.  Explain  @Autowired ,  @Qualifier  ,  @Resource  and  @Primary ?
    - they are used for dependency injection
    - @Autowired
      - can be applied to constructors, method, fields or setters.
    - @Qualifier
      - used to resolve ambiguity when multiple beans of the same type are present.
    - @Resource
      - can be applied to fields or setter methods
    - @Primary
      - indicate a bean should be given preference when multiple beans of the same type are present.
    

10.  How many annotations we can use to inject a bean?
    - Class level
      - @Component, @Service, @Repository, @Controller, @RestController, @ControllerAdvice
    - Method level
      - @Bean with @Configuration together
    - XML
      - <bean id="xxx" class = "..."></bean>
     
11. Explain and compare differnet types of denpendency injection, their pros and cons, and use cases.
    - Constructor Injection
    ```
    @Component
    public class MyClass {

        private DogsController controller;
        private DogsService service;
        private DogsDao dao;
        private ApplicationProperties properties;
 
        @Autowired
        public MyClass(DogsController controller, DogsService service, DogsDao dao, ApplicationProperties properties) {
            this.controller = controller;
            this.service = service;
            this.dao = dao;
            this.properties = properties;
        }
    }
    ```
    - Setter Injection
    ```
    @Component
    public class MyClass {

        private DogsController controller;
        private DogsService service;
        private DogsDao dao;
        private ApplicationProperties properties;
     
        @Autowired
        public void setController(DogsController controller) {
            this.controller = controller;
        }
     
        @Autowired
        public void setService(DogsService service) {
            this.service = service;
        }
 
    ...
    ```
    - Field Injection
    ```
    @Component
    public class MyClass {
        @Autowired private DogsController controller;
        @Autowired private DogsService service;
        @Autowired private DogsDao dao;
        @Autowired private ApplicationProperties properties;
    }
    ```
    |                     | Field Injection                                 | Constructor Injection                               | Setter Injection                                                   |
    |---------------------|-------------------------------------------------|-----------------------------------------------------|--------------------------------------------------------------------|
    | Readability         | best, less boilerplate, focus on business logic | better, visually stand separate from methods        | worst, add instance methods                                        |
    | Immutability        | no immutability                                 | supports immutability                               | no immutability                                                    |
    | State Safety        | possible missing                                | State Safe, full state or no, explicit dependencies | no-argument constructor, no way to set the state except Reflection |
    | Test                | not friendly with test, may need Reflection     | test-friendly                                       | test-friendly                                                      |
    | Circular Dependency | hard to diagnose                                | helps identity circular dependencies                ||

12. If we have multiple beans for one type, how to set one is primary? and how Spring IOC picks one bean to inject if no primary.
    - set primary
      - using @Primary
      - example
      ```
        interface MyService {
            void performAction();
        }
    
        @Component
        class MyServiceImpl1 implements MyService {
            @Override
            public void performAction() {
                System.out.println("Action performed by MyServiceImpl1");
            }
        }
        
        @Component
        @Primary
        class MyServiceImpl2 implements MyService {
            @Override
            public void performAction() {
                System.out.println("Action performed by MyServiceImpl2");
            }
        }
      ```
      - Injection rules without primary
        - @Autowired
          - by type
          - if many impl of a type, then using @Qualifier("name")

13.  Compare BeanFactory and ApplicationContext in Spring framework?   

| Feature                                         | BeanFactory             | ApplicationContext                                             |
|-------------------------------------------------|-------------------------|----------------------------------------------------------------|
| -                                               | basic Functionality     | basic + some advance features                                  |
| Bean instantiation/wiring                       | Yes                     | Yes                                                            |
| Automatic BeanPostProcessor registration        | x                       | Yes                                                            |
| Automatic BeanFactoryPostProcessor registration | x                       | Yes                                                            |
| Convenient MessageSource Access                 | x                       | Yes                                                            |
| Application Event Pulication                    | x                       | Yes                                                            |
| Scope                                           | Singleton and Prototype | Singleton, Prototype, request, session, application, websocket |



14.  Explain bean scope in Spring IOC?  List bean scopes with explainations and code examples if possible.
    - Singleton: default
        - instantiated once per Spring IoC container and shared across the entire application
    - Prototype
        - instantiated each time when it is requested
    - Web application
        - Request
          - instantiated once per HTTP request.
        - Session
          - instantiated once per HTTP session.
    
    ```
    @Configuration
    public class AppConfig {
        @Bean
        @Scope("singleton")/ @Scope("prototype")/ @RequestScope/ @SessionScope
        public Myservice singleton() {
            return new singletonService();
        }
    }
    ```

15. Configure a bean using xml. If bean has parameters/dependencies, how can we configure the bean?   
    - Use @Component and @Bean to configure the bean
    ```
    // define a class Cat, Dog without @Component, @Bean
    // define bean.xml
    
    //Dog.java
    public class Dog implements Animal{
        @Override
        public void sound() {
            System.out.println("this is a dog");
        }
    }
    // Cat.java
    public class Cat implements Animal {
        @Override
        public void sound() {
            System.out.println("this is a cat");
        }
    }
    
    // bean.xml
    <beans ...>
        <context:component-scan base-package="com.example.beantest"/>
        <bean id="kitten" class="com.example.beantest.components.impl.Cat"></bean>
        <bean id="puppy" class="com.example.beantest.components.impl.Dog"></bean>
    </beans>
    
    // get beans
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
    
        Animal puppy = (Animal) context.getBean("puppy");
        puppy.sound();

        Animal kitten = (Animal) context.getBean("kitten");
        kitten.sound();
    }
    ```
16. Do Q15 without xml, use Springboot IOC annotations instead.   
    ```
    add @Component or @Bean(with @Configuration) to the beans
    no bean.xml
    
    //Dog.java
    @Component
    public class Dog implements Animal{
        @Override
        public void sound() {
            System.out.println("this is a dog");
        }
    }
    // Cat.java
    @Component
    public class Cat implements Animal {
        @Override
        public void sound() {
            System.out.println("this is a cat");
        }
    }
    ```
