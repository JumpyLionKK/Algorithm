package com.lyn.learn.HuaWeiTestPractice;

import java.util.HashSet;
import java.util.Set;

public class PerfectNumber {
    public static int perfectNumber(int n){
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(check(i)){
                count++;
            }
        }
        return count;
    }

    public static boolean check(int m){
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for(int i = 1; i < m; i++){
            if(m % i == 0){
                if(!set.contains(i)){
                    sum += i;
                }else{
                    set.add(i);
                }

            }
        }
        return sum == m;
    }
}
