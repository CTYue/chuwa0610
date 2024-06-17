# HW2

1. **Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)**
    
    1. Encapsulation
    
    ```java
     class Human {
        private String name;
        private int age;
        private Long ssn;
    
        public Human(String name, int age, Long ssn) {
            this.name = name;
            this.age = age;
            this.ssn = ssn;
        }
    
        public void walk() {
            System.out.println("Walking");
        }
    
        public void work() {
            System.out.println("Working");
        }
    
        public void eat() {
            System.out.println("Eating");
        }
    }
    ```
    
    2. Polymorphism
    
    ```java
    class Programmer extends Human {
          private String language;
          private String editor;
    
          public Programmer(String name, int age, Long ssn, String language, String editor) {
              super(name, age, ssn);
              this.language = language;
              this.editor = editor;
          }
    
          @Override
          public void work() {
              System.out.println("Programming");
          }
      }
      class Cooker extends Human {
          private String cuisine;
          private String dish;
    
          public Cooker(String name, int age, Long ssn, String cuisine, String dish) {
              super(name, age, ssn);
              this.cuisine = cuisine;
              this.dish = dish;
          }
    
          @Override
          public void work() {
              System.out.println("Cooking");
          }
      }
    ```
    
    3. Inheritance
    
    ```java
    Programmer programmer = main.new Programmer("Jane", 25, 987654321L, "Java", "IntelliJ");
    programmer.walk();
    programmer.work();
    programmer.eat();
    ```
    
2. **What is wrapper class in Java and Why we need wrapper class**?
    
    Wrapper class can represent primitive data types as objects, which is used to offers methods and functions that are not available for primitive data types, such as extending the function to work with collection framework, Math operations eg add(), subtract() etc,  comparison methods eg equals(), compareTo().
    
3. **What is the difference between HashMap and HashTable?**
    
    HashMap is not thread safe, HashTable is thread safe. All methods in HashTables are synchronized, which means only one thread can access the map at a time. 
    
    HashMap allows null key and null values, HashTable don’t allow null key or values. HashMap is generated faster than HashTables.
    
4. **What is String pool in Java and why we need String pool?**
    
    If we don’t use new keyword to create string, eg
    
    ```java
    String str1 = "Hello";
    ```
    
    The JVM will first checks the String pool to see if the string already exists, if a match is found in the pool, the reference to the existing string is returned, which will save memory. If there is no match, JVM will create a new object. If we use new keywords, the constructor always create new objects.
    
5. **What are access modifiers and their scopes in Java**?
    
    The keywords define the visibility and accessibility of class methods, fields and constructors. The “Public” means it is accessible from anywhere in the program. “Private” means it only accessible within the class where it’s declared. “Protected” means it accessible from within the class where it’s declared, as well as the sub classes.
    
6. **What is final key word? (Filed, Method, Class)**
    
    The final keyword can be used on variables, methods, and classes. As final variables, once it is initialized, it’s value cannot be changed. As final methods, it can not be overridden by subclasses in inheritance, it can not be extended by other classes. 
    
7. **What is static keyword? (Filed, Method, Class). When do we usually use it?**
    
    The static keyword is used to defined class level members. It can not be modified by object since it’s class level. We can use Static to define the method which should only be created once, such as database connection method, and we can use static to define the class which do not need instance such as MathUtils.
    
8. **What is the differences between overriding and overloading?**
    
    Overriding means a subclass redefines a method inherited from its parent class. The method signature remains the same, but the subclass provides it’s own implementation. The overloading means a class has multiple methods with the same name but different parameter list.
    
9. **What is the differences between super and this?**
    
    Super is used to access methods, fields and constructors of the immediate parent, this refers to the current object of the class, it’s used to access the current object’s methods and fields. This used to distinguished between instance and local variables. 
    
    eg super.makeSound() call parent method,
    
     [this.name](http://this.name) = name means assign value to this object’s name property.
    
10. **What is the Java load sequence?**
    1. static variable initialization and Class loading
        
        Static variables are declared using static keyword, and class is loaded into memory by JVM.
        
    2. static block initialization
        
        Static block executes.
        
    3. object creation and constructor execution
        
        When we create an object using new, the constructor of class is invoked, after constructor execution, JVM will initializing an instance of class which is ready to be used.
        
11. **What is Polymorphism ? And how Java implements it ?**
    
    Polymorphism enables us to create a series of object which has same structure but different implementations. Every java class has a method table which contains all the methods declared in that class and its superclasses, each entry in the method table points to a method object. 
    
    When a method is called, The JVM will first searches the method table to find the method entry. If found, it directly uses the method object pointed to by that entry. If not found, it searches the method tables of parent classes up the inheritance chain until it finds a matching entry.
    
12. **What is Encapsulation ? How Java implements it? And why we need encapsulation?**
    
    Java provides access modifiers(public, private, protected) to control access to class members. JVM uses access modifiers to verify bytecode and potentially throw exceptions if code attempts to directly access private fields.
    
13. **What is Interface and what is abstract class? What are the differences between them?**
    
    The common part of interface and abstract class is they are all blueprints, which does provide any implementation of those methods and they can not be instantiated. 
    
    The difference is abstract class provide an abstract concept a collections of objects, such as Animal class gives a concept of all kinds of animals, including cat, dog, rabbit etc. The interface provides a pattern of a feature which can be used in many objects, such as Shape interface, Circle class, Square class all has Shape feature.
    
14. **What are Queue interface implementations and what are the differences and when to use** 
    
    There are several implementations in Java, eg
    
    LinkedList, ArrayDeque, PriorityQueue, ConcurrentLinkedQueue..
    
    - For frequent insertions/removals from the beginning or end and large datasets, use LinkedList.
    - For flexibility with insertions/removals from both ends and random access, use ArrayDeque.
    - For prioritizing elements in the queue, use PriorityQueue.
    - For concurrent access in multithreaded environments, use ConcurrentLinkedQueue.