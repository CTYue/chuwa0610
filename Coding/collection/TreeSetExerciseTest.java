package com.chuwa.exercise.collection;

import org.junit.Assert;
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
        TreeSet<Integer> set = new TreeSet<>();

        set.add(10);
        set.add(20);
        set.add(15);

        set.addAll(Arrays.asList(25, 5, 30));

        Assert.assertTrue(set.contains(10));
        Assert.assertTrue(set.contains(5));
        Assert.assertEquals(6, set.size());

        Assert.assertEquals(Integer.valueOf(5), set.first());
        Assert.assertEquals(Integer.valueOf(30), set.last());

        Assert.assertEquals(new TreeSet<>(Arrays.asList(10, 15, 20)), set.subSet(10, 25));
        Assert.assertEquals(new TreeSet<>(Arrays.asList(5, 10)), set.headSet(15));
        Assert.assertEquals(new TreeSet<>(Arrays.asList(15, 20, 25, 30)), set.tailSet(15));

        set.remove(20);
        Assert.assertFalse(set.contains(20));
        Assert.assertEquals(5, set.size());

        Assert.assertFalse(set.isEmpty());
    }
}
