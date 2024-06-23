package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
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
     * <p>
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     */
    ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();




    @Test
    public void learn_ConcurrentHashMap() {
        map.put("Howard", 123);
        map.put("Charles", 456);
        map.put("apple", 789); // add value into the map, which have <String, Integer>

        map.putIfAbsent("Three", 3); //Adds ("Three", 3) only if "Three" is not present
        map.putIfAbsent("Charles", 456); // Does not change the value for "One" as it is already present


        System.out.println(map);

        //Use putAll
        HashMap<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("Four", 4); // Adds ("Four", 4) to anotherMap
        anotherMap.put("Five", 5); // Adds ("Five", 5) to anotherMap
        map.putAll(anotherMap); // Adds all key-value pairs from anotherMap to map

        // Print the map
        System.out.println("ConcurrentHashMap: " + map);

        // currentHashMap vs HashMap
        /* HashMap isn't thread-safe at all. Thus, it is non-synchronized in nature.
        The ConcurrentHashMap, on the other hand, is thread-safe.
        Due to non-synchronization, the performance of HashMap is relatively higher,
        and various threads are capable of performing simultaneously.*/
}



    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     * <p>
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_IdentityHashMap() {
        IdentityHashMap<DayOfWeek, Integer> map = new IdentityHashMap<>();
            map.put(DayOfWeek.MONDAY, 0);
            map.put(DayOfWeek.TUESDAY, 0);
            map.put(DayOfWeek.WEDNESDAY, 0);

            map.putIfAbsent(DayOfWeek.SATURDAY, 6);
            map.putIfAbsent(DayOfWeek.MONDAY, 0);

            System.out.println(map);
    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     * <p>
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_EnumMap() {
        EnumMap<DayOfWeek, Integer> map = new EnumMap<>(DayOfWeek.class);
        map.put(DayOfWeek.THURSDAY, 4); // Adds (THURSDAY, 4)
        map.put(DayOfWeek.FRIDAY, 5); // Adds (FRIDAY, 5)

        map.putIfAbsent(DayOfWeek.SATURDAY, 7);

        System.out.println(map);

    }
}
