package com.lyn.learn.twoPointerAlgorithm;

import java.util.Arrays;

public class TriangleCount {
    public static int triangleCount(int[] S) {
        // write your code here
        if(S == null || S.length == 0){
            return 0;
        }
        Arrays.sort(S);
        int res = 0;
        for(int i = S.length - 1; i >= 2; i --){
            int l = 0;
            int r = i - 1;
            while(l < r){
                if(S[l] + S[r] > S[i]){
                    res += r - l;
                    r--;
                }else {
                    l ++;
                }
            }
        }

        return res;
    }
}
