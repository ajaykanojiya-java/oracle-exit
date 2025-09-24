package infosysPractice;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        mergeSortedArray();
    }

    private static void mergeSortedArray(){
        int [] a = new int[]{1,2,3,0,0,0,0};
        int [] b = new int[]{2,4,5,6};
        int m = 3, n = 4;
        int aIndex = 0, bIndex = 0;

        for(int i = 0; i < m+n; i++){
            if(bIndex < n){
                if(a[m-1-aIndex]>b[n-1-bIndex]){
                    a[m+n-1-i] = a[m-1-aIndex];
                    aIndex++;
                }
                else{
                    a[m+n-1-i] = b[n-1-bIndex];
                    bIndex++;
                }
            }
        }
        System.out.println("Final Array: ");
        Arrays.stream(a).forEach(System.out::println);

    }
}
