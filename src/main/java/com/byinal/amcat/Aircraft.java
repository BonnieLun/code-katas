package com.byinal.amcat;

import java.util.*;

//Amazon Prime Air is developing a system that divides shipping routes using flight optimization routing systems to a cluster of aircraft that can fulfill these routes.
// Each shipping route is identified by a unique integer identifier, requires a fixed non-zero amount of travel distance between airports,
// and is defined to be either a forward shipping route or a return shipping route. Identifiers are guaranteed to be unique within their own route type, but not across route types.
//Each aircraft should be assigned two shipping routes at once: one forward route and one return route. Due to the complex scheduling of flight plans,
// all aircraft have a fixed maximum operating travel distance, and cannot be scheduled to fly a shipping route that requires more travel distance than the prescribed maximum operating travel distance.
// The goal of the system is to optimize the total operating travel distance of a given aircraft.
// A forward/return shipping route pair is considered to be “optimal” if there does not exist another pair that has a higher operating travel distance than this pair,
// and also has a total less than or equal to the maximum operating travel distance of the aircraft.
//For example, if the aircraft has a maximum operating travel distance of 3000 miles,
// a forward/return shipping route pair using a total of 2900 miles would be optimal if there does not exist a pair that uses a total operating travel distance of 3000 miles,
// but would not be considered optimal if such a pair did exist.
//Your task is to write an algorithm to optimize the sets of forward/return shipping route pairs that allow the aircraft to be optimally utilized, given a list of forward shipping routes and a list of return shipping routes.

public class Aircraft {

    public List<List<Integer>> findOptimalRoute(int maxTravelDist, List<List<Integer>> forwardRouteList, List<List<Integer>> returnRouteList) {
        List<List<Integer>> res = new ArrayList<>();
        int forLen = forwardRouteList.size(), retLen = returnRouteList.size() ;
        if (maxTravelDist <= 0 || forLen == 0 || retLen == 0) {
            return res;
        }

        Collections.sort(forwardRouteList, (a, b) -> (a.get(1) - b.get(1)));
        Collections.sort(returnRouteList, (a, b) -> (a.get(1) - b.get(1)));
        System.out.println(forwardRouteList);
        System.out.println(returnRouteList);

        int l = 0, r = retLen - 1, diff = Integer.MAX_VALUE, sum;
        while (l < forLen && r >= 0) {
            sum = forwardRouteList.get(l).get(1) + returnRouteList.get(r).get(1);

            if (maxTravelDist - sum >= 0 && maxTravelDist - sum <= diff) {
                if (maxTravelDist - sum < diff) {
                    diff = maxTravelDist - sum;
                    res = new ArrayList<>();
                }
                res.add(Arrays.asList(forwardRouteList.get(l).get(0), returnRouteList.get(r).get(0)));
            }
            if (sum >= maxTravelDist) {
                r--;
            } else {
                l++;
            }
        }
     return res;
    }


    public static List<List<Integer>> calculateOptimalRoute(final int capacity, final List<List<Integer>> forwardList, final List<List<Integer>> returnList) {
        System.out.println(forwardList);
        System.out.println(returnList);

        // sort forward list
        Collections.sort(forwardList, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1) - o2.get(1);
            }
        });

        // sort return list
        Collections.sort(returnList, new Comparator<List<Integer>>() {
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1) - o2.get(1);
            }
        });

        int max = 0;
        int i = 0;
        int j = returnList.size() - 1;

        List<List<Integer>> result = null;
        while(i < forwardList.size() && j >= 0) {
            if (forwardList.get(i).get(1) + returnList.get(j).get(1) > max &&
                    forwardList.get(i).get(1) + returnList.get(j).get(1) <= capacity) {
                max = forwardList.get(i).get(1) + returnList.get(j).get(1);
                result = new ArrayList<List<Integer>>();
                result.add(new ArrayList<Integer>(Arrays.asList(forwardList.get(i).get(0), returnList.get(j).get(0))));
                i++;
            } else if(forwardList.get(i).get(1) + returnList.get(j).get(1) == max) {
                // no need to reset result list
                result.add(new ArrayList<Integer>(Arrays.asList(forwardList.get(i).get(0), returnList.get(j).get(0))));
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args){
        List<List<Integer>>forward=new ArrayList<>();
        List<List<Integer>>returnL=new ArrayList<>();

        forward.add(Arrays.asList(1,3000));
        forward.add(Arrays.asList(2,5000));
        forward.add(Arrays.asList(3,7000));
        forward.add(Arrays.asList(4,10000));

        returnL.add(Arrays.asList(1,2000));
        returnL.add(Arrays.asList(2,3000));
        returnL.add(Arrays.asList(3,4000));
        returnL.add(Arrays.asList(4,5000));


        List<List<Integer>>res=new Aircraft().calculateOptimalRoute(10000,forward,returnL);
        System.out.println(res);
        }
}
