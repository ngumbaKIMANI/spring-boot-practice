package com.ngumba.microsoft;

import java.util.Arrays;

public class ChessBoardRooks {


    public static void main(String[] args) {

        // Test case 1
        int[][] A1 = {{1, 4}, {2, 3}};
        int expected1 = 6;
        test(A1, expected1);

        // Test case 2
        int[][] A2 = {{15, 1, 5}, {16, 3, 8}, {2, 6, 4}};
        int expected2 = 23;
        test(A2, expected2);

        // Test case 3 (Edge case: Single square)
        int[][] A3 = {{12, 12}, {12, 12}, {0, 7}};
        int expected3 = 24;
        test(A3, expected3);

        // Test case 4 (Edge case: Multiple squares)
        int[][] A4 = {{1, 2, 14}, {8, 3, 15}};
        int expected4 = 22;
        test(A4, expected4);


    }

    public static void test(int[][] A, int expected) {
        int result = maxPoints(A);
        if (result == expected) {
            System.out.println("Pass: Expected=" + expected + ", Result=" + result);
        } else {
            System.out.println("..Fail: Expected=" + expected + ", Result=" + result);
        }
    }

    // brute force
    public static int maxPoints(int[][] A) {
        int maxSum = 0;
        int N = A.length;
        int M = A[0].length;

        // Iterate over all possible pairs of cells
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < M; y++) {
                        // Check if cells are not in the same row or column
                        if (i != x && j != y) {
                            // Calculate sum of scores for the pair
                            int sum = A[i][j] + A[x][y];
                            // Update maximum sum if current sum is larger
                            maxSum = Math.max(maxSum, sum);
                        }
                    }
                }
            }
        }
        return maxSum;
    }
}



























