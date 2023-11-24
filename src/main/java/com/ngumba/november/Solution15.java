package com.ngumba.november;

public class Solution15 {

    public static void rotate(int[][] a) {
        int n = a.length;

        // Step 1: Transpose the Matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap a elements across the main diagonal
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        // Step 2: Reverse Each Row
        for (int i = 0; i < n; i++) {
            reverseRow(a[i]);
        }
    }

    private static void reverseRow(int[] row) {
        int start = 0;
        int end = row.length - 1;

        while (start < end) {
            // Swap elements at start and end positions
            int temp = row[start];
            row[start] = row[end];
            row[end] = temp;

            // Move indices towards the center
            start++;
            end--;
        }
    }

    public static void printMatrix(int[][] a) {
        for (int[] row : a) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(a);

        rotate(a);

        System.out.println("\nRotated Matrix:");
        printMatrix(a);
    }
}

