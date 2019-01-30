package com.byinal;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MineSweeper {

    public static void main(String[] args) {
        Set<Integer> mines = find(100, 9999);
        System.out.println(mines.toString());
    }

    static Set<Integer> find(int n, int m) {
        Random random = new Random();
        int max = n * n;
        int min = 0;
        Set<Integer> positions = new HashSet<>();
        Set<Integer> selected = new HashSet<>();
        for (int i = 1; i <= n * n; i++) {
            positions.add(i);
        }
        for (int i = 1; i <= m; i++) {
            int minePos = random.nextInt(max - min + 1) + min;
            selected.add(minePos);
            positions.remove(minePos);
        }
        return selected;
    }

}
