import org.junit.Test;

import java.util.*;

import org.junit.Assert;

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
        List<Integer> list = new LinkedList<Integer>();
        list.add(2);
        list.addFirst(1);
        list.add(1, 10);
        Collection<Integer> c1 = Arrays.asList(4, 5, 6);
        list.addAll(c1);
        Collection<Integer> c2 = Arrays.asList(7, 8);
        list.addAll(2, c2);
        Assert.assertEquals(8, list.size());
        Assert.assertEquals((Integer) 1, list.getFirst());
        Assert.assertEquals((Integer) 6, list.getLast());
        Assert.assertEquals((Integer) 8, list.get(3));
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
        List<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeFirst();
        Assert.assertEquals(2, list.size());
        Assert.assertEquals((Integer) 2, list.getFirst());
        list.removeLast();
        Assert.assertEquals(1, list.size());
        Assert.assertEquals((Integer) 2, list.getLast());
        list.add(1);
        list.add(20);
        Collections.sort(list);
        Assert.assertEquals((Integer) 1, list.get(0));

    }
}
