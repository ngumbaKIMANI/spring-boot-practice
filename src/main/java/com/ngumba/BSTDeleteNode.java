package com.ngumba;


public class BSTDeleteNode {
    public static void main(String[] args) {
        // Constructing a Binary Search Tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        // Create an instance of DeleteBST
        BSTDeleteNode deleteBST = new BSTDeleteNode();

        // Delete a key (2) from the BST
        int keyToDelete = 2;
        root = deleteBST.deleteBST(root, keyToDelete);

        // Display the modified BST after deletion
        System.out.println("BST after deleting key " + keyToDelete + ":");
        printInOrder(root);
    }

    // Helper method to print the tree using in-order traversal
    private static void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }

    public TreeNode deleteBST(TreeNode root, int key) {
        // Base case: If the tree is empty
        if (root == null) {
            return null;
        }

        // Recursive cases
        if (key < root.val) {
            // If the key is in the left subtree
            root.left = deleteBST(root.left, key);
        } else if (key > root.val) {
            // If the key is in the right subtree
            root.right = deleteBST(root.right, key);
        } else {
            // If the key is found at the current node, perform deletion

            // Case 1: Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Node with two children
            root.val = findMin(root.right); // Find the in-order successor
            root.right = deleteBST(root.right, root.val); // Delete the in-order successor
        }

        return root;
    }

    // Helper method to find the minimum value in a BST
    private int findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

}

