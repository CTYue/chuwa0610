package com.chuwa.exercise.collection;

import org.junit.Test;

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
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("A", 1);
        map.putIfAbsent("B", 2);
        Map<String, Integer> newMap = new HashMap<>();
        newMap.putAll(map);

        Integer value = map.get("A");
        String first = map.firstKey();
        String last = map.lastKey();

        boolean hasA = map.containsKey("A");
        boolean hasValue2 = map.containsValue(2);

        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();
        boolean empty = map.isEmpty();
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating(TreeMap<String, Integer> map) {
        map.replace("A", 1, 2);
        map.replace("A", 2);
        map.remove("A");
    }
}
