package com.chuwa.exercise.collection;

import com.sun.source.tree.Tree;
import org.junit.Test;

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
        TreeMap<String, Integer> tMap = new TreeMap<>();
        tMap.put("Tom", 10);
        tMap.put("Mike", 20);
        tMap.putIfAbsent("Tony", 50);
        System.out.println(tMap);

        TreeMap<String, Integer> newMap = new TreeMap<>();
        newMap.putAll(tMap);
        System.out.println(newMap);

        System.out.println(tMap.get("Mike"));
        System.out.println(tMap.firstKey());
        System.out.println(tMap.lastKey());

        System.out.println(tMap.containsKey("Tom"));
        System.out.println(tMap.containsKey("Hi"));
        System.out.println(tMap.containsValue(50));

        for(String key : tMap.keySet()){
            System.out.println(key);
        }
        System.out.println(tMap.values());
        System.out.println(tMap.isEmpty());
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> tMap = new TreeMap<>();
        tMap.put("Tom", 10);
        tMap.put("Mike", 20);
        tMap.put("Ana", 50);
        System.out.println(tMap);
        tMap.replace("Tom", 10, 30);
        tMap.replace("Ana", 100);
        System.out.println(tMap);

        tMap.remove("Mike");
        System.out.println(tMap);
    }
}
