package com.lyn.learn.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return res;
        }

        Map<Integer, String[]> map = new HashMap<>();
        map.put(2, new String[]{"a", "b", "c"});
        map.put(3, new String[]{"d", "e", "f"});
        map.put(4, new String[]{"g", "h", "i"});
        map.put(5, new String[]{"j", "k", "l"});
        map.put(6, new String[]{"m", "n", "o"});
        map.put(7, new String[]{"p","q","r","s"});
        map.put(8,new String[]{"t","u","v"});
        map.put(9, new String[]{"w", "x", "y", "z"});
        if(digits.length() == 1){

            for(String s : map.get(Integer.parseInt(digits))){
                res.add(s);
            }
            return res;
        }

        String[] initStr = combinamtion(map.get(Integer.parseInt(digits.charAt(0)+"")), map.get(Integer.parseInt(digits.charAt(1)+"")));
        for(int i = 2; i < digits.length(); i++){
            initStr = combinamtion(initStr, map.get(Integer.parseInt(digits.charAt(i)+"")));
        }
        for(int i = 0; i < initStr.length; i++){
            res.add(initStr[i]);
        }
        return res;

    }

    public static String[] combinamtion(String[] str1, String[] str2){

        List<String> array = new ArrayList<>();
        for(int i = 0; i < str1.length; i++){
            for(int j = 0; j < str2.length; j++){
                array.add(str1[i] + str2[j]);
            }
        }
        String[] res = new String[array.size()];
        for(int i = 0; i < array.size(); i++){
            res[i] = array.get(i);
        }
        return res;
    }

    public static void main(String[] args){
        List<String> res = letterCombinations("234");
        for(String c : res){
            System.out.println(c);
        }
    }
}
