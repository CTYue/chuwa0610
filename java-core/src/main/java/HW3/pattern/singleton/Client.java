package HW3.pattern.singleton;

public class Client {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        // instance1  and instance2 is the same instance, will output: true
        System.out.println(instance1 == instance2);// true

        Singleton1 instance3 = Singleton1.getInstance();
        Singleton1 instance4 = Singleton1.getInstance();
        System.out.println(instance3 == instance4);//true
    }
}
