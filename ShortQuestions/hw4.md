## 5.  Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you mentioned.

``` java

// check before use
if (obj != null) {}


// try catch
try {

} catch (NullPointerException e){

} 

// Optional
Optional.ofNullable(obj)

```

## 6. Discuss Java 8 new features with code snippet.
``` java
// lambda
Arrays.sort(arr, (a,b) -> (a - b)); 

//Functional Interface
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

// method reference
list.forEach(System.out::println);

// stream API
list.stream().filter().map().toList()


//default method in interface
interface i {
    int func(int a);
    default int func2(int a, int b) {
        return a + b;
    }
}
```
## 7. What are the advantages of the Optional class?
* Avoid of NullPointerException, cleaner and more concise code.


## 8. Explain Functional Interface and Lambda with code samples.   

``` java
@FunctionalInterface
interface Calculator(){
    int calcualte(int a, int b);
}
public static void main(String[] args)
{
    Calculator add = (a,b) -> a + b;
    System.out.println(add.calculate(3, 5));
}
```

## 9.  Explain Method Reference with code samples?   
* In Java 8 we can use the method as if they were objects or primitive values, and we can treat them as a variable.
``` java
    // This square function is a variable getSquare. 
    Function<Integer, Integer> getSquare = i -> i * i;
    // Pass function as a argument to other function easily 
    SomeFunction(a, b, getSquare); 
```

## 10. Explain "Lambda can use unchanged variable outside of lambda", with code snippet.   
* if we remove the final modifier from a parameter or a local variable in a valid program without introducing compile-time errors, then it becomes effectively final. Moreover, it's also safe to add the final modifier to an effectively final variable or parameter.
``` java
public static void main(String[] args) {
    int pi = 3;
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    numbers.add(5);
    numbers.add(9);
    numbers.add(8);
    numbers.add(1);
    numbers.forEach( (n) -> { System.out.println(n + pi); } );
}
```

## 11. Can a functional interface extend/inherit another interface?   
* Yes


## 12. What are Intermediate and Terminal operations?    
* intermediate operations return a stream as a result and terminal operations return non-stream values like primitive or object or collection or may not return anything.


## 13. Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.
- map, filter, sorted, distinct, flatMap
``` java
List<String> names = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
List<String> res = names.stream().filter(name -> name.length() > 3).sorted().map(String::toUpperCase).collect(Collectors.toList());
```

## 14. How are Collections different from Stream?   

| Collections                                 | Streams                              |
|---------------------------------------------|--------------------------------------|
| It stores/holds all the data | doesn't store data                    |
|Don't use functional interfaces.|use functional interfaces like lambda which makes it a good fit for programming language. |
| Non-consumable | consumable |
| Supports parallel processing | support both sequential and parallel processing. |
| modifiable  | not modifiable   |

## 15. Leetcode 1748
``` java
class Solution {
    public int sumOfUnique(int[] nums) {
        int sum  = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                    .entrySet().stream().filter(entry -> entry.getValue() == 1).mapToInt(Map.Entry::getKey).sum();
        return sum;
    }
}
```
