package com.ngumba.february;

public class ReverseInteger {
        public static int reverse(int x) {
            int result = 0;

            // Flag to check if the number is negative
            boolean isNegative = false;
            if (x < 0) {
                isNegative = true;
                x = -x;  // Make x positive for reversal
            }

            // Loop to reverse the digits
            while (x != 0) {
                int digit = x % 10;
                // Check for overflow before updating result
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                    return 0;
                }
                result = result * 10 + digit;
                x = x / 10;
            }

            // Convert back to negative if original number was negative
            if (isNegative) {
                result = -result;
            }

            return result;
        }

        public static void main(String[] args) {
            System.out.println(reverse(123));    // Output: 321
            System.out.println(reverse(-123));   // Output: -321
            System.out.println(reverse(120));    // Output: 21
        }

}
