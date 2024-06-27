## 2.  What is the checked exception and unchecked exception in Java, could you give one example?
- Checked exceptions are exceptions that are checked at compile-time
```java
    try {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    } catch (IOException e) {
        System.out.println("An IOException was caught: " + e.getMessage());
    }
```

- Unchecked exceptions are exceptions that are not checked at compile-time.
```java
        int[] numbers = {1, 2, 3};
        try {
            System.out.println(numbers[5]));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("An ArrayIndexOutOfBoundsException was caught: " + e.getMessage());
        }

```


## 3.  Can there be multiple finally blocks?
- No, in Java, you can have multiple catch blocks, but only one finally block is allowed.

## 4.  When both catch and finally return values, what will be the final result?
- When both catch and finally blocks contain return statements, the value returned by the finally block will be the final result.

## 5.  What is Runtime/unchecked exception? what is Compile/Checked Exception?
- Checked exceptions are exceptions that are checked at compile-time. Like : IOException
- Runtime exceptions, also known as unchecked exceptions, are exceptions that are not checked at compile-time. Like: ArrayIndexOutOfBoundsException

## 6.  What is the difference between throw and throws?
- The throw keyword is used to explicitly throw an exception from a method or any block of code.
- The throws keyword is used in the method signature to declare that a method might throw one or more exceptions.

## 7.  Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?
- error order : 1. b/a throw Arithmetic error, and 2. s.equals("aa") throw NullPointer,3.Runtime error.
- Exception is all the different exception that program can throw, inorder to catch specific error we have put the Null/Runtime exception before Exception.
```java
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        String s = null;
        try {
            System.out.println(b / a); //ArithmeticException 
            System.out.println(s.equals("aa")); // NullPointerException
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("End ...");
    }
}
```

## 7.  What is optional? why do you use it? write an optional example.
- optional used to represent optional values that can be either present or absent, and it provides a more expressive way to deal with null values.
- optional mainly aim to Avoid NullPointerExceptions 

## 8.  Why finally always be executed ?
- In Java, the finally block is designed to be executed regardless of whether an exception is thrown or caught in the corresponding try or catch blocks. 
- This ensures that important cleanup code, such as releasing resources, or other necessary finalization tasks, is always executed.

## 10.  What are the types of design patterns in Java ?
- Creational Patterns
- Structural Patterns
- Behavioral Patterns

## 11.  What are the SOLID Principles ?
- S - Single Responsibility Principle (SRP)
- O - Open/Closed Principle (OCP)
- L - Liskov Substitution Principle (LSP)
- I - Interface Segregation Principle (ISP)
- D - Dependency Inversion Principle (DIP)

## 12.  How can you achieve thread-safe singleton patterns in Java ?
- Eager Initialization
- Lazy Initialization


## 13.  What do you understand by the Open-Closed Principle (OCP) ?
- Software entities should be open for extension, but closed for modification.

## 14.  Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

- 1.It mean that if the object of type A can do something, the object of type B could also be able tp
      perform the same thing