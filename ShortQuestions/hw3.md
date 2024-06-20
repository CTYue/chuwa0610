# HW3

1. What is the checked exception and unchecked exception in Java, could you give one example?
    
    checked exception is caused by something outside the control of the program, which Java compiler requires you to catch or declare in method’s throw clause.
    
    eg: the file doesn’t exist
    
    ```java
    public class CheckedExceptionExample {
        public static void main(String[] args) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("nonexistentfile.txt"));
                System.out.println(reader.readLine());
                reader.close();
            } catch (IOException e) {
                System.out.println("An error occurred while trying to read the file.");
            }
        }
    }
    ```
    
    Unchecked exception is caused by programming errors such as logic mistakes or improper use of an API.
    
    eg: array is out of bound
    
    ```java
    public class UncheckedExceptionExample {
      public static void main(String[] args) {
          int[] numbers = new int[5];
          // This line will throw ArrayIndexOutOfBoundsException, which is unchecked
          System.out.println(numbers[5]);  
      }
    }
    ```
    
2. Can there be multiple finally blocks?
    
    No, in Java, the finally block is designed to ececute that must run regardless whether exception is thrown or not. It’s useful for cleaning up resource like closing file stream, releasing connections etc
    
3. When both catch and finally return values, what will be the final result?
    
    The final result would be the value returned by finally, since in Java the value returned by finally would override the value returned by catch block.
    
4. What is **Runtime/unchecked exception**? what is Compile/Checked Exception?
    
    unchecked exception are those that Java compiler doesn’t require programmer to catch or declare. They are mainly due to programming error and incorrect use of APIs. They will be checked in the run time.
    
    Checked exception are those Java compiler require programmer to handle and define, they will be checked at compile time.
    
5. What is the difference between **throw** and **throws**?
    
    Throw is used within the method body to throw an exception, throws is used in the method declaration to indicate that the method might throw certain exceptions.
    
    ```java
    public void processFile(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException("Filename cannot be null");
        }
        // further code
    }
    public void readFile(String path) throws IOException {
        // Code that might throw IOException
        BufferedReader reader = new BufferedReader(new FileReader(path));
        // further code
    }
    ```
    
6. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?
    
    Exception in Java is the superclass for most types of exceptions, RuntimeException is subclass of Exception.  Exception is general, RuntimeException is more specific.  Java will check each catch block in order they appear and will execute the first one that matches the type of thrown exceptions. If a more general exception type were caught before more specific types, the more general type would handle all exceptions and more specific catch blocks would be unreachable. 
    
7. What is **optional**? why do you use it? write an optional example
    
    Optional is used to represent null with absent value. Enable the client to handle the possibility of absence. It will return null, which can prevent NullPointerException.
    
    For example, in user profile, middle name fields can be optional.
    
8. Why finally always be executed ?
    
    The primary purpose of finally block is to ensure that important cleanup operation are guaranteed to execute, including closing resources such as files, network, connections or database connections.
    
9. What are the types of design patterns in Java ?
    
    Design pattern are best-practice solutions for solving common design problems.
    
    1. Creational patterns: Singleton, Factory Method, Abstract Factory, Builder, Prototype
    2. Structural Pattern: Adapter, Composite, Proxy.
    3. Common Behavior Pattern include: Observer, Strategy, Command
10. What are the **SOLID** Principles ?
    1. single responsibility principle
        
        A class should have only one reason to change. which means a class should have only one job or responsibility.
        
    2. Open/Closed principle
        
        Software entities should be open for extension, but close for modification. Which means programmer should be able to add new functionality to an existing class without altering its existing code.
        
    3. Liskov Substitution principle
        
        Object of a superclass should be replaceable with objects of its subclass.
        
    4. Interface segregation principle
        
        Client should not be forced to depend on interface they do not use. Instead of one big interface, use several smaller interfaces, each one has a specific sub-module.
        
    5. Dependency inversion principle
        
        High-level modules should not depend on low-level modules. both should depend on abstractions.
        
11. How can you achieve thread-safe singleton patterns in Java ?
    1. Eager initialization
    
    ```java
    public class Singleton {
        private static final Singleton INSTANCE = new Singleton();
    
        private Singleton() {}
    
        public static Singleton getInstance() {
            return INSTANCE;
        }
    }
    ```
    
    b. Static Block initialization
    
    ```java
    public class Singleton {
        private static final Singleton INSTANCE;
    
        static {
            try {
                INSTANCE = new Singleton();
            } catch (Exception e) {
                throw new RuntimeException("Exception occurred in creating singleton instance", e);
            }
        }
    
        private Singleton() {}
    
        public static Singleton getInstance() {
            return INSTANCE;
        }
    }
    ```
    
    c. Lazy initialization with synchornization
    
    ```java
    public class Singleton {
        private static Singleton instance;
    
        private Singleton() {}
    
        public static synchronized Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }
    ```
    
    d. Double-checked locking
    
    ```java
    public class Singleton {
        private static volatile Singleton instance;
    
        private Singleton() {}
    
        public static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
    ```
    
    e. Initialization-on-demand holder idiom
    
    ```java
    public class Singleton {
        private static class SingletonHolder {
            static final Singleton INSTANCE = new Singleton();
        }
    
        private Singleton() {}
    
        public static Singleton getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }
    ```
    
12. What do you understand by the Open-Closed Principle (OCP) ?
    
    Entities should be open for extension, but closed for modification, which means a software should be allowed to be extended without modifying its source code. We can implemented it by interface, strategy pattern etc.
    
13. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer
    
    Answer is option 1: 
    
    1.  It mean that if the object of type A can do something, the object of type B could also be able to perform the same thing.