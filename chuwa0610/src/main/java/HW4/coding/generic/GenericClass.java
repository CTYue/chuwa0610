package HW4.coding.generic;

public class GenericClass<T> {// 类里面有一个参数T,代表泛型，可以在创建对象的时候，根据需要，输入任何类型的参数
    T obj;

    public GenericClass(T obj) {
        this.obj = obj;
    }

    public T getObj(){
        return this.obj;
    }
}
