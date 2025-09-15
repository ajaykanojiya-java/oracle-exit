import java.util.ArrayList;
import java.util.List;

public class ImplementStack<T> {

    List<T> list = new ArrayList<>();

    public void push(T number){
        list.add(number);
    }

    public T pop(){
        //if(!list.isEmpty())
            return list.remove(list.size()-1);
    }

    public T peek(){
        //if(!list.isEmpty())
            return list.get(list.size()-1);

    }

    public Integer size(){
        return list.size();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStack<Integer> stack = new ImplementStack<>();
        stack.push(1);stack.push(2);stack.push(3);stack.push(4);stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }

}
