package HW3.collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class HashSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new HashSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * get()
     * contains()
     *
     * remove(Object o)
     * clear()
     *
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set = new HashSet<>();
        //add (E e)
        set.add(1);

        // addAll(Collection<> c)
        Set<Integer> anotherSet = new HashSet<>();
        anotherSet.add(2);
        anotherSet.add(3);
        set.addAll(anotherSet);// set =[1, 2, 3]
        System.out.println("ser all element" + set);


        //contains()
         boolean contains3 =  set.contains(3);
        System.out.println("if contains3 :" + contains3); // true;

        // remove(Object o)
        set.remove(3);
        System.out.println("set remains: :" + set); // 1, 2;

        // clear()
        set.clear();

        // isEmpty()
        boolean isEmpty =  set.isEmpty();//will return true;
        System.out.println("set if empty :" + isEmpty); // true;
    }
}
