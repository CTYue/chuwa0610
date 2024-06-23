1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo 
   repo as example)

   1. **Encapsulation;**

      ```java
      public class Person{
        private String name;
        private int age;
        
        public String getName(){
          return this.name;
        }
        
        public void setName(String name){
          this.name = name;
        }
        
        public int getAge(){
          return this.age;
        }
        
        public void setAge(int age){
          this.age = age;
        }
      }
      ```

      **Encapsulation** is shown by making the `name` and `age` attributes private and providing public methods to access them.

   2. **Inheritance;**

      ```java
      abstract class Animal {
          protected String name;
      
          public Animal(String name) {
              this.name = name;
          }
      
          public abstract String speak();
      }
      
      class Dog extends Animal {
          public Dog(String name) {
              super(name);
          }
      
          @Override
          public String speak() {
              return "Woof!";
          }
      }
      ```

      **Inheritance** is shown by the `Dog`  class inheriting (extending) from the `Vehicle` class.

   3. **Polymorphism;**

      ```java
      class Bird extends Animal {
          public Bird(String name) {
              super(name);
          }
      
          @Override
          public String speak() {
              return "Chirp!";
          }
      }
      
      ```

      **Polymorphism** is shown by `Bird` and `Dog` classes having implementing the `speak` method in different ways, each producing different behavior.

   

2. What is wrapper class in Java and Why we need wrapper class? 

   - A wrapper class is a class that encapsulates a primitive data type into an object. Each of the eight primitive data types in Java has a corresponding wrapper class.
   - **Reasons**:
     - Java's Collection framework (such as `ArrayList`, `HashSet`, etc.) only works with objects, not primitive data types.
     - Wrapper classes provide various utility methods for conversion, comparison, and other operations.

   

3. What is the difference between HashMap and HashTable?

   |                                  | HashMap                                      | Hashtable                                                   |
   | -------------------------------- | -------------------------------------------- | ----------------------------------------------------------- |
   | Synchronization                  | Not synchronized (not thread-safe)           | Synchronized (thread-safe)                                  |
   | Null Keys and Values             | Allows one null key and multiple null values | Does not allow null keys or values                          |
   | Performance                      | Faster (no synchronization overhead)         | Slower (synchronization overhead)                           |
   | Initial Capacity and Load Factor | Can specify initial capacity and load factor | Default load factor is 0.75, default initial capacity is 11 |

   

4. What is String pool in Java and why we need String pool? 

   - The String pool in Java is a special memory region on the heap where `String` literals are stored. If two variables are assigned the same literal value, they will reference the same literal (same memory location) in the String pool.
   - Reason: It Reduces memory overhead because it avoids storing multiple copies of identical strings.

   

5. What is Java garbage collection?

   JVM automatically frees memory occupied that are no longer referenced. This helps in preventing memory leaks and optimizing the use of available memory. 

   

6. What are access modifiers and their scopes in Java?

   - `private`: The member is accessible only within the same class.
   - `default`: The member is accessible only within classes in the same package.
   - `protected`: The member is accessible within the same package and by subclasses.
   - `public`: The member is accessible from any class.

   

7. What is final key word? (Filed, Method, Class)

   - **Field**: When a variable is declared as `final`, its value cannot be changed once it is initialized. This makes the variable a constant.

   - **Method**: When a method is declared as `final`, it cannot be overridden by subclasses.

   - **Class**: When a class is declared as `final`, it cannot be subclassed.

   

8. What is static keyword? (Filed, Method, Class). When do we usually use it?

   - **Field**: A `static` field is shared among all instances of the class. It belongs to the class rather than to any specific instance. We use it for variables that need to be shared across all instances of a class.

   - **Method**: A `static` method belongs to the class rather than to any specific instance. It can be called without creating an instance of the class. We use if for methods that do not require access to instance variables.

   - **Class**: A `static` class is a static class defined within another class. It can be accessed without creating an instance of the outer class. 

   - **Block**: A `static` block is used for static initializations of a class. It runs when the class is first loaded into memory (before non-static blocks). We use it for performing static initializations with static blocks.

   

9. What is the differences between overriding and overloading?

   | Method Overriding                                       | Method Overloading                                      |
   | ------------------------------------------------------- | ------------------------------------------------------- |
   | Involves inheritance (superclass and subclass)          | Occurs within the same class                            |
   | Same method name, same parameters                       | Same method name, different parameters                  |
   | Must be the same or covariant return type               | Can be different (but not sufficient alone to overload) |
   | Cannot be more restrictive than the superclass method   | No restrictions                                         |
   | Runtime (dynamic) polymorphism                          | Compile-time (static) polymorphism                      |
   | To change or extend the behavior of an inherited method | To provide multiple ways to perform similar operations  |

10. What is the differences between `super` and `this`?

    - `this`: Used within a class to refer to the current instance of the class. 
    - `super`: Used within a subclass to refer to the superclass. It is useful for accessing superclass variables, methods, and constructors.

11. What is the Java load sequence?

    1. Classes are loaded into memory
    2. Static variables and static blocks are initialized.
    3. Instance initialization (construction).

12. What is Polymorphism ? And how Java implements it ?

    - polymorphism refers to the same object exhibiting different forms and behaviors.
    - Java implements:
      - Compile-time Polymorphism (Method Overloading)
      - Runtime Polymorphism (Method Overriding)

13. What is Encapsulation ? How Java implements it? And why we need encapsulation? 

    - Encapsulation in OOP refers to binding the data and the methods to manipulate that data together in a single unit (class).
    - Java implement:
      - **Private Variables**: Declare the variables of a class as `private` to restrict direct access from outside the class.
      - **Public Methods**(Getter ans Setter): Provide `public` getter and setter methods to allow controlled access to the private variables. This way, you can validate the data before assigning it or returning it.

14. What is Interface and what is abstract class? What are the differences between them?

    - Both interfaces and abstract classes are used to achieve abstraction, but they serve different purposes and have different capabilities.

      | Interface                                                    | Abstract Class                                               |
      | ------------------------------------------------------------ | ------------------------------------------------------------ |
      | Can have default and static methods (Java 8 or later)        | Can have both abstract and concrete methods                  |
      | A class can implement multiple interfaces (multiple inheritance) | A class can inherit only one abstract class (single inheritance) |
      | Can only have static final variables (constants)             | Can have instance variables, static variables, and constants |
      | Cannot have constructors                                     | Can have constructors                                        |
      | Only method signatures, no implementation inheritance        | Can have implementation                                      |
      | Methods are implicitly public, cannot be private or protected | Can have any access modifiers for methods and variables      |
      | Interface calls are slower due to the need for lookups       | Abstract class calls are faster                              |
      | Used to define a contract that classes must follow           | Used to share code among several closely related classes     |

15. Design a parking lot (put the code to Coding/coding1 folder)

16. What are Queue interface implementations and what are the differences and when to use what?

    - Implementations:
      - **LinkedList**: Suitable for general-purpose queue operations when the order of elements is important and thread safety is not a concern.
      - **PriorityQueue**: Suitable when elements need to be processed based on priority rather than the order of insertion.
      - **ArrayDeque**: Suitable for general-purpose deque operations when null elements are not required and thread safety is not a concern.
      - **ConcurrentLinkedQueue**: Suitable for high-performance, thread-safe queue operations in a concurrent environment.

​	