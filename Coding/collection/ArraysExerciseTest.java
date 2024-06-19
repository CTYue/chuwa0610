package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class ArraysExerciseTest {

    /**
     * e.g.
     * int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
     * numbers[?]
     *
     * numbers[?] = #
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        numbers[4] = 10;
        System.out.println(numbers[4]);
    }

    /**
     * binarySearch()
     * e.g.
     * Arrays.binarySearch(numbers, 4);
     *
     * sort(array)
     * sort(array, fromIndex, toIndex)
     * e.g.
     * Arrays.sort(numbers);
     *
     * Arrays.parallelSort(numbers);
     */
    @Test
    public void learn_search_and_sort() {
        int[] numbers = new int[]{ 1, 2, 4, 8, 10, 10, 14, 16, 30, 72};
        System.out.println(Arrays.binarySearch(numbers, 4));
        numbers = new int[]{ 10, 2, 30, 14, 16, 4, 72, 8, 1, 10 };
        Arrays.sort(numbers);
        for(int num : numbers){
            System.out.print(num + " ");
        }
        numbers = new int[]{ 10, 2, 30, 14, 16, 4, 72, 8, 1, 10 };
        Arrays.sort(numbers, 3, 8);
        for(int num : numbers){
            System.out.print(num + " ");
        }
        System.out.println();
        numbers = new int[]{ 10, 2, 30, 14, 16, 4, 72, 8, 1, 10 };
        Arrays.parallelSort(numbers);
        for(int num : numbers){
            System.out.print(num + " ");
        }
    }

    /**
     * copyOf()
     * e.g.
     * Arrays.copyOf(numbers, numbers.length);
     *
     * copyOfRange()
     * e.g.
     * Arrays.copyOfRange(numbers, 0, 5);
     */
    @Test
    public void learn_copy_of_array() {
        int[] numbers = new int[]{ 1, 2, 4, 8, 10, 10, 14, 16, 30, 72};
        int[] arr = Arrays.copyOf(numbers, numbers.length);
        for(int num : arr){
            System.out.print(num + " ");
        }
        int[] arr2 = Arrays.copyOfRange(numbers, 3, 9);
        System.out.println();
        for(int num : arr2){
            System.out.print(num + " ");
        }
    }

    /**
     * asList()
     * e.g.
     * List<Integer> list = Arrays.asList(numbers);
     *
     * equals()
     * e.g.
     * Arrays.equals(numbers1, numbers2);
     *
     * fill()
     * e.g.
     * Arrays.fill(numbers, 20);
     *
     */

    @Test
    public void learn_common_operations() {
        String[] strs = new String[]{ "Hello", "Hi", "world"};
        List<String> list = Arrays.asList(strs);
        System.out.println(list);

        String[] strs2 = new String[]{ "Hello", "Hi", "world"};
        System.out.println(Arrays.equals(strs, strs2));

        int[] arr = new int[3];
        Arrays.fill(arr, 20);
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}
