package multithreading;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerUsingBlockigQueue {
    private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
    Random random = new Random();

    public void producer(){
        try {
            int number = random.nextInt(100);
            queue.put(number);
            sleep(500);
            System.out.println("Produced: "+number);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void consumer(){
        try {
            int number;
            number = queue.take();
            sleep(500);
            System.out.println("Consumed: "+number);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sleep(long milisecond){
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ProducerConsumerUsingBlockigQueue blockigQueue = new ProducerConsumerUsingBlockigQueue();

        Thread producer = new Thread(()->{
            for(int i=0;i<100;i++){
                blockigQueue.producer();
            }
        });

        Thread consumer = new Thread(()->{
            for(int i=0;i<100;i++){
                blockigQueue.consumer();
            }
        });

        System.out.println("Producer and Consumer started ");
        producer.start();
        consumer.start();
        System.out.println("Main thread is waiting ");
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End");
    }
}
