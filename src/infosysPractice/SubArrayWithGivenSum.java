package infosysPractice;

import java.util.HashMap;
import java.util.Map;

/*arr = [1, 4, 20, 3, 10, 5]
        target = 33*/
public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        findSubArrayWithGivenSum_me();
        findSubArrayWithGivenSum_GPT();
    }

    private static void findSubArrayWithGivenSum_GPT() {
        int [] num = new int[]{1, 4, 5, 20, 3, 10, 5};
        int targetSum = 33;
        Map<Integer,Integer> map = new HashMap<>();

    }

    private static void findSubArrayWithGivenSum_me() {
        int [] num = new int[]{1, 4, 5, 20, 3, 10, 5};
        int targetSum = 33;
        int sum =0;
        for(int i=0;i<num.length;i++){
            sum = num[i];
            for(int j=i+1;j<num.length;j++){
                sum = sum + num[j];
                if(sum == targetSum){
                    System.out.println("Max sub array: "+i+", "+j);
                    break;
                }
            }
        }
    }
}
