package HW3.collection;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;


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
        list.add(4);
        list.add(5);

        Integer num1 = list.get(0);//4
        Integer num2 = list.get(1);//5
        System.out.println("num1 is :" + num1);
        System.out.println("num2 is :" + num2);

        Integer size = list.size();//2
        System.out.println("the size of list is :" + size);
    }

    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()
     *
     * Update
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
        //remove
        List<String> list = new ArrayList<>();
        list.add("tom");
        list.add("Susan");
        list.remove(0);
        list.remove("Susan");
        list.removeAll(list);
        list.clear();
        //update
        list.set(0,"shanshan");
        list.replaceAll(s -> s.toUpperCase(Locale.ROOT));
        //check
        list.contains("shanshan");
        list.indexOf("shanshan");
        list.lastIndexOf("shanshan");
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
        List<String> list = new ArrayList<>();
        list.add("tom");
        list.add("Susan");
        list.add("lily");

        // got iterator
        Iterator<String> iterator = list.iterator();

        //  hasNext() 和 next()
        System.out.println("Iterating using hasNext() and next():");
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        iterator = list.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.equals("Susan")) {
                iterator.remove();
            }
        }

        System.out.println("List after removing 'Susan':");
        System.out.println(list);


        list.add("Susan");
        list.add("Alice");

        iterator = list.iterator();
        System.out.println("Iterating using forEachRemaining():");
        iterator.forEachRemaining(new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println(name);
            }
        });

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<String> list = new ArrayList<>();
        list.add("tom");
        list.add("Susan");
        list.add("lily");
        list.add("Alice");

        System.out.println("Original list:");
        System.out.println(list);


        Collections.sort(list);
        System.out.println("List sorted in natural order:");
        System.out.println(list);


        list.sort(null);
        System.out.println("List sorted in natural order using List.sort:");
        System.out.println(list);

        list.sort(Comparator.reverseOrder());
        System.out.println("List sorted in reverse order:");
        System.out.println(list);
    }
}
