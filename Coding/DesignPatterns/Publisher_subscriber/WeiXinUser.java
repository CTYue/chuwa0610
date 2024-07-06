package DesignPatterns.Publisher_subscriber;

public class WeiXinUser implements Observer {
    private String name;

    public WeiXinUser(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}