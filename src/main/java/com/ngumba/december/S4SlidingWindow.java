package com.ngumba.december;

public class S4SlidingWindow {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 7, 4, 2, 1, 1, 5};
        System.out.println(findLength(nums, 8));
    }
    //Given an array of positive integers nums and an integer k,
    // find the length of the longest subarray whose sum is
    // less than or equal to k.

    public static int findLength(int[] nums, int k) {
        int left = 0;
        int curr = 0; // curr is the current sum of the window
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];
            while (curr > k) {
                curr -= nums[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    //Given a binary array nums and an integer k, return the maximum number of
    // consecutive 1's in the array if you can flip at most k 0's.
    public static int longestOnes(int[] nums, int k) {
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            // If we included a zero in the window we reduce the value of k.
            // Since k is the maximum zeros allowed in a window.
            if (nums[right] == 0) {
                k--;
            }
            // A negative k denotes we have consumed all allowed flips and window has
            // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
            if (k < 0) {
                // If the left element to be thrown out is zero we increase k.
                k += 1 - nums[left];
                left++;
            }
        }
        return right - left;
    }

    //You are given a binary string s (a string containing only "0" and "1").
    // You may choose up to one "0" and flip it to a "1".
    // What is the length of the longest substring achievable
    // that contains only "1"?
    public int findLength(String s) {
        // curr is the current number of zeros in the window
        int left = 0;
        int curr = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '0') {
                curr++;
            }

            while (curr > 1) {
                if (s.charAt(left) == '0') {
                    curr--;
                }

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    //Given an array of positive integers nums and an integer k,
    // return the number of subarrays where the product of all the elements
    // in the subarray is strictly less than k.
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int ans = 0;
        int left = 0;
        int curr = 1;

        for (int right = 0; right < nums.length; right++) {
            curr *= nums[right];
            while (curr >= k) {
                curr /= nums[left];
                left++;
            }

            ans += right - left + 1;
        }

        return ans;
    }

    //fixed window
    //Given an integer array nums and an integer k,
    // find the sum of the subarray with the largest
    // sum whose length is k.
    public int findBestSubarray(int[] nums, int k) {
        int curr = 0;
        for (int i = 0; i < k; i++) {
            curr += nums[i];
        }

        int ans = curr;
        for (int i = k; i < nums.length; i++) {
            curr += nums[i] - nums[i - k];
            ans = Math.max(ans, curr);
        }

        return ans;
    }

    //You are given an integer array nums consisting of n elements, and an integer k.
    //Find a contiguous subarray whose length is equal to k that has the maximum
    // average value and return this value
    public double findMaxAverage1(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];

        // Calculate cumulative sum
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        double res = sum[k - 1] * 1.0 / k;

        // Avoid repeated calculations within the loop
        for (int i = k; i < nums.length; i++) {
            int currentSum = sum[i] - sum[i - k]; // Calculate only once
            res = Math.max(res, currentSum * 1.0 / k);
        }
        return res;
    }

    //Combination of Prefix Sum technique and Sliding Window - Fixed Window
    public double findMaxAverage2(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        double res = sum[k - 1] * 1.0 / k;

        for (int i = k; i < nums.length; i++) {
            double curr = (sum[i] - sum[i - k]) * 1.0 / k;
            res = Math.max(res, curr);
        }

        return res;

    }

}