package com.chuwa.exercise.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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

        map.put("A", 1);
        Assert.assertEquals(1, map.size());

        map.putIfAbsent("B", 2);
        map.putIfAbsent("A", 3);
        Assert.assertEquals(Integer.valueOf(1), map.get("A"));
        Assert.assertEquals(2, map.size());

        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("C", 3);
        anotherMap.put("D", 4);
        map.putAll(anotherMap);
        Assert.assertEquals(4, map.size());


        Assert.assertEquals( Integer.valueOf(1), map.get("A"));

        Assert.assertEquals( Integer.valueOf(1), map.getOrDefault("A", 0));
        Assert.assertEquals( Integer.valueOf(0), map.getOrDefault("E", 0));

        Assert.assertTrue( map.containsKey("A"));
        Assert.assertTrue( map.containsValue(1));
        Assert.assertEquals( 4, map.keySet().size());
        Assert.assertEquals( 4, map.values().size());
        Assert.assertFalse( map.isEmpty());

    }
}
