package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */
public class ArrayListExerciseTest {
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        assertEquals(arrayList.get(0), 1);
        assertEquals(arrayList.size(), 1);
        ArrayList<Integer> objects = new ArrayList<>();
        objects.addAll(arrayList);
        assertEquals(objects.size(), 1);
    }

    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()
     * <p>
     * Update:
     * set(int index, E e)
     * replaceAll(UnaryOperator<E> operator)
     * <p>
     * check:
     * contains(Object o)
     * indexOf(Object o)
     * lastIndexOf(Object o)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.remove(0);
        assertEquals(arrayList.size(), 0);
        arrayList.add(2);
        arrayList.add(3);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(2);
        arrayList.removeAll(integers);
        assertEquals(arrayList.size(), 1);
        arrayList.clear();
        assertEquals(arrayList.size(), 0);
        arrayList.add(1);
        arrayList.set(0, 3);
        assertEquals(arrayList.get(0), 3);
        arrayList.replaceAll(e -> e * 2);
        assertEquals(arrayList.get(0), 6);
        assertTrue(arrayList.contains(6));
        assertEquals(0, arrayList.indexOf(6));
        assertEquals(0, arrayList.lastIndexOf(6));

    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     * forEachRemaining(Consumer<? super E> action) -- from Java8
     */

    @Test
    public void learn_Iterator() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        iterator.remove();
        assertEquals(arrayList.size(), 2);
        Iterator<Integer> iterator2 = arrayList.iterator();
        iterator2.forEachRemaining(System.out::println);
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.sort(Integer::compareTo);
        arrayList.forEach(System.out::print);

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(1);
        arrayList2.add(3);
        arrayList2.add(2);
        Collections.sort(arrayList2);
        arrayList2.forEach(System.out::print);
        arrayList2.sort(Comparator.reverseOrder());
        arrayList2.forEach(System.out::print);

    }
}
