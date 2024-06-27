import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
     * iterator()
     * hasNext()
     * next()
     * remove()
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
}
