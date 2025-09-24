package infosysPractice;


/*
arr = [-2, -3, 4, -1, -2, 1, 5, -3]
Output: 7
Explanation → [4, -1, -2, 1, 5] has sum = 7
*/
public class MaximumSubArraySum {
    public static void main(String[] args) {
        int [] num = new int[]{-2, -3, -4, -1, -2, 1, 5, -3};
        findMaximuSubArraySum(num);
        System.out.println("\nMaxSum: "+maxSubArray(num));

    }

    private static void findMaximuSubArraySum(int [] num) {

        int maxSum = 0, startIndex = -1, endIndex = -1;
        int sum = 0,countPositiveNumber = 0;
        for(int i=0;i<num.length;i++){
            sum = num[i];
            if(num[i]>0)
                countPositiveNumber++;
            for(int j=i+1;j<num.length;j++){
                sum = sum + num[j];
                if (sum>maxSum){
                    maxSum = sum;
                    startIndex = i;
                    endIndex = j;
                }
            }
            sum = 0;
        }
        if(countPositiveNumber > 1)
            System.out.println("Max Sum: "+maxSum+" index: "+startIndex+", "+endIndex);
        else
            System.out.println("Max Sum: "+num[endIndex]+" index: -1"+", "+endIndex);
    }


    public static int maxSubArray(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // Either start new subarray at arr[i] or extend previous one
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);

            // Update result if needed
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

}
