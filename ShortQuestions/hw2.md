# HW1

## 1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)

```
// Encapsulation
class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Method to calculate area (to be overridden)
    public double calculateArea() {
        return 0.0;
    }

    // Overloaded method
    public void setColor(String color, double opacity) {
        this.color = color + " with opacity " + opacity;
    }
}
// Inheritance 
class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    // Polymorphism: Overriding calculateArea method
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    // Polymorphism: Overriding calculateArea method
    @Override
    public double calculateArea() {
        return width * height;
    }
}
```

## 2. What is wrapper class in Java and Why we need wrapper class?

* A wrapper class allows primitive data types to be used as objects. 

* Example: int - Integer, char - Character

* Collections Framework Compatibility: Java's collections framework (like List, Set, Map, etc.) can only store objects

* Null Values: Wrapper classes can represent null values, whereas primitive types cannot. 
  
  ```
  List<Integer> numbers = new ArrayList<>();
  numbers.add(null);  // Allowed
  ```

* Object Methods: Wrapper classes provide methods to perform various operations.  Integer.parseInt(str) toString()

## 3. What is the difference between HashMap and HashTable?

* HashTable is thread safe, multiple threads can access and modify the Hashtable concurrently without causing data corruption or inconsistency.
* Each method in Hashtable is synchronized, ensuring that only one thread can execute any synchronized method at a time. 
* HashMap allows one null key and multiple null values.
* HashMap is generally faster.

## 4. What is String pool in Java and why we need String pool?

* The String Pool is a special memory region in the **Java heap** that stores **string literals**.
* __When a string literal is created, Java checks the String Pool to see if an identical string already exists.__ If it does, the reference to the existing string is returned. If it doesn't, the new string is added to the pool, and its reference is returned.
* String pool can have better Memory Efficiency, Faster Comparisons, Reduced Garbage Collection

## 5. What is Java garbage collection?

* Java garbage collection is an automatic memory management process that identifies and removes objects that are no longer in use or reachable by the application.
* This helps prevent memory leaks and auto memory deallocation.

## 6. What are access modifiers and their scopes in Java?

* private: same class
* default: same package
* protected: same package and subclasses
* public: anywhere

## 7. What is final key word? (Filed, Method, Class)

* Final Field: value cannot be changed.
* Final Method: it cannot be overridden by subclasses. 
* Final Class: it cannot be subclassed. 

## 8. What is static keyword? (Filed, Method, Class). When do we usually use it?

* Static Field, also known as a class variable, is shared among all instances of the class. Example: a counter for tracking the number of objects created.
* Static Method, belongs to the class rather than any particular instance. Example: Utility or helper methods.
* Static method can be called by class name.
* Static inner class.

## 9. What is the differences between overriding and overloading?

* Overloading is a Compile time polymorphism. 
* In method overloading, more than one method shares the same method name with a different signature in the class.
* Method Overriding is a Run time polymorphism. 
* Overriding: A method in a subclass with the same signature as a method in the parent class, but have different implementation. 

## 10. What is the differences between super and this?

* this: Refers to the current object instance.
* super: Refers to the parent class instance.

## 11. What is the Java load sequence?

* The Java load sequence is the order in which the JVM loads and initializes classes and their members.
* Static fields and static blocks -> Instance fields and instance blocks -> Constructor of the class.

## 12. What is Polymorphism ? And how Java implements it ?

* Polymorphism is the ability of an object to take on multiple forms. 
* In the context of programming, polymorphism is the ability of an object to behave like it's of a different class than it actually is.
* Java achieve polymorphism by method overriding and method overloading.

## 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

* Binding data and behavior into single unit is called encapsulation
* data members + methods (behavior) 
* Encapsulation can protect the internal state of an object and provide controlled access.
* Java implements encapsulation using access modifiers (private, protected, public). 

## 14. What is Interface and what is abstract class? What are the differences between them?

Abstract class

* Abstract Method: A method with only declaration but not implementation. Child classes will take care of implementation.
* If a class contains at least one abstract method, the class should be declared as an abstract class. 
* An abstract class in Java is a class that cannot be instantiated directly, but must be subclassed.
* We cannot use an abstract class to create objects.
* A class can inherit an abstract class by using the keyword ‘extends’.

Interface

* An interface is a collection of abstract methods and constants.
* All methods = public abstract, all variables = final static
* A class can implement interface by using implements keyword
* Cannot new Interface, but we can have reference. MyInterface myInterface = new MyClass();

Abstract Classes:

* Can have both abstract and concrete methods.
* Can have fields with different access modifiers.
* Can have constructors.
* Support single inheritance.

Interfaces:

* Primarily used to define a contract with abstract methods, though Java 8 and later allows default and static methods.
* Fields are implicitly public, static, and final.
* Cannot have constructors.
* Support multiple inheritance.

## 15. design a parking lot

(put the code to codingQuestions/coding1 folder, If you have no ability to design it, please find the solution in internet, then understand it, and re-type it.(Do NOT just copy and paste)


See coding1 folder

## 17. What are Queue interface implementations and what are the differences and when to use what

![Alt text](JavaCollections.PNG)

LinkedList: get(index), add(), remove(), addFirst(), addLast(), removeFirst(), removeLast()

PriorityQueue:

* Orders elements according to their natural ordering or by a Comparator provided at queue construction time.
* Does not allow null elements.
* Not thread-safe.
