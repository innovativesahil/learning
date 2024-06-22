package com.sahil.learning.java17;

import java.util.stream.Collectors;
import java.util.stream.Stream;


/*
* Collectors.teeing
* It is a composite of two downstream collectors.
* Every element is processed by both downstream collectors.
* Then their results are passed to the merge function and transformed into the final result.
 */
public class CollectorsTeeingDemo {

    public static void main(String[] args) {
        double mean = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.teeing(Collectors.summingDouble(i -> i),
                        Collectors.counting(), (sum, count) -> sum / count));
        System.out.println(mean);
    }
}
