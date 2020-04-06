package com.lyn.learn.jianzhioffer;

public class IsContinuous {
    public boolean isContinuous(int [] numbers){
        int[] array = new int[14];

        for(int i = 0; i < numbers.length; i++){
            array[numbers[i]] ++;
        }
        int min = 0;

        for(int j = 1; j < array.length; j++){
            if(array[j] > 0){
                min = j;
                break;
            }
        }
        int count = 0;
        for(int k = min; k < min + numbers.length; k++){
            if(array[k] == 0){
                count++;
            }
        }
        return array[0] >= count;

    }
}
