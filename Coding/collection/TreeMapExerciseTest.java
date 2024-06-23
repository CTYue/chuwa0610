package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.TreeMap;
import java.util.Map;

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

        // Inserting elements
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        System.out.println("After put: " + map);

        // putIfAbsent example
        map.putIfAbsent("four", 4);
        System.out.println("After putIfAbsent: " + map);

        // putAll example
        Map<String, Integer> anotherMap = new TreeMap<>();
        anotherMap.put("five", 5);
        anotherMap.put("six", 6);
        map.putAll(anotherMap);
        System.out.println("After putAll: " + map);

        // Retrieving elements
        System.out.println("Value for key 'one': " + map.get("one"));
        System.out.println("Value for key 'two': " + map.get("two"));
        System.out.println("Value for key 'three': " + map.get("three"));

        // Checking firstKey and lastKey
        System.out.println("First key: " + map.firstKey());
        System.out.println("Last key: " + map.lastKey());

        // containsKey and containsValue
        System.out.println("Contains key 'one': " + map.containsKey("one"));
        System.out.println("Contains value 2: " + map.containsValue(2));

        // keySet and values
        System.out.println("Key set: " + map.keySet());
        System.out.println("Values: " + map.values());

        // isEmpty
        System.out.println("Is map empty? " + map.isEmpty());


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

        // Inserting elements
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        System.out.println("After put: " + map);

        // Replacing elements
        map.replace("two", 2, 22);
        System.out.println("After replace with old value: " + map);

        map.replace("three", 33);
        System.out.println("After replace: " + map);

        // Removing elements
        map.remove("one");
        System.out.println("After remove: " + map);
    }
}
