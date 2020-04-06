/*
给定两个字符串s1,s2,请返回bool值代表s2是否由s1旋转而成。字符串中字符为英文字母和空格，区分大小写，字符串长度小于等于1000。
 */
package com.lyn.learn.CrackingTheInterview;

public class CheckReverseEqual {
    public boolean checkReverseEqual(String s1, String s2){
        String str = s1 + s1;
        if(str.indexOf(s2) >= 0){
            return true;
        }
        return false;
    }
}
