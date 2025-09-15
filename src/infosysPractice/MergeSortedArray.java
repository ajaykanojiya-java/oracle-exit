package infosysPractice;

public class MergeSortedArray {
    public static void main(String[] args) {

    }

    private static void mergeSortedArray(){
        int [] a = new int[]{1,2,3,0,0,0};
        int m = 3;
        int [] b = new int[]{2,5,6};
        int n= 3, index = 0,length = m+n;

        while(index<(m+n)){
            if(a[m-1] == b[n-1]){
                a[(length-1)-index] = a[(m-1)-index];
                index++;
                a[(length-1)-index] =
                m--;n--;
            }else if(a[m-1] > b[n-1]){
                a[length-1] = a[(m-1)-index];
            }else{
                a[length-1] = b[(n-1)-index];
            }
        }

    }
}
