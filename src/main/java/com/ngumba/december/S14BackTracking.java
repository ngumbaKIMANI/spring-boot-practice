package com.ngumba.december;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class S14BackTracking {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutation permutation = new Permutation();
        List<List<Integer>> finalPermutations = permutation.permute(nums);
        System.out.println(finalPermutations); // Prints all permutations of nums
    }

    static class Permutation {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            backtrack(new ArrayList<>(), ans, nums);
            return ans;
        }

        public void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
            if (curr.size() == nums.length) {
                ans.add(new ArrayList<>(curr));
                return;
            }

            for (int num : nums) {
                if (!curr.contains(num)) {
                    curr.add(num);
                    backtrack(curr, ans, nums);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }

    static class S14Subsets {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            backtrack(new ArrayList<>(), 0, ans, nums);
            return ans;
        }

        public void backtrack(List<Integer> curr, int i, List<List<Integer>> ans, int[] nums) {
            if (i > nums.length) {
                return;
            }

            ans.add(new ArrayList<>(curr));
            for (int j = i; j < nums.length; j++) {
                curr.add(nums[j]);
                backtrack(curr, j + 1, ans, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }

    static class S14Combinations {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            backtrack(new ArrayList<>(), 1, ans, n, k);
            return ans;
        }

        public void backtrack(List<Integer> curr, int i, List<List<Integer>> ans, int n, int k) {
            if (curr.size() == k) {
                ans.add(new ArrayList<>(curr));
                return;
            }

            for (int num = i; num <= n; num++) {
                curr.add(num);
                backtrack(curr, num + 1, ans, n, k);
                curr.remove(curr.size() - 1);
            }
        }
    }

    static class PhoneLetterCombination {
        private List<String> combinations = new ArrayList<>();
        private Map<Character, String> letters = Map.of(
                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        private String phoneDigits;

        public List<String> letterCombinations(String digits) {
            // If the input is empty, immediately return an empty answer array
            if (digits.length() == 0) {
                return combinations;
            }

            // Initiate backtracking with an empty path and starting index of 0
            phoneDigits = digits;
            backtrack(0, new StringBuilder());
            return combinations;
        }

        private void backtrack(int index, StringBuilder path) {
            // If the path is the same length as digits, we have a complete combination
            if (path.length() == phoneDigits.length()) {
                combinations.add(path.toString());
                return; // Backtrack
            }

            // Get the letters that the current digit maps to, and loop through them
            String possibleLetters = letters.get(phoneDigits.charAt(index));
            for (char letter : possibleLetters.toCharArray()) {
                // Add the letter to our current path
                path.append(letter);
                // Move on to the next digit
                backtrack(index + 1, path);
                // Backtrack by removing the letter before moving onto the next
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    static class AllPathsSourceTarget {
        private int target;
        private int[][] graph;
        private List<List<Integer>> results;

        protected void backtrack(int currNode, LinkedList<Integer> path) {
            if (currNode == this.target) {
                // Note: one should make a deep copy of the path
                this.results.add(new ArrayList<Integer>(path));
                return;
            }
            // explore the neighbor nodes one after another.
            for (int nextNode : this.graph[currNode]) {
                // mark the choice, before backtracking.
                path.addLast(nextNode);
                this.backtrack(nextNode, path);
                // remove the previous choice, to try the next choice
                path.removeLast();
            }
        }

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

            this.target = graph.length - 1;
            this.graph = graph;
            this.results = new ArrayList<List<Integer>>();
            // adopt the LinkedList for fast access to the tail element.
            LinkedList<Integer> path = new LinkedList<Integer>();
            path.addLast(0);
            // kick of the backtracking, starting from the source (node 0)
            this.backtrack(0, path);
            return this.results;
        }
    }
}
