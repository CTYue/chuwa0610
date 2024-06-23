package com.chuwa.learn;

/**
 * 泛型 generic
 * 使用各种数据类型时重用一段代码
 * */
public class GenericClass<T> {
    T obj;
    public GenericClass(T obj){
        this.obj = obj;
    }
    public T getObj(){
        return this.obj;
    }
}
