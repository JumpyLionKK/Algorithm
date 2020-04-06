package com.lyn.learn.leetcode;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n){

        int idx1 = n, idx2 = 0;
        for(int i = m - 1; i >= 0; i--){
            nums1[i + n] = nums1[i];
        }
        int idx = 0;
        while(idx1 < m + n && idx2 < n){

            if(nums1[idx1] >= nums2[idx2]){
                nums1[idx++] = nums2[idx2++];

            }else{
                nums1[idx++] = nums1[idx1++];
            }

        }

        if(idx1 >= m + n){
            while(idx < m + n){
                nums1[idx++] = nums2[idx2++];
            }
        }

        if(idx2 >= n){
            while(idx < m + n){
                nums1[idx++] = nums1[idx1++];
            }
        }
    }

    public static void main(String[] args){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        MergeSortedArray.merge(nums1, 3, nums2, 3);
        for(int i = 0; i < 6; i++){
            System.out.println(nums1[i]);
        }
    }
}
