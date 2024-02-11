package com.ngumba.february;

import java.util.*;

public class InterSectionOf2ArraysII {


    public static void main(String[] args) {
        InterSectionOf2ArraysII intersectionOf2ArraysII = new InterSectionOf2ArraysII();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersectionOf2ArraysII.intersect(nums1, nums2)));

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersectionOf2ArraysII.intersect(nums1, nums2)));

        nums1 = new int[]{1, 2, 2, 1};
        nums2 = new int[]{2};
        System.out.println(Arrays.toString(intersectionOf2ArraysII.intersect(nums1, nums2)));

        nums1 = new int[]{1, 2, 2, 1};
        nums2 = new int[]{2, 2};
        System.out.println(Arrays.toString(intersectionOf2ArraysII.intersect(nums1, nums2)));

        nums1 = new int[]{1, 2, 2, 1};
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); // Sort nums1 in memory

        final int CHUNK_SIZE = 3; // Define chunk size for loading nums2

        List<Integer> result = new ArrayList<>();

        // Process nums2 in chunks
        for (int i = 0; i < nums2.length; i += CHUNK_SIZE) {
            int[] chunk = Arrays.copyOfRange(nums2, i,
                    Math.min(i + CHUNK_SIZE, nums2.length)); // Load a chunk of nums2 into memory
            Arrays.sort(chunk); // Sort the loaded chunk

            int ptr1 = 0, ptr2 = 0; // Pointers for nums1 and chunk of nums2

            // Find intersection between nums1 and chunk
            while (ptr1 < nums1.length && ptr2 < chunk.length) {
                if (nums1[ptr1] == chunk[ptr2]) {
                    result.add(nums1[ptr1]);
                    ptr1++;
                    ptr2++;
                } else if (nums1[ptr1] < chunk[ptr2]) {
                    ptr1++;
                } else {
                    ptr2++;
                }
            }
        }

        // Convert List to int[]
        int[] intersection = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersection[i] = result.get(i);
        }

        return intersection;
    }


    public int[] intersectII(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        // Count occurrences of elements in nums1
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        // Iterate through nums2 and find the common elements
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        // Convert List to int[]
        int[] intersection = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersection[i] = result.get(i);
        }

        return intersection;
    }


}
