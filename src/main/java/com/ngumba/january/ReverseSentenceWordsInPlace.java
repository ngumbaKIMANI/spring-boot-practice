package com.ngumba.january;

import java.util.Stack;

public class ReverseSentenceWordsInPlace {
    public static String reverseWords(String s) {
        int lastSpaceIndex = -1;
        char[] chArray = s.toCharArray();
        int len = s.length();

        int sIndex = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || chArray[i] == ' ') {
                reverseWord(sIndex, i - 1, chArray);
                sIndex = i + 1;
            }
        }
        return new String(chArray);
    }

    private static void reverseWord(int startIndex, int endIndex, char[] chArray) {
        while (startIndex < endIndex) {
            char temp = chArray[startIndex];
            chArray[startIndex] = chArray[endIndex];
            chArray[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    public static String reverseWordsStack(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            if (i == s.length() || s.charAt(i) == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
            } else {
                stack.add(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's go get girls"));
        System.out.println(reverseWordsStack("Let's go get girls"));
    }
}
