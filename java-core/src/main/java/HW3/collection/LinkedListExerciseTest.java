package HW3.collection;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author b1go
 * @date 6/12/22 4:45 PM
 */
public class LinkedListExerciseTest {

    /**
     * e.g.
     * List<Integer> list = new LinkedList<Integer>();
     * Inserting:
     * add(E e) or addLast(E e)
     * addFirst(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addAll(int index, Collection c)
     *
     * Retrieving:
     * getFirst()
     * getLast()
     * get(int index)
     *
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<Integer> list = new LinkedList<>();

        // Inserting:
        // add(E e) or addLast(E e)
        list.add(1);

        // add(int index, E element)
        list.add(2, 3);

        // addAll(Collection c)
        List<Integer> anotherList = new LinkedList<>();
        anotherList.add(4);
        anotherList.add(5);
        list.addAll(anotherList);

        // addAll(int index, Collection c)
        List<Integer> yetAnotherList = new LinkedList<>();
        yetAnotherList.add(6);
        yetAnotherList.add(7);
        list.addAll(5, yetAnotherList);

        System.out.println("After inserting: " + list);

        // Retrieving:


        // get(int index)
        Integer elementAtIndex = list.get(3);
        System.out.println("Element at index 3: " + elementAtIndex);
    }

    /**
     * removeFirst()
     * removeLast()
     * remove(int index)
     * remove(Object o)
     * removeLastOccurrence()
     *
     * sort()
     */

    @Test
    public void learn_Remove_Sort() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        // removeFirst()
        Integer firstElement = list.removeFirst();
        System.out.println("After removeFirst(): " + list);//2,3

        // removeLast()
        Integer lastElement = list.removeLast();// 2
        System.out.println("After removeLast(): " + list);


        // remove(int index)
        list.remove(0); // Remove element at index 0
        System.out.println("After remove(0): " + list);// null

        // remove(Object o)
        list.remove(Integer.valueOf(2)); // Remove specific element
        System.out.println("After remove(2): " + list);//null

        // removeLastOccurrence()
        list.add(3); // Adding another 3 to demonstrate removeLastOccurrence()//null
        list.removeLastOccurrence(3);
        System.out.println("After removeLastOccurrence(3): " + list);


        //sort()
        list.add(1);
        list.add(2);
        list.add(4);
        Collections.sort(list);
        System.out.println("After sort(): " + list);//[1, 2, 4]
    }
}
