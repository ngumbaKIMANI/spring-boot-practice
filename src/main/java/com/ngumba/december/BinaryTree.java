package com.ngumba.december;

public class BinaryTree {
    Node root;

    public void constructTree(int[] values, int start, int end) {
        root = addNode(values, start, end);
    }

    public Node addNode(int[] values, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(values[mid]);

        node.left = addNode(values, start, mid - 1);
        node.right = addNode(values, mid + 1, end);

        return node;
    }

    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.value + " ");
            inOrderTraversal(node.right);
        }
    }
}
