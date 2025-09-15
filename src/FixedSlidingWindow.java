import java.util.Arrays;

public class FixedSlidingWindow {

    public static void main(String[] args) {
        int [] arr = {-5,12,5,-6,5,1};
        findMaxSum(arr,4);

    }

    public static void findMaxSum(int [] num, int k){
        int sum = 0, maxSum = 0,startIndex = 0,endIndex = 0;
        for (int i = 0;i<k; i++){
            sum = sum + num[i];
        }
        maxSum = sum;

        for (int i = 0;i<num.length-k;i++){
            sum = sum - num[i]; //removing element which is going out
            sum = sum + num[k+i]; //adding element which is entering
            if(sum>maxSum){
                endIndex = k+i;
                maxSum = sum;
            }
            startIndex = i;
        }
        System.out.println("Max Sum: "+maxSum+" for array: "+startIndex+" "+endIndex+" "
                + Arrays.toString(Arrays.copyOfRange(num,startIndex,endIndex)));

    }
}
