## 5.Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.

```java
 public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        // null check
        if(map.get(0) != null) {
            System.out.println(map.get(0));
        }
        String res =  Optional.ofNullable(map.get(0)).orElse("is null");
        System.out.println(res);
    }
```

## 6. Discuss Java 8 new features with code snippet.

- Lambda

  ```java
  public static void main(String[] args) {
          List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
  
          names.forEach(name -> System.out.println(name));
      }
  ```

- Functional Interfaces

  ```java
  @FunctionalInterface
  public interface TestInterface {
      void print();
      default void printDefault(){
          System.out.println("1");
      }
  }
  
  ```

- Optional

  ```java
  Optional<String> op = Optional.of("Alice");
  op.ifPresent(name->System.out.println(name));
  ```

- Stream API

  ```java
  List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
  List<String> list = names.stream().filter(s->s.length()>3).collect(Collectors.toList());
  list.forEach(System.out::println);
  ```

- Method Reference

  ```java
  list.forEach(System.out::println);
  ```

- Default Methods

  ```java
   interface TestInterface {
      void print();
      default void printDefault(){
          System.out.println("1");
      }
  }
  ```

## 7. What are the advantages of the Optional class?

Use optional class improved code clarity, avoided NullPointerException errors, streamline Null checks. This approach transforms traditional null handling into a more expressive and safer practice

## 8. **Explain Functional Interface and Lambda with code samples**

- Functional Interface: must have 1 abstract method. Comparator, Consumer, Function, Predicate, Supplier

  ```java
  @FunctionalInterface
   interface TestInterface {
      void print();
      default void printDefault(){
          System.out.println("1");
      }
  }
  
  ```

- Lambda: shorthand way of writing instances of single-method classes

  ```java
   public static void main(String[] args) {
          List<String> names = List.of("Alice", "Bob", "Charlie");
  
          // Using a lambda expression with Consumer functional interface
          Consumer<String> printConsumer = name -> System.out.println(name);
          names.forEach(printConsumer);
      }
  ```

  

## 9. **Explain Method Reference with code samples?**

Method reference provide a way to refer directly to methods of a class or instance without executing them.

- static method

  ```java
  public class StaticMethodReference {
      public static void main(String[] args) {
          List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
  
          // Using method reference to a static method
          numbers.forEach(StaticMethodReference::printNumber);
      }
  
      public static void printNumber(int number) {
          System.out.println(number);
      }
  }
  ```

- Instance Method of a Particular Object

  ```java
  public class InstanceMethodReference {
      public static void main(String[] args) {
          List<String> list = Arrays.asList("apple", "banana", "cherry");
          list.forEach(new InstanceMethodReference()::printItem);
      }
  
      public void printItem(String item) {
          System.out.println(item);
      }
  }
  ```

- Reference to a Constructor

  ```java
  public class ConstructorReference {
      public static void main(String[] args) {
          List<String> list = Arrays.asList("apple", "banana", "cherry");
  
          List<Fruit> fruits = list.stream()
                                   .map(Fruit::new)
                                   .collect(Collectors.toList());
  
          fruits.forEach(System.out::println);
      }
  }
  
  class Fruit {
      private String name;
  
      public Fruit(String name) {
          this.name = name;
      }
  
      @Override
      public String toString() {
          return "Fruit{name='" + name + "'}";
      }
  }
  
  //output
  //Fruit{name='apple'}
  //Fruit{name='banana'}
  //Fruit{name='cherry'}
  
  ```

-  Instance Method of an Arbitrary Object of a Particular Type

  ```java
   list.forEach(System.out::println);
  ```

## 10. **Explain "Lambda can use unchanged variable outside of lambda", with code snippet.**

The variable `prefix` is not modified after its initial assignment, so it is effectively final.

```java
public class LambdaExample {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        String prefix = "a";
        Predicate<String> startsWithPrefix = item -> item.startsWith(prefix);

        System.out.println(result); 
    }
}
```

## 11. **Can a functional interface extend/inherit another interface?**

Yes, a functional interface in Java can extend or inherit from another interface, including another functional interface. However, the extending functional interface must still adhere to the rule of having exactly one abstract method.

## 12. **What are Intermediate and Terminal operations?**

- Intermediate operations are those operations on a stream that return another stream. These are kind of like steps in a pipeline that take a stream as input and transform it into another stream as output.

- Terminal operations are those operations that close a stream. Once a terminal operation has been invoked on a stream, it is consumed and cannot be used anymore. Terminal operations either produce a result (such as a sum, a maximum, a list, etc.)

## 13. **Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.**

```java
filter(Predicate<T>)
map(Function<T, R>)
flatMap(Function<T, Stream<R>>)
distinct()
```

## 14. **How are Collections different from Stream?**

- Collections
  -  Collections are used to store and manage groups of objects.
  -  Elements in a Collection can be added, removed, or updated.
  -  Operations on Collections are performed immediately and directly.
  -  The data in a Collection can be reused and iterated multiple times.
- Stream
  - Streams do not modify the underlying data source; instead, they produce new streams with the result.
  - Operations on Streams are performed lazily; they are not executed until a terminal operation (like collect, forEach, or reduce) is invoked.
  - Streams do not store elements; they convey data from a source (like a Collection, array, or I/O channel) to the processing pipeline.
  -  Streams cannot be reused; once a terminal operation is called, the stream is considered consumed.