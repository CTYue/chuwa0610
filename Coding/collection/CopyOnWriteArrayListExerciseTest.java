package com.chuwa.exercise.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add(1, "Banana");  // Adding at specific index
        list.addAll(Arrays.asList("Cherry", "Date"));

        // Add if absent
        list.addIfAbsent("Banana");  // Will not add as "Banana" is already present
        list.addIfAbsent("Elderberry");  // Will add as it's absent

        // Add all absent
        List<String> newFruits = Arrays.asList("Cherry", "Fig", "Grape");
        list.addAllAbsent(newFruits);  // Only "Fig" and "Grape" will be added

        Assert.assertEquals(7, list.size());
        Assert.assertEquals("Apple", list.get(0));
        Assert.assertEquals("Banana", list.get(1));
        Assert.assertEquals("Elderberry", list.get(4));
        Assert.assertTrue(list.contains("Fig"));
        Assert.assertTrue(list.contains("Grape"));
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */
    @Test
    public void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String fruit = itr.next();
            if (fruit.equals("Banana")) {
                itr.remove();  // This should throw an UnsupportedOperationException
            }
        }

        // Testing the iterator's immutability
        List<String> expected = Arrays.asList("Apple", "Banana", "Orange");
        Assert.assertEquals(expected, list);  // Should remain unchanged because CopyOnWriteArrayList does not support iterator.remove()
        Assert.assertThrows(UnsupportedOperationException.class, () -> {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if ("Banana".equals(it.next())) {
                    it.remove();  // Attempting to remove via iterator
                }
            }
        });
    }
}
