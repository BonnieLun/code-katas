package com.byinal.queue;

import java.util.Stack;

import static org.junit.Assert.assertTrue;


public class MyQueueWithStack {

    private Stack<Integer> firstStack = new Stack();
    private Stack<Integer> tempStack = new Stack();


    public void enqueu(Integer element) {
        firstStack.push(element);
    }

    public Integer dequeu(){
        while (firstStack.size() > 1){
            tempStack.push(firstStack.pop());
        }
        Integer dequeuedElement = firstStack.pop();
        while (!tempStack.empty()){
            firstStack.push(tempStack.pop());
        }
        return dequeuedElement;
    }

    public static void main(String[] args) {
        MyQueueWithStack queue = new MyQueueWithStack();
        queue.enqueu(1);
        queue.enqueu(2);
        queue.enqueu(3);
        queue.enqueu(4);

        assertTrue("Should be 1", 1 == queue.dequeu());
        assertTrue("Should be 2",2 == queue.dequeu());
        assertTrue("Should be 3", 3 == queue.dequeu());

        queue.enqueu(5);
        queue.enqueu(6);
        assertTrue("Should be 4", 4 == queue.dequeu());
        assertTrue("Should be 5", 5 == queue.dequeu());
        assertTrue("Should be 6", 6 == queue.dequeu());
    }
}
