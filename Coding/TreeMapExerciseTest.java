package com.chuwa.exercise.collection;

import com.sun.source.tree.Tree;
import org.junit.Test;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class TreeMapExerciseTest {
    TreeMap<String, String> map1 = new TreeMap<>();
    TreeMap<String, String> map2 = new TreeMap<>();
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
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        map1.replace("aaa","bbb");
        map1.replaceAll((k, v) -> v.toUpperCase());
        map1.remove("aaa");
    }
}
