## 1. What is generic in Java? and type the following generic tutorial code by yourself.

## 2. Read the follwoing code repo and type it one by one by yourself.

## 3. Practice following stream API exercises at least 3 times

## 4. Practice Optional methods at least 2 times

## 5. Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.

* 1. Check for Null Values Explicitly
     
     ```
     String str = getString();
     if (str != null) {
     System.out.println(str.toUpperCase());
     } else {
     System.out.println("String is null");
     }
     ```
* 2. Use Ternary Operator for Null Checks
     
     ```
     String str = getString();
     String result = (str != null) ? str.toUpperCase() : "Default Value";
     System.out.println(result);
     ```
* 3. Use Optional Class
     
     ```
     Optional<String> optionalString = Optional.ofNullable(getString());
     optionalString.ifPresent(System.out::println);
     String result = optionalString.orElse("Default Value");
     System.out.println(result);
     ```

## 6. Discuss Java 8 new features with code snippet.

* 1. Lambda Expression
     
     ```
     List<String> list = Arrays.asList("a", "b", "c", "d");
     list.forEach(item -> System.out.println(item));
     ```
* 2. Stream API
     
     ```
     List<String> list = Arrays.asList("a", "b", "c", "d");
     list.stream().map(String::toUpperCase).forEach(System.out::println);
     ```
* 3. Method References (Same code above)
* 4. Optional Class
     
     ```
     Optional<String> optional = Optional.ofNullable(getValue());
     optional.ifPresent(System.out::println);
     ```
* 5. Default Methods & Static Methods for interface
     
     ```
     interface MyInterface {
     default void defaultMethod() {
        System.out.println("Default method implementation");
     }
     }
     ```

## 7. What are the advantages of the Optional class?

* 1. Avoids NullPointerExceptions
* 2. Explicit Null Handling: Force developer to handle
* 3. Improved API Design: it can indicate whether a value might be absent.

## 8. Explain Functional Interface and Lambda with code samples.

```
@FunctionalInterface
interface GreetingService {
    void sayMessage(String message);
    }
}
public class LambdaExample {
    public static void main(String[] args) {
        // Using a lambda expression to define the sayMessage method
        GreetingService greetService = message -> System.out.println("Hello " + message);
    }
}
```

## 9. Explain Method Reference with code samples?

## 10. Explain "Lambda can use unchanged variable outside of lambda", with code snippet.

```
public void testFinal() {
    final String localVariable = "Local";
    Foo foo = parameter -> {
        return parameter + " " + localVariable;
    };
    System.out.println(foo.aMethod("hello"));
}
```

If lovalVariable is not final and changed, it will have errors. 

## 11. Can a functional interface extend/inherit another interface?

Yes, but it has to follow one abstract method rules.

## 12. What are Intermediate and Terminal operations?

* Intermediate: Intermediate operations are those operations on a stream that return another stream. 
* Example: map(), filter(), distince(), sort()
* Terminal: Terminal operations are those operations that close a stream.
* Example: forEach(), collect()

## 13. Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.

```
List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "date", "banana", "elderberry");

// map: Convert all words to uppercases
List<String> upperCaseWords = words.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());

// filter: Filter words with length greater than 5
List<String> longWords = words.stream()
    .filter(word -> word.length() > 5)
    .collect(Collectors.toList());

// sorted: Sort words alphabetically
List<String> sortedWords = words.stream()
    .sorted()
    .collect(Collectors.toList());

// distinct: Remove duplicate words
List<String> distinctWords = words.stream()
    .distinct()
    .collect(Collectors.toList());
```

## 14. How are Collections different from Stream

* Collections are in-memory data structures that store and manage groups of objects, such as lists, sets, and maps, allowing for dynamic modification, random access, and iteration.
* They provide a way to store and organize data that can be accessed and manipulated repeatedly. 
* Streams, on the other hand, are a sequence of elements that can be processed in a functional style, enabling operations like map, filter, and reduce. 
* Streams are designed for one-time use and support lazy evaluation, 
