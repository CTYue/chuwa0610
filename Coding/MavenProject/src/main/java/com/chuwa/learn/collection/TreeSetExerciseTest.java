package com.chuwa.learn.collection;

import org.junit.Test;

import java.util.Arrays;
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
        TreeSet<Integer> set= new TreeSet<>(Arrays.asList(6,2,1,3,4,2,5));
        System.out.println(set);
        set.add(3);
        System.out.println("TreeSet after adding 3: " + set);
        System.out.println("TreeSet.first(): " + set.first());
        System.out.println("TreeSet.last(): " + set.last());
        System.out.println("TreeSet.headSet(4): " + set.headSet(4));
        System.out.println("TreeSet.tailSet(4): " + set.tailSet(4));
        System.out.println("TreeSet.ceiling(4): " + set.ceiling(4));
        System.out.println("TreeSet.floor(2): " + set.floor(2));
        set.remove(2);
        System.out.println("set after removing 2: " + set);
        System.out.println("Set size: " + set.size());
        set.clear();
        System.out.println("Set size after clearing: " + set.size());
    }
}
