package com.ngumba.february;

import java.util.ArrayDeque;
import java.util.Deque;

public class MonotonicQueue {
    private Deque<Integer> queue;

    public MonotonicQueue() {
        queue = new ArrayDeque<>();
    }

    public static void main(String[] args) {
        MonotonicQueue monotonicQueue = new MonotonicQueue();

        monotonicQueue.push(3);
        monotonicQueue.push(1);
        monotonicQueue.push(5);
        monotonicQueue.push(2);

        System.out.println("Maximum element in the queue: " + monotonicQueue.getMax()); // Output: 5

        monotonicQueue.pop();

        System.out.println("Maximum element in the queue after popping: " + monotonicQueue.getMax()); // Output: 5
    }

    // Push an element to the back of the queue while maintaining monotonicity
    public void push(int val) {
        // Remove all elements from the back of the queue that are smaller than the new element
        while (!queue.isEmpty() && queue.getLast() < val) {
            queue.removeLast();
        }
        // Add the new element
        queue.addLast(val);
    }

    // Get the maximum element in the current queue
    public int getMax() {
        return queue.getFirst(); // The first element will always be the maximum in a non-increasing monotonic queue
    }

    // Pop the front element of the queue
    public void pop() {
        queue.removeFirst();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
