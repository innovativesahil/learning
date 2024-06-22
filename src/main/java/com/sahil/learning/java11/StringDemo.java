package com.sahil.learning.java11;

public class StringDemo {
    public static void main(String[] args) {

        // repeat
        String repeatedWord = "Java".repeat(5);
        System.out.println(repeatedWord);

        // strip*() determines whether the character is whitespace or not based on Character.isWhitespace().
        // In other words, it is aware of Unicode whitespace characters.
        // trim(), which defines space as any character that is less than or equal to the Unicode space character (U+0020)
        String strippedWord = " \n\t Java  \u2005".strip();
        System.out.println(strippedWord);
        System.out.println(" \n\t Java  ".stripLeading());
        System.out.println(" \n\t Java  ".stripTrailing());

        // Similarly, the isBlank() method is aware of Unicode whitespace characters, just like strip().

        System.out.println("Blank " + " \n\t   ".isBlank());

        //The lines() instance method returns a Stream of lines extracted from the string, separated by line terminators:
        //The stream contains lines in the order in which they occur. The line terminator is removed from each line.
        //This method should be preferred over split(), as it provides better performance for breaking multi-line input.
        String multilineStr = "This is\n \n a multiline\n string.";
        long lineCount = multilineStr.lines()
                .filter(String::isBlank)
                .count();
        System.out.println(lineCount);

    }
}
