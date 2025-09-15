package leetcode;

public class LongestPalindromSubstring {

    public static void main(String[] args) {
        String s = "cbbd";
        String result = findLongestPalindromSubstring(s);
        System.out.println("Result: "+result);
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
}
