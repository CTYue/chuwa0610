### 1. What is the main purpose of reflection in Java?

a) To dynamically load and execute arbitrary Java code at runtime.

b) To inspect and access the metadata (information) of a class at runtime, including its methods, fields, and annotations.

c) To achieve polymorphism by treating objects of different types as the same type.

d) To improve the performance of frequently called methods by bypassing type checking.



**Answer: b)**

Through reflection, a Java program can access private methods and variables, and create instances of classes dynamically. This is particularly useful for building libraries and frameworks, such as those used for dependency injection, where behavior is determined at runtime rather than at compile time.



### 2. Which of the following statements is true about access modifiers for top-level classes in Java?

a) A top-level class can be declared as protected.

b) A top-level class can only be declared as public.

c) A top-level class can only be declared with no access modifier (package-private).

d) All of the above.



**Answer: None above**

Top-level classes can be declared with no access modifer or public. None of the four options properly described this.



### 3. Does this code execute as expected or produce a runtime error?

```java
public class Test {
    public static void main(String... args) {
        Object o = new Object() {
            public boolean equals(Object t) {
                return t.equals("hi");
            }
        };
        System.out.println(o.equals("hi"));
    }
}
```

a) Executes as expected

b) Produces a runtime error

**Answer: a)**



There are no runtime errors in this code. Therefore, it will execute as expected and print `true`.



### 4. What is the difference between weak and soft references in Java?

a) Weak references are always cleared by the garbage collector when memory is low, while soft references are never cleared.

b) Both weak and soft references are cleared by the garbage collector when memory is low, but weak references have priority for removal.

c) Weak references are cleared by the garbage collector as soon as there are no strong references to the object, while soft references persist even when memory is low.

d) There is no difference; both weak and soft references behave the same way.



**Answer: b)**

Both soft and weak references are removed when the memory is low. But weak references may be removed even the memory is not low (as long as it's discovered by the GC process).



### 5. When to choose between Serializable and Externalizable in Java?

a) Use `Serializable` for simple object state serialization and `Externalizable` for complex object graphs.

b) Use `Serializable` for faster serialization and `Externalizable` for more control over the format.

c) Use `Serializable` and `Externalizable` interchangeably as they offer the same functionality.

d) Use `Externalizable` for thread-safe serialization.



**Answer: b)**

`Serializable` is easy and fast to use while `Externalizable` provides more control of the serialization process but requires you to write extra codes.



### 6. Which of the following statements is NOT true about the Singleton pattern in Java?

a) It ensures only one instance of a class exists throughout the application.

b) It provides a global point of access to the instance.

c) It can be easily implemented using the `static` keyword.

d) It guarantees thread safety.



**Answer: d)**

The basic Singleton pattern does not inherently guarantee thread safety. To ensure thread safety you need to implement Singlton  with additional synchronization mechanisms.



### 7. What is the core principle behind object-oriented programming (OOP) in Java?

a) It organizes code around methods that manipulate data.

b) It focuses on breaking down problems into smaller, reusable components.

c) It emphasizes data encapsulation, where data and its manipulation logic are bundled together.

d) It prioritizes speed and efficiency through optimized algorithms and data structures.



**Answer: c)**

**Encapsulation** is a core principle of object-oriented programming (OOP). It refers to the bundling of data (attributes) and methods (functions or procedures) that operate on the data into a single unit or class. 



### 8. Can a Singleton pattern in Java ever return a different instance for the same class?

a) Yes, if the Singleton is implemented using a lazy initialization approach.

b) Yes, if the Singleton class has a public constructor.

c) No, by definition, the Singleton pattern always guarantees a single instance.

d) Yes, if the application uses multiple class loaders.



**Answer: c)**

That's what a Singleton is. If different instances are produced, it's not a Singleton.



### 9. What are "synthetic bridge methods" in Java?

a) Methods automatically generated by the compiler to handle covariant return types in inheritance.

b) Methods explicitly defined by the programmer to bridge between incompatible method signatures.

c) Methods used internally by the JVM for garbage collection purposes.

d) Methods created by the compiler during type erasure to ensure compatibility with generic types.



**Answer: a)**

**Synthetic bridge methods** are automatically generated by the Java compiler to ensure that covariant return types are handled correctly during inheritance. Covariant return types allow an overriding method to return a subtype of the type returned by the overridden method. To maintain binary compatibility, the compiler generates bridge methods that "bridge" the method signatures.



