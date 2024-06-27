import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class CollectionsExerciseTest {

    /**
     * Collections.min(list))
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    @Test
    public void learn_common_collections_operations() {
        List<Integer> list = Arrays.asList(1,2,4,4,5);
        Assert.assertEquals((Integer)1,Collections.min(list));
        Assert.assertEquals((Integer)5,Collections.max(list));
        Assert.assertEquals((Integer)2,(Integer) Collections.frequency(list,4));
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> arr = Arrays.asList(1,2,3);
        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>(arr));
        Assert.assertEquals(arr, synchronizedList);

    }
}
