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
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Assert.assertEquals(1,arr[0]);
        Assert.assertEquals(2,arr[1]);
        arr[3] = 0;
        Assert.assertEquals(0,arr[3]);
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
        int[] arr = {5, 2, 4, 1, 3};

        // Sort the entire array
        Arrays.sort(arr);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
        int index = Arrays.binarySearch(arr, 4);
        Assert.assertEquals(3, index);


        int[] subArray = {10, 3, 2, 1};
        Arrays.sort(subArray, 1, 4);
        Assert.assertArrayEquals(new int[]{10, 1, 2, 3}, subArray);

        int[] parallelSortArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Arrays.parallelSort(parallelSortArray);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, parallelSortArray);
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
        int[] arr = {1,2,3,4};
        int[] arr_2 = Arrays.copyOf(arr,4);
        Assert.assertEquals(arr.length,arr_2.length);
        int[] arr_3 = Arrays.copyOfRange(arr,0,3);
        Assert.assertArrayEquals(new int[]{1,2,3},arr_3);
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
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5), list);

        int[] arr_1 = {1, 2, 3, 4, 5};
        int[] arr_2 = {1, 2, 3, 4, 5};
        int[] arr_3 = {5, 4, 3, 2, 1};
        Assert.assertTrue(Arrays.equals(arr_1, arr_2));
        Assert.assertFalse(Arrays.equals(arr_1, arr_3));


        int[] arr = new int[5];
        Arrays.fill(arr, 20);
        Assert.assertArrayEquals(new int[]{20, 20, 20, 20, 20}, arr);
    }
}
