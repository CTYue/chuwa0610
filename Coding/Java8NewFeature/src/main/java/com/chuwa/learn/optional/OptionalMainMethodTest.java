package com.chuwa.learn.optional;


import org.junit.Test;

import javax.swing.text.html.Option;
import java.awt.desktop.SystemEventListener;
import java.util.Optional;

public class OptionalMainMethodTest {
    @org.junit.Test()
    public void testOptionalWithNotHandleException() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.of(employee);

        employee = null;
        // of(T t) - 不可以为null
        Optional<Employee> optional2 = Optional.of(employee);
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void test1() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.of(employee);

        employee = null;
        // of(T t) - 不可以为null
        Optional<Employee> optional2 = Optional.of(employee);
    }

    @org.junit.Test
    public void testOfNullable() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.ofNullable(employee);
        System.out.println(optional);

        employee = null;
        Optional<Employee> optional2 = Optional.ofNullable(employee);
        System.out.println(optional2);
    }

    @org.junit.Test
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