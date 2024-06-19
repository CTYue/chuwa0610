package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class CollectionsExerciseTest {

    /**
     * Collections.min(list))
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    @Test
    public void learn_common_collections_operations() {
        List<Integer> list = List.of(3, 14, 1300, 12, 4, 12, 1);
        System.out.println(Collections.min(list));
        System.out.println(Collections.max(list));
        List<String> strs = List.of("Tom", "Jack", "Allen", "Mikeee");
        String min = Collections.min(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(min);
        String max = Collections.min(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(max);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        try{
            List<Integer> list = List.of(3, 14, 1300, 12, 4, 12, 1);
            System.out.println(list);

            List<Integer> synList = Collections.synchronizedList(list);
            System.out.println(synList);
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }
}
