package HW3.collection;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.IdentityHashMap;
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
        ConcurrentHashMap<String, Integer> map1 = new ConcurrentHashMap<>();
        map1.put("key1", 1);
        map1.put("key2", 2);
        map1.putIfAbsent("key3", 3);
        map1.putIfAbsent("key1", 6);//already exist, can not be modify, key1 still 1

        ConcurrentHashMap<String, Integer> map2 = new ConcurrentHashMap<>();
        map1.putAll(map2);
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
        IdentityHashMap<DayOfWeek, Integer> map = new IdentityHashMap<>();
        map.put(DayOfWeek.MONDAY, 1);
        map.put(DayOfWeek.TUESDAY, 2);
        map.forEach((key, value) -> System.out.println(key + " -> " + value));

        map.putIfAbsent(DayOfWeek.MONDAY, 100);
        map.forEach((key, value) -> System.out.println(key + " -> " + value));
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
        // must be input Enum class
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);

        enumMap.put(DayOfWeek.MONDAY, 1);
        enumMap.put(DayOfWeek.TUESDAY, 2);

        enumMap.forEach((key, value) -> System.out.println(key + " -> " + value));

        enumMap.putIfAbsent(DayOfWeek.MONDAY, 100);
        enumMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
