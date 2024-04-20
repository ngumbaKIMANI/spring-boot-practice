package com.ngumba.december;

import java.util.*;

public class S12Greedy {
    public static void main(String[] args) {
        // DestroyAsteroids dA = new DestroyAsteroids();
        //int[] asteroids = {3, 9, 19, 21};
        //System.out.println(dA.asteroidsDestroyed(10, asteroids));

        //int k = 2;
        //int[] nums = {3, 6, 1, 2, 5};
        //ArrayPartitionW aP = new ArrayPartitionW();
        //System.out.println(aP.partitionArray(nums, k));

        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};
        IPO ipo = new IPO();
        System.out.println(ipo.findMaximizedCapital(k, w, profits, capital));
    }
}

class DestroyAsteroids {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currMass = mass;
        for (int asteroid : asteroids) {
            if (asteroid > currMass) {
                return false;
            }
            currMass += asteroid;
        }

        return true;
    }


}

class ArrayPartitionW {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - min > k) {
                min = nums[i];
                ans++;
            }
        }
        return ans;
    }


}

class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i] = new int[]{capital[i], profits[i]};
        }

        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 0;

        for (int j = 0; j < k; j++) {
            while (i < n && projects[i][0] <= w) {
                heap.add(projects[i][1]);
                i++;
            }

            if (heap.isEmpty()) {
                return w;
            }

            w += heap.remove();
        }

        return w;
    }
}

class S12Solution1 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        List<Integer> ordered = new ArrayList<>();
        for (int val : counts.values()) {
            ordered.add(val);
        }

        Collections.sort(ordered, Comparator.reverseOrder());
        while (k > 0) {
            int val = ordered.get(ordered.size() - 1);
            if (val <= k) {
                k -= val;
                ordered.remove(ordered.size() - 1);
            } else {
                break;
            }
        }

        return ordered.size();
    }
}

class S12Solution2 {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        int i = 0;
        int j = people.length - 1;
        Arrays.sort(people);

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }

            j--;
            ans++;
        }

        return ans;
    }
}
