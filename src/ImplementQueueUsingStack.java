import java.util.Stack;

public class ImplementQueueUsingStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enqueue(Integer number){
        s1.push(number);
    }

    public Integer dequeue(){
        if(s1.isEmpty() && s2.isEmpty())
            throw new RuntimeException("Queue is empty");
        if(s2.isEmpty()){
          while(!s1.isEmpty()){
              s2.push(s1.pop());
          }
        }
        return s2.pop();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStack queue = new ImplementQueueUsingStack();
        queue.enqueue(1);queue.enqueue(2);queue.enqueue(3);queue.enqueue(4);
        System.out.println(queue.dequeue());System.out.println(queue.dequeue());
        queue.enqueue(5);
        System.out.println(queue.dequeue());
    }
}
