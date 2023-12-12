package com.ngumba.december;

import java.util.Arrays;

public class S13BinarySearch {
    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                // do something
                return mid;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // target is not in arr, but left is at the insertion point
        return left;
    }

    public int binarySearchWithDuplicates(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public int binarySearchRightMostInsertionPoint(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}

class S13Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col = mid % n;
            int num = matrix[row][col];

            if (num == target) {
                return true;
            }

            if (num < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}

class S13Solution2 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        int m = potions.length;

        for (int i = 0; i < spells.length; i++) {
            int j = binarySearch(potions, success / (double) spells[i]);
            ans[i] = m - j;
        }

        return ans;
    }

    public int binarySearch(int[] arr, double target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
class Solution {
    int limit;

    public int minEatingSpeed(int[] piles, int h) {
        limit = h;
        int left = 1;
        int right = 0;

        for (int bananas: piles) {
            right = Math.max(right, bananas);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, piles)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean check(double k, int[] piles) {
        int hours = 0;
        for (double bananas: piles) {
            hours += Math.ceil(bananas / k);
        }

        return hours <= limit;
    }
}

