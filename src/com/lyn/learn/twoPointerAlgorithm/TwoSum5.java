package com.lyn.learn.twoPointerAlgorithm;

import java.util.Arrays;

public class TwoSum5 {
    public static int twoSum5(int[] nums, int target) {
        // write your code here
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while(left < right){
            if(nums[left] + nums[right] > target){
                right --;
            }else {
                count += right - left;
                left++;
            }
        }
        return count;
    }
}
