## 2.  what is selenium?
Selenium is a suite of tools designed for automating web browsers, primarily used for testing web applications. It enables developers and testers to create automated tests that simulate user interactions with a web application to ensure it functions correctly across different browsers and environments.

- Selenium is an open-source suite of tools and libraries that automates the testing of websites and web applications
- offering many tools and libraries to automate web browser interactions.
- mimic how users interact with browsers, and a server to manage brower usage accross different platforms
## 3.  what is cucumber?
- BDD (behavior driven development)
- It allows you to write test cases in plain language, which makes them easy to understand for non-technical stakeholders while still being executable by the testing framework.
   ```
   one example:
   Feature: Login functionality
   
     Scenario: Successful login with valid credentials
     Given the user is on the login page
     When the user enters valid credentials
     Then the user should be redirected to the homepage
## 4.  what is JMeter?
- JMeter is a powerful and widely-used open-source tool designed for performance testing and load testing of web applications.
- It allows developers and testers to simulate a heavy load on a server, network, or object to test its strength or analyze overall performance under different load types.
## 5.  What is the lifecircle of Junit?
- @BeforeAll
    - execute once before all tests in the test class
- @BeforeEach
    - executed before each test method
- @Test
    - actual test methods that contain the test logic
- @AfterEach
    - executed after each test method
- @AfterAll
    - executed once after all tests in the test class.
## 6.  Is @BeforeAll method should be Class level(static)?
- yes,  @BeforeAll methods must have a void return type and must be static by default
## 7.  What is Mockito? and what is its limitations?  what kind of tools can give help?
- Mockito
    - Mockito is a popular open-source Java framework used for creating mock objects in unit tests.
    - Mockito simplifies the process of creating mocks, stubs, and verifying interactions, making it easier to test code in isolation

- limitations
    - Cannot Mock Final Classes/Methods
    - Limited Static Method Mocking
    - No Mocking of Constructors:
    - Reflection Overhead:
    - Complex Interactions:

- tools can help
    - PowerMock
        - Extends Mockito to support mocking of static methods, constructors, and final methods/classes.
## 8.  What is @Mock and what is @InjectMocks?
- The @Mock  is used to create and inject mock instances for the annotated fields.
- The @InjectMocks is Used to create an instance of the class under test and automatically inject all available mocks (@Mock) into it
## 9.  What is the stubbing (define behaviors)?
- refers to the process of defining the behavior of a mock object when specific methods are called.
- when(...).thenReturn(...)
- when(...).thenThrow(...)
## 10.  what is Mockito ArgumentMatchers
- is a class provides a set of methods to define flexible and complex argument matching rules for mocked method calls.
  - any()
  - antString(), anyInt()
  - eq(T value)
  - isA(Class<T> type)
  - argThat(ArgumentMatcher<T> matcher)
  - isNull() and notNull()
## 11.  what is Hamcrest Matchers
- Hamcrest is a framework for writing matcher objects, allowing 'match' rules to be defined declaratively.
- Readable Assertions
  - assertThat(actualValue, is(expectedValue));
- Flexible Matchers
  - assertThat(actualList, hasSize(3));
  - assertThat(actualString, containsString("expected substring"));
- Composability
  - assertThat(actualValue, allOf(greaterThan(5), lessThan(10)));
## 12.  do you know @spy? what is difference between @spy and @Mock?
- @Spy is used to create a spy object, which is a partial mock of a real object. 
- @Mock, which creates a completely mock object with no real behavior
## 13.  What is assertion?
- an assertion is a statement or check that verifies whether a certain condition is true at a specific point during the execution of a test.
  - Equality Assertions
  - Inequality Assertions
  - Null Assertions
  - True/False Assertions
  - Collection Assertions
  - Exception Assertions
## 14.  If you have developed a new feature, how many types of tests for this feature? and what kind of tests are written by you? what is the purpose of each type of tests?
- Write Unit testcase : verify the correctness of individual units of code
- Integration test: verify that different components or systems work together correctly.
## 15.  Add unit test for CommentServiceImpl, the coverage should be 100%.
## 16.  write Integration tests for PostController. The tests should cover all scenarios.