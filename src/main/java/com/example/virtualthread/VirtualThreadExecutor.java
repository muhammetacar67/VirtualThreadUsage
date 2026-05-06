package com.example.virtualthread;

import java.util.concurrent.Executors;

public class VirtualThreadExecutor {
    public static void main(String[] args) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 5; i++) {
                executor.submit(() -> {
                    System.out.println("Virtual: " + Thread.currentThread());
                });
            }
        } // burada otomatik wait eder
    }
}
//Virtual thread = hızlı başlar ama JVM’i tutmaz
//main thread biterse → her şey biter
//çözüm:
//join() ✅
//Executor ✅ (en iyi)
//sleep() ⚠️ (geçici)