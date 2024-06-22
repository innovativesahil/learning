package com.sahil.learning.future;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class PostLinkSupplier implements Supplier<List<String>> {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts/%d";


    private final int days;

    public PostLinkSupplier(int days){
        this.days = days;
    }

    @Override
    public List<String> get() {
        return IntStream.range(0, days).parallel()
                .mapToObj(BASE_URL::formatted).toList();
    }
}
