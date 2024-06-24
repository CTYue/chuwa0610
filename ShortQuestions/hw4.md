# Hw4

## 1.  [What is generic in Java?  and type the following generic tutorial code by yourself.](https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t01_basic/generic)
- Generic means parameterized types. Using generics, the idea is to allow any data type to be it Integer, String, or any user-defined Datatype and it is possible to create classes that work with different data types.
- See Coding\hw4\hw4\src\main\java\com\chuwa\learn\Generic
## 2.  [Read the follwoing code repo and type it one by one by yourself.](https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/features)
- See Coding\hw4\hw4\src\main\java\com\chuwa\learn\Generic
- And Coding\hw4\hw4\src\test\java\com\chuwa\learn\
## 3.  [Practice following stream API exercises at least 3 times](https://github.com/gavinklfong/stream-api-exercises/blob/main/src/test/java/space/gavinklfong/demo/streamapi/StreamApiTest.java)
- See Coding\hw4\hw4\src\test\java\com\chuwa\learn\
## 4.  [Practice Optional methods at least 2 times](https://github.com/CTYue/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/exercise/ShoppingCartUtil.java)
- See Coding\hw4\hw4\src\main\java\com\chuwa\learn\Exercise
## 5.  Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.
- Do null check when necessary
```
   public void processUser(User user) {
        if (user != null) {
            System.out.println(user.getName());
        } else {
            System.out.println("User is null");
        }
    }
```
- Initialize variables if possible
```
    public class User {
        private String name;
    
        public User(String name) {
            this.name = name != null ? name : "Unknown"; 
        }
    }
```
- Use Optional class to deal with null
```
       public Optional<User> findUserById(int id) {
        User user = findInDatabase(id);
        return Optional.ofNullable(user); 
    } 
```
## 6.  Discuss Java 8 new features with code snippet.
### - Default method and static method can appear in interfaces
- Adds new complexity and functionality to Interfaces
```
public interface MyInterface {
    static final String name = "Alice";
    int foo(int a, int b);
    default int goo(int a, int b) {
        return a * b;
    }
    static String getName() {
        return name;
    }
}
```
### - Functional Interface
- An Interface with only one abstract method and many default methods
```
public interface MyInterface {
    int foo(int a, int b);
    default int goo(int a, int b) {
        return a * b;
    }
    default int goo(int a, int b) {
        return a / b;
    }
    ...
}
```
### - Lambda Functions
- A way to replace anonymous inner methods
```
something = public void fooA(int a){
    foo(a);
}

becomes--------------------------
something = (a) ->foo(a);
```
### - Method Reference
- A way to shorten method when reference a method
```
List<String> stringsArray = Arrays.asList("a","b","c","d");
List<String> upperCae = stringsArray.stream().map((s)->s.toUpperCase()).collect(Collectors.toList());

becomes=============================>

List<String> stringsArray = Arrays.asList("a","b","c","d");
List<String> upperCae = stringsArray.stream().map(String::toUpperCase()).collect(Collectors.toList());

```
### - Optional
- A way to prevent NullPointerException
```
        if (user != null) {
            if (address != null) {
                foo(user);
            }
        }
        
can be achieved as ==============================>
        Optional.ofNullable(foo(user));
```
### - Stream API
- A way to shorten the expression for collection processing
```
    public int foo(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        int result = 0;
        for (int i = 0; i < list.size(); i++){
            result +=list.get(i);
        }
        return result;
    }
Can be shorten to====================================>
    public int foo(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        return list.stream().mapToInt(e -> e).sum();
    }
```

## 7.  What are the advantages of the Optional class?
It reminds the developer to deal with null cases in the functions. It also somewhat handles null values automatically.\
In addition, it as provided expressive and useful functions like "filter" and "ifPresent".
## 8.  Explain Functional Interface and Lambda with code samples.
Lambda expression is a way to replace anonymous inner methods\
For a functions like:
```
something = public void fooA(int a){
    foo(a);
}

```
We can shorten it to be simpler by using lambda like this:
```
something = (a) ->foo(a);
```

