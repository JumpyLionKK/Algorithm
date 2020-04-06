package com.lyn.learn.Sorting.leetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0){
            return nums1;
        }
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        Arrays.sort(nums1);
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> map = new HashSet<>();
        for(int i = 0; i < nums2.length; i++){
            if(binarySearch(nums1, nums2[i])){
                if(map.contains(nums2[i])){
                    continue;
                }
                map.add(nums2[i]);
                res.add(nums2[i]);
            }
        }
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            result[i] = res.get(i);
        }
        return result;

    }

    private static boolean binarySearch(int[] nums1, int target){
        int start = 0;
        int end = nums1.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums1[mid] < target){
                start = mid;
            }else if(nums1[mid] > target) {
                end = mid;
            }else {
                return true;
            }
        }

        if(nums1[start] == target || nums1[end] == target){
            return true;
        }

        return false;
    }
}
