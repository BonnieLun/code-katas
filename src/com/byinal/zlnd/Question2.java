package com.byinal.zlnd;

import java.util.ArrayList;
import java.util.List;


/*
    Q2: inputs int A, int B
        solution generates string with A times 'a' and B times 'b' char. But three consecutive same char is not allowed.
        so 'aaa' and 'bbb' is not allowed.
        Assume that at least one solution exists
 */
public class Question2 {

    public static void main(String[] args) {
        solution(50,40);
    }

    private static boolean allowedToPush(String n, List text) {
        if(text.size() < 2){
            return true;
        }
        return (!text.get(text.size() - 1).equals(n) || !text.get(text.size() - 2).equals(n));
    }

    private static void solution(int A, int B){
        List<String> text = new ArrayList<>();

        while (A > 0 || B > 0) {
            if (A > B) {
                if (allowedToPush("a", text)) {
                    text.add("a");
                    A--;
                }
                else if (B == 0){
                    System.out.println("impossible");
                }
                else {
                    text.add("b");
                    B--;
                }
            } else if (B >= A) {
                if (allowedToPush("b", text)){
                    text.add("b");
                    B--;
                }
                else if (A == 0){
                    System.out.println("impossible");
                }
                else{
                    text.add("a");
                    A--;
                }
            }
        }
        System.out.println(text);
        System.out.println(String.join("", text));
    }

}
