package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */
public class ArrayListExerciseTest extends ArrayList<String>{
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
        list.get(1);
        System.out.println(list.size());
        list.addAll(List.of(4, 5, 6));
        System.out.println(list.size());
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
        ArrayListExerciseTest list = new ArrayListExerciseTest();
        list.add("Hello");
        list.add("World");
        list.add("hi");
        list.add("java");
        list.add("python");
        list.add("javascript");
        list.remove(1);
        list.remove("hi");
        list.removeRange(1, 2);
        System.out.println(list);

        ArrayList<String> sublist = new ArrayList<>(List.of("Hello", "python"));
        list.removeAll(sublist);
        System.out.println(list);
        list.clear();
        System.out.println(list.size());

        list.add("Mike");
        list.add("Tom");
        list.set(0, "Allen");
        System.out.println(list);
        list.replaceAll(e -> e.toUpperCase());
        System.out.println(list);

        list.add("ALLEN");
        System.out.println(list.contains("TOM"));
        System.out.println(list.indexOf("ALLEN"));
        System.out.println(list.lastIndexOf("ALLEN"));
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
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Iterator itr = list.iterator();
        while(itr.hasNext()){
            int elem = (int) itr.next();
            System.out.println(elem);
            if(elem % 2 == 0){
                System.out.println("Removing " + elem);
                itr.remove();
            }
        }
        itr = list.iterator();
        itr.forEachRemaining((num) -> System.out.println(num));

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        ArrayList<Integer> list = new ArrayList<>(List.of(3, 1, 4, 49, 22, 124, 2, 53, 89, 67));
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list);
    }
}
