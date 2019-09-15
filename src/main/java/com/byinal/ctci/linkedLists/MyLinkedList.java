package com.byinal.ctci.linkedLists;

public class MyLinkedList {

    Node head;

    public void appendToTail(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            Node n = head;
            while (n.next != null)
                n = n.next;

            n.next = newNode;
        }
    }

    public void appendToTail(int newData) {
        Node newNode = new Node(newData);
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = newNode;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node n = head;
        while (n != null) {
            builder.append(n.data);
            n = n.next;
        }
        return builder.toString();
    }

}
