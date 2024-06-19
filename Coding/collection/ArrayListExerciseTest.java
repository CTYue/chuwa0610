package com.chuwa.exercise.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;

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
        list.add(1); // Add elements
        list.add(2);
        Assert.assertEquals(1, (int) list.get(0)); // Get element at index
        Assert.assertEquals(2, list.size()); // Get size

        List<Integer> anotherList = Arrays.asList(3, 4);
        list.addAll(anotherList); // Add all elements from another list
        Assert.assertEquals(4, list.size()); // Confirm size after adding
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
        List<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date"));
        list.remove("Date"); // Remove by object
        list.remove(2); // Remove by index
        Assert.assertFalse(list.contains("Cherry")); // Check contains

        list.set(0, "Apricot"); // Update element
        UnaryOperator<String> operator = String::toUpperCase;
        list.replaceAll(operator); // Replace all with the operator
        Assert.assertEquals("APRICOT", list.get(0)); // Check update

        List<String> removeList = Arrays.asList("APRICOT");
        list.removeAll(removeList); // Remove all from collection
        Assert.assertTrue(list.isEmpty()); // Check if list is empty
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
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        var iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number % 2 == 0) {
                iterator.remove(); // Remove even numbers
            }
        }
        Assert.assertEquals(Arrays.asList(1, 3, 5), list); // Check remaining elements
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */
    @Test
    public void learn_Sorting() {
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 1, 3, 2));
        Collections.sort(list); // Sort the list in natural order
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4), list); // Check sorted order

        Collections.sort(list, Collections.reverseOrder()); // Sort in reverse order
        Assert.assertEquals(Arrays.asList(4, 3, 2, 1), list); // Check reverse order
    }
}