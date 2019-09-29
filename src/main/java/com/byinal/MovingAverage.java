package com.byinal;

import java.util.ArrayList;
import java.util.List;

public class MovingAverage {

    List<Integer> numberList = new ArrayList<Integer>();
    Integer n = 3;

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage();
        System.out.println(movingAverage.movingAverage(7));
        System.out.println(movingAverage.movingAverage(2));
        System.out.println(movingAverage.movingAverage(4));
        System.out.println(movingAverage.movingAverage(4));
        System.out.println(movingAverage.movingAverage(3));
        System.out.println(movingAverage.movingAverage(5));
        System.out.println(movingAverage.movingAverage(1));
    }


    public Double movingAverage(Integer number){
        numberList.add(number);
        Double sum = new Double(0);
        Double avg;
        if (numberList.size() <= n){
            for(Integer num : numberList){
                sum +=num;
            }
            avg = sum / numberList.size();
        } else {
            int numberListSize = numberList.size();
            int countNumbersToSum = n;
            while(countNumbersToSum > 0){
                sum += numberList.get(numberListSize - countNumbersToSum);
                countNumbersToSum--;
            }
            avg = sum / n;
        }
        return avg;
    }
}
