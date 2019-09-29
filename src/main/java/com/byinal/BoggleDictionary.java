package com.byinal;

import java.util.ArrayList;
import java.util.List;

/*
(Find all possible words in a board of characters)
Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
       boggle[][]   = {{'G', 'I', 'Z'},
                       {'U', 'E', 'K'},
                       {'Q', 'S', 'E'}};
      isWord(str): returns true if str is present in dictionary
                   else false.

Output:  Following words of dictionary are present
         GEEKS
         QUIZ
 */
public class BoggleDictionary {

    public static String[] dictionary = {"GEEKS", "FOR", "QUIZ", "GO"};

    public static void main(String[] args) {
        char[][] boggle = {{'G', 'I', 'Z'}, {'U', 'E', 'K'}, {'Q', 'S', 'E'}};
        int height = boggle.length;
        int width = boggle[0].length;

        for(int row = 0; row<height; row++){
            for(int col=0; col<width; col++){
                //use this boolean array as a stack that keep track of visited chars in order lifo
                boolean[][] visited = new boolean[height][width];
                dfs(boggle, row, col, "", visited);
            }
        }
    }


    public static void dfs(char[][] boggle, int x, int y, String str, boolean[][] visited){
        int height = boggle.length;
        int width = boggle[0].length;
        char startChar = boggle[x][y];
        visited[x][y] = true;
        str = str + startChar;
        if(isInDictionary(str)){
            System.out.println("String: " + str);
        }

        for(int i = x-1; i <=x+1 && i<height; i++){
            for(int k = y-1; k <=y+1 && k<width ; k++){
                if(i >= 0 && k>=0 && !visited[i][k]){
                    visited[i][k] = true; //stack push
                    dfs(boggle, i, k, str, visited);
                }
            }
        }

        str = str.substring(0, str.length()-1);
        visited[x][y] = false; //stack pop

    }


    public static boolean isInDictionary(String word){
        for (String s : dictionary) {
            if (s.equals(word)) {
                return true;
            }
        }
        return false;
    }


}
