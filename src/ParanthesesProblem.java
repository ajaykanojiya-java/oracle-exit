import java.util.Stack;

public class ParanthesesProblem {

    public static void main(String[] args) {
        String parantheses = "{[({)]}}";
        System.out.println("Is valid: "+isValidParantheses_arr(parantheses));
        System.out.println("Is valid: "+isValidParantheses_stack(parantheses));
    }

    public static boolean isValidParantheses_arr(String s){
        int length = s.length();
        char [] stack = new char[length];
        int top = -1;
        char c ;
        for (int i=0; i<length; i++){
            c = s.charAt(i);
            if (c=='(' || c=='{' || c=='['){
                stack[++top] = c;       //push into the stack
            } else{
                if(top == -1)
                    return false;
                char open = stack[top--]; //pop from stack
                if(c == ')' && open != '('
                        || c == '}' && open != '{'
                        || c == ']' && open != '[')
                   return false;
            }
        }
        return true;
    }

    public static boolean isValidParantheses_stack(String s){
        Stack<Character> stack = new Stack<>();
        Character c;
        for(int i=0; i<s.length(); i++){
            c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else{

                if((c == '}' || c== ']' || c == ')') && stack.isEmpty())
                    return false;
                Character open = stack.pop();
                if(c == ')' && open != '(' || c == '}' && open != '{' || c == ']' && open != '[')
                    return false;
            }
        }
        return true;
    }
}
