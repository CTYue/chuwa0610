
## 2. what is the @configuration and @bean?
```text
@Configuration: Indicates that a class declares one or more `@Bean` methods and can be processed by the Spring container to generate bean definitions and service requests.
@Bean: Used to indicate that a method produces a bean to be managed by the Spring container.
```
## 3. How do you handle the exceptions in Spring? How do you make sure you do NOT expose sensitive information?
- @ExceptionHandler
   - method level: This annotation is placed on methods within a controller to handle specific exceptions that are thrown by the controller's methods. It allows for customized responses for different exceptions.
- @ControllerAdvice
   - class level:  This annotation allows we to define a global exception handler that applies to all controllers. It is used to handle exceptions across the whole application, not just within a single controller.
## Ensuring Sensitive Information is Not Exposed

1. **Custom Error Messages**:

   - Instead of returning detailed error information to the client, return generic error messages. This prevents exposing internal details that could be useful to an attacker.

2. **Log Detailed Errors**:
   - Log detailed error information on the server side for troubleshooting purposes, but only return generic error messages to the client. This keeps sensitive information out of the client-facing responses.

3. **Validation Errors**:
   - When validation fails, ensure that the error messages do not expose internal details. Provide clear but general messages indicating what the validation error is.

4. **Use HTTP Status Codes**:
   - Use appropriate HTTP status codes to indicate the type of error (e.g., 400 for bad request, 401 for unauthorized, 403 for forbidden, 404 for not found, 500 for internal server error). This helps clients understand the nature of the error without exposing sensitive information.
## 4. How do you do validations in Spring? List some validation annotaitons you know. What's the purpose of validation?
### How to Perform Validations

1. **Add Validation Dependencies**:
   - Ensure that your project includes the necessary dependencies for validation, such as Hibernate Validator.

2. **Define Validation Constraints**:
   - Use validation annotations on the fields of your model classes to specify the validation rules.

3. **Enable Validation in Controllers**:
   - Use the `@Valid` annotation on method parameters in your controller methods to trigger the validation.

4. **Handle Validation Errors**:
   - Use the `BindingResult` parameter in your controller methods to handle validation errors and provide feedback to the client.

### Validation Annotations

1. **@NotNull**:
   - Ensures that the annotated field is not null.
2. **@NotEmpty**:
   - Ensures that the annotated field is not null or empty.
3. **@NotBlank**:
   - Ensures that the annotated field is not null, empty, or whitespace.
4. **@Size**:
   - Specifies the minimum and maximum length of a string.
5. **@Min**:
   - Specifies the minimum value of a numeric field.
6. **@Max**:
   - Specifies the maximum value of a numeric field.
7. **@Email**:
   - Ensures that the annotated field is a valid email address.
8. **@Pattern**:
   - Ensures that the annotated field matches a specified regular expression.
9. **@Past**:
   - Ensures that the annotated field is a date in the past.
10. **@Future**:
   - Ensures that the annotated field is a date in the future.
### Purpose of validation
- Ensure data integrity and correctness by validating user input before processing.

## 5. What is the actuator, list some endpoints and payload it provides?
- Provides production-ready features to monitor and manage applications.
    **Endpoints**: `/actuator/health`, `/actuator/info`, `/actuator/metrics`, `/actuator/env`.
    **Payload**: Health status, application info, metrics data, environment properties.

## 6. Apply above annotations to your previous homework projects as possible as you can.
## 7. watch those videos(泛泛地看⼀遍，能理解多少是多少，没有必要看其它视频。)
- 1. Spring 简介： https://www.youtube.com/watch?v=l0MqsOADAUE&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=64
- 2. IOC/DI: https://www.youtube.com/watch?v=PyMxNr2p0C0&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=65
- 3. IOC container: https://www.youtube.com/watch?v=pLa77Tw-yyI&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=66
- 4. Bean:
  - 1. https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=67
  - 2. https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=68
  - 3. https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=69
- 5. DI:
  - 1. https://www.youtube.com/watch?v=MgTpBST9onM&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=70
  - 2. https://www.youtube.com/watch?v=yhEWZx2i1BA&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=71