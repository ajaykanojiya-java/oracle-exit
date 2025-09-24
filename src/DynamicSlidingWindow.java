import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//find out the length of the longest unique substring
public class DynamicSlidingWindow {

    public static void main(String[] args) {
        String s = "abccbdbacbc";
        System.out.println("Maximum Length: "+maxLengthOfUniqueChar(s));
        String s1 = " ";
        System.out.println("Test Length: "+s1.length()+" isEmpty() "+s1.isEmpty()+" isBlank() "+s1.isBlank());
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

    }
    public static int maxLengthOfUniqueChar(String s){
        int left = 0,right,maxLength = 0;
        String subString = "";
        Set<Character> seen = new HashSet<>();

        boolean flag = true;
        for(right = 0; right < s.length();right++){
            //if duplicate is found then shrink the window else expand the window
            while(seen.contains(s.charAt(right))){
                //if duplicate is found then capture the substring before adding duplicate char
                if(flag && subString.length() < s.substring(left,right).length()){
                    subString = s.substring(left,right);
                    flag = false; //setting false so that it should not override captured substring.
                }
                seen.remove(s.charAt(left));
                left++; //shrinking window from left
            }
            flag = true; //setting it to true so that it should capture the substring
            seen.add(s.charAt(right));
            maxLength = Math.max(maxLength,right-left+1);
        }
        System.out.println("Longest Substring "+subString);
        return maxLength;
    }
}
