package com.chuwa.exercise.collection;

import org.junit.Assert;
import org.junit.Test;
import sun.awt.image.ImageWatched;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author b1go
 * @date 6/12/22 4:45 PM
 */
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
        LinkedList<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(20);
        list.addFirst(5);
        list.addLast(25);
        list.add(2, 15);
        list.addAll(Arrays.asList(30, 35));
        list.addAll(2, Arrays.asList(12, 13));

        Assert.assertEquals(Integer.valueOf(5), list.getFirst()); // getFirst()
        Assert.assertEquals(Integer.valueOf(25), list.getLast()); // getLast()
        Assert.assertEquals(Integer.valueOf(13), list.get(3)); // get(int index)

    }

    /**
     * removeFirst()
     * removeLast()
     * remove(int index)
     * remove(Object o)
     * removeLastOccurrence()
     *
     * sort()
     */

    @Test
    public void learn_Remove_Sort() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addAll(Arrays.asList(10, 20, 15, 25, 30, 35, 10, 5));

        list.removeFirst();
        list.removeLast();
        list.remove(2);
        list.remove((Integer) 30);
        list.removeLastOccurrence(10);

        Collections.sort(list);

        Assert.assertEquals(Arrays.asList(15, 20, 35), list);
    }
}
