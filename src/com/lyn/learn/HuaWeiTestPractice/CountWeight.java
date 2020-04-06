package com.lyn.learn.HuaWeiTestPractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CountWeight {
    public int countWeight(int n, int[] weight, int[] nums){
        Set<Integer> set = new HashSet<>();
        // 1.第1个重量的砝码
        for(int i = 0; i < nums[0]; i++){
            set.add(i * weight[0]);
        }
        // 2.从第二个砝码开始
        for(int i = 1; i < n; i++){
            ArrayList<Integer> list = new ArrayList<>(set);
            // 3.枚举第二个重量的所有方案
            for(int j =0; j < nums[i]; j++){
                for(int k = 0; k < set.size(); k++){
                    set.add(list.get(k) + j * weight[i]);
                }

            }
        }
        return set.size();
    }
}
