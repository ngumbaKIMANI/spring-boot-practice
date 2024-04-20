package com.ngumba.december;

import java.util.*;

public class S8Queue {
    static Queue<Integer> queue;

    public S8Queue() {
        queue = new LinkedList<>();
    }

    public static void main(String[] args) {
        // Declaration: Java supports multiple implementations, but we will using
        // the Queue interface with the LinkedList implementation. Specify the data type
        Queue<Integer> queue0 = new LinkedList<>();

        // If you want to initialize it with some initial values:
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, 3));

        // Enqueueing/adding elements:
        queue.offer(4);
        queue.offer(5);

        // De-queuing/removing elements:
        queue.poll(); // 1
        queue.poll(); // 2

        // Check if empty
        boolean b = queue.isEmpty(); // false

        // Check element at front of queue (next element to be removed)
        Integer b1 = queue.peek(); // 3

        // Get size
        int size = queue.size(); // 3

        System.out.println(ping(1));

    }

    public static int ping(int t) {
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }

        queue.offer(t);
        return queue.size();
    }
}

class MovingAverage {
    int size;
    List queue = new ArrayList<Integer>();

    public MovingAverage(int size) {
        this.size = size;

    }

    public double next(int val) {
        queue.add(val);
        // calculate the sum of the moving window
        int windowSum = 0;
        for (int i = Math.max(0, queue.size() - size); i < queue.size(); ++i)
            windowSum += (int) queue.get(i);

        return windowSum * 1.0 / Math.min(queue.size(), size);
    }

    public class DS3Strings {
        public static void main(String[] args) {
            String s = "JAMES";

            char[] array = s.toCharArray();
            Map<Integer, String> storage = new HashMap<>();
            //System.out.println(array);
            //System.out.println(s.substring(1, 3).length());

            System.out.println(longestPalindrome("madam"));


        }

        public static String longestPalindrome(String s) {
            String longestP = "";

            int left = 0;
            int right = s.length() - 1;

            int maxSize = 0;


            while (left < right) {
                System.out.println(s.charAt(left));
                System.out.println(s.charAt(right));
                if (s.charAt(left) == s.charAt(right)) {
                    String currentSubstring = s.substring(s.charAt(left), s.charAt(right));
                    maxSize = Math.max(maxSize, currentSubstring.length());

                    if (maxSize < currentSubstring.length()) {
                        maxSize = currentSubstring.length();
                        longestP = currentSubstring;
                    }
                }

                right--;
                left++;
            }


            return longestP;
        }
    }
}
