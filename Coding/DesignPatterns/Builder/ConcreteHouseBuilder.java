package com.chuwa.exercise.DesignPatterns.Builder;

/**
 * @Version
 * @Create 06/20/2024 - 15:21
 * @Author xiao
 * @Description TODO
 */

public class ConcreteHouseBuilder implements HouseBuilder {
 private House house;

 public ConcreteHouseBuilder() {
  this.house = new House();
 }

 @Override
 public void buildFoundation() {
  house.setFoundation("Concrete foundation");
  System.out.println("ConcreteHouseBuilder: Foundation complete.");
 }

 @Override
 public void buildStructure() {
  house.setStructure("Concrete structure");
  System.out.println("ConcreteHouseBuilder: Structure complete.");
 }

 @Override
 public void buildRoof() {
  house.setRoof("Concrete roof");
  System.out.println("ConcreteHouseBuilder: Roof complete.");
 }

 @Override
 public void buildInterior() {
  house.setInterior("Concrete interior");
  System.out.println("ConcreteHouseBuilder: Interior complete.");
 }

 @Override
 public House getHouse() {
  return this.house;
 }
}
