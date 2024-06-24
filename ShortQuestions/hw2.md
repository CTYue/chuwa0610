# HW2

## 1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example: 1. Encapsulation; 2. Polymorphism; 3. Inheritance;)
1. **Encapsulation**:
   ```
   public class BankAccount {  
        private String accountNumber;  
        private double balance;  
      
        public BankAccount(String accountNumber, double initialBalance) {  
            this.accountNumber = accountNumber;  
            this.balance = initialBalance;  
        }  
      
        public void deposit(double amount) {  
            if (amount > 0) {  
                balance += amount;  
                System.out.println("Deposited: " + amount + ". New balance: " + balance);  
            } else {  
                System.out.println("Deposit amount must be positive.");  
            }  
        }  
      
        public boolean withdraw(double amount) {  
            if (amount > 0 && amount <= balance) {  
                balance -= amount;  
                System.out.println("Withdrawn: " + amount + ". New balance: " + balance);  
                return true;  
            } else {  
                System.out.println("Withdrawal failed: insufficient funds or invalid amount.");  
                return false;  
            }  
        }  
      
        public double getBalance() {  
            return balance;  
        }  
   }
2. **Polymorphism**
   ```
   public class Animal {  
      public void Sound() {  
          System.out.println("sound from animal");  
      }  
   }
   
   public class Dog extends Animal {  
      @Override  
      public void Sound() {  
          System.out.println("sound from dog");  
      }  
   }
   
   public class Main {  
      public static void main(String[] args) {  
          Animal animalDog = new Dog();  
          animalDog.Sound(); 
      }  
   }
