# 1. Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.
1. **Initialize variables**: always initialize variables, especially member variables, when you declare them.  
    ```
    private String name = "";
    ```
2. **Use Optional**: use Optional to represent values that may or may not be present. This forces you to handle the absence of a value explicitly.
    ```
    import java.util.Optional;
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
    Optional<String> nameOpt = getName();
    nameOpt.ifPresent(name -> System.out.println(name));
    ```
3. **Null checks**: always check for null before accessing an object.
    ```
    if (name != null) {
        System.out.println(name.length());
    } else {
        System.out.println("Name is null");
    }
    ```

# 2. Discuss Java 8 new features with code snippet.
1. **Lambda Expressions**: Lambda expressions provide a clear and concise way to represent one method interface using an expression.
    ```
    import java.util.List;
    import java.util.ArrayList;
    public class LambdaExample {
        public static void main(String[] args) {
            List<String> list = new ArrayList<>();
            list.add("apple");
            list.add("banana");
            list.add("cherry");
            // Using lambda expression to iterate over a list
            list.forEach(item -> System.out.println(item));
        }
    }
    ```
2. **Stream API**: the Stream API is used to process collections of objects in a functional style.
    ```
    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Collectors;
    
    public class StreamExample {
        public static void main(String[] args) {
            List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");
    
            // Using Stream API to filter and collect results
            List<String> filtered = strings.stream()
                    .filter(s -> s.startsWith("a"))
                    .collect(Collectors.toList());
    
            System.out.println(filtered);
        }
    }
    ```
3. **Optional Class**: the Optional class is a container object which may or may not contain a non-null value.  
4. **Method References**: Method references provide a way to refer to methods without invoking them. They are often used to pass methods as arguments to other methods.
    ```
    import java.util.List;
    import java.util.ArrayList;
    public class MethodReferenceExample {
        public static void main(String[] args) {
            List<String> list = new ArrayList<>();
            list.add("apple");
            list.add("banana");
            list.add("cherry");
    
            // Using method reference to print each item
            list.forEach(System.out::println);
        }
    }
    ```
5. **New Date and Time API**: Java 8 introduced a new Date and Time API in java.time package which is more comprehensive and consistent.
    ```
    import java.time.LocalDate;
    import java.time.LocalTime;
    import java.time.LocalDateTime;
    public class DateTimeExample {
        public static void main(String[] args) {
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            LocalDateTime dateTime = LocalDateTime.now();
    
            System.out.println("Current Date: " + date);
            System.out.println("Current Time: " + time);
            System.out.println("Current DateTime: " + dateTime);
        }
    }
    ```

# 3. What are the advantages of the Optional class?
The Optional class in Java, introduced in Java 8, provides several advantages, particularly in enhancing code readability, safety, and expressiveness.
- Avoids NullPointerException: Optional helps in avoiding the dreaded NullPointerException by providing a clear way to represent absent values without using null.
- Clearer Intent: Using Optional makes it explicit when a value can be absent. This improves code readability and helps other developers understand that the value may not be present.
- Encourages Functional Programming: Optional promotes a functional approach to handling values, leveraging lambda expressions and method references to process values without explicit null checks.
- Provides Clear APIs: Optional provides a set of methods that clearly communicate the intention and provide a fluent API for handling absent values.

# 4. Explain Functional Interface and Lambda with code samples.
- **Functional Interface**
A functional interface in Java is an interface that contains exactly one abstract method. These interfaces can have any number of default or static methods but must have only one abstract method to be considered functional. Functional interfaces are intended to be used with lambda expressions, method references, or constructor references.  
The @FunctionalInterface annotation is used to indicate a functional interface. This annotation is optional but helps in clarifying the intention and generates a compile-time error if the interface does not satisfy the conditions of a functional interface.  
    ```
    @FunctionalInterface
    interface MyFunctionalInterface {
        void execute();
        default void defaultMethod() {
            System.out.println("This is a default method");
        }
        static void staticMethod() {
            System.out.println("This is a static method");
        }
    }
    ```
