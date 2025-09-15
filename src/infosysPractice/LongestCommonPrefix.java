package infosysPractice;

/*
* Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"
*
Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.*/

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String [] strings = new String[]{"flower","f","float"};
        System.out.println("Result: "+longestCommonPrefix(strings));
    }
    public static String longestCommonPrefix(String[] strs) {
        boolean flag = true;
        char c;
        int i = 0;
        StringBuilder prefix = new StringBuilder();
        while(flag && i< strs[0].length()) {
            c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length()>i && c == strs[j].charAt(i)) {
                   continue;
                }else{
                    flag = false;
                    break;
                }
            }
            i++;
            if (flag)
                prefix = prefix.append(c);
        }
        return prefix.toString();
    }
}
