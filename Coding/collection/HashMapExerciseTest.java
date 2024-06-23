package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class HashMapExerciseTest {

    /**
     * e.g.
     * Map<String, Integer> map = new HashMap<>();
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
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Howard");
        map.put(2, "Howard2");
        map.put(3, "Howard3");
        map.put(4, "Howard4");

        System.out.println(map);

        map.replace(1, "ray");
        System.out.println(map);

        map.putIfAbsent(2, "NewHoward2"); // Will not add because key 2 is already present
        map.putIfAbsent(5, "Howard5"); // Will add because key 5 is absent
        System.out.println(map);

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(12, "apple");
        map.putAll(map2);
        System.out.println(map);

        String value1 = map.get(12);
        System.out.println(value1);

        String value5 = map.getOrDefault(10, "0"); // Gets the value for key 5, or "DefaultValue" if absent
        System.out.println(value5);

        boolean hasKey3 = map.containsKey(3); // Checks if key 3 is present
        boolean hasValueHoward2 = map.containsValue("Howard2"); // Checks if value "Howard2" is present
        System.out.println(hasKey3);
        System.out.println(hasValueHoward2);

        // Get the set of keys and collection of values
        Set<Integer> keys = map.keySet(); // Gets the set of keys
        Collection<String> values = map.values(); // Gets the collection of values
        System.out.println(keys);
        System.out.println(values);

        boolean isEmpty = map.isEmpty(); // Checks if the map is empty
        System.out.println(isEmpty);

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
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Howard");
        map.put(2, "Howard2");
        map.put(3, "Howard3");
        map.put(4, "Howard4");
        System.out.println(map);

        map.replace(2, "NewHoward2"); // Replaces the value for key 2
        map.replace(3, "Howard3", "NewHoward3"); // Replaces the value for key 3 only if it is "Howard3"
        System.out.println(map);

        // Replace all values using a BiFunction
        map.replaceAll((key, value) -> value.toUpperCase()); // Converts all values to uppercase
        System.out.println(map);

        map.remove(4); // Removes the entry with key 4
        map.remove(1, "HOWARD6"); // Removes the entry with key 1 only if its value is "HOWARD"
        System.out.println(map);

        //Compute a new value for a key
        map.compute(2, (key, value) -> value + "_Updated"); // Appends "_Updated" to the value for key 2 which NEWHOWARD2 -> NEWHOWARD2_Updated
        System.out.println(map);

        //Compute a value if absent
        map.computeIfAbsent(5, key -> "NewValue"); // Adds "NewValue" for key 5 if it is absent
        System.out.println(map);


    }
}
