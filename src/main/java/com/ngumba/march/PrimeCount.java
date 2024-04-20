package com.ngumba.march;

public class PrimeCount {

    public static int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
