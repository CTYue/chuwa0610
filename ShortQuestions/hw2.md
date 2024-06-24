# HW2
1.
```java
// Encapsulation: Encapsulation is the mechanism of restricting direct access to some of an object's components, which can prevent the accidental modification of data. This is typically done by making class variables private and providing public getter and setter methods to access and update the value of a private variable.
public class Car {
    private string name;
    public Car(String name) {
        this.name = name;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }
    public void setName(name) {
        this.name = name;
    }
    public void gasOn(name) {
        //gason method;
    }
}

// Polymorphism: Polymorphism allows methods to do different things based on the object it is acting upon. This can be achieved through method overriding or method overloading.
// Inheritance: Inheritance allows a class to inherit the attributes and methods of another class, known as the superclass.
public class eCar extends Car {
    private String type;
    public eCar(String name, String type) {
        super.Car(name, type);
    }
    // Getter and Setter methods
    public String getType() {
        return type;
    }
    public void setType(name) {
        this.type = type;
    }

    // method overriding
    public void gasOn(name) {
        //ecar gason method;
    }
}

```
2. What is a wrapper class in Java and Why we need wrapper class?
In Java, wrapper classes provide a way to use primitive data types (int, char, double, etc.) as objects. Java provides wrapper classes for each of the primitive data types, which effectively "wrap" the primitive values in an object so they can be included in activities reserved for objects, such as being added to Collections, working with generics, or used where objects are required.
Wrapper classes are needed for several reasons in Java:

* Object Requirement: In many parts of the Java API, and in many third-party libraries, there is a need to pass objects rather than primitive types. For example, the collections framework in Java (ArrayList, HashMap, etc.) can only store objects, not primitives.

* Nullability: Wrapper classes allow for null values, providing a way to indicate the absence of data, whereas primitive types always have a default value and cannot be null.

* Class Methods: Wrapper classes provide a variety of utility methods that are useful for working with the respective primitive values. For example, Integer and Double classes have methods like compare(), valueOf(), and parseXxx(), which are very useful for converting strings to numbers and performing comparisons.

* Use in Generics: Java’s generics do not support primitive types. So, if you want to use primitive values in a generic data structure, you must use wrapper classes. For instance, List<Integer> can store integers, whereas List<int> is not valid.

3. What is the difference between HashMap and HashTable?
HashMap and HashTable are both part of Java's Collections Framework, and they implement the Map interface, which allows them to store data in key-value pair format. 
But HashMap is not synchronized, which means it is not thread-safe when multiple threads are accessing it concurrently and at least one of the threads modifies the map structurally. It also allows one null key and multiple null values. This makes it more flexible when dealing with datasets where such entries might be necessary or expected.
While HashTable is inherently synchronized, meaning all of its methods are implemented with synchronization. This makes HashTable thread-safe for concurrent access by multiple threads. However, this also means that HashTable is generally slower than HashMap due to the overhead of synchronization. And it does not allow null keys or null values. Attempting to insert a null key or value will throw a NullPointerException.

4. What is String pool in Java and why we need String pool?
The String Pool in Java is a special area of the Java heap memory used to store distinct instances of string literals. In Java, when a string literal is created, the JVM checks the string pool first. If a string with the same contents exists, a reference to this pooled instance is returned. If the string doesn't exist, a new string instance is created and placed in the pool. This mechanism is called interning. Strings not explicitly interned can be garbage collected if there are no other references to them.
It can decrease the memory usage and increasing the performance of applications.

5. What is Java garbage collection?
Java garbage collection is an automatic memory management process that the JVM uses to identify and dispose of objects that are no longer being used by a program. This process helps free up memory resources and prevent memory leaks, which can lead to reduced performance and application crashes.

6. What are access modifiers and their scopes in Java?
* public: Accessible from any other class anywhere, whether in the same package or another.
* private: Accessible only within the class it is declared. 
* protected: Accessible within the same package or subclasses in any package.
* default (package-private): Accessible only within the same package.

