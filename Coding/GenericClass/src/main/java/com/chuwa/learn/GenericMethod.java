package com.chuwa.learn;

public class GenericMethod {
    int res1 = MaximumGenericTest.maximum(3,4,5);
    double res2 = MaximumGenericTest.maximum(1.1,1.2,1.3);
    String res3 = MaximumGenericTest.maximum("apple","banana","orange");
}

class MaximumGenericTest {
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if(y.compareTo(max) > 0) {
            max = y;
        }
        if(z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }
}
