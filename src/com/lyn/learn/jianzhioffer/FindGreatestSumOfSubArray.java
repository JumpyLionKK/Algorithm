package com.lyn.learn.jianzhioffer;

public class FindGreatestSumOfSubArray {
    public int findGreatestSumOfSubArray(int[] array){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            if(sum < 0){
                sum = 0;
            }
            sum += array[i];
            max = Math.max(sum, max);
        }
        return max;
    }

    // dp
    public int findGreatestSumOfSubArray2(int[] array){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++){
            if(i != 0 && sum > 0){
                sum += array[i];
            }else{
                sum = array[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
