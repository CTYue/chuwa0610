# Homework 4 Java 8

## 1. What is generic in Java?
Generics in Java are a feature that allows you to write code with a flexible type interface, enabling classes, interfaces, and methods to operate on objects of various types while providing compile-time type safety. Introduced in Java 5, generics enhance the language's expressiveness and robustness by allowing types (classes and interfaces) to be parameters when defining classes, interfaces, and methods.

```
public class GenericClass<T> {
    // T -> Integer, User, Product
    T obj;

    public GenericClass(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return this.obj;
    }
}

public class GenericClassTest {

    public static void main(String[] args) {
        // Test for Integer type
        GenericClass<Integer> obj1 = new GenericClass<>(5);
        System.out.println(obj1.getObj());

        // Test for double type
        GenericClass<Double> obj2 = new GenericClass<>(15.777755);
        System.out.println(obj2.getObj());

        // Test for String type
        GenericClass<String> obj3 = new GenericClass<>("Yayy! That's my first Generic Class.");
        System.out.println(obj3.getObj());
    }
}

public class GenericMethod {
    public static void main(String[] args) {
        System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5,
                MaximumGenericTest.maximum(3, 4, 5));
        System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7,
                MaximumGenericTest.maximum(6.6, 8.8, 7.7));
        System.out.printf("Max of %s, %s and %s is %s\n", "pear", "apple", "orange",
                MaximumGenericTest.maximum("pear", "apple", "orange"));
    }
}


class MaximumGenericTest {
    /**
     * determines the largest of three Comparable objects
     */
    public static < T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;

        if (y.compareTo(max) > 0) {
            max = y;
        }

        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }
}

public class GenericMultiArguments {

    public static <T1, T2, T3> void temp(T1 x, T2 y, T3 z) {
        System.out.println("This is x = " + x);
        System.out.println("This is y = " + y);
        System.out.println("This is z = " + z);

    }
    public static void main(String[] args) {
        temp(1, "2", 3L);
    }
}

public class NonGeneric {
    public static void main(String[] args) {
        System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5,
                MaximumTest.maximum(3, 4, 5));
        System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7,
                MaximumTest.maximum(6.6, 8.8, 7.7));
        System.out.printf("Max of %s, %s and %s is %s\n", "pear", "apple", "orange",
                MaximumTest.maximum("pear", "apple", "orange"));
    }
}

class MaximumTest {
    /**
     * determines the largest of three Comparable objects
     */
    public static int maximum(int x, int y, int z) {
        int max = x;

        if (y > max) {
            max = y;
        }

        if (z > max) {
            max = z;
        }
        return max;
    }

    public static double maximum(double x, double y, double z) {
        double max = x;

        if (y > max) {
            max = y;
        }

        if (z > max) {
            max = z;
        }
        return max;
    }

    public static String maximum(String x, String y, String z) {
        String max = x;

        if (y.compareTo(max) > 0) {
            max = y;
        }

        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }
}
```
## 2.

