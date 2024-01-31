package com.ngumba;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithMaxKDistinctChars {


    public static void main(String[] args) {
        String s = "abcdeffg";
        int k = 3;

        LongestSubstringWithMaxKDistinctChars solution = new LongestSubstringWithMaxKDistinctChars();
        int length = solution.longestSubstringKDistinct(s, k);
        System.out.println("Length of the longest substring with at most " + k + " distinct characters: " + length);
    }

    public int longestSubstringKDistinct(String s, int k) {
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> charFrequency = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0) + 1);

            while (charFrequency.size() > k) {
                char leftChar = s.charAt(windowStart);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);
                if (charFrequency.get(leftChar) == 0) {
                    charFrequency.remove(leftChar);
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}
