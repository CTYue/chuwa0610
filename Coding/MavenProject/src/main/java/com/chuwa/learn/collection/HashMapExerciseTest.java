package com.chuwa.learn.collection;

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
        Map<String, Integer> map = new HashMap<>();

        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);
        System.out.println("After put: " + map);

        map.putIfAbsent("Apple", 10);
        map.putIfAbsent("Grape", 4);
        System.out.println("After putIfAbsent: " + map);

        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("Pineapple", 5);
        anotherMap.put("Mango", 6);
        map.putAll(anotherMap);
        System.out.println("After putAll: " + map);

        Integer appleValue = map.get("Apple");
        System.out.println("Value for 'Apple': " + appleValue);

        Integer defaultValue = map.getOrDefault("Cherry", -1);
        System.out.println("Value for 'Cherry' (with default): " + defaultValue);

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
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);
        System.out.println("Original map: " + map);

        // Replacing values using replace(K key, V oldValue, V newValue)
        map.replace("Banana", 2, 20); // Replaces 2 with 20
        map.replace("Apple", 10, 100); // Won't replace because current value is not 10
        System.out.println("After replace(K key, V oldValue, V newValue): " + map);

        // Replacing value using replace(K key, V value)
        map.replace("Orange", 30); // Replaces 3 with 30
        System.out.println("After replace(K key, V value): " + map);

        // Replacing all values using replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
        map.replaceAll((key, value) -> value * 2); // Doubles each value
        System.out.println("After replaceAll(BiFunction): " + map);

        // Removing an entry using remove(Object key)
        map.remove("Apple");
        System.out.println("After remove(Object key): " + map);

        // Removing an entry using remove(Object key, Object value)
        map.remove("Banana", 20); // Removes only if value is 20
        map.remove("Orange", 100); // Won't remove because current value is not 100
        System.out.println("After remove(Object key, Object value): " + map);

        // Using compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
        map.compute("Grape", (key, value) -> (value == null) ? 1 : value + 1); // Adds "Grape" with value 1
        map.compute("Banana", (key, value) -> value + 1); // Increments "Banana" value by 1
        System.out.println("After compute(K key, BiFunction): " + map);

        // Using computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)
        map.computeIfAbsent("Cherry", key -> 10); // Adds "Cherry" with value 10
        map.computeIfAbsent("Banana", key -> 10); // Won't change "Banana" because it is already present
        System.out.println("After computeIfAbsent(K key, Function): " + map);

        // Using computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
        map.computeIfPresent("Orange", (key, value) -> value + 5); // Increments "Orange" value by 5
        map.computeIfPresent("Pineapple", (key, value) -> value + 5); // Won't change because "Pineapple" is not present
        System.out.println("After computeIfPresent(K key, BiFunction): " + map);
    }
}
