package com.ngumba.october;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NovPractice2 {
    public static void main(String[] args) {
        System.out.println("hello min window :");
    }

    public static String minWindow(String s, String t) {
        int[] charCount = new int[128];
        for (char c : t.toCharArray()) {
            charCount[c]++;
        }

        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int count = t.length();

        while (right < s.length()) {
            if (charCount[s.charAt(right)] > 0) {
                count--;
            }
            charCount[s.charAt(right)]--;
            right++;

            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }

                if (charCount[s.charAt(left)] == 0) {
                    count++;
                }
                charCount[s.charAt(left)]++;
                left++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(minStart, minStart + minLen);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums1) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (frequency.containsKey(num) && frequency.get(num) > 0) {
                result.add(num);
                frequency.put(num, frequency.get(num) - 1);
            }
        }

        int[] intersection = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersection[i] = result.get(i);
        }

        return intersection;
    }

    class Solution {
        public int solution(int[] A, int S) {
            int n = A.length;
            long sum = 0;
            int count = 0;
            int left = 0;

            for (int right = 0; right < n; right++) {
                sum += A[right];

                while (sum > (long) S * (right - left + 1)) {
                    sum -= A[left];
                    left++;
                }

                if (sum == (long) S * (right - left + 1)) {
                    count += (right - left + 1);
                }

                if (count > 1_000_000_000) {
                    return 1_000_000_000;
                }
            }

            return count;
        }
    }



}
