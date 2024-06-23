package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class HashMapExerciseTest {
    HashMap<String, String> map1 = new HashMap<>();
    HashMap<String, String> map2 = new HashMap<>();
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
        map1.put("aaa", "aaa");
        map2.putIfAbsent("aaaa", "aaa");
        map1.putAll(map2);
        map1.get("aaa");
        map1.getOrDefault("aaa", "nnn");
        map1.containsKey("aaa");
        map1.containsValue("aaa");
        map1.keySet();
        map1.values();
        map1.isEmpty();
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
        map1.replace("aaa","bbb");
        map1.replaceAll((k, v) -> v.toUpperCase());
        map1.remove("aaa");
        map1.compute("aaa", (k, v) -> v.toUpperCase());
    }
}