7. What is final keyword?(Field,Method,Class)
* final variable: When the final keyword is used with a variable, it makes that variable a constant, meaning that its value cannot be changed once it has been assigned.
* final method: When a method is declared final, it cannot be overridden by subclasses. This is often used to prevent a method from being modified in any subclass.
* final class: When a class is declared as final, it cannot be subclassed. This is particularly useful when creating an immutable class or a class that should not be extended for security reasons.

8. What is static keyword?(Field,Method,Class). When do we usually use it?
* static variable: This means there is only one copy of the variable per class, regardless of how many objects are created from it.
* static method: Static methods can be called without creating an instance of the class. They can only access static data members and invoke other static methods.
* static class: Static nested classes are declared within another class and have access modifiers like any other member of the class.
It helps in managing global state such as database configuration and connection.

9. What is the differences between overriding and overloading?
* Overloading: Method overloading occurs when two or more methods in the same class have the same name but different parameters. It is a way of creating multiple methods with the same name that perform similar but slightly different functions, based on the arguments passed. It is determined at compile time.
* Overriding: Method overriding occurs when a subclass provides a specific implementation of a method that is already defined in its superclass. This is used when the subclass needs to modify the behavior of a method defined in the superclass. It's determined at runtime.

10. What is the differences between super and this?
* this: Refers to the current object, and its methods or constructors in the same class.
* super: Refers to the superclass, and its methods or constructors.

11. What is the Java load sequence?
The Java load sequence involves several steps that ensure classes are properly loaded, linked, and initialized before they are used in any program.
* Loading: The process where the Java ClassLoader reads the compiled .class file into the JVM.
* Linking: After a class is loaded, it undergoes linking. **Verification** that checks for byte code errors, **Preparation** that JVM allocates memory for class variables and initializing any static fields to default values and **Resolution** that resolves symbolic references from the loaded class to other classes and interfaces, replacing them with direct references.
* Initialization: This is where all static variables are initialized to their values as defined in the code, and static blocks are executed.

12. What is Polymorphism? And how Java implements it ?
Polymorphism allows methods to do different things based on the object it is acting upon. This can be achieved through method overriding or method overloading.

13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
Encapsulation refers to the bundling of variables and methods that operate on the data into a single unit or class. It also restricts direct access to some of an object's components, which is a form of data hiding. This is typically done by making class variables private and providing public getter and setter methods to access and update the value of a private variable.

14. What is Interface and what is abstract class? What are the differences between them?
In Java, both interfaces and abstract classes are used to achieve abstraction, where to define required but unspecified functionality. 
An interface in Java is a reference type, similar to a class, that can contain only constants, method signatures, default methods, static methods, and nested types. Interfaces cannot contain instance fields. The methods in interfaces are abstract by default. It is used when you expect unrelated classes to implement your interface.
An abstract class in Java is a class that cannot be instantiated on its own and must be inherited by other classes. An abstract class can contain abstract methods (methods without a body) as well as methods with implementation. It is used when you want to share code among closely related classes and when you expect classes that extend your abstract class to have many common methods or fields, or require access modifiers other than public.

15. design a parking lot (put the code to codingQuestions/coding1 folder)

16. What are Queue interface implementations and what are the differences and when to use what?
* LinkedList: It provides a doubly linked list implementation of the Queue interface. It allows insertion and removal of elements from both ends of the queue, making it also useful as a stack. Use LinkedList when you need a general-purpose queue combined with stack capabilities, and when you need to frequently insert and delete elements from both ends.
* PriorityQueue: Elements of the priority queue are ordered according to their natural ordering, or by a Comparator provided at queue construction time. Use PriorityQueue when you need to process elements based on a priority.
* ArrayDeque: Uses a resizable array, which can grow as needed. It is more efficient than LinkedList when used as a queue or stack.  Use ArrayDeque when you need high-performance, resizable-array implementation of the Deque interface. ArrayDeque is likely faster than Stack when used as a stack, and faster than LinkedList when used as a queue.
* ConcurrentLinkedQueue: A thread-safe version of a linked list.
* BlockingQueue Implementations.