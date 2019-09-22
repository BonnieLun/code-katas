package com.byinal.stripe;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/*
You are given an unsorted array with both positive and negative elements.
You have to find the smallest positive number MISSING from the array in O(n) time using constant extra space.
You can modify the original array.
 */
public class FindMinPositive {


    public static void main(String[] args) {
        int[] servers = {-1, 10, 1, -4, 2};
        assertEquals(3, solution(servers));
    }

    static int solution(int[] A) { // Our original array

        int m = Arrays.stream(A).max().getAsInt(); // Storing maximum value
        if (m < 1) // In case all values in our array are negative
        {
            return 1;
        }
        if (A.length == 1) {

            // If it contains only one element
            if (A[0] == 1) {
                return 2;
            } else {
                return 1;
            }
        }

        int i = 0;
        int[] l = new int[m];
        for (i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                if (l[A[i] - 1] != 1) // Changing the value status at the index of our list
                {
                    l[A[i] - 1] = 1;
                }
            }
        }
        for (i = 0; i < l.length; i++) // Encountering first 0, i.e, the element with least value
        {
            if (l[i] == 0) {
                return i + 1;
            }
        }
        // In case all values are filled between 1 and m
        return i + 2;
    }

}
