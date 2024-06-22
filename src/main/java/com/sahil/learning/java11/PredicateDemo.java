package com.sahil.learning.java11;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
        List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");

        List<String> filteredList = sampleList.stream().filter(Predicate.not(String::isBlank)).toList();

        System.out.println(filteredList);
    }
}
