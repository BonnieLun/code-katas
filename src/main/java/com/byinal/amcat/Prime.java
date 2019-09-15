package com.byinal.amcat;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;


//Amazon is planning to release a new order prioritization algorithm to optimize fulfilling Prime deliveries on time.
// All orders (Prime or otherwise) are given an alphanumeric ID code. However, Prime orders are given additional metadata that consists of a space delimited list of lowercase English letters,
// whereas non-Prime orders are given metadata that consists only Of a space delimited string Of positive integers.
// Each order is therefore defined as their alphanumeric id code, followed by a space, followed by their space delimited metadata.
//You have been tasked with sorting a list of all orders in the order queue to assist in prioritization of fulfillment. They should be sorted according to the following order:
//1. The Prime orders should be returned first, sorted by lexicographic sort of the alphabetic metadata.
//2. Only in the case of ties, the identifier should be used as a backup sort.
//3. The remaining non-Prime orders must all come after, in the original order they were given in the input.
//Write a function or method to sort the orders according to this system.

public class Prime {

    public static void main(String[] args) {
        String order1 = "zld 93 12";
        String order2 = "fp kindle book";
        String order3 = "10a echo show";
        String order4 = "17g 12 25 6";
        String order5 = "ab1 kindle book";
        String order6 = "125 echo dot second generation";
        List<String> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);
        orderList.add(order5);
        orderList.add(order6);
        System.out.println(prioritizedOrders(6, orderList));
    }


    public static List<String> prioritizedOrders(int numOrders, List<String> orderList)
    {
        List<String> primes = new ArrayList<>();
        List<String> nonPrimes = new ArrayList<>();
        List<String> expectedList = new ArrayList<>();

        // WRITE YOUR CODE HERE
        for(String order : orderList){
            if(isAlphabetic(getMetadata(order))){
                primes.add(order);
            }else{
                nonPrimes.add(order);
            }
        }

        primes.sort(ALPHABETICAL_ORDER);
        primes.addAll(nonPrimes);
        return primes;

    }

    private static String getMetadata(String order) {
        return order.substring(order.indexOf(" ")+1);
    }
    // METHOD SIGNATURE ENDS

    public static boolean isAlphabetic(String s) {
        return s != null && s.matches("^[a-zA-Z\\s]*$");
    }

    private static Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
        public int compare(String str1, String str2) {
            int res = String.CASE_INSENSITIVE_ORDER.compare(str1.substring(str1.indexOf(" ")+1), str2.substring(str2.indexOf(" ")+1));
            if (res == 0) {
                res = str1.substring(0, str1.indexOf(" ")).compareTo(str2.substring(0, str2.indexOf(" ")));
            }
            return res;
        }
    };


}
