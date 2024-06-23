package com.chuwa.exercise.collection;

import org.junit.Test;

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

        assertEquals("Should retrieve the first element, which is 1", 1, numbers[0]);
        assertEquals("Should retrieve the fifth element, which is 5", 5, numbers[4]);

        numbers[0] = 100;  // Changing the first element from 1 to 100
        assertEquals("First element should be updated to 100", 100, numbers[0]);

        numbers[9] = 200;  // Changing the last element from 10 to 200
        assertEquals("Last element should be updated to 200", 200, numbers[9]);

        assertEquals("Element at index 3 should still be 4", 4, numbers[3]);
        numbers[3] = 400;  // Updating the fourth element
        assertEquals("Element at index 3 should be updated to 400", 400, numbers[3]);
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
        int[] numbers = { 5, 3, 8, 1, 4 };

        Arrays.sort(numbers);
        assertArrayEquals("Array should be sorted in ascending order", new int[]{1, 3, 4, 5, 8}, numbers);

        int index = Arrays.binarySearch(numbers, 4);
        assertEquals("Index of element '4' should be 2", 2, index);

        int[] rangeNumbers = { 5, 3, 8, 1, 4, 7, 9, 2 };
        Arrays.sort(rangeNumbers, 1, 5); // Sorts elements from index 1 to 4 (exclusive of index 5)
        assertArrayEquals("Only part of the array should be sorted", new int[]{5, 1, 3, 4, 8, 7, 9, 2}, rangeNumbers);

        int[] largeNumbers = { 5, 9, 2, 8, 1, 4, 7, 3, 6 };
        Arrays.parallelSort(largeNumbers);
        assertArrayEquals("Array should be sorted in ascending order using parallel sort",
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, largeNumbers);
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
        int[] original = {5, 10, 15, 20, 25};


        int[] copiedFull = Arrays.copyOf(original, original.length);
        assertArrayEquals("The copied array should match the original", original, copiedFull);

        int[] copiedRange = Arrays.copyOfRange(original, 1, 4); // from index 1 to index 4 (exclusive)
        int[] expectedRange = {10, 15, 20}; // Expected result should include elements from index 1 to 3
        assertArrayEquals("The copied range should match the expected range", expectedRange, copiedRange);

        copiedFull[0] = 100;
        assertNotEquals("Modifying the copied array should not affect the original array",
                original[0], copiedFull[0]);

        assertEquals("Full copy should have the same length as original", original.length, copiedFull.length);
        assertEquals("Range copy should have the length of the range", 3, copiedRange.length);
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
        List<Integer> numberList = Arrays.asList(numbers);
        assertEquals("The list should have the same size as the original array", numbers.length, numberList.size());
        assertTrue("The list should contain all elements of the array", numberList.containsAll(Arrays.asList(1, 2, 3, 4, 5)));

        Integer[] numbers1 = {1, 2, 3, 4, 5};
        Integer[] numbers2 = {1, 2, 3, 4, 5};
        Integer[] numbers3 = {5, 4, 3, 2, 1};
        assertTrue("numbers1 should be equal to numbers2", Arrays.equals(numbers1, numbers2));
        assertFalse("numbers1 should not be equal to numbers3", Arrays.equals(numbers1, numbers3));

        Integer[] fillArray = new Integer[5];
        Arrays.fill(fillArray, 20);
        assertTrue("All elements of fillArray should be set to 20", Arrays.stream(fillArray).allMatch(e -> e.equals(20)));
        assertEquals("fillArray should have length 5", 5, fillArray.length);
    }
}
