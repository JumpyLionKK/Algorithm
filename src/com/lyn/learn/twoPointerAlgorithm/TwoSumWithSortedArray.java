package com.lyn.learn.twoPointerAlgorithm;

public class TwoSumWithSortedArray {
    public static int[] twoSum(int[] nums, int target) {
        // write your code here
        if(nums ==null || nums.length == 0){
            return new int[0];
        }
        int left = 0, right = nums.length - 1;
        int[] res = new int[2];
        while(left < right){
            if(nums[right] + nums[left] > target){
                right --;
            } else if(nums[right] + nums[left] < target){
                left ++;
            }else{
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }
        }
        return res;
    }
}
