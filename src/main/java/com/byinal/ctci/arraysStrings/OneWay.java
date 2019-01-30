package com.byinal.ctci.arraysStrings;

import static org.junit.Assert.assertEquals;

/*
CTCI Question 1.5
There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
EXAMPLE
pale, pIe -> true
pales. pale -> true
pale. bale -> true
pale. bake -> false
 */
public class OneWay {

    public static void main(String[] args) {
        assertEquals(check("pale", "pale"),true);
        assertEquals(check("pale", "bale"),true);
        assertEquals(check("pale", "bake"),false);
        assertEquals(check("pale", "ple"),true);
        assertEquals(check("pale", "ble"),false);
        assertEquals(check("pales", "pale"),true);
        assertEquals(check("pales", "plet"),false);
        assertEquals(check("bale", "balet"),true);
        assertEquals(check("bale", "palet"),false);
        assertEquals(check("bale", "blett"),false);
    }

    private static boolean check(String input1, String input2){
        char[] input1Chars = input1.toCharArray();
        int difference = 0;
        for (char input1Char : input1Chars) {
            if (input2.indexOf(input1Char) == -1) {
                difference++;
            }
            if (difference > 1) {
                return false;
            }
        }
        if(difference > 0 && input2.length() > input1.length()){
            return false;
        }
        return true;
    }

}
