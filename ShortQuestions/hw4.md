1. What is generic in Java?  and type the following generic tutorial code by yourself.    
   Java Generics add a way to specify concrete types to general purpose classes and methods.   
    [links](../Coding/Generic)

2. Read the follwoing code repo and type it one by one by yourself.   
    [links](../Coding/features)
3. 
3.  Practice following stream API exercises at least 3 times   
    [links](../Coding/streamAPI)

4.  Practice Optional methods at least 2 times
    [links](../Coding/Optional)    

5.  Discuss best practices on nullptr exception prevention, provide code snippet for each practice that you
    mentioned.
  
    ```
    1. Excpetion
    try {}
    catch (NullPointerException e){
    ...
    } 
    2. Optional
    Optional.ofNullable(obj)
    3. check
    if (obj != null) {
    }
    4. annotation
    someFunction(@NonNull Product produc)
    ```
    
6. Discuss Java 8 new features with code snippet.
```
      1. lambda
      Collection.sort(list, (a,b) -> Integer.compare(a,b))
      2. Stream API
      list.stream().filter().map().toList()
      3. default method in interface
      iterface A {
           int func(int a);
           default int func2(int a, int b) {
            return a + b;
      }
      4. method reference // using class::function
      list.forEach(System.out::println);
      5. Functional Interface
      @FunctionalInterface
        interface Calculator {
        int calculate(int a, int b);
        }
      }
      public class Main {
        public static void main(String[] args) {
        // Using lambda expression to implement the functional interface
            Calculator add = (a, b) -> a + b;
            System.out.println(add.calculate(3, 5)); // Output: 8
        }
        }
```
7. What are the advantages of the Optional class?
   1. avoid of NullPointerException
   2. reduction of Boilerplate Code, has map, flatMap, orElse etc
   3. Support Stream API and Functional programming
    

8. Explain Functional Interface and Lambda with code samples.   
    Functional Iterface has exactly on abstract method, can have many default methods and static methods
```
    @FunctionalInterface
    interface Calculator(){
        int calcualte(int a, int b);
    }
    public static void main(String[] args)
    {
        Calculator add = (a,b) -> a + b;
        Calculator subtract = (a,b) -> a - b;
        System.out.println(add.calculate(3, 5));
        System.out.println(add.subtract(3, 5));
    }
```
9.  Explain Method Reference with code samples?   
    Method references provide a way to refer to methods or constructors without invoking them.
```
    public class Project {
        private String name;
        private int duration; // in days
    
        public Project(String name, int duration) {
            this.name = name;
            this.duration = duration;
        }
    
        public String getName() {
            return name;
        }
    
        public int getDuration() {
            return duration;
        }
    
        public void printProjectDetails() {
            System.out.println("Project: " + name + ", Duration: " + duration + " days");
        }
    
        public static void staticPrint(Project project) {
            System.out.println("Static print: " + project.getName());
        }
    }

    List<Project> projects = Arrays.asList(
                new Project("Project A", 30),
                new Project("Project B", 45),
                new Project("Project C", 60)
        );

    //Static Method: ClassName::staticMethodName
    projects.forEach(Project::staticPrint);
    
    //Instance Method of an Object: objectReference::instanceMethodName
    projects.forEach(Project::printProjectDetails);
    

    //Constructor: ClassName::new
    List<Project> projectsRef = projectNames.stream()
                                                .map(Project::new)
                                                .collect(Collectors.toList());

    // Print projects
    projects.forEach(Project::printProjectDetails);
    
```
10. Explain "Lambda can use unchanged variable outside of lambda", with code snippet.   
    a lambda  can use variables that are declared outside of it as long as these variables are effectively final.
```
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

Calculator add = (a, b) -> a + b;
int num1 = 1, num2 = 2;
int resultSubtract = subtract.calculate(num1, num2);

num1 = 3; // error, localVaraible2 should be final or effectively final 

```
11. Can a functional interface extend/inherit another interface?   
Yes, but should follow functional interface, single abstract method rule.


12. What are Intermediate and Terminal operations?    
- Intermediate operations are operations that are executed on a stream and return a stream
- Terminal operations in stream are operations that initaite stream processing or produce a result or side-effect.
and Once a terminal operation is invoked on a stream, no further intermediate operations can be applied to it.

13. Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.
- map, filter, sorted, distinct, flatMap
```
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Emma");
List<String> res = names.stream()
    .filter(name -> name.length() > 3)
    .sorted()
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```
14. How are Collections different from Stream?   
    collections providing data storage and initial access, 
    and streams enabling processing pipelines for data transformation and computation.

    | Collections                                 | Streams                              |
    |---------------------------------------------|--------------------------------------|
    | Data sturctures holds all the data elements | no Data is stored                    |
    | External Iteration                          | Internal Iteration                   |
    | can be process any number of times          | Traverse only once                   |
    | easy to access                              | no direct way acess specific element |
    | data store                                  | an API to process the data           |
    
15. Leetcode 1748
```
int sum  = Arrays.stream(nums).boxed().collect(
          Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1)
                .mapToInt(Map.Entry::getKey).sum();
```
