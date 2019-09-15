package com.byinal.ctci.linkedLists;


import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/*
Remove Dups: Write code to remove duplicates from an unsorted linked list. FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDups {

    public static void main(String[] args) {
        MyLinkedList myLinkedListForFirstAlgorith = new MyLinkedList();
        Node head = new Node(1);
        myLinkedListForFirstAlgorith.appendToTail(head);
        myLinkedListForFirstAlgorith.appendToTail(2);
        myLinkedListForFirstAlgorith.appendToTail(3);
        myLinkedListForFirstAlgorith.appendToTail(2);
        myLinkedListForFirstAlgorith.appendToTail(1);
        myLinkedListForFirstAlgorith.appendToTail(4);
        myLinkedListForFirstAlgorith.appendToTail(3);

        assertEquals(myLinkedListForFirstAlgorith.toString(), "1232143");
        removeDuplicateWithoutBuffer(myLinkedListForFirstAlgorith);
        assertEquals(myLinkedListForFirstAlgorith.toString(), "1234");


        MyLinkedList myLinkedListForSecondAlgorith = new MyLinkedList();
        Node headForSecondAlgo  = new Node(1);
        myLinkedListForSecondAlgorith.appendToTail(headForSecondAlgo);
        myLinkedListForSecondAlgorith.appendToTail(2);
        myLinkedListForSecondAlgorith.appendToTail(3);
        myLinkedListForSecondAlgorith.appendToTail(2);
        myLinkedListForSecondAlgorith.appendToTail(1);
        myLinkedListForSecondAlgorith.appendToTail(4);
        myLinkedListForSecondAlgorith.appendToTail(3);
        assertEquals(myLinkedListForSecondAlgorith.toString(), "1232143");
        removeDuplicateWithoutBuffer(myLinkedListForSecondAlgorith);
        assertEquals(myLinkedListForSecondAlgorith.toString(), "1234");
    }


    // Bad Time complexity O(n^2) but good space complexity O(1) space
    private static void removeDuplicateWithoutBuffer(MyLinkedList myLinkedList) {
        Node head = myLinkedList.head;
        while (head != null) {
            Node nextNode = head.next;
            Node prev = head;
            while (nextNode != null) {
                if (head.data == nextNode.data) {
                    prev.next = nextNode.next;
                }
                prev = nextNode;
                nextNode = nextNode.next;
            }
            head = head.next;
        }
    }

    //Good time complexity O(N) but bad space complexity because of buffer(HashSet) used
    private static void removeDupsWithBuffer(MyLinkedList myLinkedList) {
        Node node = myLinkedList.head;
        HashSet<Integer> values = new HashSet<>();
        Node prev = null;
        while (node != null) {
            if (values.contains(node.data)) {
                prev.next = node.next;
            } else {
                values.add(node.data);
                prev = node;
            }
            node = node.next;
        }
    }

}

