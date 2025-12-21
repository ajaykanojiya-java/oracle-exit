package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        final char[][] validBoard = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'3','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println("Is Valid sudoku "+isValidSudoku(validBoard));
    }

    public static boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<String>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char number = board[i][j];
                if(number != '.'){
                    if(!seen.add(number+" in row "+i) ||
                        !seen.add(number+" in column "+j) ||
                        !seen.add(number+" in submatrix "+i/3+"-"+j/3)){
                            return false;
                    }
                }
            }
        }
        return true;
    }
}
