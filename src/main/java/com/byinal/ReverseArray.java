package com.byinal;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6};

        System.out.println(Arrays.toString(array));
        array = reverse(array);
        System.out.println(Arrays.toString(array));

        String s = "this string will be reversed!";
        System.out.println(s);
        System.out.println(reverse(s.toCharArray()));

    }

    private static <T> T[] reverse(T[] array){
        int reverseIndex = array.length - 1;
        int midPoint = (array.length / 2);
        for (int i = 0; i < midPoint; i++) {
            T temp = array[i];
            array[i] = array[reverseIndex];
            array[reverseIndex] = temp;
            reverseIndex--;
        }
        return array;
    }

    private static char[] reverse(char[] array){
        int reverseIndex = array.length - 1;
        int midPoint = (array.length / 2);
        for (int i = 0; i < midPoint; i++) {
            char temp = array[i];
            array[i] = array[reverseIndex];
            array[reverseIndex] = temp;
            reverseIndex--;
        }
        return array;
    }
}
