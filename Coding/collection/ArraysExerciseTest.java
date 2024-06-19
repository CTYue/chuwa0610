package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Arrays Exercise Test
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
        // Step 1: Create an array
        int[] numbers = {1, 2, 3, 4, 5};

        // Step 2: Retrieve elements from the array
        int firstElement = numbers[0]; // Gets the first element (1)
        int thirdElement = numbers[2]; // Gets the third element (3)

        // Step 3: Update elements in the array
        numbers[1] = 20; // Updates the second element to 20
        numbers[4] = 50; // Updates the fifth element to 50

        // Print the array to verify
        System.out.println("Array after inserting and retrieving: " + Arrays.toString(numbers));
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
        // Step 1: Create an array
        int[] numbers = {5, 2, 8, 3, 1};

        // Step 2: Sort the array
        Arrays.sort(numbers); // Sorts the array in natural order
        System.out.println("Array after sorting: " + Arrays.toString(numbers));

        // Step 3: Perform binary search
        int index = Arrays.binarySearch(numbers, 3); // Searches for the element 3
        System.out.println("Index of element 3: " + index);

        // Step 4: Perform parallel sort
        int[] moreNumbers = {10, 6, 7, 2, 8};
        Arrays.parallelSort(moreNumbers); // Sorts the array in parallel
        System.out.println("Array after parallel sorting: " + Arrays.toString(moreNumbers));
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
        // Step 1: Create an array
        int[] numbers = {1, 2, 3, 4, 5};

        // Step 2: Copy the entire array
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Copy of the entire array: " + Arrays.toString(copy));

        // Step 3: Copy a range of the array
        int[] rangeCopy = Arrays.copyOfRange(numbers, 1, 4); // Copies elements from index 1 to 3 (exclusive 4)
        System.out.println("Copy of range of the array: " + Arrays.toString(rangeCopy));
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
     */
    @Test
    public void learn_common_operations() {
        // Step 1: Create arrays
        int[] numbers = {1, 2, 3, 4, 5};
        int[] numbers2 = {1, 2, 3, 4, 5};
        int[] numbers3 = {10, 9, 8, 7, 6};

        // Step 2: Convert array to list
        //List<int[]> list = Arrays.asList(numbers);
        //System.out.println("List created from array: " + list);

        // Correctly converting array to a list of its elements
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        System.out.println("List created from array: " + list); // Output: List created from array: [1, 2, 3, 4, 5]

        // Step 3: Check if two arrays are equal
        boolean isEqual = Arrays.equals(numbers, numbers2); // Checks if numbers and numbers2 are equal
        System.out.println("Arrays are equal: " + isEqual);

        // Step 4: Fill the array with a specific value
        Arrays.fill(numbers3, 20); // Fills numbers3 with the value 20
        System.out.println("Array after filling: " + Arrays.toString(numbers3));
    }
}
