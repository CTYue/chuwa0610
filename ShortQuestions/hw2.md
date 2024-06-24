2. What is wrapper class in Java and Why we need wrapper class? 

   >Wrapper class is a class that wraps the primitive data types, which can be used to treat primitive data structures as objects. As Java is an OOP language, then wrapper classes are needed to be utilized in the data structures.

3. What is the difference between HashMap and HashTable?

   >+ HashMap is non-synchronized, while HashTable is synchronized.
   >+ HashMap allows null keys and values, but HashTable doesn't

4. What is String pool in Java and why we need String pool? 

   >String pool is used to cache the String during the program, which is a storage space in the heap. As string is immutable, it reduces the overhead of creating and destroying of such objects.

5. What is Java garbage collection?

   >Garbage collection is an automated process of collecting objects that are no longer needed to free up memory space.

6. What are access modifiers and their scopes in Java? 

   >Default: visible only within the package
   >
   >Public: visible everywhere
   >
   >Private: visible only within the class
   >
   >Protected: visible only within the package or all subclasses

7. What is final key word? (Field, Method, Class)

   >final is used to declare a field, method, or class with immutable property. 
   >
   >Final on field: define constants
   >
   >Final on method: prevent override
   >
   >Final on class: prevent inheritance and make it immutable

8. What is static keyword? (Field, Method, Class). When do we usually use it?

   >Static keyword is mainly used for memory management to share the same variables, methods, blocks or classes.
   >
   >Static on field: only one Instance
   >
   >Static on method: can directly call static method using Class name
   >
   >Static on class: create an inner class(Nested Classes) of a class

9. What is the differences between overriding and overloading?

   >Overloading happens in compile time. It can have different numbers of arguments, different types of arguments, and the same method name.
   >
   >Overriding happens in runtime. It can have different implementations of the methods with the same signature. 

10. What is the differences between super and this?

    >super can be used to invoke the parent class methods and constructors, while this is used to call the current class methods and constructors.

11. What is the Java load sequence?

    >static variable/block -> constructor(used in Obj)

12. What is Polymorphism ? And how Java implements it ? 

    >Polymorphism refers to the same object exhibiting different **forms and behaviors**.
    >
    >It includes static polymorphism and dynamic polymorphism. 
    >
    >static polymorphism: overloading
    >
    >dynamic polymorphism: overriding

13. What is Encapsulation ? How Java implements it? And why we need encapsulation? 

    >**Encapsulation** in OOP refers to binding the **data** and the **methods to manipulate that data** together in a single **unit** (class).
    >
    >This is achieved by using the access modifiers in a class. We need this because encapsulation provides a good way of dividing the whole project into single units and preventing illegal access of the data.

14. What is Interface and what is abstract class? What are the differences between them?

    >An abstract class is a class that is designed to be specifically used as a base class.
    >
    >Interface is an abstract way of enhancing the functionality of a class.
    >
    >abstract classes are used when there is some common behavior that all subclasses must share. 
    >
    >Interfaces are used when there is a set of behaviors that all subclasses must support, but the implementation details can vary

15. design a parking lot (put the code to codingQuestions/coding1 folder, )

16. What are Queue interface implementations and what are the differences and when to use what? 

    >Queue is implemented by PriorityQueue, which is used when a sorted queue is needed.
    >
    >Deque extends the Queue and has two implementations: linkedList and ArrayDeque, which are two different implementations by list and array, similar to the difference between LinkedList and ArrayList.