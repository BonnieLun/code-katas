package com.byinal.ctci.linkedLists;


import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/*
Remove Dups: Write code to remove duplicates from an unsorted linked list. FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDups {

    public static void main(String[] args) {
        Node listForfirstAlgorithm = new Node(1);
        listForfirstAlgorithm.appendToTail(2);
        listForfirstAlgorithm.appendToTail(3);
        listForfirstAlgorithm.appendToTail(2);
        listForfirstAlgorithm.appendToTail(1);
        listForfirstAlgorithm.appendToTail(4);
        listForfirstAlgorithm.appendToTail(3);

        assertEquals(listForfirstAlgorithm.toString(), "1232143");
        removeDuplicateWithoutBuffer(listForfirstAlgorithm);
        assertEquals(listForfirstAlgorithm.toString(), "1234");


        Node listForSecondAlgorith = new Node(1);
        listForSecondAlgorith.appendToTail(2);
        listForSecondAlgorith.appendToTail(3);
        listForSecondAlgorith.appendToTail(2);
        listForSecondAlgorith.appendToTail(1);
        listForSecondAlgorith.appendToTail(4);
        listForSecondAlgorith.appendToTail(3);
        assertEquals(listForSecondAlgorith.toString(), "1232143");
        removeDuplicateWithoutBuffer(listForSecondAlgorith);
        assertEquals(listForSecondAlgorith.toString(), "1234");
    }


    // Bad Time complexity O(n^2) but good space complexity O(1) space
    private static void removeDuplicateWithoutBuffer(Node head) {
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
    private static void removeDupsWithBuffer(Node node) {
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

