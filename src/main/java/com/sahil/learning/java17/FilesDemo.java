package com.sahil.learning.java17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesDemo {

    public static void main(String[] args) throws IOException {

        Path filePath1 = Files.createTempFile("file1", ".txt");
        Path filePath2 = Files.createTempFile("file2", ".txt");
        Files.writeString(filePath1, "Java 12 Article");
        Files.writeString(filePath2, "Java 12 Article");

        long mismatch1 = Files.mismatch(filePath1, filePath2);
        assert -1 ==  mismatch1;
        Path filePath3 = Files.createTempFile("file3", ".txt");
        Path filePath4 = Files.createTempFile("file4", ".txt");
        Files.writeString(filePath3, "Java 12 Article");
        Files.writeString(filePath4, "Java 12 Tutorial");

        long mismatch2 = Files.mismatch(filePath3, filePath4);
        assert 8 ==  mismatch2;

        System.out.println(mismatch1);
        System.out.println(mismatch2);
    }
}
