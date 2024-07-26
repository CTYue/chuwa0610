

## HW 47 - Testing / HW 16



### 1. List all of the new learned annotations to your annotations.md 

### 2. what is selenium? 

- Selenium is **an open-source, automated testing tool used to test **web applications across various browsers.
- Selenium can **only test web applications**, unfortunately, so desktop and mobile apps can't be tested. 
- It supports **multiple browsers** (such as Chrome, Firefox, Safari, and Edge) and **various programming languages** (including Java, C#, Python, Ruby, and JavaScript).



### 3. what is cucumber? 

- Cucumber is **a Behavior Driven Development tool **used to develop test cases for the behavior of software's functionality.

- It allows you to write tests in a natural, human-readable, plain language called Gherkin, which is designed to be easily understood by **non-programmers**. 



### 4. what is JMeter? 

- The Apache JMeter is an open-source, purely Java-based software designed for **load testing and performance measurement.**
- It allows users to simulate various scenarios and measure the performance of the target application under different loads and conditions.



### 5. What is the lifecircle of Junit? 

There is 4 major life cycle of Junit 5 is **@BeforeAll, @BeforeEach, @AfterEach and @AfterAll**.

- `@BeforeAll`:  executed once **before all** tests in the test class. used to **set up any shared resources** needed by all tests.
- `@BeforeEach`: executed before each individual test method. These methods are used to **initialize the state required for each test.**
-  `@Test`:  the actual test methods. Each test method runs **independently** of others and should not depend on the state of other test methods.
- `@AfterEach`: executed after each test method. These methods are used to **clean up any resources initialized in `@BeforeEach`.**
- `@AfterAll`: executed once after all tests in the test class have run. These methods are used to **clean up any shared resources** set up in `@BeforeAll`.



### 6. Is @BeforeAll method should be Class level(static)? 

Yes.

Both `@BeforeAll`  and `@AfterAll`method should be **class-level (static)**. The reason is that `@BeforeAll` and `@AfterAll`methods are **executed once before and after the test execution**  in the test class, Both of them shoud be avaliable to all the tests. Making them static **ensures they can be run without needing an instance** of the test class.



### 7. What is Mockito? and what is its limitations? what kind of tools can give help? 

#### What is Mockito? 

**Mockito** is a popular mocking framework for Java used in unit testing. 

It allows you to **create mock objects and define their behaviors** for testing purposes.

 This is especially useful for isolating the component being tested from its dependencies, ensuring that tests are focused on the component's behavior and not influenced by external factors.

#### and what is its limitations? 

- Mockito cannot mock **final** classes or methods
- Mockito cannot mock **static** methods.
- Mockito cannot directly mock **private** methods.
- Mockito does not support mocking **constructors**.
- Mockito is designed for unit testing and might **not be suitable for integration testing**.

#### what kind of tools can give help? 

**PowerMock**: A framework that extends Mockito's capabilities. It can mock static methods, final classes, private methods, constructors and more.

```java
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ClassWithStaticMethod.class)
public class PowerMockTest {

    @Test
    void testStaticMethod() {
        mockStatic(ClassWithStaticMethod.class);
        when(ClassWithStaticMethod.staticMethod()).thenReturn("Mocked");

        String result = ClassWithStaticMethod.staticMethod();

        assertEquals("Mocked", result);
    }
}
	
```

**JUnit**: Always used with Mockito, provides the framework and annotations needed to define and run test cases, executes the tests and manages test lifecycle.

**Reflection**: For private methods, reflection can be used to invoke private methods during tests. 

**Spring Test**: Provides comprehensive testing support for Spring applications, suitable for **integration and end-to-end testing.**

**AssertJ**: Provides a rich and fluent set of assertions for more readable and powerful assertions in tests.





### 8. What is @Mock and what is @InjectMocks? 

#### `@Mock`

- **Purpose**: **Creates and initializes** mock objects.
- **Usage**: Annotate a field with `@Mock` to create a mock instance of a class or interface.

#### `@InjectMocks`

- **Purpose**: **Injects** the mock objects into the class being tested.
- **Usage**: Annotate a field with `@InjectMocks` to automatically inject mocks (created with `@Mock`) into the class under test.

```java
@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
		// creates a mock of OrderRepository,
    @Mock
    private OrderRepository orderRepository;
		// injects the above mock into the OrderService instance.
    @InjectMocks
    private OrderService orderService;

    @Test
    public void testProcessOrder() {
        Order order = new Order();
        when(orderRepository.save(order)).thenReturn(order);

        Order result = orderService.processOrder(order);

        assertEquals(order, result);
        verify(orderRepository).save(order);
    }
}

```



### 9. What is the stubbing (define behaviors)? 

Stubbing, or defining behaviors, in Mockito refers to **the process of specifying what a mock object should do** when certain methods are called on it.

#### How Stubbing Works

1. **Define Behavior**: You use `when()` to specify what should happen when a particular method on the mock is called.
2. **Return Values**: You specify what value should be returned by the mocked method using `thenReturn()`.
3. **Verify Interactions**: You can check if the method was called with certain parameters using `verify()`.

#### Example

```java
// Import Mockito static methods
import static org.mockito.Mockito.*;

public class ExampleTest {

    @Test
    public void testStubbing() {
        // Create a mock of the MyService class
        MyService myService = mock(MyService.class);
        
        // Define behavior: when the method getData() is called, return "Mocked Data"
        when(myService.getData()).thenReturn("Mocked Data");
    		// when(myService.getData()).thenThrow("Mocked Data");

        // Use the mock in a test
        String result = myService.getData();
        assertEquals("Mocked Data", result);

        // Verify that the getData() method was called exactly once
        verify(myService).getData();
    }
}
```



### 10. what is Mockito ArgumentMatchers?

`Mockito.ArgumentMatchers` provides static methods used to specify argument conditions for verifying or stubbing method calls on mocks in Mockito. 

#### Common Argument Matchers

1. **`any()`**: Matches any value of a specified type.

   ```java
   when(myService.save(any(Order.class))).thenReturn(order);
   ```

2. **`eq()`**: Matches an **exact value**.

   ```java
   when(myService.getById(eq(1))).thenReturn(order);
   ```

3. **`isNull()`**: Matches **Null** values.

   ```java
   when(myService.save(isNull())).thenReturn(defaultOrder);
   ```

4. **`argThat()`**: Allows you to **define custom argument matchers** using a `Matcher` or a lambda expression.

   ```java
   when(myService.process(argThat(arg -> arg.getAmount() > 100))).thenReturn(result);
   ```

5. **`anyString()`, `anyInt()`, `anyDouble()`**: Specialized matchers for common types.

   ```java
   when(myService.findByName(anyString())).thenReturn(user);
   ```

```java
public class MyServiceTest {

    @Test
    public void testArgumentMatchers() {
        MyService myService = mock(MyService.class);

        // Stub a method with flexible argument matchers
        when(myService.calculate(anyInt(), eq("fixedValue"))).thenReturn(100);

        // Use the mock in a test
        int result = myService.calculate(5, "fixedValue");
        assertEquals(100, result);

        // Verify method calls with argument matchers
        verify(myService).calculate(anyInt(), eq("fixedValue"));
    }
}
```



### 11. what is Hamcrest Matchers 

- A set of **utility classes** used for writing expressive and readable assertions in tests. 
- They are commonly used in conjunction with JUnit and other testing frameworks to provide a more flexible and descriptive way to assert conditions in your tests.

#### Common Hamcrest Matchers

1. **`is()`**: Checks if a value is equal to a specified value.

   ```
   assertThat(result, is(100));
   ```

2. **`equalTo()`**: Checks if a value is equal to another value.

   ```
   assertThat(result, equalTo(100));
   ```

3. **`not()`**: Checks if a value is not equal to a specified value.

   ```
   assertThat(result, not(200));
   ```

4. **`greaterThan()`**: Checks if a value is greater than a specified value.

   ```
   assertThat(result, greaterThan(50));
   ```

5. **`containsString()`**: Checks if a string contains a specified substring.

   ```
   assertThat("Hello, world!", containsString("world"));
   ```

6. **`hasSize()`**: Checks if a collection or array has a specific size.

   ```
   assertThat(list, hasSize(3));
   ```



### 12. do you know @spy? what is difference between @spy and @Mock? 

| @Spy                                                         | @Mock                                                        |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| Creates a spy instance of a class.                           | Creates a mock instance of a class or interface.             |
| **real methods** of the class are called unless explicitly stubbed. | All methods are **mocked with no real behavior**, returning default values unless stubbed. |
| Use when you need to partially mock a class while still using the real implementation for most methods. | Use for complete isolation where you need to control all interactions. |



### 13. What is assertion? 

A statement in testing that **verifies whether a certain condition is true**. 

Assertions are used to validate that the code behaves as expected during tests. If the condition is true, the test passes; if it is false, the test fails, indicating that there may be an issue with the code.

#### Common Assertions in Testing Frameworks

- **JUnit Assertions**:

  - `assertEquals(expected, actual)`: Checks if `expected` equals `actual`.
  - `assertTrue(condition)`: Checks if the condition is true.
  - `assertFalse(condition)`: Checks if the condition is false.
  - `assertNotNull(object)`: Checks if the object is not null.
  - `assertNull(object)`: Checks if the object is null.

- **Example**:

  ```java
  public class CalculatorTest {
  
      @Test
      public void testAddition() {
          int result = add(2, 3);
          assertEquals(5, result);  // Assertion: result should be equal to 5
      }
  
      private int add(int a, int b) {
          return a + b;
      }
  }
  ```



### 14. If you have developed a new feature, how many types of tests for this feature? and what kind of tests are written by you? what is the purpose of each type of tests? 

1. **Unit Tests**: Ensure individual components work correctly.
2. **Integration Tests**: Verify interactions between components.
3. **Functional Tests**: Test end-to-end workflows and user scenarios.
4. **Performance Tests**: Assess performance under load. 
5. **Security Tests**: Check for security vulnerabilities.
6. **User Acceptance Tests(UAT)**: Validate business requirements and user stories.



### 15. Add unit test for CommentServiceImpl, the coverage should be 100%. 

### 16. write Integration tests for PostController. The tests should cover all scenarios.

