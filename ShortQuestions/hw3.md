# Homework3

## Yirun Wang

### 2. What is the checked exception and unchecked exception in Java,could you give one example?
- Checked exceptions: Java verifies checked exceptions at compile time. Check exceptions are errors outside the control of the program. Must catch or throws. IOException, SQLException.
- Unchecked Exceptions: Will not be verified during complie time. Runtime Exception. They are errors inside the program logic. ArrayIndexOutOfBoundsException, NullPointerException.

### 3. Can there be multiple finally blocks?
There can be only one finally block, and it must follow the catch blocks.

### 4. When both catch and finally return values, what will be the final result?
The returned value from finally will be the final result. If an exception occurs, but then the code reaches a return from the catch block, control is transferred to the finally block and the function eventually returns normally.

### 5. What is Runtime/uncheckedexception? what is Compile/CheckedException?
Runtime exceptions occur during the execution of a program, indicating a problem that the runtime environment cannot resolve automatically.
Runtime exceptions are subclasses of RuntimeException, which in turn is a subclass of Exception.
Examples include NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException, and ClassCastException.
They can be handled using try-catch blocks, but it is not mandatory.

Compile-time exceptions are exceptions that are checked at compile time by the Java compiler. They must be either caught or declared in the method signature. 
These exceptions are subclasses of Exception but not subclasses of RuntimeException.
They must be handled with a try-catch block or declared with the throws keyword.
Examples include IOException, SQLException, FileNotFoundException, and ClassNotFoundException.

### 6. What is the difference between throw and throws?
- They keyword throw is used to throw an exception from a method or any block of code. We can throw checked or unchecked exception. It can be used to throw cumtom exceptions.
- The keyword throws is used in the signature of a method to indicate that the method might throw one of the listed exceptions. The caller to these methods has to handle the exception using a try-catch block. 

### 7. Run the below three pieces codes. why do we put the Null/Runtime exception before Exception?
java.lang.ArithmeticException: / by zero
java.lang.NullPointerException
java.lang.RuntimeException

Try to catch as specific exceptions as we could rather than general exceptions.

### 7.  What is optional? why do you use it?write an optional example.
Optional is a container object in Java.  Optional is a class that encapsulates a value that may or may not be present. It is primarily used to avoid NullPointerException.

- To provide a clear way to express that a method might not return a value.
- To reduce the risk of NullPointerException.
- Explicitly handling the case of absence of values.

```
Optional<String> optionalString = Optional.of("Hello, World!");

Optional<String> emptyOptional = Optional.empty();

Optional<String> nullableOptional = Optional.ofNullable(null);

// Checking if a value is present
if (optionalString.isPresent()) {
    System.out.println(optionalString.get());
}

// Using orElse()
String result = emptyOptional.orElse("Default Value");

// Using orElseGet()
String resultFromSupplier = emptyOptional.orElseGet(() -> "Generated Value");

// Using orElseThrow()
try {
    String value = emptyOptional.orElseThrow(() -> new Exception("Value not present"));
} catch (Exception e) {
    e.printStackTrace();
}
```

### 8. Why finally always be executed?
The finally block always executes when the try block exits. This ensures that the finally block is executed even if an unexpected exception occurs. Common use cases include releasing resources like file handles, database connections, or network sockets.

### 10. What are the types of design patterns in Java ?
- Singleton Pattern:
    The singleton pattern restricts the instantiation of a Class and ensures that only one instance of the class exists in the Java Virtual Machine. 
- Factory Pattern:
    The factory design pattern is used when we have a superclass with multiple subclasses and based on input, we need to return one of the subclasses. 
- Abstract Factory Pattern:
    Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
- Builder Pattern:
    This pattern solves the issue with a large number of optional parameters and inconsistent state by providing a way to build the object step-by-step and provide a method that will actually return the final Object.
- Prototype Pattern:
    The prototype pattern is used when the Object creation is costly and requires a lot of time and resources, and you have a similar Object already existing. So this pattern provides a mechanism to copy the original Object to a new Object and then modify it according to our needs.

### 11. What are the SOLID Principles?
- Single Responsibility Principle (SRP)
- Open/Closed Principle
- Liskov’s Substitution Principle (LSP)
- Interface Segregation Principle (ISP)
- Dependency Inversion Principle (DIP)

### 12. How can you achieve thread-safe singleton patterns in Java?
- Enum Singleton:
    The enum type inherently provides thread-safety and guarantees a single instance.
    ```
    public enum Singleton {
        INSTANCE;
        public void someMethod() {
            // Implementation here
        }
    }
    ```
- Eager Initialization:
    In eager initialization, the singleton instance is created at the time of class loading. This is thread-safe because the instance is created before any threads access it.
- Static Block Initialization:
    Initialize the instance in a satic block, with try-catch block to handle exception.
- Lazy Initialization with Synchronized Method:
    Use synchronized on the method that create instance for singleton.
- Double-checked Locking:
    Check if instance has been created, and then enter a synchronized block to create the instance.

### 13. What do you understand by the Open-Closed Principle (OCP) ?
Classes, modules, and functions should be open for extension but closed for modification. This means that the behavior of a module can be extended without modifying its source code, thus minimizing the risk of introducing new bugs. OCP encourages the use of interfaces and abstract classes to allow new functionality to be added by creating new subclasses.

### 14.Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
1. ItmeanthatiftheobjectoftypeAcandosomething,theobjectoftypeBcouldalsobeabletp perform the same thing







