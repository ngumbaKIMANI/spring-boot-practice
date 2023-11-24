package com.ngumba.november;

public class Solution17MissingNumber {

    public static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        // Calculate the actual sum
        for (int num : nums) {
            actualSum += num;
        }

        // Find the missing number
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[5];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 7;
        nums[3] = 4;
        nums[4] = 4;
        System.out.println(findMissingNumber(nums));
    }
}