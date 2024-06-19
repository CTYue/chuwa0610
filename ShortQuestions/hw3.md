## Homework 3

### 2. 
Checked exceptions are exceptions that are checked at compile-time. This means you have to handle these exceptions either with a try-catch block or by declaring them in the method signature using the throws keyword. Failing to handle a checked exception will result in a compilation error.

IOException is a common checked exception that occurs when an input/output operation fails or is interrupted. For instance, reading from a file on disk that does not exist will throw an IOException.

Unchecked exceptions are not checked at compile-time, which means the compiler does not require methods to catch or to declare them. Unchecked exceptions are usually programming errors, such as logic errors or improper use of an API. Unchecked exceptions are subclasses of RuntimeException.

NullPointerException occurs when you try to use a reference that points to no location in memory (null) as though it were referencing an object. This is a common programming error.

### 3. 
In Java, each try block can be associated with zero or multiple catch blocks, but it can only be followed by one finally block. The finally block is designed to execute code regardless of whether an exception is thrown or not, making it ideal for clean-up activities such as closing file streams or releasing resources.

### 4. 
In Java, if both a catch block and a finally block contain return statements, the value returned by the finally block will supersede the one from the catch block. This is because the finally block is designed to execute last, to ensure that cleanup code runs regardless of what happens in the try and catch blocks. When a finally block also includes a return statement, it essentially overrides any return values issued earlier by either try or catch blocks.

### 5.
Unchecked exceptions are the exceptions that are not checked at compile time. In other words, the compiler does not require that you handle or declare these exceptions.
Checked exceptions are the exceptions that are checked at compile time. The compiler mandates that these exceptions be handled with a try-catch block or declared to be thrown by the methods using the throws keyword.

### 6. 
The throw keyword is used within a method to explicitly throw an exception. You can throw either checked or unchecked exceptions. The throw keyword is followed by an instance of an Exception class (or a subclass of Exception). It is used to indicate that a specific error has occurred, often as a response to some condition that the method encounters.

The throws keyword is used in the method signature to declare that the method might throw certain exceptions during its execution. These exceptions could be either checked exceptions (which need to be declared) or unchecked exceptions (which do not need to be declared but can be documented). Declaring an exception with throws informs the caller of the method that they need to handle or declare these exceptions when they call the method.

### 7.
In Java, when catching exceptions, the order of the catch blocks is significant because Java checks the catch blocks in the order they appear and handles the exception with the first catch block that matches the type of the exception thrown. Thus, when organizing catch blocks, more specific exceptions (narrower in hierarchy or more particular in type) should be listed before more general ones.

### 8.
In Java, Optional is a container object which may or may not contain a non-null value. Introduced in Java 8, it is part of the java.util package. The primary purpose of Optional is to provide a means for a function to indicate the possibility of returning an absent value instead of returning null. This approach can help avoid NullPointerException and makes the code more readable and cleaner by providing a more expressive alternative to null.

### 9.
- Guaranteed Execution: The primary purpose of the finally block is to guarantee that the code within it executes regardless of what happens in the try and catch blocks. This includes scenarios where:

  - An exception is thrown and optionally caught.
  - An exception is thrown and not caught (in this case, after the finally block executes, the uncaught exception is rethrown).
  - No exception is thrown.
- Resource Management: It's critical in programming to ensure that resources are properly closed or released. The finally block allows developers to place cleanup code in a central location, ensuring it executes under all circumstances, thereby avoiding resource leaks.

- Control Flow Exceptions: The finally block will execute even if the try or catch blocks contain control flow statements such as return, continue, break, or even another uncaught exception.

### 10.
Java, as in other object-oriented programming languages, design patterns are typically divided into three main categories: Creational, Structural, and Behavioral patterns.

### 11.
- Single Responsibility Principle: You have a class Order that handles both the calculations related to the order details and the database operations. According to SRP, these functions should be split into separate classes, one for processing order calculations and another for managing database operations.

- Open/Closed Principle: Suppose you have a graphic editor that supports drawing shapes. If you want to add support for new shapes, you should be able to do so without modifying the existing code, perhaps by implementing a common interface Shape that new shapes can implement.

- Liskov Substitution Principle: If you have a class Bird with a method fly(), a subclass Duck can inherit from it and implement fly(). However, a subclass Penguin should not inherit from Bird if it has to override fly() to throw an exception, because penguins can’t fly.

- Interface Segregation Principle: Instead of having one large interface for a smart device, break it into smaller interfaces, such as CameraOperations, InternetConnectivity, MediaControl, etc., depending on the functionalities that specific clients might use.

- Dependency Inversion Principle: An application that logs error messages should depend on a Logger interface rather than a specific FileLogger class. This way, logging can be done to a file, a database, or even over the network without changing the client code, by simply substituting the FileLogger with another implementation of Logger.

### 12.
1. Eager Initialization
   Using eager initialization, the instance of the singleton class is created at the time of class loading. This is the simplest method to create a thread-safe singleton class but it has a drawback: the instance is created even though the client application might not use it.
2. Static Block Initialization
   Similar to eager initialization, the singleton instance is created at the time of class loading. This approach provides the option for error handling during instance creation.
3. Lazy Initialization with Synchronization
   This method creates the singleton instance in a synchronized block when needed. This ensures the class is only created when it is needed, also known as lazy initialization, but it can decrease performance because of synchronization overhead.

### 13.
"Open for extension" means that the behavior of a module can be extended. As the requirements of the application change, developers can introduce new functionality to satisfy those changes without altering the existing code.

"Closed for modification" means that the source code is set and cannot be modified. Once a developer has developed a module and it has been tested and approved, changes to that module should be minimized or avoided to prevent the introduction of new faults.

### 14.
Answer: 1