Functional Interface is a subclass of Interface where it contains only one abstract method and many default methods.
Below is an example:
```
public interface MyInterface {
    int foo(int a, int b);    //<===========abstract method
    default int goo(int a, int b) {  //=====default methods
        return a * b;
    }
    default int goo(int a, int b) {//=====default methods
        return a / b;
    }
    ...                             //=====default methods
}
```
## 9.  Explain Method Reference with code samples?
For some functions that takes an another functions as operator(like compareToIgnoreCase), instead of using an anonymous inner method or lambda expression, we can directly call the class+method to use that function.\
We can replace the below lambda expression with method reference
```
List<String> stringsArray = Arrays.asList("a","b","c","d");
List<String> upperCae = stringsArray.stream().map((s)->s.toUpperCase()).collect(Collectors.toList());

```
change to
```
List<String> stringsArray = Arrays.asList("a","b","c","d");
List<String> upperCae = stringsArray.stream().map(String::toUpperCase()).collect(Collectors.toList());

```
## 10.  Explain "Lambda can use unchanged variable outside of lambda", with code snippet.
Usually, variables that is out of the lambda expression and used in lambda expression should be final:
```
        ...
        final String str = "Alice";
        Foo foo = ()->{
            return str+" and Bob";
        };
        ...
```
However, it is declared and never changed, it also counts
```
        ...
        String str = "Alice";
        Foo foo = ()->{
            return str+" and Bob";
        };
        ...
```
It is not acceptable to modify the variable before/after the lambda expression
```
        ...
        final String str = "Alice";
        str = "Bob"            //<================= not acceptable
        Foo foo = ()->{
            return str+" and Bob";
        };
        
         str = "Bob"            //<================= not acceptable
        ...
```
However, using setters to set an object's value is acceptable.

## 11.  Can a functional interface extend/inherit another interface?
A functional interface can extend/inherit another interface if the other interface only contains static/default methods, because if the other interface also contains abstract method, then the functional interface would have more than one abstract methods, and that violates the concept of functional interface.
## 12.  What are Intermediate and Terminal operations?
In a stream operation, we can put as many as Intermediates operations as we want. \
However we can only put one Terminal operation at the end as that will close the stream.\
If we want to use Intermediates operations again we have to convert it into another stream
## 13.  Demonstrate the most commonly used Intermediate operations in Stream API, with code snippet.
- Filter
```
    // Filter out even numbers
    public void foo(){
        List<Integer> list = Arrays.asList(1,2,3,2,5,4,7,8,3,10);
        List<Integer> list2 = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(list2);
    }
```
- Limit
```
    // Cut the list to first five element
    public void foo(){
        List<Integer> list = Arrays.asList(1,2,3,2,5,4,7,8,3,10);
        List<Integer> list2 = list.stream().limit(5).collect(Collectors.toList());
        System.out.println(list2);
    }
```
- Skip
```
    // Cut out the first five element
    public void foo(){
        List<Integer> list = Arrays.asList(1,2,3,2,5,4,7,8,3,10);
        List<Integer> list2 = list.stream().skip(5).collect(Collectors.toList());
        System.out.println(list2);
    }
```
- Distinct
```
    // remove duplicates
    public void foo(){
        List<Integer> list = Arrays.asList(1,2,3,2,5,4,7,8,3,10);
        List<Integer> list2 = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list2);
    }
```
- Map
```
    // Double all elements
    public void foo(){
        List<Integer> list = Arrays.asList(1,2,3,2,5,4,7,8,3,10);
        List<Integer> list2 = list.stream().map((n)->n*2).collect(Collectors.toList());
        System.out.println(list2);
    }
```
- Sort
```
    // Sort all elements
    public void foo(){
        List<Integer> list = Arrays.asList(1,2,3,2,5,4,7,8,3,10);
        List<Integer> list2 = list.stream().sorted().collect(Collectors.toList());
        System.out.println(list2);
    }
```
## 14.  How are Collections different from Stream?
### Collections
- Data Structures
- Stores data
- Can modify stored data
- Focused on data storage
### Stream
- Not a data structure
- Does not store data
- Does not modify the original collection, returns a new copy of the data instead
- Focused on operations on data
- 
### 15.Please solve https://leetcode.com/problems/sum-of-unique-elements/description/ with Stream API.
```
class Solution {
    public int sumOfUnique(int[] nums) {
        IntStream stream = Arrays.stream(nums);
        Map<Integer, Long> map = stream.boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        int result = map.entrySet().stream().filter(entry -> entry.getValue() == 1).mapToInt(e -> e.getKey()).sum();

        return result;

    }
}
```