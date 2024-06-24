package com.chuwa.exercise.DesignPatterns.Publisher_Subscriber;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();

        subject.attach(new User("Mike"));
        subject.attach(new User("Tom"));
        subject.attach(new User("Jack"));

        subject.notify("News updated");
    }
}
