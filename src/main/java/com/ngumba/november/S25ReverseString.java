package com.ngumba.november;

public class S25ReverseString {
    public static void reverseString(char[] s) {
        int right = s.length - 1;
        for (int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[right];
            s[right] = temp;
            right--;
        }

    }

    public static void main(String[] args) {
        reverseString(new char[]{'h','e','l','l','o'});
    }
}