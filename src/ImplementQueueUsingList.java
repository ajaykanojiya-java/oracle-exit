import java.util.ArrayList;
import java.util.List;

public class ImplementQueueUsingList<T> {

    List<T> queue = new ArrayList<>();

    public void enqueue(T t){
        queue.add(t);
    }

    public T dequeue(){
        if(queue.isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        return queue.remove(0);
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public Integer size(){
        return queue.size();
    }

    public static void main(String[] args) {
        ImplementQueueUsingList<Integer> queue = new ImplementQueueUsingList();
        queue.enqueue(1);queue.enqueue(2);queue.enqueue(3);queue.enqueue(4);
        System.out.println(queue.dequeue());System.out.println(queue.dequeue());
    }
}
