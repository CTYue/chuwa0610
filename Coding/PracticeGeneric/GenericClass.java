package PracticeGeneric;

public class GenericClass<T> {
    T obj;
    GenericClass(T obj){
    this.obj = obj;
    }

    public T getObj(){
        return this.obj;
    }

}
