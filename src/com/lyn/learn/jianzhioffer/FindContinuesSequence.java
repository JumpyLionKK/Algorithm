package com.lyn.learn.jianzhioffer;

import java.util.ArrayList;

public class FindContinuesSequence {
    public ArrayList<ArrayList<Integer>> findContinuesSequence(int sum){

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = (int)Math.sqrt(2 * sum); i >= 2; i--){
            if(sum % i == 0 && i % 2 != 0 || (sum % i ) * 2 == i){
                ArrayList<Integer> lis = new ArrayList<>();
                for (int j = 0, k = (sum / i) - (i - 1) / 2; j < i; j++, k++) {
                    lis.add(k);
                }
                res.add(lis);
            }
        }
        return res;
    }
}
