package com.sahil.learning.streams;

import java.util.List;
import java.util.stream.Stream;

public class StreamMethodsDemo {

    public static void main(String[] args) {

        List<Integer> list1 = Stream.of(1, 2, 3).toList();
        List<Integer> list2 = Stream.iterate(1, n -> n + 1).limit(20).toList();
        List<Double> list3 = Stream.generate(Math::random).map(a -> a * 10).map(Math::floor).limit(20).toList();

//        new ArrayList<String>().stream()
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);

    }
}
