package com.ngumba.november;

import java.util.Arrays;

public class DS2Arrays {

    public static int arraySum() {
        int arraySum = 0;
        int[] array = new int[5];

        int j = 0;
        while (j < 5) {
            array[j] = (int) (Math.random() * 10);
            j++;
        }

        System.out.println(Arrays.toString(array));


        for (int i = 0; i < array.length; i++) {
            arraySum += array[i];
        }

        return arraySum;
    }

    public static char[] charArray() {
        char[] fName = new char[5];
        fName[0] = 'J';
        fName[1] = 'A';
        fName[2] = 'M';
        fName[3] = 'E';
        fName[4] = 'S';

        return fName;
    }

    public static void char2DArray() {
        char[][] array = new char[3][6];
        String word = "MUM";

        char[] wordChar = word.toCharArray();


        array[0][0] = 'K';
        array[0][1] = 'I';
        array[0][2] = 'M';
        array[0][3] = 'A';
        array[0][4] = 'N';
        array[0][5] = 'I';

        array[1][0] = 'N';
        array[1][1] = 'G';
        array[1][2] = 'U';
        array[1][3] = 'M';
        array[1][4] = 'B';
        array[1][5] = 'A';

        array[2][0] = 'J';
        array[2][1] = 'A';
        array[2][2] = 'M';
        array[2][3] = 'E';
        array[2][4] = 'S';
        array[2][5] = ' ';

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(arraySum());
        System.out.println(charArray());
        char2DArray();


        DS2Arrays wordSearch = new DS2Arrays();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(wordSearch.exist(board, word)); // Should print true

    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.isEmpty()) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (deepFirstSearch(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean deepFirstSearch(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true; // Found the word
        }

        int m = board.length;
        int n = board[0].length;

        if ( i < 0 ||
                i >= m ||
                j < 0 ||
                j >= n ||
                board[i][j] != word.charAt(index)) {
            return false; // Out of bounds or mismatched character
        }

        char temp = board[i][j];
        board[i][j] = ' '; // Mark the cell as visited

        // Check adjacent cells
        boolean found = deepFirstSearch(board, i + 1, j, word, index + 1) ||
                        deepFirstSearch(board, i - 1, j, word, index + 1) ||
                        deepFirstSearch(board, i, j + 1, word, index + 1) ||
                        deepFirstSearch(board, i, j - 1, word, index + 1);

        board[i][j] = temp; // Backtrack: restore the original character

        return found;
    }
}
