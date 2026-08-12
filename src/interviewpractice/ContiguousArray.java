package interviewpractice;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static void main(String[] args) {
        int [] arr = new int [] {0,1,0,1,1,1,0};
        System.out.println("Length: "+findContigiousArrayLengh(arr));
    }

    public static int findContigiousArrayLengh(int []arr){
        Map<Integer,Integer> prefixSumIndex = new HashMap<>();
        int length = 0;
        int maxLength = 0;
        int sum = 0;

        prefixSumIndex.put(0,-1);
        for(int i=0; i<arr.length; i++){
            int num = arr[i];
            // Apply the trick: treat 0 as -1, treat 1 as +1
            if(num == 0)
                sum = sum - 1;
            else
                sum = sum + 1;

            // If this sum has been seen before, we found a balanced subarray
            if(prefixSumIndex.containsKey(sum)){
                length = i - prefixSumIndex.get(sum);
                maxLength = Math.max(length,maxLength);
            }else{
                // Only store the first occurrence to maximize subarray length
                prefixSumIndex.put(sum,i);
            }
        }
        return maxLength;
    }
}
