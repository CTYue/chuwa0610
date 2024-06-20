package com.chuwa.exercise.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
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
        Set<Integer> set= new HashSet<>();
        set.add(1);
        set.add(2);
        Assert.assertEquals(2, set.size());

        Collection<Integer> collectionToAdd = new HashSet<>();
        collectionToAdd.add(3);
        collectionToAdd.add(4);
        set.addAll(collectionToAdd);
        Assert.assertEquals( 4, set.size());

        Assert.assertTrue(set.contains(1));

        Assert.assertTrue( set.contains(3));
        Assert.assertFalse(set.contains(5));

        set.remove(1);
        Assert.assertFalse(set.contains(1));

        set.clear();
        Assert.assertTrue(set.isEmpty());

    }
}
