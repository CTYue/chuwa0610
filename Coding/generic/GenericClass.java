package generic;

/**
 * description: GenericClass
 * date: 6/20/24 1:40 AM
 * author: jinhao_pang
 * version: 1.0
 */
public class GenericClass<T>{
    T obj;

    public GenericClass(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}
