package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
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

        //add element
        for (int i = 0; i < 10; i++) {
            linkList.add(i);
        }
        System.out.println(linkList);

        linkList.addFirst(0); // Adds element to the beginning
        System.out.println("After addFirst: " + linkList);

        linkList.addLast(10);// Adds element to the end
        System.out.println("After addLast: " + linkList);

        linkList.add(3, 200); // Adds element at index 3
        System.out.println("After add at index 2: " + linkList);


        List<Integer> anotherList = new LinkedList<>();
        anotherList.add(5);
        anotherList.add(6);
        linkList.addAll(anotherList); // Adds all elements from anotherList
        System.out.println("After addAll: " + linkList);

        List<Integer> subList = new LinkedList<>();
        subList.add(7);
        subList.add(8);
        linkList.addAll(3, subList); // Adds all elements from subList at index 3
        System.out.println("After addAll at index 3: " + linkList);

        Integer firstElement = linkList.getFirst(); // Gets the first element
        Integer lastElement = linkList.getLast(); // Gets the last element
        Integer elementAtIndex2 = linkList.get(2); // Gets the element at index 2
        System.out.println("First element: " + firstElement);
        System.out.println("Last element: " + lastElement);
        System.out.println("Element at index 2: " + elementAtIndex2);

        Collections.sort(linkList); // Sorts the list
        System.out.println("After sort: " + linkList);




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
        // Step 1: Create a LinkedList instance
        List<Integer> linkedlist = new LinkedList<>();
        linkedlist.add(3);
        linkedlist.add(1);
        linkedlist.add(4);
        linkedlist.add(1);
        linkedlist.add(5);
        linkedlist.add(9);
        System.out.println("Initial list: " + linkedlist);

        // Step 2: Remove elements from the list
        ((LinkedList<Integer>) linkedlist).removeFirst(); // Removes the first element
        System.out.println("After removeFirst: " + linkedlist);

        ((LinkedList<Integer>) linkedlist).removeLast(); // Removes the last element
        System.out.println("After removeLast: " + linkedlist);

        linkedlist.remove(2); // Removes the element at index 2
        System.out.println("After remove at index 2: " + linkedlist);

        linkedlist.remove((Integer) 1); // Removes the first occurrence of element 1
        System.out.println("After remove element 1: " + linkedlist);

        ((LinkedList<Integer>) linkedlist).removeLastOccurrence((Integer) 1); // Removes the last occurrence of element 1
        System.out.println("After removeLastOccurrence of element 1: " + linkedlist);

        // Step 3: Sort the list in natural order
        Collections.sort(linkedlist); // Sorts the list
        System.out.println("After sort (natural order): " + linkedlist);

        // Step 4: Sort the list in reverse order
        //list.sort(Comparator.reverseOrder());
        Collections.sort(linkedlist, Comparator.reverseOrder());// Sorts the list in reverse order
        System.out.println("After sort (reverse order): " + linkedlist);
    }
}
