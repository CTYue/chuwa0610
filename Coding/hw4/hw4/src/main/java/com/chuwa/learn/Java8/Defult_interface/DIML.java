package com.chuwa.learn.Java8.Defult_interface;

public interface DIML {
    static final String str = "Test";

    int add(int a, int b);

    default int substract(int a, int b) {
        return a - b;
    }

    static String blogName() {
        return str;
    }
}