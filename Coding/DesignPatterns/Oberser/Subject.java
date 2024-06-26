package com.chuwa.exercise.DesignPatterns.Oberser;

/**
 * @Version
 * @Create 06/20/2024 - 15:18
 * @Author xiao
 * @Description TODO
 */

public interface Subject {
 void registerObserver(Observer o);
 void removeObserver(Observer o);
 void notifyObservers();
}

