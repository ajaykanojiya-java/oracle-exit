import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

//abcdabcab
//a, b, c, d, e, f, g, h, i, j,
public class ToucanInterview {

    public static void main(String[] args) {

       List<Character> charList = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j')) ;
       Iterator itr = charList.listIterator();
       int counter = 0;
       //charList.forEach(System.out::print);
        boolean flag = false;
       for(int i=0; i<charList.size();i++){
           if(flag){
               //System.out.println(charList.get(i));
               charList.remove(i);
               flag = false;
           }else {
               flag = true;
           }
       }
        System.out.println("----------------");
       charList.forEach(System.out::println);

/*       while(itr.hasNext() && counter < charList.size()){
           if(counter%2==0){
               System.out.println(charList.get(counter));
               charList.remove(counter);
           }
           counter++ ;
       }
       charList.forEach(System.out::println);*/
    }

    public static void test(){
        String s = "abcdabcab";
        int left =0,right=0,length=0,maxLength=0;
        Set<Character> set = new HashSet<>();
        length = s.length();
        String substring = "",maxSubString = "";
        boolean flag = false;
        for(right=0;right<length;right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength,right-left+1);
            substring = s.substring(left,right+1);

            if(substring.length()>maxSubString.length()){
                maxSubString = substring;
            }
        }
        System.out.println("Max Length: "+maxLength+" Substring: "+maxSubString);
    }
}
