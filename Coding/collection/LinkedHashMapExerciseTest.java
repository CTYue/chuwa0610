package com.chuwa.exercise.collection;

import org.junit.Test;

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
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("Apple", 100);
        map.put("Banana", 200);
        assertEquals("Check the value associated with 'Apple'", Integer.valueOf(100), map.get("Apple"));

        map.putIfAbsent("Cherry", 300);
        map.putIfAbsent("Apple", 400);  // Should not change, as 'Apple' is already present
        assertEquals("Check the value associated with 'Cherry'", Integer.valueOf(300), map.get("Cherry"));
        assertEquals("Check the value remains for 'Apple'", Integer.valueOf(100), map.get("Apple"));

        Map<String, Integer> anotherMap = new LinkedHashMap<>();
        anotherMap.put("Date", 400);
        anotherMap.put("Elderberry", 500);
        map.putAll(anotherMap);

        assertEquals("Retrieve existing key 'Date'", Integer.valueOf(400), map.get("Date"));
        assertEquals("Default value for non-existing key", Integer.valueOf(999), map.getOrDefault("Fig", 999));

        assertTrue("Map should contain key 'Apple'", map.containsKey("Apple"));
        assertTrue("Map should contain value 500", map.containsValue(500));
        assertFalse("Map should not contain key 'Grape'", map.containsKey("Grape"));

        assertEquals("Key set should preserve the insertion order",
                Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry"),
                map.keySet().toArray());
        List<Integer> expectedValues = Arrays.asList(100, 200, 300, 400, 500);
        assertArrayEquals("Values should preserve the insertion order",
                expectedValues.toArray(),
                map.values().toArray());

        assertFalse("Map should not be empty", map.isEmpty());

        map.clear();
        assertTrue("Map should be empty after clear", map.isEmpty());
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

        map.replace("Apple", 100);
        assertEquals("Apple should now have value 100", Integer.valueOf(100), map.get("Apple"));

        map.replace("Banana", 20, 200);
        assertEquals("Banana should now have value 200", Integer.valueOf(200), map.get("Banana"));

        map.remove("Banana");
        assertFalse("Banana should have been removed", map.containsKey("Banana"));

        map.compute("Apple", (k, v) -> v + 900);
        assertEquals("Apple should now have value 1000", Integer.valueOf(1000), map.get("Apple"));

        map.computeIfAbsent("Cherry", k -> 300);
        assertTrue("Cherry should be added", map.containsKey("Cherry"));

        map.computeIfPresent("Cherry", (k, v) -> v + 700);
        assertEquals("Cherry should now have value 1000", Integer.valueOf(1000), map.get("Cherry"));
    }
}
