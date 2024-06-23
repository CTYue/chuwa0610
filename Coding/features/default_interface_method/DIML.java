package features.default_interface_method;

public interface DIML {
    String BLOG = "is Chuwa a";

    // abstract method
    int add(int a, int b);

    // default method
    default int subtract(int a, int b) {
        return a - b;
    }

    // static method
    static String blogName() {
        return BLOG;
    }
}