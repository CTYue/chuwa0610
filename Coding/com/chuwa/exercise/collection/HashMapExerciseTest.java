package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class HashMapExerciseTest {

    /**
     * e.g.
     * Map<String, Integer> map = new HashMap<>();
     * <p>
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     * <p>
     * get(Object key)
     * getOrDefault(Object key, V defaultValue)
     * <p>
     * containsKey(Object key)
     * containsValue(Object value)
     * <p>
     * keySet()
     * values()
     * isEmpty()
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("01", "1");
        hashMap.putIfAbsent("01", "2");

        Map<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("02", "2");
        hashMap.putAll(hashMap2);
        assertEquals(hashMap.get("02"), "2");
        assertEquals(hashMap.getOrDefault("03", ""), "");
        assertFalse(hashMap.isEmpty());

    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     * replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
     * <p>
     * remove(Object key)
     * remove(Object key, Object value)
     * <p>
     * compute(Key, BiFunction)
     * computeIfAbsent(Key, Function)
     * computeIfPresent(Key, BiFunction)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("01", "1");
        hashMap.putIfAbsent("01", "2");
        hashMap.replace("01", "1", "001");
        assertEquals(hashMap.get("01"), "001");
        hashMap.replaceAll((k, v) -> {
            if (Objects.equals(k, "01")) {
                return "005";
            }
            return v;
        });
        assertEquals(hashMap.get("01"), "005");
        hashMap.remove("02");
        assertFalse(hashMap.containsKey("02"));
        hashMap.compute("01", (key, value) -> value + "2");
        assertEquals(hashMap.get("01"), "0052");
        hashMap.computeIfAbsent("02", k -> "100");
        assertEquals(hashMap.get("02"), "100");
        hashMap.computeIfPresent("02", (k,v) -> "1000");
        assertEquals(hashMap.get("02"), "1000");

    }
}
