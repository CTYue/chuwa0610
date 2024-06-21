package com.chuwa.learn.features.lambda;
import java.util.*;

public class lambdaLearn {
    public static void main(String[] args) {
        // public void overrideFoo() {
        Foo fooByIC = new Foo () {
            @Override
            public String aMethod(String string) {
                return string + " From Foo";
            }
        };

        String hello = fooByIC.aMethod("hello");
        System.out.println(hello);

        // public void lambdaFoo() {
        Foo foo = parameter -> parameter + " From Foo";
        String hello2 = foo.aMethod("hello2 ");
        System.out.println(hello2);

        // public void lambdaFoo2() {
        Foo foo1 = parameter -> parameter.toUpperCase() + " From foo";
        String hello3 = foo1.aMethod("hello3 ");
        System.out.println(hello3);

        // public void testFinal() {
        final String localVariable = "local";
        Foo foo2 = parameter -> {
           return parameter + " " + localVariable;
        } ;
        String str = foo2.aMethod("yoyoyu");
        System.out.println(str);

        //public void testEffectivelyFinal() {
        // the varaible used by lambda, should be final
        String localVariable2 = "local";
        Foo foo3 = parameter -> {
            return parameter + " " + localVariable2;
        };
        System.out.println(foo3.aMethod("effective final"));
        // public void testFinal21() {
        //localVariable2 = "test";  error, localVaraible2 should be final or effectively final

        //public void testFinal22() {
        String testLocal = "testLocal";
        Foo foo4 = parameter -> "jipppee";
        System.out.println(foo4.aMethod("??"));
        testLocal = "testLocal2";

        //public void testFinal3() {

        //  the object's internal state can still be modified.
        
        Empolyee empolyee = new Empolyee(20);
        Foo foo5 = parameter -> {
            return parameter + empolyee;
        };
        System.out.println(foo5.aMethod("MEAW "));
        empolyee.setAge(15);
    }

    static class Empolyee {

        private int age;
        public void setAge(int num) {
            this.age = num;
        }
        public  Empolyee(int num) {
            this.age = num;
        }
        public String toString() {
            return "Empolyee [age=" + age + "]";
        }
    }

}
