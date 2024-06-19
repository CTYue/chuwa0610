package com.chuwa.exercise.DesignPatterns.Publisher_Subscriber;

public interface Subject {
    void attach(Observer observer);

    void detach(Observer observer);

    void notify(String message);
}
