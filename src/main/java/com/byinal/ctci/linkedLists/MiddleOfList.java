package com.byinal.ctci.linkedLists;

public class MiddleOfList {

    public static void main(String[] args) {
        MyLinkedList myLinkedListForFirstAlgorith = new MyLinkedList();
        Node head = new Node(1);
        myLinkedListForFirstAlgorith.appendToTail(head);
        myLinkedListForFirstAlgorith.appendToTail(2);
        myLinkedListForFirstAlgorith.appendToTail(3);
        myLinkedListForFirstAlgorith.appendToTail(4);
        myLinkedListForFirstAlgorith.appendToTail(5);
        myLinkedListForFirstAlgorith.appendToTail(6);
        myLinkedListForFirstAlgorith.appendToTail(7);
        System.out.println(findMiddleNode(myLinkedListForFirstAlgorith.head).data);
    }

    private static Node findMiddleNode(Node head) {
        Node slowPointer = head, fastPointer = head;
        while (fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            if (fastPointer == null) {
                return slowPointer;
            }
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }
}
