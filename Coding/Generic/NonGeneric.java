package Coding.Generic;

public class NonGeneric {
    public static void main(String[] args) {
        System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5,
                GenericMethod.MaximumGenericTest.maximum(3, 4, 5));
        System.out.printf("Max of %.1f, %.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7,
                GenericMethod.MaximumGenericTest.maximum(6.6, 8.8, 7.7));
        System.out.printf("Max of %s, %s and %s is %s\n\n", "pear", "apple", "orange",
                GenericMethod.MaximumGenericTest.maximum("pear", "apple", "orange"));
    }

    class MaximumTest {
        public static int maximum(int x, int y, int z){
            int max = x;

            if(y > max){
                max = y;
            }

            if(z > max){
                max = z;
            }
            return max;
        }

        public static double maximum(double x, double y, double z){
            double max = x;

            if(y > max){
                max = y;
            }

            if(z > max){
                max = z;
            }
            return max;
        }

        public static String maximum(String x, String y, String z){
            String max = x;

            if(y.compareTo(max) > 0){
                max = y;
            }

            if(z.compareTo(max) > 0){
                max = z;
            }
            return max;
        }
    }
}