package com.chuwa.learn.stream_api;


import com.chuwa.learn.optional.Employee;
import com.chuwa.learn.optional.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiEndOperation {
    private static final List<Employee> EMPLOYEES = EmployeeData.getEmployees();
    @Test
    public void testCollect(){
        List<Employee> collect = EMPLOYEES.stream().filter(e -> e.getId() > 1002).collect(Collectors.toList());
        collect.forEach(System.out::println);

        Set<Employee> collect2 = EMPLOYEES.stream().filter(e -> e.getId() > 1002).collect(Collectors.toSet());
        collect2.forEach(System.out::println);
    }

    @Test
    public void testMatch(){
        boolean allMatch = EMPLOYEES.stream().allMatch(e -> e.getName().length() > 2);
        System.out.println(allMatch);

        boolean anyMatch = EMPLOYEES.stream().anyMatch(e -> e.getName().length() > 3);
        System.out.println(anyMatch);

        boolean noneMatch = EMPLOYEES.stream().noneMatch(e -> e.getName().startsWith("Yun"));
        System.out.println(noneMatch);
    }

    @Test
    public void testFind(){
        Optional<Employee> employee = EMPLOYEES.stream().findFirst();
        System.out.println(employee);

        Optional<Employee> any = EMPLOYEES.parallelStream().findAny();
        System.out.println(any);
    }

    @Test
    public void testCountMaxMin(){
        long count = EMPLOYEES.stream().filter(e -> e.getAge() > 40).count();
        System.out.println("num of employee(age > 40)" + count);

        Stream<Integer> stream = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> max = stream.max(Integer::compare);
        System.out.println("max age is" + max);

        Optional<Employee> min = EMPLOYEES.stream().min(Comparator.comparingInt(Employee :: getId));
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
    public void testIteration(){
        EMPLOYEES.stream().forEach(System.out::println);
        System.out.println("\n********************************\n");
        EMPLOYEES.forEach(System.out ::println);
    }
}
