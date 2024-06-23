package com.chuwa.learn.stream_api;

import com.chuwa.learn.optional.Employee;
import com.chuwa.learn.optional.EmployeeData;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiIntermediateOperation {
    @Test
    public void testFilter(){
        List<Integer> col = Arrays.asList(1,2,3,4,5,6);
        Stream<Integer> stream = col.stream();
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> nameStream = employees.stream().map(Employee::getName);
        nameStream.filter(name->name.length() > 6).forEach(System.out::println);
    }

    @Test
    public void testLimit(){
        List<Integer> col = Arrays.asList(1,2,3,4,5);
        col.stream().limit(3).forEach(System.out::println);
    }

    @Test
    public void testSkip(){
        List<Integer> col = Arrays.asList(1,2,3,4,5,6);
        col.stream().skip(2).forEach(System.out::println);
    }

    @Test
    public void testDistinct(){
        // 去重复
        int[] arr = new int[]{1,2,3,3,3,4,5,6};
        IntStream st = Arrays.stream(arr);
        st.distinct().forEach(System.out::println);
    }

    @Test
    public void testMap(){
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    @Test
    public void testFlatMap(){
        List<String> lists1 = Arrays.asList("1", "2", "33", "4", "5");
        List<String> lists2 = Arrays.asList("6", "7", "8", "9", "10");
        List<List<String>> listOfString = new ArrayList<>();
        listOfString.add(lists1);
        listOfString.add(lists2);
        System.out.println("listsOfStrings: " + listOfString);

        Stream<String> stringStream = listOfString.stream().flatMap(list -> list.stream());
        Stream<Stream<String>> streamStream = listOfString.stream().map(list -> list.stream());
//        streamStream.forEach(innerStream -> innerStream.forEach(System.out::println));
//        stringStream.forEach(System.out::println);
        OptionalInt max = stringStream.mapToInt(Integer::parseInt).max();
        int asInt = max.getAsInt();
        System.out.println(asInt);

        // Chain process
        int asInt1 = listOfString.stream().flatMap(list -> list.stream()).mapToInt(Integer::parseInt).max().getAsInt();
        System.out.println(asInt1);
    }

    @Test
    public void testIntermediateOperationChain(){
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        List<Integer> collect = list2.stream().filter(e->e%2 ==0).map(e->e*10).collect(Collectors.toList());

        list1.addAll(collect);

        System.out.println(list1);

    }

    @Test
    public void testSorted(){
        List<Integer> list = Arrays.asList(87, 2, 65, 34, 72, 12);
        list.stream().sorted().forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).forEach(System.out::println);


        Stream<Employee> stream = employees.stream();
        Stream<Employee> sorted = stream.sorted(Comparator.comparingInt(Employee::getAge));
        sorted.forEach(System.out::println);
    }
}
