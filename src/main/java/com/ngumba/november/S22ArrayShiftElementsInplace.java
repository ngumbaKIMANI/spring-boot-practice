package com.ngumba.november;

import java.util.Arrays;

public class S22ArrayShiftElementsInplace {

    public static int[] duplicateZeros(int[] arr) {
        for (int left = 0; left < arr.length; left++) {
            if (arr[left] == 0) {
                for (int right = arr.length - 1; right > left; right--) {
                    arr[right] = arr[right - 1];
                }
                left = left + 1;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(duplicateZeros(arr)));
    }
}
