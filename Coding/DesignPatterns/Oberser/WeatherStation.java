package com.chuwa.exercise.DesignPatterns.Oberser;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version
 * @Create 06/20/2024 - 15:19
 * @Author xiao
 * @Description TODO
 */

public class WeatherStation implements Subject{
 private List<Observer> observers;
 private float temperature;

 public WeatherStation() {
  observers = new ArrayList<>();
 }

 @Override
 public void registerObserver(Observer o) {
  observers.add(o);
 }

 @Override
 public void removeObserver(Observer o) {
  observers.remove(o);
 }

 @Override
 public void notifyObservers() {
  for (Observer observer : observers) {
   observer.update(temperature);
  }
 }

 public void setTemperature(float temperature) {
  this.temperature = temperature;
  notifyObservers();
 }
}
