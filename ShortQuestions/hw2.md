write your answer to this folder.

## 1.  Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo  repo as example) Encapsulation; Polymorphism; Inheritance; 
```java
class Animal {
    private int weight;

    public Animal(int weight) {
        this.weight = weight;
    }

    //Encapsulation
    public int getWeight() {
        return weight;
    }

    //Encapsulation
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Cat extends Animal{
    public Cat(int weight) {
        super(weight);
    }

    // Polymorphism
    @Override
    public void sound() {
        System.out.println("Meow");
    }
}

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat(10);

        //Inheritance
        System.out.println(cat.getWeight());
    }
}
```

## 2.  What is wrapper class in Java and Why we need wrapper class? 
* Wrapper classes are objects that wrap around primitive data types in Java, for example int -> Integer, double -> Double
* Wrapper classes encapsulate primitive data types, provide useful utility methods such as toString(), and it also provide a way to handle null values.

## 3.  What is the difference between HashMap and HashTable?
|Hashmap|Hashtable|
|  ----  | ----  |
|No method is synchronized.|Every method is synchronized.|
|Multiple threads can operate simultaneously and hence hashmap's object is not thread-safe.|At a time only one thread is allowed to operate the Hashtable's object. Hence it is thread-safe.|
|Threads are not required to wait and hence relatively performance is high.|It increases the waiting time of the thread and hence performance is low.|
|Hashmap|Hashtable|
|Null is allowed for both key and value.|Null is not allowed for both key and value. Otherwise, we will get a null pointer exception.|

## 4.  What is String pool in Java and why we need String pool? 
* String pool is a special memory region in Java where String literals are stored.
* Memory Efficiency, Reduced Garbage Collection

## 5.  What is Java garbage collection?
* Java garbage collection is the process by which Java programs perform automatic memory management.

## 6.  What are access modifiers and their scopes in Java? 
* Default: visible within the same package.
* Public: available everywhere.
* Private: accessible from the same class only.
* Protected: accessible from the same package, as well as from all subclasses of its class.

## 7.  What is final key word? (Filed, Method, Class)
* Final Classes: Classes marked as final can't be extended.
* Final Method: Methods marked as final cannot be overridden.
* Final Variables: Variables marked as final can't be reassigned.

## 8.  What is static keyword? (Filed, Method, Class). When do we usually use it?
* Static Field: Exactly a single copy of that field is created and shared. Used when the value is supposed to be shared across all objects
* Static Method: A static method belongs to the class rather than any instance of the class. It can be called without creating an instance of the class. Used to access/manipulate static variables and other static methods that don't depend upon objects.
* Static Class (Nested Class): A static nested class is a static member of the outer class. It can be accessed without an instance of the outer class and cannot access non-static members of the outer class. Usually used to group classes that will only be used in one place.

## 9.  What is the differences between overriding and overloading?
* Method Overriding is a Run time polymorphism. In method overriding, the derived class provides the specific implementation of the method that is already provided by the base class or parent class.
* Overloading is a Compile time polymorphism. In method overloading, more than one method shares the same method name with a different signature in the class.

## 10.  What is the differences between super and this?
* Super keyword is used to access methods of the parent class while this is used to access methods of the current class.

## 11.  What is the Java load sequence?
* static block -> check values of static variables -> constructor

## 12.  What is Polymorphism ? And how Java implements it ?
* The word "polymorphism" means "many forms," and it refers to the ability of different classes to be treated as instances of the same class through inheritance. Java: Method Overloading, Method Overriding, Inheritance, Interfaces.

## 13.  What is Encapsulation ? How Java implements it? And why we need encapsulation? 
* Encapsulation is one of the fundamental principles of OOP. It refers to the bundling of dat and methods that operate on that data into a single unit or class. Encapsulation also involves restricting direct access to some of an object's components, which is a means of preventing unintended interference and misuse of the data. JAVA: private, getter and setter. Why: 1. Control Access to Data 2. Improve Code Maintainability 3. Enhance Data Integrity

## 14.  What is Interface and what is abstract class? What are the differences between them?
*  An abstract class is a class that cannot be instantiated and can contain both abstract and non-abstract methods. An interface, on the other hand, is a contract that specifies a set of methods that a class must implement.
* Method implementation: In an abstract class, some methods can be implemented, while others are left abstract, meaning that they have no implementation and must be overridden by concrete subclasses. In contrast, all methods in an interface are by default abstract and must be implemented by any class that implements the interface.
* Inheritance: A class can inherit from only one abstract class, but it can implement multiple interfaces. This is because an abstract class represents a type of object, while an interface represents a set of behaviors.
* Access modifiers: Abstract classes can have access modifiers such as public, protected, and private for their methods and properties, while interfaces can only have public access.
* Variables: An abstract class can have member variables, while an interface cannot.

## 15.  design a parking lot (put the code to codingQuestions/coding1 folder, )
[ParkingLot.java](../Coding/coding1).
## 16.  What are Queue interface implementations and what are the differences and when to use what?
* The Queue interface is present in java.util package and extends the Collection interface is used to hold the elements about to be processed in FIFO(First In First Out) order.

|Class|Base data structure|Thread-safe?|Blocking/non-blocking|Fairness policy|Bounded/unbounded|Iterator type|
| --- | --- | --- | --- | --- | --- | --- | --- |
|ConcurrentLinkedQueue|Linked list|Yes (optimistic locking through compare-and-set)|Non-blocking|-|Unbounded|Weakly consistent|
|PriorityQueue|Min-heap(stored in an array)|No|Non-blocking|-|Unbounded|Fail-fast|
|LinkedBlockingQueue|Linked list|Yes(pessimistic locking with two locks)|Blocking|Not available|Bounded|Weakly consistent|
|ArrayBlockingQueue|Array|Yes(pessimistic locking with one lock)|Blocking|Optional|Bounded|Weakly consistent|
|PriorityBlockingQueue|Min-heap(stored in an array)|Yes(pessimistic locking with one lock)|Blocking(nur dequeue)|Not available|Unbounded|Weakly consistent|
|DelayQueue|Priority queue|Yes(pessimistic locking with one lock)|Blocking(nur dequeue)|Not available|Unbounded|Weakly consistent|
|SynchronousQueue|Stack(implemented with a linked list)|Yes(optimistic locking through compare-and-set)|Blocking|Optional|Unbounded|The iterator is always empty.|
|LinkedTransferQueue|Linked list|Yes(optimistic locking through compare-and-set)|Blocking(only transfer and dequeue)|Not available|Unbounded|Weakly consistent|
