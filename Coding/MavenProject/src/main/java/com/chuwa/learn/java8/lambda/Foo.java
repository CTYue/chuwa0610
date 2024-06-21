package com.chuwa.learn.java8.lambda;

@FunctionalInterface
public interface Foo {
    String aMethod(String s);

    default String bMethod() {
        String s = "This is default bMethod";
        System.out.println(s);
        return s;
    }

    default String cMethod() {
        String s = "This is default cMethod";
        System.out.println(s);
        return s;
    }
}
