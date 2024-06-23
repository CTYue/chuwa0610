# HomeWork 2

## 1. Write up Example code to demonstrate the three fundamental concepts of OOP:
```
// Base class to demonstrate inheritance
class Employee {
    private String name;  // private field for encapsulation
    private double salary;  // private field for encapsulation

    // Constructor
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for salary
    public double getSalary() {
        return salary;
    }

    // Setter for salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Method to demonstrate polymorphism
    public void work() {
        System.out.println(name + " is working");
    }
}

// Derived class to demonstrate inheritance and polymorphism
class Manager extends Employee {
    private int teamSize;

    public Manager(String name, double salary, int teamSize) {
        super(name, salary);  // call to superclass (Employee) constructor
        this.teamSize = teamSize;
    }

    // Overriding the work method to demonstrate polymorphism
    @Override
    public void work() {
        super.work();  // call to superclass method
        System.out.println(getName() + " is managing a team of " + teamSize);
    }

    // Getter for teamSize
    public int getTeamSize() {
        return teamSize;
    }

    // Setter for teamSize
    public void setTeamSize(int teamSiz teamSized) {
        this.teamSize = teamSize;
    }
}

// Main class to run the program
public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("John Doe", 50000);
        Manager manager = new Manager("Jane Doe", 75000, 5);

        employee.work();  // Calls Employee's work()
        manager.work();  // Calls Manager's overridden work()
    }
}
```

## 2. What is wrapper class in Java and Why we need wrapper class?
In Java, a wrapper class is a class that encapsulates a primitive data type within an object. Each of the eight primitive data types in Java has a corresponding wrapper class. The primary purpose of these wrapper classes is to allow primitives to be included in situations requiring an object, such as in collections that store objects (like ArrayList or HashSet) and in frameworks that operate on objects.
- byte — Byte
- short — Short
- int — Integer
- long — Long
- float — Float
- double — Double
- char — Character
- boolean — Boolean

## 3. What is the difference between HashMap and HashTable?
1. Synchronization
   - HashTable: It is synchronized, which means it is thread-safe. The methods of HashTable are synchronized to prevent multiple threads from concurrently modifying the map. This makes it suitable for use in environments where the map is accessed by multiple threads without additional synchronization.
   - HashMap: It is not synchronized, which means it is not inherently thread-safe. If a HashMap is accessed by multiple threads concurrently, and at least one of the threads modifies the map structurally, it must be synchronized externally, typically using Collections.synchronizedMap(Map).
2. Null Keys and Values
   - HashTable: Does not allow null keys or null values. Attempting to insert a null key or null value throws a NullPointerException.
   - HashMap: Allows one null key and any number of null values, making it more flexible than HashTable.

## 4. What is String pool in Java and why we need String pool? 
The String Pool in Java, also known as the String Intern Pool, is a special storage area in the Java heap memory. It is used to store a collection of unique String literals that appear in your program. When a String is created and if an identical string already exists in the pool, the new variable will reference the existing string instead of creating a new object. This mechanism is facilitated by the intern() method of the String class.

## 5. What is Java garbage collection? 
Java garbage collection (GC) is a process by which Java programs perform automatic memory management. Java applications gain memory efficiency and performance through garbage collection, which helps manage memory space in the heap by identifying and disposing objects that are no longer in use by a program.

## 6. What are access modifiers and their scopes in Java? 

In Java, access modifiers are keywords used before class names and class members (variables and methods) to set their access levels. Access modifiers determine from where these classes or class members can be accessed in your code, providing an essential aspect of Java's encapsulation capabilities.

There are four main types of access modifiers in Java, each with different access levels:

1. Private
   - Scope: The private access modifier is the most restrictive. Elements declared as private can be accessed only within the same class to which they belong.
   - Usage: Typically used for variables and helper methods that should be hidden from other parts of your application to encapsulate behavior and internal data.
2. Default (No Modifier)
   - Scope: If no access modifier is specified, the default access level is used. Default access allows the class or class member to be accessed only within other classes in the same package.
   - Usage: Useful when you want to allow access to elements for classes that are grouped together within the same package but keep them hidden from the broader application.
