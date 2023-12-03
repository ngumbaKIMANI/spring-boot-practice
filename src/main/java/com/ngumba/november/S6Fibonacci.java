package com.ngumba.november;

import java.util.Scanner;

public class S6Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        int n2=n;

        System.out.println(fibo(n2));

        System.out.println("Fibonacci Series up to " + n + " terms:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        scanner.close();
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    private static int fibo(int n) {

        if (n < 2) {
            return n;
        }

        return fibo(n - 1) + fibo(n - 2);
    }
}
