package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
* Example 1:
* Input: nums = [3,2,3]-->3
*
* Example 2:
* Input: nums = [2,2,1,1,1,2,2]-->2
* Output: 2
* */
public class MajorityNumber {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println("Majority Element: "+majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int majorityNumber = 0;
        for (int num : nums) {
            count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
            if (count > nums.length / 2) {
                majorityNumber = num;
                break;
            }
        }
        return majorityNumber;
    }
}
