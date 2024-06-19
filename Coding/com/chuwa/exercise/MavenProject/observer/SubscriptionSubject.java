package com.chuwa.exercise.MavenProject.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * description: SubscriptionSubject
 * date: 6/19/24 7:08 PM
 * author: jinhao_pang
 * version: 1.0
 */
public class SubscriptionSubject implements Subject {

    private final List<Observer> wechatUserList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        wechatUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        wechatUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : wechatUserList) {
            observer.update(message);
        }
    }
}
