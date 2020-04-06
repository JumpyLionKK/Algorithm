package com.lyn.learn.jianzhioffer;

import java.util.Arrays;


public class MoreThanHalf {
    // O(nlogn)
    public int moreThanHalfNum(int[] array){
        if(array.length == 0 || array == null) {
            return 0;
        }
        if(array.length <= 2){
            return array[0];
        }

        int half = array.length / 2;
        int count = 1;
        Arrays.sort(array);
        for(int i = 1; i < array.length - 1; i++){
            if(array[i] != array[i - 1]){
                if(count > half){
                    return array[i - 1];
                }else {
                    count = 1;
                }
            } else {
                count ++;
            }
        }
        return 0;
    }

    // O(n)
    public int moreThanHalfNum1(int[] array){
        if(array.length == 0 || array == null) {
            return 0;
        }
        if(array.length <= 2){
            return array[0];
        }

        int middle = array.length / 2;
        int start = 0;
        int end = array.length - 1;
        int index = partition(array, start, end);
        while(index != middle){
            if(index > middle){
                end = index - 1;
                index = partition(array, start, end);
            }else {
                start = index + 1;
                index = partition(array, start, end);
            }
        }

        return array[middle];

    }

    public int partition(int[] array, int start, int end){


        int pivot = array[start + (end - start) / 2];
        int left = start;
        int right = end;
        while(left <= right){
            while(left <= right && array[left] <= pivot){
                left ++;
            }
            while(left <= right && array[right] >= pivot){
                right --;
            }

            if(left <= right){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left ++;
                right --;
            }
        }

        return left;

    }

}
