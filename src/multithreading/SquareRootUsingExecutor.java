package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class SquareRootUsingExecutor {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 10; i++) {
            int num = i; // effectively final for lambda
            executorService.submit(() -> {
                int square = num * num;
                System.out.println(Thread.currentThread().getName()+" Square of " + num + " = " + square);
            });
        }
        executorService.shutdown(); // no new tasks, finish existing
    }

}
