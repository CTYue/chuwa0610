package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

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
        System.out.println(map);
        HashMap<String, Integer> newMap = new LinkedHashMap<>();
        newMap.putAll(map);
        System.out.println(newMap);

        System.out.println(map.get("absent"));
        System.out.println(map.getOrDefault("test", 20));

        System.out.println(map.containsKey("test"));
        System.out.println(map.containsValue(1200));

        for(String key : map.keySet()){
            System.out.println(key);
        }
        System.out.println(map.values());
        System.out.println(map.isEmpty());
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
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("somethinTest", 1200);
        map.putIfAbsent("absent",1300);
        System.out.println(map);
        map.replace("somethinTest", 1200, 1300);
        map.replace("absent", 1000);
        System.out.println(map);
        map.replaceAll((key, val) -> val - 500);
        System.out.println(map);

        map.put("Hi", 100);
        map.remove("absent");
        map.remove("somethinTest", 800);
        System.out.println(map);

        map.put("Tom", 300);
        map.compute("Hi", (key, val) -> val + 200);
        System.out.println(map);
        map.computeIfAbsent("Jack", k -> 500 * 500);
        System.out.println(map);
        map.computeIfPresent("Tom", (key, val) -> val - 100);
        System.out.println(map);
    }
}
