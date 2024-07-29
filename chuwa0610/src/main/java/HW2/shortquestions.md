## 1.  Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo
repo as example)
### Encapsulation;
public class Encapsulation {
private  int id;
private  String name;
private  int age;
public int getId(int id) {
return this.id = id;
}
public  String getName(int name) {
return this.name;
}
}

### Polymorphism;
    public class Animal {
        public void makeSound() {
        System.out.println("make sound");
    }

    }
    public class  dog extends Animal {
        @Override
        public void makeSound() {
            System.out.println("wangwang");
        }
    }
    public class  cat extends Animal {
        @Override
        public void makeSound() {
            System.out.println("miaomiao");
        }
    }
### Inheritance;
public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class Student extends Person {
    private String studentId;

    // 构造函数
    public Student(String name, int age, String studentId) {
        super(name, age); // 调用父类的构造函数
        this.studentId = studentId;
    }

    // 公有的 getter 方法
    public String getStudentId() {
        return studentId;
    }

    // 重写 displayInfo 方法
    @Override
    public void displayInfo() {
        super.displayInfo(); // 调用父类的 displayInfo 方法
        System.out.println("Student ID: " + studentId);
    }
}

## 2. What is wrapper class in Java and Why we need wrapper class?
Wrapper class can represent primitive data types as objects, 
which is used to offers methods and functions that are not available for primitive data 
types, such as extending the function to work with collection framework, 
Math operations eg add(), subtract() etc, comparison methods eg equals(), compareTo().
## 3. What is the difference between HashMap and HashTable?
HashMap is not thread safe, HashTable is thread safe. 
All methods in HashTables are synchronized, which means only one thread can access 
the map at a time.
HashMap allows null key and null values, HashTable don’t allow null key or values. HashMap is generated faster than HashTables. 
## 4. What is String pool in Java and why we need String pool?
If we don’t use new keyword to create string, String str1 = "Hello"
The JVM will first checks the String pool to see if the string already exists, 
if a match is found in the pool, the reference to the existing string is returned, 
which will save memory. If there is no match, JVM will create a new object. 
If we use new keywords, the constructor always create new objects.
## 5. What is Java garbage collection?
The keywords define the visibility and accessibility of class methods, 
fields and constructors. The “Public” means it is accessible from anywhere in the program. “Private” means it only accessible within the class where it’s declared. “Protected” means it accessible from within the class where it’s declared, as well as the sub classes
## 6. What are access modifiers and their scopes in Java?
   The keywords define the visibility and accessibility of class methods, fields and constructors. 
   The “Public” means it is accessible from anywhere in the program. 
   “Private” means it only accessible within the class where it’s declared. 
   “Protected” means it accessible from within the class where it’s declared, 
   as well as the sub classes
## 7. What is final key word? (Filed, Method, Class)
    - Final has different meaning in different context.
    - Final for a variable, this variable can not be change
    - Final for a method, this method can not be override
    - Final for a class, this class can not be inheritanced
## 8. What is static keyword? (Field, Method, Class). When do we usually use it?
It indicates that the modified member belongs to the class itself, not to any specific instance of the class.
- For fields, when you need a constant or variable that is shared between all instances. 
- For methods, when you need a utility method or a method that is not instance-specific. 
- For classes, in rare cases, when you need a utility class to hold static methods and variables
## 9. What is the differences between overriding and overloading?
- Overriding: means that the same method can be override in the subclass
- Overloading: means that we can create method in class with same method name, 
but we can differenticate them by the parameters’ sequence, number, type
## 10. What is the differences between super and this?
This and super are keywords in Java, which are used to refer to the current object, 
and super is used to refer to the parent class object.
## 11. What is the Java load sequence?
static variable initialization and Class loading
Static variables are declared using static keyword, and class is loaded into memory by JVM.
static block initialization
Static block executes.
object creation and constructor execution
When we create an object using new, the constructor of class is invoked, 
after constructor execution, JVM will initializing an instance of class which is ready to be used.
## 12. What is Polymorphism ? And how Java implements it ?
Polymorphism enables us to create a series of object which has same structure but different implementations. Every java class has a method table which contains all the methods declared in that class and its superclasses, each entry in the method table points to a method object.
When a method is called, The JVM will first searches the method table to find the method entry. If found, it directly uses the method object pointed to by that entry. If not found, it searches the method tables of parent classes up the inheritance chain until it finds a matching entry.
## 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
Java provides access modifiers(public, private, protected) to control access to class members. JVM uses access modifiers to verify bytecode and potentially throw exceptions if code attempts to directly access private fields.
## 14. What is Interface and what is abstract class? What are the differences between them?
- Interface is a collection of abstract methods, which only have the method signature, on body.
- abstract class can have the methods or abstract methods.
- interface support multiple inheritance while abstract class support single inheritance.
- Access modifier, interface is public while abstract can be various.
- Default methods: interface can have default and static methods while abstract class can not.
- default methods can have implementation.
## 15. design a parking lot (put the code to codingQuestions/coding1 folder, )
## 16. If you have no ability to design it, please find the solution in internet, then understand it, 
   and re-type it.(Do NOT just copy and paste)

## 17. What are Queue interface implementations and what are the differences and when to use what?
There are several implementations in Java,
LinkedList, ArrayDeque, PriorityQueue, ConcurrentLinkedQueue..
    - For frequent insertions/removals from the beginning or end and large datasets, use LinkedList.
    - For flexibility with insertions/removals from both ends and random access, use ArrayDeque.
    - For prioritizing elements in the queue, use PriorityQueue.
    - For concurrent access in multithreaded environments, use ConcurrentLinkedQueue.