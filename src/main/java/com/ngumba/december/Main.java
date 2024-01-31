package com.ngumba.december;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] values = {0, 1, 2, 3, 4, 5};
        tree.constructTree(values, 0, values.length - 1);

        System.out.println("Inorder traversal of the constructed tree is:");
        tree.inOrderTraversal(tree.root);
    }
}
