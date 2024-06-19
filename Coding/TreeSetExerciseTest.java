import org.junit.Assert;
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
        Set<Integer> myset = new TreeSet<>();
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
