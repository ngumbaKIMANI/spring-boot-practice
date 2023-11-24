package com.ngumba.november;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution10 {
    public static void main(String args[]) {
        String s1 = "welcome to split world in africa";
        System.out.println(" ");
        System.out.println("returning words limit 0:");
        System.out.println("_____________________________________");

        for (String w : s1.split("\\s", 0)) {
            System.out.println(w);
        }
        for (String w : s1.split("\\s")) {
            System.out.println(w);
        }
        System.out.println(" ");
        System.out.println("returning words limit 1:");
        System.out.println("_____________________________________");

        for (String w : s1.split("\\s", 1)) {
            System.out.println(w);
        }
        System.out.println(" ");
        System.out.println("returning words limit 2:");
        System.out.println("_____________________________________");
        for (String w : s1.split("\\s", 2)) {
            System.out.println(w);
        }
        System.out.println(" ");
        System.out.println("returning words limit 6:");
        System.out.println("_____________________________________");
        for (String w : s1.split("\\s", 6)) {
            System.out.println(w);
        }

        String input = "The quick-brown_fox jumps over the lazy dog.";

        // Define the pattern
        Pattern pattern = Pattern.compile("\\W");

        // Create a matcher for the input string
        Matcher matcher = pattern.matcher(input);



        // Count and print the number of non-word characters
        int count = 0;
        while (matcher.find()) {
            count++;
        }

        System.out.println("Number of non-word characters: " + count);
    }
}