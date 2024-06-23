package HW3.pattern.singleton;

public class Singleton1 {
    private Singleton1() {}

    private static Singleton1 instance;

    static {// when the class loading, will Initialize an instance， thread safe
        instance = new Singleton1();
    }

    public static Singleton1 getInstance() {
        return instance;
    }
}
