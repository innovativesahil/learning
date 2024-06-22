package com.sahil.learning.future;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public void test(){
        int posts = 10;
        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        PostRetriever retriever = new PostRetriever(gson, client);
        CompletableFuture<List<Post>> future =
                CompletableFuture.supplyAsync(new PostLinkSupplier(posts))
                        .thenApply(retriever);
        CompletableFuture<Void> futureWrite =
                future.thenAcceptAsync(this::saveResultList)
                        .exceptionally(ex -> {
                            System.err.println(ex.getMessage());
                            return null;
                        });
        CompletableFuture<Optional<Integer>> futureMaxId = future.thenApplyAsync(this::getMaxPost);
        CompletableFuture<Optional<Post>> futureMaxPost = future.thenApplyAsync(this::getMaxUserIdPost);
        CompletableFuture<String> futureMax = futureMaxId.thenCombineAsync(futureMaxPost, "Highest user id %s for post %s"::formatted);

        CompletableFuture.allOf(futureWrite, futureMax).join();
        future.join().forEach(System.out::println);
        System.out.println(futureMax.join());
    }

    public static void main(String[] args) {
        new CompletableFutureDemo().test();
    }

    private Optional<Integer> getMaxPost(List<Post> posts) {
        return posts.parallelStream().map(Post::id).max(Comparator.naturalOrder());
    }

    public Optional<Post> getMaxUserIdPost(List<Post> results) {
        return results.stream()
                .max(Comparator.comparingInt(Post::userId));
    }

    private void saveResultList(List<Post> posts) {
        posts.parallelStream().forEach(this::savePostToFile);
    }

    private void savePostToFile(Post post) {
        Integer id = post.id();
        Integer userId = post.userId();
        String body = post.body();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String fileName = String.format("User_%s_Post_%s.json", userId, id);
        File dir = new File("build/data");
        dir.mkdir();
        try {
            File file = new File(dir + "/" + fileName);
            Files.write(file.toPath().toAbsolutePath(), gson.toJson(post).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
