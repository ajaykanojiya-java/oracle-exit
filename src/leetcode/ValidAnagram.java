package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println("Is Anagram: "+isAnagram(s,t));
    }
    public static boolean isAnagram(String s, String t) {
        Map<Character,Integer> count = new HashMap<>();

        //if different length then return false
        if(s.length() != t.length())
            return false;

        //increment count for s and decrement count for t in the map
        for(int i=0;i<s.length();i++){
            count.put(s.charAt(i),count.getOrDefault(s.charAt(i),0) +1);
            count.put(t.charAt(i),count.getOrDefault(t.charAt(i),0) -1);
        }
        //if counts are not zero, string is not anagram
        for(int value: count.values()){
            if(value!=0)
                return false;
        }
        return true;
    }
}
