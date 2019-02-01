package com.byinal.ctci.linkedLists;

public class Node {

    Node next = null;
    int data;

    public Node(int d) {
        this.data = d;
    }

    public void appendToTail(int newData) {
        Node newNode = new Node(newData);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = newNode;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node n = this;
        while (n != null) {
            builder.append(n.data);
            n = n.next;
        }
        return builder.toString();
    }
}
