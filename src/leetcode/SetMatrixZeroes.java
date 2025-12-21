package leetcode;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        int [][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();

        //initialize rowSet and columnSet to capture position of 0 in
        //specific row and column
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(rowSet.contains(i) || columnSet.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }

        //print the matrix in traditional way
        for (int[] row : matrix) { // Outer loop for rows
            for (int element : row) { // Inner loop for elements in a row
                System.out.print(element + " ");
            }
            System.out.println(); // New line after each row
        }
    }
}
