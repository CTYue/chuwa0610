### HW44 - Spring MVC / HW 12

### 1. List all of the annotations you learned from class and homework to annotaitons.md

### 2. What is MVC pattern? 

Model-View-Controller (MVC) pattern.

- **Model**
  - a container for data, used to transfer data from one part to another. 
  - It is responsible for managing the data, processing it, and ensuring that it is consistent and valid.

- **View**:
  - receives the model containing data. It reads the model and displays the data.
  - It represents the **user interface** of the application.
  - It is responsible for presenting the data in a specific format but does not contain any business logic.

- **Controller**:
  - front controller maps the incoming request to a controller
  - Controller contains the business logic of the application
  - returns the model back to the front controller

### 3. What is Front-Controller? 

- A design pattern used in web applications to **handle all requests through a single entry point**. 
- This centralizes request processing to provide **a common place** to handle authentication, logging, request dispatching, and other tasks, instead of handling by individual components.
- The front controller maps the incoming request to a controller.

### 4. What is DispatcherServlet? please decribe how it works. 

The `DispatcherServlet` is a central component of the Spring MVC framework. It acts as the front-controller, handling all incoming HTTP requests and delegating them to appropriate handlers.

#### How it Works:

1. **Initialization**: On startup, `DispatcherServlet` is initialized and configured.
2. Tomcat receive request, then `DispatcherServlet` intercepts it. 
   - **Maps Request**: Map an HTTP request to an appropriate handler using handler mappings.
   - **Calls Handler**: Invokes the controller method associated with the request. 
     Parsing of HTTP request data and headers into data transfer objects (DTOs)or domain objects.
     Model-view-controller interaction
   - **Processes Result**: Handles the result by rendering a view or providing a response.
3. **View Resolution**: It uses view resolvers to interpret the view name and generate the view response (e.g., rendering a JSP).
4. Rendering the view The selected view renders the response (typically as HTML) and sends it back to the client.



### 5. What is JSP and What is ModelAndView？ (please google to have a basic knowlege) 

#### JSP (Jakarta Server Pages)

- A technology used for creating **dynamic web content** in Java.
-  It allows embedding Java code in HTML pages to generate dynamic content based on user requests and other data.

- Designed to simplify the creation of web-based user interfaces for Java applications.
- Allows the separation of the presentation layer from the business logic.

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome to JSP!</h1>
    <p>Current time: <%= new java.util.Date() %></p>
</body>
</html>
```



#### ModelAndView

A **class** in the Spring framework that **holds both** the model data and the view information, making it possible for a handler to **return both model and view in a single return value**.

- **Model**: Represents the data that will be displayed in the view.
- **View**: Represents the name of the view that should render the model data.

```java
@Controller
public class ExampleController {

  @RequestMapping("/hello")
  public ModelAndView hello() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("hello"); // Name of the view
    modelAndView.addObject("message", "Hello, World!"); // Adding data to the model
    return modelAndView;
  }
}

```



### 6. Could you please google any other servlets(理解多少是多少，不要花太多时间，知道servlet的名字就⾏。 ) 

#### HttpServlet

The most commonly used servlet, it provides methods to handle HTTP requests such as GET and POST.

#### GenericServlet

A protocol-independent servlet that can handle any type of request. It requires overriding the `service` method to handle client requests.

#### Servlet Filters

Used to perform filtering tasks like logging, authentication, and data transformation before reaching the servlet. Filters can modify request and response objects.

#### RequestDispatcher

Allows request forwarding and including responses from another resource (servlet, JSP, HTML file).



### 7. How many web server do you know? (Tomcat, Jetty, Jboss)

**Apache Tomcat**: An open-source implementation of Java Servlets, JavaServer Pages, Java Expression Language, and Java WebSocket technologies.

**Jetty**: A lightweight, highly scalable server used in both production and development environments.

**JBoss/WildFly**: An open-source Java EE application server developed by Red Hat.

**GlassFish**: An open-source application server for Java EE, originally developed by Sun Microsystems.

**Apache HTTP Server**: A robust, highly customizable web server used to serve static and dynamic content.

**Nginx**: Known for its high performance, stability, and low resource consumption, often used as a reverse proxy and load balancer.

**Microsoft Internet Information Services (IIS)**: A flexible, secure, and manageable Web server for hosting anything on the Web.

**LiteSpeed**: A high-performance Apache drop-in replacement, known for its high speed and efficiency.

**Node.js**: While not a traditional web server, it's an open-source, cross-platform runtime environment for executing JavaScript server-side, often used to build fast and scalable network applications.



### 8. clone this repo, and run it in you local. 

1. https://github.com/CTYue/springmvc5-demo 
2. Notice that you need to configure the Tomcat by yourself. tutorial in the slides. 
3. find out the APIs in controlelr and call some APIs, In slides, I also list some API. 
4. remeber to create a database for this project 5. all details in the slides.