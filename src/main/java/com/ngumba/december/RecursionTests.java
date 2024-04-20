package com.ngumba.december;

public class RecursionTests {

    static String reverseString(String input) {
        if (input.isEmpty()) {
            return "";
        }
        String s = input.substring(1);
        char c = input.charAt(0);

        return reverseString(s) + c;
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Hello"));
    }


}

class ReverseStringII {

    static String reverseStringII(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder reversed = new StringBuilder(input);
        return reversed.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseStringII("Hello part 2"));
    }
}

class SubstringExample {
    public static void main(String args[]) {
        String s1 = "vatpoint";
        System.out.println(s1.substring(2, 4));//returns va
        String s2 = "vatpoint";
        System.out.println(s2.substring(1));//returns vatpoint
        System.out.println(s2.charAt(0));
    }
}

class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int square;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            result[i] = square * square;
        }
        return result;
    }
}
