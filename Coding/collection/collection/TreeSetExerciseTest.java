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
        Set<Integer> set= new TreeSet<>();
        set.add(1);
        List<Integer> list = Arrays.asList(2, 3, 4);
        set.addAll(list);

        if(set.contains(2)) {
            set.remove(2);
        }

        Integer firstElement = set.first();
        Integer lastElement = set.last();
        TreeSet<Integer> subSet = set.subSet(2, 5);
        TreeSet<Integer> headSet = set.headSet(4); // Returns a view of the portion of this set whose elements are strictly less than 4
        TreeSet<Integer> tailSet = set.tailSet(3); // Returns a view of the portion of this set whose elements are greater than or equal to 3

        set.clear();
        if(set.isEmpty()) {
            int s = set.size();
        }
    }
}