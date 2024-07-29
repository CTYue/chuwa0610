## 1. What is generic in Java?
Generics in Java are a powerful feature introduced to provide type safety and eliminate the need for casting. Generics enable types (classes and interfaces) to be parameters when defining classes, interfaces, and methods.

## 5. Discuss best practices on null ptr exception prevention,provide code snippet for each practice that you mentioned.
### Use Optional
```java
import java.util.Optional;

class Main {
    public static void main(String[] args) {
        Optional<String> optionalStr = Optional.empty();
        System.out.println(optionalStr.orElse("default string"));
    }
}
```
### Use ternary operator
```java
class Main { 
    String s = null;
    String str = (s == null) ? "hello" : s;
}
```
### Check for Nulls Explicitly
```java
class Main {
    Integer val = null;
    double val = 0;
}
```


## 6. Discuss Java 8 new features with code snippet.
```java
interface Run {
    static String name = "running";
    static void run();
}
```
```java
import java.util.Arrays;
import java.util.Optional;
class Person {
    int id;
    static int getId() {
        return id;
    }
}
class Student {
    int age;
    String id;

    Student(int age) {
        this.age = age;
    }
    int getAge() {
        return age;
    }
}
class Main {
    public static void main(String[] args) {
        Optional<String> s = Optional.empty();
        Stream<Float> stream = Stream.generate(Math::random).limit(10);
        Student s1 = new Student(20);
        Student s2 = new Student(10);
        Student s3 = new Student(33);
        Student[] arr = new Student[]{s1, s2, s3};
        Arrays.sort(arr, (a, b) -> a.getAge() - b.getAge());
        for (Student s: arr)
            System.out.println(s.getAge());
    }
}
```

## 7. What are the advantages of the Optional class?
- Avoiding NullPointerExceptions
- Explicit Null Handling
- Improved Readability

## 8. Explain Functional Interface and Lambda with code samples.
- Functional interface only has one single abstract method. However, it can have many default methods. 
- Lambda is the implementation of the abstract method.
```java
@FunctionalInterface
interface MyFunctionalInterface {
    void myMethod(); // Abstract method

    default void defaultMethod() {
        System.out.println("Default method");
    }
}

```
Lambda can be used to replace anonymous inner class. And it works well with functional interface
```java
public class LambdaExample {
    public static void main(String[] args) {
        // Using lambda expression to implement the abstract method of the functional interface
        MyFunctionalInterface functionalInterface = () -> System.out.println("Hello, Lambda!");
        
        // Calling the method defined in the functional interface
        functionalInterface.myMethod();

        // Calling the default method
        functionalInterface.defaultMethod();
    }
}
```

## 9. Explain Method Reference with code samples?

```java
import java.util.function.Function;

public class Example {

    public static void main(String[] args) {
        Function<String, Integer> parseIntFunction = Integer::parseInt;
        int number = parseIntFunction.apply("123");
        System.out.println("Parsed number: " + number);
        
        Consumer<String> printUpperCase = System.out::println;
        printUpperCase.accept("hello");

        Function<Student, String> getNameFunction = Student::getName;
        List<String> names = Arrays.asList("Mary", "Bob", "Alex");
        names.sort(String::compareToIgnoreCase);

        Supplier<StringBuilder> stringBuilderSupplier = StringBuilder::new;
        StringBuilder stringBuilder = stringBuilderSupplier.get();
        stringBuilder.append("Hello!");
        System.out.println(stringBuilder.toString());
    }
}

```

## 10. Explain "Lambda can use unchanged variable outside of lambda", with code snippet.
Lambda expressions can access and use variables from the surrounding scope. However, these variables must be effectively final, which means that they should not be modified after being initialized. This restriction exists because lambdas and anonymous classes capture variables by value, not by reference. Ensuring that variables are effectively final prevents potential inconsistencies or unexpected behaviors that could arise from changes to these variables.
```java
public class LambdaExample {
    public static void main(String[] args) {
        String str = "String";
        // error
        String printStr = item -> System.out.println(str);

        // correct
        final String s = "String";
        String printString = item -> System.out.println(s);
    }
}

```

## 11. Can a functional interface extend/inherit another interface?
No.

Because it will change the fact that a functional interface allows only one abstract method. 
However, functional interface can inherit another interface which contains only static and default methods.

## 12. What are Intermediate and Terminal operations?
Intermediate operations returns a stream as a result, terminal operations return non-stream values or return nothing.
- Intermediate Operations: map(), filter(),  sorted(), limit(), distinct(), skip().
- Terminal Operations: forEach(), toArray(), min(), max(), count(), reduce(), collect(), anyMatch(), allMatch(), noneMatch(), findFirst(), findAny().

## 13. Demonstrate the most commonly used Intermediate operations in Stream API, with code snippet.
```java
class Main {
    public static void main(String[] args) {
        //Keep the first 5 elements
        Stream<Double> stream = Stream.generate(Math::random).limit(5);
    }
}
```

## 14. How are Collections different from Stream?
- Collections are responsible for storing data. 
- Stream refers to computation, responsible for processing data.