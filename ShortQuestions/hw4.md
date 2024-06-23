# MingHao Lee Hw4

## 1. What is generic in Java? and type the following generic tutorial code by yourself.
### [Generic Tutorial Code](https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t01_basic/generic)

## 2. Read the following code repo and type it one by one by yourself.
### [Java 8 Features Code Repo](https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/features)

## 3. Practice following stream API exercises at least 3 times
### [Stream API Exercises](https://github.com/gavinklfong/stream-api-exercises/blob/main/src/test/java/space/gavinklfong/demo/streamapi/StreamApiTest.java)

## 4. Practice Optional methods at least 2 times
### [Optional Methods Exercises](https://github.com/CTYue/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/exercise/ShoppingCartUtil.java)

## 5. Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.
### Best Practices to Prevent NullPointerException

1. **Use of Optional (Java 8)**
- `Optional` is a container object which may or may not contain a non-null value. It helps to avoid null checks and 
   NullPointerExceptions.

   ```java
   Optional<String> optionalString = Optional.ofNullable(getString());
   optionalString.ifPresent(s -> System.out.println(s.toUpperCase()));
   ```
2. **Check for Null Before Accessing**
- Explicitly check for null before accessing an object.

  ```java
  if (someObject != null) {
    someObject.doSomething();
  }
  ```
   
## 6. Discuss Java 8 new features with code snippet.
**Lambda Expressions**
- Lambda expressions are a way to provide a clear and concise syntax for writing anonymous methods.
  ```Java
  List<String> names = Arrays.asList("John", "Jane", "Jack");
  names.forEach(name -> System.out.println(name));

  ```
**Stream API**
- The Stream API allows for processing sequences of elements in a functional style.
  ```Java
  List<String> strings = Arrays.asList("one", "two", "three", "four");
  List<String> filtered = strings.stream()
                               .filter(s -> s.startsWith("t"))
                               .collect(Collectors.toList());
  filtered.forEach(System.out::println); // prints "two" and "three"

  ```
**Optional Class**
- Optional is a container object which may or may not contain a non-null value.

  ```Java
  Optional<String> optional = Optional.of("Hello");
  optional.ifPresent(System.out::println); // prints "Hello"
  
  ```
**Default Methods**
- Default methods allow interfaces to have methods with implementation.
  ```Java
    interface MyInterface {
      default void defaultMethod() {
          System.out.println("Default Method");
      }
  }
  
  class MyClass implements MyInterface {}
  
  MyClass myClass = new MyClass();
  myClass.defaultMethod(); // prints "Default Method"

  ```

  


## 7. What are the advantages of the Optional class?
- Optionals are a better way to handle a situation where a method like this might not have a value to return.
  When should I need using optional: optionals were only intended to be used as a return type.


## 8. Explain Functional Interface and Lambda with code samples.
**Functional Interface**
- A functional interface in Java is an interface that contains exactly one abstract method. These interfaces can have any number of default or static methods, but they must have only one abstract method. Functional interfaces can be used as the assignment target for lambda expressions or method references, providing a clear and concise way to represent single-method interfaces.
- code example please refer to the `codingFile -> JavaNewFeature -> TaskAction`

**Lambda Expressions**
- Lambda expressions are a concise way to represent anonymous functions (i.e., methods without a name). They provide a way to create inline implementations of functional interfaces.
  **Syntax:**
  - A comma-separated list of parameters enclosed in parentheses.
  - The -> symbol.
  - A body, which can be either a single expression or a block of statements.

- code example please refer to the `codingFile -> JavaNewFeature -> TaskManager`

## 9. Explain Method Reference with code samples?
**Explanation:**
- Method references are a shorthand notation of a lambda expression to call a method. They are often used to make the code more readable and concise. A method reference can be used in place of a lambda expression when the method to be called already exists.

**Types of Method References:**

- Reference to a Static Method:
  Syntax: `ClassName::staticMethodName`

- Reference to an Instance Method of a Particular Object:
  Syntax: `instance::instanceMethodName`

- Reference to an Instance Method of an Arbitrary Object of a Particular Type:
  Syntax: `ClassName::instanceMethodName`

- Reference to a Constructor:
  Syntax: `ClassName::new`

