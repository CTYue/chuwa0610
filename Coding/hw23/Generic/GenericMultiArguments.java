package com.chuwa.learn.Generic;

public class GenericMultiArguments {
    public static <T1, T2, T3> void tmp (T1 t1, T2 t2, T3 t3) {
        System.out.println(t1 + " " +t2 +" " + t3);
    }
    public static void main(String[] args) {
        tmp(1,2,3);
        tmp(1,"string",3.0);
        tmp(1,2,3);
        tmp(1,"string",3.0);

    }

    public static <T> void tmp1 (T t1, T t2, T t3) {
        System.out.println(t1 + " " +t2 +" " + t3);
    }
}
