package HW3.collection;

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
        TreeMap<String, Integer> map = new TreeMap<>();

        // put(K key, V value)
        map.put("key1", 1);

        // putIfAbsent(K key, V value)
        map.putIfAbsent("key2", 2);

        // putAll(Map<? extends K, ? extends V> m)
        TreeMap<String, Integer> anotherMap = new TreeMap<>();
        anotherMap.put("key3", 3);
        anotherMap.put("key4", 4);
        map.putAll(anotherMap);

        // get(Object key)
        Integer value = map.get("key1");
        System.out.println("Value for key1: " + value);

        // firstKey()
        String firstKey = map.firstKey();
        System.out.println("First key: " + firstKey);

        // lastKey()
        String lastKey = map.lastKey();
        System.out.println("Last key: " + lastKey);

        // containsKey(Object key)
        boolean containsKey = map.containsKey("key1");
        System.out.println("Contains key 'key1': " + containsKey);

        // containsValue(Object value)
        boolean containsValue = map.containsValue(3);
        System.out.println("Contains value '3': " + containsValue);

        // keySet()
        System.out.println("Key set: " + map.keySet());

        // values()
        System.out.println("Values: " + map.values());

        // isEmpty()
        boolean isEmpty = map.isEmpty();
        System.out.println("Is map empty? " + isEmpty);
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {

    }
}
