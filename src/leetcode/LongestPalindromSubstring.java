package leetcode;

public class LongestPalindromSubstring {

    public static void main(String[] args) {
        String s = "cbbd";
        String result = findLongestPalindromSubstring(s);
        System.out.println("Result: "+result);

        System.out.println("Example 1: " + longestPalindrome("babad")); // "bab" or "aba"

    }
    public static String findLongestPalindromSubstring(String s){

        if(s.length() == 1){
            return s;
        }
        else if(s.length() == 2 && s.charAt(0) == s.charAt(1)){
            return s;
        }else{
            String subString = "";
            String longestSubstring = "";
            for(int i=0;i<s.length();i++){
                for(int j=i+1;j<s.length();j++){
                    subString = s.substring(i,j+1);
                    if(s.charAt(i) == s.charAt(j) && isPalindrom(subString)){
                        if(subString.length()>longestSubstring.length()){
                            longestSubstring = subString;
                        }
                    }
                }
            }
            return longestSubstring;
        }
    }

    public static boolean isPalindrom(String s){
        int left=0,right=s.length();
        while(left<right){
            if(s.charAt(left)!=s.charAt(right-1))
                return false;
            left++;right--;
        }
        return true;
    }


    // Expand around the center and return palindrome length
    private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // length of palindrome
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);     // odd length
            int len2 = expandFromCenter(s, i, i + 1); // even length
            int len = Math.max(len1, len2);

            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

}
