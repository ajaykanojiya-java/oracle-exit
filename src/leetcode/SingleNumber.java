package leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
* You must implement a solution with a linear runtime complexity and use only constant extra space.
* Input: nums = [2,2,1]
* Output: 1
*
* Input: nums = [4,1,2,1,2]
* Output: 4
* */
public class SingleNumber {

    public static void main(String[] args) {
        int [] nums = {4,1,2,1,2};
        System.out.println("Single Number: "+singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num; // XOR operation
        }
        return result;
    }

    public static int singleNumberStepsForUnderstanding(int[] nums) {
        int result = 0;
        for (int num : nums) {
            System.out.printf("before: %d (%s), num: %d (%s) -> ",
                    result, Integer.toBinaryString(result), num, Integer.toBinaryString(num));
            result ^= num;
            System.out.printf("after: %d (%s)%n", result, Integer.toBinaryString(result));
        }
        return result;
    }

}
