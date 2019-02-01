package com.byinal.ctci.arraysStrings;


import static org.junit.Assert.assertEquals;

/*
CTCI Question 1.6
String Compression: Implement a method to perform basic string compression using the counts of repeated characters.
For example, the string aabcccccaaa would become a2b1c5a3.
If the "compressed" string would not become smaller than the original string,
your method should return the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class StringCompression {

    public static void main(String[] args) {
        assertEquals(compress("aabcccccaaa"),"a2b1c5a3");
        assertEquals(compress("aabcccccab"),"aabcccccab");
        assertEquals(compress("abbcccc"),"a1b2c4");
        assertEquals(compress("aaaaaaaaaa"),"a10");
        assertEquals(compress("abc"),"abc");
    }

    public static String compress(String input){
        int count = 0;
        char[] chars = input.toCharArray();
        char previous = chars[0];
        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            if(previous == c){
                count++;
            } else {
                builder.append(previous).append(count);
                count=1;
                previous = c;
            }
        }
        builder.append(previous).append(count);

        String compressed = builder.toString();
        if(compressed.length() >= input.length()){
            return input;
        }
        return compressed;
    }

}
