package com.sahil.learning;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class GenericDemo {

    public static void main(String[] args) {
        int[] nums = new int[10];
//        List<Integer> list = Stream.of(nums).toList();
        Set<Integer> numbers = new HashSet<>();
        Arrays.stream(nums).forEach(numbers::add);
        System.out.println(numbers);
    }
}