```
public class Client {

    public static void main(String[] args) {
        DIMImpl dim = new DIMImpl();
        System.out.println("Override method: " + dim.add(1, 2));
        System.out.println("default method: " + dim.substract(1, 2));
        System.out.println("static method: " + DIML.blogName());
    }
}

public interface DIML {
    static final String BLOG = "is Chuwa a";

    // abstract method
    int add(int a, int b);

    // default method
    default int substract(int a, int b) {
        return a - b;
    }

    // static method
    static String blogName() {
        return BLOG;
    }
}

public class DIMImpl implements DIML {

    /**
     *   只需要override add, substract 是default方法，不override也不会报错。
     *   但是如果不override add, 就会报错
     */
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}

@FunctionalInterface
public interface Foo {
    String aMethod(String string);

    default String defaultBar() {
        String s = "default Bar method";
        System.out.println(s);
        return s;
    }

    default String defaultCommon() {
        String s = "defaultCommon from Bar";
        System.out.println(s);
        return s;
    }
}

public class LambdaLearn {

    /**
     *
     * https://www.baeldung.com/java-8-lambda-expressions-tips
     *
     * 1， 只能有一个方法。可以有多个default方法（因为default方法被实现了）
     * 2， Avoid Overloading Methods With Functional Interfaces as Parameters， 如果有overloading, 可以用Cast
     *
     * By using the @FunctionalInterface annotation, the compiler will trigger an error in response to any attempt to
     * break the predefined structure of a functional interface. It is also a very handy tool to make our application
     * architecture easier to understand for other developers.
     */

    @Test
    public void overrideFoo() {
        // Before Java 8, we can use Anonymous Class to override this method
        // Interface var = new Class
        // List<Integer> var = new ArrayList<>()
        // Foo 这个interface有一个abstract method, 所以在Anonymous Class里需要override来提供method body
        Foo fooByIC = new Foo() {
            @Override
            public String aMethod(String string) {
                return string + " from Foo";
            }
        };

        String hello = fooByIC.aMethod("hello");
        System.out.println(hello);
    }

    @Test
    public void lambdaFoo() {
        // Foo.aMethod() 是abstract method,缺少method body. lambda 提供method body.
        // 比Anonymous class 简洁很多。
        Foo foo = parameter -> parameter + " from Foo";

        String hello = foo.aMethod("hello");
        System.out.println(hello);
    }

    @Test
    public void lambdaFoo2() {
        // 可以提供任何method body
        Foo foo = parameter -> parameter.toUpperCase() + " from Foo";

        String hello = foo.aMethod("hello");
        System.out.println(hello);
    }

    @Test
    public void testFinal() {
        final String localVariable = "Local";
        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };

        System.out.println(foo.aMethod("hello"));
    }

    /**
     * Use “Effectively Final” Variables
     * 当variable只赋值一次，没有任何变动的时候，Java默认是final。
     * 注意，在lambda expression的前后都不能被改变
     */
    @Test
    public void testEffectivelyFinal() {
        String localVariable = "Local";
        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };

        System.out.println(foo.aMethod("hello"));
    }

    /**
     * 换object会报错，因为换了内存地址
     */
    @Test
    public void testFinal21() {
        String localVariable = "Local";
        localVariable = "LOCAL"; // 新的内存地址

        Foo foo = parameter -> {
//            return parameter + " " + localVariable;
            return parameter;
        };

        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testFinal22() {
        String localVariable = "Local";

        Foo foo = parameter -> {
//            return parameter + " " + localVariable;
            return parameter;
        };

        localVariable = "LOCAL"; // 新的内存地址

        System.out.println(foo.aMethod("hello"));
    }

    /**
     * Object 的set方法不会报错
     */
    @Test
    public void testFinal3() {
        List<Employee> employees = EmployeeData.getEmployees();

        Employee employee = employees.get(0);
        employee.setAge(55);
        Foo foo = parameter -> {
            return parameter + " " + employee;
        };

        System.out.println(foo.aMethod("hello"));
    }
}

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferenceExample {
    public static void main(String[] args) {
        // 1. 静态方法引用
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35));

        // 使用Lambda表达式
        people.sort((p1, p2) -> Person.compareByName(p1, p2));

        // 使用静态方法引用
        people.sort(Person::compareByName);

        // 2. 实例方法引用（特定对象的实例方法）
        Comparator<Person> byAgeComparator = Comparator.comparingInt(Person::getAge);
        people.sort(byAgeComparator);

        // 3. 类的实例方法引用
        // 不要尝试理解Function,将会被stream使用。
        Function<Person, String> getNameFunction = Person::getName;
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.sort(String::compareToIgnoreCase);

        // 4. 构造方法引用
        // 不要尝试理解BiFunction,将会被stream使用。
        BiFunction<String, Integer, Person> personCreator = Person::new;
        Person newPerson = personCreator.apply("David", 40);

        System.out.println(people);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static int compareByName(Person p1, Person p2) {
        return p1.name.compareTo(p2.name);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(1, new User("Alice", new Address("Main Street")));
        userMap.put(2, new User("Bob", null));

        // Without Optional
        String streetName = "Unknown";
        User user = userMap.get(2);
        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                streetName = address.getStreet();
            }
        }
        System.out.println("Street name without Optional: " + streetName);

        // With Optional
        streetName = Optional.ofNullable(userMap.get(2))
                .map(User::getAddress)
                .map(Address::getStreet)
                .orElse("Unknown");
        System.out.println("Street name with Optional: " + streetName);
    }
}

class Address {
    private String street;

    public Address(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }
}

class User {
    private String name;
    private Address address;

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}

public class OptionalMainMethodTest {

    /**
     * https://www.youtube.com/watch?v=wOi2k4dJviM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=684
     * of(T t) - 不可以为null
     * ofNullable(T t) - 可以为null
     * orElse(T t) - 如果当前的optional内部封装的t是非空的，则返回内部t, 如果内部的t是空的， 则返回orElse()方法中的t
     */

    @Test()
    public void testOptionalWithNotHandleException() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.of(employee);

        employee = null;
        // of(T t) - 不可以为null
        Optional<Employee> optional2 = Optional.of(employee);
    }

    @Test(expected = NullPointerException.class)
    public void test1() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.of(employee);

        employee = null;
        // of(T t) - 不可以为null
        Optional<Employee> optional2 = Optional.of(employee);
    }

    @Test
    public void testOfNullable() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.ofNullable(employee);
        System.out.println(optional);

        employee = null;
        Optional<Employee> optional2 = Optional.ofNullable(employee);
        System.out.println(optional2);
    }

    @Test
    public void testOrElse() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.ofNullable(employee);
        System.out.println(optional);

        employee = null;
        Optional<Employee> optional2 = Optional.ofNullable(employee);
        System.out.println(optional2);

        // remember type is not Optional, it is Employee
        Employee employee1 = Optional.ofNullable(employee).orElse(new Employee(1, "JCole", 30, 6666));
        if (employee != null) {
            employee1 = employee;
        } else {
            employee1 = new Employee(1, "JCole", 30, 6666);
        }
        System.out.println(employee1);
    }

    @Test
    public void testOrElseThrow() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.ofNullable(employee);
        System.out.println(optional);

        employee = null;
        Optional<Employee> optional2 = Optional.ofNullable(employee);
        System.out.println(optional2);

        // remember type is not Optional, it is Employee
        Employee employee1 = Optional.ofNullable(employee).orElseThrow(() -> new RuntimeException("Wow Exception"));
        System.out.println(employee1);
    }
}

class OptionalTest {

    @Test
    void testOf() {
        String value = "Hello, Optional!";
        Optional<String> optional = Optional.of(value);
        assertTrue(optional.isPresent());
        assertEquals(value, optional.get());
    }

    @Test
    void testOfNullable() {
        String value = null;
        Optional<String> optional = Optional.ofNullable(value);
        assertFalse(optional.isPresent());
    }

    @Test
    void testEmpty() {
        Optional<String> optional = Optional.empty();
        assertFalse(optional.isPresent());
    }

    @Test
    void testIfPresent() {
        Optional<String> optional = Optional.of("Hello, Optional!");
        optional.ifPresent(value -> assertEquals("Hello, Optional!", value));
    }

    @Test
    void testOrElse() {
        Optional<String> optional = Optional.empty();
        String result = optional.orElse("Default value");
        assertEquals("Default value", result);
    }

    @Test
    void testOrElseGet() {
        Optional<String> optional = Optional.empty();
        String result = optional.orElseGet(() -> "Default value");
        assertEquals("Default value", result);
    }

    @Test
    void testOrElseThrow() {
        Optional<String> optional = Optional.empty();
        assertThrows(NoSuchElementException.class, optional::orElseThrow);
    }

    @Test
    void testFilter() {
        Optional<Integer> optional = Optional.of(42);
        Optional<Integer> filtered = optional.filter(value -> value % 2 == 0);
        assertTrue(filtered.isPresent());
        assertEquals(42, filtered.get());

        filtered = optional.filter(value -> value % 2 != 0);
        assertFalse(filtered.isPresent());
    }

    @Test
    void testMap() {
        Optional<String> optional = Optional.of("Hello, Optional!");
        Optional<Integer> mapped = optional.map(String::length);
        assertTrue(mapped.isPresent());
        assertEquals(16, mapped.get());
    }

    @Test
    void testFlatMap() {
        Optional<String> optional = Optional.of("Hello, Optional!");
        Optional<Integer> flatMapped = optional.flatMap(value -> Optional.of(value.length()));
        assertTrue(flatMapped.isPresent());
        assertEquals(16, flatMapped.get());
    }
}

public class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private int stock;

    public Product(int id, String name, String category, double price, int stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author b1go
 * @date 4/10/23 12:47 AM
 */
public class ProductClient {
    static List<Product> productList = Arrays.asList(
            new Product(1, "Product 1", "Electronics", 99.99, 20),
            new Product(2, "Product 2", "Electronics", 199.99, 15),
            new Product(3, "Product 3", "Electronics", 299.99, 5),
            new Product(4, "Product 4", "Clothing", 49.99, 30),
            new Product(5, "Product 5", "Clothing", 29.99, 25),
            new Product(6, "Product 6", "Clothing", 59.99, 10),
            new Product(7, "Product 7", "Kitchen", 89.99, 8),
            new Product(8, "Product 8", "Kitchen", 120.99, 2),
            new Product(9, "Product 9", "Kitchen", 60.99, 15)
    );

    @Test
    public void toList() {
        // Create a new list containing only the products with a stock greater than 10.
        List<Product> filteredProducts = productList.stream()
                .filter(product -> product.getStock() > 10)
                .collect(Collectors.toList());
    }

    @Test
    public void toSet() {
        // Create a new set containing the unique categories from the list of products.
        Set<String> uniqueCategories = productList.stream()
                .map(Product::getCategory)
                .collect(Collectors.toSet());
    }

    @Test
    public void joining() {
        // Concatenate all product names into a single string, separated by commas.
        String allProductNames = productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", "));

        // Concatenate all product names into a single string, separated by a newline character.
        String allProductNamesNewLine = productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining("\n"));
    }

    @Test
    public void counting() {
        // Count the number of products in each category.
        Map<String, Long> categoryCounts = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
    }

    @Test
    public void summingInt() {
        // Calculate the total stock of all products.
        int totalStock = productList.stream()
                .collect(Collectors.summingInt(Product::getStock));
    }

    @Test
    public void groupingBy() {
        // Group the products by category and calculate the total stock for each category.
        Map<String, Integer> categoryStock = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.summingInt(Product::getStock)));

        // Group the products by category and calculate the average price for each category.
        Map<String, Double> categoryAveragePrice = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));
    }

    @Test
    public void maxBy() {
        // 给定一个Product列表，使用Stream API的maxBy()方法找出价格最高的产品。
        Optional<Product> maxPriceProduct = productList.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Product::getPrice)));
    }

    @Test
    public void partitioningBy() {
        // 给定一个Product列表，使用Stream API的partitioningBy()方法按产品价格是否高于100分组。
        Map<Boolean, List<Product>> partitionedProducts = productList.stream()
                .collect(Collectors.partitioningBy(p -> p.getPrice() > 100));
    }

    @Test
    public void mapping() {
        Set<String> upperCaseNames = productList.stream()
                .map(Product::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
    }

    @Test
    public void match() {
        boolean isAnyProductExpensive = productList.stream()
                .anyMatch(product -> product.getPrice() > 250);
        System.out.println("Is there any expensive product? " + isAnyProductExpensive);

        // allMatch example
        boolean areAllProductsInStock = productList.stream()
                .allMatch(product -> product.getStock() > 0);
        System.out.println("Are all products in stock? " + areAllProductsInStock);

        // noneMatch example
        boolean areNoProductsFree = productList.stream()
                .noneMatch(product -> product.getPrice() == 0);
        System.out.println("Are there no free products? " + areNoProductsFree);
    }

    @Test
    public void findFirst() {
        // findFirst example
        Optional<Product> firstExpensiveProduct = productList.stream()
                .filter(product -> product.getPrice() > 100)
                .findFirst();
        firstExpensiveProduct.ifPresent(product -> System.out.println("First expensive product: " + product.getName()));
    }

    @Test
    public void findAny() {

        // findAny example
        Optional<Product> anyLowStockProduct = productList.stream()
                .filter(product -> product.getStock() < 10)
                .findAny();
        anyLowStockProduct.ifPresent(product -> System.out.println("Any low stock product: " + product.getName()));
    }
}

/**
 * Collections 讲的是数据，Stream讲的是计算（CPU）
 * 1. Stream 自己不会存储元素
 * 2. Stream 不会改变源对象，相反，他们会返回一个持有结果的新stream
 * 3. Stream操作是延迟执行的，这意味着他们会等到需要结果的时候才执行。
 * Stream执行流程：
 * 1. 创建Stream： 获取一个数据源
 * 2. 中间操作： 一个操作链： 对数据进行处理
 * 3. 终止操作： 一旦执行中止操作，则会开始执行中间操作链，并产生结果。之后，不会再被使用。
 * @author bigo
 */
public class StreamApiCreationTest {

    /**
     * 创建Stream的方式
     * 1. 通过集合
     * 2. 通过数组Arrays
     * 3. 通过Stream的Of()
     * 4. 创建无限流
     * 5. 通过Builder
     * 6. Stream of Primitives
     */

    /**
     * col.stream()
     */
    @Test
    public void testCollection() {
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);
        col.forEach(System.out::println);

        // 返回一个顺序流
        Stream<Integer> stream = col.stream();
        System.out.println("Stream object:      " + stream);

        // 返回一个并行流
        Stream<Integer> parallelStream = col.parallelStream();
        System.out.println("Parallel Stream object:     " + parallelStream);
    }

    /**
     * Arrays.stream(arr);
     */
    @Test
    public void testArrays() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(arr);
        System.out.println("Stream object:      " + stream);

        Employee e1 = new Employee(1001, "tom", 20, 2222);
        Employee e2 = new Employee(1002, "Jerry", 18, 5000);
        Employee[] arr1 = new Employee[]{e1, e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
        System.out.println("Stream object:     " + stream1);
    }

    @Test
    public void testOf() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        System.out.println("Stream object:      " + stream);
    }

    /**
     *  ######################  上面部分是重点，下面部分是非重点  ##################
     */
    // ----------------------  华丽分割线  ------------------------------------

    @Test
    public void testIterate() {
        /**
         * 遍历前10个偶数
         * seed : 0, means t's initial value is 0
         * then t is updated every time
         * limit(10) means that it only produce 10 elements then stop.
         */
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
    }

    @Test
    public void testGenerate() {
        /**
         * call Math.random() 10 times
         * limit(10)
         */
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        Stream<String> streamGenerated =
                Stream.generate(() -> "element").limit(10);
        streamGenerated.forEach(System.out::println);
    }

    @Test
    public void testStreamOfPrimitives() {
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);

        System.out.println("Stream Object:  " + intStream);
        intStream.forEach(System.out::println);

        System.out.println("Stream Object:  " + longStream);
        longStream.forEach(System.out::println);
    }
}

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Collections 讲的是数据，Stream讲的是计算（CPU）
 * 1. Stream 自己不会存储元素
 * 2. Stream 不会改变源对象，相反，他们会返回一个持有结果的新stream
 * 3. Stream操作是延迟执行的，这意味着他们会等到需要结果的时候才执行。
 * Stream执行流程：
 * 1. 创建Stream： 获取一个数据源
 * 2. 中间操作： 一个操作链： 对数据进行处理
 * 3. 终止操作： 一旦执行中止操作，则会开始执行中间操作链，并产生结果。之后，不会再被使用。
 */
public class StreamApiEndOperation {
    /**
     * 终止操作
     * 一， 匹配与查找
     * 1， allMatch(Predicate p) - 检查是否匹配所有的元素
     * 2， anyMatch(Predicate p) - 检查是否至少匹配一个元素
     * 3， noneMatch(Predicate p) - 检查是否没有匹配的元素
     * 4, findFirst - 返回第一个元素
     * 5， findAny - 返回当前流中的任意元素
     * 6, count - 返回流中元素的个数
     * 7, max(Comparator c) - 返回流中的最大值
     * 8, min(Comparator c) - 返回流中的最小值
     * 9, forEach(Consumer c) - 内部迭代
     * <p>
     * 二，归约
     * 1, reduce(T identity, BinaryOperator) - 可以将流中的元素反复结合起来，得到一个值
     * 2, reduce(BinaryOperator) - 可以将流中的元素反复结合起来，得到一个值
     * <p>
     * 三， 收集
     * 1, collect(Collector c)
     */

    private static final List<Employee> EMPLOYEES = EmployeeData.getEmployees();

    /**
     * collect最重要
     */
    @Test
    public void testCollect() {
        List<Employee> collect = EMPLOYEES.stream().filter(e -> e.getId() > 1002).collect(Collectors.toList());
        collect.forEach(System.out::println);

        Set<Employee> collect2 = EMPLOYEES.stream().filter(e -> e.getId() > 1002).collect(Collectors.toSet());
        collect2.forEach(System.out::println);
    }

    /**
     * 1， allMatch(Predicate p) - 检查是否匹配所有的元素
     * 2， anyMatch(Predicate p) - 检查是否至少匹配一个元素
     * 3， noneMatch(Predicate p) - 检查是否没有匹配的元素
     */
    @Test
    public void testMatch() {
//        1， allMatch(Predicate p) - 检查是否匹配所有的元素
        boolean allMatch = EMPLOYEES.stream().allMatch(e -> e.getName().length() > 2);
        System.out.println(allMatch);

        System.out.println("***************************");

//        2， anyMatch(Predicate p) - 检查是否至少匹配一个元素
        boolean anyMatch = EMPLOYEES.stream().anyMatch(e -> e.getName().length() > 3);
        System.out.println(anyMatch);

        System.out.println("**************************");

//        3， noneMatch(Predicate p) - 检查是否没有匹配的元素
        boolean noneMatch = EMPLOYEES.stream().noneMatch(e -> e.getName().startsWith("Yun"));
        System.out.println(noneMatch);
    }

    /**
     * 4, findFirst - 返回第一个元素
     * 5， findAny - 返回当前流中的任意元素
     */
    @Test
    public void testFind() {
//        4, findFirst - 返回第一个元素
        Optional<Employee> employee = EMPLOYEES.stream().findFirst();
        System.out.println(employee);

//        5， findAny - 返回当前流中的任意元素
        Optional<Employee> any = EMPLOYEES.parallelStream().findAny();
        System.out.println(any);
    }

    /**
     * 6, count - 返回流中元素的个数
     * 7, max(Comparator c) - 返回流中的最大值
     * 8, min(Comparator c) - 返回流中的最小值
     */
    @Test
    public void testCountMaxMin() {
//        6, count - 返回流中元素的个数
        long count = EMPLOYEES.stream().filter(e -> e.getAge() > 40).count();
        System.out.println("num of employees(age > 40): " + count);

//        7, max(Comparator c) - 返回流中的最大值
        Stream<Integer> stream = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> max = stream.max(Integer::compare);
        System.out.println("max age is: " + max);

//        8, min(Comparator c) - 返回流中的最小值
        Optional<Employee> min = EMPLOYEES.stream()
                .min(Comparator.comparingInt(Employee::getId));
        System.out.println("min age is : " + min);

        EMPLOYEES.stream()
                .filter(e -> e.getAge() > 40)
                .map(e -> e.getName() + " ： OLD PPL")
                .forEach(System.out::println);

        List<String> collect = EMPLOYEES.stream()
                .filter(e -> e.getAge() > 40).map(e -> e.getName() + " ： OLD PPL")
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    /**
     * 9, forEach(Consumer c) - 内部迭代
     * 使用集合的迭代
     */
    @Test
    public void testIteration() {
//        9, forEach(Consumer c) - 内部迭代
        EMPLOYEES.stream().forEach(System.out::println);

        System.out.println("\n********************************\n");
        // 使用集合的迭代
        EMPLOYEES.forEach(System.out::println);
    }

    @Test
    public void testReduce() {
//        1, reduce(T identity, BinaryOperator) - 可以将流中的元素反复结合起来，得到一个值
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

//        2, reduce(BinaryOperator) - 可以将流中的元素反复结合起来，得到一个值
        Stream<Integer> stream = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> reduce1 = stream.reduce(Integer::sum);
        System.out.println(reduce1);

        Stream<Integer> stream2 = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> reduce2 = stream2.reduce((d1, d2) -> d1 + d2);
        System.out.println(reduce2.get());
    }

    /**
     * map是必须要有return的
     */
    @Test
    public void testChain() {
        List<Double> collect = EMPLOYEES.stream()
                .filter(e -> e.getAge() < 40)
                .map(e -> e.getSalary() * 0.8)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("********************");

        Optional<Integer> reduce = EMPLOYEES.stream()
                .filter(e -> e.getAge() < 40)
                .map(e -> e.getSalary() * 0.8)
                .map(e -> {
                    System.out.println(e);
                    return e.intValue();
                })
                .reduce(Integer::sum);
        System.out.println(reduce.get());

        // 在终止操作后，可以继续跟一个新的.stream()来构建chain.
        Optional<Integer> reduce1 = EMPLOYEES.stream()
                .filter(e -> e.getAge() < 40)
                .collect(Collectors.toList())
                .stream()
                .map(e -> e.getSalary() * 0.8)
                .map(e -> {
                    System.out.println(e);
                    return e.intValue();
                })
                .reduce(Integer::sum);
        System.out.println(reduce1.get());
    }

    /**
     * 获得员工中，男性员工中最高工资的人，以及女性员工中最高工资的人
     */
    @Test
    public void testGroupBy() {
        Map<String, Optional<Employee>> collect = EMPLOYEES
                .stream()
                .collect(Collectors
                        .groupingBy(
                                Employee::getGender,
                                Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println("male max salary: " + collect.get("male"));
        System.out.println("female max salary: " + collect.get("female"));
    }

    /**
     * 构建一个map, key是员工ID，value是员工的工资。
     */
    @Test
    public void testToMap() {
        Map<Integer, Double> collect = EMPLOYEES.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        Employee::getSalary
                ));
    }
}

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Collections 讲的是数据，Stream讲的是计算（CPU）
 * 1. Stream 自己不会存储元素
 * 2. Stream 不会改变源对象，相反，他们会返回一个持有结果的新stream
 * 3. Stream操作是延迟执行的，这意味着他们会等到需要结果的时候才执行。
 * Stream执行流程：
 * 1. 创建Stream： 获取一个数据源
 * 2. 中间操作： 一个操作链： 对数据进行处理
 * 3. 终止操作： 一旦执行中止操作，则会开始执行中间操作链，并产生结果。之后，不会再被使用。
 */
public class StreamApiIntermediateOperation {
    /**
     * 创建Stream的中间操作
     * <p>
     * 一，筛选
     * 1. filter(Predicate p) - 接受lambda, 从流中排出某些元素
     * 2. limit(n) - 截断流，使其元素不超过给定的数量
     * 3. skip(n) - 跳过前n个元素
     * 4. distinct() - 筛选，通过元素的hashcode(), equals()去除重复元素
     * <p>
     * 二，映射
     * 1, map(function f) element -> black box(f) -> new element
     * 2, flatMap(function f)
     * 三， 排序
     * 1, sorted
     */
    @Test
    public void testFilter() {
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = col.stream();
        stream.filter(t -> t % 2 == 0).forEach(System.out::println);

        // 获取员工姓名长度大于3的员工姓名
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> nameStream = employees.stream().map(Employee::getName);
        nameStream.filter(name -> name.length() > 6).forEach(System.out::println);
    }

    @Test
    public void testLimit() {
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);
        col.stream().limit(3).forEach(System.out::println);
    }

    @Test
    public void testSkip() {
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);
        col.stream().skip(2).forEach(System.out::println);
    }

    @Test
    public void testDistinct() {
        int[] arr = new int[]{1, 2, 3, 4, 4, 2, 5};
        IntStream st = Arrays.stream(arr);
        st.distinct().forEach(System.out::println);
    }

    // https://www.youtube.com/watch?v=jPjOW6f1_EA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=678

    /**
     * 映射
     * map(Function f)： 使用函数 f 对数据进行处理
     */
    @Test
    public void testMap() {
        // map(Function f) - 接收一个函数作为参数，将元素转换成其它形式或提取信息，该函数会被
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    /**
     * 把两个string里面的数字相加并求和。 1 + 2+ 3 + ... + 9 + 10
     */
    @Test
    public void testFlatMap() {
        // 1. 构造一对二维数组
        List<String> lists1 = Arrays.asList("1", "2", "33", "4", "5");
        List<String> lists2 = Arrays.asList("6", "7", "8", "9", "10");
        List<List<String>> listsOfStrings = new ArrayList<>();
        listsOfStrings.add(lists1);
        listsOfStrings.add(lists2);
        // listOfStrings是 [[1, 2, 3, 4, 5], [6, 7, 8, 9, 10]]  -> [1,2,3,4,5,6,7,8,9]
        System.out.println("listsOfStrings: " + listsOfStrings);

        // 2. 分步骤使用flatmap找到最大值。 为了方便理解
        System.out.println("**** 分步骤使用flatmap找到最大值 *****");
        // 2.1 把一个二维的strign flatten为一个string stream对象。 注意flatMap里，input是list, 输出是list转换的stream对象。
        Stream<String> stringStream = listsOfStrings.stream().flatMap(list -> list.stream());
        // 2.1.1 如果是使用普通map，则生成的是Stream<Stream>对象
        Stream<Stream<String>> streamStream = listsOfStrings.stream().map(list -> list.stream());
        // 2.2 将string 转为int数组，然后找出max值，此时max()方法返回的是Optional<Integer>
        OptionalInt max = stringStream.mapToInt(Integer::parseInt).max();
        // 2.3 从Optional里拿出int数值。
        int asInt = max.getAsInt();
        System.out.println(asInt);

        // 2.使用flatmap找到最大值。不分步骤。 日常工作这么写。
        System.out.println("**** 使用flatmap找到最大值。不分步骤。 *****");
        int asInt1 = listsOfStrings
                .stream()
                .flatMap(list -> list.stream())
                .mapToInt(Integer::parseInt)
                .max().getAsInt();
        System.out.println(asInt1);
    }

    @Test
    public void testIntermediateOperationChain() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        // 找出list2中的偶数，并乘以10
        List<Integer> collect = list2.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 10)
                .collect(Collectors.toList());

        list1.addAll(collect);

        System.out.println(list1);
    }

    /**
     * 排序
     * https://www.youtube.com/watch?v=DlHnbbS3bBY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=679
     */
    @Test
    public void testSorted() {
        List<Integer> list = Arrays.asList(87, 2, 65, 34, 72, 12);
        list.stream().sorted().forEach(System.out::println);

        System.out.println("\n***********\n");

        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).forEach(System.out::println);

        System.out.println("\n********* equals ***************\n");
        Stream<Employee> stream = employees.stream();
        Stream<Employee> sorted = stream.sorted(Comparator.comparingInt(Employee::getAge));
        sorted.forEach(System.out::println);
    }
}

public class StreamExercise {
    @Test
    public void testMapAndFlatMap() {
        List<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("word");

        //将words数组中的元素再按照字符拆分，然后字符去重，最终达到["h", "e", "l", "o", "w", "r", "d"]
        //如果使用map，是达不到直接转化成List<String>的结果
        List<String> stringList = words.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                .distinct()
                .collect(Collectors.toList());
        stringList.forEach(e -> System.out.println(e));
    }

    @Test
    public void testMapAndFlatMap2() {
        List<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("word");

        //将words数组中的元素再按照字符拆分，然后字符去重，最终达到["h", "e", "l", "o", "w", "r", "d"]
        //如果使用map，是达不到直接转化成List<String>的结果
        List<Stream<String>> collect = words.stream()
                .map(word -> Arrays.stream(word.split("")))
                .distinct()
                .collect(Collectors.toList());
        collect.forEach(e -> System.out.println(e));
        System.out.println("**** above are stream objects, below are character *****");
        for (Stream<String> stringStream : collect) {
            stringStream.forEach(System.out::println);
        }
    }
}
```

