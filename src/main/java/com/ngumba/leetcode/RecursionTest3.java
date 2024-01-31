package com.ngumba.leetcode;

public class RecursionTest3 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public static int sumOfNodes(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int leftSum = sumOfNodes(node.left);
            int rightSum = sumOfNodes(node.right);

            return node.val + leftSum + rightSum;
        }
    }

    public static class Main {
        public static void main(String[] args) {
            // Create a sample binary tree
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);

            // Calculate the sum of all node values
            int totalSum = Solution.sumOfNodes(root);

            // Print the result
            System.out.println("Sum of all node values: " + totalSum);
        }
    }

}
