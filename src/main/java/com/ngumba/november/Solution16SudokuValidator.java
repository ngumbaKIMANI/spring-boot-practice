package com.ngumba.november;

import java.util.HashSet;
import java.util.Set;

public class Solution16SudokuValidator {

    public static boolean isValidSudoku(char[][] board) {
        // Check each row and column
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i) || !isValidColumn(board, i)) {
                return false;
            }
        }

        // Check each 3x3 subgrid
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidSubgrid(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValidRow(char[][] board, int row) {
        HashSet<Character> set = new HashSet<>();
        for (int col = 0; col < 9; col++) {
            char current = board[row][col];
            if (current != '.' && !set.add(current)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidColumn(char[][] board, int col) {
        HashSet<Character> set = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            char current = board[row][col];
            if (current != '.' && !set.add(current)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidSubgrid(char[][] board, int startRow, int startCol) {
        HashSet<Character> set = new HashSet<>();
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                char current = board[i][j];
                if (current != '.' && !set.add(current)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static  boolean solution(char[][] grid) {
        int n = grid.length;

        Set<String> set = new HashSet<String>();

        for (int row = 0; row < n ; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] != '.' && !set.add(grid[row][col] + " in row " + row))
                    return false;
                if (grid[row][col] != '.' && !set.add(grid[row][col] + " in col " + col))
                    return false;
                if (grid[row][col] != '.' && !set.add(grid[row][col] + " in square " + row/3 + " " + col/3))
                    return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        char[][] grid1 = {
                {'.', '.', '.', '1', '4', '.', '.', '2', '.'},
                {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
                {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
                {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
                {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '7', '.'}
        };
        System.out.println(isValidSudoku(grid1));  // Output: true
        System.out.println(solution(grid1));

        char[][] grid2 = {
                {'.', '.', '.', '.', '2', '.', '.', '9', '.'},
                {'.', '.', '.', '.', '6', '.', '.', '.', '.'},
                {'7', '1', '.', '.', '7', '5', '.', '.', '.'},
                {'.', '7', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '8', '3', '.', '.', '.'},
                {'.', '.', '8', '.', '.', '7', '.', '6', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '1', '.', '2', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '.', '3', '.', '.', '.', '.'}
        };
        System.out.println(isValidSudoku(grid2));  // Output: false
        System.out.println(solution(grid2));


    }
}
