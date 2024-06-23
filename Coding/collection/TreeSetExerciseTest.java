package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class TreeSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * contains(Object o)
     *
     * first()
     * last()
     * subSet(E fromElement, E toElement)
     * headSet(E toElement)
     * tailSet(E fromElement)
     *
     * remove(Object o)
     *
     * size()
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        TreeSet<Integer> set = new TreeSet<>();

        set.add(10);
        set.addAll(Arrays.asList(20, 30, 40, 50));

        assertTrue(set.contains(30));
        assertEquals(Integer.valueOf(10), set.first());
        assertEquals(Integer.valueOf(50), set.last());

        assertEquals(2, set.subSet(20, 40).size());
        assertEquals(3, set.headSet(40, true).size());
        assertEquals(4, set.tailSet(20, true).size());

        assertTrue(set.remove(50));
        assertEquals(4, set.size());

        set.clear();
        assertTrue(set.isEmpty());
    }
}