## 3. 
```
@Test
	@DisplayName("Obtain a list of product with category = \"Books\" and price > 100")
	public void exercise1() {
		long startTime = System.currentTimeMillis();
		List<Product> result = productRepo.findAll()
		.stream()
		.filter(p -> p.getCategory().equalsIgnoreCase("Books"))
		.filter(p -> p.getPrice() > 100)
		.collect(Collectors.toList());
		long endTime = System.currentTimeMillis();

		log.info(String.format("exercise 1 - execution time: %1$d ms", (endTime - startTime)));
		result.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Obtain a list of product with category = \"Books\" and price > 100 (using Predicate chaining for filter)")
	public void exercise1a() {
		Predicate<Product> categoryFilter = product -> product.getCategory().equalsIgnoreCase("Books");
		Predicate<Product> priceFilter = product -> product.getPrice() > 100;

		long startTime = System.currentTimeMillis();
		List<Product> result = productRepo.findAll()
				.stream()
				.filter(product -> categoryFilter.and(priceFilter).test(product))
				.collect(Collectors.toList());
		long endTime = System.currentTimeMillis();

		log.info(String.format("exercise 1a - execution time: %1$d ms", (endTime - startTime)));
		result.forEach(p -> log.info(p.toString()));
	}
```

## 4.

