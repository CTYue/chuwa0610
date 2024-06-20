package com.chuwa.exercise.collection;

import org.junit.Assert;
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
        map.put("somethinTest", 1200);
        map.putIfAbsent("absent",1300);

        map.put("Key1", 100);
        Assert.assertEquals(Integer.valueOf(100), map.get("Key1"));

        Assert.assertTrue(map.containsKey("Key1"));
        Assert.assertFalse(map.containsKey("NonExistingKey"));
        Assert.assertTrue(map.containsValue(100));
        Assert.assertFalse(map.containsValue(200));

        Assert.assertFalse(map.isEmpty());

        map.put("Key2", 200);

        Assert.assertEquals(2, map.size());
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
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("key1", 100);
        map.putIfAbsent("key2", 200);
        Assert.assertEquals(Integer.valueOf(100), map.get("key1"));
        Assert.assertEquals(Integer.valueOf(200), map.get("key2"));

        map.replace("key1", 100, 150);
        map.replace("key2", 250);
        Assert.assertEquals(Integer.valueOf(150), map.get("key1"));
        Assert.assertEquals(Integer.valueOf(250), map.get("key2"));

        map.replaceAll((key, value) -> value + 50);
        Assert.assertEquals(Integer.valueOf(200), map.get("key1"));
        Assert.assertEquals(Integer.valueOf(300), map.get("key2"));

        map.remove("key1");
        map.remove("key2", 300);
        Assert.assertNull(map.get("key1"));
        Assert.assertNull(map.get("key2"));

        map.put("key3", 300);
        map.compute("key3", (key, value) -> value * 2);
        Assert.assertEquals(Integer.valueOf(600), map.get("key3"));
    }
}
