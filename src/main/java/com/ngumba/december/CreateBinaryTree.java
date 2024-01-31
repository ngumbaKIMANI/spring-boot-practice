package com.ngumba.december;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CreateBinaryTree {
    protected static TreeNode buildTree(Integer[] values) {
        if (values.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeft = true;
        for (int i = 1; i < values.length; i++) {
            TreeNode node = queue.peek();
            if (values[i] != null) {
                TreeNode child = new TreeNode(values[i]);
                if (isLeft) {
                    node.left = child;
                } else {
                    node.right = child;
                }
                queue.offer(child);
            }
            if (!isLeft) {
                queue.poll();
            }
            isLeft = !isLeft; // flip the flag
        }
        return root;
    }

    private static List<Integer> treeToList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> nextLevelQueue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node != null) {
                result.add(node.val);
                // Add children to the next level's queue, including nulls.
                nextLevelQueue.add(node.left);
                nextLevelQueue.add(node.right);
            } else {
                result.add(null);
            }

            // When done with this level, move to the next one.
            if (queue.isEmpty()) {
                queue = nextLevelQueue;
                nextLevelQueue = new LinkedList<>();
            }
        }

        // Remove trailing nulls.
        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }

        return result;
    }
}
