package interviewpractice;

public class StringCompression {
    public static void main(String[] args) {
        String s = "aaabbccccd";
        //output a3b2c4d1
        System.out.println("ans:"+compress(s));
    }

    public static String compress(String s){
        if(s.isBlank())
            return s;

        int count = 1;
        StringBuilder result = new StringBuilder();
        for(int i=1;i<=s.length();i++){
            if(i<s.length() && s.charAt(i) == s.charAt(i-1)){
                count++;
            }else{
                result.append(s.charAt(i-1)).append(count);
                count = 1;
            }
        }
        return result.toString();
    }
}
