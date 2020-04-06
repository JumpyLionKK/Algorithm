package com.lyn.learn.unsolvedProblemsDuringInterview;

import java.util.Scanner;

public class FindApple {
    public static int[] findApple(int n, int[] appleNumInEach, int[] query){

        int[] sum = new int[n + 1];
        sum[0] = 0;
        int[] res = new int[query.length];

        for(int i = 1; i < n + 1; i++){
            sum[i] = sum[i - 1] + appleNumInEach[i - 1];
        }

//        for(int i = 0; i < query.length; i++){
//            for(int j = 0; j < sum.length; j++){
//                 if(j == sum.length - 1){
//                    res[i] = j;
//                    break;
//                 }else if(sum[j] <= query[i] && sum[j + 1] > query[i]){
//                    res[i] = j + 1;
//                    break;
//                }
//            }
//        }
        for(int i = 0; i < query.length; i++){
            res[i] = binarySearch(query[i], sum, 0, sum.length - 1) + 1;
        }
        return res;
    }

    public static int binarySearch(int target, int[] sum, int start, int end){




        int res = 0;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(sum[mid] < target){
                start = mid;
                //binarySearch(target, sum, start, end);
            }else{
                end = mid;
                //binarySearch(target, sum, start, end);
            }

        }
        if(sum[start] < target){
            return start;
        }
        return end;


    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] appleNumInEach = new int[n];
            for(int i = 0; i < n; i++){
                appleNumInEach[i] = sc.nextInt();
            }
            int queryNum = sc.nextInt();
            int[] query = new int[queryNum];
            for(int i = 0; i < queryNum; i++){
                query[i] = sc.nextInt();
            }

            int[] res = findApple(n, appleNumInEach, query);
            for(int c : res){
                System.out.println(c);
            }


        }
    }


}
