package HW3.collection;

import org.junit.Test;

import java.util.HashMap;
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
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("key1", 1);

        // putIfAbsent(K key, V value) key is not exist, will put key2 -> 2
        map.putIfAbsent("key2",2);


        // putAll(Map<? extends K, ? extends V> m)
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("key3", 3);
        anotherMap.put("key4", 4);
        map.putAll(anotherMap);// map = [key1 = 1, key2 = 2, key3 = 3, key4 = 4];
        System.out.println("map res:" + map);

        // get(Object key)
        Integer value = map.get("key1");//1

        // getOrDefault(Object key, V defaultValue)
        Integer valueOrDefault = map.getOrDefault("key5", 0);//0

        // containsKey(Object key)
        boolean containsKey = map.containsKey("key1");// true;

        // containsValue(Object value)
        boolean containsValue = map.containsValue(3);// true;

        // keySet()
        map.keySet();// key1, key2, key3, key4

        // values()
        map.values();// 1,2,3,4

        // isEmpty()
        boolean isEmpty = map.isEmpty();// false;

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
        Map<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);

        // replace(K key, V oldValue, V newValue)
        map.replace("key2", 2, 20);
        System.out.println("After replace(key2, 2, 20): " + map);

        // replace(K key, V value)
        map.replace("key3", 3);
        System.out.println("After replace: " + map);

        // replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
        map.replaceAll((k, v) -> v * 10);
        System.out.println("After replaceAll: " + map);

        // remove(Object key)
        map.remove("key1");
        System.out.println("After remove(key1): " + map);

        // remove(Object key, Object value)
        map.remove("key2", 20);
        System.out.println("After remove(key2, 20): " + map);

        // compute(Key, BiFunction)
        map.compute("key3", (k, v) -> v + 5);
        System.out.println("After compute: " + map);

        // computeIfAbsent(Key, Function)
        map.computeIfAbsent("key4", k -> 40);
        System.out.println("After computeIfAbsent(key4, k -> 40): " + map);

        // computeIfPresent(Key, BiFunction)
        map.computeIfPresent("key5", (k, v) -> 50); // key5 does not exist, so no change
        System.out.println("After computeIfPresent: " + map);
    }
}
