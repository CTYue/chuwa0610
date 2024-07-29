## Spring Framework Annotations
- @Configuration: Indicates that the class can be used by the Spring IoC container as a source of bean definitions.

- @Bean: Indicates that a method produces a bean to be managed by the Spring container.

- @Component: Indicates that an annotated class is a "component". Such classes are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.

- @Controller: Specialization of @Component for presentation layer.

- @RestController: A convenience annotation that combines @Controller and @ResponseBody.

- @Service: Indicates that an annotated class is a "Service".

- @Repository: Indicates that an annotated class is a "Repository".

- @Autowired: Marks a constructor, field, setter method, or config method to be autowired by Spring's dependency injection facilities.

- @Value: Used to inject values into fields.

- @PropertySource: Provides a convenient and declarative mechanism for adding a PropertySource to Spring's Environment.

- @Qualifier: Indicates a specific bean to be autowired when there are multiple candidates.

- @Primary: Indicates that a bean should be given preference when multiple beans are candidates.

## Spring Boot Annotations
- @SpringBootApplication: A convenience annotation that adds all of the following:

- @Configuration
- @EnableAutoConfiguration
- @ComponentScan
- @EnableAutoConfiguration: Enables Spring Boot’s auto-configuration mechanism.
- 
- @ComponentScan: Configures component scanning directives for use with @Configuration classes.

## Spring Boot Actuator Annotations
- @Endpoint: Used to create custom actuator endpoints.

- @ReadOperation: Marks a method as a read operation for a custom endpoint.

- @WriteOperation: Marks a method as a write operation for a custom endpoint.

- @DeleteOperation: Marks a method as a delete operation for a custom endpoint.

## Spring Validation Annotations
- @Valid: Marks a field or method parameter to be validated.

- @NotNull: The annotated element must not be null.

- @NotEmpty: The annotated element must not be null or empty.

- @NotBlank: The annotated element must not be null and must contain at least one non-whitespace character.

- @Size: The size of the annotated element must be within the specified bounds.

- @Min: The annotated element must be a number whose value is greater than or equal to the specified minimum.

- @Max: The annotated element must be a number whose value is less than or equal to the specified maximum.

- @Email: The annotated element must be a valid email address.

- @Pattern: The annotated element must match the specified regular expression.

- @Past: The annotated element must be a date in the past.

- @Future: The annotated element must be a date in the future.