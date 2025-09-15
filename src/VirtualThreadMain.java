import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadMain {
    public static void main(String[] args) {
        Instant begin = Instant.now();
        //ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor(); //Time Taken PT0.2623188S
        ExecutorService executorService = Executors.newFixedThreadPool(100000); //Time Taken PT2.8622772S
        IntStream.range(0,100_000).forEach(i->executorService.submit(()->{
            try {
                Thread.sleep(1000);
                return i;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));
        Instant end = Instant.now();
        System.out.println("Time Taken "+Duration.between(begin,end));
        executorService.shutdown();
    }
}
