package com.chuwa.exercise.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        List<Integer> list = Arrays.asList(10,9,8,8,6,5,4,3,2,1);
        int min = Collections.min(list);
        int max = Collections.max(list);
        int fre = Collections.frequency(list, 8);

        Assert.assertEquals(min, 1);
        Assert.assertEquals(max, 10);
        Assert.assertEquals(fre, 2);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        List<Integer> synchronizedList = Collections.synchronizedList(arrayList);

        // Create multiple threads to modify the synchronized list concurrently
        Thread thread1 = new Thread(() -> {
            synchronizedList.add(4);
            synchronizedList.add(5);
        });

        Thread thread2 = new Thread(() -> {
            synchronizedList.remove(0);
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Integer> list2 = Arrays.asList(2, 3, 4, 5);
        Assert.assertEquals(list2, synchronizedList);

    }
}
