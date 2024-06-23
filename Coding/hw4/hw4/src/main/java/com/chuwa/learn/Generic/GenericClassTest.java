package com.chuwa.learn.Generic;

public class GenericClassTest {
    public static void main(String[] args) {
        GenericClass<Integer> obj1 = new GenericClass<>(1);
        System.out.println(obj1.getObj());

        GenericClass<Double> obj2 = new GenericClass<>(11.111);
        System.out.println(obj2.getObj());

        GenericClass<String> obj3 = new GenericClass<>("Test String");
        System.out.println(obj3.getObj());
    }
}
