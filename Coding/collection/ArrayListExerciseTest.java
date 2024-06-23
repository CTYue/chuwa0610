package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
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
        ArrayList<String> task = new ArrayList<>();
        task.add("Java");
        task.add("Python");
        task.add("C++");
        task.add("JavaScript");

        System.out.println(task);

        System.out.println(task.indexOf("Java"));// get the index of the value that I want to check

        System.out.println("Size of Task: " + task.size());



        ArrayList<String> anotherList = new ArrayList<>();
        anotherList.add("Date");
        anotherList.add("Elderberry");
        task.addAll(anotherList); // Adds all elements from anotherList to list

        System.out.println("new map with add from anotherList: " + task);




    }


    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()

     * Update:
     * set(int index, E e)
     * replaceAll(UnaryOperator<E> operator)

     * check:
     * contains(Object o)
     * indexOf(Object o)
     * lastIndexOf(Object o)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");
        list.add("Elderberry");
        System.out.println(list);


        list.remove("Banana");
        System.out.println(list);

        ArrayList<String> anotherList = new ArrayList<>();
        anotherList.add("Apple");
        anotherList.add("Date");
        list.removeAll(anotherList); // Removes all elements in anotherList from list
        System.out.println(list);

        list.add("Banana");
        list.add("Cherry");
        list.add("Date");
        list.add("Elderberry");
        System.out.println(list);

       // cannot use remove range

        //list.clear();
        System.out.println(list);

        list.set(2, "Howard");
        System.out.println(list);


        // Replace all elements
        list.replaceAll(String::toUpperCase);

        list.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        }); // Converts all elements to uppercase
        System.out.println(list);

        boolean containsFig = list.contains("FIG"); // Checks if the list contains "FIG"
        int indexOfGrape = list.indexOf("GRAPE"); // Gets the index of "GRAPE"
        int lastIndexOfGrape = list.lastIndexOf("GRAPE"); // Gets the last index of "GRAPE"
        System.out.println(containsFig + " " + indexOfGrape + " " + lastIndexOfGrape);




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
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");

        //get an Iterator
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String element = iterator.next();
            System.out.println("element: " + element);
            // iterator.remove(); // Optionally remove elements during iteration
        }

        System.out.println("----------------------------");

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {



        // Step 1: Create an ArrayList and add elements
        ArrayList<String> list = new ArrayList<>();
        list.add("Banana");
        list.add("Apple");
        list.add("Date");
        list.add("Cherry");

        // Step 2: Sort the list using sort method
        list.sort(null); // Sorts the list in natural order (alphabetical)
        System.out.println("Sorted list: " + list);

        // Step 3: Sort the list using Collections.sort
        Collections.sort(list); // Sorts the list in natural order (alphabetical)
        System.out.println("Sorted list: " + list);

        // Step 4: Sort the list in reverse order
        list.sort(Comparator.reverseOrder()); // Sorts the list in reverse order

        // Print the sorted list to verify
        System.out.println("Sorted list: " + list);



    }
}