```
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Collections;

/**
 * Utility class for shopping cart operations.
 */
public class ShoppingCartUtil {

    private static final List<String> ALTERNATIVE_ITEMS = Arrays.asList("Apple", "Orange", "Banana", "Grape");

    // Get the first item name from a customer's cart
    public static Optional<String> getFirstItemName(Customer customer) {
        return Optional.ofNullable(customer)
            .map(Customer::getCart)
            .filter(not(List::isEmpty))
            .map(list -> list.get(0).getName());
    }

    // Calculate the total price of items in a customer's cart
    public static double getTotalPrice(Optional<Customer> optionalCustomer) {
        return optionalCustomer
            .map(Customer::getCart)
            .orElse(Collections.emptyList())
            .stream()
            .mapToDouble(Item::getPrice)
            .sum();
    }

    // Get the first item name with an alternative if not available
    public static String getFirstItemNameWithAlternative(Customer customer) {
        return Optional.ofNullable(customer)
            .map(Customer::getCart)
            .filter(not(List::isEmpty))
            .map(list -> list.get(0).getName())
            .orElseGet(ShoppingCartUtil::getRandomAlternativeItem);
    }

    // Get the first item name or throw a custom exception if the cart is empty
    public static String getFirstItemNameOrThrowException(Customer customer) throws EmptyCartException {
        return Optional.ofNullable(customer)
            .map(Customer::getCart)
            .filter(not(List::isEmpty))
            .map(list -> list.get(0).getName())
            .orElseThrow(EmptyCartException::new);
    }

    // Check if there are items in the cart and print appropriate messages
    public static void checkItemsInCart(Customer customer) {
        Optional.ofNullable(customer)
            .map(Customer::getCart)
            .ifPresent(list -> {
                if (!list.isEmpty()) {
                    System.out.println("购物车中有商品");
                } else {
                    System.out.println("购物车为空");
                }
            });
    }

    // Print all item names in the cart if available
    public static void printItemsInCart(Customer customer) {
        Optional.ofNullable(customer)
            .map(Customer::getCart)
            .ifPresent(list -> {
                if (!list.isEmpty()) {
                    list.forEach(item -> System.out.println(item.getName()));
                } else {
                    System.out.println("购物车为空");
                }
            });
    }

    // Select a random item from a predefined list of alternatives
    public static String getRandomAlternativeItem() {
        Random random = new Random();
        int randomIndex = random.nextInt(ALTERNATIVE_ITEMS.size());
        return ALTERNATIVE_ITEMS.get(randomIndex);
    }

    // Helper method to negate a predicate (useful for filters)
    private static <T> Predicate<T> not(Predicate<T> t) {
        return t.negate();
    }
}

/**
 * Assuming the existence of Customer, Cart, and Item classes with appropriate getters.
 * If these classes do not exist, they should be implemented accordingly.
 */

```

