package com.ngumba.december;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class S9Monotonic {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                int j = stack.pop();
                answer[j] = i - j;
            }

            stack.push(i);
        }
        return answer;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            // maintain monotonic decreasing.
            // all elements in the deque smaller than the current one
            // have no chance of being the maximum, so get rid of them
            while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.removeLast();
            }

            queue.addLast(i);

            // queue[0] is the index of the maximum element.
            // if queue[0] + k == i, then it is outside the window
            if (queue.getFirst() + k == i) {
                queue.removeFirst();
            }

            // only add to the answer once our window has reached size k
            if (i >= k - 1) {
                ans[i - k + 1] = nums[queue.getFirst()];
            }
        }

        return ans;
    }

    public static int longestSubarray(int[] nums, int limit) {
        ArrayDeque<Integer> increasing = new ArrayDeque<>();
        ArrayDeque<Integer> decreasing = new ArrayDeque<>();
        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            // maintain the monotonic deques
            while (!increasing.isEmpty() && increasing.getLast() > nums[right]) {
                increasing.removeLast();
            }
            while (!decreasing.isEmpty() && decreasing.getLast() < nums[right]) {
                decreasing.removeLast();
            }

            increasing.addLast(nums[right]);
            decreasing.addLast(nums[right]);

            // maintain window property
            while (decreasing.getFirst() - increasing.getFirst() > limit) {
                if (nums[left] == decreasing.getFirst()) {
                    decreasing.removeFirst();
                }
                if (nums[left] == increasing.getFirst()) {
                    increasing.removeFirst();
                }
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > stack.peek())
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }

        while (!stack.empty())
            map.put(stack.pop(), -1);

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ans = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ans));
    }

}