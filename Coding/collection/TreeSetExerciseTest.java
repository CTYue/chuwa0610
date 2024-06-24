package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.List;
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
        TreeSet<Integer> tSet = new TreeSet<>();
        tSet.add(5);
        tSet.add(2);
        tSet.addAll(List.of(8, 10, 3, 1, 9));
        System.out.println(tSet);
        System.out.println(tSet.contains(10));
        System.out.println(tSet.contains(20));
        System.out.println(tSet.first());
        System.out.println(tSet.last());
        System.out.println(tSet.subSet(2, 9));
        System.out.println(tSet.headSet(3));
        System.out.println(tSet.tailSet(8));
        tSet.remove(5);
        System.out.println(tSet);
        System.out.println(tSet.size());
        System.out.println(tSet.isEmpty());
    }
}
