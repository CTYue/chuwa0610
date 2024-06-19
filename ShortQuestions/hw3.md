## 2. What is the checked exception and unchecked exception in Java, could you give one example?
- **Checked exception**: Exceptions that are checked at compile time and should be handled by `catch` or `throws`.
Ex: IOException, SQLException, NetworkException.
- **Unchecked exception**: Runtime exceptions. Ex: NullPointerException, IndexOutOfBoundsException.

## 3. Can there be multiple finally blocks?
No, there can only be one finally block

## 4. When both catch and finally return values,what will be the final result?
The return values in the finally block will be the final return result.

## 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?
Runtime/unchecked exceptions are those exceptions that are not checked at compile time. Exceptions under Error and RuntimeException classes are unchecked exceptions. Compile/checked exceptions are those that are checked at compile time. They should be handled properly by the `catch` or `throws`.

## 6. What is the difference between throw and throws?
`throw` keyword is used to throw an specific exception. `throws` keyword is used at the end of the signature of a method to indicate the exceptions that the method might throw.

## 7. Run the below three pieces codes,Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?
Because Exception is more general and have a larger scope than Null/Runtime exception. If the Exception is before Null/Runtime exception, the code in Null/Runtime exception will never execute.

## 7. What is optional? why do you use it? write an optional example.
By using optional class, we can make sure that the program can execute without crashing.

```
   Optional<String> option1 = Optional.of("Hello World");
   Optional<String> option2 = Optional.empty();
   System.out.println(option1.orElse("Empty String")) // Prints: Hello World
   System.out.println(option2.orElse("Empty String")) // Prints: Empty String
```

## 8. Why finally always be executed?
`finally` block is designed to do cleanup work after the try/catch block. So it is designed to be executed whether the code snippet above is executed successfully or exceptions occurs.

## 10. What are the types of design patterns in Java?
- **Creational Patterns**: Singleton, Factory Method, Abstract Factory, Builder, and etc...
- **Structural Patterns**: Adapter, Decorator, Composite, and etc...
- **Behavioral Patterns**: Observer, Strategy, Command, State, and etc...

## 11. What are the SOLID Principles?
SOLID Principles includes:
1. **Single Responsibility** - A class should only have one responsibility, Furthermore, it should only have one reason to change.
2. **Open/Closed** - Classes should be open for extension but closed for modification.
3. **Liskov Substitution** - If class A is a subtype of class B, we should be able to replace B with A without disrupting the behavior of our program.
4. **Interface Segregation** - Larger interfaces should be split into smaller ones.
5. **Dependency Inversion** - Decoupling of software modules.

## 12. How can you achieve thread-safe singleton patterns in Java?
By using singleton pattern, we ensure that at any one time, there is only one instance of the singleton class. Any opertionals are performed by that single instance. Therefore, we can achieve thread-safe.

## 13. What do you understand by the Open-Closed Principle (OCP)?
We should stop modifying the existing code to introduce new features, which could cause potential new bugs. Instead, we should extend the code and introduce the new features in the subclasses.

## 14. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
Option 1 is correct:
1. It means that if the object of type A can do something, the object of type B could also be able to perform the same thing.

