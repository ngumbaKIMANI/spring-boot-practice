package com.ngumba.november.december;

import java.util.Arrays;

public class S1PrefixSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 6, 3, 2, 7, 2};
        int[][] queries = new int[][]{{0, 3}, {2, 5}, {2, 4}};
        int limit = 13;

        System.out.println(Arrays.toString(answerQueries(nums, queries, limit)));
    }

    public static boolean[] answerQueries(int[] nums, int[][] queries, int limit) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int x = queries[i][0];
            int y = queries[i][1];

            int curr = prefix[y] - prefix[x] + nums[x];

            ans[i] = curr < limit;
        }

        return ans;
    }
}
