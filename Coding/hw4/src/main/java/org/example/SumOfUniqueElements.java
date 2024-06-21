package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumOfUniqueElements {
    public static int sumOfUnique(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(num -> map.compute(num, (key, val) -> val == null ? 1 : val+1));
        return map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .mapToInt(Map.Entry::getKey)
                .sum();
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{1, 2, 3, 2};
        int[] test2 = new int[]{1, 1, 1, 1};
        int[] test3 = new int[]{1, 2, 3, 4, 5};

        System.out.println(sumOfUnique(test1));
        System.out.println(sumOfUnique(test2));
        System.out.println(sumOfUnique(test3));
    }
}
