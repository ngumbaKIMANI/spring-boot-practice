package com.ngumba.november;

class Solution5LongestPalindrome {
    public static String longestPalindrome(String s) {
        String longestP = "";

        for (int i = 0; i < s.length(); i++) {
            // Expand around the center for odd-length palindrome
            String oddPalindrome = expandAroundCenter(s, i, i);
            if (oddPalindrome.length() > longestP.length()) {
                longestP = oddPalindrome;
            }

            // Expand around the center for even-length palindrome
            String evenPalindrome = expandAroundCenter(s, i, i + 1);
            if (evenPalindrome.length() > longestP.length()) {
                longestP = evenPalindrome;
            }
        }

        return longestP;
    }

    private static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ono"));
    }

    public String longestPalindrome2(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String sub1 = expand(s, i, i);
            if (sub1.length() > result.length()) {
                result = sub1;
            }
            String sub2 = expand(s, i, i + 1);
            if (sub2.length() > result.length()) {
                result = sub2;
            }
        }
        return result;
    }

    public String expand(String s, int l, int r) {
        String result = "";
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if (l == r) {
                result += s.charAt(l);
            } else {
                result = s.charAt(l) + result + s.charAt(r);
            }
            l -= 1;
            r += 1;
        }
        return result;
    }
}

