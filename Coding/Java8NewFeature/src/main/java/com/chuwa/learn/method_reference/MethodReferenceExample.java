package com.chuwa.learn.method_reference;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

class Person{
    private String name;
    private int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public static int compareByName(Person p1, Person p2){
        return p1.name.compareTo(p2.name);
    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return name + "(" + age + ")";
    }
}
public class MethodReferenceExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35));
        // lambda
        people.sort((p1, p2)-> Person.compareByName(p1, p2));
        // 方法引用
        people.sort(Person::compareByName);
        // 定义一个 comparator 对象
        Comparator<Person> byAgeComparator = Comparator.comparingInt(Person::getAge);
        // 使用 comparator 对象
        people.sort(byAgeComparator);

        Function<Person, String> getNameFunction = Person::getName;
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.sort(String::compareToIgnoreCase);

        BiFunction<String, Integer, Person> personCreator = Person:: new;
        Person newPerson = personCreator.apply("David", 40);

        System.out.println(people);



    }

}

