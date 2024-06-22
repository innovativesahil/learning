package com.sahil.learning.java17;

public class StringDemo {
    public static void main(String[] args) {

        String text = "Hello Baeldung!\nThis is Java 12 article.";

        text = text.indent(4);
        System.out.println(text);

        text = text.indent(-10);
        System.out.println(text);

        String input = "Sahil Verma";
        String transformed = input.transform(value ->
                new StringBuilder(value).reverse().toString()
        );
        System.out.println(transformed);
    }
}
