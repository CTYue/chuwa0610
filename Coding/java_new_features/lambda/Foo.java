package com.chuwa.exercise.java_new_features.lambda;

/**
 * @Version
 * @Create 06/23/2024 - 01:53
 * @Author xiao
 * @Description TODO
 */

@FunctionalInterface
public interface Foo {
 String aMethod(String string);

 default String defaultBar() {
  String s = "default Bar method";
  System.out.println(s);
  return s;
 }

 default String defaultCommon() {
  String s = "defaultCommon from Bar";
  System.out.println(s);
  return s;
 }
}