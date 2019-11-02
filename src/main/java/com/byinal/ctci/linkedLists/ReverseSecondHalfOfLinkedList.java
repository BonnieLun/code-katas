package com.byinal.ctci.linkedLists;

import java.util.Stack;

public class ReverseSecondHalfOfLinkedList {

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
        reverseSecondHalf(head);
        System.out.println(myLinkedListForFirstAlgorith.toString());
    }

    private static void reverseSecondHalf(Node head) {
        Stack<Node> stack = new Stack();
        Node slowPointer = head, fastPointer = head;
        stack.push(fastPointer);
        stack.push(fastPointer.next);
        while (fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            if (fastPointer == null) {
                break;
            }
            stack.push(fastPointer);
            if (fastPointer.next != null) {
                stack.push(fastPointer.next);
            }
            slowPointer = slowPointer.next;
        }
        Node middleNode = slowPointer;
        Node popedNode = stack.pop();
        while (popedNode.data != middleNode.data && slowPointer != null) {
            popedNode.next = null;
            slowPointer.next = popedNode;
            popedNode = stack.pop();
            slowPointer = slowPointer.next;
        }
    }

}
