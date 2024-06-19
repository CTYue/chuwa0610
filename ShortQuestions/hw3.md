# Homework 3

## 1. Practice collection

## 2. What is the checked exception and unchecked exception in Java, could you give one example?

### Checked Exception:
A checked exception is an exception that is checked at compile-time. These are typically conditions that a well-written application should anticipate and recover from.

**Example:** `IOException`

public class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("file.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class UncheckedExceptionExample {
    public static void main(String[] args) {
        String str = null;
        System.out.println(str.length());
    }
}


## 3. Can there be multiple finally blocks?

No, there cannot be multiple finally blocks for a single try block. However, a try block can be followed by a single finally block and zero or more catch blocks.

## 4. When both catch and finally return values, what will be the final result?
public class FinallyExample {
    public static void main(String[] args) {
        System.out.println(testMethod());
    }

    public static int testMethod() {
        try {
            throw new Exception("Test");
        } catch (Exception e) {
            return 1;
        } finally {
            return 2;
        }
    }
}

## 5. What is Runtime/unchecked exception? What is Compile/Checked Exception?
Runtime/Unchecked Exception:
Runtime exceptions are not checked by the compiler at compile-time. These exceptions occur during the runtime of the program. They are subclasses of RuntimeException.

Example: ArrayIndexOutOfBoundsException, NullPointerException

Compile/Checked Exception:
Checked exceptions are checked by the compiler at compile-time. These exceptions must be either caught or declared in the method in which they are thrown.

## 6. What is the difference between throw and throws?
throw:
The throw keyword is used to explicitly throw an exception from a method or any block of code.
Only one exception can be thrown using throw.
throws:
The throws keyword is used in the method signature to declare the exceptions that can be thrown by the method.
It indicates what exceptions may be thrown by the method, but does not throw them itself.

## 7.Why Do We Put NullPointerException and RuntimeException Before Exception?
Specificity: Catch specific exceptions before general ones. Placing Exception first catches all its subclasses, making specific catch blocks (like NullPointerException or RuntimeException) unreachable and causing a compile-time error.

Appropriate Handling: Handling specific exceptions first allows tailored responses for different exception types, ensuring appropriate logging and actions.

Compiler Requirement: The Java compiler mandates that catch blocks be ordered from most specific to most general to avoid unreachable code and maintain logical error handling.

## 7. What is Optional? Why Do You Use It? Write an Optional Example.
Optional is a container object used to represent the presence or absence of a value. It helps prevent NullPointerException by providing methods to handle nullable values safely.
public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(getName());
        optional.ifPresentOrElse(
            name -> System.out.println("Name: " + name),
            () -> System.out.println("Name not found")
        );
    }

    public static String getName() {
        return null; // Simulating a method that might return null
    }
}

## 8. Why Is finally Always Executed?
The finally block is always executed to ensure that important cleanup code is run regardless of whether an exception is thrown or caught. 

## 10. What Are the Types of Design Patterns in Java?
Creational Patterns: Singleton, Factory, Abstract Factory, Builder, Prototype.
Structural Patterns: Adapter, Composite, Proxy, Flyweight, Facade, Bridge, Decorator.
Behavioral Patterns: Strategy, Observer, Chain of Responsibility, Command, State, Template.

## 11. What Are the SOLID Principles?
Single Responsibility Principle: A class should have only one reason to change.
Open/Closed Principle: Software entities should be open for extension but closed for modification.
Liskov Substitution Principle: Subtypes must be substitutable for their base types.
Interface Segregation Principle: Many specific interfaces are better than one general-purpose interface.
Dependency Inversion Principle: Depend on abstractions, not on concrete implementations.

## 12. How Can You Achieve Thread-Safe Singleton Patterns in Java?
Eager Initialization, Double-Checked Locking, Bill Pugh Singleton:

## 13. What Do You Understand by the Open-Closed Principle (OCP)?
The Open-Closed Principle (OCP) states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means you should be able to add new functionality without changing existing code, often achieved through abstraction and polymorphism.

## 14 Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be
substituted with any object of type B. What does this actually mean? 
It means that if the object of type A can do something, the object of type B should also be able to perform the same thing.

## 15