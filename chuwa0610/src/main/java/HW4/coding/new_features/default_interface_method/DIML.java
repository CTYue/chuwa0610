package HW4.coding.new_features.default_interface_method;

public interface DIML {

    static final String BLOG = "is Chuwa a";

    // abstract method
    int add(int a, int b);

    // default method // 已经实现了的方法，可以有多个，方便已有接口增加新的方法。
    default int substract(int a, int b){
        return a - b;
    }

    // static method
    static String blogName(){
        return BLOG;
    }
}
