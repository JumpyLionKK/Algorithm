package com.lyn.learn.twoPointerAlgorithm;

import java.util.Arrays;

public class TwoSum2 {
    public static int twoSum2(int[] nums, int target) {
        // write your code here
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        int res = 0;
        while(start < end){
            if(nums[start] + nums[end] <= target){
                start ++;
            }else {
                res += end - start;
                end--;
            }
        }
        return res;

    }
}
