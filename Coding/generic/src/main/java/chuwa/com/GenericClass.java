package chuwa.com;

/**
 * @author Jun Jiang
 * @date 6/21/24 12:17 AM
 */
public class GenericClass<T>  {

    T obj;

    public GenericClass(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return this.obj;
    }

}
