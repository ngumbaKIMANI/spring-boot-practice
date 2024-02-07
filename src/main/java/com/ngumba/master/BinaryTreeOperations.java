package com.ngumba.master;

import com.ngumba.december.TreeNode;
import com.ngumba.january.Node;

import java.util.*;

public class BinaryTreeOperations {

    static int diameter;

    public static int treeSum(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        return root.val + treeSum(root.left) + treeSum(root.right);
    }

    public static int treeMinValue(Node<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int minChild = Math.min(treeMinValue(root.left), treeMinValue(root.right));
        return Math.min(root.val, minChild);
    }

    public static boolean treeIncludes(Node<Integer> root, int target) {
        if (root == null) {
            return false;
        }
        if (target == root.val) {
            return true;
        }
        return treeIncludes(root.left, target) || treeIncludes(root.right, target);
    }

    public static Integer maxPathSum(Node<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return root.val + Math.max(maxPathSum(root.left), maxPathSum(root.right));
    }

    //also called maximum depth of a binary tree
    public static int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = treeHeight(root.left);
        int r = treeHeight(root.right);
        return 1 + Math.max(l, r);  // 1 + max height of left and right subtree
    }

    public static boolean isHeightBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isHeightBalanced(root.left) && isHeightBalanced(root.right);
    }


    public static int treeDepth(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(treeDepth(root.left), treeDepth(root.right));  // 1 + max depth of left and right subtree
    }

    public static int treeSize(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        return 1 + treeSize(root.left) + treeSize(root.right);  // 1 + size of left and right subtree

    }

    public static int treeLeafCount(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return treeLeafCount(root.left) + treeLeafCount(root.right);  // 1 + leaf count of left and right subtree
    }

    public static int treeLeafSum(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return treeLeafSum(root.left) + treeLeafSum(root.right);  // sum of leaf values of left and right subtree
    }

    public static int treeNodeCount(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        return 1 + treeNodeCount(root.left) + treeNodeCount(root.right);  // 1 + node count of left and right subtree
    }

    //bottom right value
    public static int bottomRightValue(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return bottomRightValue(root.right); // bottom right value of right subtree
    }

    //checks whether there exists a root-to-leaf path in a binary tree where the sum of the values along the path
    // equals a given target sum
    public static boolean hasPathSum(Node<Integer> root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    //Find the lowest common ancestor of two nodes in a binary tree.
    public static Node<Integer> lowestCommonAncestor(Node<Integer> root, Node<Integer> p, Node<Integer> q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        Node<Integer> left = lowestCommonAncestor(root.left, p, q);
        Node<Integer> right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right; // return the non-null node if found, otherwise return null
    }

    public static int diameterOfBinaryTree(Node<Integer> root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }

    public static int longestPath(Node<Integer> node) {
        if (node == null) {
            return 0;
        }
        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);
        diameter = Math.max(diameter, leftPath + rightPath);
        return Math.max(leftPath, rightPath) + 1; // max path length of left and right subtree + 1 for current node
    }

    public static int minimumTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minimumTreeDepth(root.right) + 1;
        } else if (root.right == null) {
            return minimumTreeDepth(root.left) + 1;
        }
        return Math.min(minimumTreeDepth(root.left), minimumTreeDepth(root.right)) +
                1; // min depth of left and right subtree + 1 for current node
    }

    //Find all duplicate subtrees in a binary tree.
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        findDuplicateSubtreesHelper(root, new HashMap<>(), result);
        return result;
    }

    private static String findDuplicateSubtreesHelper(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
        if (root == null) {
            return "#";
        }
        String left = findDuplicateSubtreesHelper(root.left, map, result);
        String right = findDuplicateSubtreesHelper(root.right, map, result);
        String current = root.val + "," + left + "," + right;
        if (map.getOrDefault(current, 0) == 1) {
            result.add(root);
        }
        map.put(current, map.getOrDefault(current, 0) + 1);
        return current;
    }

    //Find the length of the longest consecutive sequence in a binary tree.


    //Find the maximum width of a binary tree.
    public static int maxTreeWidth(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxWidth = Math.max(maxWidth, size);
            for (int i = 0; i < size; i++) {
                Node<Integer> current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        return maxWidth;
    }

    //Flatten a binary tree into a linked list in-place.
    public static void flattenBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        flattenBinaryTree(root.left);
        flattenBinaryTree(root.right);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        current.right = right;
    }


    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(7);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.right = new Node<>(7);
        root.left.left.left = new Node<>(2);

        //          1
        //        /   \
        //       2     5
        //      / \     \
        //     4   5     7
        //    /
        //   2

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        root1.left.left.left = new TreeNode(2);


        //System.out.println("treeSum :" + treeSum(root));
        //System.out.println("treeMinValue :" + treeMinValue(root));
        //System.out.println("treeIncludes :" + treeIncludes(root, 4));
        //System.out.println("maxPathSum :" + maxPathSum(root));
        System.out.println("treeHeight :" + treeHeight(root1));
        //System.out.println("treeDepth :" + treeDepth(root));
        //System.out.println("treeSize :" + treeSize(root));
        /*System.out.println("treeLeafCount :" + treeLeafCount(root));
        System.out.println("bottomRightValue :" + bottomRightValue(root));
        System.out.println("treeLeafSum :" + treeLeafSum(root));
        System.out.println("treeNodeCount :" + treeNodeCount(root));
        System.out.println("hasPathSum :" + hasPathSum(root, 4));
        //System.out.println("lowestCommonAncestry :"+ lowestCommonAncestor(root));
        System.out.println("diameterOfBinaryTree :" + diameterOfBinaryTree(root));
        System.out.println("maxTreeWidth :" + maxTreeWidth(root));*/
    }

    static class MaxDiffBtwNodeAndAncestor {
        // record the required maximum difference
        int result = 0;

        public int maxAncestorDiff(TreeNode root) {
            if (root == null) {
                return 0;
            }
            result = 0;
            helper(root, root.val, root.val);
            return result;
        }

        void helper(TreeNode node, int curMax, int curMin) {
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

    //class to find the deepest leaves sum using bfs
    static class DeepestLeavesSum {
        public int deepestLeavesSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int sum = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                sum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return sum;
        }

        public int deepestLeavesSum2(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return helper2(root, 0); // start at level 0
        }

        private int helper2(TreeNode node, int level) {
            if (node == null) {
                return 0;
            }
            if (level == 0) { // reached the deepest level
                return node.val;
            }
            return helper2(node.left, level - 1) + helper2(node.right, level - 1); // sum of left and right subtrees
            // at the next level - 1 (since we are at the current level)
        }

        //deepest level using a stack
        public int deepestLeavesSum3(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int sum = 0;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                int size = stack.size();
                sum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode node = stack.pop();
                    sum += node.val;
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                }
            }
            return sum;
        }
    }

    static class TreeDiameter {
        int diameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return diameter;
        }

        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = dfs(root.left);
            int rightHeight = dfs(root.right);
            //its possible longest path is not via root, so interject before returning to caller node
            diameter = Math.max(diameter, leftHeight + rightHeight);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    static public class LowestCommonAncestor {
        public static TreeNode findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // Base case: if the root is null or matches either p or q, it is the LCA.
            if (root == null || root == p || root == q) {
                return root;
            }

            // Recursively search for the LCA in the left and right subtrees.
            TreeNode leftLCA = findLowestCommonAncestor(root.left, p, q);
            TreeNode rightLCA = findLowestCommonAncestor(root.right, p, q);

            // If both leftLCA and rightLCA are non-null, root is the LCA.
            if (leftLCA != null && rightLCA != null) {
                return root;
            }

            // If one of leftLCA or rightLCA is non-null, return that as the LCA.
            return (leftLCA != null) ? leftLCA : rightLCA;
        }

        public static void main(String[] args) {
            /*
             * Example:
             *      3
             *     / \
             *    5   1
             *   / \ / \
             *  6  2 0  8
             *    / \
             *   7   4
             */
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(5);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(6);
            root.left.right = new TreeNode(2);
            root.right.left = new TreeNode(0);
            root.right.right = new TreeNode(8);
            root.left.right.left = new TreeNode(7);
            root.left.right.right = new TreeNode(4);

            TreeNode p = root.left; // Node with value 5
            TreeNode q = root.right.right; // Node with value 8

            TreeNode lca = findLowestCommonAncestor(root, p, q);

            System.out.println("Lowest Common Ancestor: " + lca.val);
        }
    }

    static public class MirrorBinaryTree {
        public static TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            // Swap the left and right subtrees.
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            // Recursively mirror the left and right subtrees.
            mirrorTree(root.left);
            mirrorTree(root.right);

            return root;
        }

        // Utility function to print the in-order traversal of a tree.
        private static void printInOrder(TreeNode node) {
            if (node != null) {
                printInOrder(node.left);
                System.out.print(node.val + " ");
                printInOrder(node.right);
            }
        }

        public static void main(String[] args) {
            /*
             * Example:
             * Original Tree:
             *      1
             *     / \
             *    2   3
             *   / \
             *  4   5
             *
             * Mirrored Tree:
             *      1
             *     / \
             *    3   2
             *       / \
             *      5   4
             */
            TreeNode originalTree = new TreeNode(1);
            originalTree.left = new TreeNode(2);
            originalTree.right = new TreeNode(3);
            originalTree.left.left = new TreeNode(4);
            originalTree.left.right = new TreeNode(5);

            System.out.println("Original Tree (In-order traversal):");
            printInOrder(originalTree);
            System.out.println();

            TreeNode mirroredTree = mirrorTree(originalTree);

            System.out.println("Mirrored Tree (In-order traversal):");
            printInOrder(mirroredTree);
        }
    }

    static public class BalancedBinaryTree {
        public static boolean isBalanced(TreeNode root) {
            return checkHeight(root) != -1;
        }

        private static int checkHeight(TreeNode node) {
            if (node == null) {
                return 0; // Height of an empty tree is 0.
            }

            // Calculate the height of the left subtree.
            int leftHeight = checkHeight(node.left);
            if (leftHeight == -1) {
                return -1; // Left subtree is unbalanced.
            }

            // Calculate the height of the right subtree.
            int rightHeight = checkHeight(node.right);
            if (rightHeight == -1) {
                return -1; // Right subtree is unbalanced.
            }

            // Check if the current subtree is balanced.
            if (Math.abs(leftHeight - rightHeight) > 1) {
                return -1; // Current subtree is unbalanced.
            }

            // Return the height of the current subtree.
            return Math.max(leftHeight, rightHeight) + 1;
        }

        public static void main(String[] args) {
            /*
             * Example:
             *      1
             *     / \
             *    2   3
             *   / \
             *  4   5
             */
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);

            boolean result = isBalanced(root);
            System.out.println("Is the tree balanced? " + result);
        }
    }

    static public class IdenticalBinaryTrees {
        public static boolean areIdentical(TreeNode root1, TreeNode root2) {
            // Base cases
            if (root1 == null && root2 == null) {
                return true; // Both trees are empty, they are identical.
            } else if (root1 == null || root2 == null) {
                return false; // One tree is empty, the other is not; they are not identical.
            }

            // Check if the values of corresponding nodes are equal.
            if (root1.val != root2.val) {
                return false;
            }

            // Recursively check the left and right subtrees.
            return areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right);
        }

        public static void main(String[] args) {
            /*
             * Example:
             * Trees 1 and 2 are identical.
             * Tree 1:
             *      1
             *     / \
             *    2   3
             *
             * Tree 2:
             *      1
             *     / \
             *    2   3
             */
            TreeNode root1 = new TreeNode(1);
            root1.left = new TreeNode(2);
            root1.right = new TreeNode(3);

            TreeNode root2 = new TreeNode(1);
            root2.left = new TreeNode(2);
            root2.right = new TreeNode(3);

            boolean result = areIdentical(root1, root2);
            System.out.println("Are the trees identical? " + result);
        }
    }


}
