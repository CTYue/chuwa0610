package com.chuwa.exercise.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set = new HashSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * get()  // Note: HashSet does not have a get() method.
     * contains()
     *
     * remove(Object o)
     * clear()
     *
     * isEmpty()
     */
    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set = new HashSet<>();

        // Adding elements
        set.add(1);
        set.add(2);
        set.add(3);

        // Attempt to add a duplicate element
        boolean added = set.add(2); // Should return false since 2 is already in the set

        // Adding multiple elements
        set.addAll(Arrays.asList(4, 5, 6));

        // Check presence of elements
        Assert.assertTrue(set.contains(1));
        Assert.assertFalse(set.contains(10)); // Check element not present
        Assert.assertFalse(added); // Check the result of adding a duplicate

        // Remove elements
        set.remove(1);
        Assert.assertFalse(set.contains(1)); // 1 should no longer be in the set

        // Check if set is empty
        Assert.assertFalse(set.isEmpty());

        // Clear the set
        set.clear();
        Assert.assertTrue(set.isEmpty()); // The set should be empty after clear
    }
}
