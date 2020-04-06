package com.lyn.learn.twoPointerAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TwoSumIII {
    private List<Integer> nums = new ArrayList<>();
    public void add(int number) {
        // write your code here
        nums.add(number);
    }

    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        HashSet<Integer> map = new HashSet<>();
        for(Integer c: nums){
            if(map.contains(value - c)){
                return true;
            }
            map.add(c);
        }
        return false;
    }
}
