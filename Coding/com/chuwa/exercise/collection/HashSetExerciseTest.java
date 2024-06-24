package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
        Set<Integer> set= new HashSet<>();
        set.add(1);
        assertTrue(set.contains(1));
        set.remove(1);
        assertTrue(set.isEmpty());
        set.add(1);
        set.clear();
        assertTrue(set.isEmpty());

    }
}