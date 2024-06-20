package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<String> list = new CopyOnWriteArrayList<>();

        list.add("Apple");
        assertTrue("List should contain 'Apple'", list.contains("Apple"));

        list.add(0, "Banana");
        assertEquals("Banana should be at index 0", "Banana", list.get(0));

        list.addAll(Arrays.asList("Cherry", "Date"));
        assertTrue("List should contain 'Cherry' and 'Date'", list.containsAll(Arrays.asList("Cherry", "Date")));

        list.addIfAbsent("Apple");  // Already present, should not add
        list.addIfAbsent("Elderberry");  // Not present, should add
        assertEquals("Apple should not be added again", 1, Collections.frequency(list, "Apple"));
        assertTrue("Elderberry should be added", list.contains("Elderberry"));

        list.addAllAbsent(Arrays.asList("Fig", "Grape", "Apple"));  // "Apple" is present, "Fig" and "Grape" are not
        assertTrue("Fig and Grape should be added", list.containsAll(Arrays.asList("Fig", "Grape")));
        assertEquals("Apple should still only appear once", 1, Collections.frequency(list, "Apple"));
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        //Created an iterator
        Iterator<String> itr = list.iterator();
    }
}
