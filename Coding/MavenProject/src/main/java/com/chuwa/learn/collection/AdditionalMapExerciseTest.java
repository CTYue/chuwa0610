package com.chuwa.learn.collection;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class AdditionalMapExerciseTest {

    /**
     * e.g.
     * ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     */
    @Test
    public void learn_ConcurrentHashMap() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);
        System.out.println("After put: " + map);

        map.putIfAbsent("Apple", 10);
        map.putIfAbsent("Grape", 4);
        System.out.println("After putIfAbsent: " + map);

        // Adding all elements from another map using putAll(Map<? extends K, ? extends V> m)
        Map<String, Integer> anotherMap = new ConcurrentHashMap<>();
        anotherMap.put("Pineapple", 5);
        anotherMap.put("Mango", 6);
        map.putAll(anotherMap);
        System.out.println("After putAll: " + map);
    }

    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_IdentityHashMap() {
        Map<DayOfWeek, Integer> map = new IdentityHashMap<>();

        // Adding elements using put(K key, V value)
        map.put(DayOfWeek.MONDAY, 1);
        map.put(DayOfWeek.TUESDAY, 2);
        map.put(DayOfWeek.WEDNESDAY, 3);
        System.out.println("After put: " + map);

        // Adding an element using putIfAbsent(K key, V value)
        map.putIfAbsent(DayOfWeek.MONDAY, 10); // Will not add because MONDAY already exists
        map.putIfAbsent(DayOfWeek.THURSDAY, 4); // Will add because THURSDAY does not exist
        System.out.println("After putIfAbsent: " + map);
    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_EnumMap() {
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);

        // Adding elements using put(K key, V value)
        enumMap.put(DayOfWeek.MONDAY, 1);
        enumMap.put(DayOfWeek.TUESDAY, 2);
        enumMap.put(DayOfWeek.WEDNESDAY, 3);
        System.out.println("After put: " + enumMap);

        // Adding an element using putIfAbsent(K key, V value)
        enumMap.putIfAbsent(DayOfWeek.MONDAY, 10); // Will not add because MONDAY already exists
        enumMap.putIfAbsent(DayOfWeek.THURSDAY, 4); // Will add because THURSDAY does not exist
        System.out.println("After putIfAbsent: " + enumMap);
    }
}