**Static Method Reference**
  ```Java
  public class MethodReferenceExample {
      public static void main(String[] args) {
          List<String> list = Arrays.asList("a", "b", "c");
  
          // Using lambda expression
          list.forEach(s -> MethodReferenceExample.printUpperCase(s));
  
          // Using method reference
          list.forEach(MethodReferenceExample::printUpperCase);
      }
  
      public static void printUpperCase(String s) {
          System.out.println(s.toUpperCase());
      }
  }
  
  ```
 **Instance Method Reference of a Particular Object**
   ```Java
   import java.util.Arrays;
   import java.util.List;
   
   public class MethodReferenceExample {
       public static void main(String[] args) {
           List<String> list = Arrays.asList("a", "b", "c");
           MethodReferenceExample example = new MethodReferenceExample();
   
           // Using lambda expression
           list.forEach(s -> example.printLowerCase(s));
   
           // Using method reference
           list.forEach(example::printLowerCase);
       }
   
       public void printLowerCase(String s) {
           System.out.println(s.toLowerCase());
       }
   }

   ```

**Instance Method Reference of an Arbitrary Object of a Particular Type:**

   ```Java
   import java.util.Arrays;
   import java.util.List;
   
   public class MethodReferenceExample {
       public static void main(String[] args) {
           List<String> list = Arrays.asList("a", "b", "c");
   
           // Using lambda expression
           list.forEach(s -> System.out.println(s));
   
           // Using method reference
           list.forEach(System.out::println);
       }
   }
   
   ```

**Constructor Reference**
   ```Java
   import java.util.Arrays;
   import java.util.List;
   import java.util.function.Function;
   
   public class MethodReferenceExample {
       public static void main(String[] args) {
           List<String> list = Arrays.asList("a", "b", "c");
   
           // Using lambda expression
           Function<String, MethodReferenceExample> func1 = s -> new MethodReferenceExample(s);
   
           // Using constructor reference
           Function<String, MethodReferenceExample> func2 = MethodReferenceExample::new;
   
           list.forEach(s -> func2.apply(s).printMessage());
       }
   
       private String message;
   
       public MethodReferenceExample(String message) {
           this.message = message;
       }
   
       public void printMessage() {
           System.out.println(message);
       }
   }
   ```


  

## 10. Explain "Lambda can use unchanged variable outside of lambda", with code snippet.
**Explanation**
- In Java, lambda expressions can capture and use variables defined in the enclosing scope. However, these variables must be effectively final, meaning they cannot be modified after they are assigned.

**Using Unchanged Variables**
   ```Java
   public class LambdaScopeExample {
       public static void main(String[] args) {
           String prefix = "Hello, ";
   
           // Using lambda expression
           GreetService greetService = message -> System.out.println(prefix + message);
   
           // This works because 'prefix' is effectively final
           greetService.sayMessage("World!");
   
           // Uncommenting the following line will cause a compilation error
           // prefix = "Hi, ";
   
           greetService.sayMessage("Java!");
       }
   
       interface GreetService {
           void sayMessage(String message);
       }
   }
   
   ```
- In the example above, the variable prefix is defined in the enclosing scope of the lambda expression.
- The lambda expression captures the prefix variable and uses it in the sayMessage method.
- The variable prefix is effectively final because it is not modified after it is assigned.
- If you try to change the value of prefix after the lambda expression is defined, it will result in a compilation error.




## 11. Can a functional interface extend/inherit another interface?
- Yes, a functional interface can extend another interface. When a functional interface extends another interface, it still must have only one abstract method to be a valid functional interface. If the superinterface is a functional interface with one abstract method, the extending interface can also be considered a functional interface, provided it does not add any new abstract methods.

## 12. What are Intermediate and Terminal operations?
**Intermediate Operations**
- Intermediate operations return a new stream and are lazy, meaning they don't execute until a terminal operation is invoked.

**Terminal Operations**
- Terminal operations trigger the execution of the stream pipeline and produce a result or a side-effect.

## 13. Demonstrate the most commonly used Intermediate operations in Stream API, with code snippet.
**Intermediate Operations:**

- filter()
- map()
- mapToDouble()
- collect() (when used with groupingBy and mapping)
- groupingBy()
- mapping()

## 14. How are Collections different from Stream?
**Collections:**
- In-memory data structures.
- Store and manage data.
- External iteration.
- Mutable.
- Finite.

**Streams:**

- Provide a view of data.
- Process data in a functional style.
- Internal iteration.
- Immutable.
- Can be finite or infinite.
- Not reusable.

Collections are suitable for storing and managing data, whereas streams are ideal for processing data in a functional and declarative way. By understanding the differences, you can choose the right tool for your specific use case.
