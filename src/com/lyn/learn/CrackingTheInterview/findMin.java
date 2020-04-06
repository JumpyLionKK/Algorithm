package com.lyn.learn.CrackingTheInterview;

import java.util.Scanner;

public class findMin {

    public static int findMin(int maxKm, int vallageNum, int[] distance){

        int curNum = 0;
        int len = distance.length;
        int count = 0;
        for(int i = 0; i < len; i++){
            curNum += distance[i];
            if(curNum > maxKm){
                count ++;
                curNum = distance[i];
            }
        }
        return count;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int maxKm = sc.nextInt();
            int vallageNum = sc.nextInt();
            int[] distance = new int[vallageNum  + 1];
            for(int i = 0; i < distance.length; i++){
                distance[i] = sc.nextInt();
                if(distance[i] > maxKm){
                    System.out.println(0);
                    return;
                }
            }
            System.out.println(findMin(maxKm, vallageNum, distance));
        }
    }
}