- **Lambda Expressions**
Lambda expressions provide a clear and concise way to represent one method interface using an expression. They can be used to create instances of functional interfaces. Lambda expressions are similar to methods but do not need a name and can be implemented right in the body of a method.
    ```
    public class LambdaExample {
        public static void main(String[] args) {
            // Using a lambda expression to implement the execute method of MyFunctionalInterface
            MyFunctionalInterface myFunc = () -> System.out.println("Executing lambda expression");
            
            // Calling the method
            myFunc.execute();
        }
    }
    ```
    Using Lambda with Built-in Functional Interfaces: Java 8 provides several built-in functional interfaces in the java.util.function package, such as Predicate, Function, Consumer, and Supplier.
    ```
    import java.util.function.Predicate;
    public class PredicateExample {
        public static void main(String[] args) {
            Predicate<String> isEmpty = s -> s.isEmpty();
            
            System.out.println(isEmpty.test(""));  // true
            System.out.println(isEmpty.test("not empty"));  // false
        }
    }
    ```

# 5. Explain Method Reference with code samples?
Method references in Java are a shorthand notation of a lambda expression to call a method. They provide a way to refer to methods without executing them. Method references can be used to replace certain lambda expressions to make the code more readable and concise.
- Reference to a Static Method
    ```
    import java.util.Arrays;
    import java.util.List;
    import java.util.function.Consumer;
    public class StaticMethodReference {
        public static void main(String[] args) {
            List<String> list = Arrays.asList("apple", "banana", "cherry");
            // Using a lambda expression
            list.forEach(item -> StaticMethodReference.printItem(item));
            // Using a method reference to a static method
            list.forEach(StaticMethodReference::printItem);
        }
        public static void printItem(String item) {
            System.out.println(item);
        }
    }
    ```
- Reference to an Instance Method of a Particular Object
    ```
    import java.util.function.Consumer;
    public class ParticularInstanceMethodReference {
        public static void main(String[] args) {
            ParticularInstanceMethodReference instance = new ParticularInstanceMethodReference();
            // Using a lambda expression
            Consumer<String> consumer1 = item -> instance.printItem(item);
            consumer1.accept("Hello, world!");
            // Using a method reference to an instance method of a particular object
            Consumer<String> consumer2 = instance::printItem;
            consumer2.accept("Hello, method reference!");
        }
        public void printItem(String item) {
            System.out.println(item);
        }
    }
    ```
- Reference to an Instance Method of an Arbitrary Object of a Particular Type
    ```
    import java.util.Arrays;
    import java.util.List;
    import java.util.function.Function;
    public class ArbitraryInstanceMethodReference {
        public static void main(String[] args) {
            List<String> list = Arrays.asList("apple", "banana", "cherry");
            // Using a lambda expression
            list.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
            // Using a method reference to an instance method of an arbitrary object
            list.sort(String::compareToIgnoreCase);
            list.forEach(System.out::println);
        }
    }
    ```
- Reference to a Constructor
    ```
    import java.util.function.Function;
    public class ConstructorReference {
        public static void main(String[] args) {
            // Using a lambda expression
            Function<String, Integer> lambdaConverter = (String s) -> new Integer(s);
            Integer result1 = lambdaConverter.apply("123");
            System.out.println(result1);
            // Using a method reference to a constructor
            Function<String, Integer> referenceConverter = Integer::new;
            Integer result2 = referenceConverter.apply("456");
            System.out.println(result2);
        }
    }
    ```

# 6. Explain "Lambda can use unchanged variable outside of lambda", with code snippet.
lambda expressions can capture and use variables from the enclosing scope. However, these variables must be effectively final, meaning they cannot be changed after they are initialized. This is because lambdas and anonymous classes can capture variables by value, not by reference. The "effectively final" requirement ensures that there are no inconsistencies or unexpected behaviors due to variable changes.
- Correct use:
    ```
    import java.util.Arrays;
    import java.util.List;
    import java.util.function.Consumer;
    public class LambdaExample {
        public static void main(String[] args) {
            // Define a variable outside the lambda
            final String prefix = "Item: ";
            List<String> items = Arrays.asList("apple", "banana", "cherry");
            // Use the variable inside the lambda
            Consumer<String> printItem = item -> System.out.println(prefix + item);
            items.forEach(printItem);
        }
    }
    ```
