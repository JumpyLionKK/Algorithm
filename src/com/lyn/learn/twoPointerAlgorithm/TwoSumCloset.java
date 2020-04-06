package com.lyn.learn.twoPointerAlgorithm;

import java.util.Arrays;

public class TwoSumCloset {
    public static int twoSumClosest(int[] nums, int target) {
        // write your code here
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        int start = 0, end = nums.length - 1;
        while(start < end){
            res = Math.min(res, Math.abs(nums[start] + nums[end] - target));
            if(nums[start] + nums[end] > target){
                end --;
            }else if(nums[start] + nums[end] < target){
                start ++;
            }else {
                return 0;
            }

        }
        return res;
    }
}
