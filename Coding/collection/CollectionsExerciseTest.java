package com.chuwa.exercise.collection;

import org.junit.Test;

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
        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 5);

        assertEquals("Minimum should be 5", Integer.valueOf(5), Collections.min(numbers));
        assertEquals("Maximum should be 20", Integer.valueOf(20), Collections.max(numbers));

        Comparator<Integer> reverse = Comparator.reverseOrder();
        assertEquals("Minimum with reverse comparator should be 20", Integer.valueOf(20), Collections.min(numbers, reverse));
        assertEquals("Maximum with reverse comparator should be 5", Integer.valueOf(5), Collections.max(numbers, reverse));

        assertEquals("Frequency of 5 should be 2", 2, Collections.frequency(numbers, 5));
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        List<Integer> syncList = Collections.synchronizedList(list);

        assertEquals("Synchronized list should contain 1", true, syncList.contains(1));
        assertEquals("Synchronized list should contain 2", true, syncList.contains(2));
        s
        synchronized (syncList) {
            Iterator<Integer> it = syncList.iterator();
            while (it.hasNext()) {
                assertNotNull("Element should not be null", it.next());
            }
        }
    }
}
