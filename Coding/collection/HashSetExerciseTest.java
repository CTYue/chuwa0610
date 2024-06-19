package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        set.add(1);
        set.add(5);
        set.addAll(List.of(3, 2, 8, 9));
        System.out.println(set);
        System.out.println(set.contains(5));
        System.out.println(set.contains(10));
        set.remove(9);
        System.out.println(set);
        set.clear();
        System.out.println(set.isEmpty());
    }
}
