package com.ngumba.november;

import java.util.Scanner;

public class Solution1 {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);

        for (int i = 0; i <= s.length() - k; i++) {
            String st = s.substring(i, i + k);
            if (st.compareTo(smallest) < 0) {
                smallest = st;
            } if (st.compareTo(largest) > 0) {
                largest = st;
            }
        }

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();


        System.out.println(getSmallestAndLargest(s, k));
    }


}
