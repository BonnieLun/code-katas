package com.byinal.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackWithSingleQueue {

    private Queue<Integer> queue = new LinkedList<>();

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        Integer popedElement;
        for (int i = 0; i < queue.size(); i++) {
            if(i == queue.size() - 1){
                return queue.remove();
            }else {
                Integer element = queue.remove();
                queue.add(element);
            }
        }
        return null;
    }

    public void push(Integer element){
        queue.add(element);
    }


    public static void main(String[] args) {
        MyStackWithSingleQueue myStack = new MyStackWithSingleQueue();
        myStack.push(10);
        myStack.push(9);
        myStack.push(8);
        myStack.push(7);
        myStack.push(6);
        myStack.push(5);
        myStack.push(4);
        System.out.println("Pop: " + myStack.pop());
        System.out.println("Pop: " + myStack.pop());
        myStack.push(11);
        System.out.println("Pop: " + myStack.pop());
        System.out.println("Pop: " + myStack.pop());
        System.out.println("Pop: " + myStack.pop());
    }

}
