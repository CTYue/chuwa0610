package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("01", "1");
        treeMap.putIfAbsent("02", "2");
        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastKey());

    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("01", "1");
        treeMap.putIfAbsent("01", "2");
        treeMap.replace("01", "1", "001");
        assertEquals(treeMap.get("01"), "001");
        treeMap.replaceAll((k, v) -> {
            if (Objects.equals(k, "01")) {
                return "005";
            }
            return v;
        });
        assertEquals(treeMap.get("01"), "005");
        treeMap.remove("02");
        assertFalse(treeMap.containsKey("02"));
    }
}
