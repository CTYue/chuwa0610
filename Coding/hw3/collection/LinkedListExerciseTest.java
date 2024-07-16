package com.chuwa.exercise.collection;

import org.junit.Test;

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
        LinkedList<String> list = new LinkedList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");
        System.out.println("Initial list: " + list);

        list.addFirst("First Element");
        System.out.println("After addFirst: " + list);
        list.addLast("Last Element");
        System.out.println("After addLast: " + list);
        String firstElement = list.getFirst();
        System.out.println("First element: " + firstElement);

        String lastElement = list.getLast();
        System.out.println("Last element: " + lastElement);

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

        LinkedList<String> list = new LinkedList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");
        list.removeFirst();
        list.removeLast();
        list.sort();
    }
}