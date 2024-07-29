package com.chuwa.learn.features.default_interface_method;

public class Client {
    public static void main(String[] args) {
        DIMImpl dim = new DIMImpl();
        System.out.println(dim.add(1,2));
        System.out.println(dim.substract(1,2));
        System.out.println(DIML.blogName());

    }


}
