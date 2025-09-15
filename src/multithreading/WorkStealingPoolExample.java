package multithreading;

import java.util.concurrent.*;
import java.util.*;

public class WorkStealingPoolExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            tasks.add(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
                Thread.sleep(1000); // simulate work
                return "Result " + taskId;
            });
        }

        try {
            // invokeAll submits all tasks at once and waits for completion
            List<Future<String>> results = executor.invokeAll(tasks);

            for (Future<String> f : results) {
                System.out.println("Completed: " + f.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}

