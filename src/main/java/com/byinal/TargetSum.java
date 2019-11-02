package com.byinal;


import java.util.*;

import static org.junit.Assert.*;

// For a given array of numbers and a 'targetProduct',
// find two numbers 'a' and 'b' from the input array so that:
// 		a * b = targetProduct
//
// Example:
// input: [1, 3, 5, 5, 10], targetSum: 8 , result: true (3, 5)
// input: [1, 3, 4, 11], targetSum: 16, result: false
public class TargetSum {


    public static void main(String[] args) {
        int[] numbersFo8 = {1, 2, 3, 5, 5, 10};
        int[] numbersFor16 = {1, 3, 4, 11};
        TargetSum targetSum = new TargetSum();
        assertTrue(targetSum.check(numbersFo8, 8));
        assertFalse(targetSum.check(numbersFor16, 16));
    }


    public boolean check(int[] numbers, int targetSum){
        Set<Integer> firstNumbers = new HashSet<>();
        Set<Integer> secondNumbers = new HashSet<>();
        for (int number : numbers) {
            firstNumbers.add(number);
            int remainder = targetSum - number;
            if (firstNumbers.contains(remainder)) {
                System.out.println(number);
                System.out.println(remainder);
                return true;
            }
        }
        return false;
    }

}
