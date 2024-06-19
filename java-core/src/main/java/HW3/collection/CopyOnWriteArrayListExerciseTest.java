package HW3.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        // 创建一个 CopyOnWriteArrayList
        List<String> list = new CopyOnWriteArrayList<>();

        // 添加元素
        list.add("apple");
        list.add("banana");


        list.add(1, "cherry");

        List<String> otherList = List.of("dates", "figs");
        list.addAll(otherList);

        // 添加元素（如果不存在）
        list.addIfAbsent("apple");

        // 添加所有不存在的元素
        List<String> absentList = List.of("banana", "grapes");
        list.addAllAbsent(absentList);

        // 输出列表内容
        System.out.println("CopyOnWriteArrayList: " + list);
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        //Created an iterator
        Iterator<String> itr = list.iterator();
    }
}
