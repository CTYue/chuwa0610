1. What is generic in Java?  and type the following generic tutorial code by yourself

   - generics allow you to define classes, interfaces, and methods with a placeholder for types that can be specified when you instantiate or invoke them.

2. Read the follwoing code [repo](https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/features) and type it one by one by yourself.

3. Practice following stream API [exercises](https://github.com/gavinklfong/stream-api-exercises/blob/main/src/test/java/space/gavinklfong/demo/streamapi/StreamApiTest.java) at least 3 times

4. Practice [Optional methods](https://github.com/CTYue/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/exercise/ShoppingCartUtil.java) at least 2 times

5. Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.

   1. Use `Optional` (Java 8+)

      ```java
      public class User {
          private String name;
      
          public Optional<String> getName() {
              return Optional.ofNullable(name);
          }
      }
      
      User user = new User();
      String name = user.getName().orElse("Default Name");
      ```

   2. Always Initialize Objects to Default Value

      ```java
      public class Example {
          private String message = "";
      
          public void printMessage() {
              System.out.println(message);
          }
      }
      
      // Usage
      Example example = new Example();
      example.printMessage();
      ```

   3. Use Null Checks Before Rendering

      ```java
      public void printMessage(String message) {
          if (message != null) {
              System.out.println(message);
          } else {
              System.out.println("Empty Message");
          }
      }
      // Or use ternary operator
      System.out.println(message != null ? message : "Default Message");
      ```

6. Discuss Java 8 new features with code snippet.

   1. **Functional Interface**

      A functional interface is an interface that has exactly one abstract method, but it can have multiple default or static methods. Functional interfaces are used as the basis for lambda expressions and method references, which provide a more concise way to implement single-method interfaces.

      ```java
      @FunctionalInterface
      interface MyFunctionalInterface {
          void myMethod();
      }
      
      // You can implement it with a lambda expression:
      MyFunctionalInterface  myFunc = () -> {
        System.out.println("This is an implementation of MyFuctionalInterface.");
      };
      myFunc.myMethod();
      ```

      Commonly used Functional Interfaces:

      - `Predicate<T>`: Represents a boolean-valued function of one argument.

      - `Function<T, R>`: Represents a function that takes one argument and produces a result.
      - `Supplier<T>`: Represents a supplier of results. Takes no argument and return a result.
      - `Consumer<T>`: Represents an operation that takes a single input argument and returns no result.
      - `BiFunction<T, U, R>`: Represents a function that takes two arguments and produces a result.

   2. **Lambda Expression**

      A lambda expression in Java is a concise way to represent an anonymous function that can be passed around and executed.

      **Syntax**: `(parameters) -> expression` or `(parameters) -> { statements; }`

      ```java
      // Predicate<T>
      Predicate<Integer> isEven = (n) -> n % 2 == 0;
      System.out.println(isEven.test(4)); // Output: true
      
      // Function<T, R>
      Function<String, Integer> stringLength = (s) -> s.length();
      System.out.println(stringLength.apply("Hello")); // Output: 5
      
      // Supplier<T>
      Supplier<String> stringSupplier = () -> "Hello, Supplier!";
      System.out.println(stringSupplier.get());
      
      // Consumer<T>
      Consumer<String> print = (s) -> System.out.println(s);
      print.accept("Hello, World!"); // Output: Hello, World!
      
      //BiFuction<T, U, R>
      BiFunction<Integer, Integer, Integer> addFunction = (x, y) -> x + y;
      int result = addFunction.apply(5, 3);
      ```

   3. **Optional**

      `Optional` is a container object introduced in Java 8 that may or may not contain a non-null value. It reduces the risk of `NullPointerException` and improving code readability by explicitly expressing the possibility of a value being absent.

      - **`Optional.of()`**: Creates an Optional with the given non-null value. It throws NullPointerException if the value is null.

        ```java
        Optional<String> optional = Optional.of("Hello");
        ```

      - **`Optional.ofNullable()`**: This method creates an `Optional` with the given value, which may be null. If the value is null, it returns an empty `Optional`.

        ```java
        Optional<String> optional = Optional.ofNullable(null);
        ```

      - **`Optional.empty()`**: Creates an empty Optional object.

        ```java
        Optional<String> emptyOptional = Optional.empty();
        ```

      - **`Optional` can't be created with `new` because the constructor is private. we can only create `Optional` with factory methods provided (above).**

      - **`isPresent()`**: Checks if a value is present.

        ```java
        if (optional.isPresent()) {
            System.out.println("Value is present");
        }
        ```

      - **`ifPresent(Consumer<? super T> action)`**: Executes the given action if a value is present.

        ```java
        optional.ifPresent(value -> System.out.println("Value: " + value));
        ```

      - **`orElse(T other)`**: Returns the value if present; otherwise, returns the other specified value.

        ```java
        String value = optional.orElse("Default Value");
        ```

      - **`orElseGet(Supplier<? extends T> other)`**: Returns the value if present; otherwise, returns the result produced by the supplying function.

        ```java
        String value = optional.orElseGet(() -> "Default Value");
        ```

      - **`orElseThrow(Supplier<? extends X> exceptionSupplier)`**: Returns the value if present; otherwise, throws an exception provided by the supplier.

        ```java
        String value = optional.orElseThrow(() -> new IllegalArgumentException("Value is absent"));
        ```

      - **`map(Function<? super T, ? extends U> mapper)`**: If a value is present, applies the provided mapping function to it and returns an `Optional` describing the result. If no value is present, returns an empty `Optional`.

        ```java
        Optional<String> optional = Optional.of("Hello");
        Optional<Integer> lengthOptional = optional.map(String::length);
        lengthOptional.ifPresent(length -> System.out.println("Length: " + length));
        // Output: Length: 5
        ```

      - **`flatMap(Function<? super T, Optional<U>> mapper)`**: Similar to `map`, but the mapping function returns an `Optional`.

        ```java
        Optional<String> optional = Optional.of("Hello");
        // different with map: the method inside flatMap returns an Optional.
        Optional<Integer> lengthOptional = optional.flatMap(value -> Optional.of(value.length()));
        lengthOptional.ifPresent(length -> System.out.println("Length: " + length)); 
        // Output: Length: 5
        ```

   4. **Stream**

      1. **Creating a Stream**

         ```java
         // Creating a stream from a collection
         List<String> stringList = Arrays.asList("a", "b", "c", "d");
         Stream<String> streamFromList = stringList.stream();
         
         // Creating a stream from an array
         String[] stringArray = {"a", "b", "c", "d"};
         Stream<String> streamFromArray = Arrays.stream(stringArray);
         
         // Creating a stream using the Stream.of() method
         Stream<String> streamOf = Stream.of("a", "b", "c", "d");
         ```

      2. **Intermediate Operations**

         Intermediate operations return a new stream. They are lazy, meaning they are not executed until a terminal operation is called.

         - **`filter(Predicate<? super T> predicate)`**: Filters elements based on a predicate.
         - **`map(Function<? super T, ? extends R> mapper)`**: Transforms each element using a mapping function.
         - **`sorted()` or `sorted(Comparator<? super T> comparator)`**: Sorts the elements of the stream.
         - **`distinct()`**: Removes duplicate elements.
         - **`limit(long maxSize)`**: Truncates the stream to a specified number of elements.
         - **`skip(long n)`**: Skips the first `n` elements.

         ```java
         List<String> stringList = Arrays.asList("a", "b", "a", "c", "b", "d");
         
         List<String> result = stringList.stream()
             .filter(s -> !s.equals("a")) // Remove "a"
             .map(String::toUpperCase) // Convert to uppercase
             .distinct() // Remove duplicates
             .sorted() // Sort the elements
             .collect(Collectors.toList()); // Collect the result into a list
         ```

         

      3. **Terminal Operations**

         Terminal operations produce a result or a side-effect and terminate the stream.

         - **`forEach(Consumer<? super T> action)`**: Performs an action for each element.

         - **`collect(Collector<? super T, A, R> collector)`**: Converts the stream into a collection or other data structure.

         - **`reduce(BinaryOperator<T> accumulator)`**: Reduces the elements to a single value using an associative accumulation function.

         - **`count()`**: Returns the number of elements in the stream.

         - **`anyMatch(Predicate<? super T> predicate)`**: Returns `true` if any elements match the predicate.

         - **`allMatch(Predicate<? super T> predicate)`**: Returns `true` if all elements match the predicate.

         - **`noneMatch(Predicate<? super T> predicate)`**: Returns `true` if no elements match the predicate.

         - **`findFirst()`**: Returns the first element in the stream.

         - **`findAny()`**: Returns any element in the stream.

           ```java
           List<String> stringList = Arrays.asList("a", "b", "a", "c", "b", "d");
           
           // forEach example
           stringList.stream()
               .forEach(s -> System.out.print(s + " ")); // Output: a b a c b d 
           
           // collect example
           List<String> collectedList = stringList.stream()
               .distinct()
               .collect(Collectors.toList());
           System.out.println(collectedList); // Output: [a, b, c, d]
           
           // reduce example
           Optional<String> concatenated = stringList.stream()
               .reduce((s1, s2) -> s1 + s2);
           concatenated.ifPresent(System.out::println); // Output: abacbd
           
           // count example
           long count = stringList.stream()
               .distinct()
               .count();
           System.out.println(count); // Output: 4
           
           // findFirst example
           Optional<String> firstElement = stringList.stream()
               .findFirst();
           firstElement.ifPresent(System.out::println); // Output: a
           ```

           

7. What are the advantages of the Optional class?

   - It reduces the risk of `NullPointerException` and improving code readability by explicitly expressing the possibility of a value being absent.

8. Explain Functional Interface and Lambda with code samples.

   - A functional interface is an interface that has exactly one abstract method, but it can have multiple default or static methods. Functional interfaces are used as the basis for lambda expressions and method references, which provide a more concise way to implement single-method interfaces.

     ```java
     @FunctionalInterface
     interface MyFunctionalInterface {
         void myMethod();
     }
     
     // You can implement it with a lambda expression:
     MyFunctionalInterface  myFunc = () -> {
       System.out.println("This is an implementation of MyFuctionalInterface.");
     };
     myFunc.myMethod();
     ```

9. Explain Method Reference with code samples?

   ```java
   Consumer<String> printer = System.out::println;
   printer.accept("This is an example of method reference");
   ```

10. Explain "Lambda can use unchanged variable outside of lambda", with code snippet.

    ```java
    final int id = 12345;
    Consumer<String> printer = (msg) -> {
        System.out.println(msg + id);
    };
    printer.accept("This is a message from student: ");
    // This is a message from student: 12345
    ```

11. Can a functional interface extend/inherit another interface?

    - Yes, a functional interface can extend (inherit) another interface. When a functional interface extends another interface, it inherits its abstract methods. So a functional interface can only extend another functional interface and it cannot have additional abstract methods. But it can have its additional default or static methods.

12. What are Intermediate and Terminal operations?

    - **Intermediate operations** return a new stream. They are lazy, meaning they are not executed until a terminal operation is called.
    - **Terminal operations** produce a result or a side-effect and terminate the stream. 

13. Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.

    See Q6-4.

14. How are Collections different from Stream?

    |                  | Collections                                             | Stream                                                       |
    | ---------------- | ------------------------------------------------------- | ------------------------------------------------------------ |
    | **Data Storage** | Store and manage data.                                  | Do not store data; process data from a source                |
    | **Mutability**   | Mutable; elements can be added, removed, or modified.   | Immutable; once created, cannot be changed.                  |
    | **Iteration**    | Can be iterated multiple times                          | Can be iterated (processed) only once                        |
    | **Evaluation**   | Eager evaluation (operations are executed immediately). | Lazy evaluation (operations are executed only when a terminal operation is invoked). |
    | **Operations**   | Primarily for data storage and basic data manipulation. | For functional-style data processing and transformations.    |

    