# HW2

## 1. Write up Example code to demonstrate the three fundamental concepts of OOP.
### 1. Encapsulation
```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) { // Ensure age is not negative
            this.age = age;
        } else {
            System.out.println("Age cannot be negative.");
        }
    }
}

```
### 2. Polymorphism
#### Overloading
```java
class Person {
    private String name;
    private int age;
    
    updateInfo(String newName) {
        this.name = newName;
    }

    updateInfo(String newName, int newAge) {
        this.name = newName;
        this.age = newAge;
    }
}
```

#### Overriding

```java
class Person {
    void run() {
      System.out.println("person is running");
    }
}

class Student extends Person {
    @Override
    void run() {
        System.out.println("student is running");
    }
}
```

### 3. Inheritance
```java
class Person { 
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person {
    String studentId;
    String major;
    Student(String studentId, String major, String name, int age) {
        super(name, age); // Call to the superclass constructor
        this.studentId = studentId;
        this.major = major;
    }

    public void showInfo() {
        System.out.println("Student information:\n"
                + "name: " + super.name
                + ", age: " + super.age
                + ", studentId: " + this.studentId
                + ", major: " + this.major
        );
    }
}
```

## 2. What is wrapper class in Java and Why we need wrapper class?

#### What is wrapper class?
Wrapper class provides a way to use primitive date types as **Objects**. eg. integer - Integer.

#### Why we need wrapper class?
Wrapper class make Java as a completely object-oriented programming language.

## 3. What is the difference between HashMap and HashTable?

| HashMap                   | HashTable                            |
|---------------------------|--------------------------------------|
| not synchronized          | synchronized                         |
| not thread-safe           | thread-safe                          |
| allow null key and values | not allow null key and values        |
| faster                    | slow due to overhead of thread-safe  |

## 4. What is String pool in Java and why we need String pool?

#### What?
A part of Java heap memory where stores String constants.

#### Why wee need?
- Reduce the overhead of memory by reusing the string constants.
- Improve performance: If the string value we need has already exists in the string pool, we access string in string 
  pool, which is faster than creating a new string object.

## 5. What is Java garbage collection?

**Garbage collection (GC)** is the process of identifying and disposing of objects that are no longer needed by a Java 
application automatically. 


## 6. What are access modifiers and their scopes in Java?

- public: Accessible from **any other class**, regardless of packages.
- protected: Accessible **within the same package**, and the **subclasses** even if in different packages.
- private: Accessible only **within the same class**.
- default: Accessible only **within the same package**.

## 7. What is final key word? (Filed, Method, Class)

- Field: The value cannot be changed after initialized.
- Method: The method cannot be overridden by subclasses.
- Class: The class cannot be subclassed / inherited.

## 8. What is static keyword? (Filed, Method, Class). When do we usually use it?
#### What?
- Field: A static field is shared among all instances of class. It belongs to the class.
- Method: A static method belongs to the class. It can be called without creating an instance of the class.
- Class: A static class must be defined **in** a class. It must be a **nested** class and cannot access non-static 
  members of the outer class.

#### When use it?
It is commonly used for shared resources(field), utility functions(method), and grouping related classes(class), 
enhancing code organization and efficiency.
It is always used for sharing among instances of class.


## 9. What is the differences between overriding and overloading?

| Overriding                                                                                  | Overloading                                                                |
|---------------------------------------------------------------------------------------------|----------------------------------------------------------------------------|
| happens at runtime                                                                          | happens at compile time                                                    |
| involves methods in parent class and subclass                                               | involves methods within a class                                            |
| methods in parent class and subclass have the same signature(name, return type, parameters) | methods have the same name but different parameters(type, number, or both) |


## 10. What is the differences between super and this?

- super: refer to the parent class of the current class.
- this: refer to the instance of the current class

## 11. What is the Java load sequence?

Java load sequence refers to the order that JVM loads and initializes the classes.
1. Loading: The Java ClassLoader loads Java classes into the Java Virtual Machine. ( The ClassLoader is a part of the Java Runtime Environment)
2. Linking: 
   - Verification: The bytecode of the class is verified to ensure correct format and valid, and does not violate 
     security constraints.
   - Preparation: Allocating memory and initializing static fields to their default values (0, null, 
     false, etc.).
   - Resolution: Symbols in the bytecode that reference other classes are resolved to direct references.
3. Initialization: Static fields are initialized to their specified values and all static initialization blocks are 
   executed in the order they appear.

   
## 12. What is Polymorphism? And how Java implements it?

Polymorphism refers to the ability of a single method, function to operate on different ways, two main types are 
overloading and overriding.

### How Java implements it?
#### Overriding:
```java
class Person {
  void run() {
    System.out.println("person is running");
  }
}

class Student extends Person {
  @Override
  void run() {
    System.out.println("student is running");
  }
}
```

#### Overloading:
```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    int add(int a, int b, int c) {
      return a + b + c;
    }
    double add(double a, double b) {
      return a + b;
    }
}
```

## 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

#### What?
Encapsulation gives a way to encapsulate fields and methods into a single unit, restricting the direct access to 
some components of an object to provide privacy and maintain control over the transparency of data.

#### How?
using access modifiers:
- private
- protected
- default
- public

#### Why?

Improving code maintainability, readability, modularity and security.

## 14. What is Interface and what is abstract class? What are the differences between them?

#### What?
Interface is a reference type that can contain only constants, method signatures, default methods, static methods, and nested types. 
Interfaces cannot contain instance fields or constructors.


- An interface in Java is a reference type that can contain only constants, method signatures, default methods, static methods, and nested types. (A Complete Abstract Class)
- An abstract class is a class that is declared abstract—it may or may not include abstract methods, which are methods without a body; the key difference is that a class implementing an interface must implement all its methods, while a class extending an abstract class does not need to implement its abstract methods unless the subclass is also declared as abstract.

#### Differences

Interfaces contains **all** behaviors that all subclasses must have.

But abstract class contains **some** behaviors that all subclasses must share.

| interface                              | abstract class                               |
|----------------------------------------|----------------------------------------------|
| a class implements multiple interfaces | a class only extends one abstract class      |
| extends interfaces only,               | extends                                      |
| must be implemented **all methods**    | must be implemented **all abstract** methods |


## [15. Design a parking lot (put the code to codingQuestions/coding1 folder)](../Coding/Hw2_ParkingLot)


## 16. What are Queue interface implementations and what are the differences and when to use?

Queue interface is a collection designed for holding elements prior to processing. It has different ordering rules 
with different implementations.

### LinkedList
- If we want to follow FIFO principle.
### PriorityQueue
- If we want to follow a priority order.
### ArrayDeque
- If we need an efficient general-purpose queue with the ability to expand as needed and follow FIFO.


