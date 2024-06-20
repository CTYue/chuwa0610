import org.junit.Test;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.time.DayOfWeek;

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
        ConcurrentHashMap<String, Integer> m_map = new ConcurrentHashMap<>();
        m_map.put("key1", 100);
        assertEquals("Check if key1 was added with value 100", Integer.valueOf(100), map.get("key1"));
        m_map.putIfAbsent("key2", 200);
        m_map.putIfAbsent("key2", 300);
        assertEquals("Check if key2 still has value 200", Integer.valueOf(200), map.get("key2"));
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("key3", 300);
        anotherMap.put("key4", 400);
        m_map.putAll(anotherMap);
        assertEquals("Check if key3 was added with value 300", Integer.valueOf(300), map.get("key3"));
        assertEquals("Check if key4 was added with value 400", Integer.valueOf(400), map.get("key4"));
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
        Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
        map.put(DayOfWeek.MONDAY, 1);
        assertEquals("Check if Monday was added with value 1", Integer.valueOf(1), map.get(DayOfWeek.MONDAY));

        DayOfWeek anotherMonday = DayOfWeek.MONDAY;
        map.put(anotherMonday, 2);
        assertEquals("Check if 'anotherMonday' reference updates the value", Integer.valueOf(2), map.get(DayOfWeek.MONDAY));

        DayOfWeek anotherMonday2 = DayOfWeek.MONDAY;
        map.putIfAbsent(anotherMonday2,3);
        assertEquals("Check if 'yetAnotherMonday' does not change the value", Integer.valueOf(2), map.get(DayOfWeek.MONDAY));

        map.putIfAbsent(DayOfWeek.TUESDAY, 2);
        assertEquals("Check if Tuesday was added with value 2", Integer.valueOf(2), map.get(DayOfWeek.TUESDAY));


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
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);


        enumMap.put(DayOfWeek.MONDAY, 1);
        assertEquals("Check if Monday was added with value 1", Integer.valueOf(1), enumMap.get(DayOfWeek.MONDAY));


        enumMap.putIfAbsent(DayOfWeek.MONDAY, 2);
        assertEquals("Check if Monday still has value 1", Integer.valueOf(1), enumMap.get(DayOfWeek.MONDAY));


        enumMap.putIfAbsent(DayOfWeek.TUESDAY, 3);
        assertEquals("Check if Tuesday was added with value 3", Integer.valueOf(3), enumMap.get(DayOfWeek.TUESDAY));

        assertEquals("Check if the map has two entries", 2, enumMap.size());
    }
}
