# Homework 7

## Yirun Wang

### 2. explain how the below annotaitons specify the table in database?
The name field will map to a column in the database table. The data type is varchar, limit length is 255, and the default value is "John Snow".
studentName will map to a column in the database table called "STUDENT_NAME". It is varchar with a maximum length of 50. It can't contain Null value. Duplicate values are allowed.

### 3. What is the default column names of the table in database for @Column?
firstName
operatingSystem

### 4. What are the layers in springboot application? what is the role of each layer?
- Presentation layer
This layer is responsible for handling HTTP requests, returning HTTP responses, and rendering the user interface. It manages the interaction with the client and often includes controllers.
```
@RestController
@RequestMapping("/api")
public class UserController {
    
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        // Call to Service Layer
    }
}
```
- Service layer
This layer contains the business logic of the application. It processes input from the Presentation Layer, performs necessary calculations or transformations, and coordinates activities across various components of the application.
```
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
```
- Data Access layer
This layer is responsible for interacting with the database. It performs CRUD (Create, Read, Update, Delete) operations and abstracts the data access details from the Service Layer.
```
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
```
- Model Layer
This layer contains the domain entities and models that are used throughout the application. These are the objects that are persisted to and retrieved from the database.
```
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;

    // getters and setters
}
```

### 5. Describe the flow in all of the layers if an API is called by Postman.
- The request is received by the DispatcherServlet, the front controller in Spring MVC.
- The DispatcherServlet routes the request to the appropriate controller based on the URL mapping.
- The controller method calls a method in the Service Layer to perform business logic.
- The service method processes the input (e.g., fetches user details, applies business rules).
- The service method interacts with the Repository Layer to fetch or modify data.
- The repository interfaces with the database to perform the necessary operations (e.g., query the user by ID).
- The repository retrieves data from the database and returns it as an entity object. The entity object is passed back through the layers to the service method.
- The service method receives the entity object and may perform additional processing. The processed data is returned to the controller.
- The controller prepares the HTTP response, typically wrapping the data in a ResponseEntity.
- The DispatcherServlet sends the HTTP response back to Postman.

### 6. What is the application.properties? do you know application.yml?
Both application.properties and application.yml are configuration files used in Spring Boot to externalize configuration.
application.properties uses a key-value pair format, where each configuration property is specified on a new line. Commonly used for straightforward, simple configurations, like database configuration.
application.yml uses YAML (YAML Ain’t Markup Language) format, which is more hierarchical and can represent nested properties in a cleaner way. Preferred for more complex configurations where nested properties are involved.

## Postman

### GET
### 1. JSON Response:
GET https://jsonplaceholder.typicode.com/posts/1
```
{
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
}
```

### 2. XML Response:
GET https://www.w3schools.com/xml/note.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<note>
    <to>Tove</to>
    <from>Jani</from>
    <heading>Reminder</heading>
    <body>Don't forget me this weekend!</body>
</note>
```

### 3. Image Response
GET https://dog.ceo/api/breeds/image/random
```
{
    "message": "https://images.dog.ceo/breeds/spitz-japanese/beet-005.jpg",
    "status": "success"
}
```

### 4. HTTP Response
GET https://chatgpt.com/
html page

### 5. Plain Text
GET http://numbersapi.com/27
```
27 is the current number of Amendments to the United States Constitution (2012 February).
```

### 404 - Not Found

```
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Error</title>
</head>

<body>
    <pre>Cannot GET /ab3q</pre>
</body>

</html>
```

### 401 - Unauthorized

```
{
    "cod": 401,
    "message": "Invalid API key. Please see https://openweathermap.org/faq#error401 for more info."
}
```

### 500 Internal Server Error

something unexpected went wrong on the server's end and it couldn't fulfill the request from the client. This error typically occurs due to server-side issues rather than client-side problems. 

