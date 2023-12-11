package com.ngumba.december;

import java.util.*;

public class S11GraphsDFS {
    public static void main(String[] args) {
        //int[][] isConnected = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        //Solution1 s1 = new Solution1();
        //System.out.println(s1.findCircleNum(isConnected));

        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        Solution2 s2 = new Solution2();
        System.out.println(s2.numIslands(grid));
    }

    static class Solution1 {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] seen;

        public int findCircleNum(int[][] isConnected) {
            // build the graph
            int n = isConnected.length;
            for (int i = 0; i < n; i++) {
                if (!graph.containsKey(i)) {
                    graph.put(i, new ArrayList<>());
                }
                for (int j = i + 1; j < n; j++) {

                    if (!graph.containsKey(j)) {
                        graph.put(j, new ArrayList<>());
                    }
                    if (isConnected[i][j] == 1) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            seen = new boolean[n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (!seen[i]) {
                    // add all nodes of a connected component to the set
                    ans++;
                    seen[i] = true;
                    dfs(i);
                }
            }

            return ans;
        }

        public void dfs(int node) {
            for (int neighbor : graph.get(node)) {
                if (!seen[neighbor]) {
                    seen[neighbor] = true;
                    dfs(neighbor);
                }
            }
        }
    }

    static class Solution2 {
        int m;
        int n;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] seen;

        public int numIslands(char[][] grid) {
            int ans = 0;
            m = grid.length;
            n = grid[0].length;
            seen = new boolean[m][n];

            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] == '1' && !seen[row][col]) {
                        ans++;
                        seen[row][col] = true;
                        dfs(row, col, grid);
                    }
                }
            }

            return ans;
        }

        public boolean valid(int row, int col, char[][] grid) {
            return 0 <= row && row < m && 0 <= col && col < n && grid[row][col] == '1';
        }

        public void dfs(int row, int col, char[][] grid) {
            for (int[] direction : directions) {
                int nextRow = row + direction[0], nextCol = col + direction[1];

                if (valid(nextRow, nextCol, grid) && !seen[nextRow][nextCol]) {
                    seen[nextRow][nextCol] = true;
                    dfs(nextRow, nextCol, grid);
                }
            }
        }
    }

    static class Solution3 {
        Set<String> roads = new HashSet<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        ;
        Set<Integer> seen = new HashSet<>();

        public int minReorder(int n, int[][] connections) {
            for (int i = 0; i < n; i++) {
                graph.put(i, new ArrayList<>());
            }

            for (int[] connection : connections) {
                int x = connection[0], y = connection[1];
                graph.get(x).add(y);
                graph.get(y).add(x);
                roads.add(convertToHash(x, y));
            }

            seen.add(0);
            return dfs(0);
        }

        public int dfs(int node) {
            int ans = 0;
            for (int neighbor : graph.get(node)) {
                if (!seen.contains(neighbor)) {
                    if (roads.contains(convertToHash(node, neighbor))) {
                        ans++;
                    }

                    seen.add(neighbor);
                    ans += dfs(neighbor);
                }
            }

            return ans;
        }

        public String convertToHash(int row, int col) {
            return String.valueOf(row) + "," + String.valueOf(col);
        }
    }

    static class Solution4 {
        Set<Integer> seen = new HashSet<>();

        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            seen.add(0);
            dfs(0, rooms);
            return seen.size() == rooms.size();
        }

        public void dfs(int node, List<List<Integer>> rooms) {
            for (int neighbor : rooms.get(node)) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    dfs(neighbor, rooms);
                }
            }
        }
    }

    static class Solution5 {
        public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
            int[] indegree = new int[n];
            for (List<Integer> edge : edges) {
                indegree[edge.get(1)]++;
            }

            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (indegree[i] == 0) {
                    ans.add(i);
                }
            }

            return ans;
        }
    }
}
