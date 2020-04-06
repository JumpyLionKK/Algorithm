/*
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
 */
package com.lyn.learn.jianzhioffer;

public class LeftRotateString {
    public String leftRotateString(String str,int n){
        if(str == null || str.length() == 0){
            return "";
        }
        StringBuilder sb1 = new StringBuilder(str);
        String sb2 = sb1.substring(0,n);
        sb1 = sb1.delete(0,n).append(sb2);
        return sb1.toString();

    }
}
