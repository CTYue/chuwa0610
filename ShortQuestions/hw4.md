# HW4

## 1. What is generic in Java? and type the following generic tutorial code by yourself.

- Generics in Java are used to create classes, interfaces, and methods with a placeholder for types. This enables type safety and code reusability by allowing the same code to work with different data types.

## 2. Read the follwoing code repo and type it one by one by yourself.

## 3. Practice following stream API exercises at least 3 times

## 4. Practice Optional methods at least 2 times

## 5. Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.

- Use Optional for return types: 
```java
Optional<String> getValue() {
    return Optional.ofNullable(value);
}
```

- Use Objects.requireNonNull
```java
public void setName(String name) {
    this.name = Objects.requireNonNull(name, "Name cannot be null");
}
```

- Default Values
```java
String name = (inputName != null) ? inputName : "defaultName";
```

- Null checks
```java
if (object != null) {
    object.doSomething();
}
```

## 6. Discuss Java 8 new features with code snippet

- Lambda Expressions
```java
List<String> list = Arrays.asList("a", "b", "c");
list.forEach(s -> System.out.println(s));
```

- Streams API
```java
List<String> list = Arrays.asList("a", "b", "c");
list.stream()
    .filter(s -> s.startsWith("a"))
    .forEach(System.out::println);
```

- Default Methods
```java
interface MyInterface {
    default void defaultMethod() {
        System.out.println("Default method");
    }
}
```

- Optional
```java
Optional<String> optional = Optional.ofNullable("value");
optional.ifPresent(System.out::println);
```

## 7. What are the advantages of the Optional class?

- Avoid NullPointerException
- Improve Code Readability

## 8. Explain Functional Interface and Lambda with code samples

### 1. Functional Interface
- It is an interface with a single abstract method, used as a target for lambda expressions and method references. It can have default and static methods but only one abstract method. 
```java
@FunctionalInterface
interface MyFunctionalInterface {
    void execute();
}
```

### 2. Lambda Expression
- A lambda expression provides a clear and concise way to represent an instance of a functional interface using an expression. It is essentially a shorthand for implementing a functional interface.
```java
MyFunctionalInterface func = () -> System.out.println("......");
func.execute();
```

## 9. Explain Method Reference with code samples?
- A method reference is a  way to refer to a method. It uses :: and can refer to static methods, instance methods and Constructors

### 1. Static Method
```java
Function<String, Integer> methodRef = Integer::parseInt;
System.out.println(methodRef.apply("123"));
```

### 2. Instance Methdo
```java
List<String> list = Arrays.asList("a", "b", "c");
list.forEach(String::toUpperCase);
```

### 3. Constructor
```java
List<List<String>> methodRef = ArrayList::new;
List<String> list = methodRef.get();
```

## 10. Explain "Lambda can use unchanged variable outside of lambda", with code snippet.
- lambda expressions can capture and use variables from their enclosing scope, but these variables must be effectively final. This means the variable cannot be modified after it is assigned.
```java
public class LambdaExample {
    public static void main(String[] args) {
        int number = 10; // Effectively final variable
        Runnable lambda = () -> System.out.println(number);
        lambda.run();
    }
}
```

## 11. Can a functional interface extend/inherit another interface?

- Yes, a functional interface can extend another interface. However, the extended interface must also be a functional interface, meaning it must have exactly one abstract method. The extended interface can have any number of default or static methods.

## 12. What are Intermediate and Terminal operations?

- Intermediate operations are operations that transform the stream into another stream. They are lazy, meaning they do not process elements until a terminal operation is invoked. Ex: map(), filter(), sorted(), limit()

- Terminal operations are operations that produce a result or a side-effect. They trigger the processing of elements in the stream pipeline. Ex: forEach(), toArray(), collect(), min(), max()

## 13. Demontrate the most commonly used Intermediate operations in Stream API, with code snippet

- filter(). It filters elements based on a predicate
- map(). It transforms elements using a mapper function
- sorted(). It sorts the elements of the stream
- limit(). Limits the number of elements in the stream
- skip(). Skips the specified number of elements in the stream

```java
List<String> names = Arrays.asList("Apple", "Banana", "Carrot");
List<String> result = names.stream()
                           .filter(name -> name.length() > 3)
                           .map(String::toUpperCase)
                           .sorted()
                           .collect(Collectors.toList());
```

## 14. How are Collections different from Stream?
- Collections are mostly used for data storage. On the contrary, Streams are used for computation and data processing.
- Collections use methods that directly manipulate the data (e.g., add, remove). On the contrary, Streams use intermediate operations (e.g., map, filter) followed by a terminal operation (e.g., collect, forEach) to process data.
