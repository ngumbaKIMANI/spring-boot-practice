package com.ngumba.november;

import java.util.Scanner;

public class DS4Strings {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of A: ");
        String A = sc.next();
        System.out.print("Enter the value of Bs: ");
        String B = sc.next();
        /* Enter your code here. Print output to STDOUT. */

        System.out.println(A.length() + B.length());

        if (A.compareTo(B) > 0) {
            System.out.println("Yes" + " : " + (int) A.charAt(0) + " : " + (int) B.charAt(0));
        } else {
            System.out.println("No" + " : " + (int) A.charAt(0) + " : " + (int) B.charAt(0));
        }


        System.out.println(
                A.replace(A.charAt(0), Character.toUpperCase(A.charAt(0))) +
                        " " +
                        B.replace(B.charAt(0), Character.toUpperCase(B.charAt(0))));

        System.out.println(" " + A.repeat(4));
        System.out.println(" " + A.compareTo(B));
        System.out.println(" " + A.concat(B));

        System.out.println(" " + A.substring(A.length() - 1, A.length()).toUpperCase());

        System.out.println(Character.isLetter('a'));
        System.out.println(Character.toString(5));
        System.out.println(Character.charCount(0x1F60D));
        System.out.println(Character.compare('a', 'x'));
        System.out.println(Character.getName(0x1F60D));
        System.out.println(Character.isSpaceChar(' '));
        System.out.println(Character.isSpaceChar('a'));

        int x = 5;

        // Using post-increment (x++)
        int resultPostIncrement = x++;
        System.out.println("Post-increment - Result: " + resultPostIncrement + ", x: " + x);

        // Reset x to 5
        x = 5;

        // Using pre-increment (++x)
        int resultPreIncrement = ++x;
        System.out.println("Pre-increment - Result: " + resultPreIncrement + ", x: " + x);




    }

    static{
        System.out.println("i am a static block");
    }


}
