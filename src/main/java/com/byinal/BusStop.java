package com.byinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
There are  groups of friends, and each group is numbered from 1 to . The th group contains  people.

They live near a bus stop, and only a single bus operates on this route.
An empty bus arrives at the bus stop and all the groups want to travel by the bus.

However, group of friends do not want to get separated. So they enter the bus only if the bus can carry the entire group.

Moreover, the groups do not want to change their relative positioning while travelling.
In other words, group 3 cannot travel by bus,
unless group 1 and group 2 have either (a) already traveled by the bus in the previous trip
or (b) they are also sitting inside the bus at present.

You are given that a bus of size  can carry  people simultaneously.

Find the size  of the bus so that (1) the bus can transport all the groups and (2) every time when the bus starts from the bus station,
 there is no empty space in the bus (i.e. the total number of people present inside the bus is equal to )?
Print all possible sizes of the bus in an increasing order.
 */
public class BusStop {

    public static void main(String[] args) {

        int[] friends = {2, 2, 1, 1, 1, 1, 1, 2, 1, 2};
        System.out.println(Arrays.toString(solve(friends)));

    }

    static int[] solve(int[] groups) {
        if (groups.length == 0){
            return new int[0];
        }
        int max = Arrays.stream(groups).max().getAsInt();
        int sum = Arrays.stream(groups).sum();
        List<Integer> resuls = new ArrayList<>();
        IntStream.rangeClosed(max, sum)
                .forEach(cap -> {
                    if(check(groups, cap)){
                        resuls.add(cap);
                    }
                });
        int[] result = new int[resuls.size()];
        for (int i = 0; i < resuls.size(); i++) {
            result[i] = resuls.get(i);
        }
        return result;
    }


    static boolean check(int[] groups, int capacity){
        int sum = 0;
        for (int group : groups) {
            sum += group;
            if(sum > capacity){
                return false;
            }
            if (sum == capacity) {
                sum = 0;
            } else if (sum % capacity == 0){
                sum = 0;
            }
        }
        return sum == 0;
    }

}
