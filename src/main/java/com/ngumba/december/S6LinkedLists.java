package com.ngumba.december;

//Given the head of a linked list
// with an odd number of nodes head,
// return the value of the node in the middle.
public class S6LinkedLists {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.println(getMiddle(node1));
    }

    static int getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.val;
    }

    //Given the head of a linked list, determine if the linked list has a cycle.
    static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    //Given the head of a linked list and an integer k, return the Kth
    //node from the end.
    static ListNode findNode(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;

        //move fast pointer first to have a head start
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        //now move the slow pointer
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //Given the head of a singly linked list, return the middle node of
    // the linked list.
    static ListNode midOfSinglyLL(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
    // Return the linked list sorted as well.
    static ListNode removeDuplicateSort(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    //24. Swap Nodes in Pairs

    public static ListNode swapPairs(ListNode head) {
        // Check edge case: linked list has 0 or 1 nodes, just return
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = head.next;     // Step 5
        ListNode prev = null;           // Initialize for step 3
        while (head != null && head.next != null) {
            if (prev != null) {
                prev.next = head.next;  // Step 4
            }
            prev = head;                // Step 3

            // Step 2
            ListNode nextNode = head.next.next;
            head.next.next = head;      // Step 1

            head.next = nextNode;       // Step 6
            head = nextNode;            // Move to next pair (Step 3)
        }

        return dummy;
    }
}



