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