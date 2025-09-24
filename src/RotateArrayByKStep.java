import java.util.Arrays;

//Rotate an array by k steps (in-place).
public class RotateArrayByKStep {
    public static void main(String[] args) {
        int [] num = {1,2,3,4,5,6,7};
        int k = 3; //rotate k times
        num = rotate(num,k);
        System.out.println("Final Rotated Array: "+Arrays.toString(num));
    }
    public static int[] rotate(int [] num, int k){
        int n = num.length;
        //rotate entire array
        num = reverse(num,0,n-1); //rotate entire array
        //rotate first half array
        num = reverse(num,0,k-1); //rotate first half
        //rotate second half array
        num = reverse(num,k,n-1); //rotate second half
        return num;
    }
    public static int[] reverse(int [] num, int start, int end){
        int tmp;
        while(start<end){
            tmp = num[start];
            num[start] = num[end];
            num[end] = tmp;
            start++;
            end--;
        }
        return num;
    }
}
