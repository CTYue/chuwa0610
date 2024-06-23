
## 1. Practice collection
https://github.com/CTYue/chuwa-eij-tutorial/

## 2. What is the checked exception and unchecked exception in Java, could you give one example?
- **Checked exception**: Happens in compile time. It must be handled with `try/catch` or `throws`.
  eg: IOException, SQLException.
```java
public class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(new File("test.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

- **Unchecked exception**: Happens in runtime. eg: ArithmeticException, NullPointerException, 
  IndexOutOfBoundsException.
```java
public class UncheckedExceptionExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        System.out.println(numbers[3]); 
        // This will throw ArrayIndexOutOfBoundsException
    }
}
```

## 3. Can there be multiple finally blocks?
No.

## 4. When both catch and finally return values, what will be the final result?
`finally` block always implements, so the return value in final block will be returned.

## 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?
- Runtime/unchecked exceptions are the exceptions not checked at compile time. Handling them is not 
required.
- Compile/checked exceptions are the exceptions checked at compile time. We must handle them.


## 6. What is the difference between throw and throws?
- `throw` : Used to explicitly throw an exception.
- `throws` : Used in the method signature to declare exceptions that a method can throw

## 7. Run the below three pieces codes,Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?
When we use `try/catch` to catch exceptions, we must catch exception following the principle form small scale to big 
scale. Exception is bigger scale exception, Null/Runtime exception is the smaller scale.

## 7. What is optional? why do you use it? write an optional example.
#### What?
Optional is a container object which represents a value that may or may not be present.

#### Why use it?
Using Optional in Java provides a safer and more expressive way to handle values that may or may not be present.

```java
public class SimpleOptionalExample {
    public static void main(String[] args) {
        Optional<String> optionalStr1 = Optional.of("Hello, World");
        Optional<String> optionalStr2 = Optional.ofNullable(null);
        // Prints: Hello, World
        System.out.println(option1.orElse("default")); 
        // Prints: default
        System.out.println(option2.orElse("default")); 
    }
}

   
```

## 8. Why finally always be executed?
`finally` block is designed to ensure that important cleanup code is always executed, even if an exception occurs.

## 10. What are the types of design patterns in Java?
- **Creational Patterns**: Singleton, Factory Method, Abstract Factory, Builder, Prototype...
- **Structural Patterns**: Adapter, Bridge, Composite, Decorator, Facade...
- **Behavioral Patterns**: Iterator, Observer, Command, State, Strategy...

## 11. What are the SOLID Principles?
SOLID Principles includes:
- **Single Responsibility Principle (SRP)** -  A class should have only one reason to change, meaning it should have only one job or responsibility.
- **Open/Closed Principle (OCP)** - Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
- **Liskov Substitution Principle (LSP)** - Subtypes/subclasses must be substitutable/replaceable for their base types 
  without altering the correctness of the program.
- **Interface Segregation Principle (ISP)** - Interfaces should be small and specific to the clients using them.
- **Dependency Inversion Principle (DIP)** - High level modules should not depend on low level modules; both should 
  depend on abstractions. Make modules decouple.

## 12. How can you achieve thread-safe singleton patterns in Java?
- **Easy Initialization**: Create the instance at the time of class loading, ensuring only one instance, thread-safe.
```java
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }
}

```
- **Lazy Initialization with `synchronized` keyword**: Initializes the singleton instance only when it is accessed for 
  the first time. It uses double-checked locking to ensure thread safety.
```java
public class Singleton {
private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

## 13. What do you understand by the Open-Closed Principle (OCP)?

Open-Closed Principle (OCP) requires us to create classes more modular, flexible, and easier to maintain, so that we can add new features by creating new classes rather than modifying existing ones.

## 14. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
Choose option 1.
Example:
```java
class Main {
    public static void main(String[] args) {
        Animal animal1 = new Bird();
        Animal animal2 = new Dog();

        animal1.makeSound(); // 输出：Bird sings
        animal2.makeSound(); // 输出：Dog barks
    }
}

class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Bird extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bird sings");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}
```

## 15. Watch the design pattern video, and type the code, submit it to MavenProject folder.