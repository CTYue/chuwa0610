package com.chuwa.learn.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class CollectionsExerciseTest {

    /**
     * Collections.min(list))
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    @Test
    public void learn_common_collections_operations() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5,3,8,4,2,7,1,6));

        // Finding the minimum element in the list
        int min = Collections.min(numbers);
        System.out.println("Minimum value in the list: " + min);

        // Finding the maximum element in the list
        int max = Collections.max(numbers);
        System.out.println("Maximum value in the list: " + max);

        // Creating a custom comparator for finding the min and max elements
        Comparator<Integer> comparator = (a, b) -> b - a; // Reverse order

        // Finding the minimum element in the list using a custom comparator
        int minWithComparator = Collections.min(numbers, comparator);
        System.out.println("Minimum value in the list (with comparator): " + minWithComparator);

        // Finding the maximum element in the list using a custom comparator
        int maxWithComparator = Collections.max(numbers, comparator);
        System.out.println("Maximum value in the list (with comparator): " + maxWithComparator);

        // Finding the frequency of an element in the list
        int frequencyOf4 = Collections.frequency(numbers, 4);
        System.out.println("Frequency of 4 in the list: " + frequencyOf4);

        // Finding the frequency of an element in a list with duplicate values
        numbers.add(4);
        int frequencyOf4AfterAdding = Collections.frequency(numbers, 4);
        System.out.println("Frequency of 4 in the list after adding another 4: " + frequencyOf4AfterAdding);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> syncList = Collections.synchronizedList(new ArrayList<>(Arrays.asList(1,2,3)));
        System.out.println("Initial synchronized list: " + syncList);

        // Using multiple threads to add elements to the synchronized list
        Thread thread1 = new Thread(() -> {
            for (int i = 4; i <= 6; i++) {
                syncList.add(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 7; i <= 9; i++) {
                syncList.add(i);
            }
        });

        thread1.start();
        thread2.start();

        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Printing the final synchronized list
        System.out.println("Final synchronized list: " + syncList);
    }
}
