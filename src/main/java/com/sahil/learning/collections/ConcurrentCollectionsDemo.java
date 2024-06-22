package com.sahil.learning.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

public class ConcurrentCollectionsDemo {

    public static void main(String[] args) {

        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, String> concurrentSkipListMap = new ConcurrentSkipListMap<>();
        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        Set<String> concurrentSkipListSet = new ConcurrentSkipListSet<>();
        Set<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

//        CompletionStage<String> completionStage = CompletableFuture.completedStage(null);

    }
}
