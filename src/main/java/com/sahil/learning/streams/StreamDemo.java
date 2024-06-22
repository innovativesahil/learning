package com.sahil.learning.streams;

import java.util.OptionalDouble;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class StreamDemo {

    private static final IntPredicate oddNumber = (i) -> i % 2 != 0;
    public static void main(String[] args){
        OptionalDouble average = IntStream.of(1,2,3,4).filter(oddNumber).average();
        System.out.println(average.orElse(0));
        System.out.println((0.1d + 0.2d));
    }

}