### 10. Which of the following statements is NOT true about interfaces and abstract classes in Java?

a) Both can be used to define common functionalities for different classes.

b) Interface methods are implicitly public and abstract, whereas abstract class methods can have different access modifiers.

c) Interfaces can be used to achieve loose coupling, while abstract classes enforce tight coupling.

d) Both can be declared as `public` or package-private but cannot be declared as `protected`.



**Answer: c)**

Both interfaces and abstract classes can be used to achieve loose coupling.



### 11. **Consider the following scenario:**

**A Java application creates a large number of temporary objects during a specific processing phase. These objects are only needed within that phase and become immediately unreachable after the phase completes.**

**Which statement accurately describes the behavior of the generational garbage collector in this scenario, considering the potential impact on application performance?**

a) The garbage collector will immediately reclaim memory for all temporary objects once the processing phase ends, minimizing any performance impact.

b) The garbage collector might trigger frequent, small collections throughout the processing phase, potentially leading to performance overhead.

c) The garbage collector will wait for a significant memory threshold to be reached before reclaiming memory, potentially causing a sudden pause during the processing phase.

d) The garbage collector's behavior is entirely unpredictable and cannot be controlled, leading to inconsistent application performance.



**Answer: b) **

In the given scenario, where a large number of temporary objects are created, the garbage collector will likely perform frequent minor collections to reclaim the memory occupied by these objects. These frequent collections can introduce overhead, which may impact performance, especially if they occur frequently during the processing phase.



### 12. In the context of multithreading, which of the following statements best describes the role of synchronization?

a) Synchronization ensures that only one thread can access a shared resource at a time, preventing race conditions and data inconsistencies.

b) Synchronization guarantees that all threads accessing a shared resource will execute in a specific order, improving program efficiency.

c) Synchronization automatically creates copies of shared resources for each thread, allowing concurrent access without data conflicts.

d) Synchronization allows threads to communicate and share data directly, eliminating the need for separate copies of shared resources.

**Answer: a)**

**Synchronization** in multithreading is a mechanism that controls the access of multiple threads to shared resources. It ensures that only one thread can access a shared resource at a time.



### 13. Which of the following statements is NOT true about checked and unchecked exceptions in Java?

a) Checked exceptions are explicitly declared in the method signature, while unchecked exceptions are not.

b) Unchecked exceptions are generally considered more critical errors compared to checked exceptions.

c) The compiler enforces developers to handle checked exceptions, while unchecked exceptions can be left unhandled.

d) Both checked and unchecked exceptions inherit from the `Exception` class.



**Answer: b)**

Unchecked exceptions (like `RuntimeException` and its subclasses) are typically used for programming errors (e.g., null pointer dereference, array index out of bounds), which are not meant to be caught and handled in most cases. Checked exceptions, on the other hand, are for recoverable conditions and are generally considered more critical in terms of the need for handling.



### 14. **Java Reflection and Class Loading: When invoking a method using reflection in Java, what is the difference between calling `getMethod` and `getDeclaredMethod`?**

a) `getMethod` returns only public methods, while `getDeclaredMethod` returns all methods including private ones.

b) `getMethod` searches the entire class hierarchy, while `getDeclaredMethod` only searches the current class.

c) Both methods are functionally identical and can be used interchangeably.

d) `getMethod` throws a `NoSuchMethodException` if the method doesn't exist, while `getDeclaredMethod` returns null.



**Answer: a)**

**`getMethod`**: This method is used to retrieve public methods of the class or interface, including inherited methods from superclasses. It does not retrieve private, protected, or package-private methods.

**`getDeclaredMethod`**: This method retrieves all methods declared by the class or interface, including public, protected, package-private, and private methods. However, it only retrieves methods declared directly in the class, not those inherited from a superclass.



### 15. Consider the following Java code snippet:

```java
public class MyClass {
    public static void printList(List list) {
        for (Object obj : list) {
            System.out.println(obj.toString());
        }
    }
}
```

**What is the potential issue with the provided `printList` method and how can it be improved using Generics?**

a) The method cannot handle lists containing different data types.

b) The method requires explicit type casting before printing objects.

c) Generics cannot be applied to existing code without rewriting the entire method.

d) This code snippet does not have any issues; it works correctly.



**Answer: b)**

```java
public class MyClass {
    public static <T> void printList(List<T> list) {
        for (T obj : list) {
            System.out.println(obj.toString());
        }
    }
}
```
