package com.byinal.ctci.tree.binary;

public class BinarySearchTree {

    Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        } else if(data <= root.data){
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }
}
