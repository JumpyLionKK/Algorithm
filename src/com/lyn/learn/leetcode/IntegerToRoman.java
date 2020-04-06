package com.lyn.learn.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    public static String intToRoman(int num) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");
        ArrayList<Integer> numList = new ArrayList<>();
        int temp = num;
        while(temp != 0){
            numList.add(temp % 10);
            temp = temp/10;
        }
        int totalBit = numList.size();
        String res = "";
        for(int i = totalBit - 1; i >= 0; i--){
            int position = (int)Math.pow(10,i);
            int numInbit = numList.get(i);
            if(numInbit == 4){
                res +=  map.get(position)+ map.get(5 * position);
            }else if(numInbit == 9){
                res += map.get(position) + map.get(position*10);
            }else {
                if(numInbit < 9 && numInbit >= 5){
                    res += map.get(5 * position);
                    numInbit = numInbit - 5;
                }
                while(numInbit != 0){
                    res += map.get(position);
                    numInbit--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(intToRoman(58));
    }
}
