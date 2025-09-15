package infosysPractice;

import java.util.Arrays;

//s = "  Infosys   is   hiring ";
//output: "hiring is Infosys"
public class ReverseWordInString {

    public static void main(String[] args) {
        String s = "  Infosys   is   hiring ";
        String[] subStrings = s.trim().split("\\s ");
        StringBuilder stringBuilder = new StringBuilder();
        int length = subStrings.length;
        for(int i=0; i<subStrings.length;i++){
            stringBuilder = stringBuilder.append(subStrings[length-1-i]).append(" ");
        }
        System.out.println("Output: "+stringBuilder.toString());
    }
}
