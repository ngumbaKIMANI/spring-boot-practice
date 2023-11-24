package com.ngumba.november;
import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        scanner.close();

        if (s.trim().isEmpty()) {
            System.out.println("0");
        } else {
            // Split the string using the specified regular expression
            String[] tokens = s.trim().split("[ !,?._'@]+");


            // Print the number of tokens
            System.out.println(tokens.length);

            // Print each token on a new line
            for (String token : tokens) {
                System.out.println(token);
            }
        }
    }
}

