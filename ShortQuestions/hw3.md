
# Chuwa Hw3 MingHao Lee

## 1. Practice collection
- Refer to the coding folder in collection. 

## 2. What is the checked exception and unchecked exception in Java, could you give one example?
 ### Checked Exceptions
 - Checked exceptions are exceptions that are checked at compile-time. This means that the compiler ensures that the programmer handles these exceptions, either with a 
   try-catch block or by declaring the exception in the method's throws clause. These exceptions typically represent conditions that a reasonable application might want 
   to catch.

```Java   
public class CheckedExceptionExample {
   public static void main(String[] args) {
       try {
           BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
           String line = reader.readLine();
           System.out.println(line);
           reader.close();
       } catch (IOException e) {
           System.out.println("An I/O error occurred: " + e.getMessage());
           }
        }
     }
```
- In this example, IOException is a checked exception. The compiler forces us to handle it by using a try-catch block.

### Checked Exceptions
- Unchecked exceptions are exceptions that are not checked at compile-time. These exceptions are subclasses of RuntimeException. They usually represent programming 
  errors, such as logic errors or improper use of an API.

```Java
public class UncheckedExceptionExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        try {
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds: " + e.getMessage());
        }
    }
}
```




## 3. Can there be multiple finally blocks?
 - No, there cannot be multiple `finally` blocks for a single try block. 

## 4. When both catch and finally return values, what will be the final result?
 - The calue returned by the `finally` block will be the final result.

## 5. What is Runtime/unchecked exception? What is Compile/Checked Exception?
### Runtime/Unchecked Exception

- **Definition:** Unchecked exceptions are exceptions that are not checked at compile-time. They are usually the result of programming errors, such as logic mistakes or improper use of APIs. These exceptions are subclasses of `RuntimeException`.
- **Handling:** The compiler does not require you to handle these exceptions. It is up to the programmer to handle them, usually through proper code logic.
- **Examples:** 
  - `NullPointerException`
  - `ArrayIndexOutOfBoundsException`
  - `IllegalArgumentException`

### Compile/Checked Exception

- **Definition:** Checked exceptions are exceptions that are checked at compile-time. These exceptions represent conditions that a reasonable application might want to catch and handle. They are subclasses of `Exception`, but not RuntimeException.
- **Handling:** The compiler requires that you handle these exceptions. You must catch them with a `try-catch` block or declare them in the method signature using the `throws` keyword.

- **Examples:** 
  - `IOException`
  - `SQLException`
  - `FileNotFoundException`




## 6. What is the difference between throw and throws?
 ### `throw`
 - **Purpose:** Used to explicitly throw an exception from a method or block of code.
 - **Usage:** Creates an instance of an exception and throws it to be caught by an exception handler.
 - **Placement:** Inside a method or block of code.

 ### `throws`
 - **Purpose:** Used in a method signature to declare that a method can throw one or more exceptions.
 - **Usage:** Informs the caller of the method about the exceptions that might be thrown, allowing them to handle those exceptions.
 - **Placement:** In the method signature.


## 7. Run the below three pieces of code, Noticed the printed exceptions. Why do we put the Null/Runtime exception before Exception?

```java
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        String s = null;
        try {
            System.out.println(b / a);
            System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("End ...");
    }
}

```

```Java
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        String s = null;
        try {
            // System.out.println(b / a);
            System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("End ...");
    }
}
```
```Java
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        String s = null;
        try {
            // System.out.println(b / a);
            // System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("End ...");
    }
}
```
 - When handling exceptions in Java, it's important to catch more specific exceptions before the more general ones.(from small to big)
   Here's why in the example code, we catch `NullPointerException` and other 
   `RuntimeException` subclasses before `Exception`


## 8. What is optional? Why do you use it? Write an optional example.
### What is `Optional`?
- `Optional` is a container object used to contain not-null objects. It is part of the `java.util` package and was introduced in Java 8. The main idea of `Optional` is to provide a way to handle `null` values explicitly and to avoid `NullPointerException`.

### Why do you use it?
- **Avoid NullPointerException:** `Optional` helps in reducing the number of `NullPointerException` by providing a container that can either contain a value or be empty.
- **Express Intent:** It explicitly indicates that a value might be absent, making the code more readable and showing the developer's intent.
- **Functional Style Operations:** It allows for more functional-style operations, making the code concise and expressive.


