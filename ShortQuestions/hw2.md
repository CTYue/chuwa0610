# HW2
## 1.  Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)
```
class Car{
    //Encapsulation=======================================================
    private int numOfDoors;
    public int getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(int numOfDoors) {
        this.numOfDoors = numOfDoors;
    }
    //====================================================================

    void printInfo(){
        System.out.println("This vehicle is a car");
    }

    public void printMakeInfo(){
        System.out.println("Unbranded car");
    }

}
//Inheritance=======================================================
class Toyota extends Car{
//==================================================================


    // Polymorphism================================================
    @Override
    public void printMakeInfo() {
        System.out.println("This is a toyota");
    }
    //==============================================================
}
public class Main {

    public static void main(String[] args) {
        Toyota t = new Toyota();
        t.printMakeInfo();
        // Inheritance===============================================
        t.printInfo();
        //====================================================================

    }
    
}
```
## 2.  What is wrapper class in Java and Why we need wrapper class?
- Wrapper classes are classes that encapsulates primitive types. For example ___int->Integer___, ___byte-> Byte___.
- Primitive types are not objects. Wrapper classes allows us to use primitive types as objects.
## 3.  What is the difference between HashMap and HashTable?
### HaseMap:
- Non-synchronized, problems could rise when shared with multiple threads.
- Allows a null key and multiple null values.
- Faster compare to HashTable.
- Traversed by Iterator.
### HashTable
- Synchronized, safe to share with different threads.
- Does not allow null key or values.
- Slower compare to HashMap.
- Traversed by Enumerator and Iterator.
## 4.  What is String pool in Java and why we need String pool?
String pool is part of the heap that stores strings when they are created(via String xxx). It does not contain any duplicate String, which means different variables that calls the same string will point to the same string in the heap.\
String pool makes Java more memory efficient. Since strings are also immutable, it also ensures all strings cannot be modified.
## 5.  What is Java garbage collection?
It's a process where Java performs automatic memory management. When objects are no longer needed, the garbage collector finds and frees those memory.
## 6.  What are access modifiers and their scopes in Java?
### Default
Can be accessed within the same package
### Private
Can only e accessed within the same class
### Protected
Can be accessed with in the same package and all children classes
### Public
Can be accessed anywhere
## 7.  What is final key word? (Field, Method, Class)
### Variables
Final makes variables constants that cannot be changed.
### Methods
Final makes methods not able to be overridden.
### Classes
Final makes classes not able to be inherited. It also makes the class immutable.
## 8.  What is static keyword? (Field, Method, Class). When do we usually use it?
### Variables
Static makes the variables only one instance for the class. We use it when we only want one instance of a field for the whole class
### Methods
Static makes methods can be called using class name. We use them to create tool methods.
### Classes
Static makes a inner class nested and can be called without creating an object of that static class. We use it for tool class for easy access.
## 9.  What is the differences between overriding and overloading?
### Override
- Dynamic polymorphism
- Completed at run time
- Needs children class
- The same method in children class behaves differently than parent's
- Less performance compare to Overload
- Cannot override final methods
- ### Overload
- Static polymorphism
- Completed at compiler time
- Can be done in the same class
- The same method in the class that takes in different arguments
- Better performance compare to Override
- Can overload final methods
## 10.  What is the differences between super and this?
- "this" refers to the current object
- "super" refers to the immediate parent object
## 11.  What is the Java load sequence?
- Loading: Delivers the binary data to JVM
- Linking: Verify the class is properly formed, then transfer symbolic reference in the constant pool into data reference. 
- Initialising: Class variables are given their initial value.
## 12.  What is Polymorphism ? And how Java implements it ?
Polymorphism means methods can take different forms. In Java, it is done with override and overload.\
Override allows the same method in the children class to behave differently, while overload allows the same method to take in different parameters.
## 13.  What is Encapsulation ? How Java implements it? And why we need encapsulation?
Encapsulation is the idea that variables are hidden inside the class and can only be accessed with methods from the class\
In Java, variables of an object is encapsulated inside a class. Non-public variables can only be accessed through getters and setters.\
We need encapsulation for better control, and better security of the data.
## 14.  What is Interface and what is abstract class? What are the differences between them?
### Interface
A contract that specifies a set of method that a class must implement.
- Contains only abstract methods
- Variables are either final or static\
- Use "implement"
- Can extend other interfaces
### Abstract Class
A class that cannot be instantiated, and can contain both abstract and non-abstract method.
- Contains abstract and non-abstract methods
- Variables can be static/non-static, final/non-final
- Use "extends"
- Can extend other classes and implement other interfaces
## 15.  design a parking lot (put the code to codingQuestions/coding1 folder)
See codingQuestions/coding1.
## 16.  What are Queue interface implementations and what are the differences and when to use what? 
Queue interface is implemented by Priority Queue, Linked List, Priority Blocking Queue, etc.
### Priority Queue
- Elements in priority queue are maintained to be sorted.
- We can use priority queue when we need to keep and process in coming tasks in order.
### Linked List
- A linear structure where each node knows where the next node is.
- We can use it as a basic queue when we want to process tasks in FIFO order
### Priority Blocking Queue
- Same as priority queue but thread-safe
- We can use it when we want to share this priority queue among different threads