package com.chuwa.exercise.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
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
        List<Integer> copyOnWriteList = new CopyOnWriteArrayList<>();

        copyOnWriteList.add(1);
        copyOnWriteList.add(2);
        Assert.assertEquals(2, copyOnWriteList.size());

        copyOnWriteList.add(1, 3);
        Assert.assertEquals( Integer.valueOf(3), copyOnWriteList.get(1));

        Collection<Integer> collectionToAdd = new ArrayList<>();
        collectionToAdd.add(4);
        collectionToAdd.add(5);
        copyOnWriteList.addAll(collectionToAdd);
        Assert.assertTrue( copyOnWriteList.containsAll(collectionToAdd));

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
        while (itr.hasNext()) {
            if ("Apple".equals(itr.next())) {
                itr.remove();  // This should throw an UnsupportedOperationException
            }
        }
    }
}
