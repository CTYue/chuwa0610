package com.chuwa.exercise.DesignPatterns.Builder;

/**
 * @Version
 * @Create 06/20/2024 - 15:21
 * @Author xiao
 * @Description TODO
 */

public interface HouseBuilder {
 void buildFoundation();
 void buildStructure();
 void buildRoof();
 void buildInterior();
 House getHouse();
}
