package com.ngumba.december;

import java.util.ArrayList;
import java.util.List;

public class S14BackTrackingConstrained {
    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            backtrack(new ArrayList<>(), 0, 0, ans, candidates, target);
            return ans;
        }

        public void backtrack(List<Integer> path, int start, int curr, List<List<Integer>> ans, int[] candidates,
                              int target) {
            if (curr == target) {
                ans.add(new ArrayList<>(path));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                int num = candidates[i];
                if (curr + num <= target) {
                    path.add(num);
                    backtrack(path, i, curr + num, ans, candidates, target);
                    path.remove(path.size() - 1);
                }
            }

        }
    }

    static class WordSearch {
        int m;
        int n;
        String target;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] seen;

        public boolean exist(char[][] board, String word) {
            m = board.length;
            n = board[0].length;
            target = word;
            seen = new boolean[m][n];

            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (board[row][col] == word.charAt(0)) {
                        seen[row][col] = true;
                        if (backtrack(row, col, 1, board)) {
                            return true;
                        }
                        seen[row][col] = false;
                    }
                }
            }

            return false;
        }

        public boolean backtrack(int row, int col, int i, char[][] board) {
            if (i == target.length()) {
                return true;
            }

            for (int[] direction : directions) {
                int nextRow = row + direction[0], nextCol = col + direction[1];
                if (valid(nextRow, nextCol) && !seen[nextRow][nextCol]) {
                    if (board[nextRow][nextCol] == target.charAt(i)) {
                        seen[nextRow][nextCol] = true;
                        if (backtrack(nextRow, nextCol, i + 1, board)) {
                            return true;
                        }
                        seen[nextRow][nextCol] = false;
                    }
                }
            }

            return false;
        }

        public boolean valid(int row, int col) {
            return 0 <= row && row < m && 0 <= col && col < n;
        }
    }
}
