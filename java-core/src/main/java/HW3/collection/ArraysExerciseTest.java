package HW3.collection;

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

        // numbers[?]
        System.out.println("Element at index 0: " + numbers[0]);
        System.out.println("Element at index 4: " + numbers[4]);
        System.out.println("Element at index 9: " + numbers[9]);

        // numbers[?] = #
        numbers[0] = 11;
        numbers[4] = 22;
        numbers[9] = 33;

        System.out.print("Modified array: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
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
        int[] numbers = { 2, 4, 1, 8, 5 };

        // binarySearch
        int index = Arrays.binarySearch(numbers, 4);
        System.out.println("Index of 4: " + index);

        // sort
        Arrays.sort(numbers);
        System.out.print("Sorted array: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        //  parallelSort
        Arrays.parallelSort(numbers);
        System.out.print("Parallel sorted array: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
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
        int[] numbers = { 1, 2, 3, 4, 5 };

        // 使用 copyOf() 复制整个数组
        int[] copy1 = Arrays.copyOf(numbers, numbers.length);
        System.out.print("Copy of the whole array: ");
        for (int num : copy1) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 使用 copyOfRange() 复制部分数组
        int[] copy2 = Arrays.copyOfRange(numbers, 0, 3);
        System.out.print("Copy of range from index 0 to 2: ");
        for (int num : copy2) {
            System.out.print(num + " ");
        }
        System.out.println();
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
        // 使用 asList() 将数组转换为列表
        Integer[] numbers = { 1, 2, 3, 4, 5 };
        List<Integer> list = Arrays.asList(numbers);
        System.out.println("List from array: " + list);

        // 使用 equals() 比较两个数组是否相等
        Integer[] numbers1 = { 1, 2, 3 };
        Integer[] numbers2 = { 1, 2, 3 };
        boolean isEqual = Arrays.equals(numbers1, numbers2);
        System.out.println("Arrays are equal: " + isEqual);

        // 使用 fill() 将数组元素填充为指定值
        int[] nums = new int[5];
        Arrays.fill(nums, 10);
        System.out.println("Filled array: " + Arrays.toString(nums));
    }
}
