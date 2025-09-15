package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class SquareUsingExecutorAndCollable implements Callable<String> {

    private static volatile long number = 1;
    private Random random = new Random();

    public static void main(String[] args) throws Exception {
        SquareUsingExecutorAndCollable classObject = new SquareUsingExecutorAndCollable();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<String>> result = new ArrayList<>();
        for(int i=1;i<=10;i++){
            Future<String> future = executorService.submit(()->classObject.call());
            result.add(future);
        }
        for(Future f: result){
            System.out.println(f.get());
        }
        executorService.shutdown();
    }
    @Override
    public String call() throws Exception {
        number = random.nextInt(20);
        long square = number * number;
        String result = "Square of number "+number+" is "+square ;
        return result;

    }
}
