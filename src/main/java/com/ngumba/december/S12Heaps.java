package com.ngumba.december;

import java.util.*;

public class S12Heaps {

    public static void heapTest() {
        // In Java, we will use the PriorityQueue interface and the
        // PriorityQueue implementation. By default, this implements
        // a min heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // Add to heap
        heap.add(1);
        heap.add(2);
        heap.add(3);

        // Check minimum element
        Integer i = heap.peek(); // 1

        // Pop minimum element
        heap.remove(); // 1

        // Get size
        int s = heap.size(); // 2

        // Bonus: if you want a max heap instead, you can pass
        // Comparator.reverseOrder() to the constructor:
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    private static void heapPlayground() {
        // Note: Java PriorityQueue implements a min heap by default

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        //PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int[] nums = {67, 341, 234, -67, 12, -976};

        for (int num : nums) {
            heap.add(num);
        }

        heap.add(7451);
        heap.add(-5352);

        // The numbers will be printed in sorted order
        while (!heap.isEmpty()) {
            System.out.println(heap.remove());
        }
    }

    public static void main(String[] args) {
        //heapPlayground();
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(Solution.lastStoneWeight(stones));
    }

    static class Solution {
        public static int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
            for (int stone : stones) {
                heap.add(stone);
            }

            while (heap.size() > 1) {
                int first = heap.remove();
                int second = heap.remove();
                if (first != second) {
                    heap.add(first - second);
                }
            }

            return heap.isEmpty() ? 0 : heap.remove();
        }
    }

    static class Solution2 {
        public static int halveArray(int[] nums) {
            double target = 0;
            PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());

            for (double num : nums) {
                target += num;
                heap.add(num);
            }

            target /= 2;
            int ans = 0;
            while (target > 0) {
                ans++;
                double x = heap.remove();
                target -= (x / 2);
                heap.add(x / 2);
            }

            return ans;
        }
    }

    class MedianFinder {
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        ;

        public void addNum(int num) {
            maxHeap.add(num);
            minHeap.add(maxHeap.remove());
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.remove());
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            }

            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }

    class Solution4 {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> counts = new HashMap<>();
            for (int num : nums) {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> counts.get(n1) - counts.get(n2));
            for (int num : counts.keySet()) {
                heap.add(num);
                if (heap.size() > k) {
                    heap.remove();
                }
            }

            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = heap.remove();
            }

            return ans;
        }
    }

    class Solution5 {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> {
                if (Math.abs(n1 - x) == Math.abs(n2 - x)) {
                    return n2 - n1;
                }

                return Math.abs(n2 - x) - Math.abs(n1 - x);
            });

            for (int num : arr) {
                heap.add(num);
                if (heap.size() > k) {
                    heap.remove();
                }
            }

            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                ans.add(heap.remove());
            }

            Collections.sort(ans);
            return ans;
        }
    }
}