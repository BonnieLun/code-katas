package com.byinal;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
We can use a max heap on left side to represent elements that are less than effective median,
and a min heap on right side to represent elements that are greater than effective median.

After processing an incoming element, the number of elements in heaps differ utmost by 1 element.
When both heaps contain same number of elements, we pick average of heaps root data as effective median.
When the heaps are not balanced, we select effective median from the root of heap containing more elements.
 */
public class MovingMedian {

    public static void main(String[] args) {
        int[] numbers = {12, 4, 5, 3, 8, 7};
        Double[] medians = getMedians(numbers);
        for (int i = 0; i < medians.length; i++) {
            System.out.println(medians[i]);
        }

    }

    private static Double[] getMedians(int[] numbers) {
        PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * o1.compareTo(o2);
            }
        });
        PriorityQueue<Integer> highers = new PriorityQueue<>(Integer::compareTo);
        Double[] medians = new Double[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            addNumber(numbers[i], lowers, highers);
            rebalance(lowers, highers);
            medians[i] = getMedian(lowers, highers);
        }
        return medians;
    }

    private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() < highers.size() ? lowers : highers;
        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        } else if (smallerHeap.size() - biggerHeap.size() >= 2) {
            biggerHeap.add(smallerHeap.poll());
        }

    }

    private static Double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.size() - highers.size() == 1) {
            return new Double(lowers.peek());
        } else if (highers.size() - lowers.size() == 1) {
            return new Double(highers.peek());
        } else {
            return (new Double(lowers.peek()) + new Double(highers.peek())) / 2;
        }

    }

    private static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.size() == 0 || number < lowers.peek()) {
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }

}
