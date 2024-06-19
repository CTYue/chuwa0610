package com.chuwa.exercise.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

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
        map.put("somethingTest", 1200);
        map.putIfAbsent("absent", 1300);

        // Adding multiple entries at once
        Map<String, Integer> newEntries = new LinkedHashMap<>();
        newEntries.put("anotherTest", 1400);
        newEntries.put("yetAnother", 1500);
        map.putAll(newEntries);

        Assert.assertEquals(Integer.valueOf(1200), map.get("somethingTest"));
        Assert.assertEquals(Integer.valueOf(1300), map.getOrDefault("absent2", 1300)); // Key not present
        Assert.assertTrue(map.containsKey("anotherTest"));
        Assert.assertTrue(map.containsValue(1500));
        Assert.assertEquals(4, map.size());
        Assert.assertFalse(map.isEmpty());
        Assert.assertNotNull(map.keySet());
        Assert.assertNotNull(map.values());
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
        map.put("key1", 100);
        map.put("key2", 200);
        map.put("key3", 300);

        // Replace elements
        map.replace("key2", 250);
        Assert.assertEquals(Integer.valueOf(250), map.get("key2"));

        map.replace("key3", 300, 350);
        Assert.assertEquals(Integer.valueOf(350), map.get("key3"));

        // Replace all using a function
        map.replaceAll((key, value) -> value + 100);
        Assert.assertEquals(Integer.valueOf(200), map.get("key1"));
        Assert.assertEquals(Integer.valueOf(450), map.get("key3"));

        // Remove elements
        map.remove("key1");
        Assert.assertFalse(map.containsKey("key1"));

        map.remove("key2", 250);
        Assert.assertFalse(map.containsKey("key2"));

        // Compute values
        map.computeIfAbsent("key4", k -> 400);
        Assert.assertEquals(Integer.valueOf(400), map.get("key4"));

        map.computeIfPresent("key3", (k, v) -> v + 50);
        Assert.assertEquals(Integer.valueOf(500), map.get("key3"));

        map.compute("key4", (k, v) -> v != null ? v * 2 : 500);
        Assert.assertEquals(Integer.valueOf(800), map.get("key4"));
    }
}