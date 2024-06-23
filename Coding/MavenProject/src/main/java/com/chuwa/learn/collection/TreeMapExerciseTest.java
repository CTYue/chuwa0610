package com.chuwa.learn.collection;

import org.junit.Test;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
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

    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> map = new TreeMap<>();

        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);
        System.out.println("After put: " + map);

        map.putIfAbsent("Apple", 10);
        map.putIfAbsent("Grape", 4);
        System.out.println("After putIfAbsent: " + map);

        Map<String, Integer> anotherMap = new TreeMap<>();
        anotherMap.put("Pineapple", 5);
        anotherMap.put("Mango", 6);
        map.putAll(anotherMap);
        System.out.println("After putAll: " + map);

        Integer appleValue = map.get("Apple");
        System.out.println("Value for 'Apple': " + appleValue);

        String firstKey = map.firstKey();
        String lastKey = map.lastKey();
        System.out.println("First key: " + firstKey);
        System.out.println("Last key: " + lastKey);

        boolean hasBanana = map.containsKey("Banana");
        System.out.println("Contains 'Banana': " + hasBanana);

        boolean hasValue5 = map.containsValue(5);
        System.out.println("Contains value 5: " + hasValue5);

        Set<String> keys = map.keySet();
        System.out.println("Keys: " + keys);

        Collection<Integer> values = map.values();
        System.out.println("Values: " + values);

        boolean isEmpty = map.isEmpty();
        System.out.println("Is map empty: " + isEmpty);
    }
}
