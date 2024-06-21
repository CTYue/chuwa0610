# HW4

1. **Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned**
    1. Explicit Null Checks
        
        ```java
        public void printLength(String str) {
            if (str != null) {
                System.out.println(str.length());
            } else {
                System.out.println("String is null");
            }
        }
        ```
        
    2. Use Assertions
        
        ```java
        public void printLength(String str) {
            assert str != null : "String should not be null";
            System.out.println(str.length());
        }
        ```
        
    3. Optional and Nullable Types
        
        ```java
        public void printLength(Optional<String> strOpt) {
            strOpt.ifPresent(str -> System.out.println(str.length()));
        }
        ```
        
    4. Default values
        
        ```java
        public void printLength(String str) {
            String safeStr = (str != null) ? str : "";
            System.out.println(safeStr.length());
        }
        ```
        
    5. Design by Contract
        
        ```java
        import org.jetbrains.annotations.NotNull;
        public void printLength(@NotNull String str) {
            System.out.println(str.length());
        }
        ```
        
2. **Discuss Java 8 new features with code snippet**
    - Lambda Expressions
        
        ```java
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.forEach(name -> System.out.println(name));
        ```
        
    - Stream API
        
        ```java
        List<String> filtered = names.stream()
                                     .filter(s -> s.startsWith("A"))
                                     .collect(Collectors.toList());
        System.out.println(filtered);
        ```
        
    - Optional
        
        ```java
        Optional<String> optionalName = Optional.of("Alice");
        optionalName.ifPresent(name -> System.out.println(name));
        ```
        
    - Method Reference
        
        ```java
        names.forEach(System.out::println);
        ```
        
    - Default Methods
        
        ```java
        interface Vehicle {
            default void print() {
                System.out.println("I am a vehicle!");
            }
        }
        ```
        
3. **What are the advantages of the Optional class?**
    
    Use optional class improved code clarity, avoided NullPointerException errors, streamline Null checks. This approach transforms traditional null handling into a more expressive and safer practice, thereby improving the maintainability and robustness of Java applications.
    
4. **Explain Functional Interface and Lambda with code samples**
    
    The functional interface provide a target type for lambda expressions and method references. eg:
    
    ```
    •	Runnable, Callable (from the Java concurrency package)
    •	Comparator, Consumer, Function, Predicate, Supplier (from the Java java.util.function package)
    ```
    
    Lambda expressions are a shorthand way of writing instances of single-method classes. 
    
    ```java
    import java.util.List;
    import java.util.function.Consumer;
    
    public class LambdaExample {
        public static void main(String[] args) {
            List<String> names = List.of("Alice", "Bob", "Charlie");
    
            // Using a lambda expression with Consumer functional interface
            Consumer<String> printConsumer = name -> System.out.println(name);
            names.forEach(printConsumer);
        }
    }
    ```
    
5. **Explain Method Reference with code samples?**
    
    Method reference provide a way to refer directly to methods of a class or instance without executing them. 
    
    There are four types of method references in Java:
    
    1. Reference to a static method
        
        ```java
        public class MethodReferencesExample {
            public static boolean isPositive(int number) {
                return number > 0;
            }
        
            public static void main(String[] args) {
                List<Integer> numbers = Arrays.asList(-5, 0, 5, 10);
                long positiveCount = numbers.stream()
                                            .filter(MethodReferencesExample::isPositive)
                                            .count();
                System.out.println("Positive numbers count: " + positiveCount);
            }
        }
        ```
        
    2. Reference to an instance method of a particular object.
        
        ```java
        import java.util.function.BiPredicate;
        
        public class MethodReferencesExample {
            public static void main(String[] args) {
                String prefix = "Mr.";
                BiPredicate<String, String> startsWith = String::startsWith;
                boolean result = startsWith.test(prefix, "Mr. Smith");
                System.out.println("Starts with " + prefix + "? " + result);
            }
        }
        ```
        
    3. Reference to an instance method of an arbitrary object of a particular type.
        
        ```java
        public class MethodReferencesExample {
            public static void main(String[] args) {
                List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
                names.forEach(System.out::println);
            }
        }
        ```
        
    4. Reference to a constructor.
        
        ```java
        
        public class MethodReferencesExample {
            public static void main(String[] args) {
                List<String> numbers = Arrays.asList("1", "2", "3");
                List<Integer> intNumbers = numbers.stream()
                                                  .map(Integer::new)
                                                  .collect(Collectors.toList());
                System.out.println(intNumbers);
            }
        }
        ```
        
6. **Explain "Lambda can use unchanged variable outside of lambda", with code snippet.**
    
     lambda expressions can capture and use variables from the surrounding context where the lambda is defined. eg:
    
    ```java
    public class LambdaScopeExample {
        private int instanceVariable = 42;
    
        public void testLambdaScope() {
            int localVariable = 100;
    
            // This lambda expression uses both instance and local variables
            Runnable r = () -> {
                System.out.println("Instance variable: " + instanceVariable);
                System.out.println("Local variable: " + localVariable);
            };
    
            // Run the lambda
            r.run();
        }
    
        public static void main(String[] args) {
            new LambdaScopeExample().testLambdaScope();
        }
    }
    ```
    
7. **Can a functional interface extend/inherit another interface?**
    
    Yes, a functional interface in Java can extend or inherit from another interface, but the resulting interface must have exactly one abstract method. This rule ensures that the interface can be used effectively with lambda expressions and method references, which require a clear contract of a single functionality to implement.
    
8. **What are Intermediate and Terminal operations?**
    
    Intermediate operations are those operations on a stream that return another stream. These are kind of like steps in a pipeline that take a stream as input and transform it into another stream as output.
    
    Terminal operations are those operations that close a stream. Once a terminal operation has been invoked on a stream, it is consumed and cannot be used anymore. Terminal operations either produce a result (such as a sum, a maximum, a list, etc.)
    
9. **Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.**
    
    ```java
    filter(Predicate<T>)
    map(Function<T, R>)
    flatMap(Function<T, Stream<R>>)
    distinct()
    ```
    
10. **How are Collections different from Stream?**

Collections are primarily focused on storing and managing groups of data in memory with support for direct operations and modifications, whereas Streams in Java provide a high-level abstraction for defining complex data processing operations in a functional style without storing or altering the original data source.