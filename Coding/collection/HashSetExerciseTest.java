package com.chuwa.exercise.collection;

import org.junit.Test;

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
        // Step 1: Create a HashSet instance
        Set<Integer> set = new HashSet<>();

        // Step 2: Add elements to the set
        for (int i = 0; i < 10; i++) {
            set.add(i); // Adds elements 0 to 9
        }

        System.out.println(set);

        //Add all elements from another collection
        Set<Integer> anotherSet = new HashSet<>();
        anotherSet.add(10);
        anotherSet.add(11);
        set.addAll(anotherSet); // Adds elements 10 and 11

        System.out.println(set);

        //Check if the set contains specific elements
        boolean contains5 = set.contains(5); // Checks if the set contains 5
        boolean contains15 = set.contains(15); // Checks if the set contains 15
        System.out.println(contains5);
        System.out.println(contains15);

        //Clear the set
        //set.clear(); // Removes all elements from the set

        // Check if the set is empty
        boolean isEmpty = set.isEmpty(); // Checks if the set is empty
        System.out.println(isEmpty);

    }
}
