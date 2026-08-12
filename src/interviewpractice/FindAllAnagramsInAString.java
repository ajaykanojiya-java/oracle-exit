package interviewpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//frequency pattern + window
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "bcbaebabacd";
        String p = "abc";
        System.out.println(findAnagram(s,p));
    }
    public static List<Integer> findAnagram(String s, String p){
        List<Integer> result = new ArrayList<>();
        if(s == null || p == null || s.length()<p.length())
            return result;

        int []sCount = new int[26];
        int []pCount = new int[26];

        for(int i=0;i<p.length();i++){
            sCount[s.charAt(i)-'a']++;
            pCount[p.charAt(i)-'a']++;
        }

        //early check
        if(Arrays.equals(sCount,pCount))
            result.add(0);

        int left = 0;
        int right = p.length();
       while(right<s.length()){
            //add the count for the char which is coming in
            sCount[s.charAt(right)-'a']++;
            //remove the count for the char which is going out
            sCount[s.charAt(left)-'a']--;

            if(Arrays.equals(sCount,pCount))
                result.add(left+1);
            right++;
            left++;
        }
       return result;
    }
}
