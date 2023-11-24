package com.ngumba.november;

public class DS3Patterns {
    public static void main(String[] args) {
        pattern1(4);
        pattern2(4);
        pattern3(4);
        pattern4(4);
        pattern5(4);
        pattern6(4);

    }

    public static void pattern1(int n) {
        System.out.println("Pattern 1");
        //rows
        for (int row = 1; row <= n; row++) {
            //cols
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern2(int n) {
        System.out.println("Pattern 2");
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern3(int n) {
        System.out.println("Pattern 3");
        for (int row = 1; row <= n; row++) {
            for (int col = n; col >= row; col--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern4(int n) {
        System.out.println("Pattern 4");
        for (int row = 1; row < n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static void pattern5(int n) {
        System.out.println("Pattern 5");
        for (int row = 1; row <= (n * 2) - 1; row++) {
            int varCol = (row > n) ? (n * 2 - row) : row;
            for (int col = 1; col <= varCol; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static void pattern6(int n) {
        System.out.println("Pattern 6");
        for (int row = 1; row <= (n * 2) - 1; row++) {

            int varCol = (row > n) ? (n * 2 - row) : row;

            int noOfSpaces = n - varCol;
            for (int i = 1; i <= noOfSpaces; i++) {
                System.out.print(" ");
            }

            for (int col = 1; col <= varCol; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (checkWord(i, j, board, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean checkWord(int i, int j, char[][] board, String word, int index) {
            if (index == word.length()) {
                return true;
            }

            int m = board.length;
            int n = board[0].length;

            if (i < 0 || i >= m || j < 0 || j >= n ||
                    board[i][j] != word.charAt(index)) {
                return false;
            }

            char temp = board[i][j];
            board[i][j] = ' ';

            boolean found =
                    checkWord(i + 1, j, board, word, index + 1) || checkWord(i - 1, j, board, word, index + 1) ||
                            checkWord(i, j + 1, board, word, index + 1) || checkWord(i, j - 1, board, word, index + 1);

            board[i][j] = temp;

            return found;

        }
    }


}