## 5. 

1. Null Checks
   Practice: Always check for null before using an object reference.

Example:
```
public void printName(String name) {
if (name != null) {
System.out.println(name);
} else {
System.out.println("Name is null!");
}
}
```
2. Using Java Optional Class
   Practice: Use Optional to handle values that might be null. This approach can replace explicit null checks and prevent NPE by making nullability a part of your method's contract.

Example:
```
public String getFirstName(List<String> names) {
return names.stream()
.findFirst()
.orElse("No names available");
}
```
3. Assertions
   Practice: Use assertions to catch null references during development, particularly for internal methods where passing null would be a programming error.

Example:
```
public void processUser(User user) {
assert user != null : "User must not be null";
System.out.println("Processing user: " + user.getName());
}
```
## 6. 

1. Lambda Expressions
   Feature Description: Lambdas add functional programming features to Java, making it easier to write code that is more concise and readable, especially when using functional interfaces.

``` 
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
Collections.sort(names, (a, b) -> a.compareTo(b));
```

2. Streams
   Feature Description: The Stream API allows for declarative processing of collections (and other types of data) using various operations (filter, map, reduce, etc.), which can be performed in parallel effortlessly.
``` 
List<String> filteredNames = names.stream()
    .filter(name -> name.startsWith("A"))
    .collect(Collectors.toList()); 
```
3. Method References
   Feature Description: Method references enhance readability and conciseness by allowing methods to be used as lambdas.
