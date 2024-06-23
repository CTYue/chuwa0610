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

        map.put("Apple", 1);
        map.put("Banana", 2);

        map.putIfAbsent("Cherry", 3);
        map.putIfAbsent("Banana", 4);  // Should not overwrite existing "Banana"

        assertEquals("Value for 'Apple' should be 1", Integer.valueOf(1), map.get("Apple"));
        assertEquals("Value for 'Banana' should remain 2", Integer.valueOf(2), map.get("Banana"));
        assertEquals("Value for 'Cherry' should be 3", Integer.valueOf(3), map.get("Cherry"));

        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("Date", 4);
        anotherMap.put("Elderberry", 5);
        map.putAll(anotherMap);

        assertEquals("Value for 'Date' should be 4", Integer.valueOf(4), map.get("Date"));
        assertEquals("Default value for non-existing key should be 0", Integer.valueOf(0), map.getOrDefault("Fig", 0));

        assertTrue("Map should contain key 'Apple'", map.containsKey("Apple"));
        assertTrue("Map should contain value 5", map.containsValue(5));

        Set<String> keys = map.keySet();
        assertTrue("Key set should contain 'Apple' and 'Date'", keys.containsAll(Arrays.asList("Apple", "Date")));

        Collection<Integer> values = map.values();
        assertTrue("Values should contain 1 and 5", values.containsAll(Arrays.asList(1, 5)));

        assertFalse("Map should not be empty", map.isEmpty());
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
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Cherry", 30);

        map.replace("Apple", 10, 100);
        assertEquals("Apple should now be associated with 100", Integer.valueOf(100), map.get("Apple"));

        map.replace("Banana", 200);  // This will replace "Banana" regardless of the old value
        assertEquals("Banana should now be associated with 200", Integer.valueOf(200), map.get("Banana"));

        BiFunction<String, Integer, Integer> function = (key, value) -> value + 100;
        map.replaceAll(function);
        assertEquals("Apple should now be 200", Integer.valueOf(200), map.get("Apple"));
        assertEquals("Banana should now be 300", Integer.valueOf(300), map.get("Banana"));

        map.remove("Cherry");  // Simple key-based removal
        assertFalse("Cherry should no longer be in the map", map.containsKey("Cherry"));

        map.remove("Banana", 300);  // Conditional removal (key-value pair match)
        assertFalse("Banana shoxuld no longer be in the map", map.containsKey("Banana"));

        map.compute("Apple", (key, value) -> value != null ? value * 2 : 100);
        assertEquals("Apple should now be 400", Integer.valueOf(400), map.get("Apple"));

        map.computeIfAbsent("Date", k -> 42);  // Date is not present, so it will be added with value 42
        assertEquals("Date should be associated with 42", Integer.valueOf(42), map.get("Date"));

        map.computeIfPresent("Date", (key, value) -> value + 58);
        assertEquals("Date should now be 100", Integer.valueOf(100), map.get("Date"));
        map.computeIfPresent("Fig", (key, value) -> value + 58);  // Fig is not present, no changes made

        assertEquals("Final map size should be 3", 3, map.size());
    }
}