3. Protected
   - Scope: Elements declared as protected can be accessed within the same package or within subclasses in different packages.
   - Usage: This is particularly useful when you want to hide certain class members from the world but still allow access to them by child classes, potentially across package boundaries.
4. Public
   - Scope: The public access modifier specifies that the class, method, or variable can be accessed from any other class in the Java universe, regardless of which package it belongs to.
   - Usage: Typically used for API methods and variables that need to be available to the entire application or other applications.

## 7. What is final key word? (Filed, Method, Class)
1. Final Variables
   
   When a variable is declared with the final keyword, its value can be assigned only once. Attempting to change the value of a final variable after it has been assigned will result in a compilation error. This applies to both class (static) variables and instance variables.

- Local Variables: When a local variable is marked as final, it must be initialized only once and cannot be changed within its scope.
- Parameters: Parameters can be declared final, preventing them from being altered within the method.

2. Final Methods
- A final method cannot be overridden by subclasses. This is useful when you want to prevent a method from any alteration in the subclass, ensuring the method's behavior remains consistent across all subclasses.

3. Final Classes
   
   When a class is declared as final, it cannot be subclassed. This is particularly useful when creating an immutable class like String or when a class is not designed to be inherited.

## 8. What is static keyword? (Filed, Method, Class). When do we usually use it?
The static keyword in Java is used to indicate that a particular member (variable or method) or a nested class belongs to the type itself, rather than to instances of the type. This means that the member can be accessed without creating an instance of the class.

Static variables are shared among all instances of a class. When you declare a variable as static, a single copy of that variable is created and shared among all instances of the class, no matter how many instances you create. Changes to the static variable affect all instances because the variable is shared.

Static methods can be called without creating an instance of the class. They can only directly access static variables and other static methods; they cannot access instance variables or instance methods (non-static members), because these require an instance of the class to be used.

Static nested classes are not associated with a specific instance of the outer class, but rather with the class itself. They are used primarily when the nested class logically belongs to the class that encloses it, and accessing the enclosing class's members is not necessary.

When to Use static  Shared Property: 
- Use static for properties that should be shared across all instances of a class, such as a counter or configuration settings.
- Utility Methods: static is commonly used for utility or helper methods that perform a function independently of the state of any instance of the class. This is typical in classes like Math or Collections.
- Constants: Static variables are often used together with the final keyword to create constant values that are shared.
- Performance: Static fields and methods can sometimes help in reducing the overhead of method calls and memory usage since no instance is required.
- Factory Methods: Static methods are used in factory patterns where they return an instance of their class based on some arguments.

## 9. What is the differences between overriding and overloading?
- Overriding is about giving a new implementation to an inherited method in a subclass. Overriding resolves which method to call at runtime, making it a case of dynamic binding.
- Overloading is about defining methods that have the same name but different parameters within the same class. Overloading resolves which method to call at compile time, making it a case of static binding.

## 10. What is the differences between super and this?
- `this` keyword is used within an instance method or a constructor of a class to refer to the current object—the object whose method or constructor is being called. You can use this to:
  Differentiate between instance variables and parameters when they have the same names.
  Call another constructor in the same class (constructor chaining).
  Pass the current object as a parameter to another method.
  Return the current class instance.
-  `super` keyword is used within an instance method or a constructor of a subclass to refer to the superclass (parent class) of the current object. It is used to:
   Access methods of the superclass that have been overridden by the subclass.
   Access constructor of the superclass.
   Access fields of the superclass if they are shadowed (redefined) in the subclass.

## 11. What is the Java load sequence?
- Class loading is the process by which the Java ClassLoader reads class files (binary data) and brings them into the JVM. The class loader performs the loading of classes dynamically upon request.
- Linking: After a class is loaded, it undergoes linking. Linking involves verifying, preparing, and (optionally) resolving. 
- Initialization is the final phase of class loading. During this phase, static variables are initialized, and the static block (if any) is executed. This is done from parent to child and respects the hierarchical order of the classes.

