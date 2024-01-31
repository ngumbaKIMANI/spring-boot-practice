package com.ngumba.november;


import java.util.Scanner;

class IsAnagram {

    static boolean S2isAnagram(String a, String b) {
        // Complete the function
        a = a.toLowerCase();
        b = b.toLowerCase();

        int CHARACTER_RANGE = 256;

        if (a.length() != b.length()) {
            return false;
        }

        int count[] = new int[CHARACTER_RANGE];


        // Increment counts for characters in string 'a'
        for (char c : a.toCharArray()) {
            count[c - 'a']++;
        }

        // Decrement counts for characters in string 'b'
        for (char c : b.toCharArray()) {
            count[c - 'a']--;
        }

        for (int i = 0; i < CHARACTER_RANGE; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = S2isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
