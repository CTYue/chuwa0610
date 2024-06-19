package com.chuwa.exercise.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class LinkedListExerciseTest {

    /**
     * e.g.
     * List<Integer> list = new LinkedList<Integer>();
     * Inserting:
     * add(E e) or addLast(E e)
     * addFirst(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addAll(int index, Collection c)
     *
     * Retrieving:
     * getFirst()
     * getLast()
     * get(int index)
     *
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<Integer> list = new LinkedList<>();
        // Adding elements
        list.add(10); // implicitly addLast
        list.addFirst(5);
        list.add(20); // addLast
        list.add(1, 15); // Insert at index

        List<Integer> moreNumbers = Arrays.asList(25, 30);
        list.addAll(moreNumbers); // Add collection to the end
        list.addAll(3, Arrays.asList(17, 19)); // Insert collection at index

        // Retrieving elements
        Assert.assertEquals(Integer.valueOf(5), list.getFirst());
        Assert.assertEquals(Integer.valueOf(30), list.getLast());
        Assert.assertEquals(Integer.valueOf(15), list.get(1));
        Assert.assertEquals(Integer.valueOf(19), list.get(4));
    }

    /**
     * removeFirst()
     * removeLast()
     * remove(int index)
     * remove(Object o)
     * removeLastOccurrence(Object o)
     *
     * sort()
     */
    @Test
    public void learn_Remove_Sort() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50, 20));
        // Removing elements
        list.removeFirst(); // removes 10
        list.removeLast(); // removes 50
        list.remove(new Integer(20)); // removes first occurrence of 20
        list.removeLastOccurrence(20); // removes the last occurrence of 20
        list.remove(1); // removes element at index 1 (40)

        // At this point, list should only contain 30
        Assert.assertTrue(list.contains(30));
        Assert.assertEquals(1, list.size());

        // Sorting
        list.addFirst(50);
        list.addFirst(40);
        list.addFirst(60);
        Collections.sort(list);

        Assert.assertEquals(Arrays.asList(30, 40, 50, 60), list);
    }
}