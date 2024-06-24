# HW2

## 1. Write up Example code to demonstrate the three foundmental concepts of OOP. 
### 1. Encapsulation
```java
class Person {
    private String name;
    private int age;
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
        this.age = age;
    }
}
```
### 2. Polymorphism
- Method Overloading
```java
class Helper {
    int Multiply(int a, int b) {
        return a * b;
    }
 
    int Multiply(int a, int b, int c) {
        return a * b * c;
    }
}
```

- Method Overriding
```java
class Parent {
    void Print() {
        System.out.println("parent class");
    }
}

class subclass1 extends Parent {
    void Print() {
        System.out.println("subclass1");
    }
}
```

### 3. Inheritance
```java
class Animal {
  String name;
  public void eat() {
    System.out.println("I can eat");
  }
}

class Dog extends Animal {
  public void display() {
    System.out.println("My name is " + name);
  }
}
```

## 2. What is wrapper class in Java and Why we need wrapper class?

- In Java, wrapper classes encapsulate primitive data types into objects. Each primitive type has a corresponding wrapper class (e.g., int -> Integer, char -> Character).

## 3. What is the difference between HashMap and HashTable?

- HashMap is not synchronized, not thread-safe. HashTable is synchronized and thread-safe
- HashMap supports null key and value pairs but HashTable does not support
- HashMap has faster performance than HashTable because of not synchronized

## 4. What is String pool in Java and why we need String pool?

- The String pool in Java is a special memory region where Java stores string literals. It is part of the Java heap memory.
- We need String pool because it saves memory by reusing immutable string objects. If two string literals have the same value, they share the same memory location in the pool. Second, utilizing String pool reduces memory overhead and improves performance since identical string literals do not need to be duplicated.

## 5. What is Java garbage collection?

- Java garbage collection is the automatic process of identifying and reclaiming memory occupied by objects that are no longer in use by the application.

## 6. What are access modifiers and their scopes in Java?

- public: Accessible from any other class
- protected: Accessible within the same package and by subclasses
- private: Accessible only within the same class
- default: Package Protected, i.e, Accessible only within the same package

## 7. What is final key word? (Filed, Method, Class)

- Field: The value cannot be changed once it has been assigned
- Method: The method cannot be overridden by other classes
- Class: The class cannot be subclassed, i.e, can not be inherited

## 8. What is static keyword? (Filed, Method, Class). When do we usually use it?

- Field: A static field belongs to the class and it can be shared among each instance.
- Method: A static method belongs to the class and can be called without creating an instance.
- Class: A static class is a nested class that cannot access non-static members of the outer class.
The reason that we use static keyword is because when we need a member which can be shared among all instances

## 9. What is the differences between overriding and overloading?

- Overriding: 
### 1. Modifies the behavior of an inherited method in a subclass.
### 2. Method signature (name and parameters) must be the same as the parent class.
### 3. Involves two classes (parent and child)

- Overloading:
### 1. Defines multiple methods with the same name but different parameters in the same class.
### 2. Methods must have different parameter lists (type, number, or both).
### 3. Happens within the same class or can involve parent and child classes.

## 10. What is the differences between super and this?

- super: Referring to the parent class object
- this: Referring to the instance within the class

## 11. What is the Java load sequence?

- The Java load sequence refers to the order in which the Java Virtual Machine (JVM) loads and initializes classes. The sequence is as follows:
### 1. Loading: The JVM loads the class file into memory.
### 2. Linking: This involves 
- Verification: Ensuring the class file is correctly formatted and valid.
- Preparation: Allocating memory for static fields and initializing them to default values.
- Resolution: Converting symbolic references to direct references.
### 3. Initialization
- Static initializers and static blocks are executed in the order they appear.
- Static fields are assigned their specified values.

## 12. What is Polymorphism ? And how Java implements it?

- Polymorphism in Java is the ability of a single interface or method to operate in different ways based on the context, typically achieved through method overriding and method overloading.
### 1. Method Overriding: 
```java
class Animal {
    void sound() { System.out.println("Animal sound"); }
}
class Dog extends Animal {
    @Override
    void sound() { System.out.println("Bark"); }
}
```

### 2. Method Overloading:
```java
class Example {
    void func(int a) { System.out.println(a); }
    void func(String a) { System.out.println(a); }
}
```

## 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

- Encapsulation is a way of bundling data and methods that operate on the data into a single unit (class) and restricting direct access to some of the object's components to protect the integrity of the data.

- Java implements encapsulation using access modifiers (private, public, protected, and default) to control access to class members, and by providing public getter and setter methods to access and update private fields.

- Encapsulation is needed to enhance security, maintain control over data, and promote modularity and flexibility in code maintenance.

## 14. What is Interface and what is abstract class? What are the differences between them?

- An interface in Java is a reference type that can contain only constants, method signatures, default methods, static methods, and nested types. (A Complete Abstract Class)
- An abstract class is a class that is declared abstract—it may or may not include abstract methods, which are methods without a body; the key difference is that a class implementing an interface must implement all its methods, while a class extending an abstract class does not need to implement its abstract methods unless the subclass is also declared as abstract.

## 15. Design a parking lot (put the code to codingQuestions/coding1 folder)

- Within the Coding Folder as ParkingLot.java

## 16. What are Queue interface implementations and what are the differences and when to use what?

- The Queue interface represents a collection designed for holding elements that follows the FIFO (First-In-First-Out) principle.

### 1. LinkedList:
- Allows null elements and is not thread-safe. Suitable for basic FIFO operations.
- Uses LinkedList for basic FIFO operations and when null elements are allowed.

### 2. PriorityQueue: 
- Orders elements according to their natural ordering or a custom comparator.
- Uses PriorityQueue when elements need to be processed based on priority.

### 3. ArrayDeque: 
- Resizable-array implementation. Not thread-safe. Suitable for fast FIFO operations.
- Uses ArrayDeque for fast FIFO operations and as a stack.