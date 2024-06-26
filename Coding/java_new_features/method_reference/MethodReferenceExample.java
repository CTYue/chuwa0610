package com.chuwa.exercise.java_new_features.method_reference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferenceExample {
 public static void main(String[] args) {
  // 1. 静态方法引用
  List<Person> people = Arrays.asList(
          new Person("Mary", 22),
          new Person("Bob", 25),
          new Person("Charlie", 35));

  // 使用Lambda表达式
  people.sort((p1, p2) -> Person.compareByName(p1, p2));

  //people.sort((p1, p2) -> Person.compareByName(p1, p2));
  people.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));


  // 使用静态方法引用
  people.sort(Person::compareByName);
  people.sort(Person::compareByName);


  // 2. 实例方法引用（特定对象的实例方法）
  Comparator<Person> byAgeComparator = Comparator.comparingInt(Person::getAge);
  people.sort(byAgeComparator);

  Comparator<Person> ageComparator1 = (p1, p2) -> p1.getAge() - p2.getAge();
  people.sort(ageComparator1);

  Comparator<Person> ageComparator2 = Comparator.comparingInt(p -> p.getAge());
  people.sort(ageComparator2);

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