
## 1.  Practice  collection
* [Coding](../Coding)

## 2.  What is the checked exception and unchecked exception in Java, could you give one example?
* Checked exceptions are the exceptions that are checked at compile time. If some code within a method throws a checked exception, then the method must either handle the exception or it must specify the exception using the throws keyword. e.g.  FileReader() throws a checked exception FileNotFoundException.
* Unchecked exceptions are exceptions that are not checked at compile-time. e.g. divide 0;

## 3.  Can there be multiple finally blocks? 
* No, for each try block there can be zero or more catch blocks, but only one finally block.

## 4.  When both catch and finally return values, what will be the final result?
* finally return value

## 5.  What is Runtime/unchecked exception? what is Compile/Checked Exception?
* Checked Exceptions: These are the exceptions that are checked at compile time.
* Unchecked Exceptions: These are the exceptions that are not checked at compile time.

## 6.  What is the difference between throw and throws?
* Both throw and throws are concepts of exception handling in Java. The throws keyword is used to declare which exceptions can be thrown from a method, while the throw keyword is used to explicitly throw an exception within a method or block of code.

## 7.  Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?
* Because Exception is the parent class, catch Exception will include subclasses. 

## 7.  What is optional? why do you use it? write an optional example.
* The purpose of the class is to provide a type-level solution for representing optional values instead of null references.
``` java
class GFG {
    // Driver code
    public static void main(String[] args)
    {

        // creating a string array
        String[] str = new String[5];
 
        // Setting value for 2nd index
        str[2] = "Geeks Classes are coming soon";
 
        // It returns an empty instance of Optional class
        Optional<String> empty = Optional.empty();
        System.out.println(empty);
 
        // It returns a non-empty Optional
        Optional<String> value = Optional.of(str[2]);
        System.out.println(value);
    }
}

```

## 8.  Why finally always be executed ?
* The finally block always executes when the try block exits. This ensures that the finally block is executed even if an unexpected exception occurs. Note: The finally block may not execute if the JVM exits while the try or catch code is being executed

## 10.  What are the types of design patterns in Java ?
* Some common Java design patterns include the Singleton pattern, the Factory pattern, the Adapter pattern, the Observer pattern, the Decorator pattern, and the Strategy pattern, among others.

## 11.  What are the SOLID Principles ?
* S - Single-responsibility Principle
* O - Open-closed Principle
* L - Liskov Substitution Principle
* I - Interface Segregation Principle
* D - Dependency Inversion Principle

## 12.  How can you achieve thread-safe singleton patterns in Java ?
* Create the instance variable at the time of class loading.

## 13.  What do you understand by the Open-Closed Principle (OCP) ?
* "software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification";[1] that is, such an entity can allow its behaviour to be extended without modifying its source code.
## 14.  Liskov's substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
* 1.  It mean that if the object of type A can do something, the object of type B could also 

## 15.  Watch the design pattern video, and type the code, submit it to MavenProject folder
* [MavenProject](../MavenProject)
