import java.util.HashMap;
import java.util.Map;

/*
* input [5,10,11,17,19]
* target sum = 28
* */
public class TwoSumTarget {
    public static void main(String[] args) {
        int [] input = {5,10,11,17,19};
        int targetSum = 15;
        int[] result = findTargetSumNumbers(targetSum,input);
        System.out.println("Target sum array: "+result[0]+" "+result[1]);
    }

    private static int[] findTargetSumNumbers(int targetSum, int[] array){
        Map<Integer,Integer> complementMap = new HashMap<>();

        for (int i =0; i<array.length; i++){
            Integer complementIndex = complementMap.get(array[i]);
            if(complementIndex!=null) {
                return new int[]{i, complementIndex};
            }
            complementMap.put(Math.abs(targetSum-array[i]),i);
            }
        return new int[]{0,0};
        }

    }

