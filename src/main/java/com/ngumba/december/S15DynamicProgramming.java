package com.ngumba.december;

import java.util.HashMap;
import java.util.Map;

public class S15DynamicProgramming {
    static Map<Integer, Integer> memo = new HashMap<>();

    public static int fibonacciTopDown(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        memo.put(n, fibonacciTopDown(n - 1) + fibonacciTopDown(n - 2));
        return memo.get(n);
    }

    public static int fibonacciBottomUp(int n) {
        int[] arr = new int[n + 1];
        // base case - the second Fibonacci number is 1
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacciTopDown(8));
    }
}
