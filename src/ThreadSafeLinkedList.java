import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;


//wrong program, I had to create separate classes for producer and consumer.
public class ThreadSafeLinkedList implements Runnable{

    private List<Integer> data = new ArrayList<>();
    private final int LIMIT = 10;
    @Override
    public void run() {
        Random random = new Random();
        for (int i =0; i <5;i++){
            produceData(random.nextInt(11));
            consumeData(random.nextInt(11));
        }
    }

    private void produceData(int value){
        System.out.println("waiting to produce: "+value);
        synchronized (data){
            if (data.size() == LIMIT) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else{
                data.add(value);
                System.out.println("Added data "+value);
                notifyAll();
            }
        }
    }

    private void consumeData(int value) {
        System.out.println("Waiting to consume: "+value);
        synchronized (data){
            if(data.size() == 0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else{
                data.remove(value);
                System.out.println("Consumed data: "+value);
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        ThreadSafeLinkedList list = new ThreadSafeLinkedList();
        Random random = new Random();
        Thread producer = new Thread(list);
        Thread consumer = new Thread(list);
        producer.start();
        consumer.start();
    }
}
