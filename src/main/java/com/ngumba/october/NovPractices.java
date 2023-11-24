package com.ngumba.october;


import java.util.Arrays;

public class NovPractices {

    public static void main(String[] args) {
        // System.out.println("maxSubArray : " + maxSubArray(new int[]{4, -5, 1}));
        // System.out.println("InPlacePalindrome check : "+isPalindrome("eoboe"));
        System.out.println("mergeSort 2 arrays : " +
                Arrays.toString(mergeSortedArrays()));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentMaxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMaxSum = Math.max(nums[i], currentMaxSum + nums[i]);
            maxSum = Math.max(maxSum, currentMaxSum);
        }

        return maxSum;
    }

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static int[] mergeSortedArrays() {
        int[] nums1 = new int[]{1, 3, 7};
        int[] nums2 = new int[]{2, 5, 6};

        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[m + n];
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                result[k--] = nums1[i--];
            } else {
                result[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            result[k--] = nums2[j--];
        }

        return result;
    }


}
