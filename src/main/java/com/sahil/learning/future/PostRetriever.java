package com.sahil.learning.future;

import com.google.gson.Gson;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class PostRetriever implements Function<List<String>, List<Post>> {

    private final Gson gson;
    private final OkHttpClient client;

    public PostRetriever(Gson gson, OkHttpClient client) {
        this.gson = gson;
        this.client = client;
    }


    private Optional<Post> getPost(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                System.out.println("Post not found for " + url);
                return Optional.empty();
            }
            return Optional.of(gson.fromJson(response.body().string(), Post.class));
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Post> apply(List<String> strings) {
        return strings.parallelStream()
                .map(this::getPost)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
