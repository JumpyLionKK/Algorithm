package com.lyn.learn.HuaWeiTestPractice;

public class ContinuesBit {
    public int continuesBit(int n){
        int count = 0;
        int max = Integer.MIN_VALUE;
        while(count != 0){
            if((n & 1) == 1){
                count++;
                max = Math.max(count, max);
            }else{
                count = 0;
            }
            n = n >> 1;
        }
        return max;
    }
}
