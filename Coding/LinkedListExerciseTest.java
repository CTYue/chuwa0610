package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author b1go
 * @date 6/12/22 4:45 PM
 */
public class LinkedListExerciseTest {
    LinkedList<String> list1 = new LinkedList<>();
    LinkedList<String> list2 = new LinkedList<>();
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
        list1.add("aaa");
        list2.addFirst("bbb");
        list1.addAll(0, list2);
        System.out.println(list1.getFirst());
        System.out.println(list1.getLast());
        System.out.println(list1.get(3));
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
        list1.removeFirst();
        list1.removeLast();
        list1.remove(0);
        list1.remove("aaa");
        list1.removeLastOccurrence("aaa");
    }
}
