package com.ngumba.microsoft;

public class StringCountMatchingPrefixAndSuffix {
    public int solution(String S) {
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(0)) {
                count++;
            }
        }

        if (S.charAt(0) == S.charAt(S.length() - 1)) {
            count += S.length() - 1;
        }

        return count;
    }

}
