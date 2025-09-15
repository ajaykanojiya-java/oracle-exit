public class KadanesAlgorithmWithSubarray {

    public static void maxSubArray(int[] arr) {
        int currentSum = arr[0];
        int maxSum = arr[0];

        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < arr.length; i++) {
            // Decide whether to start a new subarray or extend
            if (arr[i] > currentSum + arr[i]) {
                currentSum = arr[i];
                tempStart = i;   // start new subarray
            } else {
                currentSum += arr[i]; // extend
            }

            // Update max sum and indices
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        // Print result
        System.out.println("Maximum Subarray Sum = " + maxSum);
        System.out.print("Subarray = [ ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        maxSubArray(arr);
    }
}
