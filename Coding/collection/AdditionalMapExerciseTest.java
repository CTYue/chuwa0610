package com.chuwa.exercise.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.IdentityHashMap;
import java.util.EnumMap;
import java.time.DayOfWeek;

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
        map.put("one", 1);
        map.putIfAbsent("two", 2);
        ConcurrentHashMap<String, Integer> newMap = new ConcurrentHashMap<>();
        newMap.put("three", 3);
        map.putAll(newMap);

        Assert.assertEquals(1, (int) map.get("one"));
        Assert.assertEquals(2, (int) map.get("two"));
        Assert.assertEquals(3, (int) map.get("three"));
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
        IdentityHashMap<DayOfWeek, Integer> map = new IdentityHashMap<>();
        map.put(DayOfWeek.MONDAY, 1);
        map.putIfAbsent(DayOfWeek.TUESDAY, 2);

        // Due to the nature of IdentityHashMap, two keys that are equal are not necessarily the same.
        DayOfWeek mondayCopy = DayOfWeek.MONDAY;
        map.put(mondayCopy, 10);

        Assert.assertEquals(1, (int) map.get(DayOfWeek.MONDAY));
        Assert.assertNotEquals(10, (int) map.get(DayOfWeek.MONDAY));
        Assert.assertEquals(2, (int) map.get(DayOfWeek.TUESDAY));
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
        enumMap.put(DayOfWeek.MONDAY, 1);
        enumMap.putIfAbsent(DayOfWeek.MONDAY, 10);
        enumMap.put(DayOfWeek.WEDNESDAY, 3);

        Assert.assertEquals(1, (int) enumMap.get(DayOfWeek.MONDAY));
        Assert.assertEquals(3, (int) enumMap.get(DayOfWeek.WEDNESDAY));
    }
}
