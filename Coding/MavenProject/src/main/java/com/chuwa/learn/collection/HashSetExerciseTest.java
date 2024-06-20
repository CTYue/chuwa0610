package com.chuwa.learn.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
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
        Set<String> set = new HashSet<>(Arrays.asList("a", "b", "c", "d", "e"));
        System.out.println("Original Set: " + set);
        set.add("f");
        if (set.contains("a")) System.out.println("Set contains 'a'");
        set.remove("b");
        System.out.println("Set after removing \"b\": " + set);
        set.clear();
        if (set.isEmpty())  System.out.println("Set after clear: " + set);
    }
}
