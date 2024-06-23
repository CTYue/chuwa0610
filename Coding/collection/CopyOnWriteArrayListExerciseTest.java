package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Iterator;

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
        // Step 1: Create a CopyOnWriteArrayList instance
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // Step 2: Add elements to the list
        list.add("Apple");
        list.add("Banana");
        System.out.println(list);

        // Step 3: Add an element at a specific index
        list.add(1, "Orange"); // Adds "Orange" at index 1
        System.out.println(list);

        // Step 4: Add all elements from another collection
        List<String> anotherList = new CopyOnWriteArrayList<>();
        anotherList.add("Grapes");
        anotherList.add("Pineapple");
        list.addAll(anotherList); // Adds all elements from anotherList to list
        System.out.println(list);

        // Step 5: Add element if absent
        list.addIfAbsent("Apple"); // Does not add "Apple" because it is already present
        list.addIfAbsent("Mango"); // Adds "Mango" because it is not present
        System.out.println(list);

        // Step 6: Add all absent elements from another collection
        List<String> absentList = new CopyOnWriteArrayList<>();
        absentList.add("Banana");
        absentList.add("Cherry");
        list.addAllAbsent(absentList);  // Adds only "Cherry" because "Banana" is already present
        System.out.println(list);
        // Print the list to verify
        System.out.println("List after inserting and retrieving: " + list);
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

        // Step 3: Iterate over the list using the iterator
        while (itr.hasNext()) {
            String element = itr.next();
            System.out.println("Iterator element: " + element);

            // Note: Remove operation is not supported by CopyOnWriteArrayList iterator
            // itr.remove(); // This will throw UnsupportedOperationException
        }

        for (String element : list) {
            System.out.println(" For Iterator element: " + element);
        }
    }


}