``` 
List<String> namesUpperCase = names.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

4. Optional
   Feature Description: Optional is a container object used to contain not-null objects. Optional object is used to represent null with absent value.

``` 
public String getCountry(User user) {
    return Optional.ofNullable(user)
        .map(User::getAddress)
        .map(Address::getCountry)
        .orElse("Unknown");
}
```

## 7.

1. Improved Code Readability
   By using Optional, it's clear from the method signature that there might not be a value present. This is more expressive than simply returning null from a method, which requires extra documentation to specify. Optional makes your code more readable and self-documenting.

2. Avoiding NullPointerException
   Optional forces you to actively think about the case where a value might be absent, helping you to avoid NullPointerException. It provides methods like orElse, orElseGet, and orElseThrow, which allow handling missing values explicitly, reducing the likelihood of runtime exceptions due to null dereferencing.

3. Streamlining Null Handling
   Optional integrates seamlessly with the Stream API, making it easier to handle values that might be null in a functional style. For example, you can map over an Optional or filter it without needing to check for null explicitly. This helps in writing cleaner, more elegant code.

4. Better API Design
   When an API returns an Optional, it clearly communicates to the client that the result might not exist. This can help API consumers handle the absence of values more gracefully and make more robust and error-free software.

5. Facilitates Handling of Absent Values
   Instead of using conditionals to check for nulls, Optional provides utility methods like isPresent() and isEmpty() to check if a value is available. It also supports functional-style operations like ifPresent() that execute a block of code only when the value is present.

6. Support for Default Values and Actions
   Optional makes it easy to define default actions or values when a value is absent. For instance, orElse() allows returning a default value if Optional is empty, which can simplify many conditional statements in your code.

## 8. 

Functional Interfaces
A functional interface is an interface that contains exactly one abstract method. These serve as the types for lambda expressions and method references. Java uses functional interfaces to provide a target type in contexts where a lambda expression is used.

The @FunctionalInterface annotation is an informative annotation that can be used to indicate that an interface is intended to be a functional interface. While it's not required to use this annotation to define a functional interface, it helps in providing clarity and also causes the compiler to generate an error if the annotated interface does not satisfy the conditions (i.e., it must have exactly one abstract method).

Lambda Expressions
Lambda expressions are a concise way of representing an instance of a functional interface. They allow you to write less verbose code, particularly when implementing simple method contracts of functional interfaces, without the need for an anonymous class.

``` 
@FunctionalInterface
interface NumericTest {
    boolean computeTest(int n);
}

