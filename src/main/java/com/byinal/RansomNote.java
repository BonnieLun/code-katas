package com.byinal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RansomNote {

    /*
    Complete the checkMagazine function in the editor below. It must print  if the note can be formed using the magazine, or .
    checkMagazine has the following parameters:
    magazine: an array of strings, each a word in the magazine
    note: an array of strings, each a word in the ransom note
     */
    public static void main(String[] args) {
        String[] magazine = {"give", "me", "one", "grand", "today", "night"};
        String[] ransom = {"give", "one", "grand", "one"};

        checkMagazine(magazine, ransom);

    }


    public static void checkMagazine(String[] magazine, String[] ransom) {
        int k = 4;
//        int[] result = new int[]{1"","2"","3"","4"","5};

//        while (k>0){
//            result = leftRotate(result);
//            k--;
//        }
//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i] + " ");
//        }
        List<String> mag = Arrays.asList(magazine);
        List<String> ran = Arrays.asList(ransom);


        Map<String, Long> ransomMap = Arrays.stream(ransom).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> magazineMap = Arrays.stream(magazine).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        boolean res = (ransomMap.entrySet().stream()
                .filter(i -> (!magazineMap.containsKey(i.getKey()) || magazineMap.get(i.getKey()) < i.getValue()))
                .count() == 0);
        if (res) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }


    public static int[] leftRotate(int[] array) {
        int[] result = new int[array.length];
        result[array.length - 1] = array[0];
        for (int i = 1; i < array.length; i++) {
            result[i - 1] = array[i];
        }
        return result;
    }

}