- Incorrect use:
    ```
    import java.util.Arrays;
    import java.util.List;
    public class LambdaErrorExample {
        public static void main(String[] args) {
            List<String> items = Arrays.asList("apple", "banana", "cherry");
            String prefix = "Item: ";
            // Uncommenting the next line will cause a compilation error
            // prefix = "New Item: ";
            items.forEach(item -> System.out.println(prefix + item));
        }
    }
    ```

# 7. Can a functional interface extend/inherit another interface?
Yes, a functional interface can extend or inherit from another interface. However, there are specific conditions that must be met for the interface to still be considered a functional interface:
- Single Abstract Method: The extending interface must still have exactly one abstract method, either inherited or newly declared, to qualify as a functional interface.  
- Default and Static Methods: The interface can have any number of default or static methods

# 8. What are Intermediate and Terminal operations?
In Java's Stream API, operations are divided into two categories: intermediate operations and terminal operations.  
- **Intermediate Operations**
Intermediate operations are those that transform a stream into another stream. They are lazy, meaning they do not perform any processing until a terminal operation is invoked on the stream. Intermediate operations are used to build a pipeline of operations to be applied to the stream elements.
- **Terminal Operations**  
Terminal operations produce a result or a side effect and mark the end of the stream processing. After a terminal operation is invoked, the stream pipeline is considered consumed and can no longer be used.

# 9. Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.
Common Intermediate Operations:
- filter: Filters elements based on a predicate.
- map: Transforms each element using a function.
- flatMap: Flattens nested structures.
- distinct: Removes duplicate elements.
- sorted: Sorts the elements.
- peek: Performs an action on each element as it is consumed from the stream.
- limit: Truncates the stream to a given number of elements.
- skip: Skips the first n elements  

Example:
```
import java.util.Arrays; 
import java.util.List; 
import java.util.stream.Collectors;
public class CombinedOperationsExample {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "banana", "cherry", "apple", "date");
        
        List<String> result = items.stream()
                                   .filter(s -> s.length() > 5)
                                   .distinct()
                                   .sorted()
                                   .limit(2)
                                   .collect(Collectors.toList());
        
        System.out.println(result);  // Output: [banana, cherry]
    }
}
```

# 10. How are Collections different from Stream?
- **Collections**
    - Characteristics:
        - In-memory Data Structure: Collections are in-memory data structures that store and manage a group of objects.
        - Eager Evaluation: Operations on collections are performed eagerly, meaning the result is computed immediately.
        - Mutability: Most collection implementations are mutable, allowing you to add, remove, and modify elements.
        - Iterative Processing: Collections provide methods for iterating over elements using loops or iterators.
        - Storage and Retrieval: Collections are primarily designed for storing, retrieving, and manipulating data.
    - Examples:
        - List: ArrayList, LinkedList
        - Set: HashSet, TreeSet
        - Map: HashMap, TreeMap

- **Streams**
    - Characteristics:
        - Pipeline of Computation: Streams represent a pipeline of computation on data, which can be used to process collections or other data sources.
        - Lazy Evaluation: Stream operations are performed lazily, meaning intermediate operations are not executed until a terminal operation is invoked.
        - Immutability: Streams are immutable. They do not modify the underlying data source but produce new streams.
        - Functional-style Processing: Streams use a functional-style approach, allowing operations like map, filter, and reduce to be chained together.
        - Single-use: Streams cannot be reused once a terminal operation is performed. You need to create a new stream to perform additional operations.
    - Examples:
        - Stream: Stream, IntStream, LongStream, DoubleStream

- Summary
    - Purpose:
        - Collections: Designed for storing and managing in-memory data.
        - Streams: Designed for processing sequences of elements, providing a high-level way to perform aggregate operations on collections.
    - Data Storage:
        - Collections: Store data.
        - Streams: Do not store data; they are a view of data that can be processed.
    - Evaluation:
        - Collections: Operations are performed eagerly.
        - Streams: Operations are performed lazily.
    - Mutability:
        - Collections: Typically mutable.
        - Streams: Immutable.
    - Usage:
        - Collections: Used to hold and manage data.
        - Streams: Used to process data in a functional style.
    - Reusability:
        - Collections: Can be reused.
        - Streams: Cannot be reused after a terminal operation.











