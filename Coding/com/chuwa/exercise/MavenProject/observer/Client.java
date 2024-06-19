package com.chuwa.exercise.MavenProject.observer;

/**
 * description: Client
 * date: 6/19/24 7:11 PM
 * author: jinhao_pang
 * version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();

        subject.attach(new WechatUser("king"));
        subject.attach(new WechatUser("queen"));
        subject.attach(new WechatUser("master"));

        subject.notify("update now");

    }
}
