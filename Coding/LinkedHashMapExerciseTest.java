import org.junit.Test;
import org.junit.Assert;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class LinkedHashMapExerciseTest {
    /**
     * e.g.
     * HashMap<String, Integer> map = new LinkedHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * getOrDefault(Object key, V defaultValue)
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
        Map<String, Integer> mymap = new LinkedHashMap<>();
        mymap.put("a", 1);
        mymap.put("b", 2);
        mymap.putIfAbsent("b", 4);
        mymap.putIfAbsent("c", 3);
        Assert.assertEquals((Integer) 1, mymap.get("a"));
        Assert.assertEquals((Integer) 2, mymap.get("b"));
        Map<String, Integer> mymap_2 = new LinkedHashMap<>();
        mymap_2.put("d", 4);
        mymap_2.put("e", 5);
        mymap.putAll(mymap_2);
        Assert.assertEquals((Integer) 4, mymap.get("d"));

        Assert.assertTrue(mymap.keySet().contains("a"));
        Assert.assertTrue(mymap.values().contains(1));

    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     * replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
     *
     * remove(Object key)
     * remove(Object key, Object value)
     *
     * compute(Key, BiFunction)
     * computeIfAbsent(Key, Function)
     * computeIfPresent(Key, BiFunction)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        Map<String, Integer> mymap = new LinkedHashMap<>();
        mymap.put("a", 1);
        mymap.put("b", 2);
        mymap.putIfAbsent("b", 4);
        mymap.putIfAbsent("c", 3);
        mymap.replace("a", 1, 10);
        Assert.assertEquals((Integer) 10, mymap.get("a"));
        mymap.replaceAll((k, v) -> v +1);
        Assert.assertEquals((Integer) 4, mymap.get("c"));
        mymap.compute("c", (k, v) -> v + 1);
        Assert.assertEquals((Integer)5,mymap.get("c"));
    }
}
