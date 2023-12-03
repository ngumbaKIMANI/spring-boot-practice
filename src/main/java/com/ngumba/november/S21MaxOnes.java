package com.ngumba.november;

public class S21MaxOnes {

    //maximum number of ones occurring contiguously
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currentMax = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentMax += 1;
            } else {
                currentMax = 0;
            }
            max = Math.max(max, currentMax);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }

}
