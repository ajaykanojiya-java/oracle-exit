package interviewpractice;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "swiss";
        System.out.println("Answer: "+findChar(s));
    }

    public static char findChar(String s){
        if(s.isBlank())
            return '\0';
        if(s.length() == 1)
            return s.charAt(0);
        int []freq = new int[26];
        for(char c: s.toCharArray())
            freq[c-'a']++;
        for(char c: s.toCharArray()){
            if(freq[c-'a'] == 1)
                return c;
        }
        return '\0';
    }
}
