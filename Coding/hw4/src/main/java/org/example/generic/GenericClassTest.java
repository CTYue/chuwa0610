package org.example.generic;

public class GenericClassTest {
    public static void main(String[] args) {
        // Integer type
        GenericClass<Integer> obj1 = new GenericClass<>(5);
        System.out.println(obj1.getObj());

        // Double type
        GenericClass<Double> obj2 = new GenericClass<>(15.77);
        System.out.println(obj2.getObj());

        // String type
        GenericClass<String> obj3 = new GenericClass<>("My first generic class");
        System.out.println(obj3.getObj());
    }
}
