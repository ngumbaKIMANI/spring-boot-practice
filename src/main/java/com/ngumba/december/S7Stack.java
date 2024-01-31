package com.ngumba.december;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class S7Stack {

    public static boolean isValid(String s) {
        Map<Character, Character> matching = new HashMap<>();
        matching.put('(', ')');
        matching.put('[', ']');
        matching.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (matching.containsKey(c)) { // if c is an opening bracket
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char previousOpening = stack.pop();
                if (matching.get(previousOpening) != c) {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public static String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.charAt(stack.length() - 1) == c) {
                stack.deleteCharAt(stack.length() - 1);
            } else {
                stack.append(c);
            }
        }

        return stack.toString();
    }

    public static String removeKuplicates(String s, int k) {
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && checkKConsecutive(stack, k, c)) {
                for (int i = 1; i <= k - 1; i++) {
                    int index = stack.length() - i;
                    if (index >= 0 )
                    stack.deleteCharAt(stack.length() - i);
                }
            } else {
                stack.append(c);
            }
        }

        return stack.toString();
    }

    static boolean checkKConsecutive(StringBuilder stack, int k, char curr) {
        for (int i = 1; i <= k - 1; i++) {
            int index = stack.length() - i;
            if (index >= 0 && stack.charAt(index) == curr) {
                return false;
            }
        }
        return true;
    }


    public static String simplifyPath(String path) {

        // Initialize a stack
        Stack<String> stack = new Stack<String>();
        String[] components = path.split("/");

        // Split the input string on "/" as the delimiter
        // and process each portion one by one
        for (String directory : components) {

            // A no-op for a "." or an empty string
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {

                // If the current component is a "..", then
                // we pop an entry from the stack if it's non-empty
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {

                // Finally, a legitimate directory name, so we add it
                // to our stack
                stack.add(directory);
            }
        }

        // Stitch together all the directory names together
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);


        }

        return !result.isEmpty() ? result.toString() : "/";
    }


    public static String makeGood1(String s) {
        StringBuilder newS = new StringBuilder(s);

        // if s has less than 2 characters, we just return itself.
        while (newS.length() > 1) {
            // 'find' records if we find any pair to remove.
            boolean find = false;

            // Check every two adjacent characters, currChar and nextChar.
            for (int i = 0; i < newS.length() - 1; ++i) {
                char currChar = newS.charAt(i), nextChar = newS.charAt(i + 1);

                // If they make a pair, remove them from 's' and let 'find = true'.
                if (Math.abs(currChar - nextChar) == 32) {
                    newS.deleteCharAt(i);
                    newS.deleteCharAt(i);
                    find = true;
                    break;
                }
            }

            // If we cannot find any pair to remove, break the loop.
            if (!find) {
                break;
            }
        }
        return newS.toString();
    }


    public static String makeGood2(String s) {
        // Use stack to store the visited characters.
        Stack<Character> stack = new Stack<>();

        // Iterate over 's'.
        for (char currChar : s.toCharArray()) {
            // If the current character make a pair with the last character in the stack,
            // remove both of them. Otherwise, we the add current character to stack.
            if (!stack.isEmpty() && Math.abs(stack.lastElement() - currChar) == 32) {
                stack.pop();
            } else {
                stack.add(currChar);
            }
        }

        // Returns the string concatenated by all characters left in the stack.
        StringBuilder ans = new StringBuilder();
        for (char currChar : stack)
            ans.append(currChar);
        return ans.toString();
    }

    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(stack.lastElement() - c) == 32) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(s);

        return sb.toString();
    }

    public static String makeGood3(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - s.charAt(i)) == 32) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }

    public static void main(String[] args) {
        //System.out.println(removeDuplicates("abbaca"));
        // System.out.println(makeGood3("leEeetcode"));
        //System.out.println(removeKChars("abbaca", 2));
        //System.out.println(removeKChars("aaabbbcc", 3)); // Output: "cc"
        //System.out.println(removeKChars("deeedbbcccbdaa", 3)); // Output: "aa"
        System.out.println(removeKuplicates("aaabbbcccxxx", 3));
    }

    public static String removeKChars(String s, int k) {
        StringBuilder stack = new StringBuilder();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.charAt(stack.length() - 1) == c) {
                count++;
            } else {
                count = 1; // Reset the count for a new character
            }

            stack.append(c);

            if (count == k) {
                // Remove the last K characters from the stack
                for (int i = 0; i < k; i++) {
                    stack.deleteCharAt(stack.length() - 1);
                }
                count = 0; // Reset the count after removing K characters
            }
        }

        return stack.toString();
    }

}
