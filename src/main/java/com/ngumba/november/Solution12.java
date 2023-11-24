package com.ngumba.november;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution12 {
    public static void main(String[] args) {
        String input = "james";

        // Define the pattern to match non-word characters
        Pattern pattern = Pattern.compile("\\s");

        // Create a matcher for the input string
        Matcher matcher = pattern.matcher(input);

        // Count and store the occurrences of non-word characters
        Map<Character, Integer> charCounts = new HashMap<>();
        while (matcher.find()) {
            char nonWordChar = input.charAt(matcher.start());
            charCounts.put(nonWordChar, charCounts.getOrDefault(nonWordChar, 0) + 1);
        }

        // Print the counts of individual non-word characters
        System.out.println("Counts of individual non-word characters:");
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Print the total count of non-word characters
        int totalCount = charCounts.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total number of non-word characters: " + totalCount);
    }
}

