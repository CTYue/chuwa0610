# HW3
## 1. Practice Collection

## 2. What is the checked exception and unchecked exception in Java, could you give one example?

- Checked Exception must be caught or declared in method signature and it is resolved at Compile-Time
- Ex: IOException
```java
public class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
```
- Unchecked Exception does not need to be caught or declared and it is resolved at Run-Time
- Ex: ArrayIndexOutOfBoundsException
```java
public class UncheckedExceptionExample {
    public static void main(String[] args) {
        int[] array = new int[10];
        System.out.println(array[11]);
    }
}
```

## 3. Can there be multiple finally blocks?

- There can only be one finally block since it is associated with the single try block. The finally block will always run no matter an exception is thrown or not.

## 4. When both catch and finally return values, what will be the final result?

- The return values from finally block will be the final result since it will always run regardless the exception is thrown or not and the finally block will override the return value from the catch block

## 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?

- Runtime/Unchecked Exception is not checked at Compile-Time. They are subclasses of RuntimeException. Ex: ArrayIndexOutOfBoundsException
- Compile-Time (Checked) Exception is checked at Compile-Time. They must be caught or declared in the method signature. Ex: IOException

## 6. What is the difference between throw and throws?

- throw is always used to throw an exception and it is followed by an instance of Throwable
- throws is always used in method signatures to declare that method may throw exceptions and it is followed by exception class names

## 7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?

```java
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3
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

public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3
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

public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3
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
- The first block of code will throw the ArithmeticException and the second block of code will throw NullPointerException and the third block of code will throw RuntimeException
- We put the Null/Runtime exception before Exception because in Java, exceptions are caught by the first matching catch block in the order they appear. If a more general exception type (like Exception) is placed before more specific ones (like NullPointerException or RuntimeException), the general catch block would handle all exceptions of that type and its subclasses, preventing the specific catch blocks from ever being reached.
- However, we want to show the specific exception being catched, that's why we put the Null/Runtime exception before Exception

## 8. What is optional? why do you use it? write an optional example.

- Optional is to represent optional values, which may or may not be present. It helps to avoid NullPointerException and makes code more readable by handling the absence of values. Ex:

```java
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> optionalValue = Optional.of("Hello");
        System.out.println("Value is present: " + optionalValue.isPresent());
        System.out.println("Value: " + optionalValue.orElse("Default Value"));
    }
}
```

## 9. Why finally always be executed?

- The finally block will always be executed is because it can make sure the code will always run no matter what kind of exception is thrown. The important part of it is to release resources and guarantee execution after the try block

## 10. What are the types of design patterns in Java?

### 1. Creational Patterns:
- Used for object creation such as Singleton, Factory Method, Abstract Factory, Builder, and Prototype patterns.

### 2. Structural Patterns:
- Used for object composition and relationship such as Adapter and Proxy patterns.

### 3. Behavioral Patterns:
- Used for object interaction such as Chain of Responsibility, Iterator and Template Method patterns.

## 11. What are the SOLID Principles?

### 1. Single Responsibility Principle:
- A class can only have one reason to change

### 2. Open/Closed Principle:
- Software entities should be open for extension but closed for modification.

### 3. Liskov Substitution Principle:
- Objects of a superclass should be replaceable with objects of its subclasses.

### 4. Interface Segregation Principle:
- Clients should not be forced to depend on interfaces they do not use.

### 5. Dependency Inversion Principle:
- High-level modules should not depend on low-level modules. Instead, both should depend on abstractions.

## 12. How can you achieve thread-safe singleton patterns in Java?
- Eager Initialization
- Lazy Initialization
- Double-Checked Locking
- Enum Singleton

## 13. What do you understand by the Open-Closed Principle (OCP)?
- Open-Closed means that software entities should definitely support extension. At the same time, it should close for modification. The software developers are able to add new extensions such as new functionality to a program or software without changing its existing code.

## 14. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

### 1. It mean that if the object of type A can do something, the object of type B could also be able to perform the same thing
### 2. It means that all the objects of type A could execute all the methods present in its subtype B
### 3. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.
### 4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.

- The correct answer should be the first one. Because LSP states that a superclass should be replaceable with objects of its subclasses without affecting the program. This means that subclasses should be substitutable for their base classes, and they should be able to behave in a way that is consistent with the behavior of the superclass. i.e. If the object of type A can do something, the object of type B could also be able to perform the same thing.

## 15. Watch the design pattern video, and type the code, submit it to MavenProject folder
- singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
- Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6d9
- Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6d9
- Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f7accf859bf7f6d9