```java
import java.util.Optional;

public class SimpleOptionalExample {
    public static void main(String[] args) {
        // Creating an Optional object that contains a non-null value
        Optional<String> nonEmptyOptional = Optional.of("Hello, World!");

        // Creating an Optional object that might be null
        Optional<String> emptyOptional = Optional.ofNullable(null);

        // Using orElse to provide a default value if the Optional is empty
        String message = nonEmptyOptional.orElse("Default Message");
        System.out.println(message); // Prints: Hello, World!

        String emptyMessage = emptyOptional.orElse("Default Message");
        System.out.println(emptyMessage); // Prints: Default Message
    }
}
```

## 9. Why finally always be executed?
### Explanation

- The `finally` block in Java is used to execute important code such as closing resources, cleaning up, or releasing locks. The code inside the `finally` block is always executed, regardless of whether an exception is thrown or caught. This ensures that the necessary cleanup code runs, providing a way to guarantee that certain actions are performed no matter what.

### Reasons why `finally` is always executed:

-  **Guaranteed Execution:** The `finally` block is designed to ensure that crucial cleanup code runs even if an exception occurs or if a return statement is 
   encountered in the `try` or `catch` blocks.
-  **Resource Management:** It's often used for closing resources like files, network connections, or database connections to prevent resource leaks.
-  **Code Reliability:** By ensuring that the `finally` block executes, Java increases the reliability of the code by making sure that important cleanup tasks are 
   performed.


## 10. Practice collection problems here: 
 - ## Refer to the coding folder in design. 
https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection


## 11. What are the types of design patterns in Java?
## Types of Design Patterns in Java

Design patterns are typical solutions to common problems in software design. They represent best practices used by experienced object-oriented software developers. Design patterns can be categorized into three main types: creational, structural, and behavioral.

### 1. Creational Design Patterns
Creational design patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation.

- **Singleton:** Ensures a class has only one instance and provides a global point of access to it.
- **Factory Method:** Defines an interface for creating an object but allows subclasses to alter the type of objects that will be created.
- **Abstract Factory:** Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
- **Builder:** Separates the construction of a complex object from its representation, allowing the same construction process to create different representations.
- **Prototype:** Creates new objects by copying existing ones, known as prototypes.

### 2. Structural Design Patterns
Structural design patterns deal with object composition or the way to assemble objects to create new functionality.

- **Adapter:** Allows incompatible interfaces to work together.
- **Bridge:** Separates an object’s abstraction from its implementation so that the two can vary independently.
- **Composite:** Composes objects into tree structures to represent part-whole hierarchies.
- **Decorator:** Adds additional responsibilities to an object dynamically.
- **Facade:** Provides a simplified interface to a complex subsystem.
- **Flyweight:** Reduces the cost of creating and manipulating a large number of similar objects.
- **Proxy:** Provides a surrogate or placeholder for another object to control access to it.

### 3. Behavioral Design Patterns
Behavioral design patterns are concerned with algorithms and the assignment of responsibilities between objects.

- **Chain of Responsibility:** Passes a request along a chain of handlers until one of them handles it.
- **Command:** Encapsulates a request as an object, thereby allowing for parameterization of clients with queues, requests, and operations.
- **Interpreter:** Provides a way to evaluate language grammar or expression.
- **Iterator:** Provides a way to access elements of a collection sequentially without exposing its underlying representation.
- **Mediator:** Defines an object that encapsulates how a set of objects interact.
- **Memento:** Captures and externalizes an object’s internal state without violating encapsulation, so that the object can be restored to this state later.
- **Observer:** Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
- **State:** Allows an object to alter its behavior when its internal state changes. The object will appear to change its class.
- **Strategy:** Defines a family of algorithms, encapsulates each one, and makes them interchangeable.
- **Template Method:** Defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.
- **Visitor:** Represents an operation to be performed on the elements of an object structure, allowing one to define a new operation without changing the classes of the elements on which it operates.

### Summary

- **Creational Patterns:** Deal with object creation (e.g., Singleton, Factory Method).
- **Structural Patterns:** Deal with object composition (e.g., Adapter, Composite).
- **Behavioral Patterns:** Deal with object collaboration (e.g., Observer, Strategy).

