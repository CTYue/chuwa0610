package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class TreeSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * contains(Object o)
     *
     * first()
     * last()
     * subSet(E fromElement, E toElement)
     * headSet(E toElement)
     * tailSet(E fromElement)
     *
     * remove(Object o)
     *
     * size()
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        assertTrue(set.contains(1));
        set.remove(1);
        assertTrue(set.isEmpty());
        set.add(1);
        set.clear();
        assertTrue(set.isEmpty());

        set.add(1);
        set.add(3);
        set.add(9);
        set.add(4);
        System.out.println(set.first());
        System.out.println(set.last());
        System.out.println(set.subSet(3,9));

    }
}
