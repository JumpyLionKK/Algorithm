/*
给定一串字符，里面有些字符有连续出现的特点，请寻找这些连续出现字符中最长的串，如果最长的字串有多个，请输出字符ASCII码最小的那一串。
 */
package com.lyn.learn.HuaWeiTestPractice;

public class FindLongestContinues {

    public static String findLongestContinues(String str){

        int[] res = new int[256];
        char[] list = str.toCharArray();
        for(int i = 0; i < list.length; i++){
            int startIndex = i;
            while(i < list.length - 1 && list[i] == list[i + 1]){
                i ++;
            }
            res[list[startIndex]] = list[i] == list[startIndex] ? i - startIndex + 1 : i - startIndex;

        }
        int max = 0;
        for(int i = 0; i < 256; i++){
            max = Math.max(max, res[i]);
        }
        char target = ' ';
        for(int i = 0; i < 256; i++){
            if(res[i] == max){
                target = (char) i;
                break;
            }
        }
        String result = "";
        for(int i = 0; i < max; i++){
            result += target;
        }
        return result;
    }

    public static void main(String[] args){
        String s = "aaabbbbbccccccczzzzzzzzz";
        System.out.println(findLongestContinues(s));

    }
}
