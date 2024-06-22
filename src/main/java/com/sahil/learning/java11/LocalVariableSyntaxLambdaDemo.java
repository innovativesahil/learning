package com.sahil.learning.java11;

import jakarta.annotation.Nullable;

import java.util.List;
import java.util.stream.Collectors;

public class LocalVariableSyntaxLambdaDemo {

    public static void main(String[] args) {

        List<Character> list = List.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');

        // Local variable type inference works now with var as well.
        // https://www.baeldung.com/java-var-lambda-params
        list.stream().map((@Nullable var character) -> character.toString()).collect(Collectors.toSet());
    }
}
