/*
请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，
并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
 */
package com.lyn.learn.CrackingTheInterview;

public class ReplaceSpace {
    public String replaceSpace(String iniString, int length) {
        // write code here
        StringBuilder sb = new StringBuilder();
        for(Character c : iniString.toCharArray()){
            if(c != ' '){
                sb.append(c);
            }else{
                sb.append("%20");
            }
        }
        return sb.toString();


    }
}
