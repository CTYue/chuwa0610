## 1.  What is generic in Java?  and type the following generic tutorial code by yourself.
- Generics in Java is a powerful feature that allows developers to write flexible and reusable code. They enable classes, interfaces, and methods to operate on objects of various types while providing compile-time type safety.
- See Coding/PracticeGeneric/

## 2.  Read the follwoing code repo and type it one by one by yourself.
- See Coding/PracticeRepo/

## 3.  Practice following stream API exercises at least 3 times
- See Coding/PracticeStreamAPI/

## 4.  Practice Optional methods at least 2 times
- See Coding/PracticeOptional/


## 5.  Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.
### Collections
- Collections are used to store and manage groups of objects. They provide data structures such as lists, sets, and maps.
- Collections actually store the data elements.
- Collections are generally mutable.
- Collections are not lazy.
- 
### Streams
- Streams are used for processing sequences of elements, providing a functional approach to handling collections of data. They support operations like map, filter, and reduce.
- Streams do not store data.
- Streams are immutable.
- Stream operations are lazy

## 6.  Discuss Java 8 new features with code snippet.
###  Lambda Expressions

```java
ArrayList<Integer> arr = new ArrayList<Integer>();
arr.add(1);
arr.add(2);
arr.add(3);
arr.forEach((n)->{System.out.println(n);});
```


### Functional Interfaces
```java
interface Func{
    void animalsound(string message);
}
public class test{
    public static void main(String[] args) {
        Func func = message -> {System.out.println("sound of : "+message);};
        func.animalsound("cat");
    }
}

```

### Stream API
```java
 List<String> names = Arrays.asList("abc", "bef", "drew", "dttw");
        names.stream()
             .filter(name -> name.startsWith("d"))
             .forEach(System.out::println);

```

###  Optional
```java
Optional<String> optional = Optional.of("Hello");
optional.ifPresent(System.out::println);
```


## 7.  What are the advantages of the Optional class?
- The Optional class is a container object used to contain not-null objects. It is used to avoid null checks and NullPointerException.



## 8.  Explain Functional Interface and Lambda with code samples.
```java
@FunctionalInterface
interface Testinterface {
    void animalsound(String message);
}

public static void main(String[] args) {

    Testinterface testinterface = (message) -> System.out.println(message);
    myFunc2.animalsound("cat sound");
    
}
```



## 9.  Explain Method Reference with code samples?
```java
import java.util.function.Function;
public class MethodReference {
    public static void main(String[] args) {
        Function<String, Integer> StrongtoInt = str -> Integer.parseInt(str);
        System.out.println(StrongtoInt.apply("123"));
    }
}
```






## 10.  Explain "Lambda can use unchanged variable outside of lambda", with code snippet.
```java
public class Lambda {
    public static void main(String[] args) {
        String number = "1";
        Function<String, Integer> StrongtoInt = str -> Integer.parseInt(str) + Integer.parseInt(number);
//        number = "123154"; // this is not allow
        System.out.println(StrongtoInt.apply("123")); // 124
    }
}
```



## 11.  Can a functional interface extend/inherit another interface?
-Yes, a functional interface in Java can extend another interface. If a functional interface extends another interface, it can still be considered a functional interface as long as it contains exactly one abstract method.

## 12.  What are Intermediate and Terminal operations?
### Intermediate operation in stream 
- Intermediate operations transform a stream into another stream.
- For example : filter(), map(),flatMap();
### Terminal operation in stream
- Terminal operations is a result or a side effect and mark the end of the stream pipeline.
- forEach(), findAny(),findFirst();


## 13.  Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
List<String> filteredNames = names.stream()
                                  .filter(name -> name.startsWith("A"))
                                  .collect(Collectors.toList());

List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
List<String> filteredNames = names.stream()
        .filter(name -> name.startsWith("A"))
        .map(name->"good" + name)
        .collect(Collectors.toList());



```


## 14.  How are Collections different from Stream?
- Collections are used to store and manage groups of objects, Stream is design for processing flow of data it does not store.
- Collections are mutable but Stream is not.
- Collections result are precalculated but Stream is lazy evaluation.








