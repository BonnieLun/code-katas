package com.byinal.ctci.tree.binary;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 (where we allow a node to be a descendant of itself).”
      10
    6    15
  3   8
   4 7  9

input 3, 7 output: 6
Lowest Common Ancestor
 */
public class LCA {

    public static void main(String[] args) {
        LCA lca = new LCA();
        Node root = new Node(10);
        lca.createBST(root);
        System.out.println(lca.findLCA(root, 4, 9));
        System.out.println(lca.findLCAWithoutExtraSpace(root, 4, 9));

    }

    //this solution needs extra space and time comp O(n)
    private Node findLCA(Node root, int p, int q){
        List<Node> pathToNodeP = new ArrayList<>();
        List<Node> pathToNodeQ = new ArrayList<>();
        pathToNode(root, p, pathToNodeP);
        pathToNode(root, q, pathToNodeQ);
        System.out.println(pathToNodeP);
        System.out.println(pathToNodeQ);
        Node result = null;
        for (int i = 0; i < pathToNodeP.size() && i < pathToNodeQ.size(); i++){
            Node nodeToP = pathToNodeP.get(i);
            Node nodeToQ = pathToNodeQ.get(i);
            if(nodeToP.data == nodeToQ.data){
                result = nodeToP;
            }
        }
        return result;
    }


    private void pathToNode(Node root, int dataToFind, List<Node> path) {
        if (root != null) {
            path.add(root);
            if(root.data > dataToFind){
                pathToNode(root.left, dataToFind, path);
            } else if (root.data < dataToFind) {
                pathToNode(root.right, dataToFind, path);
            }
        }
    }


    private Node findLCAWithoutExtraSpace(Node root, int dataP, int dataQ){
        if(root == null) return null;
        if(root.data == dataP || root.data == dataQ) return root;
        Node left = findLCAWithoutExtraSpace(root.left, dataP, dataQ);
        Node right = findLCAWithoutExtraSpace(root.right, dataP, dataQ);
        if(left!=null && right!=null) return root;
        if(left==null && right==null) return null;
        return left != null ? left : right;
    }



    private Node createBST(Node root) {
        BinarySearchTree bst = new BinarySearchTree(root);
        root = bst.insert(root, 6);
        root = bst.insert(root, 3);
        root = bst.insert(root, 4);
        root = bst.insert(root, 8);
        root = bst.insert(root, 7);
        root = bst.insert(root, 9);
        root = bst.insert(root, 15);
        return root;
    }


}
