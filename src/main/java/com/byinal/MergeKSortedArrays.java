package com.byinal;

import java.util.PriorityQueue;

/*
This Min Heap based solution has same time complexity which is O(nk Log k).

Following is detailed algorithm.
1. Create an output array of size n*k.
2. Create a min heap of size k and insert 1st element in all the arrays into the heap
3. Repeat following steps n*k times.
     a) Get minimum element from heap (minimum is always at root) and store it in output array.
     b) Replace heap root with next element from the array from which the element is extracted.
      If the array doesn’t have any more elements, then replace root with infinite. After replacing the root, heapify the tree.
 */
public class MergeKSortedArrays {

    private static int k = 3, n = 4;


    public static void main(String[] args) {
        int[][] numArrays = { {1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}} ;
        merge(numArrays);
    }

    private static void merge(int[][] numArrays){
        int[] result = new int[k*n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Integer::compareTo);

        for (int x = 0; x < n ; x++) {
            for (int y = 0; y < k; y++) {
                minHeap.add(numArrays[y][x]);
            }
        }
        for (int i = 0; i < n * k; i++) {
            result[i] = minHeap.poll();
        }
        for (int i = 0; i < n * k; i++) {
            System.out.println(result[i]);
        }
    }

}
