package com.byinal.amcat;

import java.util.Arrays;

public class SortCenter {

    public static void main(String[] args) {
        int[] packages = {1, 10, 25, 35, 60, 90};
        int space = 90;
        int reseveSpace = 30;
        System.out.println(Arrays.toString(solution(packages, space, reseveSpace)));
    }


    private static int[] solution(int[] packages, int space, int reserveSpace) {
        int[] result = new int[2];

        int freeSpace = space - reserveSpace;
        int selectedTotalSpace = 0;
        int instantSum;

        for (int i = 0; i < packages.length; i++) {
            for (int j = i + 1; j < packages.length; j++) {
                instantSum = packages[i] + packages[j];
                if (instantSum > selectedTotalSpace && instantSum <= freeSpace) {
                    selectedTotalSpace = instantSum;
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }


}
