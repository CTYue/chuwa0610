package HW3.collection;

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
        // new HashMap
        Map<String, Integer> map = new HashMap<>();

        // add key - value
        map.put("one", 1);
        map.put("two", 2);
        map.putIfAbsent("three", 3);

        // get method
        System.out.println("Key: one, Value: " + map.get("one")); //  1
        System.out.println("Key: two, Value: " + map.get("two")); //  2
        System.out.println("Key: three, Value: " + map.get("three")); // 3

        // getOrDefault
        System.out.println("Key: four, Value: " + map.getOrDefault("four", 0)); // 0

        // containsKey
        System.out.println("Contains key 'one': " + map.containsKey("one")); //  true
        System.out.println("Contains key 'four': " + map.containsKey("four")); //  false

        // containsValue
        System.out.println("Contains value 2: " + map.containsValue(2)); // true
        System.out.println("Contains value 4: " + map.containsValue(4)); // false

        // isEmpty()
        System.out.println("Map is empty: " + map.isEmpty()); // false

        // keySet
        System.out.println("Keys: " + map.keySet()); //[one, two, three]

        // values
        System.out.println("Values: " + map.values()); //[1, 2, 3]
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
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        //replace (K key, V oldValue, V newValue) change value
        map.replace("one", 1, 10);
        //replace(K key, V value)
        map.replace("two", 20);
        // replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
        //all values * 2:
        map.replaceAll((k, v) -> v * 2);
        System.out.println("all value * 2 :" + map);
        // remove(Object key)
        map.remove("three");// remove key, return value
        System.out.println("Remove 'three': " + map.containsKey("three")); // false

        // remove(Object key, Object value)
        //remove key and value if they are both exist,
        map.put("four", 40);
        map.remove("four", 40);
        System.out.println("Remove 'four' with value 40: " + map.containsKey("four")); // false

        // compute(Key, BiFunction)
        map.compute("one", (k, v) -> v == null ? 0 : v + 1);
        System.out.println("Compute 'one' by adding 1: " + map.get("one")); // 20 -> 21

        // computeIfAbsent(Key, Function)
        map.computeIfAbsent("five", k -> 50);
        System.out.println("Compute if absent 'five' with 50: " + map.get("five")); //50

        // computeIfPresent(Key, BiFunction)
        map.computeIfPresent("two", (k, v) -> v + 10);
        System.out.println("Compute if present 'two'&& value not null: " + map.get("two")); // 50
    }
}
