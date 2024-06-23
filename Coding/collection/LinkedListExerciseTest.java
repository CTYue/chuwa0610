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
        List<Integer> list = new LinkedList<>();

        list.add(10); // Add at the end
        list.addFirst(5); // Add at the start
        list.add(20); // Add at the end
        list.add(1, 15); // Insert at index 1

        list.addAll(Arrays.asList(25, 30));
        list.addAll(3, Arrays.asList(17, 19)); // Insert collection at index

        assertEquals("First element should be 5", Integer.valueOf(5), list.getFirst());
        assertEquals("Last element should be 30", Integer.valueOf(30), list.getLast());
        assertEquals("Element at index 1 should be 15", Integer.valueOf(15), list.get(1));
        assertEquals("Element at index 3 should be 17", Integer.valueOf(17), list.get(3));
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
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(30);  // Duplicate to test removeLastOccurrence

        list.removeFirst();  // Removes 10
        list.removeLast();   // Removes last 30
        list.remove(Integer.valueOf(40)); // Removes 40
        list.remove(1); // Removes element at index 1 (20 now at index 1)
        list.removeLastOccurrence(30); // Removes the first 30

        assertTrue("List should be empty", list.isEmpty());

        list.add(50);
        list.add(40);
        list.add(10);
        list.add(30);
        Collections.sort(list);
        assertEquals(Arrays.asList(10, 30, 40, 50), list);
    }
}
