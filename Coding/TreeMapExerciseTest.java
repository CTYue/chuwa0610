import org.junit.Assert;
import org.junit.Test;
import java.util.TreeMap;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */



public class TreeMapExerciseTest {

    /**
     * e.g.
     * TreeMap<String, Integer> map = new TreeMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * firstKey()
     * lastKey()
     *
     * containsKey(Object key)
     * containsValue(Object value)
     *
     * keySet()
     * values()
     * isEmpty()
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        TreeMap<String, Integer> mymap = new TreeMap<>();
        mymap.put("a", 1);
        mymap.put("b", 2);
        Assert.assertEquals((Integer) 1, mymap.get("a"));
        Assert.assertEquals((Integer) 2, mymap.get("b"));

        mymap.putIfAbsent("b", 3);
        mymap.putIfAbsent("c", 3);
        Assert.assertEquals((Integer) 2, mymap.get("b"));
        Assert.assertEquals((Integer) 3, mymap.get("c"));

        TreeMap<String, Integer> mymap_2 = new TreeMap<>();
        mymap_2.put("d", 4);
        mymap.putAll(mymap_2);
        Assert.assertEquals((Integer) 4, mymap.get("d"));
        Assert.assertTrue(mymap.containsKey("a"));
        Assert.assertFalse(mymap.containsKey("f"));
        Assert.assertTrue(mymap.containsValue(1));

        Assert.assertTrue(mymap.keySet().contains("a"));
        Assert.assertFalse(mymap.keySet().contains("f"));

        Assert.assertTrue(mymap.values().contains(1));

        Assert.assertFalse(mymap.isEmpty());
        mymap.clear();
        Assert.assertTrue(mymap.isEmpty());
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {

        TreeMap<String, Integer> mymap = new TreeMap<>();
        mymap.put("a", 1);
        mymap.put("b", 2);
        mymap.put("c", 3);

        mymap.replace("a",10);
        Assert.assertEquals((Integer)10, mymap.get("a"));
        mymap.replaceAll((a,b)-> b+1 );
        Assert.assertEquals((Integer)11,mymap.get("a"));
        mymap.remove("a");
        Assert.assertNull(mymap.get("a"));
        mymap.compute("b",(a,b)->b+1);
        Assert.assertEquals((Integer) 4,mymap.get("c"));
    }
}
