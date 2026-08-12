package interviewpractice;

public class CharacterFrequency {
    public static void main(String[] args) {
        String s = "listen";
        String t = "silent";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t){

        if(s.length() != t.length())
            return false;

        int [] freq = new int[26];
        for(char c: s.toCharArray())
            freq[c-'a']++;

        for(char c: t.toCharArray())
            freq[c-'a']--;

        for(int count : freq){
            if(count !=0)
                return false;
        }
        return true;
    }
}
