/*
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
Find all unique quadruplets in the array which gives the sum of target.
 */
package com.lyn.learn.leetcode;

import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        if(nums == null || nums.length < 4)
            return new ArrayList<List<Integer>>(res);
        Arrays.sort(nums);
        dfs(nums, target, res, new ArrayList<Integer>(), 0, 4);
        return new ArrayList<List<Integer>>(res);


    }

    public void dfs(int[] nums, int target, Set<List<Integer>> res, List<Integer> cur, int pos, int k){

        if(cur.size() == k - 2){
            List<List<Integer>> twosums = twoSum(nums, target, pos, nums.length - 1);
            for(int i = 0; i < twosums.size(); i++){
                List<Integer> tempCur = new ArrayList<>(cur);
                tempCur.addAll(twosums.get(i));
                res.add(tempCur);
            }
        }else{
            for(int i = pos; i < nums.length; i++){
                cur.add(nums[i]);
                dfs(nums, target - nums[i], res, cur, i + 1, k);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int left, int right){

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[left]);
                temp.add(nums[right]);
                res.add(temp);
                left++;
                right--;
                continue;
            }else if(sum > target) right--;
            else left++;
        }

        return res;

    }
}
