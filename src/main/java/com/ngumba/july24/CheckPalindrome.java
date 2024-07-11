package com.ngumba.july24;

import java.util.Arrays;

public class CheckPalindrome {
    static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static int[] findTwoNumbersAddingToTarget(int[] nums, int t) {
        int ans[] = new int[2];

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == t) {
                ans[0] = nums[left];
                ans[1] = nums[right];
                return ans;
            } else if (sum > t) {
                right--;
            } else {
                left++;
            }
        }

        return ans;
    }

    static int[] combineTwoArr(int[] A, int[] B) {
        int[] ans = new int[A.length + B.length];
        int i = 0;
        int j = 0;
        while (i<A.length && j<B.length){

        }

            return ans;
    }

    public static void main(String[] args) {
        String word = "racecar";
        //System.out.println(isPalindrome(word));
        int[] n = {3, 6, 21, 23, 25};
        int t = 27;
        System.out.println(Arrays.toString(findTwoNumbersAddingToTarget(n, t)) + " adds to " + t);

    }
}