## 12. What is Polymorphism ? And how Java implements it ?
Polymorphism is a core concept in object-oriented programming that refers to the ability of a variable, function, or object to take on multiple forms.
Java primarily implements polymorphism through inheritance and interfaces. Here’s how each mechanism works:

1. Inheritance and Method Overriding (Runtime Polymorphism)
   When a subclass overrides a method of its superclass, it's providing its own implementation. At runtime, the JVM determines the object's type and executes the overriding method, ensuring that the behavior is appropriate for the actual object's class.

2. Method Overloading (Compile-time Polymorphism)
   Java allows multiple methods in the same class with the same name but different parameters. The compiler uses the method signature and parameters to determine which specific method to call, and this decision is made at compile time.

## 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
Encapsulation is the mechanism of wrapping the data (variables) and code acting on the data (methods) together as a single unit. In encapsulation, the variables of a class are hidden from other classes and can be accessed only through the methods of their current class. Therefore, it is also known as data hiding.

Java provides several access modifiers to help encapsulate an object. The main levels are:

- Private: The access level of a private modifier is only within the class. It cannot be accessed from outside the class.
- Default: If no access modifier is specified, then the default access level is used, which allows access to the member from any other class in the same package.
- Protected and Public: These provide more broad access, but are less about encapsulation and more about interaction between different parts of a program.

Why We Need Encapsulation

- Control of the way data is accessed or modified: By encapsulating the components, you can protect an object's internal state by preventing users from setting the state into anything other than what you define. For example, you can set conditions on a setter method to ensure the data fits certain criteria.
- Maintainability and flexibility: Encapsulation makes the code more maintainable and flexible. Developers can change one part of the code without affecting other parts. Implementing encapsulation can protect the objects in your application from unintended interference and misuse.
- Increase security of data: By making the class variables private and providing public setter and getter methods, you control who can modify or read the state of the variables. This can prevent accidental or intentional changes to the data, which can lead to data corruption or undesired behavior.

## 14. What is Interface and what is abstract class? What are the differences between them?
- An interface in Java is a reference type, similar to a class, that can contain only constants, method signatures, default methods, static methods, and nested types. Interfaces cannot contain instance fields. The methods in interfaces are abstract by default, i.e., they do not have a body, except for default and static methods.
- An abstract class is a class that cannot be instantiated on its own and must be subclassed. It can contain abstract methods (methods without a body) as well as methods with an implementation. You can also define fields that can be inherited.

Abstract Methods:

- Interface: All methods in an interface are implicitly abstract unless they are default or static methods.
- Abstract Class: Can have both abstract and non-abstract methods.

Instance Variables:

- Interface: Cannot have instance variables. All fields in an interface are public, static, and final by default.
- Abstract Class: Can have instance variables and constants, and they can have any visibility (private, protected, public).

Constructor:

- Interface: Cannot have constructors because interfaces cannot be instantiated by themselves.
- Abstract Class: Can have constructors, which can be called when a subclass is instantiated.

## 16. What are Queue interface implementations and what are the differences and when to use what?
Common Implementations of Queue Interface 

- LinkedList

Implements both the List and Queue interfaces.
Provides a FIFO queue behavior.
Allows for constant-time size checking, element addition at the end, and removal at the beginning.
Use Case: Use LinkedList when you need a general-purpose queue combined with list operations. It is suitable for applications where you frequently insert and remove elements from the queue.

- PriorityQueue

Elements are ordered according to their natural ordering or by a Comparator provided at queue construction time.
Does not permit null elements.
Offers O(log n) time complexity for insertion and extraction.
Use Case: Use PriorityQueue when you need to process elements based on priority rather than just FIFO. Common applications include scheduling systems where priorities are assigned to tasks.

- ArrayDeque

Resizable-array implementation of the Deque interface, thus also functioning as a queue.
More efficient than LinkedList for add and remove operations at both ends.
Does not permit null elements.
Use Case: Use ArrayDeque when you need a resizable array implementation of a deque (double-ended queue) where you can add or remove elements from both ends. It is ideal for a stack (LIFO) or queue (FIFO) with no capacity restrictions.