Design patterns are essential for building robust, maintainable, and scalable software systems. Understanding these patterns helps in writing better object-oriented code and improving software design.


## 12. What are the SOLID Principles?
- ### 1. Single Responsibility Principle (SRP)
 - **Definition:** A class should have only one reason to change, meaning it should have only one job or responsibility.
 - **Explanation:** Each class should focus on a single responsibility. If a class has more than one responsibility, those responsibilities become coupled, and changes 
     to one responsibility may impact the other.
 - **Example:** Separating data access logic and business logic into different classes.

- ### 2. Open/Closed Principle (OCP)
 - **Definition:** Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
 - **Explanation:** You should be able to add new functionality to a class without changing its existing code. This can be achieved through abstraction and polymorphism.
 - **Example:** Using interfaces or abstract classes to allow the addition of new implementations.

- ### 3. Liskov Substitution Principle (LSP)
 - **Definition:** Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.
 - **Explanation:** Subclasses should override the superclass methods in a way that does not break the functionality of the parent class.
 - **Example:** Ensuring that subclasses of a base class implement methods in a way that they can be used interchangeably without causing errors.

- ### 4. Interface Segregation Principle (ISP)
 - **Definition:** A client should not be forced to depend on methods it does not use.
 - **Explanation:** Rather than having a single large interface, create smaller, more specific interfaces so that clients only need to know about the methods that are 
     of interest to them.
 - **Example:** Splitting a large interface into several smaller, more specific interfaces.

- ### 5. Dependency Inversion Principle (DIP)
 - **Definition:** High-level modules should not depend on low-level modules. Both should depend on abstractions (e.g., interfaces).
 - **Explanation:** This principle suggests that you should depend upon abstractions rather than concrete implementations. This makes the code more flexible and easier 
     to maintain.
 - **Example:** Using dependency injection to inject dependencies into a class.

## 13. How can you achieve thread-safe singleton patterns in Java?
- ## Achieving Thread-Safe Singleton Patterns in Java

  - Achieving a thread-safe Singleton pattern in Java ensures that the Singleton instance is created only once, even when multiple threads try to access it 
    simultaneously. Here are a few ways to achieve this:

- ### 1. Eager Initialization

  - **Explanation:** The instance is created at the time of class loading. This method is thread-safe because the instance is created before any thread accesses it.

```java
public class Singleton {
    private static final Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }
}
```

- ### 2. Lazy Initialization with Synchronized Method

  - **Explanation:** The instance is created only when it is needed, but the method is synchronized to ensure thread safety.

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```



## 14. What do you understand by the Open-Closed Principle (OCP)?
 - The Open-Closed Principle (OCP) is one of the five SOLID principles of object-oriented design and programming. The principle states that:

 - "Software entities (such as classes, modules, and functions) should be open for extension, but closed for modification."

 - This means that the behavior of a module can be extended without modifying its source code. Here’s a more detailed explanation:

 - Open for Extension
   - The module or class should allow its behavior to be extended. This can be done by adding new functionality.
   - For instance, you can extend the behavior of a class by inheriting from it and overriding or adding new methods.
- Closed for Modification
   - Once a module or class has been developed and tested, it should not be modified. This helps prevent bugs from being introduced into existing, working code.
   - To avoid modifying the existing code, new features or behaviors should be added through extension mechanisms like inheritance, interfaces, or using design patterns 
     such as the Strategy or Decorator patterns.


## 15. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

  - It means that if the object of type A can do something, the object of type B could also be able to perform the same thing.

  - It means that all the objects of type A could execute all the methods present in its subtype B.

  - It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.

  - It means that for the class B to inherit class A, objects of type B and objects of type A must be same.

  - Answer:
    - It means that if the object of type A can do something, the object of type B could also be able to perform the same thing.
     - This option correctly captures the essence of LSP, which ensures that an object of a derived class (B) can replace an object of its base class (A) without 
       affecting the functionality expected from the base class.
## 16. Watch the design pattern video, and type the code, submit it to MavenProject folder:
- ## Refer to the coding folder in design. 
  - Singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
  - Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6d9
  - Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6d9
  - Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f7accf859bf7f6d9

