package com.ngumba.extra;

import com.ngumba.december.TreeNode;

class InsertIntoBST {
    public com.ngumba.december.TreeNode insertIntoBST(com.ngumba.december.TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        // insert into the right subtree
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        // insert into the left subtree
        else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}


