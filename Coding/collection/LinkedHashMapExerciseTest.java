package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Function;

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
        // Step 1: Create a LinkedHashMap instance
        Map<String, Integer> map = new LinkedHashMap<>();

        // Step 2: Add elements to the map
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        System.out.println("After put: " + map);

        // Step 3: Add elements only if absent
        map.putIfAbsent("Two", 22); // Will not add because key "Two" is already present
        map.putIfAbsent("Five", 5); // Will add because key "Five" is absent
        System.out.println("After putIfAbsent: " + map);

        // Step 4: Add all elements from another map
        Map<String, Integer> anotherMap = new LinkedHashMap<>();
        anotherMap.put("Six", 6);
        anotherMap.put("Seven", 7);
        map.putAll(anotherMap); // Adds all elements from anotherMap to map
        System.out.println("After putAll: " + map);

        // Step 5: Retrieve elements from the map
        Integer value1 = map.get("One"); // Gets the value for key "One"
        Integer value5 = map.getOrDefault("Five", -1); // Gets the value for key "Five", or -1 if absent
        System.out.println("Value for key 'One': " + value1);
        System.out.println("Value for key 'Five' (or default): " + value5);

        // Step 6: Check if map contains a key or value
        boolean hasKeyThree = map.containsKey("Three"); // Checks if key "Three" is present
        boolean hasValue2 = map.containsValue(2); // Checks if value 2 is present
        System.out.println("Contains key 'Three': " + hasKeyThree);
        System.out.println("Contains value 2: " + hasValue2);

        // Step 7: Get the set of keys and collection of values
        Set<String> keys = map.keySet(); // Gets the set of keys
        Collection<Integer> values = map.values(); // Gets the collection of values
        System.out.println("Keys: " + keys);
        System.out.println("Values: " + values);

        // Step 8: Check if map is empty
        boolean isEmpty = map.isEmpty(); // Checks if the map is empty
        System.out.println("Is map empty: " + isEmpty);
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
        // Step 1: Create a LinkedHashMap instance
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        System.out.println("Initial map: " + map);

        // Step 2: Replace values in the map
        map.replace("Two", 22); // Replaces the value for key "Two"
        map.replace("Three", 3, 33); // Replaces the value for key "Three" only if it is 3
        System.out.println("After replace: " + map);

        // Step 3: Replace all values using a BiFunction
        map.replaceAll((key, value) -> value * 2); // Doubles all values
        System.out.println("After replaceAll: " + map);

        // Step 4: Remove elements from the map
        map.remove("Four"); // Removes the entry with key "Four"
        map.remove("One", 1); // Removes the entry with key "One" only if its value is 1
        System.out.println("After remove: " + map);

        // Step 5: Compute a new value for a key
        map.compute("Two", (key, value) -> value + 10); // Adds 10 to the value for key "Two"
        System.out.println("After compute: " + map);

        // Step 6: Compute a value if absent
        map.computeIfAbsent("Five", key -> 50); // Adds 50 for key "Five" if it is absent
        System.out.println("After computeIfAbsent: " + map);

        // Step 7: Compute a value if present
        map.computeIfPresent("Three", (key, value) -> value + 5); // Adds 5 to the value for key "Three"
        System.out.println("After computeIfPresent: " + map);
    }
}
