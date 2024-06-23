package com.chuwa.exercise.DesignPatterns.Builder;

/**
 * @Version
 * @Create 06/20/2024 - 15:22
 * @Author xiao
 * @Description TODO
 */

class HouseDirector {
 private HouseBuilder houseBuilder;

 public HouseDirector(HouseBuilder houseBuilder) {
  this.houseBuilder = houseBuilder;
 }

 public House constructHouse() {
  houseBuilder.buildFoundation();
  houseBuilder.buildStructure();
  houseBuilder.buildRoof();
  houseBuilder.buildInterior();
  return houseBuilder.getHouse();
 }
}

