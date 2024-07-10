package com.chuwa.learn.Generic;

public class GenericMethod {
    public static void main(String[] args) {
        System.out.println(MaximumGenericTest.maximum(3,4,5));
        System.out.println(MaximumGenericTest.maximum(6.6,8.8,7.7));
        System.out.println(MaximumGenericTest.maximum("apple", "pear", "orange"));
    }
}
class MaximumGenericTest {
    public static  <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }
}

