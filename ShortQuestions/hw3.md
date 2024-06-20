2. What is the checked exception and unchecked exception in Java, could you give one example?
   - Checked exceptions are exceptions that are checked at compile time. The Java compiler requires that you handle these exceptions explicitly, either with a try-catch block or by declaring them in the method signature using the `throws` keyword. Examples: `IOException`, `ClassNotFoundException`, `SQLException`, `FileNotFoundException`.
   - Unchecked exceptions are exceptions that are not checked at compile time. These exceptions do not need to be handled explicitly. They are usually errors made by programmers. Examples: `NullPointerException`, `ArrayIndexOutOfBoundsException`

3. Can there be multiple finally blocks?

   - No. `try` block can be followed by multiple `catch` blocks but at most 1 `finally` block.

4. When both catch and finally return values, what will be the final result?

   - The return value of the `finally` block will be the final result.

5. What is Runtime/unchecked exception? what is Compile/Checked Exception?

   - Same as 2.

6. What is the difference between throw and throws?

   - The `throw` keyword is used to actually throw an exception. It is used within a method to indicate that an exception has occurred.
   - The `throws` keyword is used in a method signature to declare that the method might throw certain exceptions. This informs the caller of the method that it needs to handle these potential exceptions.

7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?

   - First output:

     ```
     java.lang.ArithmeticException: / by zero
     	at Main.main(Main.java:7)
     End ...
     ```

   - Second output:

     ```
     java.lang.NullPointerException
     	at Main.main(Main.java:8)
     End ...
     ```

   - Third output:

     ```
     java.lang.RuntimeException
     	at Main.main(Main.java:9)
     End ...
     ```

   - Reason: 

     - Placing more specific exceptions like `NullPointerException` or `RuntimeException` before the general `Exception` in the catch blocks can give more specific information. If a general exception like `Exception` is placed before specific ones, it will catch all exceptions that are subclasses of `Exception`, preventing any subsequent specific catch blocks from being reached.

8. What is optional? why do you use it? write an optional example.

   - `Optional` is a container object introduced in Java 8. It is used to represent the presence or absence of a value. The `Optional` class is a part of the `java.util` package and is used to avoid `NullPointerException` and to handle values that can be null more gracefully.

   - Reasons:

     - **Avoid NullPointerException:** It provides a more expressive way to handle null values without the risk of encountering a `NullPointerException`.
     - **Readable Code:** It makes the code more readable and helps in understanding the possibility of an absent value.
     - **Functional Style:** It encourages a functional style of programming and better error handling.

   - Example:

     ```java
     Optional<String> optionalString = findName("John");
     
     // Check if value is present
     if (optionalString.isPresent()) {
         System.out.println("Found: " + optionalString.get());
     } else {
         System.out.println("Name not found");
     }
     
     // Using orElse
     String defaultName = optionalString.orElse("Default Name");
     System.out.println("Name: " + defaultName);
     
     // Using orElseGet
     String dynamicDefaultName = optionalString.orElseGet(() -> "Dynamic Default Name");
     System.out.println("Dynamic Name: " + dynamicDefaultName);
     
     // Using ifPresent
     optionalString.ifPresent(name -> System.out.println("Hello " + name));
     ```

9. Why finally always be executed ?

   This is a crucial feature for resource management, ensuring that resources like files, network connections, and database connections are properly closed, even if an error occurs during the execution of a try block.

10. What are the types of design patterns in Java ?

    - **Creational Patterns**
      - **Singleton Pattern:** Ensures that a class has only one instance and provides a global point of access to it.
      - **Factory Method Pattern:** Defines an interface for creating an object but allows subclasses to alter the type of objects that will be created.
      - **Abstract Factory Pattern:** Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
      - **Builder Pattern:** Separates the construction of a complex object from its representation, allowing the same construction process to create different representations.
    - **Structural Patterns**
    - **Behavioral Patterns**

11. What are the **SOLID** Principles ?

    - Single Responsibility Principle (SRP)
    - Open/Closed Principle (OCP)
    - Liskov Substitution Principle (LSP)
    - Interface Segregation Principle (ISP)
    - Dependency Inversion Principle (DIP)

12. How can you achieve thread-safe singleton patterns in Java ?

    - **Using `sychronized`** 

      ```java
      public class Singleton {
          private static Singleton instance;
      
          private Singleton() {
              // private constructor to prevent instantiation
          }
      
          public static synchronized Singleton getInstance() {
              if (instance == null) {
                  instance = new Singleton();
              }
              return instance;
          }
      }
      // Can have performance issues due to the synchronized method, especially if getInstance is called frequently.
      ```

    - **Enum Singleton**

      - Enums provide implicit support for thread safety and are guaranteed to have only one instance.

        ```java
        public enum Singleton {
            INSTANCE;
        
            public void someMethod() {
                // method implementation
            }
        }
        // Not suitable if singleton class has to extend another class since Java enum types cannot inherit from other classes.
        ```

    - **Early Initialization**

      - In this method, the instance is created at the time of class loading. This ensures thread safety because the JVM ensures that the instance is created before any thread accesses the static `instance` variable.

        ```java
        public class Singleton {
            private static final Singleton INSTANCE = new Singleton();
        
            private Singleton() {
                // private constructor to prevent instantiation
            }
        
            public static Singleton getInstance() {
                return INSTANCE;
            }
        }
        //Instance is created even if it is never used, which could be a problem if the creation is resource-intensive.
        ```

13. What do you understand by the Open-Closed Principle (OCP) ?

    - Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. OCP allows a class to be extended with new functionality without modifying its existing code, thus reducing the risk of introducing bugs.

14. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be 
    substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

    - Answer: It mean that if the object of type A can do something, the object of type B could also be able tp 
      perform the same thing

15. 