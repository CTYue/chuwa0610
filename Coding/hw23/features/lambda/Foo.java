package com.chuwa.learn.features.lambda;

@FunctionalInterface
public interface Foo {
    String aMethod(String string);

    default String defaultBar() {
        String s = "default method";
        System.out.println(s);
        return s;
    }

    default String defaultCommon() {
        String s = "defalut common from bar";
        System.out.println(s);
        return s;
    }

}
