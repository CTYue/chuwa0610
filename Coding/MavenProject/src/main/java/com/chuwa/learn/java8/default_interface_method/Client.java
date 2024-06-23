package com.chuwa.learn.java8.default_interface_method;

public class Client {
    public static void main(String[] args) {
        DIML diml = new DIMLImpl();
        System.out.println(diml.add(2, 3));
        System.out.println(DIML.blogName());
        System.out.println(diml.sub(2,3));
    }
}
