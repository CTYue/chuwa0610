package com.chuwa.exercise.collection;

import org.junit.Test;

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

        List<String> list = new ArrayList<>();

        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        assertEquals("Check if the first element is Apple", "Apple", list.get(0));
        assertEquals("Check if the second element is Banana", "Banana", list.get(1));


        assertEquals("Check the size of the list", 3, list.size());

        List<String> anotherList = new ArrayList<>();
        anotherList.add("Date");
        anotherList.add("Elderberry");


        list.addAll(anotherList);

        assertEquals("Check the size of the list after adding another list", 5, list.size());
        assertEquals("Check if the fourth element is Date", "Date", list.get(3));
        assertEquals("Check if the fifth element is Elderberry", "Elderberry", list.get(4));
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
        List<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry"));

        list.remove(0); // Removes "Apple"
        assertFalse("Check if Apple is removed", list.contains("Apple"));

        list.remove("Banana");
        assertFalse("Check if Banana is removed", list.contains("Banana"));

        list.subList(0, 1).clear(); // Removes "Cherry"
        assertFalse("Check if Cherry is removed", list.contains("Cherry"));

        List<String> toRemove = Arrays.asList("Date", "Elderberry");
        list.removeAll(toRemove);
        assertTrue("List should be empty after removing all elements", list.isEmpty());


        list.addAll(Arrays.asList("Fig", "Grape", "Honeydew"));

        list.set(1, "Guava"); // Change "Grape" to "Guava"
        assertEquals("Check if Grape was replaced by Guava", "Guava", list.get(1));

        UnaryOperator<String> operator = s -> s.toUpperCase();
        list.replaceAll(operator);
        assertEquals("Check if Fig is now uppercase", "FIG", list.get(0));
        assertEquals("Check if Guava is now uppercase", "GUAVA", list.get(1));

        assertTrue("Check if FIG is present", list.contains("FIG"));
        assertEquals("Check index of FIG", 0, list.indexOf("FIG"));
        assertEquals("Check last index of FIG", 0, list.lastIndexOf("FIG"));

        list.clear();
        assertTrue("List should be empty after clear", list.isEmpty());
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
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        Iterator<String> it = fruits.iterator();

        assertTrue("Iterator should have next element", it.hasNext());
        assertEquals("Next element should be Apple", "Apple", it.next());

        it.remove();
        assertFalse("List should not contain Apple anymore", fruits.contains("Apple"));

        List<String> remaining = new ArrayList<>();
        Consumer<String> action = remaining::add;
        it.forEachRemaining(action);

        assertTrue("Remaining should contain Banana and Cherry", remaining.contains("Banana") && remaining.contains("Cherry"));
        assertEquals("Remaining size should be 2", 2, remaining.size());
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
        numbers.add(3);
        numbers.add(8);

        Collections.sort(numbers);
        assertEquals("First element should be 3 after sorting", Integer.valueOf(3), numbers.get(0));

        Collections.sort(numbers, Comparator.reverseOrder());
        assertEquals("First element should be 8 after reverse sorting", Integer.valueOf(8), numbers.get(0));
    }
}
