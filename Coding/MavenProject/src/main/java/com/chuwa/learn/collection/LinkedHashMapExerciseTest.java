package com.chuwa.learn.collection;

import org.junit.Test;

import java.util.*;

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
        Map<String, Integer> map = new LinkedHashMap<>();

        // Adding elements using put(K key, V value)
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);
        System.out.println("After put: " + map);

        // Adding an element using putIfAbsent(K key, V value)
        map.putIfAbsent("Apple", 10); // Will not add because "Apple" already exists
        map.putIfAbsent("Grape", 4); // Will add because "Grape" does not exist
        System.out.println("After putIfAbsent: " + map);

        // Adding all elements from another map using putAll(Map<? extends K, ? extends V> m)
        Map<String, Integer> anotherMap = new LinkedHashMap<>();
        anotherMap.put("Pineapple", 5);
        anotherMap.put("Mango", 6);
        map.putAll(anotherMap);
        System.out.println("After putAll: " + map);

        // Retrieving elements using get(Object key)
        Integer appleValue = map.get("Apple");
        System.out.println("Value for 'Apple': " + appleValue);

        // Retrieving elements using getOrDefault(Object key, V defaultValue)
        Integer cherryValue = map.getOrDefault("Cherry", -1);
        System.out.println("Value for 'Cherry' (with default): " + cherryValue);

        // Checking if a key exists using containsKey(Object key)
        boolean hasBanana = map.containsKey("Banana");
        System.out.println("Contains 'Banana': " + hasBanana);

        // Checking if a value exists using containsValue(Object value)
        boolean hasValue5 = map.containsValue(5);
        System.out.println("Contains value 5: " + hasValue5);

        // Getting the set of keys using keySet()
        Set<String> keys = map.keySet();
        System.out.println("Keys: " + keys);

        // Getting the collection of values using values()
        Collection<Integer> values = map.values();
        System.out.println("Values: " + values);

        // Checking if the map is empty using isEmpty()
        boolean isEmpty = map.isEmpty();
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
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);
        System.out.println("Original map: " + map);

        map.replace("Banana", 2, 20);
        map.replace("Apple", 10, 100);
        System.out.println("After replace(K key, V oldValue, V newValue): " + map);

        map.replace("Orange", 30);
        System.out.println("After replace(K key, V value): " + map);

        map.replaceAll((key, value) -> value * 2);
        System.out.println("After replaceAll(BiFunction): " + map);

        map.remove("Apple");
        System.out.println("After remove(Object key): " + map);

        map.remove("Banana", 20);
        System.out.println("After remove(Object key, Object value): " + map);

        map.compute("Grape", (key, value) -> (value == null) ? 1 : value + 1);
        map.compute("Banana", (key, value) -> value + 1);
        System.out.println("After compute(K key, BiFunction): " + map);

        map.computeIfAbsent("Cherry", key -> 10);
        map.computeIfAbsent("Banana", key -> 10);
        System.out.println("After computeIfAbsent(K key, Function): " + map);

        map.computeIfPresent("Grape", (key, value) -> value + 5);
        map.computeIfPresent("Pineapple", (key, value) -> value + 5);
        System.out.println("After computeIfPresent(K key, BiFunction): " + map);
    }
}
