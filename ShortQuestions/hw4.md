# HW4

1.  **What is generic in Java?**
    
    Generic enables one class/interface/method to process different types of parameters
    
2. **Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned**
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
        
3. **Discuss Java 8 new features with code snippet**
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
        
4. **What are the advantages of the Optional class?**
    
    Use optional class improved code clarity, avoided NullPointerException errors, streamline Null checks. This approach transforms traditional null handling into a more expressive and safer practice, thereby improving the maintainability and robustness of Java applications.
    
5. **Explain Functional Interface and Lambda with code samples**
    
    The functional interface provide a target type for lambda expressions and method references. Functional interface only has one abstract method but several default or static methods eg:
    
    ```java
    
    @FunctionalInterface
    public interface Foo {
        String aMethod(String string);
    
        default String defaultBar(){
            String s = "default Bar method";
            System.out.println(s);
            return s;
        }
    
        default String defaultCommon(){
            String s = "defaultCommon from Bar";
            System.out.println(s);
            return s;
        }
    }
    ```
    
    Lambda expressions are a shorthand way of writing instances of single-method classes. 
    
    ```java
    public void lambdaFoo(){
            /*
            * lambda 表达式
            * 使用lambda 表达式的前提是Foo 必须是一个functional interface
            *
            * */
            Foo foo = param -> param + " testing";
            String hello = foo.aMethod("hello");
            System.out.println(hello);
        }
    ```
    
6. **Explain Method Reference with code samples?**
    
    Method reference provide a way to refer directly to methods of a class or instance without executing them. 
    
    Reference to an instance method of an arbitrary object of a particular type.
    
    ```java
    Stream<String> nameStream = employees.stream().map(Employee::getName);
    ```
    
7. **Explain "Lambda can use unchanged variable outside of lambda", with code snippet.**
    
    Lambda can use localVariable, but if we change localVariable to “Hello”, it can not be used anymore.We can reassign value of map and other reference type data structure since the address of map will not change.
    
    ```java
    public void testFinal(){
    //        String localVariable = "Local";
    //        localVariable = "hello";
            HashMap<Integer, String> map= new HashMap<>();
            // 内存地址不变
            map.put(1," local variable");
            map.put(1, "local changed");
            Foo foo = param -> {
               return param + " "+ map.get(1);
            };
    
            System.out.println(foo.aMethod("Hello"));
        }
    ```
    
8. **Can a functional interface extend/inherit another interface?**
    
    Yes, a functional interface in Java can extend or inherit from another interface, but the resulting interface must have exactly one abstract method. This rule ensures that the interface can be used effectively with lambda expressions and method references, which require a clear contract of a single functionality to implement.
    
9. **What are Intermediate and Terminal operations?**
    
    Intermediate operations are those operations on a stream that return another stream. These are kind of like steps in a pipeline that take a stream as input and transform it into another stream as output.
    
    Terminal operations are those operations that close a stream. Once a terminal operation has been invoked on a stream, it is consumed and cannot be used anymore. Terminal operations either produce a result (such as a sum, a maximum, a list, etc.)
    
10. **Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.**
    
    ```java
    filter(Predicate<T>)
    map(Function<T, R>)
    flatMap(Function<T, Stream<R>>)
    distinct()
    ```
    
11. **How are Collections different from Stream?**

Collections are primarily focused on storing and managing groups of data in memory with support for direct operations and modifications, whereas Streams in Java provide a high-level abstraction for defining complex data processing operations in a functional style without storing or altering the original data source.