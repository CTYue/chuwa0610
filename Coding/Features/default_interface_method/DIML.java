package com.chuwa.exercise.collection.hw4.Features.default_interface_method;

public interface DIML {
    static final String BLOG = "text";

    int add(int a, int b);

    default int substract(int a, int b) {
        return a - b;
    }

    static String blogName() {
        return BLOG;
    }
}
