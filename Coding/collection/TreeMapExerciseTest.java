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

        map.put("Orange", 10);
        map.put("Apple", 5);
        map.putIfAbsent("Banana", 20);
        map.putIfAbsent("Apple", 15); // This will not overwrite "Apple"

        Map<String, Integer> anotherMap = new TreeMap<>();
        anotherMap.put("Cherry", 25);
        anotherMap.put("Date", 30);
        map.putAll(anotherMap);

        assertEquals(Integer.valueOf(5), map.get("Apple"));
        assertEquals(Integer.valueOf(10), map.get("Orange"));
        assertEquals(Integer.valueOf(20), map.get("Banana"));
        assertEquals("Apple", map.firstKey());
        assertEquals("Date", map.lastKey());

        assertTrue(map.containsKey("Cherry"));
        assertTrue(map.containsValue(30));
        assertFalse(map.isEmpty());

        assertEquals(5, map.keySet().size());
        assertTrue(map.values().containsAll(Arrays.asList(5, 10, 20, 25, 30)));
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Apple", 100);
        map.put("Banana", 200);
        map.put("Cherry", 300);

        map.replace("Apple", 150);
        assertEquals("Check replaced value for 'Apple'", Integer.valueOf(150), map.get("Apple"));

        boolean replaced = map.replace("Banana", 200, 250);
        assertTrue("Check if replacement was successful", replaced);
        assertEquals("Check new value for 'Banana'", Integer.valueOf(250), map.get("Banana"));

        map.remove("Cherry");
        assertFalse("Check if 'Cherry' is removed", map.containsKey("Cherry"));
    }
}
