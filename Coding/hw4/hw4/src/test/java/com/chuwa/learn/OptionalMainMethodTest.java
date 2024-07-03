package com.chuwa.learn;

import org.junit.Test;

import java.util.Optional;

import static java.util.Optional.*;
import static java.util.Optional.ofNullable;

public class OptionalMainMethodTest {

    @Test()
    public void testOptionalWithNotHandleException() {
        Employee employee = new Employee();
        Optional<Employee> optional = of(employee);

        employee = null;
        // of(T t) - 不可以为null
        Optional<Employee> optional2 = of(employee);
    }

    @Test(expected = NullPointerException.class)
    public void test1() {
        Employee employee = new Employee();
        Optional<Employee> optional = of(employee);

        employee = null;
        // of(T t) - 不可以为null
        Optional<Employee> optional2 = of(employee);
    }

    @Test
    public void testOfNullable() {
        Employee employee = new Employee();
        Optional<Employee> optional = ofNullable(employee);
        System.out.println(optional);

        employee = null;
        Optional<Employee> optional2 = ofNullable(employee);
        System.out.println(optional2);
    }

    @Test
    public void testOrElse() {
        Employee employee = new Employee();
        Optional<Employee> optional = ofNullable(employee);
        System.out.println(optional);

        employee = null;
        Optional<Employee> optional2 = ofNullable(employee);
        System.out.println(optional2);

        // remember type is not Optional, it is Employee
        Employee employee1 = ofNullable(employee).orElse(new Employee(1, "JCole", 30, 6666));
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
        Optional<Employee> optional = ofNullable(employee);
        System.out.println(optional);

        employee = null;
        Optional<Employee> optional2 = ofNullable(employee);
        System.out.println(optional2);

        // remember type is not Optional, it is Employee
        Employee employee1 = ofNullable(employee).orElseThrow(() -> new RuntimeException("Wow Exception"));
        System.out.println(employee1);
    }
}