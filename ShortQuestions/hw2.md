# Homework 2

## 1. Example code demonstrating OOP concepts

### 1.1 Encapsulation
Encapsulation is the concept of wrapping data (variables) and code (methods) together as a single unit and restricting access to some components.

```java
class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println("Animal sound");
    }
}
1.2 Inheritance
Inheritance is a mechanism where a new class inherits properties and behavior from an existing class.
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}
1.3 Polymorphism
Polymorphism allows methods to do different things based on the object it is acting upon.
public class TestPolymorphism {
    public static void main(String[] args) {
        Animal myDog = new Dog("Buddy");
        myDog.makeSound(); // Outputs: Bark
    }
}


2. What is a wrapper class in Java and why do we need wrapper classes?
A wrapper class in Java allows primitive data types to be used as objects. Examples include Integer for int, Character for char, etc. We need wrapper classes because many Java utilities, such as collections, require objects rather than primitives.

3. What is the difference between HashMap and HashTable?
HashMap: Allows one null key and multiple null values, is not synchronized, and is generally faster.
HashTable: Does not allow null keys or values, is synchronized, and is slower due to thread safety.
4. What is String pool in Java and why do we need String pool?
The String pool is a special memory region for storing String literals. When a new String is created, the JVM checks the pool for an existing instance and returns a reference if found, otherwise adds the new String to the pool. This conserves memory and improves performance.

5. What is Java garbage collection?
Java garbage collection is an automatic memory management process that removes unused or unreferenced objects from memory, preventing memory leaks and optimizing resource usage.

6. What are access modifiers and their scopes in Java?
public: Accessible from any other class.
protected: Accessible within the same package and subclasses.
default: (no modifier) Accessible only within the same package.
private: Accessible only within the same class.

7. What is the final keyword? (Field, Method, Class)
Field: The value cannot be changed once assigned.
Method: The method cannot be overridden.
Class: The class cannot be subclassed.

8. What is the static keyword? (Field, Method, Class). When do we usually use it?
Field: A static field belongs to the class and is shared among all instances.
Method: A static method belongs to the class and can be called without an instance.
Class: A static class is a nested class that cannot access non-static members of the outer class.
We use static when a member should be shared across all instances or when the behavior does not depend on instance variables.

9. What are the differences between overriding and overloading?
Overriding: Defining a method in a subclass with the same signature as a method in the parent class.
Overloading: Defining multiple methods with the same name but different parameters within the same class.

10. What are the differences between super and this?
this: Refers to the current object instance.
super: Refers to the parent class object.

11. What is the Java load sequence?
The Java load sequence is the order in which the JVM loads and initializes classes and their members:

Static fields and static blocks in the order they are defined.
Instance fields and instance blocks in the order they are defined.
Constructor of the class.

12. What is Polymorphism? And how does Java implement it?
Polymorphism allows objects to be treated as instances of their parent class rather than their actual class. Java implements polymorphism through method overriding (runtime) and method overloading (compile-time).

13. What is Encapsulation? How does Java implement it? And why do we need encapsulation?
Encapsulation is the practice of bundling data and methods that operate on the data into a single unit and restricting access to some components. Java implements encapsulation using access modifiers (private, protected, public). Encapsulation is needed to protect the internal state of an object and provide controlled access.

14. What is Interface and what is Abstract Class? What are the differences between them?
Interface: A reference type that can contain only constants, method signatures, default methods, static methods, and nested types. Methods are abstract by default.
Abstract Class: A class that cannot be instantiated and can have both abstract and concrete methods.
Differences:
Interfaces cannot have instance fields or constructors, whereas abstract classes can.
A class can implement multiple interfaces but can inherit only one abstract class.

15. Design a parking lot
class Vehicle {
    private String licensePlate;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}

class ParkingSpot {
    private Vehicle vehicle;
    private boolean isOccupied;

    public ParkingSpot() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (!isOccupied) {
            this.vehicle = vehicle;
            this.isOccupied = true;
            return true;
        }
        return false;
    }

    public boolean removeVehicle() {
        if (isOccupied) {
            this.vehicle = null;
            this.isOccupied = false;
            return true;
        }
        return false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

class ParkingLot {
    private List<ParkingSpot> spots;
    public ParkingLot(int numberOfSpots) {
        spots = new ArrayList<>(numberOfSpots);
        for (int i = 0; i < numberOfSpots; i++) {
            spots.add(new ParkingSpot());
        }
    }
    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                return spot.parkVehicle(vehicle);
            }
        }
        return false; 
    }
    public boolean removeVehicle(String licensePlate) {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && spot.getVehicle().getLicensePlate().equals(licensePlate)) {
                return spot.removeVehicle();
            }
        }
        return false; 
    }
    public void displayParkingLot() {
        for (int i = 0; i < spots.size(); i++) {
            ParkingSpot spot = spots.get(i);
            System.out.println("Spot " + i + ": " + (spot.isOccupied() ? "Occupied" : "Available"));
        }
    }
}


16. What are Queue interface implementations and what are the differences and when to use what?
LinkedList: Implements Queue, allows null elements, and is not synchronized. Use when you need a general-purpose queue with frequent insertions and deletions.
PriorityQueue: Implements Queue, does not allow null elements, and orders elements based on their natural ordering or a comparator. Use when you need a priority-based ordering of elements.
ArrayBlockingQueue: Implements BlockingQueue, does not allow null elements, and is thread-safe. Use when you need a fixed-size queue with thread-safe operations.
ConcurrentLinkedQueue: Implements Queue, allows null elements, and is thread-safe. Use when you need a non-blocking thread-safe queue.
LinkedBlockingQueue: Implements BlockingQueue, does not allow null elements, and is thread-safe. Use when you need a queue with optionally bounded capacity and thread-safe





