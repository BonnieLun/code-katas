package com.byinal.stack;

public class MyStackWithArray {

    private int capacity;
    private int[] elements;
    private int elementCount = 0;

    public MyStackWithArray(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
    }

    public int size() {
        return elementCount;
    }

    public boolean isFull() {
        return size() == capacity;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack is full. Can not push new element");
        } else {
            elements[elementCount] = element;
            elementCount++;
        }
    }

    public int peek() {
        return elements[elementCount - 1];
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        int element = peek();
        elements[elementCount - 1] = 0;
        elementCount--;
        return element;
    }


    public static void main(String[] args) {
        MyStackWithArray myStack = new MyStackWithArray(10);
        System.out.println(myStack.size());
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.isFull());
        System.out.println(myStack.pop());
        myStack.push(10);
        myStack.push(9);
        myStack.push(8);
        myStack.push(7);
        myStack.push(6);
        myStack.push(5);
        myStack.push(4);
        System.out.println("Peek: " + myStack.peek());
        System.out.println("Full: " + myStack.isFull());
        System.out.println("Pop: " + myStack.pop());
        System.out.println("Pop: " + myStack.pop());
        myStack.push(11);
        System.out.println("Full: " + myStack.isFull());
        System.out.println("Pop: " + myStack.pop());
        System.out.println("Peek: " + myStack.peek());
    }

}
