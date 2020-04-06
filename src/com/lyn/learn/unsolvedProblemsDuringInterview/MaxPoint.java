package com.lyn.learn.unsolvedProblemsDuringInterview;

public class MaxPoint {
    public static int maxPoint(int[] point, int[] isWeaken, int k){

        if(point.length != isWeaken.length){
            return 0;
        }
        int len = point.length;
        int maxPoint = 0;
        int res = 0;
        for(int i = 0; i < len; i++){
            if(isWeaken[i] == 0){
                int count = 0;
                int[] temp = isWeaken.clone();
                while(count < k && count + i < len){
                    temp[count + i] = 1;
                    count++;
                }
                maxPoint = getTotalPoint(point, temp);
            }
            res = Math.max(res, maxPoint);
        }
        return res;
    }

    public static int getTotalPoint(int[] point, int[] isWeaken){

        int sum = 0;
        for(int i = 0; i < point.length; i++){
            sum += point[i] * isWeaken[i];
        }
        return sum;
    }

    public static void main(String[] args){
        int[] point = {1,2,3,4,5,6,7};
        int[] isWeaken = {1,0,0,0,1,0,0};
        System.out.println(maxPoint(point, isWeaken, 3));
    }
}
