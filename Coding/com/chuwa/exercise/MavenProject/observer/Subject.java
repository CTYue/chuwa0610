package com.chuwa.exercise.MavenProject.observer;

/**
 * description: Subject
 * date: 6/19/24 7:05 PM
 * author: jinhao_pang
 * version: 1.0
 */
public interface Subject {
    void attach(Observer observer);

    void detach(Observer observer);

    void notify(String message);
}
