package com.chuwa.exercise.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
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
        TreeMap<String, Integer> map = new TreeMap<>();

        map.put("key1", 100);
        map.put("key2", 200);
        map.putIfAbsent("key3", 300);

        TreeMap<String, Integer> anotherMap = new TreeMap<>();
        anotherMap.put("key4", 400);
        anotherMap.put("key5", 500);
        map.putAll(anotherMap);

        Assert.assertEquals(Integer.valueOf(100), map.get("key1"));
        Assert.assertEquals("key1", map.firstKey());
        Assert.assertEquals("key5", map.lastKey());

        Assert.assertTrue(map.containsKey("key2"));
        Assert.assertTrue(map.containsValue(300));

        Assert.assertEquals(5, map.keySet().size());

        Assert.assertFalse(map.isEmpty());
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

        map.put("key1", 100);
        map.put("key2", 200);
        map.put("key3", 300);

        map.replace("key1", 100, 150);
        map.replace("key2", 250);

        Assert.assertEquals(Integer.valueOf(150), map.get("key1"));
        Assert.assertEquals(Integer.valueOf(250), map.get("key2"));

        map.remove("key3");

        Assert.assertNull(map.get("key3"));
        Assert.assertEquals(2, map.size());
    }
}
