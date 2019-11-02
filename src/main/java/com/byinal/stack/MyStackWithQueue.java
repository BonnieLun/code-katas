package com.byinal.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackWithQueue {

    private Queue<Integer> firstQueue = new LinkedList<>();
    private Queue<Integer> tempQueue = new LinkedList<>();
    private Integer top;

    //V1 efficient push with non-efficient pop
    public void push(int element) {
        firstQueue.add(element);
        top = element;
    }


    public Integer peek() {
        return top;
    }

    public boolean isEmpty(){
        return firstQueue.isEmpty();
    }

    //V1 non-efficient pop with efficient push
    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        while (firstQueue.size() > 1){
            Integer poll = firstQueue.poll();
            tempQueue.add(poll);
            top = poll;
        }
        Integer popElement = firstQueue.poll();
        firstQueue = tempQueue;
        tempQueue = new LinkedList<>();
        return popElement;
    }

    //V2 non-efficient push with efficient pop
    public void pushV2(int element){
        while (!firstQueue.isEmpty()){
            tempQueue.add(firstQueue.poll());
        }
        firstQueue.add(element);
        while (!tempQueue.isEmpty()){
            firstQueue.add(tempQueue.poll());
        }
        top = element;
    }

    //V2 efficient pop with non-efficient push
    public Integer popV2(){
        Integer popElement = firstQueue.poll();
        top = firstQueue.peek();
        return popElement;
    }

    public static void main(String[] args) {
        MyStackWithQueue myStack = new MyStackWithQueue();
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.pop());
        System.out.println("V1 Efficient Push, NonEfficient Pop");
        System.out.println("--------------------------------------");
        myStack.push(10);
        myStack.push(9);
        myStack.push(8);
        myStack.push(7);
        myStack.push(6);
        myStack.push(5);
        myStack.push(4);
        System.out.println("Peek: " + myStack.peek());
        System.out.println("Pop: " + myStack.pop());
        System.out.println("Pop: " + myStack.pop());
        myStack.push(11);
        System.out.println("Pop: " + myStack.pop());
        System.out.println("Peek: " + myStack.peek());

        System.out.println("V2 NonEfficient Push, Efficient Pop");
        System.out.println("--------------------------------------");
        myStack = new MyStackWithQueue();
        myStack.pushV2(10);
        myStack.pushV2(9);
        myStack.pushV2(8);
        myStack.pushV2(7);
        myStack.pushV2(6);
        myStack.pushV2(5);
        myStack.pushV2(4);
        System.out.println("Peek: " + myStack.peek());
        System.out.println("Pop: " + myStack.popV2());
        System.out.println("Pop: " + myStack.popV2());
        myStack.pushV2(11);
        System.out.println("Pop: " + myStack.popV2());
        System.out.println("Peek: " + myStack.peek());

    }
}
