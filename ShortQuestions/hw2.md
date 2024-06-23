## 1.Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)


### Encapsulation
```java
public class Person{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getname(){
        return this.name;
    }

    public int getage(){
        return this.age;
    }
    public void setname(String name){
        this.name = name;
    }
    public void setage(int age){
        this.age = age;
    }
    public void displayInfo(){
      System.out.println("Name: " + this.getname()+ "\nAge: " + this.getage());
    }
}

```

### Inheritance (extends Above class)
```java
public class Student extends Person{
    private String course;
    public Student(String name, int age, String course){
        super(name, age);
        this.course = course;
    }
    public String getcourse(){
        return this.course;
    }
    public void setcourse(String course){
        this.course = course;
    }
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Course: " + this.getcourse());
    }
}
```

### Polymorphism (same function name with different implementation and class)
```java
class Animal{
    public void animalSound(){
        System.out.println("The animal sound");
    }
}
class Dog extends Animal{
    public void animalSound(){
        System.out.println("The dog sound");
    }
}
class Cat extends Animal{
    public void animalSound(){
        System.out.println("The cat sound");
    }
}

```



##  2.What is wrapper class in Java and Why we need wrapper class?
- wrapper class is an object representation of a primitive data type, for example: Int -> Integer
- we can use with collection framework like ArrayList, HashMap.
- we can convert from one type to another Type Conversion
- we can have Null Values with wrapper class.


## 3.What is the difference between HashMap and HashTable?
  | Feature                   | HashMap                                 | Hashtable                              |
  |---------------------------|-----------------------------------------|----------------------------------------|
  | Synchronization           | Not synchronized                        | Synchronized                           |
  | Thread-Safe               | No                                      | Yes                                    |
  | Null Keys and Values      | Allows one `null` key and multiple `null` values | Does not allow `null` keys or `null` values |


## 4.  What is String pool in Java and why we need String pool?
- String pool are area where java stores string literals in heap memory.
- String pool have 1.Memory Efficiency 2.Performance Improvement 3.Immutable Strings

## 5.  What is Java garbage collection?
- Garbage Collection in Java is a process by which the Java Virtual Machine (JVM) automatically identifies and frees up memory that is no longer in use or reachable by the application.

## 6.  What are access modifiers and their scopes in Java?
- Access modifiers in Java are keywords that determine the visibility and accessibility of classes, methods, constructors, and variables. 
- Like : Protected, Public, private, default with no keyword

## 7.  What is final key word? (Filed, Method, Class)
- The final keyword in Java is used to denote constants, prevent inheritance, and restrict method overriding.

## 8.  What is static keyword? (Filed, Method, Class). When do we usually use it?
- The static keyword in Java is used to indicate that a particular member belongs to the class itself, rather than instances of the class.

## 9.  What is the differences between overriding and overloading?
| Feature                     | Overriding                                                                 | Overloading                                                             |
|-----------------------------|-----------------------------------------------------------------------------|-------------------------------------------------------------------------|
| Definition                  | Subclass provides a specific implementation of a method already defined in its superclass | Multiple methods in the same class with the same name but different parameters |
| Class Involvement           | Involves a superclass and a subclass                                        | Involves only one class                                                 |
| Method Signature            | Must be exactly the same as the method in the superclass                    | Must have different parameter lists (type, number, or both)             |
| Return Type                 | Must be the same or covariant                                               | Can be different                                                        |
| Polymorphism                | Runtime polymorphism (dynamic binding)                                      | Compile-time polymorphism (static binding)                              |
| Annotations                 | `@Override` annotation is recommended                                       | No specific annotation                                                  |
| Purpose                     | To provide a specific implementation of a method defined in a superclass    | To perform similar operations with different inputs                     |


## 10.  What is the differences between super and this?
| Feature                     | super                                            | this                                 |
|-----------------------------|--------------------------------------------------|--------------------------------------|
| Reference                   | Refers to the immediate superclass object        | Refers to the current class instance |
| Usage                       | Access superclass methods, fields, and constructors | Access current class etc..           |
| Method Invocation           | Calls superclass methods                         | Calls current class methods          |
| Constructor Invocation      | Calls superclass constructors                    | Calls current class constructors     |
| Accessing Fields            | Access superclass fields                         | Access current class fields          |


## 11.  What is the Java load sequence?
- Java load sequence is the order of how each components of a Java class are initialized and loaded into memory when a Java application starts.

## 12.  What is Polymorphism ? And how Java implements it ? 
- The word "polymorphism" means "many different forms," and it enables a single interface to be used for a general class of actions.  
- For example, the methods below have the same name but different parameters:
```java
void display(int num) {
        System.out.println("Display method with integer: " + num);
    }

    void display(String message) {
        System.out.println("Display method with string: " + message);
    }
```

## 13.  What is Encapsulation ? How Java implements it? And why we need encapsulation? 
- The word "encapsulation"  involves restricting direct access to some of the object's components, making the internal representation of an object hidden from the outside.
- For example, I can make a variable in the parent class private, which means it can only be accessed within that class and not by any of its subclasses.

## 14.  What is Interface and what is abstract class? What are the differences between them?
- Interface are used to specify a set of methods that one or more classes are expected to implement.
- An abstract class in Java is a class that cannot be instantiated on its own and is meant to be subclassed.

| Feature                     | Interface                                  | Abstract                         |
|-----------------------------|--------------------------------------------|----------------------------------|
| Constructors                | Can Not have                               | Can have                         |
| Inheritance                 | A class can implement multiple interfaces  | A class can extend only one abstract class       |
| Access Modifiers            | Methods are implicitly public              | Can have any access modifier      |
| Multiple Inheritance        | Supports multiple inheritance              | Does not support multiple inheritance |



## 16.  What are Queue interface implementations and what are the differences and when to use what?
- The LinkedList class implements both the List and Queue interfaces. It provides a doubly linked list implementation.
- The PriorityQueue class provides a priority heap, where elements are ordered based on their natural ordering or by a Comparator provided at queue construction time.
- The ArrayDeque class provides a resizable-array implementation of the Deque interface. It can be used both as a stack and a queue.

