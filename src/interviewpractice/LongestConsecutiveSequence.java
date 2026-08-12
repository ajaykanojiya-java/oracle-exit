package interviewpractice;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int [] arr = new int[]{100, 4, 200, 1, 3, 2};
        //output 4 --> 1,2,3,4
        System.out.println("Ans: "+findLongestConsecutiveSeq(arr));
    }

    public static int findLongestConsecutiveSeq(int [] arr){
        Set<Integer> set = new HashSet<>();

        // 1. Insert all elements into a HashSet
        for(int num : arr)
            set.add(num);

        int longestSeq = 0;
        int currentStreak = 0;
        int nextNumber;

        // 2. Iterate through each number to find sequences
        for(int num: arr){
            // Check if 'num' is the start of a sequence
            if(!set.contains(num-1)){
                currentStreak++;
                nextNumber = num+1;
                // Expand the sequence forward
                while(set.contains(nextNumber)){
                    nextNumber++;
                    currentStreak++;
                }
                longestSeq = Math.max(currentStreak,longestSeq);
                currentStreak = 0;
            }
        }
        return longestSeq;
    }
}
