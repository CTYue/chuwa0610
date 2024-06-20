package com.chuwa.exercise.collection;

import com.sun.javafx.image.IntPixelGetter;
import org.junit.Assert;
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
        Assert.assertEquals(numbers[1], 2);
        numbers[1] = 999;
        Assert.assertEquals(numbers[1], 999);
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
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int index = Arrays.binarySearch(numbers, 4);
        Assert.assertEquals(index, 3);

        int[] numbers2 = {10, 9, 8, 7};
        Arrays.sort(numbers2);
        Assert.assertEquals(numbers2[0], 7);

        int[] numbers3 = {10, 9 , 8, 7};
        Arrays.parallelSort(numbers3);
        Assert.assertArrayEquals(numbers2, numbers3);

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
        int[] numbers = {10, 9, 8, 7};
        int[] numbers2 = Arrays.copyOf(numbers, numbers.length);
        Assert.assertArrayEquals(numbers2, numbers);

        int[] number3 = Arrays.copyOfRange(numbers, 0, 2);
        Assert.assertArrayEquals(number3, new int[]{10, 9});
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
        Integer[] numbers = {10, 9, 8, 7};
        List<Integer> list = Arrays.asList(numbers);
        Assert.assertEquals(list.get(1), new Integer(9));

        Arrays.fill(numbers, 999);
        Assert.assertEquals(numbers[2], new Integer(999));
    }
}
