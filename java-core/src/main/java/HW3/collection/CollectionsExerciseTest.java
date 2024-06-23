package HW3.collection;

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
        // 创建一个列表
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5);

        // 使用 Collections.min 获取最小值
        Integer min = Collections.min(numbers);
        System.out.println("Minimum value in list: " + min);

        // 使用 Collections.max 获取最大值
        Integer max = Collections.max(numbers);
        System.out.println("Maximum value in list: " + max);

        // 使用 Collections.frequency 获取元素出现次数
        int frequency = Collections.frequency(numbers, 1);
        System.out.println("Frequency of 1 in list: " + frequency);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        // 创建普通的 ArrayList
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        // 使用 Collections.synchronizedList 创建线程安全的列表
        List<String> synchronizedList = Collections.synchronizedList(list);

        // 输出线程安全的列表内容
        System.out.println("Thread-safe list: " + synchronizedList);
    }
}
