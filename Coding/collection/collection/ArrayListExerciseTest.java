package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */

class Op implements UnaryOperator<String> {
    public String apply(String str) {
        return str.toUpperCase();
    }
}

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
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        int arrGet = arr.get(0);
        int size = arr.size();
        ArrayList<Integer> arrCopy = new ArrayList<>();
        arrCopy.addAll(arr);
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
    public void learn_Remove_Replacing_Updating(ArrayList<String> arr, ArrayList<String> arr2) {
        arr.remove(0);
        arr.remove("a");
        arr.removeRange(0, 1);
        arr.removeAll(arr2);
        arr.clear();

        arr.set(0, "b");
        arr.replaceAll(new Op());

        if(arr.contains("a")) {
            // ...
        }
        System.out.println(arr.indexOf("a"));
        System.out.println(arr.lastIndexOf("b")); //return last index of b or -1;

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     * forEachRemaining(Consumer<? super E> action) -- from Java8
     */

    @Test
    public void learn_Iterator(ArrayList<String> arr) {
        Iterator<String> iterator = arr.iterator();
        while(iterator.hasNext()) {
            String elem = iterator.next();
            iterator.remove();
        }

        iterator = arr.iterator();
        iterator.forEachRemaining(System.out::println);
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> numbers = Arrays.asList(5, 3, 1, 4, 2);
        sort(numbers);
        Collections.sort(numbers);
        numbers.sort(Collections.reverseOrder());
    }
}