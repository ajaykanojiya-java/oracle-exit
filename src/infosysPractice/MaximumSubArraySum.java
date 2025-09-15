package infosysPractice;


/*
arr = [-2, -3, 4, -1, -2, 1, 5, -3]
Output: 7
Explanation → [4, -1, -2, 1, 5] has sum = 7
*/
public class MaximumSubArraySum {
    public static void main(String[] args) {
        int [] num = new int[]{-2, -3, -4, -1, -2, -1, 5, -3};
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

}
