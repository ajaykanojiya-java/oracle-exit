package interviewpractice;

import java.util.HashMap;
import java.util.Map;

/*
Time Complexity: (O(n)). We traverse the array exactly once, performing (O(1)) amortised hash map searches.
Space Complexity: (O(n)). In the worst case, every single prefix sum value is completely unique, requiring (O(n))
storage space in the map.
 */
public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int [] arr = new int[]{10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println("Longest Subarray: "+findLongestSubArray(arr,k));
    }

    public static int findLongestSubArray(int []arr, int k){
        // Map to store: [Prefix Sum -> Earliest Index where it appeared]
        Map<Integer,Integer> prefixSumIndex = new HashMap<>();
        int currentSum = 0;
        int subarrayLength = 0;
        int maxLength = 0;

        // Base case: A prefix sum of 0 happens before the array starts (index -1)
        prefixSumIndex.put(0,-1);

        for(int i=0;i<arr.length;i++){
            currentSum = currentSum + arr[i];

            // If (currentSum - k) exists, a valid subarray ends at index i
            if(prefixSumIndex.containsKey(currentSum - k)){
                subarrayLength = i - prefixSumIndex.get(currentSum - k);
                maxLength = Math.max(subarrayLength,maxLength);
            }

            // CRITICAL STEP: Only add the sum if it DOES NOT already exist.
            // This preserves the earliest index to ensure maximum subarray length.
            if(!prefixSumIndex.containsKey(currentSum - k)){
                prefixSumIndex.put(currentSum,i);
            }
        }
        return maxLength;
    }
}
