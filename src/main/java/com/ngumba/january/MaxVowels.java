package com.ngumba.january;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxVowels {


    public static int maxVowels(String s, int k) {
        int maxNumV = 0;
        int currVN = 0;
        int left = 0;

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        // Initial count for the first k characters
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                currVN++;
            }
        }

        maxNumV = currVN;

        // Sliding window approach
        for (int right = k; right < s.length(); right++) {
            // Add the rightmost character to the substring
            if (vowels.contains(s.charAt(right))) {
                currVN++;
            }

            // Remove the leftmost character from the substring
            if (vowels.contains(s.charAt(left))) {
                currVN--;
            }

            maxNumV = Math.max(currVN, maxNumV);
            left++;
        }

        return maxNumV;
    }

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
    }
}


