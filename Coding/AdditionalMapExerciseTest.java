import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class AdditionalMapExerciseTest {

    /**
     * e.g.
     * ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     */
    @Test
    public void learn_ConcurrentHashMap() {
        // Initialize ConcurrentHashMap
        ConcurrentHashMap<String, Integer> mymap = new ConcurrentHashMap<>();
        mymap.put("a", 1);
        mymap.put("b", 2);
        Assert.assertEquals((Integer) 1, mymap.get("a"));
        Assert.assertEquals((Integer) 2, mymap.get("b"));


        mymap.putIfAbsent("b", 3);
        mymap.putIfAbsent("c", 3);
        Assert.assertEquals((Integer) 2, mymap.get("b"));
        Assert.assertEquals((Integer) 3, mymap.get("c"));


        Map<String, Integer> mymap_2 = new HashMap<>();
        mymap_2.put("d", 4);
        mymap_2.put("e", 5);
        mymap.putAll(mymap_2);
        Assert.assertEquals(5, mymap.size());
    }

    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_IdentityHashMap() {
        Map<DayOfWeek,Integer> mymap = new IdentityHashMap<>();
        mymap.put(DayOfWeek.MONDAY,1);
        mymap.put(DayOfWeek.TUESDAY, 2);
        Assert.assertEquals((Integer) 1, mymap.get(DayOfWeek.MONDAY));
        Assert.assertEquals((Integer) 2, mymap.get(DayOfWeek.TUESDAY));


        mymap.putIfAbsent(DayOfWeek.TUESDAY, 3);
        mymap.putIfAbsent(DayOfWeek.WEDNESDAY, 3);
        Assert.assertEquals((Integer) 2, mymap.get(DayOfWeek.TUESDAY));
        Assert.assertEquals((Integer) 3, mymap.get(DayOfWeek.WEDNESDAY));
    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_EnumMap() {
        EnumMap<DayOfWeek,Integer> enumMap = new EnumMap<>(DayOfWeek.class);
        enumMap.put(DayOfWeek.MONDAY,1);
        enumMap.put(DayOfWeek.TUESDAY,2);
        Assert.assertEquals((Integer) 1, enumMap.get(DayOfWeek.MONDAY));
        Assert.assertEquals((Integer) 2, enumMap.get(DayOfWeek.TUESDAY));

        enumMap.putIfAbsent(DayOfWeek.TUESDAY, 3);
        enumMap.putIfAbsent(DayOfWeek.WEDNESDAY, 3);
        Assert.assertEquals((Integer) 2, enumMap.get(DayOfWeek.TUESDAY));
        Assert.assertEquals((Integer) 3, enumMap.get(DayOfWeek.WEDNESDAY));
    }
}
