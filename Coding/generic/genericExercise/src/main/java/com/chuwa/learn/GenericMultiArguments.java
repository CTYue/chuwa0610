package com.chuwa.learn;

public class GenericMultiArguments {
    public static <T1, T2, T3> void temp(T1 x, T2 y, T3 z){
        System.out.println("This is x = " + x);
        System.out.println("This is y = " + y);
        System.out.println("This is z = " + z);
    }
    public static <T1, T2, T3, E extends Comparable<E>> E test(T1 x1, T2 y1, T3 z1, E e1){
        System.out.println("This is x = " + x1);
        System.out.println("This is y = " + y1);
        System.out.println("This is z = " + z1);
        return e1;
    }
    public static void main(String[] args){
        temp(1, "2", 3L);
        int ret = test(1, "2", 3L, 100);
        System.out.println(ret);
    }
}
