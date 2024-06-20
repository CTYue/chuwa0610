package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class HashSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new HashSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * get()
     * contains()
     *
     * remove(Object o)
     * clear()
     *
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set = new HashSet<>();

        assertTrue("Should return true when adding a new element", set.add(10));
        assertFalse("Should return false when adding a duplicate element", set.add(10));

        set.addAll(Arrays.asList(20, 30, 40));
        assertTrue("Set should contain 20, 30, 40", set.containsAll(Arrays.asList(20, 30, 40)));

        assertTrue("Set should contain 10", set.contains(10));
        assertFalse("Set should not contain 50", set.contains(50));

        assertTrue("Should return true when removing an existing element", set.remove(10));
        assertFalse("Set should no longer contain 10", set.contains(10));
        assertFalse("Should return false when trying to remove an element not present in set", set.remove(50));

        set.clear();
        assertTrue("Set should be empty after clear", set.isEmpty());

        set.addAll(Arrays.asList(100, 200, 300));
        assertFalse("Set should not be empty after adding elements", set.isEmpty());
        set.removeAll(Arrays.asList(100, 200, 300));
        assertTrue("Set should be empty after removing all elements", set.isEmpty());
    }
}
