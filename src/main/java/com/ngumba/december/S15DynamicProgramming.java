package com.ngumba.december;

import java.util.HashMap;
import java.util.Map;

public class S15DynamicProgramming {
    static Map<Integer, Integer> memo = new HashMap<>();

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        memo.put(n, fibonacci(n - 1) + fibonacci(n - 2));
        return memo.get(n);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(8));
    }
}
