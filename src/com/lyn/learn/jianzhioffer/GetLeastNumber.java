package com.lyn.learn.jianzhioffer;

import java.util.ArrayList;

public class GetLeastNumber {
    public static ArrayList<Integer> getLeastNumber(int[] input, int k){
        ArrayList<Integer> res = new ArrayList<>();

        if(input == null || input.length == 0 || k > input.length || k <=0){
            return res;
        }

        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        System.out.println(index);
        while(index != k - 1){

            if(index > k -1){
                end = index - 1;
                index = partition(input, start, end);
                System.out.println("zuo");
            }else {
                start = index + 1;
                System.out.println(start);
                System.out.println(end);
                index= partition(input, start, end);
                //System.out.println(index);
            }
        }

        for(int i = 0; i < k; i++){
            res.add(input[i]);
        }
        return res;


    }



    public static int partition(int[] input, int start, int end){

        int pivot = input[start + (end - start) / 2];
        //System.out.println(pivot);
        int left = start;
        int right = end;
        while(left < right){
            while(left < right && input[left] <= pivot){
                left ++;
                //System.out.println("left: " + left);
            }
            while(left < right && input[right] >= pivot){
                right --;
                //System.out.println("right: " + right);
            }

            if(left < right){
                int temp = input[left];
                input[left] = input[right];
                input[right] = temp;
                left ++;
                right --;
            }
        }
        int tmp = input[left];
        input[left] = pivot;
        input[start + (end - start) / 2] = tmp;
        return left;

    }

    public static void main(String[] args){
        int[] list = {4,5,1,6,2,7,3,8};
        System.out.print(getLeastNumber(list, 4));
    }
}
