/*
给出字母列表{A, B, C}求出其所有的排列组合
{A,B,C,AB,AC,BC,ABC}
 */

package com.lyn.learn.unsolvedProblemsDuringInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public List<String> helper(char[] array){
        List<String> str = new ArrayList<>();
        permutation(array, 0, str);

        return str;

    }
    public void permutation(char[] array, int start, List<String> res){

        if(start >= array.length){
            return;
        }

        List<String> str = new ArrayList<>();

        if(res.size() != 0){
            for(String c : res){
                String newString = c + array[start];
                str.add(newString);
            }
        }
        for(String c:str){
            res.add(c);
        }

        res.add("" + array[start]);
        start = start + 1;

        permutation(array, start, res);

    }

    public List<String> newPermutation(List<Character> array){

        if(array.size() == 0){
            return new ArrayList<String>();
        }

        char newChar = array.get(0);
        List<String> list = newPermutation(array.subList(1,array.size()));

        List<String> newList = new ArrayList<>();

        for(String s : list){
            newList.add(s + newChar);
            newList.add(s);
        }

        newList.add(newChar + "");

        return newList;
    }



    public static void main(String[] args){
        char[] array = {'A', 'B', 'C'};
        List<Character> list = new ArrayList<>();
        for(char c : array){
            list.add(c);
        }

        Permutation permutation = new Permutation();
        List<String> res = permutation.newPermutation(list);
        for(String c : res){
            System.out.println(c);
        }
    }
}
