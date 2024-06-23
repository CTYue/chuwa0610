package com.chuwa.exercise.collection;

import org.junit.Test;

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
        map.put("A", 1);
        map.putIfAbsent("B", 2);
        Map<String, Integer> newMap = new HashMap<>();
        newMap.putAll(map);

        Integer value = map.get("A");
        value = map.getOrDefault("C", 0);

        boolean hasA = map.containsKey("A");
        boolean hasValue2 = map.containsValue(2);

        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();
        boolean empty = map.isEmpty();
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
    public void learn_Remove_Replacing_Updating(Map<String, Integer> map) {
        map.replace("A", 1, 2);
        map.replace("A", 2);
        map.replaceAll((key, value) -> value * 2);

        map.remove("A");
        boolean removed = map.remove("A", 2);
        map.compute("A", (key, value) -> (value == null) ? 0 : value); // Attempts to compute a mapping for the specified key and its current mapped value
        map.computeIfAbsent("A", key -> 5);
        map.computeIfPresent("B", (key, value) -> value * 2);
    }
}
