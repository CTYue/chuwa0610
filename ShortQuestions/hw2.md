# Homework2

## Yirun Wang

### 1. Write up Example code to demostrate the three foundmental concepts of OOP.
- Encapsulation
```
public class Person {
    private String first_name;
    private String last_name;
    private int number;
    
    public Person(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return first_name + " " + last_name;
    }

    public int getNumber() {
        return number;
    }
}
```
- Polymorphism & Inheritance
```
public class Employee extends Person{
    private String title;
    private Date hire_date;

    public Employee(String first_name, String last_name){
        super(first_name, last_name);
    }

    public Employee(String first_name, String last_name, String title, Date hire_date) {
        super(first_name, last_name);
        this.title = title;
        this.hire_date = hire_date;
    }

    @Override
    public String getName() {
        return title + " - " + super.getName();
    }
    // skip all the getter and setter here
}
```
### 2. What is wrapper class in Java and Why we need wrapper class?
A wrapper class encapsulates a primritive data type in an object. Wrapper classes are final and immutable. 
1. Some collection frameworks, like ArrayList and HastMap, don't support primtive data types. They only work with objects.
2. Methods for data manipulation: Wrapper classes provides methods data conversion. Like parseInt(), parseDouble, toString().
3. Null values: Objects can be assigned to a null value while primitive data types can not.
4. Wrapper class objects are immutable, meaning their values cannot be changed once created.

### 3. What is the difference between HashMap and HashTable?
1. HashMap is not synchronized, it is not thread safe. While HashTable is thread-safe. Its methods are synchroized. But HashMap performance better in non-threaded applications.
2. HashMap allows null as key and values. HashTable doesn't allow null keys or values.
3. HashMap only uses Interator, while HashTable uses Iterator and Enumeration.
4. HashMap extends AbstractMap, HashTable extends Dictionary.
5. They used different hash methods.

### 4. What is String pool in Java and why we need String pool?
Stringpool is a storage space in the Heap memory where stores stirng iterals. When a string literal is created, Java checks the pool for existing identical string. If found, it returns a reference to the instance. If not, it will add a new string to the pool.
It saves memory by resuing memory for identical strings.
Enhances performance in scenarios with many repetitive string values.

### 5. What is Java garbage collection?
Java garbage collection is an automatic memory management process. When Java programs run on the JVM, objects will be created on the heap. Eventually, some objects will no longer be needed. The garbage collector will find the unused objects and delete them to free up memory resources.

### 6. What are access modifiers and their scopes in Java?
- public: accessible from any classes
- private: only within the class
- protected: classes in the same package, and by subclasses(even in different packages)
- default: classes in the same package

### 7. What is the final keyword?
Can be used to describe variable, method and class.
- final variables: can't be modified. Constants.
- final methods: can't be override by a subclass.
- final classes: can't be extend by a subclass.

### 8. What is static keyword?
Static is used to declare memebers that belong to the class itself, rather than instances.
- static variables: shared among all instances of the class. Initialized only once at the start of execution, and remain in the memory until the program ends. Can be accessed directly by class name.
- static methods: belong to the class. Can be accessed directly by class name. Static methods can only access other static variables or methods.
- static classes: a class can be made static only it's a nested class. Static nested classes do not have access to instance variables and methods of the outer class directly. They can only access static members.
- static blocks: it will only run once when the class is loaded into memory.

### 9. What is the differences between overriding and overloading?
Override: a method in the subclass that has the same name, parameters, and return type as the method in its superclass. It provides a specific implementation of the method.
Overload: with the same method names in the same class, but different parameter types or number. Simply with different return types is not allowed.

### 10. What is the differences between super and this?
The super keyword is used to access superclass methods, constructors, and instance variables from within a subclass. 
This refers to the current instance of a class. This can be used to differentiate between instance varivale and parameters.

### 11. What is the Java load sequence?
1. superclass's static variables/blocks/methods.
2. current class's static variables/blocks/methods.
3. superclass's variables amd blocks.
4. superclass's constructor.
5. current class's variables and blocks.
6. current class's constructor.

### 12. What is Polymorphism? And how Java implements it?
Polymorphism is objects of different classes to be treated as objects of a common superclass through inheritance. 
There are two types: complie-time or static, achieved by overloading, where multiple methods have the same method names but different parameters.
run-time or dynamic, achieved through overriding, where a subclass provides a specific implementation of a method defined in its superclass.

### 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
Encapsulation hides the internal state of objects and restricting direct access to them from outside the class. To achieve, declare class variables/attributes as private, and provide public get and set methods to access and update the value of a private variable.

- We need encapsulation to prevents direct access from outside the class to improve maintainability.
- Encapsulation allows the internal implementation details of a class to be hidden, exposing only the necessary parts through a well-defined interface. This simplifies the complexity of interacting with objects.

### 14. What is Interface and what is abstract class? What are the differences between them?
Interface is like a template or blueprint that specifies the methods a class must implement.
Abstract class is a class that can't be instantiated and can contain both abstract and non-abstract methods.

- Interfaces will be implemented, abstract class will be extended.
- A subclass and implement multiple interfaces, but extends only one abstract class.
- Interface contains only method signatures, constants, default methods, static methods, and nested types. Abstract class can have methods with body.It can have constructors and instance variables.

# 16. What are Queue interface implementations and what are the differences and when to use what?
Queue interface represents a collection for holding elements prior to processing which follows the Firt-In-First-Out principle. Elements are inserted at the end of the queue and removed from the beginning.

- LinkedList:
    Double-linked list. 
    Efficient for add and remove operations from both ends.
    Allows null.
    -> general purpose
    -> insert and remove from both ends of the list
- PriorityQueue:
    Priority heap.
    Elements are order based on natural ordering or Comparator.
    Efficient for accessing and removing the head element with peek(), poll().
    Doesn't allow null.
    -> we need priority or ordering
    -> need elements to be ordered automatically according to their priority
- ArrayDeque:
    Resizable-array implementation.
    Efficient for add and remove from both ends.
    Allows null.
    -> for implementing stacks or queues where elements are added and removed from both ends.
