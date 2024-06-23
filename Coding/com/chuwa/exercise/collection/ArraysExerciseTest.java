package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class ArraysExerciseTest {

    /**
     * e.g.
     * int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
     * numbers[?]
     * <p>
     * numbers[?] = #
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        numbers[0] = 3;
        Arrays.stream(numbers).forEach(System.out::println);
    }

    /**
     * binarySearch()
     * e.g.
     * Arrays.binarySearch(numbers, 4);
     * <p>
     * sort(array)
     * sort(array, fromIndex, toIndex)
     * e.g.
     * Arrays.sort(numbers);
     * <p>
     * Arrays.parallelSort(numbers);
     */
    @Test
    public void learn_search_and_sort() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i = Arrays.binarySearch(numbers, 4);
        assertEquals(i, 3);
        numbers = new int[]{1, 2, 4, 3, 5, 6, 7, 8, 9, 10};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        numbers = new int[]{1, 2, 4, 3, 5, 6, 7, 8, 9, 10};
        Arrays.parallelSort(numbers);
        System.out.println(Arrays.toString(numbers));

    }

    /**
     * copyOf()
     * e.g.
     * Arrays.copyOf(numbers, numbers.length);
     * <p>
     * copyOfRange()
     * e.g.
     * Arrays.copyOfRange(numbers, 0, 5);
     */
    @Test
    public void learn_copy_of_array() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] ints = Arrays.copyOf(numbers, 3);
        System.out.println(Arrays.toString(ints));
        int[] ints1 = Arrays.copyOfRange(numbers, 2, 4);
        System.out.println(Arrays.toString(ints1));

    }

    /**
     * asList()
     * e.g.
     * List<Integer> list = Arrays.asList(numbers);
     * <p>
     * equals()
     * e.g.
     * Arrays.equals(numbers1, numbers2);
     * <p>
     * fill()
     * e.g.
     * Arrays.fill(numbers, 20);
     */

    @Test
    public void learn_common_operations() {
        int[] numbers1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] numbers2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertArrayEquals(numbers1, numbers2);
        Arrays.fill(numbers2,9);
        System.out.println(Arrays.toString(numbers2));

    }
}
