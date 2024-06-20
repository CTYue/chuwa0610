package com.chuwa.learn.collection;

import org.junit.Test;

import java.util.Arrays;

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
        System.out.println(numbers[5]);
        numbers[5] = 10;
        System.out.println(Arrays.toString(numbers));
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
        int[] numbers = {5, 3, 8, 4, 2, 7, 1, 6};

        Arrays.sort(numbers);
        System.out.println("After sort: " + Arrays.toString(numbers));

        int index = Arrays.binarySearch(numbers, 4);
        System.out.println("Index of 4 using binarySearch: " + index);

        int[] moreNumbers = {12, 11, 15, 10, 14, 13, 16};

        Arrays.sort(moreNumbers, 1, 5);
        System.out.println("After partial sort: " + Arrays.toString(moreNumbers));

        int[] parallelNumbers = {20, 18, 22, 19, 17, 21, 23};

        Arrays.parallelSort(parallelNumbers);
        System.out.println("After parallelSort: " + Arrays.toString(parallelNumbers));
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
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] copyNumbers = Arrays.copyOf(numbers, numbers.length);
        System.out.println(Arrays.toString(copyNumbers));
        int[] copyNumbers2 = Arrays.copyOfRange(numbers, 0, 5);
        System.out.println(Arrays.toString(copyNumbers2));
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
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(Arrays.toString(numbers));
        int[] numbers2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(Arrays.toString(numbers2));
        System.out.println(Arrays.equals(numbers, numbers2));
        Arrays.fill(numbers, 20);
        System.out.println(Arrays.toString(numbers));
    }
}
