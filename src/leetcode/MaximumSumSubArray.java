package leetcode;
/*
* Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

* Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.*/
public class MaximumSumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,-1};
        System.out.println("Max Sum of Sub Array: "+maxSubArray(nums));
    }

    public static int maxSubArray(int [] nums){
        int currSum = 0, maxSum = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            if(currSum < 0)
                currSum = nums[i];
            else
                currSum = currSum + nums[i];
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}
