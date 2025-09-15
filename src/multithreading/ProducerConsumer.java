package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerConsumer {

    List<Integer> QUEUE = new ArrayList<>();
    final int SIZE = 10;

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Thread producer = new Thread(()-> producerConsumer.producer());
        Thread consumer = new Thread(()-> producerConsumer.consumer());

        producer.start();
        consumer.start();

        System.out.println("Main thread exiting...");

    }

    private void producer(){
        int number;
        while(true){
            synchronized (this){
                while(QUEUE.size()>=10){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                number = new Random().nextInt(50);
                QUEUE.add(number);
                System.out.println("Produced: "+number);
                sleep(500);
                notifyAll();
            }
        }
    }
    private void consumer(){
        int number;
        while(true){
            synchronized (this){
                while(QUEUE.size()==0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                number = QUEUE.getLast();
                QUEUE.remove(QUEUE.size()-1);
                System.out.println("Consumed: "+number);
                sleep(500);
                notifyAll();
            }
        }
    }

    private void sleep(long millisecond){
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
