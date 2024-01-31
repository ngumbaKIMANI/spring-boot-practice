package com.ngumba.december;

public class S10DFSBinaryTree extends CreateBinaryTree {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

    }

    public static void main(String[] args) {
        //Integer[] values = {8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13};
        //TreeNode root = buildTree(values);
        //System.out.println(MaxDiff.maxAncestorDiff(root));
        Integer[] values = {1, 2, 3, 4, 5};
        TreeNode root = buildTree(values);
        System.out.println(LargestDiameter.longestPath(root));

        //convert tree back to list
        //List<Integer> treeList = treeToList(root);
        //Integer[] resultArray = treeList.toArray(new Integer[0]);
        //System.out.println("original values :" + Arrays.toString(values));
        //System.out.println("reversed tree   :" + Arrays.toString(resultArray));
    }

    static class MaxDiff {
        // record the required maximum difference
        static int result = 0;

        public static int maxAncestorDiff(TreeNode root) {
            if (root == null) {
                return 0;
            }
            result = 0;
            helper(root, root.val, root.val);
            return result;
        }

        static void helper(TreeNode node, int curMax, int curMin) {
            if (node == null) {
                return;
            }
            // update `result`
            int possibleResult = Math.max(Math.abs(curMax - node.val), Math.abs(curMin - node.val));
            result = Math.max(result, possibleResult);
            // update the max and min
            curMax = Math.max(curMax, node.val);
            curMin = Math.min(curMin, node.val);
            helper(node.left, curMax, curMin);
            helper(node.right, curMax, curMin);
            return;
        }
    }

    static class LargestDiameter {
        private static int diameter;

        private static int longestPath(TreeNode node) {
            if (node == null) {
                return 0;
            }
            // recursively find the longest path in
            // both left child and right child
            int leftPath = longestPath(node.left);
            int rightPath = longestPath(node.right);

            // update the diameter if left_path plus right_path is larger
            diameter = Math.max(diameter, leftPath + rightPath);

            // return the longest one between left_path and right_path;
            // remember to add 1 for the path connecting the node and its parent
            return Math.max(leftPath, rightPath) + 1;
        }

        public int diameterOfBinaryTree(TreeNode root) {
            diameter = 0;
            longestPath(root);
            return diameter;
        }
    }

}

