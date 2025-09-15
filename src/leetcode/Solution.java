package leetcode;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'compareTriplets' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        List<Integer> rating = new ArrayList<>();
        int length = Math.min(a.size(),b.size());
        for(int i =0;i<length;i++){
            if(a.get(i)>b.get(i))
                rating.set(0, rating.get(0)+1);
            else if(a.get(i)<b.get(i))
                rating.set(1, rating.get(1)+1);

        }
        return rating;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        List<Integer> a = List.of(3,2,4);
        List<Integer> b = List.of(1,5,3);
        List<Integer> result = Result.compareTriplets(a, b);


    }
}
