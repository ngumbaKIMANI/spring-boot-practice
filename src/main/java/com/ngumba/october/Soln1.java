package com.ngumba.october;

import java.util.HashMap;
import java.util.Map;

class Soln1 {

        public int solution(int[] A, int S) {
            int n = A.length;
            long totalSum = 0;
            int count = 0;
            Map<Long, Integer> sumCount = new HashMap<>();

            for (int i = 0; i < n; i++) {
                totalSum += A[i];
                long diff = totalSum - (long) i * S;

                if (diff == 0) {
                    count++;
                }

                if (sumCount.containsKey(diff)) {
                    count += sumCount.get(diff);
                }

                sumCount.put(totalSum, sumCount.getOrDefault(totalSum, 0) + 1);

                if (count > 1_000_000_000) {
                    return 1_000_000_000;
                }
            }

            return count;

    }

    public static void main(String[] args) {
        Soln1 s= new Soln1();
        System.out.println(s.solution(new int[]{2, 1, 3}, 2));

    }
}
