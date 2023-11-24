package com.ngumba.november;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution11 {
    public static void main(String[] args) {
        String input = "The quick-brown_fox jumps over the lazy dog.";

        // Define the pattern to match non-word characters
        Pattern pattern = Pattern.compile("\\W");

        // Create a matcher for the input string
        Matcher matcher = pattern.matcher(input);

        // Count and print the number of non-word characters
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Non-word character found: " + matcher.group());
        }

        System.out.println("Number of non-word characters: " + count);
    }




}
