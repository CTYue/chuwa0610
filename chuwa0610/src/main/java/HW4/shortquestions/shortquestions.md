##1. What is generic in Java?
- Generics means **parametrized types**. It allows users to create classes that work with different data types. An entity such as class, interface, or method 
that operates on a parameterized type is a generic entity.
##2. Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.
1. Use ternary operator
```
   String str = null;
   String result = (str == null) ? "default" : str;
```
2. if - else 
```
  String s = "shanshan";
  if (s != null) {
  return s;
  }
```
3. Use optional class
```
   Optional<String> opt = Optional.empty();
   String str = opt.orElse("default");
```
##3. Discuss Java 8 new features with code snippet.
1. Default method and static method in interface
```
   public interface DIML {
      static final String BLOG = "is Chuwa a";
      // abstract method
      int add(int a, int b);
      // default method
      default int substract(int a, int b){
         return a - b;
      }
      // static method
      static String blogName(){
         return BLOG;
      }
   }
```
2. Lambda & Functional Interface
```
   int[] arr = new int[]{1, 2, 3};
   Arrays.sort(arr, (a, b) -> b - a);
```
3. Method reference
```
   people.sort(Person::compareByName);
   Comparator<Person> byAgeComparator = Comparator.comparingInt(Person::getAge);
   people.sort(byAgeComparator);
   Function<Person, String> getNameFunction = Person::getName;
   List<String> names = Arrays.asList("Alice", "Bob", "charlie");
   names.sort(String::compareToIgnoreCase);
```
4. Optional
```
   Optional<String> emptyOptional = Optional.empty();
```
5. Stream API
```
   Stream<Double> stream = Stream.generate(Math::random).limit(5);
```
##4. What are the advantages of the Optional class?
Optional class provides a more secure and elegant way to deal with null value without throwing NullPointerException.
##5. Explain Functional Interface and Lambda with code samples.
Functional interface only has one single abstract method. However, it can have many default methods. Lambda is the implementation of the abstract method.
```
   public interface Foo {
      String aMethod(String str);
      default String defaultBar(){
         String s = "default bar method";
         System.out.println(s);
         return s;
      }
      default String defaultCommon(){
         String s = "default common from bar";
         System.out.println(s);
         return s;
      }
   }
```
Lambda can be used to replace anonymous inner class. And it works well with functional interface
```
   int[] arr = new int[]{1, 2, 3};
   Arrays.sort(arr, (a, b) -> b - a);
```
##6. Explain Method Reference with code samples?
Method references are a special type of lambda expression. They are used to create simple lambda expressions by referencing existing methods.
```
   // Static Method reference
   people.sort(Person::compareByName);
   // Instance method reference of a particular object
   Comparator<Person> byAgeComparator = Comparator.comparingInt(Person::getAge);
   people.sort(byAgeComparator);
   // Function
   Function<Person, String> getNameFunction = Person::getName;
   List<String> names = Arrays.asList("Alice", "Bob", "charlie");
   names.sort(String::compareToIgnoreCase);
   // Constructor Reference
   BiFunction<String, Integer, Person> personCreator = Person::new;
   Person newPerson = personCreator.apply("David", 40);
   System.out.println(people);
```
##7. Explain "Lambda can use unchanged variable outside of lambda", with code snippet.
Lambda can use variables outside of lambda as long as those variables are final or effectively final (non final variable that is never changed after initialization)
```
   // Final variable
   final String localVariable = "Local";
   Foo foo = param -> {
      return param + " " + localVariable;
   };
   // Effectively final
   String localVariable = "Local";
   Foo foo = param -> {
      return param + " " + localVariable;
   };
```
##8. Can a functional interface extend/inherit another interface?
A functional interface cannot extend/inherit another interface which has 
an abstract method. Because it will change the fact that a functional interface 
allows only one abstract method. However, functional interface can inherit another interface 
which contains only static and default methods.
##9. What are Intermediate and Terminal operations?
Intermediate operations returns a stream as a result, terminal operations return non-stream values or return nothing.
- Intermediate Operations: map(), filter(), distinct(), sorted(), limit(), skip().
- Terminal Operations: forEach(), toArray(), reduce(), collect(), min(), max(), count(), anyMatch(), allMatch(), noneMatch(), findFirst(), findAny().
##10. Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.
```
   Stream<Double> stream = Stream.generate(Math::random).limit(5);
   //Keep the first 5 elements
```
##11. How are Collections different from Stream?
Collections are responsible for storing data. Stream refers to computation, responsible for processing data.