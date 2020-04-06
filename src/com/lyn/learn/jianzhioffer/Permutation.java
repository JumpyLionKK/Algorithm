package com.lyn.learn.jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;

public class Permutation {
    public ArrayList<String> permutation(String str){
        if(str == null){
            return null;
        }

        ArrayList<String> list = new ArrayList<>();
        char[] pStr = str.toCharArray();

        permutationHelper(list, 0, pStr);
        Collections.sort(list);
        return list;

    }

    private void permutationHelper(ArrayList<String> list, int i, char[] str) {
        if(str == null){
            return;
        }

        if(i == str.length - 1){
            if(list.contains(String.valueOf(str))){
                return;
            }else {
                list.add(String.valueOf(str));
            }
        }else {
            for(int j = i; j < str.length; j++){
                char temp = str[j];
                str[j] = str[i];
                str[i] = temp;
                permutationHelper(list, i + 1, str);
                temp = str[j];
                str[j] = str[i];
                str[i] = temp;

            }

        }
    }


}
