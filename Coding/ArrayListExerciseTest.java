import org.junit.Test;
import org.junit.Assert;

import java.util.*;

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
        list.add("item_1");
        list.add("item_2");
        list.add("item_3");
        Assert.assertEquals("[item_1, item_2, item_3]", list.toString());
        Assert.assertEquals(3, list.size());
        list.add("item_4");
        Assert.assertEquals("[item_1, item_2, item_3, item_4]", list.toString());
        Assert.assertEquals(4, list.size());
        List<String> list_2 = new ArrayList<String>(Arrays.asList("item_5","item_6"));
        list.addAll(list_2);
        Assert.assertEquals("[item_1, item_2, item_3, item_4, item_5, item_6]", list.toString());
        Assert.assertEquals(4+2, list.size());
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
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.remove(0);
        Assert.assertEquals("[1, 2, 3, 4]", list.toString());
        List<Integer> list_2 = Arrays.asList(1,2,3);
        list.removeAll(list_2);
        Assert.assertEquals("[4]",  list.toString());
        list.clear();
        Assert.assertEquals("[]", list.toString());
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.set(0,5);
        Assert.assertEquals("[5, 1, 2, 3, 4]", list.toString());
        Assert.assertTrue(list.contains(5));
        Assert.assertEquals(0, list.indexOf(5));


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
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        int sum =0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        Assert.assertEquals(10, sum);
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {

        List<Integer> list = new ArrayList<>();
        for (int i = 4; i >=0; i--) {
            list.add(i);
        }
        Collections.sort(list);
        Assert.assertEquals(5, list.size());
        Assert.assertEquals("[0, 1, 2, 3, 4]", list.toString());
        list.sort(Comparator.reverseOrder());
        Assert.assertEquals("[4, 3, 2, 1, 0]", list.toString());
    }
}
