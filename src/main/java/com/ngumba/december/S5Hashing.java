package com.ngumba.december;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class S5Hashing {

    public static boolean checkIfPangram1(String sentence) {
        // We iterate over 'sentence' for 26 times, one for each letter 'currChar'.
        for (int i = 0; i < 26; ++i) {
            char currChar = (char) ('a' + i);

            // If 'sentence' doesn't contain currChar, it is not a pangram.
            if (sentence.indexOf(currChar) == -1) {
                return false;
            }
        }

        // If we manage to find all 26 letters, it is a pangram.
        return true;
    }


    public static boolean checkIfPangram2(String sentence) {
        Set<Character> s = new HashSet<>();

        for (char c : sentence.toCharArray()) {
            s.add(c);
        }
        if (s.size() == 26) {
            return true;
        }
        return false;
    }


    public static int missingNumber1(int[] nums) {
        Arrays.sort(nums);

        // Ensure that 0 is at the first index
        if (nums[0] != 0) {
            return 0;
        }
        // Ensure that n is at the last index
        else if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }

        // If we get here, then the missing number is on the range (0, n)
        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i - 1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }

        // Array was not missing any numbers
        return -1;
    }


    public static int missingNumber2(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }

    //gauss formula
    public static int missingNumber3(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }

    //bit manipulation
    public static int missingNumber4(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public static void main(String[] args) {
        //System.out.println(checkIfPangram2("thequickbrownfoxjumpsoverthelazydog"));
        int[] nums = new int[]{0, 2, 3, 4};
        System.out.println(missingNumber2(nums));
    }


}

