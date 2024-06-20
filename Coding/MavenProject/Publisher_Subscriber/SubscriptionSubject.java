package com.chuwa.exercise.collection.Publisher_Subscriber;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject {
    private List<Observer> UserList = new ArrayList<Observer>();

    public void attach(Observer observer){
        UserList.add(observer);
    }
    public void detach(Observer observer){
        UserList.add(observer);
    }
    public void notify(String message){
        for(Observer observer1:UserList){
            observer1.update(message);
        }
    }
}
