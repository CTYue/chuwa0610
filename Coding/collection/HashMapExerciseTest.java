package com.chuwa.exercise.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

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
        map.put("apple", 10);
        map.putIfAbsent("banana", 20);
        map.putIfAbsent("apple", 30); // This will not overwrite the existing "apple" entry

        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("cherry", 30);
        anotherMap.put("date", 40);
        map.putAll(anotherMap);

        Assert.assertEquals(Integer.valueOf(10), map.get("apple"));
        Assert.assertEquals(Integer.valueOf(40), map.get("date"));
        Assert.assertEquals(Integer.valueOf(50), map.getOrDefault("orange", 50));

        Assert.assertTrue(map.containsKey("banana"));
        Assert.assertTrue(map.containsValue(20));
        Assert.assertFalse(map.isEmpty());

        Assert.assertEquals(4, map.keySet().size());
        Assert.assertEquals(4, map.values().size());
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
        map.put("apple", 10);
        map.put("banana", 20);

        // Removing entries
        map.remove("apple");  // Simple remove
        map.put("apple", 10); // Re-adding for further operations
        map.remove("apple", 10); // Conditional remove, checks both key and value

        // Replacing entries
        map.replace("banana", 20, 30);
        map.replace("banana", 40); // Unconditional replace

        // Updating all entries using replaceAll
        BiFunction<String, Integer, Integer> addTen = (key, value) -> value + 10;
        map.replaceAll(addTen);

        // Compute new values
        BiFunction<String, Integer, Integer> computeFunction = (key, value) -> value != null ? value * 2 : 1;
        map.compute("banana", computeFunction); // Should double 50 to 100

        Function<String, Integer> computeIfAbsentFunction = k -> 200;
        map.computeIfAbsent("cherry", computeIfAbsentFunction); // Should add "cherry" with 200

        BiFunction<String, Integer, Integer> computeIfPresentFunction = (key, value) -> value + 100;
        map.computeIfPresent("cherry", computeIfPresentFunction); // Should update "cherry" from 200 to 300

        Assert.assertFalse(map.containsKey("apple"));
        Assert.assertEquals(Integer.valueOf(100), map.get("banana"));
        Assert.assertEquals(Integer.valueOf(300), map.get("cherry"));
    }
}
