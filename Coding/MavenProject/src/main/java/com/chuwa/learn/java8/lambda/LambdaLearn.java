package com.chuwa.learn.java8.lambda;

import com.chuwa.learn.java8.pojos.Employee;
import com.chuwa.learn.java8.utils.EmployeeData;
import org.junit.Test;

import java.util.List;

public class LambdaLearn {

    @Test
    public void overrideFoo() {
        Foo fooByIC = new Foo() {
            @Override
            public String aMethod(String string) {
                return string + " from Foo";
            }
        };

        String string = fooByIC.aMethod("Hello");
        System.out.println(string);
    }

    @Test
    public void lambdaFoo(){
        Foo fooByIC = (string)-> string + " from Lambda Foo";
        String string = fooByIC.aMethod("Hello");
        System.out.println(string);
    }

    @Test
    public void lambdaFoo2(){
        Foo fooByIC = (string)-> string.toUpperCase() + " from Lambda Foo";
        String string = fooByIC.aMethod("Hello");
        System.out.println(string);
    }

    @Test
    public void testFinal() {
        final String localVariable = "Local";
        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };

        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testEffectivelyFinal() {
        String localVariable = "Local";
        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };

        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testFinal21() {
        String localVariable = "Local";
        localVariable = "LOCAL";

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

        localVariable = "LOCAL";

        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testFinal3() {
        List<Employee> employees = EmployeeData.getEmployees();

        Employee employee = employees.get(0);
        employee.setAge(55); // 调用set方法不会改变employee对象的内存地址，也就是employee的值未变，所以仍然是effective final
        Foo foo = parameter -> {
            return parameter + " " + employee;
        };

        System.out.println(foo.aMethod("hello"));
    }

}
