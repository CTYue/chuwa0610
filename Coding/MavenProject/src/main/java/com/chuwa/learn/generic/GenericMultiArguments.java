package com.chuwa.learn.generic;

public class GenericMultiArguments {
    public static <T1, T2, T3> void temp(T1 t1, T2 t2, T3 t3){
        System.out.println("class: " + t1.getClass() + " value: " + t1);
        System.out.println("class: " + t2.getClass() + " value: " + t2);
        System.out.println("class: " + t3.getClass() + " value: " + t3);
    }
    public static void main(String[] args) {
        temp(1, "2", 3L);
    }
}
