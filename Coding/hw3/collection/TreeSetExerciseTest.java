package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

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


        set.add(5);
        set.add(2);
        set.add(9);
        set.add(1);


        Set<Integer> otherSet = new TreeSet<>();
        otherSet.add(3);
        otherSet.add(7);
        set.addAll(otherSet);

        set.contains(2);
        set.first();
        set.last();
        set.subSet(2,7);
        set.headSet(5);
        set.tailSet(5);

        set.remove(5);
        set.size();
        set.isEmpty();
    }
}
