package leetcode;
/*
* Input: height = [1,8,6,2,5,4,8,3,7]
* Output: 49
* Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
* In this case, the max area of water (blue section) the container can contain is 49.*/
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("Container with most water: "+maxArea(height));
    }

    public static int maxArea(int[] height) {
        int area = 0,maxArea = 0;
        int left = 0, right = height.length-1;

        while(left<right){
            area = Math.min(height[left],height[right]) * (right - left);
            maxArea = Math.max(area,maxArea);
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
