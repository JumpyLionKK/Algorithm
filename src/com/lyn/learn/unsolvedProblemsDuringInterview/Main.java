/*
华老师的n个学生参加了一次模拟测验，考出来的分数很糟糕，但是华老师可以将成绩修改为[0,100]中的任意值，
所以他想知道，如果要使所有人的成绩的平均分不少于X分，至少要改动多少个人的分数？
 */
package com.lyn.learn.unsolvedProblemsDuringInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int scoreNeedToChange(int x, int[] score, int len){

        int averageSum = 0;
        Arrays.sort(score);
        for(int i = 0; i < len; i++){
            averageSum += score[i] - x;
        }

        int count = 0;
        if(averageSum < 0){
            for(int i = 0; i < len; i++){
                averageSum += 100 - score[i];
                count++;
                if(averageSum >= 0){
                    return count;
                }
            }
        }
        return len;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        int[] len = new int[testNum];
        int[] average = new int[testNum];
        List<int[]> scores = new ArrayList<>();
        for(int j = 0; j < testNum; j++) {
            len[j] = sc.nextInt();
            average[j] = sc.nextInt();
            scores.add(new int[len[j]]);
            for (int i = 0; i < len[j]; i++) {
                scores.get(j)[i] = sc.nextInt();
            }
        }

        for(int k = 0; k<testNum; k++){
            System.out.println(scoreNeedToChange(average[k], scores.get(k), len[k]));
        }
    }
}
