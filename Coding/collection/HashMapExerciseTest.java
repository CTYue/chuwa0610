package com.chuwa.exercise.collection;

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
        Map<String, Integer> map = new HashMap<>();
        map.put("hello", 2);
        map.put("hi", 5);
        map.putIfAbsent("Tom", 8);
        map.putIfAbsent("hi", 5);
        System.out.println(map);
        Map<String, Integer> newMap = new HashMap<>();
        newMap.putAll(map);
        System.out.println(newMap);
        System.out.println(map.get("Tom"));
        System.out.println(map.getOrDefault("Mike", 10));
        System.out.println(map.containsKey("Mike"));
        System.out.println(map.containsKey("Jack"));
        System.out.println(map.containsValue(10));
        System.out.println(map.containsValue(7));

        for(String str : map.keySet()){
            System.out.println(str);
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
        Map<String, Integer> map = new HashMap<>();
        map.put("Mike", 5);
        map.put("Tom", 10);
        map.put("Jack", 3);
        System.out.println(map);
        map.replace("Tom", 10, 8);
        map.replace("Jack", 100);
        System.out.println(map);
        map.replaceAll((key, val) -> val * val);
        System.out.println(map);

        map.remove("Mike");
        System.out.println(map);
        map.remove("Tom", 64);
        System.out.println(map);

        map.put("Hello", 5);
        map.compute("Jack", (key, val) -> val - 5000);
        System.out.println(map);

        map.computeIfAbsent("Hi", k -> 100 + 200);
        System.out.println(map);

        map.computeIfPresent("Hello", (key, val) -> val + 2000);
        System.out.println(map);
    }
}
