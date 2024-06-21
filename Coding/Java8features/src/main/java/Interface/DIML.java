package Interface;

public interface DIML {
    static final String BLOG = "hello world";

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
