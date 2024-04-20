package com.ngumba.february;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    //optimal solution
    //Time complexity: O(1)
    //Space complexity: O(1)
    public static boolean isValidSudokuI(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.') {
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //brute force
    //Time complexity: O(n^2)
    //Space complexity: O(n^2)
    public static boolean isValidSudokuII(char[][] board) {
        int[][] left = new int[9][9];
        int[][] right = new int[9][9];
        int[][] box = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';

                if (left[i][num - 1] == 1) {
                    return false;
                }
                if (right[j][num - 1] == 1) {
                    return false;
                }
                if (box[3 * (i / 3) + (j / 3)][num - 1] == 1) {
                    return false;
                }
                left[i][num - 1] = 1;
                right[j][num - 1] = 1;
                box[3 * (i / 3) + (j / 3)][num - 1] = 1;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidSudokuI(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));

    }


}
