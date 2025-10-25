
/*
* Context:
* George is a software developer who is analyzing customer purchase patterns.
* He has a list of purchase amounts for N customers (array A[]).
* He needs to:
* 1. Find the largest contiguous increasing subarray.
* 2. Find the largest contiguous decreasing subarray.
* 3. Then, find the maximum length between these two (increasing vs decreasing).
*
* N = 6
 * A = [10, 20, 30, 25, 20, 10]
* Increasing subarray: [10, 20, 30] → length = 3
* Decreasing subarray: [30, 25, 20, 10] → length = 4
* Maximum length between them = max(3, 4) = 4*/

public class MaxLengthIncreasingDecreasingSubArray {

    public static void main(String[] args) {
        int input1 = 6;
        int[] input2 = {10, 20, 30, 25, 20, 10};
        int maxLength = maximumLength(input1,input2);
        System.out.println("Max Length between increasing and decreasing sub array: "+maxLength);
    }

    public static int maximumLength(int input1, int[] input2) {
        int maxInc = 1, maxDec = 1;
        int inc = 1, dec = 1;

        for (int i = 1; i < input1; i++) {
            if (input2[i] > input2[i - 1]) {
                inc++;
                dec = 1;
            } else if (input2[i] < input2[i - 1]) {
                dec++;
                inc = 1;
            } else {
                inc = 1;
                dec = 1;
            }

            maxInc = Math.max(maxInc, inc);
            maxDec = Math.max(maxDec, dec);
        }

        return Math.max(maxInc, maxDec);
    }
}
