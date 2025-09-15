package multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer1 {


    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Random random = new Random();

        Thread producer = new Thread(()->{
            for(int i =1;i<100;i++){
                try {
                    int number = random.nextInt(100);
                    queue.put(Integer.valueOf(number));
                    System.out.println("Produced: "+number);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(()->{
            for(int i=1 ;i<100;i++){
                try {
                    int number = queue.take();
                    System.out.println("Consumed: "+number);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
