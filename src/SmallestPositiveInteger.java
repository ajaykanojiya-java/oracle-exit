import java.util.HashSet;
import java.util.Set;

/*Compilation successful.
        Example test:   [1, 3, 6, 4, 1, 2]
        ANSWER 5
        Example test:   [1, 2, 3]
        ANSWER 4
        Example test:   [-1, -3]
        ANSWER expected 1.*/

public class SmallestPositiveInteger {

    public static void main(String[] args) {
        int [] A = {-1,-3,1,6,4,8,3,2,};
        System.out.println("Answer: "+solution(A));

    }

        public static int solution(int[] A) {
            // Implement your solution here
            Set<Integer> set = new HashSet<>();
            int result = Integer.MAX_VALUE;
            for (int i=0;i<A.length; i++){
                if(A[i]>=0) {
                    set.add(A[i]);
                    result = Math.min(result,A[i]);
                }
            }
            return result;
        }
}
