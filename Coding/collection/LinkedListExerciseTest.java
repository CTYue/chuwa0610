package com.chuwa.exercise.collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

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
        LinkedList<Integer> linkList = new LinkedList<>();
        linkList.add(1);
        linkList.add(2);
        linkList.add(3);
        linkList.addFirst(0);
        linkList.addLast(4);
        linkList.add(1, 10000);
        System.out.println(linkList.getFirst());
        System.out.println(linkList.getLast());
        Collections.sort(linkList);
        System.out.println(linkList);
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
        List<Integer> linkedlist = new LinkedList<>();
        linkedlist.add(5);
        linkedlist.add(1);
        linkedlist.add(3);
        linkedlist.remove(2);
        System.out.println(linkedlist);
        Collections.sort(linkedlist);
        System.out.println(linkedlist);
    }
}
