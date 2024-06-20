package com.chuwa.exercise.collection.Publisher_Subscriber;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();
        subject.attach(new User("tom"));
        subject.attach(new User("cat"));
        subject.attach(new User("dog"));

        subject.notify("new update");
    }
}
