package com.lyn.learn.HuaWeiTestPractice;

import java.util.ArrayList;

public class MarkNum {
    public String markNum(String str){

        char[] c = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        char prev = ' ';
        char next = ' ';
        for(int i = 0; i < c.length; i++){
            if(isNumber(c[i]) && !isNumber(prev) || !isNumber(c[i]) && isNumber(prev)){
                sb.append('*');
            }
            prev = c[i];
            sb.append(c[i]);

        }
        if(isNumber(sb.charAt(sb.length() - 1))){
            sb.append('*');
        }
        return sb.toString();




    }

    public boolean isNumber(char c){
        if(c <= '9' && c >= '0'){
            return true;
        }
        return false;
    }
}
