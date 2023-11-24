package com.ngumba.october;

import java.util.Scanner;

public class ReverseArray {

    public static void formatString() {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");

        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            //Complete this line
            System.out.printf("%-15S%03d%n", s1, x);
        }
        System.out.println("================================");

    }


    public static void main(String[] args) {
        //System.out.println(reverseString(new char[]{'j', 'a', 'm', 'e', 's', '0'}));
        formatString();
    }

    public static char[] reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        return s;
    }
}

