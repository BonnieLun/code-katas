package com.byinal.ctci.linkedLists;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return data == node.data &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(next, data);
    }
}
