package com.ngumba.january;

public class MinStepSumGreaterThan1 {

    public static int minStartValue(int[] nums) {
        int startVal = 0;
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            startVal = Math.min(startVal, total);
        }

        return -startVal + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(minStartValue(nums));
    }
}
