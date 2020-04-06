/*
已知某小镇的房子沿直线分布，给定一个有序整型数组arr，里面的每个值代表小镇每栋房子的一维坐标点。
现在需要建N个广告牌，广告牌只能建在这些坐标点上，使得每个坐标点离广告牌的总距离最短，请返回这个最短的总距离
 */
package com.lyn.learn.HuaWeiTestPractice;

import java.util.Arrays;
import java.util.Scanner;

public class ChoseAdsPosition {
    // 1. 考虑只有一个广告牌的情况
    public static int findSmallestDistance(int count, int[] array){

        Arrays.sort(array);
        int sum = 0;
        int lastIndex = array.length - 1;
        while(count > 1){
            count --;
            lastIndex --;
        }
        int lastOne = lastIndex / 2;
        for(int i = 0; i < lastIndex; i++){
            sum += array[lastOne] - array[i];
        }
        return sum;
    }
    public static int charToNum(char s){
        return s - '0';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while (sc.hasNext()) {
            String s = sc.next();
            String[] charArray = s.split(" ");
            int[] array = new int[charArray.length - 1];
            for (int i = 0; i < charArray.length - 1; i++) {
                array[i] = charToNum(charArray[i].charAt(0));
            }
            int num = charToNum(charArray[charArray.length - 1].charAt(0));


            System.out.println(findSmallestDistance( num,array));
        }
    }

}
