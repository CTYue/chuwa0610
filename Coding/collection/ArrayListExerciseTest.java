package com.chuwa.exercise.collection;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.UnaryOperator;

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
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Assert.assertEquals(list.get(1), Integer.valueOf(2));
        Assert.assertEquals(list.size(), 2);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);
        list.addAll(list2);
        Assert.assertEquals(list.size(), 4);
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
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("bb");
        list.add("ccc");

        list.remove(0);
        list.remove("bb");
        list.clear();

        list.add("p");
        list.add("bb");
        list.add("ccc");
        list.set(0, "a");
        UnaryOperator<String> operator = String::toUpperCase;
        list.replaceAll(operator);

        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("a","A"));
        list.removeAll(list2); //remove A, not a
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
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Circus"));
        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(4);
        numbers.add(2);
        numbers.add(3);

        Collections.sort(numbers);
        Assert.assertEquals(numbers, Arrays.asList(1,2,3,4,5));

        Collections.sort(numbers, Comparator.reverseOrder());
        Assert.assertEquals(numbers, Arrays.asList(5,4,3,2,1));

        UnaryOperator<Integer> doubleValue = x -> x * 2;
        numbers.replaceAll(doubleValue);
        Assert.assertEquals(numbers, Arrays.asList(10,8,6,4,2));
    }
}
