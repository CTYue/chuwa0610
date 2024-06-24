## Practice collection
See /Coding/hw3/collections/src/test/java/com/chuwa/learn/
## What is the checked exception and unchecked exception in Java, could you give one example?
### checked exception

- Exceptions that can be caught in compile time
- eg. IOExcepion (FileNotFound)
### unchecked exception

- Exceptions that happen in run time
- eg. NullPointerException

## Can there be multiple finally blocks?
No, there can only be one finally block after try.
## When both catch and finally return values, what will be the final result?
You can put return statement in both catch and finally, but only the one in finally block will return.
## What is Runtime/unchecked exception? what is Compile/Checked Exception?
- Checked exceptions are exceptions that can be caught by the compiler. It must be handled by try and catch to resolve the exception.
- Unchecked exceptions are exceptions that can only happen during runtime. It is unrecoverable, and it is not forced by the compiler to handle these exceptions.
## What is the difference between throw and throws?
- ```Throw``` is a method that throws an exception. We can customize the error message like ```throw new NullPointerException("demo");```
- ```Throws```is a keyword in the method's signature indicates that this method might throw these types of exceptions. The method body must handle all listed exceptions.
## Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?
```
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        String s = null;
        try {
            System.out.println(b / a);
            System.out.println(s.equals("aa"));
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
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        String s = null;
        try {
            // System.out.println(b / a);
            System.out.println(s.equals("aa"));
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
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        String s = null;
        try {
            // System.out.println(b / a);
            // System.out.println(s.equals("aa"));
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
- First code prints ```java.lang.ArithmeticException: / by zero```
- Second code prints ```java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "s" is null```
- Last code prints ```java.lang.RuntimeException```
- We do this in this order because the catch methods catches exceptions in order. If we put more general exceptions(like Exception) that covers other specific exceptions(like NullPointerException), the later one will never be caught.
## What is optional? why do you use it? write an optional example.
It is a class that helps to deal with NullPointerException. We use them to do null-checkes.
For example:
```     
        String[] str = new String[10];  
        String lowercaseString = str[5].toLowerCase();  
        System.out.print(lowercaseString);  
```
will return NullPointerException. However, if we change it to
```
        String[] str = new String[10];  
        Optional<String> checkNull = Optional.ofNullable(str[5]);  
        if(checkNull.isPresent()){  
            String lowercaseString = str[5].toLowerCase();  
            System.out.print(lowercaseString);  
        }else  
            System.out.println("string value is not present");  
    }  
```
We will be able to deal with null values and preventing the program from crushing.
## Why finally always be executed ?
Since Finally can execute even when the exception is not handled, it is used execute important code such as clean up or close connection.
## Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection
See /Coding/hw3/collections/src/test/java/com/chuwa/learn/
## What are the types of design patterns in Java ?
There are mainly 3 types of design patterns in Java

- Creational Design Pattern
    - Concerned with the way of creating objects
    - Such as Singleton Pattern and Factory Pattern
- Structural Design Pattern
    - Simplifies the structure by identifying the relationships
    - Such as Bridge Pattern and Adapter Pattern
- Behavioral Design Pattern
    - Makes interaction between the objects such that they can easily talk to each other and still be loosely coupled.
    - Such as Observer Pattern and Visitor Pattern
## What are the SOLID Principles ?
I found these images helpful in understanding the principles
- S: Single Responsibility Principle
![](https://www.globalnerdy.com/wordpress/wp-content/uploads/2009/07/single_responsibility_principle.jpg)
- O: Open/Closed Principle
![](https://www.globalnerdy.com/wordpress/wp-content/uploads/2009/07/openclosed_principle.jpg)
- L: Liskov's Substitution
![](https://www.globalnerdy.com/wordpress/wp-content/uploads/2009/07/liskov_substitution_principle.jpg)
- I: Interface Segregation Principle
![](https://www.globalnerdy.com/wordpress/wp-content/uploads/2009/07/interface_segregation_principle.jpg)
- D: Dependency Inversion Principle
![](https://www.globalnerdy.com/wordpress/wp-content/uploads/2009/07/dependency_inversion_principle.jpg)
## How can you achieve thread-safe singleton patterns in Java ?
We can use ___Lazy Initialization___, and syncronize the ```getInstance()``` functions
eg:
```
public class MyClass 
{

  private static MyClass instance;
 
  private MyClass() 
  {
    ...
  }
 
  synchronized public static MyClass getInstance() 
  {
    if (instance == null) 
    {
      instance = new MyClass();
    }
    return instance;
  }
}
```
## What do you understand by the Open-Closed Principle (OCP) ?
This principle suggests that class should be open to extension, but closed to modification.\
This means when I want to add new ability a the currently working class, I should create a new class that extends it rather than always adding more functionalities to it.
## Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

-[x] It means that if the object of type A can do something, the object of type B could also be able tp perform the same thing
-[ ] It means that all the objects of type A could execute all the methods present in its subtype B
-[ ] It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.
-[ ] It means that for the class B to inherit class A, objects of type B and objects of type A must be same.
## Watch the design pattern video, and type the code, submit it to MavenProject folder
- singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
  - See /Coding/hw3/collections/src/main/java/com/chuwa/learn/MavenProject/Singleton
- Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6d9
  - See /Coding/hw3/collections/src/main/java/com/chuwa/learn/MavenProject/Factory
- Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6d9
  - See /Coding/hw3/collections/src/main/java/com/chuwa/learn/MavenProject/Builder
- Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f7accf859bf7f6d9
  - See /Coding/hw3/collections/src/main/java/com/chuwa/learn/MavenProject/Observer

