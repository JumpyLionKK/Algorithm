/*
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的
 */
package com.lyn.learn.jianzhioffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FindNumbersWithSum {
    public static ArrayList<Integer> findNumbersWithSum(int sum, int[] array){
        ArrayList<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < array.length; i++){
            if(!set.contains(sum - array[i])){
                set.add(array[i]);
            }else{
                if(!res.isEmpty()){
                    if((sum - array[i]) * array[i] > res.get(0) * res.get(1)){
                        continue;
                    }else{
                        res.clear();
                    }
                }
                res.add(Math.min(array[i],sum - array[i]));
                res.add(Math.max(array[i],sum - array[i]));

            }
        }
        return res;

    }

    public static void main(String[] args){
        int[] array = {1,2,4,7,11,15};
        ArrayList<Integer> res = findNumbersWithSum(15, array);

    }
}
