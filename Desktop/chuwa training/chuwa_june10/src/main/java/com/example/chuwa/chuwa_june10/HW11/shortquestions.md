## 2.  Compare Spring and Springboot? What are the benfits of Srpingboot?
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
## 3.  What is IOC and What is DI?
    - IOC 
      - Inversion of Control, is a design principle where the control of objects is transferred from the developer to a container or framework.
    - DI
      - It is a form of IoC implementation where dependencies are injected into classes instead of the class creating or looking up its dependencies itself.
## 4.  What is  @ComponentScan ?
    - Annotations used to specify base packages, and Spring will then scan components in these packages and register them with the IoC container.
```java
@Configuration
@ComponentScan(basePackages = "com.example.myapp")// specify base package path.
public class AppConfig {
    // .....
}
```
## 5.  What is  @SpringbootApplication ?
```text
  a central annotation in Spring Boot that combines several other annotations to help the configuration of Spring Boot Applications.
  is typically placed on the main class of a Spring Boot application, which serves as the entry point of the application.
```
    - @Configuration + @EnableAutoConfiguration + @ComponentScan
## 6.  How many ways to define a bean? Provide code examples.
- 1 @Component
````java
 @Component
    public class Com1 {
        
    }
````
- 2 @Configuration + @Bean
```java
 @Configuration
    public class Com2 {
        @Bean
        public MyService myService() {
            return new MyServiceImpl();
        }
    }
```
- 3 XML configuration
```text
 <beans ...>
       <bean id = "myService" class="..."/>
  </beans>
```
- others: @Service, @Repository @Controller, @RestController
## 7.  What is default bean name for  @Component  and  @Bean ? Also compare  @Component  and  @Bean .
- @Component: the default name is the unqualified class name with the first letter in lowercase. 
  - example: class "MyService", the default bean name is: "myService"
- @Bean: the default bean name is the method that defines the bean. 
  - example: method "MyService", the default bean name is: "myService", Typically used with "@Configuration"

- difference
```text
 @Component: class level annotation, be used to auto-detect and auto-configure beans using classpath scanning.
 @Bean: method level annotation, usually be used with @Configuration to explicitly declare a bean, usually for 3rd-party libraries
```
## 8.  Compare  @component  and  @service , @repository ,  @controller ?
- @Component: a generic  annotation used to mark a class as a spring component.
- @Service: specialized version of @Component for service layer classes.
- @Repository: specialized version of @Component for data access layer classes.
- @Controller: specialized version of @Component for web layer classes
## 9.  Explain  @Autowired ,  @Qualifier  ,  @Resource  and  @Primary ?
- they are used for dependency injection
```text
 - @Autowired : can be applied to constructors, method, fields or setters.
 - @Qualifier : used to resolve ambiguity when multiple beans of the same type are present.
    @Autowired
    public PetService(@Qualifier("cat") Animal animal) {
        this.animal = animal;
    }
    
 - @Resource : Supports injection by name, supports injection by type, Injected by name by default,  can be applied to fields or setter methods.
 - @Primary : indicate a bean should be given preference when multiple beans of the same type are present.
```
 
## 10.  How many annotations we can use to inject a bean?
```text
 Class level:  @Component, @Service, @Repository, @Controller, @RestController, @ControllerAdvice
 Method level : @Bean with @Configuration together
 XML file:  <bean id="xxx" class = "..."></bean>
```
## 11.  Explain and compare different types of dependency injection, their pros and cons, and use cases.
- Constructor Injection： Dependencies are injected through the class constructor.
  - pros: Injectable immutable objects；  Injected objects cannot be modified； Applicable to any environment, whether it is IOC framework or non-IOC framework,
  - cons: Can lead to longer constructor parameter lists in classes when we use multiple dependencies.
- Setter Injection： Dependencies are injected through the setter method
  - pros: Allows dependencies to be injected dynamically after object creation
  - cons: Unable to inject an immutable object, a final modified object， Injected objects can be modified
- Field Injection：Dependencies are directly injected into class fields using annotations like @Autowired.
  - pros: Simple to implement and use, just add an annotation (@Autowired) to the variable
  - cons: Unable to inject an immutable object, a final modified object
## 12.  If we have multiple beans for one type, how to set one is primary? and how Spring IOC picks one bean to inject if no primay.
- set one is primary when multiple beans for one type
```java
public interface Animal {
  void makeSound();
}

@Component
public class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}

@Component
@Primary //  when we use animal interface to inject object in class ,spring will set the dog instance as primary bean,
public class Dog implements Animal {
  @Override
  public void makeSound() {
    System.out.println("Bark");
  }
}

```

## 13.  Compare BeanFactory and ApplicationContext in Spring framework?
- BeanFactory
```text
BeanFactory is the basic interface of the Spring framework, which provides basic dependency injection and bean lifecycle management functions. 
It is suitable for situations where resources are limited or performance requirements are not high.
```
- ApplicationContext
```text
It is an extension of BeanFactory, providing more enterprise-level functions and services, 
suitable for most enterprise applications, 
especially for higher requirements for functions and scalability.
```
## 14.  Explain bean scope in Spring IOC?  List bean scopes with explainations and code examples if possible.
- Bean scope in Spring IOC：Bean Scope defines the life cycle and visibility scope of a bean instance.

- Singleton : instantiated once per Spring IoC container and shared by the entire application
  - Lifecycle: Instantiated when the container starts and destroyed when the container is shut down.
- Prototype: Each time send a request to the container, a new bean instance is created.
  - Lifecycle: Spring does not manage the complete lifecycle of a bean, instead it creates and returns new instances when requested.
```java
@Configuration
    public class AppConfig {
        @Bean
        @Scope("singleton")/ @Scope("prototype")/ @RequestScope/ @SessionScope
        public Myservice singleton() {
            return new singletonService();
        }
    }
```
## 15.  Configure a bean using xml. If bean has parameters/dependencies, how can we configure the bean?
- create xml file;
- Generate a namespace and introduce spring related tags
- Configure beans: Use the bean tag in the xml file to configure bean information
- Set properties: Set properties through the property tag, set the name and value of the property.
- Set dependencies: Use the ref attribute to introduce dependencies
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

  <bean id="exampleBean" class="com.example.ExampleBean">
    <property name="propertyName" value="propertyValue"/>
    <property name="dependency" ref="dependencyBean"/>
  </bean>

  <!-- Define dependencyBean if it's not defined elsewhere -->
  <bean id="dependencyBean" class="com.example.DependencyBean"/>

</beans>

```

## 16.  Do Q15 without xml, use Springboot IOC annotations instead.
``` java
@Component
public class MyBean {
    private String name;
    private int age;

    public MyBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getters and setters
}
```