package com.lyn.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    public static List<String> res = new ArrayList<>();

//    public List<Integer> findSubstring(String s, String[] words) {
//
//    }
    // {A,B,C}->{ABC,ACB,BAC,BCA,CAB,CBA}
    public static void findAllCombinations(String[] words, int from, int to){

        if(from == to){
            String temp = "";
            for(String c:words){
                temp += c;
            }
            res.add(temp);
            return;
        }

        for(int i = from; i <= to; i++){
            swap(words, i, from);
            findAllCombinations(words, from + 1, to);
            swap(words, i, from);
        }
    }

    public static void swap(String[] words, int n, int m){
        String temp = words[n];
        words[n] = words[m];
        words[m] = temp;
    }

    public static void main(String[] args) {
        String[] words = {"a", "b", "c"};
        findAllCombinations(words,0,2);
        int k = 0;
    }
}
