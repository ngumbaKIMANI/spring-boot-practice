package com.ngumba.february;

import java.util.Arrays;

public class MoveZeros {
    public void moveZeroes(int[] nums) {

        int i = 0, j = 0;

        while (j < nums.length) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }
    }

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        int[] nums = {0, 1, 0, 3, 12};
        moveZeros.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));


    }
}
