package com.chuwa.exercise.MavenProject.observer;

/**
 * description: WechatUser
 * date: 6/19/24 7:10 PM
 * author: jinhao_pang
 * version: 1.0
 */
public class WechatUser implements Observer {
    private String name;

    public WechatUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
