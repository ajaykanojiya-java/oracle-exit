package leetcode;
/*Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is
* missing from the array.
* Example 1:
* Input: nums = [3,0,1]
* Output: 2
* Example 2:
* Input: nums = [0,1] -->2
* n = 2 since there are 2 numbers, so all numbers are in the range [0,2].
*
* To solve the "Missing Number" problem in
* O(n) time and O(1) extra space, use a mathematical formula: The sum of numbers from 0 to n is n(n+1)/2
* Subtract the sum of the array from this total to get the missing number.
* */
public class MissingNumber {

    public static void main(String[] args) {
        int [] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println("Missing Number: "+missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
       int actualSum = 0;
       int expectedSum = nums.length * (nums.length+1)/2;
       for(int num: nums){
           actualSum = actualSum + num;
       }
       return expectedSum - actualSum;
    }
}
