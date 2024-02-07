package com.ngumba.master;

import java.util.Arrays;

public class TwoPointerOperations {

    public static int removeDuplicated(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        System.out.println("after :" + Arrays.toString(nums));
        return j;
    }

    public static int maximumProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
        int[] nums = {3, 4, -1, 0, 6, 2, 3};
        int[] duplicatedNums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println("before :" + Arrays.toString(duplicatedNums));
        System.out.println("removeDuplicates :" + removeDuplicated(duplicatedNums));
        System.out.println("maxProfits : " + maximumProfit(prices));


    }

    static class LongestIncreasingSubSequence {

        //Complexity O(n Log(n))
        public static int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int len = 0;

            for (int num : nums) {
                int index = Arrays.binarySearch(dp, 0, len, num);

                if (index < 0) {
                    index = -(index + 1);
                }

                dp[index] = num;

                if (index == len) {
                    len++;
                }
            }

            return len;
        }

        public int lengthOfLIS2(int[] nums) {

            int[] T = new int[nums.length];

            // Start main pointer
            for (int i = 1; i < nums.length; i++)

                // Start second pointer
                for (int j = 0; j < i; j++)

                    if (nums[i] > nums[j]) {
                        if (T[j] + 1 > T[i]) {
                            T[i] = T[j] + 1;
                        }
                    }

            // find the max value
            int maxIndex = 0;
            for (int i = 0; i < T.length; i++)
                if (T[i] > T[maxIndex]) {
                    maxIndex = i;
                }

            return T[maxIndex] + 1;
        }


        public int lengthOfLIS1(int[] nums) {

            int[] T = new int[nums.length];

            int max = 0;

            for (int i = 0; i < nums.length; i++) {
                T[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        T[i] = Math.max(T[i], T[j] + 1);
                    }
                }
                max = Math.max(max, T[i]);
            }

            return max;
        }


    }

}
