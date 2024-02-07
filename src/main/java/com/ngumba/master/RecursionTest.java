package com.ngumba.master;

public class RecursionTest {
    public static int sumNumbers(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumNumbers(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sumNumbers(5));
    }

}
