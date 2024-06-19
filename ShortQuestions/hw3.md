## HW3

2. What is the checked exception and unchecked exception in Java, could you give one example?

   >Checked exception: must use catch or throws
   >
   >1. IOException
   >2. SQLException
   >
   >unchecked exception: Runtime Exception
   >
   >1. NullPointerException

3. Can there be multiple finally blocks?

   >No

4. When both catch and finally return values, what will be the final result?

   >Only get the return value from the finally

5. What is Runtime/unchecked exception? what is Compile/Checked Exception?

   >Checked exception: must use catch or throws
   >
   >unchecked exception: runtime Exception

6. What is the difference between throw and throws?

   >throw is used to throw an exception inside a method, while throws is used in the method signature to throw the exception explicitly.

7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?

   >NullPointerException is inherited from Runtime exception and  Runtime exception is inherited from Exception. Therefore, the exception range is gradually increasing to help the developer find the error.

8. What is optional? why do you use it? write an optional example.

   >optional is used to help handle the null values.
   >
   >```java
   >String a = null;
   >String s = Optional.ofNullable(a).orElse("aaa");
   >System.out.println(s);
   >```

9. Why finally always be executed ?

   >The finally block always executes when the try block exits. This ensures that the finally block is executed even if an unexpected exception occurs.

10. What are the types of design patterns in Java?

    >Creational: 
    >
    >1. Factory Pattern
    >2. Abstract Factory Pattern
    >3. Singleton Pattern
    >4. Prototype Pattern
    >5. Builder Pattern
    >
    >Structural:
    >
    >1. Adapter Pattern
    >2. Bridge Pattern
    >3. Composite Pattern
    >4. Decorator Pattern
    >5. Facade Pattern
    >6. Flyweight Pattern
    >7. Proxy Pattern
    >
    >Behavioral:
    >
    >1. Chain Of Responsibility Pattern
    >2. Command Pattern
    >3. Interpreter Pattern
    >4. Iterator Pattern
    >5. Mediator Pattern
    >6. Memento Pattern
    >7. Observer Pattern
    >8. State Pattern
    >9. Strategy Pattern
    >10. Template Pattern
    >11. Visitor Pattern

11. What are the SOLID Principles?

    >S: Single-responsibility Principle
    >O: Open-closed Principle
    >L: Liskov Substitution Principle
    >I: Interface Segregation Principle
    >D: Dependency Inversion Principle

12. How can you achieve thread-safe singleton patterns in Java?

    >```java
    >public class Singleton {
    >  private static Singleton instance = new Singleton(); 
    >  private Singleton (){}
    >  public static Singleton getInstance() {
    >    return instance; 
    >  }
    >}
    >```

13. What do you understand by the Open-Closed Principle (OCP) ?

    >Objects or entities should be open for extension but closed for modification.
    >
    >If we want to modify the codes, we'd better add some extensions on it instead of modifying the codes we already have.

14. Liskov's substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA) choose your answer.

    2. It means that all the objects of type A could execute all the methods present in its subtype B

    3. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.