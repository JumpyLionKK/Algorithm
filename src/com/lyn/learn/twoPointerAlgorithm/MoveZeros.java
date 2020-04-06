package com.lyn.learn.twoPointerAlgorithm;

public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return;
        }
        int start = 0;
        for(int i = 0; i < nums.length; i++){
           if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start++] = temp;
            }
        }
    }
}
