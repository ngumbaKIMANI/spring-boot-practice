package com.ngumba.december;

import java.util.*;

public class S11GraphsBFS {
    static class Solution1 {
        int n;
        int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        public int shortestPathBinaryMatrix(int[][] grid) {
            if (grid[0][0] == 1) {
                return -1;
            }

            n = grid.length;

            // more convenient to use a 2d array instead of a set for seen
            boolean[][] seen = new boolean[n][n];
            seen[0][0] = true;
            Queue<State1> queue = new LinkedList<>();
            queue.add(new State1(0, 0, 1)); // row, col, steps

            while (!queue.isEmpty()) {
                State1 state = queue.remove();
                int row = state.row, col = state.col, steps = state.steps;
                if (row == n - 1 && col == n - 1) {
                    return steps;
                }

                for (int[] direction : directions) {
                    int nextRow = row + direction[0], nextCol = col + direction[1];
                    if (valid(nextRow, nextCol, grid) && !seen[nextRow][nextCol]) {
                        seen[nextRow][nextCol] = true;
                        queue.add(new State1(nextRow, nextCol, steps + 1));
                    }
                }
            }

            return -1;
        }

        public boolean valid(int row, int col, int[][] grid) {
            return 0 <= row && row < n && 0 <= col && col < n && grid[row][col] == 0;
        }
    }

    static class State1 {
        int row;
        int col;
        int steps;

        State1(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    static class Solution2 {
        Map<TreeNode, TreeNode> parents = new HashMap<>();

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            dfs(root, null);
            Queue<TreeNode> queue = new LinkedList<>();
            Set<TreeNode> seen = new HashSet<>();
            queue.add(target);
            seen.add(target);

            int distance = 0;
            while (!queue.isEmpty() && distance < k) {
                int currentLength = queue.size();
                for (int i = 0; i < currentLength; i++) {
                    TreeNode node = queue.remove();
                    for (TreeNode neighbor : new TreeNode[]{node.left, node.right, parents.get(node)}) {
                        if (neighbor != null && !seen.contains(neighbor)) {
                            seen.add(neighbor);
                            queue.add(neighbor);
                        }
                    }
                }

                distance++;
            }

            List<Integer> ans = new ArrayList<>();
            for (TreeNode node : queue) {
                ans.add(node.val);
            }

            return ans;
        }

        public void dfs(TreeNode node, TreeNode parent) {
            if (node == null) {
                return;
            }

            parents.put(node, parent);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    static class State3 {
        int row;
        int col;
        int steps;

        State3(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    static class Solution3 {
        int m;
        int n;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public int[][] updateMatrix(int[][] mat) {
            m = mat.length;
            n = mat[0].length;

            Queue<State3> queue = new LinkedList<>();
            boolean[][] seen = new boolean[m][n];

            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (mat[row][col] == 0) {
                        queue.add(new State3(row, col, 1));
                        seen[row][col] = true;
                    }
                }
            }

            while (!queue.isEmpty()) {
                State3 state = queue.remove();
                int row = state.row, col = state.col, steps = state.steps;

                for (int[] direction : directions) {
                    int nextRow = row + direction[0], nextCol = col + direction[1];
                    if (valid(nextRow, nextCol, mat) && !seen[nextRow][nextCol]) {
                        seen[nextRow][nextCol] = true;
                        queue.add(new State3(nextRow, nextCol, steps + 1));
                        mat[nextRow][nextCol] = steps;
                    }
                }
            }

            return mat;
        }

        public boolean valid(int row, int col, int[][] mat) {
            return 0 <= row && row < m && 0 <= col && col < n && mat[row][col] == 1;
        }
    }


}
