/*
题目描述
计算最少出列多少位同学，使得剩下的同学排成合唱队形

说明：
N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK,
则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 */
package com.lyn.learn.HuaWeiTestPractice;

import java.util.ArrayList;
import java.util.Scanner;

public class ChorusProblem {

    public int chrusProblem(int[] heights){
        // 1. 先正向求出每个数在最大排列的子串中的位置
        int[] incSub = new int[heights.length];
        for(int i = 0; i < incSub.length; i++){
            incSub[i] = 1;
        }
        for(int i = 1; i < heights.length; i++){
            for(int j = i - 1; j >= 0; j--){
                if(heights[j] < heights[i] && incSub[i] < incSub[j] + 1){
                    incSub[i] = incSub[j] + 1;
                }
            }
        }

        // 2.再反向求出每个数在最大排列的子串中的位置
        int[] decSub = new int[heights.length];
        int[] reversedHeights = new int[heights.length];
        for(int i = 0; i < decSub.length; i++){
            decSub[i] = 1;
        }
        for(int i = 0; i < decSub.length; i++){
            reversedHeights[i] = heights[heights.length - 1 - i];
        }
        for(int i = 1; i < reversedHeights.length; i++){
            for(int j = i - 1; j >=0; j--){
                if(reversedHeights[j] < reversedHeights[i] && decSub[i] < decSub[j] + 1){
                    decSub[i] = decSub[j] + 1;
                }
            }
        }

        // 3.合并正反两个子串位置,记录最大数
        int max = 0;
        int[] merge = new int[heights.length];
        for(int i = 0; i < heights.length; i++){
            merge[i] = incSub[i] + decSub[heights.length - 1 - i];
            max = Math.max(max, merge[i]);
        }

        return heights.length - max + 1;

    }

    public static void main(String[] args){
        ChorusProblem chorusProblem = new ChorusProblem();
        int[] array = {186,186,150,200,160,130,197,200};
        System.out.println(chorusProblem.chrusProblem(array));

    }
}
