package interviewpractice;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int [] nums = new int[]{3, 4, -2, 2, 1};
        int k = 5;
        System.out.println("Number of Subarray: "+findSubArray(nums,k));
    }

    public static int findSubArray(int []nums, int k){
        // Map to store: [Prefix Sum -> Number of times it has occurred]
        Map<Integer,Integer> prefixSumFreq  = new HashMap<>();

        // Base case: An empty subarray has a sum of 0, occurring once
        prefixSumFreq .put(0,1);

        int currentSum = 0;
        int totalSubArray = 0;

        for(int num: nums){
            currentSum = currentSum + num;

            // If (currentSum - k) exists in the history, we found valid subarrays
            if(prefixSumFreq .containsKey(currentSum-k)){
                totalSubArray = totalSubArray + prefixSumFreq.get(currentSum - k);
            }
            // Record the current prefix sum into the map
            prefixSumFreq .put(currentSum,prefixSumFreq .getOrDefault(currentSum,0)+1);
        }
        return totalSubArray;
    }
}
