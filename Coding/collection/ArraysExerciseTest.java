package com.chuwa.exercise.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // Retrieve the 5th element (index starts from 0)
        Assert.assertEquals(5, numbers[4]);

        // Change the 5th element to 20
        numbers[4] = 20;
        Assert.assertEquals(20, numbers[4]);
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
        int[] numbers = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Arrays.sort(numbers);
        Assert.assertEquals(1, numbers[0]);

        int index = Arrays.binarySearch(numbers, 4);
        Assert.assertEquals(3, index); // index of number 4 after sorting

        Arrays.parallelSort(numbers); // Utilizing parallel sort
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, numbers);
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
        int[] original = {1, 2, 3, 4, 5};
        int[] copy = Arrays.copyOf(original, original.length);
        Assert.assertArrayEquals(original, copy);

        int[] rangeCopy = Arrays.copyOfRange(original, 0, 3);
        Assert.assertArrayEquals(new int[]{1, 2, 3}, rangeCopy);
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
        Integer[] numbers = {1, 2, 3, 4, 5};
        List<Integer> list = Arrays.asList(numbers);
        Assert.assertTrue(list.contains(3));

        Integer[] numbers1 = {1, 2, 3};
        Integer[] numbers2 = {1, 2, 3};
        Assert.assertTrue(Arrays.equals(numbers1, numbers2));

        Arrays.fill(numbers, 20);
        Assert.assertTrue(Arrays.equals(new Integer[]{20, 20, 20, 20, 20}, numbers));
    }
}