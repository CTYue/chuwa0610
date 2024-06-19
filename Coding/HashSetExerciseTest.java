import org.junit.Assert;
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
        Set<Integer> myset = new HashSet<>();
        myset.add(1);
        myset.add(2);
        myset.add(1);
        Assert.assertEquals(2,myset.size());
        Assert.assertTrue(myset.contains(1));
        myset.remove(1);
        Assert.assertFalse(myset.contains(1));
        myset.remove(2);
        Assert.assertTrue(myset.isEmpty());
    }
}
