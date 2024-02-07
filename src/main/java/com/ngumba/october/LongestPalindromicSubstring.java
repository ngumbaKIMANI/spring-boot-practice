package com.ngumba.october;

import java.util.Collections;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String s = "madam";
        String result = solution.longestPalindrome(s);
        System.out.println(result); // Output: "bab" or "aba"
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];

        int start = 0; // Start index of the longest palindromic substring
        int maxLength = 1; // Length of the longest palindromic substring

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }

        // Check substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check substrings of length 3 or more
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1; // Ending index of the substring

                // Check if the substring is a palindrome and its inner substring is a palindrome
                if (isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    isPalindrome[i][j] = true;
                    start = i;
                    maxLength = length;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }
}
