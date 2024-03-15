package com.ngumba.november;

public class MatrixPatterns {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        // pattern1(matrix);
        //pattern2(matrix);
        //pattern3(matrix);
        //pattern4(matrix);
        pattern5(matrix);
        pattern6(matrix);
        printOuterRowAndColumn(matrix);
        printXShape(matrix);
        printSShape(matrix);
        printLShape(matrix);
        printUShape(matrix);

    }

    public static void pattern1(int[][] matrix) {
        int N = matrix.length;
        System.out.println("Pattern 1");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("  " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void pattern2(int[][] matrix) {
        int N = matrix.length;
        System.out.println("Pattern 2");
        //M
        for (int i = 0; i < N; i++) {
            //N
            for (int j = 0; j <= i; j++) {
                System.out.print("  " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void pattern3(int[][] matrix) {
        int N = matrix.length;
        System.out.println("Pattern 3");
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j >= i; j--) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void pattern4(int[][] matrix) {
        int N = matrix.length;
        System.out.println("Pattern 4");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void pattern5(int[][] matrix) {
        int N = matrix.length;
        System.out.println("Pattern 5");
        for (int i = 0; i <= (N * 2) - 1; i++) {

            int varCol = (i >= N) ? (2 * N - i - 1) : i;

            for (int j = 0; j <= varCol; j++) {
                System.out.print(matrix[varCol - j][j] + " ");
            }

            System.out.println();
        }
    }

    public static void pattern6(int[][] matrix) {
        int N = matrix.length;
        System.out.println("Pattern 6");
        for (int i = 1; i <= (N * 2) - 1; i++) {

            int varCol = (i > N) ? (N * 2 - i) : i;

            int noOfSpaces = N - varCol;
            for (int j = 1; j <= noOfSpaces; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= varCol; k++) {
                System.out.print(matrix[varCol - 1][k - 1] + " ");
            }
            System.out.println();
        }
    }

    public static void printOuterRowAndColumn(int[][] matrix) {
        System.out.println("______Box");
        int M = matrix.length;
        int N = matrix[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || i == M - 1 || j == 0 || j == N - 1) {
                    System.out.print(matrix[i][j] + " ");
                } else {
                    System.out.print("  "); // Print blank space for inner elements
                }
            }
            System.out.println();
        }
    }

    public static void printXShape(int[][] matrix) {
        System.out.println("______X");
        int M = matrix.length;
        int N = matrix[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j || i + j == M - 1) {
                    System.out.print(matrix[i][j] + " ");
                } else {
                    System.out.print("  "); // Print blank space for other elements
                }
            }
            System.out.println();
        }
    }

    public static void printSShape(int[][] matrix) {
        System.out.println("______S");
        int M = matrix.length;
        int N = matrix[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || i == M - 1) {
                    System.out.print(matrix[i][j] + " "); // Print the first and last M as they are
                } else if ((i < M / 2 && j == 0) || (i > M / 2 && j == N - 1)) {
                    System.out.print(
                            matrix[i][j] + " "); // Print the leftmost and rightmost elements for top and bottom halves
                } else if (i == M / 2 && j > 0 && j < N - 1) {
                    System.out.print(matrix[i][j] + " "); // Print the middle row as it is
                } else {
                    System.out.print("  "); // Print blank space for other elements
                }
            }
            System.out.println();
        }
    }

    public static void printUShape(int[][] matrix) {
        System.out.println("______U");
        int M = matrix.length;
        int N = matrix[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == M - 1 || j == 0) {
                    System.out.print(matrix[i][j] + " "); // Print the last row and the first column as they are
                } else if (i < M - 1 && j == N - 1) {
                    System.out.print(
                            matrix[i][j] + " "); // Print the rightmost elements for the M above the last row
                } else {
                    System.out.print("  "); // Print blank space for other elements
                }
            }
            System.out.println();
        }
    }

    public static void printLShape(int[][] matrix) {
        System.out.println("______L");
        int M = matrix.length;
        int N = matrix[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == M - 1 || j == 0) {
                    System.out.print(matrix[i][j] + " "); // Print the last row and the first column as they are
                } else {
                    System.out.print("  "); // Print blank space for other elements
                }
            }
            System.out.println();
        }
    }


    class Solution {
        public boolean exist(char[][] board, String word) {
            int M = board.length;
            int N = board[0].length;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
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

            int M = board.length;
            int N = board[0].length;

            if (i < 0 || i >= M || j < 0 || j >= N ||
                    board[i][j] != word.charAt(index)) {
                return false;
            }

            char temp = board[i][j];
            board[i][j] = ' ';

            boolean found =
                    checkWord(i + 1, j, board, word, index + 1) ||
                            checkWord(i - 1, j, board, word, index + 1) ||
                            checkWord(i, j + 1, board, word, index + 1) ||
                            checkWord(i, j - 1, board, word, index + 1);

            board[i][j] = temp;

            return found;

        }
    }


}
