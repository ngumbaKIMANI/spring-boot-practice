package com.ngumba.january;

public class BinaryTreeOperations {

    public static int treeSum(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        return root.val + treeSum(root.left) + treeSum(root.right);
    }

    public static Double treeMinValue(Node<Double> root) {
        if (root == null) {
            return Double.POSITIVE_INFINITY;
        }
        double minChild = Math.min(treeMinValue(root.left), treeMinValue(root.right));
        return Math.min(root.val, minChild);
    }

    public static boolean treeIncludes(Node<String> root, String target) {
        if (root == null) {
            return false;
        }
        if (target.equals(root.val)) {
            return true;
        }
        return treeIncludes(root.left, target) || treeIncludes(root.right, target);
    }

    public static Double maxPathSum(Node<Double> root) {
        if (root == null) {
            return Double.NEGATIVE_INFINITY;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return root.val + Math.max(maxPathSum(root.left), maxPathSum(root.right));
    }


}
