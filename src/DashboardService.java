import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DashboardService {
    public static void main(String[] args) {
        System.out.println("Started");
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        CompletableFuture<String> userProfileFuture = CompletableFuture.supplyAsync(()-> fetchUserProfile(),executorService);
        CompletableFuture<String> recommendationFuture = CompletableFuture.supplyAsync(()->fetchRecommendation(),executorService);
        CompletableFuture<String> orderServiceFuture = CompletableFuture.supplyAsync(()->fetchRecentOrder(),executorService);
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(userProfileFuture,recommendationFuture,orderServiceFuture);
        allTasks.join();
        System.out.println("Started1");

        String dashboard = "";
        try {
             dashboard = """
                Dashboard:
                Profile: %s
                Orders: %s
                Recommendations: %s
                """.formatted(
                    userProfileFuture.get(),
                    orderServiceFuture.get(),
                    recommendationFuture.get()
            );
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println(dashboard);
    }

    private static String fetchRecentOrder() {
        sleep(800);
        System.out.println("Started2");
        return "[Order1, Order2]";
    }

    private static String fetchRecommendation() {
        sleep(800);
        System.out.println("Started3");
        return "[ProductX, ProductY]";
    }

    private static String fetchUserProfile() {
        sleep(500);
        System.out.println("Started4");
        return "Ajay Kanojiya";
    }

    private static void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
