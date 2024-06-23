package com.chuwa.learn.collection;

import org.junit.Test;

import java.util.*;

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
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int size = list.size();
        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.addAll(list);
        System.out.println(list);
        System.out.println(list2);
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
        List<String> list = new ArrayList<>(Arrays.asList("abc", "def", "ghi", "jkl", "mno", "pqr", "tuv", "wxyz"));
        System.out.println("Original list: " + list);
        list.remove(0);
        System.out.println("After remove index 0: " + list);
        list.remove("def");
        System.out.println("After remove object \"def\": " + list);
        list.subList(0, 2).clear(); // equals to removeRange
        System.out.println("After remove elements from index 0 to index 2: " + list);
        List<String> listToRemove = new ArrayList<>(Arrays.asList("tuv", "wxyz"));
        list.removeAll(listToRemove);
        System.out.println("After remove list[\"tuv\", \"wxyz\"]: " + list);
        list.clear();
        System.out.println("After clear list: " + list);
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
        List<String> list = new ArrayList<>(Arrays.asList("abc", "def", "ghi", "jkl", "mno", "pqr", "tuv", "wxyz"));
        System.out.println("Original list: " + list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.equals("tuv")) iterator.remove();
        }
        System.out.println("After using iterator to remove \"tuv\": " + list);
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,4,3,5,7));
        System.out.println("Original list: " + list);
        Collections.sort(list);
        System.out.println("After sorting list: " + list);
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println("After sorting list in reverse order: " + list);
    }
}
