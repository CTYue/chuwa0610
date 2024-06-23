package com.chuwa.learn.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("After add(E e): " + list);

        ((LinkedList<Integer>) list).addLast(4);
        System.out.println("After addLast(E e): " + list);

        ((LinkedList<Integer>) list).addFirst(0);
        System.out.println("After addFirst(E e): " + list);

        list.add(2, 10); // Adds 10 at index 2
        System.out.println("After add(int index, E element): " + list);

        List<Integer> additionalElements = List.of(20, 30, 40);
        list.addAll(additionalElements);
        System.out.println("After addAll(Collection c): " + list);

        List<Integer> moreElements = List.of(50, 60);
        list.addAll(3, moreElements); // Adds 50 and 60 starting at index 3
        System.out.println("After addAll(int index, Collection c): " + list);


        Integer firstElement = ((LinkedList<Integer>) list).getFirst();
        System.out.println("getFirst(): " + firstElement);

        Integer lastElement = ((LinkedList<Integer>) list).getLast();
        System.out.println("getLast(): " + lastElement);

        Integer elementAtIndex2 = list.get(2);
        System.out.println("get(int index): " + elementAtIndex2);
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
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1,2,3,4,5,2,1,2,1));
        System.out.println("Original list: " + list);

        list.removeFirst();
        System.out.println("After removeFirst(): " + list);

        list.removeLast();
        System.out.println("After removeLast(): " + list);

        list.remove(2);
        System.out.println("After remove(int index=2): " + list);

        list.remove((Object) 2);
        System.out.println("After remove(Object o=2): " + list);

        list.removeLastOccurrence(2);
        System.out.println("After removeLastOccurrence(Object o): " + list);

        Collections.sort(list);
        System.out.println("After sort(): " + list);
    }
}