3. **Inheritance**
   ```
   public class Vehicle {  
      protected String make;  
      protected String model;  
    
      public Vehicle(String make, String model) {  
          this.make = make;  
          this.model = model;  
      }  
    
      public void startEngine() {  
          System.out.println("The engine is started.");  
      }  
   }  
  
   public class Car extends Vehicle {  
      private String color;  
    
      public Car(String make, String model, String color) {  
          super(make, model); 
          this.color = color;  
      }  
    
      public void honk() {  
          System.out.println("The horn honks.");  
      }  
   }  
   
   public class Main {  
      public static void main(String[] args) {  
          Car myCar = new Car("Toyota", "Camry", "Red");  
          myCar.startEngine(); 
          myCar.honk(); 
          System.out.println("Make: " + myCar.make + ", Model: " + myCar.model + ", Color: " + myCar.color);  
      }  
   }

# 2. What is wrapper class in Java and Why we need wrapper class?
In Java, wrapper classes are special classes that provide a way to represent primitive data types as objects. Wrapper classes are:
- Byte for byte
- Short for short
- Integer for int
- Long for long
- Float for float
- Double for double
- Character for char
- Boolean for boolean
  
Advantages:
  - Object-Oriented Programming (OOP): In Java, everything is an object, except for the primitive data types.
Wrapper classes allow us to treat primitive types as objects, enabling us to use methods and inheritance with them.
  - Collections: Java's collection framework, such as ArrayList, HashSet, and HashMap, can only store objects.
Wrapper classes allow us to store primitive types in these collections.
  - Utility Methods: Wrapper classes provide useful utility methods for their respective primitive types. For example, the Integer class has methods like parseInt(), toHexString(), etc.
  - Serialization: Primitive types cannot be serialized directly, but their wrapper classes can be. This allows us to store and retrieve primitive data types from files or databases.
  - Null Values: Wrapper classes can have a null value, while primitive types cannot. This can be useful in certain scenarios where a value may or may not be present.

# 3. The difference between HashMap and HashTable in Java can be summarized as follows:
1. Data Structure and Implementation:
   - Both HashMap and HashTable are implemented based on the hash table data structure.
   - HashMap uses an array combined with linked lists or red-black trees (in Java 8 and later) to handle collisions.
   - HashTable uses an array and linked lists to resolve collisions. 
2. Thread Safety:
   - HashMap is not thread-safe. Multiple threads access and modify a HashMap concurrently, it may lead to incorrect results or ConcurrentModificationException.
   - HashTable is thread-safe. Multiple threads can access and modify it concurrently without causing such issues.
3. Null Keys and Null Values:
   - HashMap allows null keys and null values.
   - HashTable does not permit null keys or null values.
5. Performance:
   - Due to its non-synchronized nature, HashMap generally offers better performance in single-threaded environments.
   - HashTable, being synchronized, has a performance overhead but is suitable for multithreaded environments without external synchronization.
7. Initial Capacity and Load Factor:
   - The default initial capacity of a HashMap is 16, with a load factor of 0.75.
   - HashTable has a default initial capacity of 11 and a load factor of 0.75.
9. Hashing Technique:
    - HashMap applies a secondary hash function to the key's hashCode to reduce collisions and improve the distribution of elements within the internal array.
    - HashTable uses a simpler hashing approach, directly using the key's hashCode modulo the table size.

# 4. What is String pool in Java and why we need String pool?
1. What is the String Pool?
  - Location: The String pool exists in the **heap memory**, specifically in the StringTable area, which is a dedicated portion of the heap.
  - Content: The String pool primarily contains strings created using double quotes, e.g., "hello", and interned strings (strings that have been explicitly added to the pool using the intern() method).
  - Uniqueness: The String pool ensures that each unique string literal is represented by only one String object. This means that if two string literals have the same content, they will refer to the same String object in the pool.
2. Why need the String Pool?
  - Memory Efficiency: Since string literals and interned strings are stored in the String pool, duplicate strings are not created, which saves memory. 
  - Performance: Comparing strings by their references is faster than comparing their contents.
  - Convenience: The String pool provides a convenient way to share string literals across different parts of the program.

# 5. What is Java garbage collection?
Java garbage collection (GC) is a form of automatic memory management in the Java Virtual Machine (JVM) that aims to reclaim and reuse memory occupied by objects that are no longer needed by the application. 
When an object is no longer referenced (i.e., it is unreachable from any thread of execution or static variable), the JVM considers it eligible for garbage collection.

# 6. What are access modifiers and their scopes in Java?
In Java, access modifiers are keywords that are used to set the accessibility of classes, methods, variables, and constructors. 
They determine the scope or visibility of these entities within the program.
1. public:
  - Scope: Accessible from anywhere in the program, regardless of the package.
  - Usage: Can be used with classes, methods, variables, and constructors.
2. protected:
  - Scope: Accessible within the same package and by subclasses in other packages.
  - Usage: Can be used with classes, methods, variables, and constructors.
3. default (package-private):
  - Scope: Accessible only within the same package.
  - Usage: If no access modifier is specified, the default access modifier is applied. Can be used with classes, methods, variables, and constructors.
4. private:
  - Scope: Accessible only within the class where it is declared.
  - Usage: Can be used with methods, variables, and constructors. Cannot be used with top-level classes.

# 7. What is final key word? (Filed, Method, Class)
1. Final Field (Variable):
  - A final field is a constant variable whose value cannot be changed once it is initialized.
  - For primitive types and String, the value itself cannot be changed.
  - For reference types, the reference cannot be changed to refer to a different object, but the state of the object itself can be modified.
  - Final fields can be initialized either at the point of declaration, in a constructor, or in an instance initializer block.
  - Static final fields (also known as class constants) are typically used to define compile-time constants.
2. Final Method:
  - A final method cannot be overridden by any subclass.
  - This ensures that the behavior of the method remains unchanged in subclasses.
3. Final Class:
  - A final class cannot be extended or inherited by any other class.
  - All methods in a final class are implicitly final, but this does not mean that they cannot be overridden by methods in the same class.

# 8. What is static keyword? (Filed, Method, Class). When do we usually use it?
1. Static Fields (Variables)
- Definition: A static field is a variable that belongs to the class rather than an instance of the class. 
- Storage: Static variables are stored in the method area of the JVM's memory, not the heap where object instances are stored.
- Lifecycle: Static variables are loaded when the class is loaded by the JVM and remain in memory for the entire lifetime of the JVM.
- Access: Static variables can be accessed directly using the class name without creating an instance of the class.
- Usage: We typically use static fields when we want a variable to be shared by all instances of a class or when the variable's value does not depend on the state of any particular object.
2. Static Methods
- Definition: A static method belongs to the class and can be accessed without creating an instance of the class.
- Access: Static methods can be called using the class name directly.
- Restrictions: Static methods cannot access non-static variables or methods directly.
- Usage: We use static methods when the method's logic does not depend on the state of any particular object instance and when we want to provide utility methods that are associated with the class but do not require an object to be created.
3. Static Classes (Nested Static Classes)
- Definition: A static nested class is a nested class that is declared static. It cannot access non-static variables or methods of its enclosing class directly.
- Usage: Static nested classes are typically used when we want to group related classes together but do not want the inner class to have an implicit reference to an instance of the outer class.

# 9. What is the differences between overriding and overloading?
1. **Overloading**
- Definition: Overloading refers to having multiple methods with the same name but different signatures (parameter types, number, or order) within a single class.
- Polymorphism Type: Overloading is a form of compile-time polymorphism.
- Signature Difference: Methods must have at least one difference in their signatures to be considered overloaded. This includes the number of parameters, the types of parameters, or the order of parameters.
- Return Type: The return type of methods can be different in overloading, but it is not part of the signature that determines overloading.
- Access Level: The access level (public, private, protected) of overloaded methods can be different.
- Inheritance: Overloading occurs within a single class and has no direct relationship to inheritance.
2. **Overriding**
- Definition: Overriding refers to having a method in a subclass with the same signature as a method in its superclass. When an object of the subclass is used to call the method, the subclass's version of the method is executed.
- Polymorphism Type: Overriding is a form of runtime polymorphism.
- Signature Match: The signature of the method in the subclass must exactly match the signature of the method in the superclass.
- Return Type: The return type of the method in the subclass must be the same as or a subtype of the return type in the superclass.
- Access Level: The access level of the method in the subclass cannot be more restrictive than the access level in the superclass. 
- Inheritance: Overriding occurs due to inheritance, where a subclass inherits a method from its superclass and provides its own implementation.

# 10. What is the differences between super and this?
1. Usage: **super** is used to access members of the superclass, while **this** is used to access members of the current object.
2. Inheritance: **super** is relevant in the context of inheritance, referring to the parent class, while **this** refers to the current object regardless of inheritance.
3. Constructors: Both **super** and **this** can be used to invoke constructors, but **super** is used to call the parent's constructor, and **this** is used to call another constructor within the same class.
4. Scope: **super** has a limited scope to the superclass, while **this** has a scope to the current object and its members.
5. Syntax: Both use the dot notation (**super.** or **this.**) to access members, but **super** cannot be used to refer to the current object like **this** can.

# 11. What is the Java load sequence?
The Java load sequence typically refers to the order in which classes and their components (such as static variables, instance variables, and initialization blocks) are loaded and initialized by the Java Virtual Machine (JVM). 

# 12. What is Polymorphism ? And how Java implements it?
Polymorphism refers to the ability of different objects to respond to the same message in different ways. In other words, it is the ability to have multiple forms of the same interface or function name, which are executed differently based on the object's type.
In Java, Polymorphism is implemented primarily through two mechanisms, including **overriding** and **overloading**.
Polymorphism in Java enables flexibility (Allows for code reuse and extension through inheritance) and extensibility (Allows subclasses to add or modify behavior without affecting existing code).

# 13. What is Encapsulation? How Java implements it? And why we need encapsulation?
1. Definition:
Encapsulation is a fundamental concept in object-oriented programming that refers to the bundling of data (variables) and the methods that manipulate that data into a single unit called a class. It is a way to hide the internal state and implementation details of an object from the outside world, while providing a controlled interface for accessing and modifying the object's state.

2. Implementation:
Java implements encapsulation primarily through the use of access modifiers and classes.
- Access Modifiers:
Java provides four access modifiers: public, protected, default (package-private), and private.
By declaring variables and methods as private within a class, we hide them from the outside world. This ensures that only the methods within the class can access and modify these variables directly.
- Classes:
Classes are the fundamental building blocks of object-oriented programming in Java.
By grouping related variables and methods into a class, we create a unit of encapsulation.
Only the public methods of a class are accessible to other classes. This allows us to control how other classes interact with the encapsulated data.

3. Advantages:
- Data Hiding:
Encapsulation hides the internal state and implementation details of an object. This makes the code more secure and less prone to errors.
By restricting access to variables, we prevent unauthorized modification of the object's state.
- Abstraction:
Encapsulation allows us to provide a simplified view of the object's state and behavior through the public interface.
This makes it easier for other parts of the code to interact with the object without needing to know its internal details.
- Code Reusability:
By encapsulating related data and methods into classes, we can create reusable components.
These classes can be instantiated and used in multiple parts of the code, promoting code reuse and reducing duplication.

# 14. What is Interface and what is abstract class? What are the differences between them?
**Interface**:
An interface is a contract that specifies a set of methods that a class must implement. 
It is a purely abstract class that cannot be instantiated. An interface defines the behavior that a class must adhere to, but it does not provide any implementation details.

**Abstract Class**:
An abstract class is a class that is declared with the abstract keyword. 
It cannot be instantiated, but it can contain both abstract and non-abstract methods. 
An abstract class is a template for subclasses, providing some implementation details while leaving others to be implemented by subclasses.

**Differences**:
1. Instantiation: Interfaces cannot be instantiated, while abstract classes cannot be instantiated directly but can be subclassed.
2. Method Implementation: All methods in an interface are abstract and have no implementation. Abstract classes can have both abstract and non-abstract methods.
3. Inheritance: A class can implement multiple interfaces, but it can only extend one abstract class.
4. Field Declarations: Interfaces can only contain constant variables (static final), while abstract classes can have instance variables and static variables.
5. Constructors: Abstract classes can have constructors, which are used by subclasses during instantiation. Interfaces cannot have constructors.

# 15. What are Queue interface implementations and what are the differences and when to use what?
Queue interface implementations in Java provide various ways to manage data structures that follow the First-In-First-Out (FIFO) principle.
There are some implemations for Queue interface, including **ArrayDeque**, **LinkedList**, **BlockingQueue**, **Deque**.

Differences:
- ArrayDeque and LinkedList provide general-purpose queue implementations with different performance characteristics.
- BlockingQueue and its subtypes add blocking behavior for concurrent programming.
- Deque allows elements to be inserted and removed from both ends.

When to Use What:
- For general-purpose queues, ArrayDeque is a good default choice due to its balanced performance.
- If you need a queue that can grow dynamically, LinkedList can be used.
- For concurrent programming, BlockingQueue and its subtypes provide thread-safe queue operations with blocking behavior.
- If you need a queue that supports efficient insertion and removal from both ends, use a Deque implementation like ArrayDeque or LinkedList.
