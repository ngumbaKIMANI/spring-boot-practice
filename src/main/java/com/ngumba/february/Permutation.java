package com.ngumba.february;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i <= n; i++) {
            tempList.add(i);
            backtrack(result, tempList, i + 1, n, k);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        // Test case 1
        int n1 = 4;
        int k1 = 2;
        List<List<Integer>> result1 = combine2(n1, k1);
        System.out.println("Combinations2 for n = " + n1 + ", k = " + k1 + " using backtracking:");
        for (List<Integer> combination : result1) {
            System.out.println(combination);
        }
    }

    public static List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        generateCombinations(result, combination, n, k, 1);
        return result;
    }

    private static void generateCombinations(List<List<Integer>> result, List<Integer> combination, int n, int k,
                                             int start) {
        if (k == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            combination.add(i);
            generateCombinations(result, combination, n, k - 1, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
