package com.chuwa.learn.Generic;

public class NoGeneric {
    public static void main(String[] args) {
        System.out.println(MaximumTest.maximum(1,2));
        System.out.println(MaximumTest.maximum(1.0,2.0));
        System.out.println(MaximumTest.maximum("hello","world"));
    }

}
class MaximumTest {
    public static int maximum(int a, int b) {
        return Math.max(a, b);
    }
    public static double maximum(double a, double b) {
        return Math.max(a, b);
    }
    public static String maximum(String a, String b) {
        return a.compareTo(b) > 0 ? a : b;
    }

}
