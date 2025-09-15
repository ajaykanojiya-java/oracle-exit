package infosysPractice;

/*Input: height = [1,8,6,2,5,4,8,3,7]
   Output: 49
   Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
   In this case, the max area of water (blue section) the container can contain is 49.
*/
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int [] height = new int[]{1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea(height);
        System.out.println("Max Area: "+maxArea);
    }

    public static int maxArea(int[] height) {
        int length = height.length;

        if (length == 0 || length == 1)
            return 0;
        if (length == 2)
            return Math.min(height[0], height[1]);

        int left = 0, right = length - 1;
        int area = 0, maxArea = 0;
        while (left < right) {
            area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(area, maxArea);
            if (height[left]<height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
