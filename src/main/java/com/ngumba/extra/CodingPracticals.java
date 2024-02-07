package com.ngumba.extra;

import java.util.Arrays;
import java.util.HashMap;

public class CodingPracticals {
    public static void main(String[] args) {
        //Minimum_Difference_Between_Largest_and_Smallest_Value_in_Three_Moves m =
        //       new Minimum_Difference_Between_Largest_and_Smallest_Value_in_Three_Moves();
        //int[] nums = {1, 5, 0, 10, 14};
        //System.out.println(m.minDifference(nums));

        //System.out.println(Number_of_Good_Ways_to_Split_a_String.numSplits("aacaba"));
    }

    static class Minimum_Difference_Between_Largest_and_Smallest_Value_in_Three_Moves {

        public int minDifference(int[] nums) {
            // If the array length is 4 or less, we can equalize all numbers
            if (nums.length <= 4) {
                return 0;
            }

            // Sort the array
            Arrays.sort(nums);
            int n = nums.length;



            // Initialize the minDiff with the maximum possible integer value
            int minDiff = Integer.MAX_VALUE;

            // There are four cases considering we can make at the most 3 moves:

            // Case 1: Change the first three smallest numbers
            minDiff = Math.min(minDiff, nums[n - 1] - nums[3]);

            // Case 2: Change two smallest numbers and the largest number
            minDiff = Math.min(minDiff, nums[n - 2] - nums[2]);

            // Case 3: Change smallest number and two largest numbers
            minDiff = Math.min(minDiff, nums[n - 3] - nums[1]);

            // Case 4: Change the first three largest numbers
            minDiff = Math.min(minDiff, nums[n - 4] - nums[0]);

            // Return the minimum difference after at most 3 moves
            return minDiff;
        }

    }
// Time Complexity :- O(NlogN)
// Space Complexity :- O(1)

    static class Number_of_Good_Ways_to_Split_a_String {
        public int numSplits(String s) {
            HashMap<Character, Integer> left = new HashMap<>();
            HashMap<Character, Integer> right = new HashMap<>();

            // Populate right map with frequency count of all characters
            for (char curr : s.toCharArray()) {
                right.put(curr, right.getOrDefault(curr, 0) + 1);
            }

            int count = 0; // To store the good split count

            // Transfer character from right map to left map one by one
            for (char curr : s.toCharArray()) {
                left.put(curr, left.getOrDefault(curr, 0) + 1);
                right.put(curr, right.get(curr) - 1);

                // If count equals to zero then remove the key/value pair
                if (right.get(curr) == 0) {
                    right.remove(curr);
                }

                // If equal amount of distinct characters, increment count
                if (left.size() == right.size()) {
                    count++;
                }
            }

            return count;
        }
    }

}
