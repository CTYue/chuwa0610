package com.chuwa.learn.generic;

public class GenericClassTest {
    public static void main(String[] args) {
        GenericClass<Integer> obj1 = new GenericClass<>(1);
        System.out.println(obj1.getObject());

        GenericClass<Double> obj2 = new GenericClass<>(2.0);
        System.out.println(obj2.getObject());

        GenericClass<String> obj3 = new GenericClass<>("Hello World!");
        System.out.println(obj3.getObject());
    }
}
