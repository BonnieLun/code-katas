package com.byinal.ctci.tree.binary;

public class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("data=").append(data);
//        sb.append(", left=").append(left);
//        sb.append(", right=").append(right);
        sb.append('}');
        return sb.toString();
    }
}
