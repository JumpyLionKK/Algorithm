package com.lyn.learn.Sorting.leetcodeProblems;

public class WiggleSort {
    public static void wiggleSort(int[] nums){
        if(nums.length == 0 || nums == null) {
            return;
        }
        for(int i = 0; i < nums.length - 1; i ++){
            if(i / 2 == 0) {
                if(nums[i] > nums[i + 1]){
                    swap(nums, i , i + 1);
                }
            }else{
                if(nums[i] < nums[i + 1]){
                    swap(nums, i, i + 1);
                }
            }

        }
    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] arg) {
        int[] A = {1,3,4,2,7,6,9};
        wiggleSort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
        }


    }


}
