package leetcode;
/*
* A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
* non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
* Input: s = "A man, a plan, a canal: Panama"
* Output: true
* Explanation: "amanaplanacanalpanama" is a palindrome.*/
public class ValidPalindrom {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Is valid palindrom: "+isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        String validString = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        int length = validString.length();
        if(length == 1)
            return true;
        boolean result = true;
        for(int i=0;i<validString.length()/2;i++){
            if(validString.charAt(i)!=validString.charAt(length-1-i))
                result = false;
        }
        return result;
    }
}
