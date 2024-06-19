package com.chuwa.exercise.DesignPatterns.Publisher_Subscriber;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject implements Subject{
    private List<Observer> userList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        this.userList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        this.userList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for(Observer observer : this.userList){
            observer.update(message);
        }
    }
}
