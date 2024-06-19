package DesignPatterns.Singleton;

public class Client {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);

        Singleton1 instance3 = Singleton1.getInstance();
        Singleton1 instance4 = Singleton1.getInstance();
        System.out.println(instance3 == instance4);
    }
}
