package com.lyn.learn.Sorting.leetcodeProblems;

public class SortColors {
    public static void sortColors1(int[] nums){
        // 1-pass
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while(index <= p2){
            if(nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if(nums[index] == 2){
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index --;
            }
            index++;
        }

    }

    public static void sortColors2(int[] nums){
        // 2-pass
        int count0 = 0, count1 =0, count2 = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 0){
                count0++;
            }
            if(nums[i] == 1){
                count1++;
            }
            if(nums[i] == 2){
                count2++;
            }
        }
        for(int i = 0; i < nums.length - 1; i ++){
            if(count0 != 0){
                nums[i] = 0;
                count0 --;
            } else if(count1 != 0){
                nums[i] = 1;
                count1--;
            }else {
                nums[i] = 2;
                count2 --;
            }
        }
    }

    public static void main(String[] arg) {
        int[] A = {2,1,2,0,1,0,2};
        sortColors2(A);

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
        }


    }
}
