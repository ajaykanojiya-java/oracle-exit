import java.util.HashMap;
import java.util.Map;

/* First pass → Count occurrences of each character.
   Second pass → Return the first character with count = 1.
   This ensures O(n) time (linear scan twice) and O(1) space for ASCII (or O(k) for Unicode).*/
public class FirstNonRepeatingChar {

    final static String s = "bcabsdebc";

    public static void main(String[] args) {
        int count = 0;
        Map<Character,Integer> countMap = new HashMap<>();
        for(char c : s.toCharArray()){
            count = countMap.getOrDefault(c,0);
            countMap.put(c,count+1);
        }
        for(char c: s.toCharArray()){
            if(countMap.get(c)==1) {
                System.out.println("First non repeating char " + c);
                break;
            }
        }
    }

}
