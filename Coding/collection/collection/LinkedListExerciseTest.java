package com.chuwa.exercise.collection;

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
        List<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.addLast(3);
        list.addFirst(0);
        list.add(2,2);
        List<Integer> listCopy = new LinkedList<Integer>();
        listCopy.addAll(list);
        listCopy.addAll(3, list);

        int first = list.getFirst();
        int last = list.getLast();
        first = list.get(0);
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
    public void learn_Remove_Sort(List<Integer> list) {
        list.removeFirst();
        list.removeLast();
        list.remove(0);
        Integer i = 1;
        list.remove(i);
        list.removeLastOccurrence();

        Collections.sort(list);
    }
}