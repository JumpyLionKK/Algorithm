package com.lyn.learn.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

public class FindDuplication {

    public static boolean findDuplicate(int numbers[],int length,int [] duplication) {
        if(numbers.length == 0 || numbers == null){

            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            if(!map.containsKey(numbers[i])){
                map.put(numbers[i], 1);
                continue;
            }
            if(map.get(numbers[i]) == 1){
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] s = new int[1];
        s[0] = -1;
    }
}
