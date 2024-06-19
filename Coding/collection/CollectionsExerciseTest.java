package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


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
        // Step 1: Create a list
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 5, 3, 8, 1, 9, 2, 5, 3);

        // Step 2: Find the minimum value in the list
        int minValue = Collections.min(list);
        System.out.println("Minimum value: " + minValue);

        // Step 3: Find the maximum value in the list
        int maxValue = Collections.max(list);
        System.out.println("Maximum value: " + maxValue);

        // Step 4: Find the frequency of a specific value in the list
        int frequency = Collections.frequency(list, 3);
        System.out.println("Frequency of 3: " + frequency);

        // Step 5: Find the minimum value using a custom comparator (natural order in this case)
        minValue = Collections.min(list, Comparator.naturalOrder());
        System.out.println("Minimum value with comparator: " + minValue);

        // Step 6: Find the maximum value using a custom comparator (natural order in this case)
        maxValue = Collections.max(list, Comparator.naturalOrder());
        System.out.println("Maximum value with comparator: " + maxValue);




    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        // Step 1: Create a normal ArrayList
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5);

        // Step 2: Make the ArrayList thread-safe
        List<Integer> synchronizedList = Collections.synchronizedList(list);

        // Step 3: Access the synchronized list (synchronized block needed for iteration)
        synchronized (synchronizedList) {
            for (Integer number : synchronizedList) {
                System.out.println("Synchronized list element: " + number);
            }
        }
        /*Thread-Safe ArrayList:
            Collections.synchronizedList(list): Creates a thread-safe version of the given list.
            Access to the synchronized list is demonstrated within a synchronized block to ensure thread safety during iteration.
        */
    }
}
