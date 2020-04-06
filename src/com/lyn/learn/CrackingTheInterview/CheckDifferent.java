/*
现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。

给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。
保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
 */
package com.lyn.learn.CrackingTheInterview;

public class CheckDifferent {
    public static boolean checkDifferent(String iniString){

        if(iniString.length() == 1){
            return true;
        }



        char target = iniString.charAt(0);
        String newStr = iniString.substring(1);
        for(Character c : newStr.toCharArray()){
            if(c == target){
                return false;
            }
        }

        return checkDifferent(newStr);

    }

    public static void main(String[] args){

        String str = "fbcdbea";

        System.out.println(checkDifferent(str));

    }

}
