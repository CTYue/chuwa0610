package com.chuwa.learn.lambda;

/**
 * 使用lambda 表达式之前先定义函数式接口
 * functionalInterface 注解 表示一个interface 被用作functional interface
 * Functional Interface 只包含一个方法，但是可以包含若干个default 或者 static 方法
 *
 */
@FunctionalInterface
public interface Foo {
    String aMethod(String string);

    default String defaultBar(){
        String s = "default Bar method";
        System.out.println(s);
        return s;
    }

    default String defaultCommon(){
        String s = "defaultCommon from Bar";
        System.out.println(s);
        return s;
    }
}
