package com.byinal.ctci.linkedLists;

public class Node {

    Node next = null;
    int data;

    public Node(int d) {
        this.data = d;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("next=").append(next);
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
