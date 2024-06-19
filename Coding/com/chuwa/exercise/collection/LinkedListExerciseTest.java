package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
     * <p>
     * Retrieving:
     * getFirst()
     * getLast()
     * get(int index)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.sort(Integer::compareTo);
        linkedList.forEach(System.out::println);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

    }

    /**
     * removeFirst()
     * removeLast()
     * remove(int index)
     * remove(Object o)
     * removeLastOccurrence()
     * <p>
     * sort()
     */

    @Test
    public void learn_Remove_Sort() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.removeLast();
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.add(3);
        System.out.println(linkedList);
        linkedList.removeFirstOccurrence(3);
        System.out.println(linkedList);
    }
}
