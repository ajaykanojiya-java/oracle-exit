package interviewpractice;

public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        String s = "abbaca";
        //output: "ca"
        System.out.println("Ans: "+removeDuplicate(s));
    }

    public static String removeDuplicate(String s){
        if(s.isBlank())
            return s;

        StringBuilder stack = new StringBuilder();
        int count = 0;
        for(char c: s.toCharArray()){
            if(count > 0 && stack.charAt(count-1) == c){
                stack.deleteCharAt(count-1);
                count--;
            }else{
                stack.append(c);
                count++;
            }
        }
        return stack.toString();
    }
}
