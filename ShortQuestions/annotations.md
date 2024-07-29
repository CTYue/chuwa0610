## Core Spring
@Bean -Annotated method produces a bean managed by the Spring IoC container
Stereotype annotations
@Component - Marks annotated class as a bean found by the component-scanning and loaded into the application context
@Controller - Marks annotated class as a bean for Spring MVC containing request handler
@RestController - Marks annotated class as a @Controller bean and adds @ResponseBody to serialize returned results as messages
@Configuration - Marks annotated class as a Java configuration defining beans
@Service - Marks annotated class as a bean (as convention usually containing business logic)
@Repository - Marks annotated class as a bean (as convention usually providing data access) and adds auto-translation from SQLException to DataAccessExceptions
### Spring Boot
@SpringBootConfiguration - Indicates Spring Boot application @Configuration
@EnableAutoConfiguration - Enables application context auto-configuration to provide possibly needed beans based on the classpath
@ConfigurationProperties - Provides external binding of key value properties
@ConstructorBinding - Bind properties by using constructor rather than setters
@ConfigurationPropertiesScan - Enables auto-detection of @ConfigurationProperties classes
@SpringBootApplication - Combination of @SpringBootConfiguration, @EnableAutoConfiguration, @ConfigurationPropertiesScan and @ComponentScan
@EntityScan - Configures base packages to scan for entity classes
@EnableJpaRepositories - Enables auto-configuration of jpa repositories
### Bean state
@PostConstruct - Annotated method is executed after dependency injection is done to perform initialization
@PreDestroy - Annotated method is executed before the bean is destroyed, e.g. on the shutdown
### Configuration
@Import - Imports one or more Java configuration classes @Configuration
@PropertySource - Indicates the location of applicaiton.properties file to add key-value pairs to Spring Environment
@Value - Annotated fields and parameters values will be injected
@ComponentScan - Configures component scanning @Compenent, @Service, etc.
### Bean properties
@Lazy - Annotated bean will be lazily initialized on the first usage
@Profile - Indicates that beans will be only initialized if the defined profiles are active
@Scope - Defines bean creation scope, e.g. prototype, singleton, etc.
@DependsOn - Explicitly defines a dependency to other beans in terms of creation order
@Order - Defines sorting order if injecting a list of beans, but it does not resolve the priority if only a single bean is expected
@Primary - Annotated bean will be picked if multiple beans can be autowired
@Conditional - Annotated bean is created only if conditions are satisfied
### Additionally available in Spring Boot:
@ConditionalOnBean
@ConditionalOnMissingBean
@ConditionalOnClass
@ConditionalOnMissingClass
@ConditionalOnProperty
@ConditionalOnMissingProperty
### Bean injection
@Autowired - Beans are injected into annotated setters, fields, or constructor params.
@Qualifier - Specifies the name of a bean as an additional condition to identify a unique candidate for autowiring
### Validation
@Valid - Mark a property, method parameters or return type for validation
@Validated - Variant of @Valid that allows validation of multiple groups, e.g. all fields of an annotated class
@NotNull - Must be not null
@NotEmpty - Must be not null nor empty
@NotBlank - Must be not null and at least one non-whitespace character
@Digits - Must be a number within accepted range
@Past - Must be an instant, date or time in the past
@Future - Must be an instant, date or time in the future
...
### Spring Boot Tests
@SpringBootTest - Annotated test class will load the entire application context for integration tests
@WebMvcTest - Annotated test class will load only the web layer (service and data layer are ignored)
@DataJpaTest - Annotated class will load only the JPA components
@JsonTest - Annotated class will load only json mapper for serialization and deserialization ### tests
@MockBean - Marks annotated field as a mock and loads it as a bean into the application context
@SpyBean - Allows partial mocking of beans
@Mock - Defines annotated field as a mock
### Spring Test
@ContextConfiguration - Defines @Configuration to load application context for integration test
@ExtendWith - Defines extensions to execute the tests with, e.g. MockitoExtension
@SpringJUnitConfig - Combines @ContextConfiguration and @ExtendWith(SpringExtension.class)
@TestPropertySource - Defines the location of property files used in integration tests
@DirtiesContext - Indicates that annotated tests dirty the application context and will be cleaned after each test
@ActiveProfiles - Defines which active bean definition should be loaded when initializing the test application context
@Sql - Allows defining SQL scripts and statements to be executed before and after tests
### Transactions
@EnableTransactionManagement - Enables annotation-driven transaction declaration @Transactional
@Transactional - Annotated methods will be executed in a transactional manner
### Spring JPA and Hibernate
@Id - Marks annotated field as a primary key of an entity
@GeneratedValue - Provides generation strategy of primary keys
@Entity - Marks annotated class as an entity
@Column - Provides additional configuration for a field, e.g. column name
@Table - Provides additional configuration for an entity, e.g. table name
@PersistenceContext - EntityManger is injected into annotated setters and fields
@Embedded - Annotated field is instantiated as a value of an Embeddable class
@Embeddable - Instances of an annotated class are stored as part of an entity
@EmbeddedId - Marks annotated property as a composite key mapped by an embeddable class
@AttributeOverride - Overrides the default mapping of a field
@Transient - Annotated field is not persistent
@CreationTimestamp - Annotated field contains the timestamp when an entity was stored for the first time
@UpdateTimestamp - Annotated field contains the timestamp when an entity was updated last time
@ManyToOne - Indicates N:1 relationship, the entity containing annotated field has a single relation to an entity of other class, but the other class has multiple relations
@JoinColumn - Indicates a column for joining entities in @ManyToOne or @OneToOne relationships at the owning side or unidirectional @OneToMany
@OneToOne - Indicates 1:1 relationship
@MapsId - References joining columns of owning side of @ManyToOne or @OneToOne relationships to be the primary key of referencing and referenced entities
@ManyToMany - Indicates N:M relationship
@JoinTable - Specifies an association using a join table
@BatchSize - Defines size to lazy load a collection of annotated entities
@FetchMode - Defines fetching strategy for an association, e.g. loading all entities in a single subquery
### Spring Security
@EnableWebSecurity - Enables web security
@EnableGlobalMethodSecurity - Enables method security
@PreAuthorize - Defines access-control expression using SpEL, which is evaluated before invoking a protected method
@PostAuthorize - Defines access-control expression using SpEL, which is evaluated after invoking a protected method
@RolesAllowed - Specifies a list of security roles allowed to invoke protected method
@Secured - Java 5 annotation for defining method level security
### Spring AOP
@EnableAspectJAutoProxy - Enables support for handling components marked with @Aspect
@Aspect - Declares an annotated component as an aspect containing pointcuts and advices
@Before - Declares a pointcut executed before the call is propagated to the join point
@AfterReturning - Declares a pointcut executed if the join point successfully returns a result
@AfterThrowing - Declares a pointcut executed if the join point throws an exception
@After - Declares a pointcut executed if the join point successfully returns a result or throws an exception
@Around - Declares a pointcut executed before the call giving control over the execution of the join point to the advice
@Pointcut - Externalized definition a pointcut expression