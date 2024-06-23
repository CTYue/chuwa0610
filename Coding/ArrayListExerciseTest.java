package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */
public class ArrayListExerciseTest {
    ArrayList<String> list1 = new ArrayList<>();
    ArrayList<String> list2 = new ArrayList<>();
    String s = "3";
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        list1.add(s);
        list2.add("222");
        System.out.println(list1.get(0));
        list1.addAll(list2);
        System.out.println(list1.size());
    }

    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()
     *
     * Update:
     * set(int index, E e)
     * replaceAll(UnaryOperator<E> operator)
     *
     * check:
     * contains(Object o)
     * indexOf(Object o)
     * lastIndexOf(Object o)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        list1.remove(0);
        list1.remove(s);
        list2.subList(1, 3).clear();
        list1.removeAll(list2);

        list1.set(0, "aaa");
        list1.replaceAll(String::toUpperCase);
        System.out.println(list1.contains("aaa"));
        System.out.println(list1.indexOf("aaa"));
        System.out.println(list1.lastIndexOf("aaa"));
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
        Iterator<String> it = list1.iterator();
        System.out.println(it.hasNext());
        System.out.println(it.next());
        it.remove();
        it.forEachRemaining(e -> System.out.println(e));
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        Collections.sort(list1, Comparator.reverseOrder());
    }
}
