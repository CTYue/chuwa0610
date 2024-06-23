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
     * Set<Integer> set = new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<? extends E> c)
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
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        TreeSet<Integer> set = new TreeSet<>();

        // Inserting elements
        set.add(3);
        set.add(1);
        set.add(4);
        set.add(1); // Duplicate element, won't be added
        set.add(5);
        set.add(9);
        System.out.println("After add: " + set);

        // Adding a collection of elements
        Set<Integer> anotherSet = new TreeSet<>();
        anotherSet.add(2);
        anotherSet.add(6);
        anotherSet.add(5); // Duplicate element, won't be added
        set.addAll(anotherSet);
        System.out.println("After addAll: " + set);

        // Checking for the existence of elements
        System.out.println("Contains 3: " + set.contains(3));
        System.out.println("Contains 10: " + set.contains(10));

        // Retrieving first and last elements
        System.out.println("First element: " + set.first());
        System.out.println("Last element: " + set.last());

        // Getting subsets
        System.out.println("SubSet from 2 to 6: " + set.subSet(2, 6));
        System.out.println("HeadSet to 4: " + set.headSet(4));
        System.out.println("TailSet from 4: " + set.tailSet(4));

        // Removing elements
        set.remove(1);
        System.out.println("After remove 1: " + set);

        // Checking size and if empty
        System.out.println("Size: " + set.size());
        System.out.println("Is set empty? " + set.isEmpty());
    }
}
