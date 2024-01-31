package com.ngumba.january;

public class ReverseOnlyLetters {
    public static String reverseOnlyLetters(String s) {

        int left = 0;
        int right = s.length() - 1;

        char[] arr = s.toCharArray();

        while (left < right) {

            while (left < right && !Character.isLetter(arr[left])) {
                left++;

            }

            while (right > left && !Character.isLetter(arr[right])) {
                right--;
            }

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("7_28]"));
    }
}
