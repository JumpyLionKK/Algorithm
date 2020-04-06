package com.lyn.learn.CrackingTheInterview;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ClearZero {

    public static int[][] clearzero(int[][] mat, int n){

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    map.put(i, j);
                }
            }
        }

        Set<Integer> set = map.keySet();
        for(Integer num : set){
            for(int i = 0; i < n; i++){
                mat[num][i] = 0;
                mat[i][map.get(num)] = 0;
            }
        }
        return mat;
    }

    public static void main(String[] args){
        int[][] mat = {{1,2,3},{0,1,2},{0,0,1}};
        int[][] res = clearzero(mat, 3);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.println(res[i][j]);
            }
        }

    }
}
