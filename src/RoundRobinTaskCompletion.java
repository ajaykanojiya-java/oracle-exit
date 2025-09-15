import java.util.Arrays;

public class RoundRobinTaskCompletion {

    public static void main(String[] args) {

        System.out.println("Otput: "+Math.abs(Integer.MIN_VALUE));
        int [] arr = {3,1,2};
        int[] completionTime = new int[arr.length];
        int elapsedTime=0;
        int length = arr.length;
        boolean pending = true;
        while(pending){
            pending = false;
            for(int i=0; i<length; i++) {
                if (arr[i] > 0) {
                    arr[i]--;
                    elapsedTime++;
                    pending = true;
                    //completionTime[i]!=0, otherwise it will override the entry for already completed task
                    if(arr[i]==0)
                        completionTime[i]=elapsedTime;
                }
            }
        }
        System.out.println("Time to finished: "+ Arrays.toString(completionTime));
    }

}
