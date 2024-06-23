## 1. Practice collection

## 2. What is the checked exception and unchecked exception in Java, could you give one example?

* A checked exception is an exception that is checked at compile-time. Checked Exception must be caught or declared in method signature.
* Examples: IOException, SQLException, and ClassNotFoundException
* Unchecked exception: it is resolved at Run-Time
* Examples: NullPointerException, ArrayIndexOutOfBoundsException, and ArithmeticException

## 3. Can there be multiple finally blocks?

No, at most one finally blocks.

## 4. When both catch and finally return values, what will be the final result?

The value returned by the finally block will override the value returned by the catch block. 

## 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?

* Unchecked Exceptions (Runtime Exceptions) are exceptions that are not checked at compile time. These exceptions occur at runtime and are typically the result of programming errors, such as logic mistakes or improper use of an API.
* Checked Exceptions (Compile-Time Exceptions) are exceptions that are checked at compile time. 

## 6. What is the difference between throw and throws?

* The throw keyword is used to explicitly throw an exception from a method or any block of code. It is followed by an instance of Throwable (typically an Exception or Error).
* The throws keyword is used in a method signature to declare that the method can throw one or more exceptions. It is followed by a comma-separated list of exception classes.

## 7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?

```
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        String s = null;
        try {
            System.out.println(b / a);  // This will cause an ArithmeticException
            System.out.println(s.equals("aa"));  // This line won't be executed
            throw new RuntimeException();  // This line won't be executed
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();  // Fixed to match others
        }
        System.out.println("End ...");
    }
}
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        String s = null;
        try {
            // System.out.println(b / a);  // This line is commented out
            System.out.println(s.equals("aa"));  // This will cause a NullPointerException
            throw new RuntimeException();  // This line won't be executed
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();  // Fixed to match others
        }
        System.out.println("End ...");
    }
}
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        String s = null;
        try {
            // System.out.println(b / a);  // This line is commented out
            // System.out.println(s.equals("aa"));  // This line is commented out
            throw new RuntimeException();  // This will cause a RuntimeException
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();  // Fixed to match others
        }
        System.out.println("End ...");
    }
}

```

* ArithmeticException -> NullPointerException -> RuntimeException
* In Java, exceptions are caught by the first matching catch block in the order they appear. 
* We generally put specific catch blocks before.

## 7. What is optional? why do you use it? write an optional example.

* In Java, Optional is a container object which may or may not contain a non-null value. 
* It helps to avoid NullPointerException and to make the code more readable.
  
  ```
  String name = "Alice";
  Optional<String> optionalName = Optional.of(name);
  ```

## 8. Why finally always be executed ?

* The finally block is always executed to ensure the execution of necessary release resources and cleanup codes running regardless of whether an exception is thrown or caught.

## 9. Practice collection problems here: 

https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection

## 10. What are the types of design patterns in Java ?

## 11. What are the SOLID Principles ?

* Single Responsibility Principle (SRP): A class should have only one reason to change, meaning that a class should only have one job or responsibility.
* Open/Closed Principle (OCP): Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
* Liskov Substitution Principle (LSP): Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.
* Interface Segregation Principle (ISP): Clients should not be forced to depend on interfaces they do not use.
* Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules. Both should depend on abstractions. Also, abstractions should not depend on details. Details should depend on abstractions.

## 12. How can you achieve thread-safe singleton patterns in Java ?

* Eager Initialization
* Lazy Initialization

## 13. What do you understand by the Open-Closed Principle (OCP) ?

* The Open-Closed Principle (OCP) asserts that software entities (such as classes, modules, and functions) should be open for extension but closed for modification. This implies that you should be able to introduce new functionality without altering existing code, which is typically accomplished through the use of abstraction and polymorphism.

## 14.  Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

It means that if the object of type A can do something, the object of type B could also be able to perform the same thing.

## 15. Watch the design pattern video, and type the code, submit it to MavenProject folder
