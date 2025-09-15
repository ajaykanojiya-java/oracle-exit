import java.util.Arrays;

//Rotate an array by k steps (in-place).
public class RotateArrayByKStep {

    public static void main(String[] args) {
        int [] num = {1,2,3,4,5,6,7};
        int k = 3; //rotate k times
        System.out.println("Initial Array: "+Arrays.toString(num));
        num = rotate(num,k);
        System.out.println("Final Rotated Array: "+Arrays.toString(num));
    }

    public static int[] rotate(int [] num, int k){
        int n = num.length;
        num = reverse(num,0,n-1); //rotate entire array
        System.out.println("Rotated entire Array: "+Arrays.toString(num));
        num = reverse(num,0,k-1); //rotate first half
        System.out.println("Rotated first half: "+Arrays.toString(num));
        num = reverse(num,k,n-1); //rotate second half
        System.out.println("Rotated second half: "+Arrays.toString(num));
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
