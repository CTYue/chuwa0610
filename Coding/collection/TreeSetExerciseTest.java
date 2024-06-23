package com.chuwa.exercise.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

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
     */
    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        NavigableSet<Integer> set = new TreeSet<>();
        // Adding individual elements
        set.add(10);
        set.add(20);
        set.add(30);

        // Adding a collection of elements
        set.addAll(Arrays.asList(40, 50, 60));

        // Element retrieval tests
        Assert.assertTrue(set.contains(30));
        Assert.assertEquals(Integer.valueOf(10), set.first());
        Assert.assertEquals(Integer.valueOf(60), set.last());

        // Subset operations
        Set<Integer> subSet = set.subSet(20, true, 50, true);
        Assert.assertEquals(3, subSet.size());  // Includes 20, 30, 40, 50
        Assert.assertTrue(subSet.contains(30) && subSet.contains(50));

        Set<Integer> headSet = set.headSet(40, false);  // Elements less than 40
        Assert.assertEquals(2, headSet.size());  // Includes 10, 20
        Assert.assertTrue(headSet.contains(20) && !headSet.contains(40));

        Set<Integer> tailSet = set.tailSet(30, true);  // Elements greater than or equal to 30
        Assert.assertEquals(4, tailSet.size());  // Includes 30, 40, 50, 60
        Assert.assertTrue(tailSet.contains(60) && tailSet.contains(30));

        // Removing elements
        set.remove(50);
        Assert.assertFalse(set.contains(50));
        Assert.assertEquals(5, set.size());

        // Check set characteristics after removal
        set.clear();
        Assert.assertTrue(set.isEmpty());
    }
}