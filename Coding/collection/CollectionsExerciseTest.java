package com.chuwa.exercise.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        List<Integer> numbers = Arrays.asList(5, 3, 8, 2, 9, 1, 7);

        // Test min and max without a comparator
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);
        Assert.assertEquals(1, min);
        Assert.assertEquals(9, max);

        // Test min and max with a comparator
        Comparator<Integer> comparator = Comparator.reverseOrder();
        min = Collections.min(numbers, comparator);
        max = Collections.max(numbers, comparator);
        Assert.assertEquals(9, min); // Reverse order makes 9 the min
        Assert.assertEquals(1, max); // Reverse order makes 1 the max

        // Test frequency
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        int frequency = Collections.frequency(items, "apple");
        Assert.assertEquals(3, frequency);
    }

    /**
     * synchronizedList()
     */
    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        // Make the list thread-safe
        List<Integer> syncList = Collections.synchronizedList(list);

        // Since it's hard to test thread safety without actual concurrent modifications,
        // we'll just verify the content remains accessible and correct.
        syncList.add(3);
        Assert.assertEquals(3, syncList.size());
        Assert.assertTrue(syncList.contains(1));
        Assert.assertTrue(syncList.contains(2));
        Assert.assertTrue(syncList.contains(3));
    }
}
