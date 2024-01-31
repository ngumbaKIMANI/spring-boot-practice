package com.ngumba.leetcode;


public class RecursionTest {

    // Function to swap pairs in a linked list
    public static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next = swapPairs(secondNode.next);


        secondNode.next = firstNode;

        return secondNode; // Placeholder, replace with actual result
    }

    public static ListNode reverseLinkedList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode head = reverseLinkedList(node.next);
        node.next.next = node;
        node.next = null;

        return head;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        // Create a sample linked list for demonstration
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Print the original linked list
        System.out.println("Original Linked List:");
        printLinkedList(head);

        // Call the swapPairs function
        ListNode swappedHead = swapPairs(head);
        //ListNode swappedHead = reverseLinkedList(head);

        // Print the swapped linked list
        System.out.println("\nLinked List After Swapping Pairs:");
        printLinkedList(swappedHead);
    }

    // Utility method to print a linked list
    private static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    void fun(int n) {

        if (n == 0) {
            return;
        }
        System.out.println(n);
        fun(n-1);

    }

}
