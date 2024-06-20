package com.chuwa.exercise.DesignPatterns.Factory;

/**
 * @Create 06/19/2024 - 20:04
 * @Author xiao
 * @Description
 */

public class ShapeFactory {
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
