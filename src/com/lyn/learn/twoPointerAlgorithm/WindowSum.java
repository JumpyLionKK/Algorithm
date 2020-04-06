package com.lyn.learn.twoPointerAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class WindowSum {
    public static int[] winSum(int[] nums, int k) {
        // write your code here
        if(nums == null || nums.length == 0 || nums.length < k){
            return new int[0];
        }
        int start = 0, end = k - 1;
        List<Integer> lis = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        lis.add(sum);
        while(end < nums.length - 1){
            end++;
            sum = sum - nums[start] + nums[end];
            start++;
            lis.add(sum);
        }
        int[] res = new int[lis.size()];
        for(int i = 0; i < lis.size(); i++){
            res[i] = lis.get(i);
        }
        return res;
    }
}