public class TestFunctionalInterface {
    public static void main(String[] args) {
        // Using lambda expression to implement NumericTest functional interface
        NumericTest isEven = (n) -> (n % 2) == 0;

        System.out.println("Is 10 even? " + isEven.computeTest(10));  // Output: Is 10 even? true
        System.out.println("Is 3 even? " + isEven.computeTest(3));    // Output: Is 3 even? false
    }
}
```

## 9. 
There are four types of method references in Java:

- Reference to a static method: Uses the syntax ClassName::staticMethodName
```
public class Utility {
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
List<Integer> evenNumbers = numbers.stream()
                                   .filter(Utility::isEven)
                                   .collect(Collectors.toList());
System.out.println(evenNumbers); // Output: [2, 4, 6]

```
- Reference to an instance method of a particular object: Uses the syntax instance::instanceMethodName
```
public class Example {
    public void printUpperCase(String string) {
        System.out.println(string.toUpperCase());
    }
}

Example example = new Example();
List<String> messages = Arrays.asList("hello", "world");
messages.forEach(example::printUpperCase); // Output: HELLO WORLD
```
- Reference to an instance method of an arbitrary object of a particular type: Uses the syntax ClassName::instanceMethodName
```
List<String> strings = Arrays.asList("hello", "world");
strings.stream()
       .map(String::toUpperCase)
       .forEach(System.out::println); // Output: HELLO WORLD

```
- Reference to a constructor: Uses the syntax ClassName::new
```
class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
List<Person> people = names.stream()
                           .map(Person::new)
                           .collect(Collectors.toList());
people.forEach(person -> System.out.println(person.getName())); // Output: Alice Bob Charlie
```

## 10.
Specifically, lambda expressions can capture and use local variables only if they are effectively final. An effectively final variable is one whose value does not change after it is first assigned.
``` 
import java.util.function.IntConsumer;

public class LambdaExample {
    public static void main(String[] args) {
        int base = 10;  // Effectively final variable

        // Lambda that captures and uses the effectively final variable 'base'
        IntConsumer addBase = (a) -> System.out.println(a + base);

        addBase.accept(5);  // Output will be 15
        // base = 20;  // Uncommenting this line will cause a compilation error
    }
}
```

## 11.
Yes, a functional interface in Java can extend another interface, and this includes both functional and non-functional interfaces. However, there are specific rules that must be adhered to in order for the interface to remain functional.

Rules for Functional Interfaces Extending Other Interfaces
- Single Abstract Method: The resulting interface must still have exactly one abstract method. This ensures that it still qualifies as a functional interface.

- Inheriting Abstract Methods: A functional interface can extend another interface and still be a functional interface if:

  - The parent interface does not have any abstract methods.
  - The parent interface has one abstract method, and the child interface does not introduce any new abstract methods.
  - The parent interface’s abstract methods are overridden as default or static methods in the child interface.

## 12.
Intermediate operations are those operations on a stream that return another stream. These are invoked on a stream instance and after processing, they hand over a new stream for any further operations. This allows them to be chained one after the other in what is referred to as a "stream pipeline". They are lazy in execution, meaning they do not execute until a terminal operation is invoked. That is, intermediate operations are set up during their invocation but don't begin processing the data.

Terminal operations are those operations that close a stream. After a terminal operation is performed, the stream can no longer be used. Terminal operations either produce a result (such as a primitive value, a collection, or perhaps nothing at all) or a side-effect, such as printing each element. Once a terminal operation is performed, the data processing chain is considered consumed, and no more operations can be performed on that stream.

## 13.
``` 
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private String department;

