package com.sahil.learning.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LinearSorting {

    public static void main(String[] args) {

        List<Short> list = IntStream.range(-128 , 128).mapToObj(i -> (short)i).collect(Collectors.toList());
        Collections.shuffle(list);
        short[] sorted = new short[256];
//        System.out.println(list);
        for (Short i : list) {
            int index = i + 128;
            sorted[index] = i;
        }
//        System.out.println(Arrays.toString(sorted));

        // scenario where integers from 0 to 100_000 need to be sorted

        List<Integer> integers = Stream.concat(
                Stream.concat(IntStream.range(500, 800).boxed(), IntStream.range(1100, 1300).boxed()),
                Stream.concat(IntStream.range(1350, 1600).boxed(), IntStream.range(1750, 1950).boxed()))
                .collect(Collectors.toList());

        Collections.shuffle(integers);
        System.out.println("##### UNSORTED LIST #####");
        System.out.println(integers);

        int[] sortedIntegers = new int[2_000];
        Arrays.fill(sortedIntegers, -1);

        for (Integer i : integers) {
            sortedIntegers[i] = i;
        }
        System.out.println("##### SORTED LIST WITH -1 #####");
        System.out.println(Arrays.toString(sortedIntegers));
        int j = 0;
        for (int i = 0; i < sortedIntegers.length; i++) {
            if(sortedIntegers[i] != -1) {
                sortedIntegers[j++] = sortedIntegers[i];
            }
        }
        System.out.println("##### SORTED LIST #####");
        System.out.println(Arrays.toString(Arrays.copyOf(sortedIntegers, integers.size())));
    }
}
