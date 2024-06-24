package com.chuwa.learn.stream_api;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamApiCreationTest {
    @Test
    public void testCollection(){
        List<Integer> col = Arrays.asList(1,2,3,4,5);
        col.forEach(System.out::println);

        Stream<Integer> stream = col.stream();
        System.out.println("Stream object " + stream);

        Stream<Integer> parallelStream = col.parallelStream();
        System.out.println("Parallel Stream:  " + parallelStream);
    }

    @Test
    public void testOf(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        System.out.println("Stream object:      " + stream);
    }

    @Test
    public void testGenerate(){
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        Stream<String> streamGenerated =
                Stream.generate(() -> "element").limit(10);
        streamGenerated.forEach(System.out::println);
    }

    @Test
    public void testStreamOfPrimitives(){
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);

        System.out.println("Stream Object:  " + intStream);
        intStream.forEach(System.out::println);

        System.out.println("Stream Object:  " + longStream);
        longStream.forEach(System.out::println);
    }

}
