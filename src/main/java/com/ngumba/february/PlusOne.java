package com.ngumba.february;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        // Increment the last digit by one
        digits[n - 1] += 1;

        // Handle carry
        for (int i = n - 1; i > 0 && digits[i] == 10; i--) {
            digits[i] = 0;
            digits[i - 1] += 1; // propagate the carry
        }

        // If there's still a carry in the first digit, we need to expand the array
        if (digits[0] == 10) {
            int[] result = new int[n + 1];
            result[0] = 1;
            return result;
        }

        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits)));

    }
}
