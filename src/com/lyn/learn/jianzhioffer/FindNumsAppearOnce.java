package com.lyn.learn.jianzhioffer;

import java.util.*;

public class FindNumsAppearOnce {
    // 1. use hashMap
    public void findNumsAppearOnce1(int[] array, int[] num1, int[] num2){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else{
                map.put(i, 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            if((Integer) entry.getValue() == 1){
                res.add((Integer) entry.getKey());
            }
        }
        num1[0] = res.get(0);
        num2[0] = res.get(1);
    }

    // 2.使用异或的方法
    /*
    可以用位运算实现，如果将所有所有数字相异或，则最后的结果肯定是那两个只出现一次的数字异或的结果，
    所以根据异或的结果1所在的最低位，把数字分成两半，每一半里都还有只出现一次的数据和成对出现的数据这样
    继续对每一半相异或则可以分别求出两个只出现一次的数字
     */
    public void findNumsAppearOnce(int[] array, int[] num1, int[] num2){
        int temp = 0;
        for(int i = 0; i < array.length; i++){
            temp ^= array[i];
        }

        int index = 0;
        while((temp & 1) == 0){
            temp = temp >> 1;
            ++index;
        }
        num1[0] = 0;
        num2[0] = 0;
        for(int i = 0; i < array.length; i++){
            if(isBitOne(array[i], index) == 1){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }

    }
    public int isBitOne(int num, int index){
        num = num >> index;
        return (num & 1);
    }


}
