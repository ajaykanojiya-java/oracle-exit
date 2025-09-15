
/*Longest Subarray with Sum Divisible by K
        Problem Statement:
        Given an array of integers arr[] and an integer K, find the length of the longest subarray whose sum is divisible by K.
        Example:
        Input: arr = [2, 7, 6, 1, 4, 5], K = 3
        Output: 4
        Explanation: The subarray [7, 6, 1, 4] has a sum of 18, which is divisible by 3.*/

public class LongestSubarraySumDivisibleByK {

    public static void main(String[] args) {
        int [] arr = {2, 7, 6, 1, 4, 5};
        int k = 3;
        int sum = 0,maxLength = 0;
        for(int i=0;i<arr.length;i++){
            sum = sum + arr[i];
            for(int j=i+1;j<arr.length;j++){
                sum = sum + arr[j];
                if(sum%k == 0){
                    maxLength = Math.max(maxLength,j-i+1);
                    System.out.println("indexes: "+i+" "+j);
                }
            }
            sum = 0;
        }
        System.out.println("Maxlength: "+maxLength);
    }

}
