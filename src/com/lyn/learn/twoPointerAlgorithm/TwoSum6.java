package com.lyn.learn.twoPointerAlgorithm;

import java.util.Arrays;

public class TwoSum6 {
    public static int twoSum6(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);
        int preNum = nums[0] - 1;
        int start = 0, end = nums.length - 1;
        int count = 0;
        while(start < end){
            if(nums[start] + nums[end] > target){
                end--;
            }else if(nums[start] + nums[end] < target){
                start ++;
            }else {
                if(preNum != nums[start]){
                    preNum = nums[start];
                    count++;
                }
                start++;
                end--;
            }
        }
        return count;
    }
}
