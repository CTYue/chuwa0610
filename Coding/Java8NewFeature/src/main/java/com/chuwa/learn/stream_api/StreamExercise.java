package com.chuwa.learn.stream_api;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExercise {
    @Test
    public void testMapAndFlatMap(){
//        List<String> words = new ArrayList<String>();
//        words.add("Hello");
//        words.add("world");
//
//        List<String> stringList = words.stream().flatMap(word -> Arrays.stream(word.split(""))).distinct().collect(Collectors.toList());
//        stringList.forEach(e-> System.out.println(e));
        List<String> words = new ArrayList<String>();
        words.add("Hello");
        words.add("worlds");
        List<String> stringList = words.stream().flatMap(word -> Arrays.stream(word.split(""))).distinct().collect(Collectors.toList());
        stringList.forEach(e -> System.out.println(e));

    }

    @Test
    public void testMapAndFlatMap2(){
//        List<String> words = new ArrayList<String>();
//        words.add("hello");
//        words.add("word");
//
//        List<List<String>> collect = words.stream()
//                .map(word -> Arrays.stream(word.split(""))
//                        .distinct()
//                        .collect(Collectors.toList()))
//                .collect(Collectors.toList());
//
//       collect.forEach(e-> System.out.println(e));
        List<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("world");

        List<List<String>> collect = words.stream().map(word -> Arrays.stream(word.split(""))
                .distinct()
                .collect(Collectors.toList()))
                .collect(Collectors.toList());
//        collect.forEach(e -> System.out.println(e));
        System.out.println(collect);
    }
}
