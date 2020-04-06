package com.lyn.learn.JiuZhangSenior;

public class MinimumSizeSubarraySum {
    public static int minimumSizeSubarraySum(int[] nums, int s) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for(int l = 0, r = 0; r < nums.length; r++){
            sum += nums[r];

            while(sum >= s){
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
