package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueue {
    List<Integer> blockingQueue = new ArrayList<>();
    static final int MAX = 10;

    Random random = new Random();

    public void produce(){
        int number = random.nextInt(100);
        synchronized (this){
            while(blockingQueue.size()==MAX){
                try {
                    wait();
                } catch (InterruptedException e) {
                    notify();
                    throw new RuntimeException(e);
                }
            }
            blockingQueue.add(number);
            System.out.println("Produced: "+number);
            sleep(500);
            notify();
        }
    }

    public void consume(){
        int number;
        synchronized (this){
            while(blockingQueue.size()==0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    notify();
                    throw new RuntimeException(e);
                }
            }
            number = blockingQueue.remove(0);
            System.out.println("consumed: "+number);
            sleep(500);
            notify();
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
        CustomBlockingQueue queue = new CustomBlockingQueue();
        Thread producer = new Thread(()->{
            for(int i=0;i<100;i++){
                queue.produce();
            }
        });

        Thread consumer = new Thread(()->{
            for(int i=0;i<100;i++){
                queue.consume();
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End");
    }

}
