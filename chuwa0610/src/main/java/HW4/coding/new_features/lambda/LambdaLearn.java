package HW4.coding.new_features.lambda;

import org.junit.Test;

import java.util.List;

public class LambdaLearn {
    @Test
    public void overrideFoo(){
        Foo fooByIC = new Foo(){
            @Override
            public String aMethod(String str){
                return str + " from Foo";
            }
        };
        String hello = fooByIC.aMethod("Hello");
        System.out.println(hello);
    }

    @Test
    public void lambdaFoo(){
        Foo foo = param -> param + " from Foo";

        String hello = foo.aMethod("hello");
        System.out.println(hello);
    }

    @Test
    public void testFinal(){
        final String localVariable = "Local";
        Foo foo = param -> {
            return param + " " + localVariable;
        };
        System.out.println(foo.aMethod("Hello"));
    }

    @Test
    public void testEffectivelyFinal(){
        String localVariable = "Local";
        Foo foo = param -> {
            return param + " " + localVariable;
        };
        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testFinal1(){
        String localVariable = "Local";
        localVariable = "LOCAL";
        Foo foo = param -> {
//            return param + " " + localVariable; // should be effectively final
            return param;
        };
        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testFinal2(){
        String localVariable = "Local";
        Foo foo = param -> {
//            return param + " " + localVariable; // should be effectively final
            return param;
        };
        localVariable = "LOCAL"; // Still error
        System.out.println(foo.aMethod("hello"));
    }

    /**
     * Setter is allowed
     */
    @Test
    public void testFinal3() {
        List<Employee> employees = EmpolyeeData.getEmployees();
        Employee employee = employees.get(0);
        employee.setAge(55);
        Foo foo = param -> {
            return param + " " + employee;
        };
        System.out.println(foo.aMethod("hello"));
    }
}
