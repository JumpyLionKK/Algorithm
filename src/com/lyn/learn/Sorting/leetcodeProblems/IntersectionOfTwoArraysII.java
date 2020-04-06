package com.lyn.learn.Sorting.leetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysII {
    public static int[] intersection(int[] nums1, int[] nums2){
        if(nums1 == null || nums2 == null) return new int[0];
        int index = 0;
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i = 0; i < nums1.length; i++){
            if(nums1[i] == nums2[index]){
                res.add(nums1[i]);
                if(++index == nums2.length) break;
            } else if(nums1[i] > nums2[index]){
                i --;
                if(++index == nums2[index]){
                    break;
                }
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
