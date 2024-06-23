# Homework 4

## Yirun Wang

### 1. What is generic in Java？
Generics refer to the ability to use a type as a parameter to methods and classes. This provides the ability to define a set of related classes or methods that can operate on many different types with a single declaration. 


### 5. Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.
1. Use Optional
```
Optional<User> optionalUser = Optional.ofNullable(userMap.get(2));
// Using isPresent() to check if the Optional contains a value
if (optionalUser.isPresent()) {
    User user = optionalUser.get();
    // Perform some business logic with the user object
    System.out.println("Performing business logic with user: " +
user.getName());
} else {
    System.out.println("User not found.");
}
```

2. Set defalt value when null
```
HashMap<Integer, Integer> hashmap = new HashMap<>();
System.out.println(hashmap.getOrDefault(1));
```
```
public static String getUppercaseOrDefault(String str) {
    return (str != null) ? str.toUpperCase() : "Default Value";
}
```

### 6. Discuss Java 8 new features with code snippet.
1. default method and static method in interface
Default methods allow interfaces to provide implementations for methods.
```
public interface MyFunctionalInterface {
    static final String str = "static final String";

    void execute();
    default void greet() {
        System.out.println("hi");
    }
}
```
2. Functional Interface
With one abstract method, and they can be used as the assignment target for lambda expressions.
```
interface MyFunctionalInterface {
    void execute();
}
// when use
MyFunctionalInterface func = () -> System.out.println("Executing");
func.execute();
```

3. Lambda
Lambda expressions provide a clear and concise way to represent one method interface using an expression.
```
List<Integer> list = Arrays.asList(1, 2, 3);
list.forEach(item -> System.out.println(item));
```

4. Optional
Optional is a container object which may or may not contain a non-null value.
```
Optional<User> optionalUser = Optional.ofNullable(userMap.get(2));
// Using isPresent() to check if the Optional contains a value
if (optionalUser.isPresent()) {
    User user = optionalUser.get();
    // Perform some business logic with the user object
    System.out.println("Performing business logic with user: " +
user.getName());
} else {
    System.out.println("User not found.");
}
```

5. Streams API
Process sequences of elements in a functional style.
```
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

int sum = numbers.stream()
    .filter(n -> n % 2 == 0)
    .mapToInt(n -> n * n)
    .sum();
```

### 7. What are the advantages of the Optional class?
Reduces the risk of NullPointerException by explicitly handling optional values.
- With Optional.ofNullable(), it wraps your object in an Optional object like this: Optional<T> optional = Optional.ofNullable(T). You can then use the various methods provided by Optional to handle the cases where the value is present or not. The isPresent() method returns true if the value is present, and false if it is not.
- .orElse() will return the value wrapped in the Optional, or a default value when it is not present.
- .orElseThrow() is used to throw an exception if the Optional is empty. 

### 8. Explain Functional Interface and Lambda with code samples.
Functional interface has only one single abstract method.
But it can have many default methods.
Add @FunctionalInterface for sanity check, but it is not mandatory。
Lambda is the implementation of the abstract interface.
```
@FunctionalInterface
interface MyFunctionalInterface {
    void singleAbstractMethod();
    
    // Default method
    default void defaultMethod() {
        System.out.println("This is a default method");
    }

    // Static method
    static void staticMethod() {
        System.out.println("This is a static method");
    }
}
```
Lambda is a concise way to represent an instance of a functional interface.
The syntax is:
```
(parameters) -> expression
(parameters) -> { statements; }
```
```
    // Using a lambda expression to implement the abstract method of the functional interface
    MyFunctionalInterface myFunc = () -> System.out.println("Lambda Expression Implementation");

    // Calling the method implemented by the lambda expression
    myFunc.singleAbstractMethod();

    // Calling the default method
    myFunc.defaultMethod();

    // Calling the static method
    MyFunctionalInterface.staticMethod();
```
### 9. Explain Method Reference with code samples
Method references in Java 8 provide a way to refer to methods without invoking them. They are a shorthand notation for lambda expressions that execute just one method. Method references make the code more readable and concise.
1. Reference to static method:
```
ClassName::staticMethodName
```
```
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Using method reference to refer to a static method
        numbers.forEach(Main::printNumber);
    }

    public static void printNumber(int number) {
        System.out.println(number);
    }
}
```
2. Reference to an Instance Method of a Particular Object
```
instance::instanceMethodName
```
```
Comparator<Person> byAgeComparator = Comparator.comparingInt(Person::getAge); people.sort(byAgeComparator);

class Person {
    private String name;
    private int age;

    public Person(String name) {
        this.name = name;
    }
    public int getAge(){
        return this.age;
    }
    @Override
    public String toString() {
        return name;
    }
}
```
3. Reference to an Instance Method of an Arbitrary Object of a Particular Type
```
ClassName::instanceMethodName
```
```
public class Main {
    public static void main(String[] args) {
        List<String> messages = Arrays.asList("Hello", "World", "Method", "References");

        // Using method reference to refer to an instance method of an arbitrary object of a particular type
        messages.forEach(String::toUpperCase);
        
        // Print all the messages in uppercase
        messages.forEach(System.out::println);
    }
}
```
4. Reference to a Constructor
```
ClassName::new
```
```
public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.stream()
             .map(Person::new)  // Reference to Person constructor
             .forEach(System.out::println);
    }

    public void printWelcome() {
        System.out.println("Welcome!");
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
```

