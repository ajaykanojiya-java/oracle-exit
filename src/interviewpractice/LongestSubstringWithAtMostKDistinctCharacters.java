package interviewpractice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println("Ans: "+longestSubstring(s,k));
    }

    public static int longestSubstring(String s, int k){
        if(k == 0)
            return 0;
        int left = 0;
        int maxLength = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for(int right = 0;right<s.length();right++){
            char c = s.charAt(right);
            freq.put(c,freq.getOrDefault(c,0)+1);

            //remove the element from left, shrink the window
            while(freq.size() > k){
                char ch = s.charAt(left);
                //subtract the freq for the char which is going out
                freq.put(ch,freq.get(ch)-1);

                //remove the char which has 0 freq
                if(freq.get(ch) == 0)
                    freq.remove(ch);
                left++;
            }
            maxLength = Math.max(maxLength,right-left+1);

        }

        return maxLength;
    }
}
