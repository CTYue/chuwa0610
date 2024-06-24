package com.chuwa.learn.lambda;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class LambdaLearn {
    @Test
    public void overrideFoo(){
        /*
        * 匿名内部类
        *
        * */
        Foo fooByIC = new Foo(){
            @Override
            public String aMethod(String string){
                return string + " from Foo";
            }
        };
        String hello = fooByIC.aMethod("Hello");
        System.out.println(hello);

    }

    @Test
    public void lambdaFoo(){
        /*
        * lambda 表达式
        * 使用lambda 表达式的前提是Foo 必须是一个functional interface
        *
        * */
        Foo foo = param -> param + " testing";
        String hello = foo.aMethod("hello");
        System.out.println(hello);
    }

    @Test
    public void lambdaFoo2(){
        Foo foo  = param -> param.toUpperCase() + " from Foo";
        String hello = foo.aMethod("Hello");
        System.out.println(hello);
    }

    @Test
    public void testFinal(){
//        String localVariable = "Local";
//        localVariable = "hello";
        HashMap<Integer, String> map= new HashMap<>();
        // 内存地址不变
        map.put(1," local variable");
        map.put(1, "local changed");
        Foo foo = param -> {
           return param + " "+ map.get(1);
        };

        System.out.println(foo.aMethod("Hello"));
    }
}
