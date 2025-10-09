package multithreading;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProducerConsumer {

    List<Integer> list = new LinkedList<>();
    final int LIMIT = 10;
    private static AtomicBoolean stop = new AtomicBoolean(true);

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Thread producer = new Thread(producerConsumer::produce);
        Thread consumer = new Thread(producerConsumer::consumer);

        producer.start();
        consumer.start();
        System.out.println("Press enter key to stop the program...");
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stop.set(false);
        System.out.println("Main Exit..");
    }

    public void produce(){
        int number;
        Random random = new Random();
        while(stop.get()){
            synchronized (this){
                while(list.size() == LIMIT) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        notifyAll();
                        throw new RuntimeException(e);
                    }
                }
                number = random.nextInt(100);
                list.add(number);
                System.out.println("Produced: "+number);
                sleep(1000);
                notifyAll();
            }
        }
    }

    public void consumer(){
        int number;
        while(stop.get()){
            synchronized (this){
                while(list.size() == 0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        notifyAll();
                        throw new RuntimeException(e);
                    }
                }
                number = list.removeFirst();
                System.out.println("Consumed: "+number);
                sleep(1000);
                notifyAll();
            }
        }
    }

    private void sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
