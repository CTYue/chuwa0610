package HW3.collection;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class TreeSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * contains(Object o)
     *
     * first()
     * last()
     * subSet(E fromElement, E toElement)
     * headSet(E toElement)
     * tailSet(E fromElement)
     *
     * remove(Object o)
     *
     * size()
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set = new TreeSet<>();

        // add(E e)
        set.add(1);
        set.add(2);
        set.add(3);

        // addAll(Collection<> c)
        Set<Integer> anotherSet = new TreeSet<>();
        anotherSet.add(4);
        anotherSet.add(5);
        set.addAll(anotherSet);

        // contains(Object o)
        boolean containsThree = set.contains(3);
        System.out.println("Set contains 3: " + containsThree);

        // first()
        Integer firstElement = ((TreeSet<Integer>) set).first();
        System.out.println("First element: " + firstElement);

        // last()
        Integer lastElement = ((TreeSet<Integer>) set).last();
        System.out.println("Last element: " + lastElement);

        // subSet(E fromElement, E toElement)
        Set<Integer> subSet = ((TreeSet<Integer>) set).subSet(2, 5);
        System.out.println("Subset from 2 to 5: " + subSet);

        // headSet(E toElement)
        Set<Integer> headSet = ((TreeSet<Integer>) set).headSet(3);
        System.out.println("Head set up to 3: " + headSet);

        // tailSet(E fromElement)
        Set<Integer> tailSet = ((TreeSet<Integer>) set).tailSet(3);
        System.out.println("Tail set from 3: " + tailSet);

        // remove(Object o)
        set.remove(3);
        System.out.println("After removing 3: " + set);

        // size()
        int setSize = set.size();
        System.out.println("Size of set: " + setSize);

        // isEmpty()
        boolean isEmpty = set.isEmpty();
        System.out.println("Is set empty? " + isEmpty);
    }
}
