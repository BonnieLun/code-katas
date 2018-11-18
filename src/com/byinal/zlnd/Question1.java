package com.byinal.zlnd;

import java.util.Arrays;
import java.util.stream.IntStream;


/*
    Q1: input temperature of each day in the year [-3, -14, -5 ,7 ,8 ,42 ,8,3]
        there are 4 season 1-winter 2-spring 3-autumn 4-summer
        amplitude -> difference between highest and lowest temp in a season
        find season with max amplitude
 */
public class Question1 {

    public static void main(String[] args) {
        int[] T = {-3, -14, -5 ,7 ,8 ,42 ,8, 3};
        System.out.println(solution(T));
    }

    private static String solution(int[] T) {
        int length = T.length;
        int seasonDaySize = length / 4;

        int[] winter = Arrays.copyOfRange(T, 0, seasonDaySize);
        int[] spring = Arrays.copyOfRange(T, seasonDaySize, (2*seasonDaySize));
        int[] summer = Arrays.copyOfRange(T, (2*seasonDaySize), (3*seasonDaySize));
        int[] autumn = Arrays.copyOfRange(T, (3*seasonDaySize), length);


        int winterMax = Arrays.stream(winter).max().getAsInt();
        int winterMin = Arrays.stream(winter).min().getAsInt();

        int springMax = Arrays.stream(spring).max().getAsInt();
        int springMin = Arrays.stream(spring).min().getAsInt();

        int summerMax = Arrays.stream(summer).max().getAsInt();
        int summerMin = Arrays.stream(summer).min().getAsInt();

        int autumnMax = Arrays.stream(autumn).max().getAsInt();
        int autumnMin = Arrays.stream(autumn).min().getAsInt();


        int winterAmp = winterMax - winterMin;
        int springAmp = springMax - springMin;
        int summerAmp = summerMax - summerMin;
        int autmnAmp = autumnMax - autumnMin;


        int[] amps = {winterAmp, springAmp, summerAmp, autmnAmp};

        int ampMax = Arrays.stream(amps).max().getAsInt();

        int index = IntStream.range(0, amps.length)
                .filter(i -> ampMax == amps[i])
                .findFirst()
                .orElse(-1);

        if(index == 0) {
            return "WINTER";
        } else if(index == 1) {
            return "SPRING";
        } else if(index == 2) {
            return "SUMMER";
        } else {
            return "AUTUMN";
        }

    }


//    public static String solution(int[] T){
//        int length = T.length;
//        int seasonDaySize = length / 4;
//        int[] amplitudes = new int[4];
//        int season = 0;
//        int first = T[0];
//        int sec = T[1];
//        int min, max;
//
//        if (T[0] > T[1]) {
//            max = T[0];
//            min = T[1];
//        } else {
//            max = T[1];
//            min = T[0];
//        }
//
//        for (int i = 2; i < length; i++) {
//            if (i % seasonDaySize == 0) {
//                season++;
//                if (T[i] > T[i + 1]) {
//                    max = T[i];
//                    min = T[i + 1];
//                } else {
//                    max = T[i + 1];
//                    min = T[i];
//                }
//                i++;
//                amplitudes[season] = max - min;
//                continue;
//            }
//            if (T[i] < min) {
//                min = T[i];
//            } else if (T[i] > max) {
//                max = T[i];
//            }
//            amplitudes[season] = max - min;
//        }
//
//        int maxAmp = amplitudes[0];
//
//        for (int i = 1; i < amplitudes.length; i++) {
//            if (amplitudes[i] > max) {
//                maxAmp = amplitudes[i];
//            }
//        }
//
//        int index = Arrays.asList(amplitudes).indexOf(maxAmp);
//        if(index == 0) {
//            return "WINTER";
//        } else if(index == 1) {
//            return "SPRING";
//        } else if(index == 2) {
//            return "SUMMER";
//        } else  {
//            return "AUTUMN";
//        }
//    }

}
