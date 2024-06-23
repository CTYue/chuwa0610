package com.chuwa.exercise.collection.hw4.Generic;

import com.chuwa.exercise.collection.hw4.Generic.GenericClass;

public class GenericClassTest {
    public static void main(String[] args) {
        // Test for Integer type
        GenericClass<Integer> obj1 = new GenericClass<>(5);
        System.out.println(obj1.getObj());

        // Test for double type
        GenericClass<Double> obj2 = new GenericClass<>(15.77);
        System.out.println(obj2.getObj());

        // Test for String type
        GenericClass<String> obj3 = new GenericClass<>("string here");
        System.out.println(obj3.getObj());
    }
}
