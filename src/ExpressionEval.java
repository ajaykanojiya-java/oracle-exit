/*Given an expression string exp, write a program to examine whether the pairs and the orders of "{", "}", "(", ")", "[", "]"
are correct in exp.
        Example:
        Input: exp = "[()]{}{[()()]()}" Output: Balanced
        Input: exp = "[(])" Output: Not Balanced*/

import java.util.Stack;

public class ExpressionEval {

    public static void main(String[] args) {
        String exp = "[()]{}{[()()]()}";
        int length = exp.length();
        boolean isBalanced = true;
        Stack<Character>  stack = new Stack<>();
        for(int i=0;i<length;i++){
            char c = exp.charAt(i);
            if(c == '[' || c == '(' || c== '{') {
                stack.push(c);
            }else {
                if ((c == ']' || c == ')' || c == '}') && stack.isEmpty())
                    isBalanced = false;
                char open = stack.pop();
                if (c == ']' && open != '[' || c == '}' && open != '{' || c == ')' && open != '(')
                    isBalanced = false;
            }
        }
        if(isBalanced)
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }
}
