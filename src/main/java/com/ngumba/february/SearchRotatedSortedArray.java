package com.ngumba.february;

public class SearchRotatedSortedArray {
    public static int searchRotatedSortedArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // find index of smallest element
        while (left < right) {
            int midpoint = left + (right - left) / 2;
            if (nums[midpoint] > nums[right]) {
                left = midpoint + 1;
            } else {
                right = midpoint;
            }
        }

        System.out.println("Index of smallest element is : " + left);

        int start = left; //index of smallest element
        left = 0;//re set left
        right = nums.length - 1;// reset right

        if (target >= nums[start] && target <= nums[right]) {
            left = start;
        } else {
            right = start;
        }

        //binary search on portion of array
        while (left <= right) {
            int midpoint = left + (right - left) / 2;
            if (nums[midpoint] == target) {
                return midpoint;
            } else if (nums[midpoint] < target) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target is greater, ignore left half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        // If target is not present in the array
        return -1;
    }


    public static void main(String[] args) {
        System.out.println("Target found at index : " + searchRotatedSortedArray(new int[]{3, 4, 5, 6, 7, 8, 1}, 5));
    }
}
