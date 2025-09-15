import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeLinkedList1 {
    private final LinkedList<Integer> list = new LinkedList<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    // Adds an element to the end of the list
    public void add(Integer element) {
        lock.writeLock().lock();
        try {
            list.add(element);
        } finally {
            lock.writeLock().unlock();
        }
    }
    // Gets the element at a specified index
    public Integer get(int index) {
        lock.readLock().lock();
        try {
            return list.get(index);
        } finally {
            lock.readLock().unlock();
        }
    }

    // Removes an element at a specified index
    public Integer remove(int index) {
        lock.writeLock().lock();
        try {
            return list.remove(index);
        } finally {
            lock.writeLock().unlock();
        }
    }

    // Returns the size of the list
    public int size() {
        lock.readLock().lock();
        try {
            return list.size();
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeLinkedList1 obj = new ThreadSafeLinkedList1();

        Random random = new Random();
        Thread t1 = new Thread (()->{
            for (int i=0;i<10;i++)
                obj.list.add(random.nextInt(11));
        });

        Thread t2 = new Thread (()->{
            for (int i=0;i<10;i++)
                obj.list.remove(random.nextInt(11));
        });

        t1.join();
        t2.join();
        obj.list.stream().forEach(t->t.intValue());
    }

}
