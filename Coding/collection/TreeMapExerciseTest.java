package com.chuwa.exercise.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

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
        map.put("apple", 100);
        map.put("banana", 200);
        map.putIfAbsent("cherry", 300);
        map.putIfAbsent("banana", 250); // won't put because "banana" is already present

        Map<String, Integer> additionalMap = new TreeMap<>();
        additionalMap.put("date", 400);
        additionalMap.put("elderberry", 500);
        map.putAll(additionalMap);

        Assert.assertEquals(Integer.valueOf(100), map.get("apple"));
        Assert.assertEquals("apple", map.firstKey());
        Assert.assertEquals("elderberry", map.lastKey());
        Assert.assertTrue(map.containsKey("banana"));
        Assert.assertTrue(map.containsValue(200));
        Assert.assertFalse(map.isEmpty());
        Assert.assertNotNull(map.keySet());
        Assert.assertNotNull(map.values());
        Assert.assertEquals(5, map.size());
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
        map.put("apple", 100);
        map.put("banana", 200);
        map.put("cherry", 300);

        // Replace values
        map.replace("banana", 250); // Unconditional replace
        map.replace("cherry", 300, 350); // Conditional replace (only if currently mapped to 300)

        // Remove an entry
        map.remove("apple");

        // Check results
        Assert.assertFalse(map.containsKey("apple"));
        Assert.assertEquals(Integer.valueOf(250), map.get("banana"));
        Assert.assertEquals(Integer.valueOf(350), map.get("cherry"));
        Assert.assertEquals(2, map.size()); // only banana and cherry should remain
    }
}
