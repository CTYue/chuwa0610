##2.  What is the checked exception and unchecked exception in Java, could you give one example?
- Checked exceptions that are checked at compile-time
unchecked exceptions that are checked at run-time
- Checked Exceptions:
    - IOException
    - SQLException
    - ClassNotFoundException
    - FileNotFoundException
- Unchecked Exceptions:
    - NPE
    - ArrayIndexOutOfBoundsException
    - ArithmeticException
## 3.  Can there be multiple finally blocks?
- No, in Java, a try block can only be associated with one finally block. 
## 4.  When both catch and finally return values, what will be the final result?
- When both the catch and finally blocks contain return statements, 
the final return value will come from the finally block
## 5.  What is Runtime/unchecked exception? what is Compile/Checked Exception?
 - runtime/unchecked exception：Can happen during runtime, the compiler is not required to handle
 - Compile/Checked Exception：Checked during compilation, must be handled explicitly
## 6.  What is the difference between throw and throws?
- Throw is used to throw an exception object within a method or a block of code.
- Throws is used in a function signature,  indicates  it may throw exception  type  in the method
## 7.  Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?
- Subclass exceptions must be caught before parent class exceptions. 
If the parent class exception is placed before the subclass exception, 
the subclass exception will not be caught.
- ArithmeticException and NullPointerException are the subclass of RuntimeException.
RuntimeException is subclass of Exception.
## 7. What is optional? why do you use it? write an optional example.
- Optional is a class to process NullPointerException
```java
public class Example {
    public static void main(String[] args) {
      // Create an Optional containing a value
      Optional<String> optional = Optional.of("Hello");
      // Check if Optional has a value and print
      System.out.println("Optional contains value: " + optional.isPresent());//true
      // Get the value from Optional, or use a default value if empty
      String value = optional.orElse("Default Value");
      System.out.println("Value or else default: " + value);// hello
      // Use ifPresent to process the value if it exists
      optional.ifPresent(v -> System.out.println("Value found: " + v));// hello

      // Create an empty Optional
      Optional<String> emptyOptional = Optional.empty();
      
      emptyOptional.ifPresent(v -> System.out.println("This will not be printed"));
    }
}
```

## 8. Why finally always be executed ?
Regardless of whether an exception occurs, some operations can be performed in finally. For example, resource release, cleanup operations, and supplementary exception handling

## 9. Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection
finish in HW3/collection  directory
## 10. What are the types of design patterns in Java ?
Factory method pattern,  singleton pattern， abstract factory pattern,

## 11. What are the SOLID Principles ?
Five basic principles of object-oriented design and development
-Single Responsibility Principle, SRP
- Open/Closed Principle, OCP
- Liskov Substitution Principle, LSP
- Interface Segregation Principle, ISP
- Dependency Inversion Principle, DIP)

## 12. How can you achieve thread-safe singleton patterns in Java ?
- Eager Initialization：d when the class is loaded，A unique instance is create
- Lazy Initialization: The first time you call it,  create an instance.
- Static inner class
- Enumeration class
## 13. What do you understand by the Open-Closed Principle (OCP) ?
Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
This makes it easy to add new functionality or change behavior without changing existing code.
- Open for Extension: It means extending the functionality of the system by adding new code without modifying the existing code.
- Closed for Modification: means that once a class or module is defined, its behavior should remain stable, and its behavior should be avoided as much as possible by modifying its source code.

## 14. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
### my answer is 14-1
- 1 mean that if the object of type A can do something, the object of type B could also be able tpperform the same thing
- 2 It means that all the objects of type A could execute all the methods present in its subtype B
- 3 It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.
- 4 It means that for the class B to inherit class A, objects of type B and objects of type A must be same.