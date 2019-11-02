package com.byinal.ctci.tree.binary;

import java.util.*;

public class DFSandBFS {

    public static void main(String[] args) {
        DFSandBFS dFSandBFS = new DFSandBFS();
        Node root = new Node(10);
        root = dFSandBFS.createBST(root);
        System.out.println("InOrder: ");
        dFSandBFS.dfsInOrder(root);
        System.out.println("\nPreOrder: ");
        int maxSum = dFSandBFS.dfsPreOrder(root, 0, 0);
        System.out.println("\nMax Sum of a Path: " + maxSum);
        System.out.println("PostOrder: ");
        dFSandBFS.dfsPostOrder(root);
        System.out.println("\nBFS: ");
        dFSandBFS.bfs(root);

        System.out.println("isBFSValid: " + dFSandBFS.verify(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        int heightOfTree = dFSandBFS.heightOfTree(root);
        System.out.println("Height of Tree: " + heightOfTree);
    }

    private void dfsInOrder(Node root) {
        if (root != null) {
            dfsInOrder(root.left);
            System.out.print(" " + root.data);
            dfsInOrder(root.right);
        }
    }

    private int dfsPreOrder(Node root, int sum, int maxSum) {
        if (root != null) {
            System.out.print(" " + root.data);
            sum += root.data;
            maxSum = dfsPreOrder(root.left, sum, maxSum);
            maxSum = dfsPreOrder(root.right, sum, maxSum);
        } else {
            maxSum = maxSum < sum ? sum : maxSum;
            sum = 0;
        }
        return maxSum;
    }

    private void dfsPostOrder(Node root) {
        if (root != null) {
            dfsPostOrder(root.left);
            dfsPostOrder(root.right);
            System.out.print(" " + root.data);
        }
    }


    private void bfs(Node currentNode) {
        Queue<Node> nodeQueue = new LinkedList<>();
        int maxNumberOfNodesInOneLevel = 0;
        while (currentNode != null) {
            System.out.print(" " + currentNode.data);
            if (currentNode.left != null) {
                nodeQueue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                nodeQueue.add(currentNode.right);
            }
            maxNumberOfNodesInOneLevel = maxNumberOfNodesInOneLevel < nodeQueue.size() ? nodeQueue.size() : maxNumberOfNodesInOneLevel;
            currentNode = nodeQueue.poll();
        }
        System.out.println("\nMaxNumberOfNodesInOneLevel: " + maxNumberOfNodesInOneLevel);
    }


    private boolean verify(Node root, int min, int max) {
        if (root == null) {
            return true;
        } else {
            boolean leftValid = verify(root.left, min, root.data) && root.data <= max;
            boolean rightValid = verify(root.right, root.data, max) && root.data > min;
            return leftValid && rightValid;
        }
    }

    private int heightOfTree(Node root) {
        if(root == null){
            return -1; //decide height of root's position.
        }
        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);
        return 1 + Math.max(left, right);
    }

    private Node createBST(Node root) {
        BinarySearchTree bst = new BinarySearchTree(root);
        root = bst.insert(root, 6);
        root = bst.insert(root, 3);
        root = bst.insert(root, 4);
        root = bst.insert(root, 8);
        root = bst.insert(root, 7);
        root = bst.insert(root, 9);
        root = bst.insert(root, 2);
        return root;
    }

}
