package com.ngumba.december;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S10BinarySearchTree extends CreateBinaryTree {

    public static int rangeSumBST1(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        if (low <= root.val && root.val <= high) {
            ans += root.val;
        }
        if (low < root.val) {
            ans += rangeSumBST1(root.left, low, high);
        }
        if (root.val < high) {
            ans += rangeSumBST1(root.right, low, high);
        }

        return ans;
    }

    public static int rangeSumBST2(TreeNode root, int low, int high) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int ans = 0;

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (low <= node.val && node.val <= high) {
                ans += node.val;
            }
            if (node.left != null && low < node.val) {
                stack.push(node.left);
            }
            if (node.right != null && node.val < high) {
                stack.push(node.right);
            }
        }

        return ans;
    }

    public static int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        dfs(root, values);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            ans = Math.min(ans, values.get(i) - values.get(i - 1));
        }
        return ans;
    }

    public static void dfs(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }

        dfs(node.left, values);
        values.add(node.val);
        dfs(node.right, values);
    }

    public static int getMinimumDifference2(TreeNode root) {
        List<Integer> values = iterativeInorder(root);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            ans = Math.min(ans, values.get(i) - values.get(i - 1));
        }

        return ans;
    }

    public static List<Integer> iterativeInorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> values = new ArrayList<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                values.add(curr.val);
                curr = curr.right;
            }
        }

        return values;
    }

    public static boolean isValidBST(TreeNode root) {
        return dfsV(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean dfsV(TreeNode node, long small, long large) {
        if (node == null) {
            return true;
        }

        if (small >= node.val || node.val >= large) {
            return false;
        }

        boolean left = dfsV(node.left, small, node.val);
        boolean right = dfsV(node.right, node.val, large);
        return left && right;
    }

    public static void main(String[] args) {
        Integer[] values = {10, 5, 15, 3, 7, 18};
        TreeNode root = buildTree(values);
        System.out.println(rangeSumBST1(root, 7, 15));
    }

}


