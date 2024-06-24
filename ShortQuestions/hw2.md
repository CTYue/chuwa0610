## 1. Write up Example code to demonstrate the three foundmental concepts of OOP

1. Encapsulation
```
   class Student {
      // Private instance variables
      private String name;
      private String studentId;
      private String SSN;

      // Constructor
      public Student(String name, String studentId, String SSN){
         this.name = name;
         this.studentId = studentId;
         this.SSN = SSN;
      }

      public void verfiy(String name, String studentId, String SSN){
         if(this.name.toLowerCase().equals(name.toLowerCase()) &&
            this.studentId.equals(studentId) && 
            this.SSN.equals(SSN)){
               System.out.println("Student Verified");
         } else {
            System.out.println("Invalid Credentials");
         }
      }
   }

   class Encapsulation {
      public static void main(String[] args){
         Student student = new Student("Mike", "12345678", "9876");

         student.verify("MIKE", "12345678", "9876");

         student.verify("mike", "12345", "463049");
      }
   }
```

2. Polymorphism
```
   public class Animal {
      public void Speak() {
         System.out.println("Hello");
      }
   }

   class Human extends Animal {
      private String name;
      
      public Human(String name){
         this.name = name;
      }

      @Override
      public void Speak(){
         super.Speak();
         System.out.println("My name is " + this.name);
      }
   }

   class Dog extends Animal {
      private String name;

      public Dog(String name){
         this.name = name;
      }

      @Override
      public void Speak(){
         System.out.println("Woof");
      }
   }

   public class Main {
      public static void main(String[] args){
         Animal mike = new Human("Mike");
         Animal lucky = new Dog("lucky");

         mike.speak() // This line will print out "Hello My name is Mike"
         lucky.speak() // This line will print out "Woof"
      }
   }
```

3. Inheritance
```
   public class Animal {
      public void Speak() {
         System.out.println("Hello");
      }
   }

   class Human extends Animal {
      private String name;
      
      public Human(String name){
         this.name = name;
      }

      @Override
      public void Speak(){
         super.Speak();
         System.out.println("My name is " + this.name);
      }
   }

   class Dog extends Animal {
      private String name;

      public Dog(String name){
         this.name = name;
      }

      @Override
      public void Speak(){
         System.out.println("Woof");
      }
   }
```

## 2. What is wrapper class in Java and Why we need wrapper class?
Wrapper class allows programmer to use primitive data types as objects. For instance: int -> Integer, double -> Double, char -> Character. 
We need to use wrapper class because we can not use primitive data types in Collections. We need the corresponding wrapper classes to store primitive data types as objects in Collections. Another reason is the support for Null value. Primitive data types can not be set to null. However, objects can be null.

## 3. What is the difference between HashMap and HashTable?
HashMap is non-synchronized, so it is not thread-safe to use HashMap. However, HashTable is synchronized and thread-safe. Null is allowed for both key and value in HashMap, but it is not allowed anywhere in a HashTable. 

## 4. What is String pool in Java and why we need String pool?
String pool is where Java stores String literals at a special memory location in the Java heap. With String pool, string is immutable in Java. Also, it allows Java to be more efficient to deal with Strings.

## 5. What is Java garbage collection?
In Java, objects are created and stored in the heap memory. When those objects are no longer needed or used, JVM finds those objects and destory them to free up the memory space.

## 6. What are access modifiers and their scopes in Java?
Access modifiers help to restrict and define the scope of a class, method, and data members.
- **Default**: Visible only within the package(package private)
- **Private**: Visible within the class only
- **Protected**: Visible within the package or all subclasses
- **Public**: Visible everywhere

## 7. What is final keyword?(Filed,Method,Class)
Final keyword is a non-access modifier in Java for class, method, and varible.
- **Filed**: The value of a final varible cannot be changed once initialized.
- **Method**: The final method cannot be overrided by the subclasses.
- **Class**: The final class cannot be extended and is immutable.

## 8. What is static keyword?(Filed,Method,Class).When do we usually use it?
Static keyword is a non-access modifier in Java that can be used to define a class, method, or varible. We use the static keyword when we want to share the same varibles or methods in a given class.
- **Filed**: The static varible is belong to the class. All instances of the class share a same static varible.
- **Method**: Static method can be used directly with class name. Ex: Math.max().
- **Class**: Static class is nested class

## 9. What is the differences between overriding and overloading?
Method overriding is redefining a parent class's method in a subclass. Method overloading is create a number of method with same method name and different return types, different number/types of arguments. Overloading happends at compile time while overriding happens at runtime.

## 10. What is the differences between super and this?
Super refers to the variables or methods in the parent class. This refers to the variables or methods in the current class.

## 11. What is the Java load sequence?
Java first loads the static varible/block, then the constructors

## 12. What is Polymorphism? And how Java implements it?
Polymorphism refers to the same object exhibiting different forms and behaviors. 
The two mechanisms Java used to implement Polymorphism are:
1. **Static** Polymorphism: **Overload**(same class) in compile time.
2. **Dynamic** Polymorphism: **Override**(child class) in run time.

## 13. What is Encapsulation? How Java implements it? And why we need encapsulation?
Encapsulation refers to binding the data and methods to manipulate the data together in a single unit(class). In Java, encapsulation can be achieved by defining the instance varibles as private and using getter and setter to modify and access them. We need encapsulation to hide the important implementation details and protect the data.

## 14. What is Interface and what is abstract class? What are the differences between them?
Intefaces are used when there is a set of behaviors that all subclasses must support, but the implementation details can vary.
Abstract class are used when there is some common behavior that all subclasses must share.

## 16. What are Queue interface implementations and what are the differences and when to use what?
Queue interface is a part of Java Collections framework. It allows user to store elements and process them in a First-in-first-out(FIFO) manner. 
- **LinkedList**: Implemented by a doubly-linked list.
Use case: When both FIFO and LIFO operations are needed.
- **PriorityQueue**: Orders the elements based on a comparator or the natural ordering of the elements.
Use case: When the order of the elements is important.
- **ArrayDeque**: Also supports both FIFO and LIFO operations, and it is more efficient than LinkedList. 
Use case: When users need a resizable array that supports deque operations.