### 10. Explain "Lambda can use unchanged variable outside of lambda", with code snippet.
lambda expressions can access variables from the surrounding scope. But they must be final or effectively final variables. 
```
        String localVariable = "Local";
        localVariable = "LOCAL"; // 新的内存地址

        // 报错：java: local variables referenced from a lambda expression must be
        // final or effectively final
        Foo foo = parameter -> {
            return parameter + " " + localVariable;
            return parameter;
        };

```

### 11. Can a functional interface extend/inherit another interface?
Yes, functional interfaces in Java can extend other interfaces. Althogh in a functional interface there can be only one abstract method.

### 12. What are Intermediate and Terminal operations?
Intermediate operations in Java Streams are operations that return a new Stream. They are typically chained together to form a pipeline that modifies or transforms the elements in the original Stream. 
Some common intermedita operations include: filter, limit, skip, distinct, map, flatMap, sort.

Terminal operations are operations that produce a result or a side-effect. They are executed only after all intermediate operations have been completed. Once a terminal operation is invoked on a Stream, the Stream is consumed and cannot be used again.
Some common terminal operations include: forEach, collect, reduce, count.

### 13. Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.
```
// Sample list of strings
    List<String> words = Arrays.asList("java", "python", "javascript", "ruby", "c", "swift", "java");

    // Filter operation: Filter strings starting with 'j'
    List<String> filteredList = words.stream()
                                    .filter(s -> s.startsWith("j"))
                                    .collect(Collectors.toList());
    System.out.println("Filtered List: " + filteredList);  // Output: [java, javascript]

    // Limit operation: Limit to first 3 elements
    List<String> limitedList = words.stream()
                                    .limit(3)
                                    .collect(Collectors.toList());
    System.out.println("Limited List: " + limitedList);  // Output: [java, python, javascript]

    // Skip operation: Skip first 2 elements
    List<String> skippedList = words.stream()
                                    .skip(2)
                                    .collect(Collectors.toList());
    System.out.println("Skipped List: " + skippedList);  // Output: [javascript, ruby, c, swift, java]

    // Distinct operation: Remove duplicates
    List<String> distinctList = words.stream()
                                    .distinct()
                                    .collect(Collectors.toList());
    System.out.println("Distinct List: " + distinctList);  // Output: [java, python, javascript, ruby, c, swift]

    // Map operation: Convert each string to uppercase
    List<String> mappedList = words.stream()
                                .map(String::toUpperCase)
                                .collect(Collectors.toList());
    System.out.println("Mapped List: " + mappedList);  // Output: [JAVA, PYTHON, JAVASCRIPT, RUBY, C, SWIFT, JAVA]

    // FlatMap operation: Split each string into characters and flatten the Stream
    List<String> phrases = Arrays.asList("Hello World", "Java Streams");
    List<String> flatMappedList = phrases.stream()
                                        .flatMap(s -> Arrays.stream(s.split(" ")))
                                        .collect(Collectors.toList());
    System.out.println("FlatMapped List: " + flatMappedList);  // Output: [Hello, World, Java, Streams]

    // Sorted operation: Sort strings alphabetically
    List<String> sortedList = words.stream()
                                .sorted()
                                .collect(Collectors.toList());
    System.out.println("Sorted List: " + sortedList);  // Output: [c, java, java, javascript, python, ruby, swift]
```

### 14. How are Collections different from Stream?
Collections are mainly about storing and managing a collection of elements, while Streams are sequences of elements that support sequential and parallel aggregate operations.

- For Collections, data structure holds all the data elements, while in Streams, no data is stored.
- For Collections, to process elements in a collection, you typically use iterators or enhanced for loops. But you can use internal interation with Streams.
- The elements are easy to access in Collections, but there is no direct way to access specific element in Stream.


### Leetcode 1748
```
class Solution {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Long> elementCount = Arrays.stream(nums)
                                        .boxed()
                                        .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        return elementCount.entrySet()
                           .stream()
                           .filter(entry -> entry.getValue() == 1)
                           .mapToInt(Map.Entry::getKey)
                           .sum();
    }
}
```
