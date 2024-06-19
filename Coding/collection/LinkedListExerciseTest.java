package com.chuwa.exercise.collection;

import org.junit.Test;

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
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.addLast(0);
        list.addFirst(5);
        list.add(2, 3);
        System.out.println(list);
        list.addAll(List.of(9, 4, 10, 8));
        System.out.println(list);
        list.addAll(2, List.of(88, 22, 55));
        System.out.println(list);

        // Retrieving
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(4));
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
        LinkedList<Integer> list = new LinkedList<>(List.of(3, 5, 1, 6, 12, 8, 9));
        System.out.println("List: " + list);
        list.removeFirst();
        System.out.println("List after removeFirst: " + list);
        list.removeLast();
        System.out.println("List after removeLast: " + list);
        list.remove(2);
        System.out.println("List after removing element in index 2: " + list);
        Integer toRemove = 12;
        list.remove(toRemove);
        System.out.println("List after remove element 12: " + list);
        list.add(5);
        System.out.println(list);
        list.removeLastOccurrence(5);
        System.out.println("List after removeLastOccurrence 5: " + list);
        Collections.sort(list);
        System.out.println("After sorting: " + list);
    }
}
