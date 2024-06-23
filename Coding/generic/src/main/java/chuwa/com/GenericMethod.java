package chuwa.com;

/**
 * @author Jun Jiang
 * @date 6/21/24 12:03 AM
 */
public class GenericMethod {
    public static void main(String[] args) {
        System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5,
                MaximumGenericTest.maximum(3, 4, 5));
        System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7,
                MinimumGenericTest.minimum(6.6, 8.8, 7.7));
        System.out.printf("Max of %s, %s and %s is %s\n", "pear", "apple", "orange",
                MaximumGenericTest.maximum("pear", "apple", "orange"));
    }
}


class MaximumGenericTest {
    /**
     * determines the largest of three Comparable objects
     */
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
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

class MinimumGenericTest {
    public static <T extends Comparable<T>> T minimum(T x, T y, T z){
        T min = x;

        if (y.compareTo(min) < 0) {
            min = y;
        }

        if (z.compareTo(min) < 0){
            min = z;
        }

        return min;
    }
}