    public Employee(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name + " (" + age + ", " + department + ")";
    }
}

public class StreamDemo {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 34, "HR"),
            new Employee("Bob", 24, "HR"),
            new Employee("Charlie", 44, "IT"),
            new Employee("Diana", 29, "Marketing")
        );

        // Let's apply some intermediate operations
        performOperations(employees);
    }

    public static void performOperations(List<Employee> employees) {
    System.out.println("Original Employees: " + employees);

    List<Employee> hrEmployees = employees.stream()
        .filter(e -> "HR".equals(e.getDepartment()))
        .collect(Collectors.toList());
    System.out.println("HR Employees: " + hrEmployees);

    List<String> employeeNames = employees.stream()
        .map(Employee::getName)
        .collect(Collectors.toList());
    System.out.println("Employee Names: " + employeeNames);

    List<Employee> sortedByAge = employees.stream()
        .sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
        .collect(Collectors.toList());
    System.out.println("Employees sorted by age: " + sortedByAge);
}

}

```

## 14.
Here are the fundamental differences between Collections and Streams:

Purpose and Design: Collections are primarily designed to manage groups of data elements, whereas Streams are designed to perform computations on data elements sourced from collections, arrays, or other I/O channels.

Data Handling: Collections directly store elements and can be accessed and modified explicitly. Streams do not store data but instead pull it from a source, compute results as specified, and optionally return a result or output a side-effect.

Usage of Memory: Collections hold all their elements in memory simultaneously, while streams compute elements on-the-fly and thus do not need to store all elements.

Operations: Operations on collections can modify the collection itself (mutative operations). Stream operations, however, usually result in new streams or values and do not modify the underlying data source.

Iteration: Collections use external iteration (for example, using a for-each loop). Streams facilitate internal iteration, where the iteration is abstracted away through operations like map, filter, etc.

## 15. Leetcode using stream
``` 
class Solution {
    public int sumOfUnique(int[] nums) {
        
        return Arrays.stream(nums)
                     .boxed()  // Necessary to use Collectors
                     .collect(Collectors.groupingBy(i -> i, Collectors.counting()))  // Creates a frequency map
                     .entrySet()
                     .stream()
                     .filter(entry -> entry.getValue() == 1)  // Filters entries based on count
                     .mapToInt(Map.Entry::getKey)  // Converts filtered entries back to a stream of integers
                     .sum();
    }
}
```